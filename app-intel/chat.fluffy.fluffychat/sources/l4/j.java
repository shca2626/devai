package l4;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public SurfaceHolder f19648a;

    /* renamed from: b, reason: collision with root package name */
    public SurfaceTexture f19649b;

    public j(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.f19648a = surfaceHolder;
    }

    public void a(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.f19648a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.f19649b);
        }
    }

    public j(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.f19649b = surfaceTexture;
            return;
        }
        throw new IllegalArgumentException("surfaceTexture may not be null");
    }
}
