package y;

import java.util.Arrays;
import z.AbstractC1826a;
import z5.C1877k;

/* loaded from: classes.dex */
public class l implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ boolean f23817l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ int[] f23818m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object[] f23819n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ int f23820o;

    public l() {
        this(0, 1, null);
    }

    public void a(int i7, Object obj) {
        int i8 = this.f23820o;
        if (i8 != 0 && i7 <= this.f23818m[i8 - 1]) {
            k(i7, obj);
            return;
        }
        if (this.f23817l && i8 >= this.f23818m.length) {
            m.e(this);
        }
        int i9 = this.f23820o;
        if (i9 >= this.f23818m.length) {
            int iE = AbstractC1826a.e(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23818m, iE);
            M5.m.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f23818m = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23819n, iE);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23819n = objArrCopyOf;
        }
        this.f23818m[i9] = i7;
        this.f23819n[i9] = obj;
        this.f23820o = i9 + 1;
    }

    public void b() {
        int i7 = this.f23820o;
        Object[] objArr = this.f23819n;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f23820o = 0;
        this.f23817l = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        M5.m.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        l lVar = (l) objClone;
        lVar.f23818m = (int[]) this.f23818m.clone();
        lVar.f23819n = (Object[]) this.f23819n.clone();
        return lVar;
    }

    public Object f(int i7) {
        return m.c(this, i7);
    }

    public int g(Object obj) {
        if (this.f23817l) {
            m.e(this);
        }
        int i7 = this.f23820o;
        for (int i8 = 0; i8 < i7; i8++) {
            if (this.f23819n[i8] == obj) {
                return i8;
            }
        }
        return -1;
    }

    public int h(int i7) {
        if (this.f23817l) {
            m.e(this);
        }
        return this.f23818m[i7];
    }

    public void k(int i7, Object obj) {
        int iA = AbstractC1826a.a(this.f23818m, this.f23820o, i7);
        if (iA >= 0) {
            this.f23819n[iA] = obj;
            return;
        }
        int i8 = ~iA;
        if (i8 < this.f23820o && this.f23819n[i8] == m.f23821a) {
            this.f23818m[i8] = i7;
            this.f23819n[i8] = obj;
            return;
        }
        if (this.f23817l && this.f23820o >= this.f23818m.length) {
            m.e(this);
            i8 = ~AbstractC1826a.a(this.f23818m, this.f23820o, i7);
        }
        int i9 = this.f23820o;
        if (i9 >= this.f23818m.length) {
            int iE = AbstractC1826a.e(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23818m, iE);
            M5.m.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f23818m = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23819n, iE);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23819n = objArrCopyOf;
        }
        int i10 = this.f23820o;
        if (i10 - i8 != 0) {
            int[] iArr = this.f23818m;
            int i11 = i8 + 1;
            C1877k.f(iArr, iArr, i11, i8, i10);
            Object[] objArr = this.f23819n;
            C1877k.h(objArr, objArr, i11, i8, this.f23820o);
        }
        this.f23818m[i8] = i7;
        this.f23819n[i8] = obj;
        this.f23820o++;
    }

    public void l(int i7) {
        m.d(this, i7);
    }

    public void m(int i7) {
        if (this.f23819n[i7] != m.f23821a) {
            this.f23819n[i7] = m.f23821a;
            this.f23817l = true;
        }
    }

    public int n() {
        if (this.f23817l) {
            m.e(this);
        }
        return this.f23820o;
    }

    public Object o(int i7) {
        if (this.f23817l) {
            m.e(this);
        }
        return this.f23819n[i7];
    }

    public String toString() {
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f23820o * 28);
        sb.append('{');
        int i7 = this.f23820o;
        for (int i8 = 0; i8 < i7; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(h(i8));
            sb.append('=');
            Object objO = o(i8);
            if (objO != this) {
                sb.append(objO);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        M5.m.d(string, "buffer.toString()");
        return string;
    }

    public l(int i7) {
        if (i7 == 0) {
            this.f23818m = AbstractC1826a.f24024a;
            this.f23819n = AbstractC1826a.f24026c;
        } else {
            int iE = AbstractC1826a.e(i7);
            this.f23818m = new int[iE];
            this.f23819n = new Object[iE];
        }
    }

    public /* synthetic */ l(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 10 : i7);
    }
}
