package y;

import java.util.Arrays;
import z.AbstractC1825a;
import z5.C1880k;

/* renamed from: y.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1793h implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ boolean f23806l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ long[] f23807m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object[] f23808n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ int f23809o;

    public C1793h() {
        this(0, 1, null);
    }

    public void a() {
        int i7 = this.f23809o;
        Object[] objArr = this.f23808n;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f23809o = 0;
        this.f23806l = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1793h clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        M5.m.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C1793h c1793h = (C1793h) objClone;
        c1793h.f23807m = (long[]) this.f23807m.clone();
        c1793h.f23808n = (Object[]) this.f23808n.clone();
        return c1793h;
    }

    public Object c(long j7) {
        int iB = AbstractC1825a.b(this.f23807m, this.f23809o, j7);
        if (iB < 0 || this.f23808n[iB] == AbstractC1794i.f23810a) {
            return null;
        }
        return this.f23808n[iB];
    }

    public int f(long j7) {
        if (this.f23806l) {
            int i7 = this.f23809o;
            long[] jArr = this.f23807m;
            Object[] objArr = this.f23808n;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != AbstractC1794i.f23810a) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.f23806l = false;
            this.f23809o = i8;
        }
        return AbstractC1825a.b(this.f23807m, this.f23809o, j7);
    }

    public long g(int i7) {
        int i8;
        if (i7 < 0 || i7 >= (i8 = this.f23809o)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
        }
        if (this.f23806l) {
            long[] jArr = this.f23807m;
            Object[] objArr = this.f23808n;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != AbstractC1794i.f23810a) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.f23806l = false;
            this.f23809o = i9;
        }
        return this.f23807m[i7];
    }

    public void h(long j7, Object obj) {
        int iB = AbstractC1825a.b(this.f23807m, this.f23809o, j7);
        if (iB >= 0) {
            this.f23808n[iB] = obj;
            return;
        }
        int i7 = ~iB;
        if (i7 < this.f23809o && this.f23808n[i7] == AbstractC1794i.f23810a) {
            this.f23807m[i7] = j7;
            this.f23808n[i7] = obj;
            return;
        }
        if (this.f23806l) {
            int i8 = this.f23809o;
            long[] jArr = this.f23807m;
            if (i8 >= jArr.length) {
                Object[] objArr = this.f23808n;
                int i9 = 0;
                for (int i10 = 0; i10 < i8; i10++) {
                    Object obj2 = objArr[i10];
                    if (obj2 != AbstractC1794i.f23810a) {
                        if (i10 != i9) {
                            jArr[i9] = jArr[i10];
                            objArr[i9] = obj2;
                            objArr[i10] = null;
                        }
                        i9++;
                    }
                }
                this.f23806l = false;
                this.f23809o = i9;
                i7 = ~AbstractC1825a.b(this.f23807m, i9, j7);
            }
        }
        int i11 = this.f23809o;
        if (i11 >= this.f23807m.length) {
            int iF = AbstractC1825a.f(i11 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f23807m, iF);
            M5.m.d(jArrCopyOf, "copyOf(this, newSize)");
            this.f23807m = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23808n, iF);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23808n = objArrCopyOf;
        }
        int i12 = this.f23809o;
        if (i12 - i7 != 0) {
            long[] jArr2 = this.f23807m;
            int i13 = i7 + 1;
            C1880k.g(jArr2, jArr2, i13, i7, i12);
            Object[] objArr2 = this.f23808n;
            C1880k.h(objArr2, objArr2, i13, i7, this.f23809o);
        }
        this.f23807m[i7] = j7;
        this.f23808n[i7] = obj;
        this.f23809o++;
    }

    public void k(long j7) {
        int iB = AbstractC1825a.b(this.f23807m, this.f23809o, j7);
        if (iB < 0 || this.f23808n[iB] == AbstractC1794i.f23810a) {
            return;
        }
        this.f23808n[iB] = AbstractC1794i.f23810a;
        this.f23806l = true;
    }

    public void l(int i7) {
        if (this.f23808n[i7] != AbstractC1794i.f23810a) {
            this.f23808n[i7] = AbstractC1794i.f23810a;
            this.f23806l = true;
        }
    }

    public int m() {
        if (this.f23806l) {
            int i7 = this.f23809o;
            long[] jArr = this.f23807m;
            Object[] objArr = this.f23808n;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != AbstractC1794i.f23810a) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.f23806l = false;
            this.f23809o = i8;
        }
        return this.f23809o;
    }

    public Object n(int i7) {
        int i8;
        if (i7 < 0 || i7 >= (i8 = this.f23809o)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
        }
        if (this.f23806l) {
            long[] jArr = this.f23807m;
            Object[] objArr = this.f23808n;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != AbstractC1794i.f23810a) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.f23806l = false;
            this.f23809o = i9;
        }
        return this.f23808n[i7];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f23809o * 28);
        sb.append('{');
        int i7 = this.f23809o;
        for (int i8 = 0; i8 < i7; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(g(i8));
            sb.append('=');
            Object objN = n(i8);
            if (objN != sb) {
                sb.append(objN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        M5.m.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public C1793h(int i7) {
        if (i7 == 0) {
            this.f23807m = AbstractC1825a.f24031b;
            this.f23808n = AbstractC1825a.f24032c;
        } else {
            int iF = AbstractC1825a.f(i7);
            this.f23807m = new long[iF];
            this.f23808n = new Object[iF];
        }
    }

    public /* synthetic */ C1793h(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 10 : i7);
    }
}
