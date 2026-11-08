#!/usr/bin/env python3
"""Fetch camoufox browser without GitHub API (bypasses api.github.com rate limit).

Synthesizes the release JSON for the library-pinned browser tag using the
direct release-asset URL, patches camoufox.pkgman.github_api, then runs the
official CamoufoxFetcher().install() so the on-disk layout stays canonical.
"""
import sys

PIN_TAG = "v158.0.1-beta.41"
PIN_REPO = "daijro/camoufox"
ASSET = "camoufox-158.0.1-beta.41-lin.x86_64.zip"
URL = f"https://github.com/{PIN_REPO}/releases/download/{PIN_TAG}/{ASSET}"


def main() -> int:
    import camoufox.pkgman as pm

    def fake_github_api(path: str):
        if path.startswith("repos/") and path.endswith("/releases"):
            repo = path[len("repos/"): -len("/releases")]
            if repo in ("daijro/camoufox", "camoufox/camoufox"):
                return [{
                    "tag_name": PIN_TAG,
                    "prerelease": True,
                    "assets": [{
                        "name": ASSET,
                        "browser_download_url": URL,
                        "id": 0,
                        "size": 0,
                        "updated_at": "",
                        "created_at": "",
                    }],
                }]
        raise RuntimeError(f"unexpected github_api call: {path}")

    pm.github_api = fake_github_api

    from camoufox.pkgman import CamoufoxFetcher
    fetcher = CamoufoxFetcher()
    print(f"resolved: {fetcher.version}-{fetcher.build} from {fetcher.github_repo}")
    fetcher.install()
    print("installed at:", pm.camoufox_path())
    return 0


if __name__ == "__main__":
    sys.exit(main())
