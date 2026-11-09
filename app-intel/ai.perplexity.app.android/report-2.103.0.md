# App Intelligence report — Perplexity - Ask Anything (ai.perplexity.app.android)

- Version analyzed: 2.103.0 (260673)
- Acquired: 99.3 MB, sha256 `d17dd8d9804fee88d2c197fb29669bbd3534aad456f2fa8d3e25b50fde2619c4`, originality: match
- Generated: 2026-11-09T23:57:55.345Z



---

(from store-listing.md)

# Store listing — Perplexity - Ask Anything (ai.perplexity.app.android)

- Developer: PerplexityAI
- Genre: Productivity | Content rating: Teen
- Installs: 100,000,000+ | Rating: 4.620744 (2230004 ratings)
- Current version: 2.103.0 (Android 8.0)
- Released: May 24, 2023 | Updated: +058799-10
- Screenshots: 8

## Description

Perplexity—Where Knowledge Begins. The answers you need—right at your finger tips.

Cut through the clutter and get straight to credible, up-to-date answers. This free app syncs across devices and leverages the power of the top AI models from OpenAI, Anthropic, Meta, and more. 

Features:

· Perplexity Pro Search: Guided AI search for deeper exploration.

· Thread Follow-Up: Keep the conversation going for a deeper understanding.

· Voice: Instant, up-to-date answers whether you type or say it. 

· Trust Built In: Cited sources for every answer.

· Discover: Learn new things from the community.

· Your Library: More than search history, it's a curation of your discoveries.

Download Perplexity now and continue your journey to better knowledge and understanding.


---

(from original-apk.md)

# Original APK acquisition — ai.perplexity.app.android

- Acquired: 99320332 bytes (99.32 MB), 9 bundle entries
- Version: 2.103.0 (260673)
- sha256: `d17dd8d9804fee88d2c197fb29669bbd3534aad456f2fa8d3e25b50fde2619c4`
- Originality vs provider listing: **match**

Acquired through the reverse-engineered provider chain (hold-to-verify + turnstile + proof-of-work),
the same pipeline the public APK-downloader services use to fetch originals from Google Play.


---

(from tech-stack.md)

# Tech stack — ai.perplexity.app.android

- **Native Android (Java/Kotlin)** — 8033 decompiled JVM sources, no cross-platform markers (medium)
- **Kotlin stdlib** — kotlin.* packages in decompiled sources (medium)

## Native libraries
- `libaic.so`
- `libandroidx.graphics.path.so`
- `libaudioconverter.so`
- `libc++_shared.so`
- `libdatastore_shared_counter.so`
- `libimage_processing_util_jni.so`
- `libjingle_peerconnection_so.so`
- `libjnidispatch.so`
- `libmapbox-common.so`
- `libmapbox-maps.so`
- `libmultimodal_uniffi.so`
- `libonnxruntime.so`
- `libonnxruntime4j_jni.so`
- `libsurface_util_jni.so`

## Dart packages (top 30 of 0)


---

(from code-map.md)

# Code map — ai.perplexity.app.android

- Decompiled Java/Kotlin files: 8033

## Top-level packages
- `defpackage` — 3315 files
- `androidx` — 246 files
- `ai` — 202 files
- `org` — 171 files
- `android` — 29 files
- `kotlinx` — 16 files
- `kotlin` — 13 files
- `cloud` — 6 files
- `okhttp3` — 2 files

## Non-SDK endpoints (0)


---

(from endpoints-and-sync.md)

# Endpoints & synchronization — ai.perplexity.app.android

Every URL recovered from the compiled app, classified with its purpose.
Framework noise (engine licenses, DTDs, registry links) is separated from real app endpoints.

## Endpoints (2)

| Kind | URL | Purpose | Evidence |
| --- | --- | --- | --- |
| review | http://crbug.com/483041824 | possible app resource — verify against decompiled call sites before treating as a backend | sources/org/chromium/support_lib_boundary/PrefetchOperationCallbackBoundaryInterface.java |
| docs | https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted | Android developer documentation reference | sources/androidx/media3/datasource/HttpDataSource$HttpDataSourceException.java |

## How sync works (offline / online)

