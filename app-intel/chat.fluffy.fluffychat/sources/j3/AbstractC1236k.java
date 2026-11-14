package j3;

import java.util.Arrays;

/* renamed from: j3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1236k extends AbstractC1230e {
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
