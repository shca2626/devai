package io.flutter.embedding.engine;

import M2.c;
import X4.e;
import Z4.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Surface;
import android.view.SurfaceControl;
import g5.u;
import h.InterfaceC1116a;
import i5.d;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.renderer.n;
import io.flutter.embedding.engine.renderer.o;
import io.flutter.plugin.platform.C1190w;
import io.flutter.plugin.platform.U;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry;
import io.flutter.view.k;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import u5.AbstractC1668c;

@InterfaceC1116a
/* loaded from: classes.dex */
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static b asyncWaitForVsyncDelegate = null;
    private static float displayDensity = -1.0f;
    private static float displayHeight = -1.0f;
    private static float displayWidth = -1.0f;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static String vmServiceUri;
    private a accessibilityDelegate;
    private Y4.a deferredComponentManager;
    private d localizationPlugin;
    private Long nativeShellHolderId;
    private e platformMessageHandler;
    private C1190w platformViewsController;
    private U platformViewsController2;
    private u settingsChannel;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();
    private final Set<a.b> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<n> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private final Set<o> flutterUiResizeListeners = new CopyOnWriteArraySet();
    private final Looper mainLooper = Looper.getMainLooper();

    public interface a {
        void a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr);

        void b(ByteBuffer byteBuffer, String[] strArr);

        void d();

        void f(String str);
    }

    public interface b {
        void a(long j7);
    }

    public static class c {
        public FlutterJNI a() {
            return new FlutterJNI();
        }
    }

    private static void asyncWaitForVsync(long j7) {
        b bVar = asyncWaitForVsyncDelegate;
        if (bVar == null) {
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
        bVar.a(j7);
    }

    public static Bitmap decodeImage(ByteBuffer byteBuffer, final long j7) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Z4.c.a(byteBuffer, new c.a() { // from class: W4.f
                @Override // Z4.c.a
                public final void a(int i7, int i8) {
                    FlutterJNI.nativeImageHeaderCallback(j7, i7, i8);
                }
            });
        }
        return null;
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    public static String getVMServiceUri() {
        return vmServiceUri;
    }

    private void handlePlatformMessageResponse(int i7, ByteBuffer byteBuffer) {
        e eVar = this.platformMessageHandler;
        if (eVar != null) {
            eVar.g(i7, byteBuffer);
        }
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j7);

    private native void nativeDeferredComponentInstallFailure(int i7, String str, boolean z7);

    private native void nativeDestroy(long j7);

    private native void nativeDispatchEmptyPlatformMessage(long j7, String str, int i7);

    private native void nativeDispatchPlatformMessage(long j7, String str, ByteBuffer byteBuffer, int i7, int i8);

    private native void nativeDispatchPointerDataPacket(long j7, ByteBuffer byteBuffer, int i7);

    private native void nativeDispatchSemanticsAction(long j7, int i7, int i8, ByteBuffer byteBuffer, int i9);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i7);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i7);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i7);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i7);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i7);

    private native Bitmap nativeGetBitmap(long j7);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j7, int i7, int i8);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j7, int i7);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j7, int i7);

    private native void nativeInvokePlatformMessageResponseCallback(long j7, int i7, ByteBuffer byteBuffer, int i8);

    private native boolean nativeIsSurfaceControlEnabled(long j7);

    private native void nativeLoadDartDeferredLibrary(long j7, int i7, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j7);

    private native void nativeMarkTextureFrameAvailable(long j7, long j8);

    private native void nativeNotifyLowMemoryWarning(long j7);

    private native void nativeOnVsync(long j7, long j8, long j9);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterImageTexture(long j7, long j8, WeakReference<TextureRegistry.ImageConsumer> weakReference, boolean z7);

    private native void nativeRegisterTexture(long j7, long j8, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j7, String str, String str2, String str3, AssetManager assetManager, List<String> list, long j8);

    private native void nativeScheduleFrame(long j7);

    private native void nativeSetAccessibilityFeatures(long j7, int i7);

    private native void nativeSetSemanticsEnabled(long j7, boolean z7);

    private native void nativeSetViewportMetrics(long j7, float f7, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int[] iArr, int[] iArr2, int[] iArr3, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29);

    private native FlutterJNI nativeSpawn(long j7, String str, String str2, String str3, List<String> list, long j8);

    private native void nativeSurfaceChanged(long j7, int i7, int i8);

    private native void nativeSurfaceCreated(long j7, Surface surface);

    private native void nativeSurfaceDestroyed(long j7);

    private native void nativeSurfaceWindowChanged(long j7, Surface surface);

    private native void nativeUnregisterTexture(long j7, long j8);

    private native void nativeUpdateDisplayMetrics(long j7);

    private native void nativeUpdateJavaAssetManager(long j7, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f7);

    private void onPreEngineRestart() {
        Iterator<a.b> it = this.engineLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void setApplicationLocale(String str) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar != null) {
            aVar.f(str);
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar != null) {
            aVar.b(byteBuffer, strArr);
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar != null) {
            aVar.a(byteBuffer, strArr, byteBufferArr);
        }
    }

    public boolean IsSurfaceControlEnabled() {
        return nativeIsSurfaceControlEnabled(this.nativeShellHolderId.longValue());
    }

    public void addEngineLifecycleListener(a.b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(bVar);
    }

    public void addIsDisplayingFlutterUiListener(n nVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(nVar);
    }

    public void addResizingFlutterUiListener(o oVar) {
        ensureRunningOnMainThread();
        this.flutterUiResizeListeners.add(oVar);
    }

    @SuppressLint({"NewApi"})
    public void applyTransactions() {
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("");
        }
        u7.i();
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j7) {
        nativeCleanupMessageData(j7);
    }

    public String[] computePlatformResolvedLocale(String[] strArr) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < strArr.length; i7 += 3) {
            String str = strArr[i7];
            String str2 = strArr[i7 + 1];
            String str3 = strArr[i7 + 2];
            Locale.Builder builder = new Locale.Builder();
            if (!str.isEmpty()) {
                builder.setLanguage(str);
            }
            if (!str2.isEmpty()) {
                builder.setRegion(str2);
            }
            if (!str3.isEmpty()) {
                builder.setScript(str3);
            }
            arrayList.add(builder.build());
        }
        Locale localeC = this.localizationPlugin.c(arrayList);
        return localeC == null ? new String[0] : new String[]{localeC.getLanguage(), localeC.getCountry(), localeC.getScript()};
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        C1190w c1190w = this.platformViewsController;
        if (c1190w != null) {
            return c1190w.J();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @SuppressLint({"NewApi"})
    public FlutterOverlaySurface createOverlaySurface2() {
        U u7 = this.platformViewsController2;
        if (u7 != null) {
            return u7.q();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @SuppressLint({"NewApi"})
    public SurfaceControl.Transaction createTransaction() {
        U u7 = this.platformViewsController2;
        if (u7 != null) {
            return u7.s();
        }
        throw new RuntimeException("");
    }

    public void deferredComponentInstallFailure(int i7, String str, boolean z7) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i7, str, z7);
    }

    @SuppressLint({"NewApi"})
    public void destroyOverlaySurface2() {
        ensureRunningOnMainThread();
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        u7.t();
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        C1190w c1190w = this.platformViewsController;
        if (c1190w == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        c1190w.M();
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i7) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i7);
            return;
        }
        U4.b.g(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i7);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i7, int i8) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i7, i8);
            return;
        }
        U4.b.g(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i8);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i7);
    }

    public void dispatchSemanticsAction(int i7, k.g gVar) {
        dispatchSemanticsAction(i7, gVar, null);
    }

    @SuppressLint({"NewApi"})
    public void endFrame2() {
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("");
        }
        u7.G();
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public float getScaledFontSize(float f7, int i7) {
        u uVar = this.settingsChannel;
        DisplayMetrics displayMetricsA = uVar == null ? null : uVar.a(i7);
        if (displayMetricsA != null) {
            return TypedValue.applyDimension(2, f7, displayMetricsA) / displayMetricsA.density;
        }
        U4.b.b(TAG, "getScaledFontSize called with configurationId " + i7 + ", which can't be found.");
        return -1.0f;
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i7, long j7) {
        e eVar = this.platformMessageHandler;
        if (eVar != null) {
            eVar.h(str, byteBuffer, i7, j7);
        } else {
            nativeCleanupMessageData(j7);
        }
    }

    @SuppressLint({"NewApi"})
    public void hideOverlaySurface2() {
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        u7.y();
    }

    @SuppressLint({"NewApi"})
    public void hidePlatformView2(int i7) {
        ensureRunningOnMainThread();
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to hide a platform view");
        }
        u7.z(i7);
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j7, int i7) {
        if (initCalled) {
            U4.b.g(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j7, i7);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i7) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i7);
            } else {
                U4.b.g(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i7);
            }
            this.shellHolderLock.readLock().unlock();
        } catch (Throwable th) {
            this.shellHolderLock.readLock().unlock();
            throw th;
        }
    }

    public void invokePlatformMessageResponseCallback(int i7, ByteBuffer byteBuffer, int i8) {
        FlutterJNI flutterJNI;
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
        this.shellHolderLock.readLock().lock();
        try {
            try {
                if (isAttached()) {
                    flutterJNI = this;
                    flutterJNI.nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i7, byteBuffer, i8);
                } else {
                    flutterJNI = this;
                    U4.b.g(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i7);
                }
                flutterJNI.shellHolderLock.readLock().unlock();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                flutterJNI.shellHolderLock.readLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            flutterJNI = this;
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i7) {
        return nativeFlutterTextUtilsIsEmoji(i7);
    }

    public boolean isCodePointEmojiModifier(int i7) {
        return nativeFlutterTextUtilsIsEmojiModifier(i7);
    }

    public boolean isCodePointEmojiModifierBase(int i7) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i7);
    }

    public boolean isCodePointRegionalIndicator(int i7) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i7);
    }

    public boolean isCodePointVariantSelector(int i7) {
        return nativeFlutterTextUtilsIsVariationSelector(i7);
    }

    public void loadDartDeferredLibrary(int i7, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i7, strArr);
    }

    public void loadLibrary(Context context) {
        if (loadLibraryCalled) {
            U4.b.g(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        M2.c.a(new c.d() { // from class: W4.e
            @Override // M2.c.d
            public final void a(String str) {
                U4.b.a(FlutterJNI.TAG, str);
            }
        }).e(context, "flutter");
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j7);
    }

    public void maybeResizeSurfaceView(int i7, int i8) {
        Iterator<o> it = this.flutterUiResizeListeners.iterator();
        while (it.hasNext()) {
            it.next().a(i7, i8);
        }
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        C1190w c1190w = this.platformViewsController;
        if (c1190w == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
        }
        c1190w.b0();
    }

    public void onDisplayOverlaySurface(int i7, int i8, int i9, int i10, int i11) {
        ensureRunningOnMainThread();
        C1190w c1190w = this.platformViewsController;
        if (c1190w == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        c1190w.d0(i7, i8, i9, i10, i11);
    }

    public void onDisplayPlatformView(int i7, int i8, int i9, int i10, int i11, int i12, int i13, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        C1190w c1190w = this.platformViewsController;
        if (c1190w == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        c1190w.e0(i7, i8, i9, i10, i11, i12, i13, flutterMutatorsStack);
    }

    @SuppressLint({"NewApi"})
    public void onDisplayPlatformView2(int i7, int i8, int i9, int i10, int i11, int i12, int i13, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        u7.F(i7, i8, i9, i10, i11, i12, i13, flutterMutatorsStack);
    }

    public void onEndFrame() {
        ensureRunningOnMainThread();
        C1190w c1190w = this.platformViewsController;
        if (c1190w == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
        }
        c1190w.f0();
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<n> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<n> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public void onSurfaceChanged(int i7, int i8) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i7, i8);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j7, long j8, long j9) {
        nativeOnVsync(j7, j8, j9);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            U4.b.g(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerImageTexture(long j7, TextureRegistry.ImageConsumer imageConsumer, boolean z7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterImageTexture(this.nativeShellHolderId.longValue(), j7, new WeakReference<>(imageConsumer), z7);
    }

    public void registerTexture(long j7, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j7, new WeakReference<>(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(a.b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(bVar);
    }

    public void removeIsDisplayingFlutterUiListener(n nVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(nVar);
    }

    public void removeResizingFlutterUiListener(o oVar) {
        ensureRunningOnMainThread();
        this.flutterUiResizeListeners.remove(oVar);
    }

    public void requestDartDeferredLibrary(int i7) {
        U4.b.b(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list, long j7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list, j7);
    }

    public void scheduleFrame() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeScheduleFrame(this.nativeShellHolderId.longValue());
    }

    public void setAccessibilityDelegate(a aVar) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = aVar;
    }

    public void setAccessibilityFeatures(int i7) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setAccessibilityFeaturesInNative(i7);
        }
    }

    public void setAccessibilityFeaturesInNative(int i7) {
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i7);
    }

    public void setAsyncWaitForVsyncDelegate(b bVar) {
        asyncWaitForVsyncDelegate = bVar;
    }

    public void setDeferredComponentManager(Y4.a aVar) {
        ensureRunningOnMainThread();
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void setLocalizationPlugin(d dVar) {
        ensureRunningOnMainThread();
        this.localizationPlugin = dVar;
    }

    public void setPlatformMessageHandler(e eVar) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = eVar;
    }

    public void setPlatformViewsController(C1190w c1190w) {
        ensureRunningOnMainThread();
        this.platformViewsController = c1190w;
    }

    public void setPlatformViewsController2(U u7) {
        ensureRunningOnMainThread();
        this.platformViewsController2 = u7;
    }

    public void setRefreshRateFPS(float f7) {
        refreshRateFPS = f7;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z7) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setSemanticsEnabledInNative(z7);
        }
    }

    public void setSemanticsEnabledInNative(boolean z7) {
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z7);
    }

    public void setSemanticsTreeEnabled(boolean z7) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar == null || z7) {
            return;
        }
        aVar.d();
    }

    public void setSettingsChannel(u uVar) {
        ensureRunningOnMainThread();
        this.settingsChannel = uVar;
    }

    public void setViewportMetrics(float f7, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int[] iArr, int[] iArr2, int[] iArr3, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        U4.b.a(TAG, "Sending viewport metrics to the engine.");
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f7, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, iArr, iArr2, iArr3, i22, i23, i24, i25, i26, i27, i28, i29);
    }

    @SuppressLint({"NewApi"})
    public void showOverlaySurface2() {
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        u7.O();
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list, long j7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI flutterJNINativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list, j7);
        Long l7 = flutterJNINativeSpawn.nativeShellHolderId;
        AbstractC1668c.a((l7 == null || l7.longValue() == 0) ? false : true, "Failed to spawn new JNI connected shell from existing shell.");
        return flutterJNINativeSpawn;
    }

    @SuppressLint({"NewApi"})
    public void swapTransactions() {
        U u7 = this.platformViewsController2;
        if (u7 == null) {
            throw new RuntimeException("");
        }
        u7.P();
    }

    public void unregisterTexture(long j7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j7);
    }

    public void updateDisplayMetrics(int i7, float f7, float f8, float f9) {
        displayWidth = f7;
        displayHeight = f8;
        displayDensity = f9;
        if (loadLibraryCalled) {
            nativeUpdateDisplayMetrics(this.nativeShellHolderId.longValue());
        }
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }

    public void dispatchSemanticsAction(int i7, k.g gVar, Object obj) {
        ByteBuffer byteBufferA;
        int iPosition;
        ensureAttachedToNative();
        if (obj != null) {
            byteBufferA = h5.o.f16907a.a(obj);
            iPosition = byteBufferA.position();
        } else {
            byteBufferA = null;
            iPosition = 0;
        }
        dispatchSemanticsAction(i7, gVar.f18022l, byteBufferA, iPosition);
    }

    public void dispatchSemanticsAction(int i7, int i8, ByteBuffer byteBuffer, int i9) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i7, i8, byteBuffer, i9);
    }
}