Local-first storage (Room persistence (SQLite ORM), ContentProvider data layer) with REST calls to the backend — a classic store-then-sync pattern; no background scheduler detected, so sync happens while the app is open.

### Signals
- **ContentProvider (×1 refs)** — ContentProvider data layer (offline storage)
- **androidx.room (×1 refs)** — Room persistence (SQLite ORM) (offline storage)


---

(from database-schema.md)

# Local database — ai.perplexity.app.android

## Storage engines
- **Room persistence (SQLite ORM)** (androidx.room in decompiled sources)
- **ContentProvider data layer** (ContentProvider in decompiled sources)

_No CREATE TABLE statements recovered — schema is likely created at runtime or lives server-side._


---

(from api-surface.md)

# API surface — ai.perplexity.app.android

## HTTP clients: none detected
## API base URLs: none detected
## Auth: none detected

## Recovered API paths (0)

## Model classes (5)
- WebResourceRequest
- WebResourceResponse
- DownloadRequest
- AwaitingResponse
- IntegrityTokenRequest

## Screens / views (13)
- WebView
- RecycleListView
- WebPage
- ListView
- FirstPage
- OlderPage
- AbsListView
- AssistantDialog
- CardView
- ReadingPage
- FullScreen
- GoToNextPage
- AllowInWebView

## Modules (40)
- InvocationHandler
- WebView
- HttpDataSource
- WebResourceRequest
- PackageManager
- TextUtils
- ActionProvider
- WebResourceResponse
- ContextUtils
- NotificationListenerService
- AlertController
- RecycleListView
- MediaController
- LifecycleUtils
- WebChromeClient
- WebViewClient
- ContentProvider
- CookieManager
- ServiceWorkerController
- RefCountDelegate
- LowLatencyAudioBufferManager
- WebPage
- AudioOutputProvider
- ListView
- MissingProvider
- FirstPage
- OlderPage
- AbsListView
- ContentApi
- WindowManager
- UserManager
- UploadDataProvider
- ApplicationContextProvider
- H264Utils
- PriorityTaskManager
- ContentDataSource
- HttpEngineDataSource
- UdpDataSource
- AssetDataSource
- RawResourceDataSource


---

(from clone-pack/overview.md)

# Perplexity Clone Blueprint

## Overview
Perplexity is a productivity AI search app that provides credible, up-to-date answers with cited sources. It features voice input, conversation threading, and device synchronization. The app uses native Android development with Kotlin and integrates multiple AI models.

## Key Features
- Perplexity Pro Search for guided AI exploration
- Thread follow-up for continued conversations
- Voice input for instant answers
- Cited sources for all answers
- Community discovery feature
- Personal library for saved searches

## Architecture
- Native Android app built with Kotlin
- Room persistence (SQLite ORM) for local storage
- ContentProvider for data layer
- WebView components for content display
- Native libraries for AI processing (libonnxruntime.so, libmultimodal_uniffi.so)

## Data Sync
- Local-first storage with Room persistence
- ContentProvider for data synchronization
- Store-then-sync pattern (no background scheduler detected)
- Sync occurs while app is open

## API Contract
- No explicit API endpoints identified in evidence
- Auth method not specified
- Backend implementation needed for search functionality

## Clone Plan
1. Backend development (AI integration, search API) - 4 weeks
2. Data layer implementation (Room, ContentProvider) - 2 weeks
3. Core features (search, voice, threading) - 3 weeks
4. UI components (WebView, list views) - 2 weeks
5. Library and sync features - 2 weeks

تطبيق Perplexity هو أداة بحث ذكية تقدم إجابات موثوقة ومحدثة مع مصادر موثوقة.


---

(from clone-pack/features.md)

# Perplexity Clone Blueprint

## Overview
Perplexity is a productivity AI search app that provides credible, up-to-date answers with cited sources. It features voice input, conversation threading, and device synchronization. The app uses native Android development with Kotlin and integrates multiple AI models.

## Key Features
- Perplexity Pro Search for guided AI exploration
- Thread follow-up for continued conversations
- Voice input for instant answers
- Cited sources for all answers
- Community discovery feature
- Personal library for saved searches

