# App Intelligence report — FluffyChat Matrix Messenger (chat.fluffy.fluffychat)

- Version analyzed: 2.11.4 (3576)
- Acquired: 197.8 MB, sha256 `b5b4f8e1e94a35c2b5f958ef5d5ec0cd5a630570516b8e076d3db66203289d4a`, originality: unknown
- Generated: 2026-11-09T21:58:56.078Z



---

(from store-listing.md)

# Store listing — FluffyChat Matrix Messenger (chat.fluffy.fluffychat)

- Developer: Krille
- Genre: Social | Content rating: Mature 17+
- Installs: 100,000+ | Rating: 4.07 (952 ratings)
- Current version: 2.11.5 (Android 7.0)
- Released: Sep 17, 2020 | Updated: +058818-05
- Screenshots: 12

## Description

Messaging how it should be!
Whether for your friends, your company or local community, FluffyChat supports a variety of features to cover all your daily needs.

Easy to use!
Simply install, log in and start chatting. The intuitive user interface makes secure communication as easy as possible.

Secure!
With olm/megolm end-to-end encryption, encrypted message backups and an automated key trust system, FluffyChat is among the most secure messengers available.

Decentral!
Based on the open Matrix protocol we build a decentralized messaging network together, which no entity can control. Host your own chat server while remaining in contact with everyone.

Feature rich and reliable!
From public chats with tens of thousands of participants and polls to custom stickers, spaces, rich moderation tools, and multi-device support, FluffyChat delivers a comprehensive communication suite.

Secure video calls!
Direct calls and video conferences, fully secured with Matrix RTC-compatible encryption.

Not another walled garden!
We do not build another walled garden! FluffyChat is fully compatible with any other Matrix client like Element, Nheko, Cinny or NeoChat. Learn more at matrix.org.

Made by volunteers!
FluffyChat is a non-profit project based on open standards and driven entirely by volunteers. Infrastructure is funded by donations, and participation is open to everyone.


---

(from permissions-and-security.md)

# Permissions & security — chat.fluffy.fluffychat

## Permissions (14)

- `android.permission.INTERNET`
- `android.permission.ACCESS_NETWORK_STATE`
- `android.permission.CAMERA`
- `android.permission.RECORD_AUDIO`
- `android.permission.POST_NOTIFICATIONS`
- `android.permission.READ_EXTERNAL_STORAGE`
- `android.permission.WRITE_EXTERNAL_STORAGE`
- `android.permission.VIBRATE`
- `android.permission.USE_BIOMETRIC`
- `android.permission.USE_FINGERPRINT`
- `android.permission.FOREGROUND_SERVICE`
- `android.permission.RECEIVE_BOOT_COMPLETED`
- `android.permission.WAKE_LOCK`
- `android.permission.READ_CONTACTS`

## Signature
- Present: unknown | status: signed | scheme: v2
- Certificate: CN=FluffyChat (F-Droid release)
- Provider marks this file as **sourced from Google Play**: no

## VirusTotal
- Verdict: clean

## Manifest
- targetSdk 35 | compileSdk 35

## Versions tracked by the provider (1)
- 2.11.4 (3576) — latest — sha256 b5b4f8e1e94a35c2…

## Native / protectors
- ABIs: arm64-v8a, armeabi-v7a, x86_64
- Native libs: libflutter.so, libapp.so, libolm.so, libmatrix_jni.so
- Protectors: none detected


---

(from original-apk.md)

# Original APK acquisition — chat.fluffy.fluffychat

- Acquired: 197812116 bytes (197.81 MB), 1 bundle entries
- Version: 2.11.4 (3576)
- sha256: `b5b4f8e1e94a35c2b5f958ef5d5ec0cd5a630570516b8e076d3db66203289d4a`
- Originality vs provider listing: **unknown**

Acquired through the reverse-engineered provider chain (hold-to-verify + turnstile + proof-of-work),
the same pipeline the public APK-downloader services use to fetch originals from Google Play.


---

(from tech-stack.md)

