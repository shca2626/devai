# App Intelligence report — FluffyChat Matrix Messenger (chat.fluffy.fluffychat)

- Version analyzed: 2.11.5 (3578)
- Acquired: 199.7 MB, sha256 `a40f3876ec60adec4eb44ee91467b3094708dca0d4a38bb97b725a13367bd833`, originality: unknown
- Generated: 2026-11-14T18:50:33.577Z



---

(from store-listing.md)

# Store listing — FluffyChat Matrix Messenger (chat.fluffy.fluffychat)

- Developer: Krille
- Genre: Social | Content rating: Mature 17+
- Installs: 100,000+ | Rating: 4.07 (957 ratings)
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

## Permissions (45)

- `android.permission.ACCESS_COARSE_LOCATION`
- `android.permission.ACCESS_FINE_LOCATION`
- `android.permission.ACCESS_NETWORK_STATE`
- `android.permission.ACCESS_NOTIFICATION_POLICY`
- `android.permission.BLUETOOTH`
- `android.permission.CAMERA`
- `android.permission.DISABLE_KEYGUARD`
- `android.permission.FOREGROUND_SERVICE`
- `android.permission.FOREGROUND_SERVICE_CAMERA`
- `android.permission.FOREGROUND_SERVICE_DATA_SYNC`
- `android.permission.FOREGROUND_SERVICE_MICROPHONE`
- `android.permission.FOREGROUND_SERVICE_PHONE_CALL`
- `android.permission.FOREGROUND_SERVICE_SHORT_SERVICE`
- `android.permission.INTERNET`
- `android.permission.MANAGE_OWN_CALLS`
- `android.permission.MODIFY_AUDIO_SETTINGS`
- `android.permission.POST_NOTIFICATIONS`
- `android.permission.READ_APP_BADGE`
- `android.permission.READ_EXTERNAL_STORAGE`
- `android.permission.RECEIVE_BOOT_COMPLETED`
- `android.permission.RECORD_AUDIO`
- `android.permission.TURN_SCREEN_ON`
- `android.permission.USE_BIOMETRIC`
- `android.permission.USE_FINGERPRINT`
- `android.permission.USE_FULL_SCREEN_INTENT`
- `android.permission.VIBRATE`
- `android.permission.WAKE_LOCK`
- `android.permission.WRITE_EXTERNAL_STORAGE`
- `chat.fluffy.fluffychat.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`
- `chat.fluffy.fluffychat.PERMISSION_CALL`
- `com.anddoes.launcher.permission.UPDATE_COUNT`
- `com.htc.launcher.permission.READ_SETTINGS`
- `com.htc.launcher.permission.UPDATE_SHORTCUT`
- `com.huawei.android.launcher.permission.CHANGE_BADGE`
- `com.huawei.android.launcher.permission.READ_SETTINGS`
- `com.huawei.android.launcher.permission.WRITE_SETTINGS`
- `com.majeur.launcher.permission.UPDATE_BADGE`
- `com.oppo.launcher.permission.READ_SETTINGS`
- `com.oppo.launcher.permission.WRITE_SETTINGS`
- `com.sec.android.provider.badge.permission.READ`
- `com.sec.android.provider.badge.permission.WRITE`
- `com.sonyericsson.home.permission.BROADCAST_BADGE`
- `com.sonymobile.home.permission.PROVIDER_INSERT_BADGE`
- `me.everything.badger.permission.BADGE_COUNT_READ`
- `me.everything.badger.permission.BADGE_COUNT_WRITE`

## Signature
- Present: yes | status: verified (computed from the APK signing block) | scheme: v3
- Certificate: Common Name: FDroid, Organizational Unit: FDroid, Organization: fdroid.org, Locality: ORG, State/Province: ORG, Country: UK
- Cert sha256: `057ac45164a2e6e31f6dde555a5f2cccb4d8834cb1852549681b00e34668caf3`
- Known signers: Common Name: FDroid, Organizational Unit: FDroid, Organization: fdroid.org, Locality: ORG, State/Province: ORG, Country: UK
- Provider marks this file as **sourced from Google Play**: no

## VirusTotal
- Verdict: official F-Droid repository build (open-source; signed with the F-Droid key, not the upstream release key); not VT-scanned (0/0 engines)

## Manifest
- targetSdk 36
- Exported unguarded components (5): activity:chat.fluffy.fluffychat.MainActivity, activity:com.linusu.flutter_web_auth_2.CallbackActivity, receiver:com.pravera.flutter_foreground_task.service.RebootReceiver, service:org.unifiedpush.android.connector.internal.RaiseToForegroundService, receiver:org.unifiedpush.android.connector.internal.MessagingReceiverImpl

