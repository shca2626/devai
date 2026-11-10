package p5;

import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z5.C1881o;

/* renamed from: p5.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1450d {

    /* renamed from: a, reason: collision with root package name */
    public static final C1450d f20989a = new C1450d();

    /* JADX WARN: Code restructure failed: missing block: B:101:0x013e, code lost:
    
        if (a(r2.getValue(), r5.getValue()) == false) goto L131;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.C1450d.a(java.lang.Object, java.lang.Object):boolean");
    }

    public final int b(Object obj) {
        int iB = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.hashCode((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.hashCode((long[]) obj);
        }
        int iB2 = 1;
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length;
            while (iB < length) {
                iB2 = (iB2 * 31) + d(dArr[iB]);
                iB++;
            }
            return iB2;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length;
            while (iB < length2) {
                iB2 = (iB2 * 31) + f(fArr[iB]);
                iB++;
            }
            return iB2;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length3 = objArr.length;
            while (iB < length3) {
                iB2 = (iB2 * 31) + b(objArr[iB]);
                iB++;
            }
            return iB2;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iB2 = (iB2 * 31) + b(it.next());
            }
            return iB2;
        }
        if (!(obj instanceof Map)) {
            return obj instanceof Double ? d(((Number) obj).doubleValue()) : obj instanceof Float ? f(((Number) obj).floatValue()) : obj.hashCode();
        }
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            iB += b(entry.getValue()) ^ (b(entry.getKey()) * 31);
        }
        return iB;
    }

    public final boolean c(double d7, double d8) {
        if ((d7 == 0.0d ? 0.0d : d7) == (d8 != 0.0d ? d8 : 0.0d)) {
            return true;
        }
        return Double.isNaN(d7) && Double.isNaN(d8);
    }

    public final int d(double d7) {
        if (d7 == 0.0d) {
            d7 = 0.0d;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(d7);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final boolean e(float f7, float f8) {
        if ((f7 == 0.0f ? 0.0f : f7) == (f8 != 0.0f ? f8 : 0.0f)) {
            return true;
        }
        return Float.isNaN(f7) && Float.isNaN(f8);
    }

    public final int f(float f7) {
        if (f7 == 0.0f) {
            f7 = 0.0f;
        }
        return Float.floatToIntBits(f7);
    }

    public final List g(Throwable th) {
        M5.m.e(th, "exception");
        return C1881o.l(th.getClass().getSimpleName(), th.toString(), "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
    }
}
