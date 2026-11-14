package y;

import java.util.Arrays;
import z.AbstractC1825a;
import z5.C1880k;

/* loaded from: classes.dex */
public class l implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ boolean f23823l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ int[] f23824m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object[] f23825n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ int f23826o;

    public l() {
        this(0, 1, null);
    }

    public void a(int i7, Object obj) {
        int i8 = this.f23826o;
        if (i8 != 0 && i7 <= this.f23824m[i8 - 1]) {
            k(i7, obj);
            return;
        }
        if (this.f23823l && i8 >= this.f23824m.length) {
            m.e(this);
        }
        int i9 = this.f23826o;
        if (i9 >= this.f23824m.length) {
            int iE = AbstractC1825a.e(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23824m, iE);
            M5.m.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f23824m = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23825n, iE);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23825n = objArrCopyOf;
        }
        this.f23824m[i9] = i7;
        this.f23825n[i9] = obj;
        this.f23826o = i9 + 1;
    }

    public void b() {
        int i7 = this.f23826o;
        Object[] objArr = this.f23825n;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f23826o = 0;
        this.f23823l = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        M5.m.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        l lVar = (l) objClone;
        lVar.f23824m = (int[]) this.f23824m.clone();
        lVar.f23825n = (Object[]) this.f23825n.clone();
        return lVar;
    }

    public Object f(int i7) {
        return m.c(this, i7);
    }

    public int g(Object obj) {
        if (this.f23823l) {
            m.e(this);
        }
        int i7 = this.f23826o;
        for (int i8 = 0; i8 < i7; i8++) {
            if (this.f23825n[i8] == obj) {
                return i8;
            }
        }
        return -1;
    }

    public int h(int i7) {
        if (this.f23823l) {
            m.e(this);
        }
        return this.f23824m[i7];
    }

    public void k(int i7, Object obj) {
        int iA = AbstractC1825a.a(this.f23824m, this.f23826o, i7);
        if (iA >= 0) {
            this.f23825n[iA] = obj;
            return;
        }
        int i8 = ~iA;
        if (i8 < this.f23826o && this.f23825n[i8] == m.f23827a) {
            this.f23824m[i8] = i7;
            this.f23825n[i8] = obj;
            return;
        }
        if (this.f23823l && this.f23826o >= this.f23824m.length) {
            m.e(this);
            i8 = ~AbstractC1825a.a(this.f23824m, this.f23826o, i7);
        }
        int i9 = this.f23826o;
        if (i9 >= this.f23824m.length) {
            int iE = AbstractC1825a.e(i9 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.f23824m, iE);
            M5.m.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f23824m = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23825n, iE);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23825n = objArrCopyOf;
        }
        int i10 = this.f23826o;
        if (i10 - i8 != 0) {
            int[] iArr = this.f23824m;
            int i11 = i8 + 1;
            C1880k.f(iArr, iArr, i11, i8, i10);
            Object[] objArr = this.f23825n;
            C1880k.h(objArr, objArr, i11, i8, this.f23826o);
        }
        this.f23824m[i8] = i7;
        this.f23825n[i8] = obj;
        this.f23826o++;
    }

    public void l(int i7) {
        m.d(this, i7);
    }

    public void m(int i7) {
        if (this.f23825n[i7] != m.f23827a) {
            this.f23825n[i7] = m.f23827a;
            this.f23823l = true;
        }
    }

    public int n() {
        if (this.f23823l) {
            m.e(this);
        }
        return this.f23826o;
    }

    public Object o(int i7) {
        if (this.f23823l) {
            m.e(this);
        }
        return this.f23825n[i7];
    }

    public String toString() {
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f23826o * 28);
        sb.append('{');
        int i7 = this.f23826o;
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
            this.f23824m = AbstractC1825a.f24030a;
            this.f23825n = AbstractC1825a.f24032c;
        } else {
            int iE = AbstractC1825a.e(i7);
            this.f23824m = new int[iE];
            this.f23825n = new Object[iE];
        }
    }

    public /* synthetic */ l(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 10 : i7);
    }
}
