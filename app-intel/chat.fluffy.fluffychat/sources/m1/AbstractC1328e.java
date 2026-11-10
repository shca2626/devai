package m1;

import B0.A;
import E0.E;
import g1.V;

/* renamed from: m1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1328e {

    /* renamed from: a, reason: collision with root package name */
    public final V f19721a;

    /* renamed from: m1.e$a */
    public static final class a extends A {
        public a(String str) {
            super(str, null, false, 1);
        }
    }

    public AbstractC1328e(V v7) {
        this.f19721a = v7;
    }

    public final boolean a(E e7, long j7) {
        return b(e7) && c(e7, j7);
    }

    public abstract boolean b(E e7);

    public abstract boolean c(E e7, long j7);
}
