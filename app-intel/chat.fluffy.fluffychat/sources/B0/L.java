package B0;

import E0.U;
import java.util.Arrays;
import java.util.List;
import k3.AbstractC1278v;
import o3.AbstractC1399a;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: b, reason: collision with root package name */
    public static final L f554b = new L(AbstractC1278v.v());

    /* renamed from: c, reason: collision with root package name */
    public static final String f555c = U.A0(0);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1278v f556a;

    public static final class a {

        /* renamed from: f, reason: collision with root package name */
        public static final String f557f = U.A0(0);

        /* renamed from: g, reason: collision with root package name */
        public static final String f558g = U.A0(1);

        /* renamed from: h, reason: collision with root package name */
        public static final String f559h = U.A0(3);

        /* renamed from: i, reason: collision with root package name */
        public static final String f560i = U.A0(4);

        /* renamed from: a, reason: collision with root package name */
        public final int f561a;

        /* renamed from: b, reason: collision with root package name */
        public final I f562b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f563c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f564d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean[] f565e;

        public a(I i7, boolean z7, int[] iArr, boolean[] zArr) {
            int i8 = i7.f425a;
            this.f561a = i8;
            boolean z8 = false;
            j3.o.d(i8 == iArr.length && i8 == zArr.length);
            this.f562b = i7;
            if (z7 && i8 > 1) {
                z8 = true;
            }
            this.f563c = z8;
            this.f564d = (int[]) iArr.clone();
            this.f565e = (boolean[]) zArr.clone();
        }

        public I a() {
            return this.f562b;
        }

        public s b(int i7) {
            return this.f562b.a(i7);
        }

        public int c() {
            return this.f562b.f427c;
        }

        public boolean d() {
            return AbstractC1399a.a(this.f565e, true);
        }

        public boolean e(int i7) {
            return this.f565e[i7];
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f563c == aVar.f563c && this.f562b.equals(aVar.f562b) && Arrays.equals(this.f564d, aVar.f564d) && Arrays.equals(this.f565e, aVar.f565e)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f562b.hashCode() * 31) + (this.f563c ? 1 : 0)) * 31) + Arrays.hashCode(this.f564d)) * 31) + Arrays.hashCode(this.f565e);
        }
    }

    public L(List list) {
        this.f556a = AbstractC1278v.r(list);
    }

    public AbstractC1278v a() {
        return this.f556a;
    }

    public boolean b(int i7) {
        for (int i8 = 0; i8 < this.f556a.size(); i8++) {
            a aVar = (a) this.f556a.get(i8);
            if (aVar.d() && aVar.c() == i7) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || L.class != obj.getClass()) {
            return false;
        }
        return this.f556a.equals(((L) obj).f556a);
    }

    public int hashCode() {
        return this.f556a.hashCode();
    }
}
