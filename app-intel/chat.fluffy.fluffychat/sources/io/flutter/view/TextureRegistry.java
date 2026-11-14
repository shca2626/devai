package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;
import h.InterfaceC1117a;

/* loaded from: classes.dex */
public interface TextureRegistry {

    @InterfaceC1117a
    public interface GLTextureConsumer {
        SurfaceTexture getSurfaceTexture();
    }

    @InterfaceC1117a
    public interface ImageConsumer {
        Image acquireLatestImage();
    }

    @InterfaceC1117a
    public interface ImageTextureEntry {
        /* synthetic */ long id();

        void pushImage(Image image);

        /* synthetic */ void release();
    }

    @InterfaceC1117a
    public interface SurfaceProducer {

        public interface a {
            void onSurfaceAvailable();

            void onSurfaceCleanup();

            default void onSurfaceCreated() {
            }

            default void onSurfaceDestroyed() {
            }
        }

        Surface getForcedNewSurface();

        int getHeight();

        Surface getSurface();

        int getWidth();

        boolean handlesCropAndRotation();

        /* synthetic */ long id();

        /* synthetic */ void release();

        void scheduleFrame();

        void setCallback(a aVar);

        void setSize(int i7, int i8);
    }

    @InterfaceC1117a
    public interface SurfaceTextureEntry {
        /* synthetic */ long id();

        /* synthetic */ void release();

        default void setOnFrameConsumedListener(a aVar) {
        }

        default void setOnTrimMemoryListener(b bVar) {
        }

        SurfaceTexture surfaceTexture();
    }

    public interface a {
    }

    public interface b {
        void onTrimMemory(int i7);
    }

    public enum c {
        manual,
        resetInBackground
    }

    SurfaceProducer a(c cVar);

    ImageTextureEntry b();

    default SurfaceProducer c() {
        return a(c.manual);
    }

    SurfaceTextureEntry d();
}