# Tech stack — chat.fluffy.fluffychat

- **Flutter (Dart AOT)** — libflutter.so + libapp.so with Dart package strings (high)

## Native libraries
- `libImaging.so`
- `libapp.so`
- `libdartjni.so`
- `libdatastore_shared_counter.so`
- `libflutter.so`
- `libjingle_peerconnection_so.so`
- `libnoise.so`
- `libsqlcipher.so`
- `libvodozemac_bindings_dart.so`
- `libwebcrypto.so`

## Dart packages (top 30 of 60)
- flutter ×424
- fluffychat ×280
- image ×197
- highlight ×197
- material_ui ×157
- lottie ×157
- matrix ×122
- livekit_client ×87
- flutter_map ×52
- markdown ×47
- archive ×46
- emoji_picker_flutter ×33
- cupertino_ui ×30
- chewie ×29
- material_color_utilities ×27
- flutter_rust_bridge ×23
- xml ×23
- flutter_webrtc ×23
- sqflite_common ×23
- pretty_qr_code ×23
- dbus ×22
- protobuf ×22
- webrtc_interface ×21
- flutter_local_notifications ×20
- particles_network ×18
- go_router ×18
- flutter_foreground_task ×18
- rxdart ×17
- sqlite3 ×16
- intl ×16


---

(from feature-map.md)

# Feature map — chat.fluffy.fluffychat

Mapped from package fingerprints in the compiled app (ref count = string occurrences):

- QR codes — `pretty_qr_code` ×23
- local notifications — `flutter_local_notifications` ×20
- localization/dates — `intl` ×16
- HTTP client — `http` ×16
- encrypted storage — `flutter_secure_storage` ×7
- audio recording — `record` ×6
- state management — `provider` ×5
- external links — `url_launcher` ×4


---

(from code-map.md)

# Code map — chat.fluffy.fluffychat

- Decompiled Java/Kotlin files: 4649

## Top-level packages
- `com` — 592 files
- `androidx` — 235 files
- `org` — 228 files
- `io` — 133 files
- `W5` — 88 files
- `Z` — 86 files
- `q` — 60 files
- `J0` — 59 files
- `k3` — 59 files
- `M` — 54 files
- `I0` — 54 files
- `g1` — 44 files

## Non-SDK endpoints (20)
- https://spec.matrix.org/latest/rooms
- https://fluffychat.im
- https://microg.org
- https://unifiedpush.org
- https://ko-fi.com/post
- https://fluffychat.im/privacyapplication
- https://fluffychat.im/tosapplication
- https://www.openstreetmap.org
- https://github.com/krille-chan/fluffychatck
- https://matrix.to
- https://matrix.gateway.unifiedpush.org/_matrix/push/v1
- https://aomediacodec.github.io/av1-rtp-spec
- https://fluffychat.imp
- http://www.ibm.com/data/dtd/v11/ibmxhtml1-transitional.dtds3m
- https://github.com/dart-lang/language/issues/3488
- https://push.fluffychat.im/_matrix/push/v1/notifyv
- https://fluffychat.im/assets/favicon.pngdier
- https://github.com/flutter/flutter/issues/30701
- https://pub.dev
- https://fluffychat.im/changelog


---

(from endpoints-and-sync.md)

# Endpoints & synchronization — chat.fluffy.fluffychat

Every URL recovered from the compiled app, classified with its purpose.
Framework noise (engine licenses, DTDs, registry links) is separated from real app endpoints.

## Endpoints (31)