## Versions tracked by the provider (1)
- 2.11.5 (3578) — latest — sha256 a40f3876ec60adec…

## Native / protectors
- ABIs: arm64-v8a, armeabi-v7a, x86, x86_64
- Native libs: libImaging.so, libapp.so, libdartjni.so, libdatastore_shared_counter.so, libflutter.so, libjingle_peerconnection_so.so, libnoise.so, libsqlcipher.so, libvodozemac_bindings_dart.so, libwebcrypto.so
- Protectors: none detected


---

(from original-apk.md)

# Original APK acquisition — chat.fluffy.fluffychat

- Acquired: 199696390 bytes (199.70 MB), 1 bundle entries
- Version: 2.11.5 (3578)
- sha256: `a40f3876ec60adec4eb44ee91467b3094708dca0d4a38bb97b725a13367bd833`
- Originality vs provider listing: **unknown**
- Acquired via: **fdroid-open**

Acquired from the official F-Droid repository — the app’s own open-source distribution channel (public API, no mirror involved).


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
- fluffychat ×282
- image ×197
- highlight ×197
- lottie ×159
- material_ui ×157
- matrix ×122
- livekit_client ×87
- archive ×85
- flutter_map ×52
- markdown ×47
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

- Decompiled Java/Kotlin files: 3707

## Top-level packages
- `com` — 401 files
- `org` — 199 files
- `androidx` — 177 files
- `io` — 120 files
- `Z` — 82 files
- `j$` — 77 files
- `W5` — 60 files
- `J0` — 56 files
- `M` — 53 files
- `k3` — 47 files
- `q` — 42 files
- `I0` — 41 files

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

## Endpoints (29)

| Kind | URL | Purpose | Evidence |
| --- | --- | --- | --- |
| asset-cdn | https://fluffychat.im/assets/favicon.pngdier | developer's own file/upload CDN — where user content and media are stored | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im | developer's website root (about/support/landing page) | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im/privacy | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im/tosapplication | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| app-site | https://push.fluffychat.im/_matrix/push/v1/notifyv | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| app-site | https://fluffychat.im/changelog | developer's own site — app backend origin (REST calls most likely originate here) | libapp.so (Dart AOT string table) |
| review | https://matrix.to/# | possible app resource — verify against decompiled call sites before treating as a backend | libapp.so (Dart AOT string table) |
| review | https://aomediacodec.github.io/av1-rtp-spec | possible app resource — verify against decompiled call sites before treating as a backend | libapp.so (Dart AOT string table) |
| review | https://fluffychat.imp | possible app resource — verify against decompiled call sites before treating as a backend | libapp.so (Dart AOT string table) |
| social | https://ko-fi.com/post | donation/support page (fundraising link, not a runtime integration) | libapp.so (Dart AOT string table) |
| social | https://github.com/krille-chan/fluffychat | developer repository link (about/support page) | libapp.so (Dart AOT string table) |
| docs | https://spec.matrix.org/latest/rooms | Matrix protocol specification reference (the app speaks the Matrix protocol) | libapp.so (Dart AOT string table) |
| docs | https://microg.org/ | microG integration reference (FOSS Google-services replacement) | libapp.so (Dart AOT string table) |
| docs | https://unifiedpush.org/ | UnifiedPush integration reference (FOSS push notifications) | libapp.so (Dart AOT string table) |
| docs | https://developer.android.com/guide/components | Android developer documentation reference | libapp.so (Dart AOT string table) |
| docs | https://www.openstreetmap.org/?mlat=-60Yx | OpenStreetMap map/location link (geo feature) | libapp.so (Dart AOT string table) |
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
| framework-noise | https://github.com/google/gson/blob/main | framework/engine repository link from bundled license text — not app code | sources/w3/AbstractC1736G.java |

## How sync works (offline / online)

Offline-capable: local SQLite database (Flutter sqflite) holds data locally; network reachability checks (drives online/offline switching) drives when sync happens; local notifications announce events while backgrounded. Read paths hit local storage first; writes queue and flush to the REST backend when a connection is available.

### Signals
- **package:sqflite_common** — local SQLite database (Flutter sqflite) (offline storage)
- **package:sqlite3** — SQLite native bindings (offline storage)
- **package:flutter_local_notifications_windows** — local notifications (realtime/push)
- **package:flutter_local_notifications** — local notifications (realtime/push)
- **package:sqflite_common_ffi** — local SQLite database (Flutter sqflite) (offline storage)
- **package:flutter_local_notifications_linux** — local notifications (realtime/push)
- **package:flutter_secure_storage** — encrypted key-value store (Keystore-backed) (offline storage / token storage)
- **package:http** — Dart http client (api client)
- **package:flutter_local_notifications_platform_interface** — local notifications (realtime/push)
- **package:shared_preferences** — key-value preferences store (offline storage)
- **package:connectivity_plus** — network reachability checks (drives online/offline switching) (sync orchestration)
- **ContentProvider (×1 refs)** — ContentProvider data layer (offline storage)

