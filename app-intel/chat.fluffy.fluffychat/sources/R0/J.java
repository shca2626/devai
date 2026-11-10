package R0;

import java.util.List;

/* loaded from: classes.dex */
public interface J {

    /* renamed from: a, reason: collision with root package name */
    public static final J f7773a = new J() { // from class: R0.H
        @Override // R0.J
        public final List b(String str, boolean z7, boolean z8) {
            return T.k(str, z7, z8);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final J f7774b = new J() { // from class: R0.I
        @Override // R0.J
        public final List b(String str, boolean z7, boolean z8) {
            return T.o(J.f7773a.b(str, z7, z8));
        }
    };

    List b(String str, boolean z7, boolean z8);
}
