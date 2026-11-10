package L4;

import I4.b;
import M5.m;
import android.media.AudioDeviceInfo;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class g {
    public static final I4.b a(AudioDeviceInfo audioDeviceInfo) {
        m.e(audioDeviceInfo, "<this>");
        if (audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 8) {
            return new b.a(audioDeviceInfo.getProductName().toString());
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
            return new b.a(audioDeviceInfo.getProductName().toString());
        }
        if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || (i7 >= 26 && audioDeviceInfo.getType() == 22)) {
            return new b.d(null, 1, null);
        }
        if (audioDeviceInfo.getType() == 1) {
            return new b.C0041b(null, 1, null);
        }
        if (audioDeviceInfo.getType() == 2) {
            return new b.c(null, 1, null);
        }
        return null;
    }
}