### Realtime channels: local notifications


---

(from database-schema.md)

# Local database — chat.fluffy.fluffychat

## Storage engines
- **encrypted key-value store (Keystore-backed)** (package:flutter_secure_storage in libapp.so)
- **ContentProvider data layer** (ContentProvider in decompiled sources)
- **key-value preferences store** (package:shared_preferences in libapp.so)
- **local SQLite database (Flutter sqflite)** (package:sqflite_common_ffi in libapp.so)
- **local SQLite database (Flutter sqflite)** (package:sqflite_common in libapp.so)
- **SQLite native bindings** (package:sqlite3 in libapp.so)

_No CREATE TABLE statements recovered — schema is likely created at runtime or lives server-side._

## SQL evidence (verbatim, truncated)
- `SELECT END CALL ABORT CLEAR CHANNEL FACTOR LIST NUMBER OVERRIDE SET WEEK DISTRIBUTIONNODE ELSE WHEN THEN OTHERWISE IENUM CSV INCLUDE LEAVE RIDER SAVE DELETE NOV`
- `select set skip startsas stop title update waitsas where window x systask add and alter as cascade check create delete describe distinct drop foreign from group`
- `insert into in`
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

## Recovered API paths (5)
- `/client/v3/pushers/setVoc`
- `/settings`
- `/config`
- `/backup`
- `/login`

## Model classes (30)
- AudioFocusRequest
- StreamedRequest
- HTTPRequest
- StoreDataBlobResponse
- QuitarTrackPublishedResponse
- VGrTrickleRequest
- PublishDataTrackResponse
- SignalRequest
- FileSystemEntity
- GertStreamedRequest
- FfiMethodResponse
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
- HTTPErrorResponse

## Screens / views (30)
- DataView
- RenderView
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
- MaterialPage

## Modules (40)
- KeyManager
- SqfliteFfiMethodCallHandler
- ContentProvider
- TextInputClient
- VideoPlayerInstanceApi
- SharedPreferencesApi
- PlatformConfigurationNativeApi
- ExecutorService
- TypeAdapter
- X509TrustManager
- AndroidVideoPlayerApi
- AutofillManager
- BiometricManager
- ShortcutManager
- TextUtils
- KeyboardManager
- PushHelper
- TextSelectionDelegate
- RTCVideoPlatformController
- DataView
- OlmManager
- RouteInformationProvider
- LocalAuthApi
- AudioFocusRequest
- BaseAdapter
- TrustManager
- StreamedRequest
- ImagePickerApi
- UrlLauncherApi
- PointerUtils
- RadioClient
- HttpClient
- StatefulWidget
- RenderView
- HTTPRequest
- ScrollController
- BaseKeyProvider
- UndoManagerClient
- DehydratedDeviceMatrixApi
- SystemContextMenuClient


---

(from clone-pack/overview.md)

# FluffyChat Replication Blueprint

FluffyChat is a Matrix-based messaging app with end-to-end encryption, decentralized architecture, and rich communication features. It supports secure messaging, video calls, polls, spaces, and cross-client compatibility. The app uses Flutter for cross-platform development and integrates with the Matrix protocol for decentralized communication.

تم تطوير FluffyChat لتوفير تجربة مراسلة آمنة ومركزية.


---

(from clone-pack/features.md)

# Core Features

- **Matrix Protocol Integration**: Full compatibility with Matrix network and other Matrix clients
- **End-to-End Encryption**: Olm/Megolm encryption for messages and calls
- **Decentralized Architecture**: No single entity controls the network
- **Rich Messaging**: Text, media, polls, stickers, and reactions
- **Video/voice Calls**: Matrix RTC-compatible encrypted calls
- **Multi-device Support**: Synchronized across devices
- **Spaces**: Organized chat rooms with hierarchy
- **Moderation Tools**: Admin controls for communities
- **Push Notifications**: Via UnifiedPush integration
- **Localization**: Multi-language support

# Technical Features

- **Offline Capability**: Local SQLite database for offline access
- **Encrypted Storage**: Secure storage for keys and data
- **Biometric Authentication**: Device unlock with biometrics
- **Location Sharing**: Optional location features


---

