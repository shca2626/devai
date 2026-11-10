package org.webrtc;

import java.util.ArrayList;
import java.util.List;
import org.webrtc.CameraEnumerationAndroid;

/* loaded from: classes3.dex */
public class Camera1Helper {
    public static Size findClosestCaptureFormat(int i7, int i8, int i9) {
        List<CameraEnumerationAndroid.CaptureFormat> supportedFormats = getSupportedFormats(i7);
        ArrayList arrayList = new ArrayList();
        if (supportedFormats != null) {
            for (CameraEnumerationAndroid.CaptureFormat captureFormat : supportedFormats) {
                arrayList.add(new Size(captureFormat.width, captureFormat.height));
            }
        }
        return CameraEnumerationAndroid.getClosestSupportedSize(arrayList, i8, i9);
    }

    public static int getCameraId(String str) {
        return Camera1Enumerator.getCameraIndex(str);
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int i7) {
        return Camera1Enumerator.getSupportedFormats(i7);
    }
}
