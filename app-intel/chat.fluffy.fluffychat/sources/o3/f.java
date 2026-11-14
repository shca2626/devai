package o3;

import j3.o;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class f implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public static final f f20371o = new f(new int[0]);

    /* renamed from: l, reason: collision with root package name */
    public final int[] f20372l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f20373m;

    /* renamed from: n, reason: collision with root package name */
    public final int f20374n;

    public f(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static f a(int[] iArr) {
        return iArr.length == 0 ? f20371o : new f(Arrays.copyOf(iArr, iArr.length));
    }

    public static f e() {
        return f20371o;
    }

    public int b(int i7) {
        o.o(i7, d());
        return this.f20372l[this.f20373m + i7];
    }

    public boolean c() {
        return this.f20374n == this.f20373m;
    }

    public int d() {
        return this.f20374n - this.f20373m;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (d() != fVar.d()) {
            return false;
        }
        for (int i7 = 0; i7 < d(); i7++) {
            if (b(i7) != fVar.b(i7)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iJ = 1;
        for (int i7 = this.f20373m; i7 < this.f20374n; i7++) {
            iJ = (iJ * 31) + g.j(this.f20372l[i7]);
        }
        return iJ;
    }

    public String toString() {
        if (c()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(d() * 5);
        sb.append('[');
        sb.append(this.f20372l[this.f20373m]);
        int i7 = this.f20373m;
        while (true) {
            i7++;
            if (i7 >= this.f20374n) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f20372l[i7]);
        }
    }

    public f(int[] iArr, int i7, int i8) {
        this.f20372l = iArr;
        this.f20373m = i7;
        this.f20374n = i8;
    }
}