| Kind | URL | Purpose | Evidence |
| --- | --- | --- | --- |
| asset-cdn | https://fluffychat.im/assets/favicon.pngdier | developer's own file/upload CDN — where user content and media are stored | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im | developer's website root (about/support/landing page) | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im/privacy | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im/tosapplication | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| app-site | https://push.fluffychat.im/_matrix/push/v1/notifyv | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im/changelog | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| review | http://javax.xml.XMLConstants/feature/secure-processing | possible app resource — verify against decompiled call sites before treating as a backend | sources/com/fasterxml/jackson/databind/ext/DOMDeserializer.java |
| review | http://apache.org/xml/features/disallow-doctype-decl | possible app resource — verify against decompiled call sites before treating as a backend | sources/com/fasterxml/jackson/databind/ext/DOMDeserializer.java |
| review | https://matrix.to/# | possible app resource — verify against decompiled call sites before treating as a backend | libapp.so (Dart AOT string table) |
| review | https://aomediacodec.github.io/av1-rtp-spec | possible app resource — verify against decompiled call sites before treating as a backend | libapp.so (Dart AOT string table) |
| review | https://fluffychat.imp | possible app resource — verify against decompiled call sites before treating as a backend | libapp.so (Dart AOT string table) |
| social | https://ko-fi.com/post | donation/support page (fundraising link, not a runtime integration) | libapp.so (Dart AOT string table) |
| social | https://github.com/krille-chan/fluffychat | developer repository link (about/support page) | libapp.so (Dart AOT string table) |
| docs | https://spec.matrix.org/latest/rooms | Matrix protocol specification reference (the app speaks the Matrix protocol) | libapp.so (Dart AOT string table) |
| docs | https://microg.org/ | microG integration reference (FOSS Google-services replacement) | libapp.so (Dart AOT string table) |
| docs | https://unifiedpush.org/ | UnifiedPush integration reference (FOSS push notifications) | libapp.so (Dart AOT string table) |
| docs | https://developer.android.com/guide/components | Android developer documentation reference | libapp.so (Dart AOT string table) |
| docs | https://www.openstreetmap.org/?mlat=Yx | OpenStreetMap map/location link (geo feature) | libapp.so (Dart AOT string table) |
| docs | https://matrix.gateway.unifiedpush.org/_matrix/push/v1 | UnifiedPush integration reference (FOSS push notifications) | libapp.so (Dart AOT string table) |
| docs | https://docs.flutter.dev/release/breaking-changes | Flutter documentation reference | libapp.so (Dart AOT string table) |
| docs | https://unifiedpush.org/.#sink# | UnifiedPush integration reference (FOSS push notifications) | libapp.so (Dart AOT string table) |
| framework-noise | http://www.w3.org/2000 | W3C DTD/XML-schema namespace referenced by XML parsers — parser boilerplate | libapp.so (Dart AOT string table) |
| framework-noise | http://www.w3.org/1999/xhtml | W3C DTD/XML-schema namespace referenced by XML parsers — parser boilerplate | libapp.so (Dart AOT string table) |
| framework-noise | https://api.flutter.dev/flutter/dart-ui | Flutter framework documentation link (engine/ LICENSE or about strings) | libapp.so (Dart AOT string table) |
| framework-noise | http://www.w3.org | W3C DTD/XML-schema namespace referenced by XML parsers — parser boilerplate | libapp.so (Dart AOT string table) |
| framework-noise | http://www.ibm.com/data/dtd/v11 | XHTML transitional DTD fallback bundled inside XML parser stacks — parser boilerplate, never fetched | libapp.so (Dart AOT string table) |
| framework-noise | https://github.com/dart-lang/language/issues/3488 | framework/engine repository link from bundled license text — not app code | libapp.so (Dart AOT string table) |
| framework-noise | https://github.com/flutter/flutter/issues/30701 | framework/engine repository link from bundled license text — not app code | libapp.so (Dart AOT string table) |
| framework-noise | http://www.w3.org/1998 | W3C DTD/XML-schema namespace referenced by XML parsers — parser boilerplate | libapp.so (Dart AOT string table) |
| framework-noise | https://pub.dev/ | Dart package registry — dependency metadata baked into the release build, not a runtime call | libapp.so (Dart AOT string table) |
| framework-noise | http://schemas.android.com/apk/res/android | Android manifest XML namespace — static manifest reference | sources/N/k.java |

## How sync works (offline / online)

Offline-capable: local SQLite database (Flutter sqflite) holds data locally; network reachability checks (drives online/offline switching) drives when sync happens; local notifications announce events while backgrounded. Read paths hit local storage first; writes queue and flush to the REST backend when a connection is available.

