package com.cloudwebrtc.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import org.webrtc.CapturerObserver;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

@TargetApi(21)
/* loaded from: classes.dex */
public class OrientationAwareScreenCapturer implements VideoCapturer, VideoSink {
    private static final int DISPLAY_FLAGS = 3;
    private static final int VIRTUAL_DISPLAY_DPI = 400;
    private CapturerObserver capturerObserver;
    private int height;
    private boolean isPortrait;
    private MediaProjection mediaProjection;
    private final MediaProjection.Callback mediaProjectionCallback;
    private MediaProjectionManager mediaProjectionManager;
    private final Intent mediaProjectionPermissionResultData;
    private volatile int oldHeight;
    private volatile int oldWidth;
    private SurfaceTextureHelper surfaceTextureHelper;
    private VirtualDisplay virtualDisplay;
    private Surface virtualDisplaySurface;
    private int width;
    private WindowManager windowManager;
    private long numCapturedFrames = 0;
    private volatile boolean isDisposed = false;
    private volatile boolean isStopped = false;

    public OrientationAwareScreenCapturer(Intent intent, MediaProjection.Callback callback) {
        this.mediaProjectionPermissionResultData = intent;
        this.mediaProjectionCallback = callback;
    }

    private void checkNotDisposed() {
        if (this.isDisposed) {
            throw new RuntimeException("capturer is disposed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createVirtualDisplay() {
        updateSurfaceTextureSize();
        releaseVirtualDisplaySurface();
        Surface surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
        this.virtualDisplaySurface = surface;
        this.virtualDisplay = this.mediaProjection.createVirtualDisplay("WebRTC_ScreenCapture", this.width, this.height, VIRTUAL_DISPLAY_DPI, 3, surface, null, null);
    }

    private boolean isDeviceOrientationPortrait() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels > displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseVirtualDisplaySurface() {
        Surface surface = this.virtualDisplaySurface;
        if (surface != null) {
            surface.release();
            this.virtualDisplaySurface = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeVirtualDisplay() {
        updateSurfaceTextureSize();
        this.virtualDisplay.resize(this.width, this.height, VIRTUAL_DISPLAY_DPI);
        Surface surface = this.virtualDisplaySurface;
        Surface surface2 = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
        this.virtualDisplaySurface = surface2;
        this.virtualDisplay.setSurface(surface2);
        if (surface != null) {
            surface.release();
        }
    }

    private void updateSurfaceTextureSize() {
        this.surfaceTextureHelper.setTextureSize(this.width, this.height);
        this.surfaceTextureHelper.getSurfaceTexture().setDefaultBufferSize(this.width, this.height);
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void changeCaptureFormat(int i7, int i8, int i9) {
        try {
            checkNotDisposed();
            if (this.oldWidth != i7 || this.oldHeight != i8) {
                this.width = i7;
                this.height = i8;
                this.oldWidth = i7;
                this.oldHeight = i8;
                ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable() { // from class: com.cloudwebrtc.webrtc.OrientationAwareScreenCapturer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (OrientationAwareScreenCapturer.this.surfaceTextureHelper == null || OrientationAwareScreenCapturer.this.mediaProjection == null) {
                            return;
                        }
                        if (OrientationAwareScreenCapturer.this.virtualDisplay != null) {
                            OrientationAwareScreenCapturer.this.resizeVirtualDisplay();
                        } else {
                            OrientationAwareScreenCapturer.this.createVirtualDisplay();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void dispose() {
        this.isDisposed = true;
    }

    public long getNumCapturedFrames() {
        return this.numCapturedFrames;
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        checkNotDisposed();
        if (capturerObserver == null) {
            throw new RuntimeException("capturerObserver not set.");
        }
        this.capturerObserver = capturerObserver;
        if (surfaceTextureHelper == null) {
            throw new RuntimeException("surfaceTextureHelper not set.");
        }
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.mediaProjectionManager = (MediaProjectionManager) context.getSystemService("media_projection");
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return true;
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.isDisposed || this.isStopped) {
            return;
        }
        this.isPortrait = isDeviceOrientationPortrait();
        int iMax = Math.max(this.height, this.width);
        int iMin = Math.min(this.height, this.width);
        boolean z7 = this.isPortrait;
        int i7 = z7 ? iMin : iMax;
        if (!z7) {
            iMax = iMin;
        }
        if (i7 != this.oldWidth || iMax != this.oldHeight) {
            changeCaptureFormat(i7, iMax, 15);
        }
        this.capturerObserver.onFrameCaptured(videoFrame);
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void startCapture(int i7, int i8, int i9) {
        try {
            boolean zIsDeviceOrientationPortrait = isDeviceOrientationPortrait();
            this.isPortrait = zIsDeviceOrientationPortrait;
            if (zIsDeviceOrientationPortrait) {
                this.width = i7;
                this.height = i8;
            } else {
                this.height = i7;
                this.width = i8;
            }
            this.oldWidth = this.width;
            this.oldHeight = this.height;
            MediaProjection mediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
            this.mediaProjection = mediaProjection;
            mediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
            createVirtualDisplay();
            this.capturerObserver.onCapturerStarted(true);
            this.surfaceTextureHelper.startListening(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
        if (this.isDisposed || this.isStopped) {
            return;
        }
        this.isStopped = true;
        ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable() { // from class: com.cloudwebrtc.webrtc.OrientationAwareScreenCapturer.1
            @Override // java.lang.Runnable
            public void run() {
                OrientationAwareScreenCapturer.this.surfaceTextureHelper.stopListening();
                OrientationAwareScreenCapturer.this.capturerObserver.onCapturerStopped();
                if (OrientationAwareScreenCapturer.this.virtualDisplay != null) {
                    OrientationAwareScreenCapturer.this.virtualDisplay.release();
                    OrientationAwareScreenCapturer.this.virtualDisplay = null;
                }
                OrientationAwareScreenCapturer.this.releaseVirtualDisplaySurface();
                if (OrientationAwareScreenCapturer.this.mediaProjection != null) {
                    OrientationAwareScreenCapturer.this.mediaProjection.unregisterCallback(OrientationAwareScreenCapturer.this.mediaProjectionCallback);
                    OrientationAwareScreenCapturer.this.mediaProjection.stop();
                    OrientationAwareScreenCapturer.this.mediaProjection = null;
                }
            }
        });
    }
}
