package I3;

import android.hardware.Camera;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4248a = "I3.a";

    public static int a(int i7) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f4248a, "No cameras!");
            return -1;
        }
        boolean z7 = i7 >= 0;
        if (!z7) {
            i7 = 0;
            while (i7 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i7, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i7++;
            }
        }
        return i7 < numberOfCameras ? i7 : z7 ? -1 : 0;
    }

    public static Camera b(int i7) {
        int iA = a(i7);
        if (iA == -1) {
            return null;
        }
        return Camera.open(iA);
    }
}