### Signals
- **package:flutter_local_notifications_windows** — local notifications (realtime/push)
- **package:sqflite_common_ffi** — local SQLite database (Flutter sqflite) (offline storage)
- **package:connectivity_plus** — network reachability checks (drives online/offline switching) (sync orchestration)
- **package:flutter_local_notifications** — local notifications (realtime/push)
- **package:sqflite_common** — local SQLite database (Flutter sqflite) (offline storage)
- **package:flutter_local_notifications_platform_interface** — local notifications (realtime/push)
- **package:sqlite3** — SQLite native bindings (offline storage)
- **package:shared_preferences** — key-value preferences store (offline storage)
- **package:flutter_secure_storage** — encrypted key-value store (Keystore-backed) (offline storage / token storage)
- **package:flutter_local_notifications_linux** — local notifications (realtime/push)
- **package:http** — Dart http client (api client)
- **WorkManager (×1 refs)** — WorkManager background jobs (deferred sync queues) (sync orchestration)

### Realtime channels: local notifications


---

(from database-schema.md)

# Local database — chat.fluffy.fluffychat

## Storage engines
- **local SQLite database (Flutter sqflite)** (package:sqflite_common in libapp.so)
- **encrypted key-value store (Keystore-backed)** (package:flutter_secure_storage in libapp.so)
- **local SQLite database (Flutter sqflite)** (package:sqflite_common_ffi in libapp.so)
- **SQLite native bindings** (package:sqlite3 in libapp.so)
- **key-value preferences store** (package:shared_preferences in libapp.so)

_No CREATE TABLE statements recovered — schema is likely created at runtime or lives server-side._

## SQL evidence (verbatim, truncated)
- `SELECT END CALL ABORT CLEAR CHANNEL FACTOR LIST NUMBER OVERRIDE SET WEEK DISTRIBUTIONNODE ELSE WHEN THEN OTHERWISE IENUM CSV INCLUDE LEAVE RIDER SAVE DELETE NOV`
- `select set skip startsas stop title update waitsas where window x systask add and alter as cascade check create delete describe distinct drop foreign from group`
- `insert into in`
- `SELECT COUNT(*) FROM sqlite_master`
- `INSERT INTO WebPInfoContextAction`
- `Select push distributor8in if for while finally new do return else break catch instanceof throw try this switch continue typeof delete debugger super yield impo`
- `DELETE FROM clubs`
- `insert into replace`
- `delete from into`


---

(from api-surface.md)

# API surface — chat.fluffy.fluffychat

## HTTP clients: package:http_parser, package:http
## API base URLs: none detected
## Auth: biometric / device-credential unlock (package:local_auth present); encrypted token storage (package:flutter_secure_storage present)

## Recovered API paths (6)
- `/client/v3/pushers/setVoc`
- `/settings`
- `/config`
- `/backup`
- `/login`
- `/v1`

## Model classes (30)
- StreamedRequest
- HTTPRequest
- AddTrackRequest
- StoreDataBlobResponse
- QuitarTrackPublishedResponse
- VGrTrickleRequest
- PublishDataTrackResponse
- SignalRequest
- GertStreamedRequest
- RpcResponse
- FfiMethodResponse
- InitRequest
- KeyManagerKeyShareRequest
- GetSpaceHierarchyResponse
- SENDTO
- AffineStateSpaceModel
- BesselFilterModel
- BiquadraticFilterModel
- ButterworthFilterModel
- Chebyshev1FilterModel
- Chebyshev2FilterModel
- CoxModel
- CreateDataSystemModel
- CreateSystemModel
- DualSystemsModel
- EllipticFilterModel
- FittedModel
- FromEntity
- GenerateHTTPResponse
- GeoModel