(from clone-pack/architecture.md)

# Tech Stack

- **Frontend**: Flutter (Dart) with Provider for state management
- **Storage**: SQLite (sqflite) for local database, flutter_secure_storage for encrypted data
- **Networking**: HTTP client for Matrix API calls, UnifiedPush for notifications
- **Authentication**: Biometric authentication with encrypted token storage
- **Media**: Custom video player, audio recording capabilities

# Data Flow

1. UI components (Provider state) → 2. Local storage (SQLite/secure storage) → 3. Network client (HTTP) → 4. Matrix API endpoints
- Offline mode: UI reads from local storage, writes queue until connection
- Online mode: Data syncs with Matrix homeserver, encrypted end-to-end
- Push notifications handled via UnifiedPush integration


---

(from clone-pack/endpoints-analysis.md)

# Matrix Protocol Endpoints

- `https://spec.matrix.org/latest/rooms` - Matrix protocol specification reference
- `https://matrix.to/#` - Matrix resource link (verified against Matrix protocol)
- `https://matrix.gateway.unifiedpush.org/_matrix/push/v1` - UnifiedPush notification gateway

# App Backend Endpoints

- `https://fluffychat.im` - Primary backend origin (REST calls)
- `https://fluffychat.im/privacy` - Privacy policy endpoint
- `https://fluffychat.im/tosapplication` - Terms of service endpoint
- `https://push.fluffychat.im/_matrix/push/v1/notifyv` - Push notification endpoint
- `https://fluffychat.im/changelog` - App changelog endpoint

# Third-Party Services

- `https://microg.org` - microG integration (Google services replacement)
- `https://unifiedpush.org` - UnifiedPush documentation
- `https://www.openstreetmap.org` - Map/location service integration
- `https://ko-fi.com/post` - Donation/support page (non-runtime)

# Framework Noise

- Various W3C DTDs and XML schemas (parser boilerplate)
- Flutter and Dart documentation links (bundled in release)
- GitHub issue links (framework/engine references)


---

(from clone-pack/data-sync.md)

# Sync Architecture

- **Offline Storage**: SQLite database (sqflite) stores messages, rooms, and user data locally
- **Encrypted Storage**: flutter_secure_storage holds authentication tokens and encryption keys
- **Network Reachability**: connectivity_plus package monitors connection status
- **Sync Triggers**: Automatic sync when connection available; push notifications for real-time updates
- **Queue System**: Offline writes queue and flush to server when online
- **Conflict Resolution**: Matrix protocol handles conflict resolution at protocol level

# Sync Process

1. Local SQLite stores all message history and room state
2. Network client polls homeserver for new messages via Matrix API
3. Push notifications received via UnifiedPush gateway
4. Biometric authentication required for access to encrypted data
5. Changes sync bidirectionally when connection available


---

(from clone-pack/api-contract.md)

# Matrix API Base

- **Base URL**: Variable (user-configurable homeserver)
- **Authentication**: Matrix access token stored securely
- **Content-Type**: application/json

# Key Endpoints

- `POST /client/v3/login` - User authentication
- `GET /client/v3/sync` - Message synchronization
- `POST /client/v3/rooms/{roomId}/send/m.room.message` - Send message
- `POST /client/v3/pushers/set` - Register push notification
- `GET /client/v3/rooms/{roomId}/state` - Get room state
- `POST /client/v3/rooms/{roomId}/join` - Join room

# Payload Examples

- Login: `{"type":"m.login.password", "user":"user", "password":"pass"}`
- Send message: `{"msgtype":"m.text", "body":"Hello"}`
- Set pusher: `{"pushkey":"key", "kind":"http", "app":"app", "app_display_name":"app"}`


---

(from clone-pack/clone-plan.md)

# Build Plan

## Phase 1: Backend Foundation (3-4 weeks)

- Implement Matrix homeserver compatibility
- Create user authentication system
- Develop message storage and sync endpoints
- Set up push notification service

## Phase 2: Data Layer (2-3 weeks)

- Implement local SQLite database schema
- Create encrypted storage for tokens/keys
- Develop offline queue system
- Build conflict resolution logic

## Phase 3: Core Features (4-5 weeks)

- Implement messaging UI with text/media support
- Add end-to-end encryption (Olm/Megolm)
- Develop room creation and management
- Implement biometric authentication

## Phase 4: Advanced Features (3-4 weeks)

- Add video/voice calling capabilities
- Implement spaces and hierarchy
- Create polling and reaction features
- Add cross-client compatibility

## Phase 5: Polish (1-2 weeks)

- Localization support
- UI/UX refinements
- Performance optimization
- Testing and bug fixes