## Architecture
- Native Android app built with Kotlin
- Room persistence (SQLite ORM) for local storage
- ContentProvider for data layer
- WebView components for content display
- Native libraries for AI processing (libonnxruntime.so, libmultimodal_uniffi.so)

## Data Sync
- Local-first storage with Room persistence
- ContentProvider for data synchronization
- Store-then-sync pattern (no background scheduler detected)
- Sync occurs while app is open

## API Contract
- No explicit API endpoints identified in evidence
- Auth method not specified
- Backend implementation needed for search functionality

## Clone Plan
1. Backend development (AI integration, search API) - 4 weeks
2. Data layer implementation (Room, ContentProvider) - 2 weeks
3. Core features (search, voice, threading) - 3 weeks
4. UI components (WebView, list views) - 2 weeks
5. Library and sync features - 2 weeks

تطبيق Perplexity هو أداة بحث ذكية تقدم إجابات موثوقة ومحدثة مع مصادر موثوقة.


---

(from clone-pack/architecture.md)

# Perplexity Clone Blueprint

## Overview
Perplexity is a productivity AI search app that provides credible, up-to-date answers with cited sources. It features voice input, conversation threading, and device synchronization. The app uses native Android development with Kotlin and integrates multiple AI models.

## Key Features
- Perplexity Pro Search for guided AI exploration
- Thread follow-up for continued conversations
- Voice input for instant answers
- Cited sources for all answers
- Community discovery feature
- Personal library for saved searches

## Architecture
- Native Android app built with Kotlin
- Room persistence (SQLite ORM) for local storage
- ContentProvider for data layer
- WebView components for content display
- Native libraries for AI processing (libonnxruntime.so, libmultimodal_uniffi.so)

## Data Sync
- Local-first storage with Room persistence
- ContentProvider for data synchronization
- Store-then-sync pattern (no background scheduler detected)
- Sync occurs while app is open

## API Contract
- No explicit API endpoints identified in evidence
- Auth method not specified
- Backend implementation needed for search functionality

## Clone Plan
1. Backend development (AI integration, search API) - 4 weeks
2. Data layer implementation (Room, ContentProvider) - 2 weeks
3. Core features (search, voice, threading) - 3 weeks
4. UI components (WebView, list views) - 2 weeks
5. Library and sync features - 2 weeks

تطبيق Perplexity هو أداة بحث ذكية تقدم إجابات موثوقة ومحدثة مع مصادر موثوقة.


---

(from clone-pack/endpoints-analysis.md)

# Perplexity Clone Blueprint

## Overview
Perplexity is a productivity AI search app that provides credible, up-to-date answers with cited sources. It features voice input, conversation threading, and device synchronization. The app uses native Android development with Kotlin and integrates multiple AI models.

## Key Features
- Perplexity Pro Search for guided AI exploration
- Thread follow-up for continued conversations
- Voice input for instant answers
- Cited sources for all answers
- Community discovery feature
- Personal library for saved searches

## Architecture
- Native Android app built with Kotlin
- Room persistence (SQLite ORM) for local storage
- ContentProvider for data layer
- WebView components for content display
- Native libraries for AI processing (libonnxruntime.so, libmultimodal_uniffi.so)

## Data Sync
- Local-first storage with Room persistence
- ContentProvider for data synchronization
- Store-then-sync pattern (no background scheduler detected)
- Sync occurs while app is open

## API Contract
- No explicit API endpoints identified in evidence
- Auth method not specified
- Backend implementation needed for search functionality

## Clone Plan
1. Backend development (AI integration, search API) - 4 weeks
2. Data layer implementation (Room, ContentProvider) - 2 weeks
3. Core features (search, voice, threading) - 3 weeks
4. UI components (WebView, list views) - 2 weeks
5. Library and sync features - 2 weeks

تطبيق Perplexity هو أداة بحث ذكية تقدم إجابات موثوقة ومحدثة مع مصادر موثوقة.


---

(from clone-pack/data-sync.md)

# Perplexity Clone Blueprint

## Overview
Perplexity is a productivity AI search app that provides credible, up-to-date answers with cited sources. It features voice input, conversation threading, and device synchronization. The app uses native Android development with Kotlin and integrates multiple AI models.