## Screens / views (30)
- DataView
- RenderView
- MannsetPromptRectRangePageView
- SettingsStyleView
- AboutDialog
- ShirtblackMountainView
- VideoView
- LicensePage
- EmltsSettingsSecurityView
- CustomTransitionPage
- ListView
- SettingsChatView
- RestoreBootstrapView
- RenderAndroidView
- AuthenticationDialog
- ChoiceDialog
- CreateDialog
- ExitDialog
- FlipView
- FormPage
- GalleryView
- HomePage
- MenuView
- MessageDialog
- OpenerView
- PopupView
- SlideView
- TableView
- TabView
- TraceDialog

## Modules (40)
- SerializerProvider
- ClassUtil
- DeserializationProblemHandler
- KeyManager
- NullValueProvider
- SqfliteFfiMethodCallHandler
- VersionUtil
- NullsConstantProvider
- SimpleFilterProvider
- TextInputClient
- VideoPlayerInstanceApi
- ThreadLocalBufferManager
- SharedPreferencesApi
- PlatformConfigurationNativeApi
- FilterProvider
- JsonParserDelegate
- AndroidVideoPlayerApi
- FileSystemProvider
- ISO8601Utils
- PushHelper
- TextSelectionDelegate
- RTCVideoPlatformController
- DataView
- OlmManager
- LocalAuthApi
- BeanUtil
- RmiProvider
- JsonGeneratorDelegate
- StreamedRequest
- ImagePickerApi
- UrlLauncherApi
- QRViewController
- PointerUtils
- RadioClient
- HttpClient
- StatefulWidget
- RenderView
- RouteInformationProvider
- FileHandler
- HTTPRequest


---

(from clone-pack/overview.md)

# FluffyChat Matrix Messenger

A secure, decentralized messaging app based on the Matrix protocol.

- **Purpose**: End-to-end encrypted messaging, video calls, and community chats
- **Target Audience**: Privacy-conscious users and communities
- **Key Differentiators**: Decentralized architecture, Matrix protocol compatibility, open-source
- **Platform**: Flutter (Dart) for cross-platform support
- **Security**: End-to-end encryption (olm/megolm), encrypted backups
- **Infrastructure**: Self-hostable with compatibility across Matrix clients

FluffyChat provides secure messaging how it should be.


---

(from clone-pack/features.md)

# Feature Set

- **Messaging**: Text, media sharing, stickers, polls
- **Video Calls**: Encrypted direct calls and conferences
- **Security**: End-to-end encryption, key trust system, biometric unlock
- **Decentralization**: Matrix protocol compatibility with self-hosting options
- **Multi-device Support**: Synchronized across devices
- **Moderation Tools**: For community and group management
- **Spaces**: Organized chat spaces
- **Push Notifications**: Local and unified push support
- **Location Sharing**: Integration with OpenStreetMap
- **Cross-client Compatibility**: Works with other Matrix clients

All features are built on the open Matrix protocol for true interoperability.


---

(from clone-pack/architecture.md)

# Technical Architecture

- **Frontend**: Flutter (Dart) with Provider for state management
- **Storage**: SQLite (sqflite) for local database, flutter_secure_storage for encrypted data
- **Networking**: HTTP client for Matrix API calls, UnifiedPush for notifications
- **Authentication**: Biometric/device credentials with encrypted token storage
- **Modules**: OlmManager for encryption, PushHelper for notifications, VideoPlayer for calls
- **Data Flow**: UI → Provider → SQLite/Secure Storage → HTTP API → Matrix homeserver
- **Background Processing**: WorkManager for deferred sync operations
- **Platform Integration**: Native Android APIs for camera, contacts, notifications

The architecture prioritizes security and decentralization while maintaining a responsive user experience.


---

(from clone-pack/endpoints-analysis.md)

# API Endpoint Analysis

**Matrix Protocol Endpoints**:
- `https://spec.matrix.org/latest/rooms` - Matrix protocol specification reference
- `https://matrix.to` - Matrix deep linking protocol
- `https://matrix.gateway.unifiedpush.org/_matrix/push/v1` - UnifiedPush gateway for notifications

