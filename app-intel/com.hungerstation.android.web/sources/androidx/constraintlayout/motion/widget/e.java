package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    HashMap<Object, HashMap<String, float[]>> f5645a = new HashMap<>();

    float a(Object obj, String str, int i12) {
        if (!this.f5645a.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap<String, float[]> map = this.f5645a.get(obj);
        if (!map.containsKey(str)) {
            return Float.NaN;
        }
        float[] fArr = map.get(str);
        if (fArr.length > i12) {
            return fArr[i12];
        }
        return Float.NaN;
    }

    void b(Object obj, String str, int i12, float f12) {
        if (!this.f5645a.containsKey(obj)) {
            HashMap<String, float[]> map = new HashMap<>();
            float[] fArr = new float[i12 + 1];
            fArr[i12] = f12;
            map.put(str, fArr);
            this.f5645a.put(obj, map);
            return;
        }
        HashMap<String, float[]> map2 = this.f5645a.get(obj);
        if (!map2.containsKey(str)) {
            float[] fArr2 = new float[i12 + 1];
            fArr2[i12] = f12;
            map2.put(str, fArr2);
            this.f5645a.put(obj, map2);
            return;
        }
        float[] fArrCopyOf = map2.get(str);
        if (fArrCopyOf.length <= i12) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, i12 + 1);
        }
        fArrCopyOf[i12] = f12;
        map2.put(str, fArrCopyOf);
    }
}