## Key Features
- Perplexity Pro Search for guided AI exploration
- Thread follow-up for continued conversations
- Voice input for instant answers
- Cited sources for all answers
- Community discovery feature
- Personal library for saved searches

## Architecture
- Native Android app built with Kotlin
- Room persistence (SQLite ORM) for local storage
- ContentProvider for data layer
- WebView components for content display
- Native libraries for AI processing (libonnxruntime.so, libmultimodal_uniffi.so)

## Data Sync
- Local-first storage with Room persistence
- ContentProvider for data synchronization
- Store-then-sync pattern (no background scheduler detected)
- Sync occurs while app is open

## API Contract
- No explicit API endpoints identified in evidence
- Auth method not specified
- Backend implementation needed for search functionality

## Clone Plan
1. Backend development (AI integration, search API) - 4 weeks
2. Data layer implementation (Room, ContentProvider) - 2 weeks
3. Core features (search, voice, threading) - 3 weeks
4. UI components (WebView, list views) - 2 weeks
5. Library and sync features - 2 weeks

تطبيق Perplexity هو أداة بحث ذكية تقدم إجابات موثوقة ومحدثة مع مصادر موثوقة.


---

(from clone-pack/api-contract.md)

# Perplexity Clone Blueprint

## Overview
Perplexity is a productivity AI search app that provides credible, up-to-date answers with cited sources. It features voice input, conversation threading, and device synchronization. The app uses native Android development with Kotlin and integrates multiple AI models.

## Key Features
- Perplexity Pro Search for guided AI exploration
- Thread follow-up for continued conversations
- Voice input for instant answers
- Cited sources for all answers
- Community discovery feature
- Personal library for saved searches

## Architecture
- Native Android app built with Kotlin
- Room persistence (SQLite ORM) for local storage
- ContentProvider for data layer
- WebView components for content display
- Native libraries for AI processing (libonnxruntime.so, libmultimodal_uniffi.so)

## Data Sync
- Local-first storage with Room persistence
- ContentProvider for data synchronization
- Store-then-sync pattern (no background scheduler detected)
- Sync occurs while app is open

## API Contract
- No explicit API endpoints identified in evidence
- Auth method not specified
- Backend implementation needed for search functionality

## Clone Plan
1. Backend development (AI integration, search API) - 4 weeks
2. Data layer implementation (Room, ContentProvider) - 2 weeks
3. Core features (search, voice, threading) - 3 weeks
4. UI components (WebView, list views) - 2 weeks
5. Library and sync features - 2 weeks

تطبيق Perplexity هو أداة بحث ذكية تقدم إجابات موثوقة ومحدثة مع مصادر موثوقة.


---

(from clone-pack/clone-plan.md)

# Perplexity Clone Blueprint

## Overview
Perplexity is a productivity AI search app that provides credible, up-to-date answers with cited sources. It features voice input, conversation threading, and device synchronization. The app uses native Android development with Kotlin and integrates multiple AI models.

## Key Features
- Perplexity Pro Search for guided AI exploration
- Thread follow-up for continued conversations
- Voice input for instant answers
- Cited sources for all answers
- Community discovery feature
- Personal library for saved searches

## Architecture
- Native Android app built with Kotlin
- Room persistence (SQLite ORM) for local storage
- ContentProvider for data layer
- WebView components for content display
- Native libraries for AI processing (libonnxruntime.so, libmultimodal_uniffi.so)

## Data Sync
- Local-first storage with Room persistence
- ContentProvider for data synchronization
- Store-then-sync pattern (no background scheduler detected)
- Sync occurs while app is open

## API Contract
- No explicit API endpoints identified in evidence
- Auth method not specified
- Backend implementation needed for search functionality

## Clone Plan
1. Backend development (AI integration, search API) - 4 weeks
2. Data layer implementation (Room, ContentProvider) - 2 weeks
3. Core features (search, voice, threading) - 3 weeks
4. UI components (WebView, list views) - 2 weeks
5. Library and sync features - 2 weeks

تطبيق Perplexity هو أداة بحث ذكية تقدم إجابات موثوقة ومحدثة مع مصادر موثوقة.