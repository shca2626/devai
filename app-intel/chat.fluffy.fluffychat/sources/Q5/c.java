package Q5;

import M5.g;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: l, reason: collision with root package name */
    public static final a f7685l = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public static final c f7686m = G5.b.f3296a.b();

    public static final class a extends c implements Serializable {
        public /* synthetic */ a(g gVar) {
            this();
        }

        @Override // Q5.c
        public int b(int i7) {
            return c.f7686m.b(i7);
        }

        @Override // Q5.c
        public int c() {
            return c.f7686m.c();
        }

        @Override // Q5.c
        public int d(int i7) {
            return c.f7686m.d(i7);
        }

        @Override // Q5.c
        public int e(int i7, int i8) {
            return c.f7686m.e(i7, i8);
        }

        public a() {
        }
    }

    public abstract int b(int i7);

    public int c() {
        return b(32);
    }

    public int d(int i7) {
        return e(0, i7);
    }

    public int e(int i7, int i8) {
        int iC;
        int i9;
        int iB;
        d.b(i7, i8);
        int i10 = i8 - i7;
        if (i10 > 0 || i10 == Integer.MIN_VALUE) {
            if (((-i10) & i10) == i10) {
                iB = b(d.c(i10));
            } else {
                do {
                    iC = c() >>> 1;
                    i9 = iC % i10;
                } while ((iC - i9) + (i10 - 1) < 0);
                iB = i9;
            }
            return i7 + iB;
        }
        while (true) {
            int iC2 = c();
            if (i7 <= iC2 && iC2 < i8) {
                return iC2;
            }
        }
    }
}