**FluffyChat Backend**:
- `https://fluffychat.im` - Main backend origin for API calls
- `https://fluffychat.im/privacy` - Privacy policy endpoint
- `https://fluffychat.im/tosapplication` - Terms of service endpoint
- `https://push.fluffychat.im/_matrix/push/v1/notifyv` - Push notification endpoint
- `https://fluffychat.im/changelog` - App changelog endpoint
- `https://fluffychat.im/assets/favicon.pngdier` - Asset CDN for media and uploads

**Third-Party Services**:
- `https://microg.org` - microG integration (Google services replacement)
- `https://unifiedpush.org` - UnifiedPush documentation
- `https://www.openstreetmap.org` - Map/location services
- `https://ko-fi.com/post` - Donation/support page
- `https://github.com/krille-chan/fluffychat` - Developer repository

**Framework Noise**:
- Various W3C DTDs and XML namespaces (parser boilerplate)
- Flutter and Dart documentation links
- Package registry references (pub.dev)

The app primarily communicates with Matrix homeservers and uses FluffyChat's own backend for push notifications and assets.


---

(from clone-pack/data-sync.md)

# Data Synchronization Strategy

- **Local Storage**: SQLite database (sqflite) for message history and metadata
- **Encrypted Storage**: flutter_secure_storage for authentication tokens and sensitive data
- **Preferences**: shared_preferences for app settings
- **Sync Triggers**: Network connectivity checks (connectivity_plus) drive online/offline switching
- **Background Sync**: WorkManager handles deferred sync operations when connection is available
- **Push Notifications**: flutter_local_notifications for real-time updates
- **Conflict Resolution**: Not explicitly detailed in evidence - Matrix protocol typically handles this at the server level

The app is designed to work offline, with local storage as the primary data source. Changes are queued and synchronized when connectivity is restored. The Matrix protocol handles cross-device synchronization at the server level.


---

(from clone-pack/api-contract.md)

# Reconstructed API Contract

**Base URL**: `https://fluffychat.im` (primary backend)

**Authentication**:
- Method: Token-based with encrypted storage
- Endpoints: `/login` (POST)
- Security: Biometric/device credential unlock

**Core Endpoints**:
- `/client/v3/pushers/setVoc` (POST) - Configure push notifications
- `/settings` (GET/POST) - Retrieve/update app settings
- `/config` (GET) - Get server configuration
- `/backup` (GET/POST) - Handle encrypted message backups
- `/v1` (GET/POST) - General API endpoint (likely Matrix protocol)

**Matrix Protocol Compliance**:
- Follows Matrix homeserver API specification
- Uses standard Matrix endpoints for messaging, rooms, and user data
- Implements Matrix encryption (olm/megolm)

**Data Models**:
- Message objects with encryption metadata
- User and room information
- Push notification configuration
- Backup and key management data

The API contract is Matrix-compliant with FluffyChat-specific extensions for push notifications and settings.


---

(from clone-pack/clone-plan.md)

# Clone Implementation Plan

**Phase 1: Backend Foundation (4-6 weeks)**
- Set up Matrix homeserver compatibility (Synapse or Dendrite)
- Implement core Matrix API endpoints (auth, messaging, rooms)
- Create push notification service (FluffyChat-compatible)
- Develop media upload/download CDN
- Implement encryption (olm/megolm) handling

**Phase 2: Data Layer (3-4 weeks)**
- SQLite schema design for local storage
- Encrypted storage implementation for tokens and keys
- Sync queue system for offline operations
- Conflict resolution mechanisms
- Migration and backup systems

**Phase 3: Core Features (6-8 weeks)**
- Authentication and security (biometric unlock)
- Messaging functionality (text, media, stickers)
- Room and space management
- Push notification system (UnifiedPush integration)
- Video call implementation (Matrix RTC)

**Phase 4: Advanced Features (4-6 weeks)**
- Polls and reactions
- Location sharing (OpenStreetMap integration)
- Moderation tools
- Multi-device synchronization
- Cross-client compatibility testing

**Total Estimated Effort**: 17-24 weeks

Prioritize Matrix protocol compliance and security features first, then build out additional functionality.