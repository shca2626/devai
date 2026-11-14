package b6;

/* renamed from: b6.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0878m {
    public static final void a(int i7) {
        if (i7 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i7).toString());
    }

    public static final W5.J b(W5.J j7, String str) {
        return str != null ? new C0888w(j7, str) : j7;
    }
}
