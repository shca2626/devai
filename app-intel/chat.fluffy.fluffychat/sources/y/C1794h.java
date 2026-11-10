package y;

import java.util.Arrays;
import z.AbstractC1826a;
import z5.C1877k;

/* renamed from: y.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1794h implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ boolean f23800l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ long[] f23801m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object[] f23802n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ int f23803o;

    public C1794h() {
        this(0, 1, null);
    }

    public void a() {
        int i7 = this.f23803o;
        Object[] objArr = this.f23802n;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f23803o = 0;
        this.f23800l = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1794h clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        M5.m.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C1794h c1794h = (C1794h) objClone;
        c1794h.f23801m = (long[]) this.f23801m.clone();
        c1794h.f23802n = (Object[]) this.f23802n.clone();
        return c1794h;
    }

    public Object c(long j7) {
        int iB = AbstractC1826a.b(this.f23801m, this.f23803o, j7);
        if (iB < 0 || this.f23802n[iB] == AbstractC1795i.f23804a) {
            return null;
        }
        return this.f23802n[iB];
    }

    public int f(long j7) {
        if (this.f23800l) {
            int i7 = this.f23803o;
            long[] jArr = this.f23801m;
            Object[] objArr = this.f23802n;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != AbstractC1795i.f23804a) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.f23800l = false;
            this.f23803o = i8;
        }
        return AbstractC1826a.b(this.f23801m, this.f23803o, j7);
    }

    public long g(int i7) {
        int i8;
        if (i7 < 0 || i7 >= (i8 = this.f23803o)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
        }
        if (this.f23800l) {
            long[] jArr = this.f23801m;
            Object[] objArr = this.f23802n;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != AbstractC1795i.f23804a) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.f23800l = false;
            this.f23803o = i9;
        }
        return this.f23801m[i7];
    }

    public void h(long j7, Object obj) {
        int iB = AbstractC1826a.b(this.f23801m, this.f23803o, j7);
        if (iB >= 0) {
            this.f23802n[iB] = obj;
            return;
        }
        int i7 = ~iB;
        if (i7 < this.f23803o && this.f23802n[i7] == AbstractC1795i.f23804a) {
            this.f23801m[i7] = j7;
            this.f23802n[i7] = obj;
            return;
        }
        if (this.f23800l) {
            int i8 = this.f23803o;
            long[] jArr = this.f23801m;
            if (i8 >= jArr.length) {
                Object[] objArr = this.f23802n;
                int i9 = 0;
                for (int i10 = 0; i10 < i8; i10++) {
                    Object obj2 = objArr[i10];
                    if (obj2 != AbstractC1795i.f23804a) {
                        if (i10 != i9) {
                            jArr[i9] = jArr[i10];
                            objArr[i9] = obj2;
                            objArr[i10] = null;
                        }
                        i9++;
                    }
                }
                this.f23800l = false;
                this.f23803o = i9;
                i7 = ~AbstractC1826a.b(this.f23801m, i9, j7);
            }
        }
        int i11 = this.f23803o;
        if (i11 >= this.f23801m.length) {
            int iF = AbstractC1826a.f(i11 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.f23801m, iF);
            M5.m.d(jArrCopyOf, "copyOf(this, newSize)");
            this.f23801m = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f23802n, iF);
            M5.m.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f23802n = objArrCopyOf;
        }
        int i12 = this.f23803o;
        if (i12 - i7 != 0) {
            long[] jArr2 = this.f23801m;
            int i13 = i7 + 1;
            C1877k.g(jArr2, jArr2, i13, i7, i12);
            Object[] objArr2 = this.f23802n;
            C1877k.h(objArr2, objArr2, i13, i7, this.f23803o);
        }
        this.f23801m[i7] = j7;
        this.f23802n[i7] = obj;
        this.f23803o++;
    }

    public void k(long j7) {
        int iB = AbstractC1826a.b(this.f23801m, this.f23803o, j7);
        if (iB < 0 || this.f23802n[iB] == AbstractC1795i.f23804a) {
            return;
        }
        this.f23802n[iB] = AbstractC1795i.f23804a;
        this.f23800l = true;
    }

    public void l(int i7) {
        if (this.f23802n[i7] != AbstractC1795i.f23804a) {
            this.f23802n[i7] = AbstractC1795i.f23804a;
            this.f23800l = true;
        }
    }

    public int m() {
        if (this.f23800l) {
            int i7 = this.f23803o;
            long[] jArr = this.f23801m;
            Object[] objArr = this.f23802n;
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                Object obj = objArr[i9];
                if (obj != AbstractC1795i.f23804a) {
                    if (i9 != i8) {
                        jArr[i8] = jArr[i9];
                        objArr[i8] = obj;
                        objArr[i9] = null;
                    }
                    i8++;
                }
            }
            this.f23800l = false;
            this.f23803o = i8;
        }
        return this.f23803o;
    }

    public Object n(int i7) {
        int i8;
        if (i7 < 0 || i7 >= (i8 = this.f23803o)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i7).toString());
        }
        if (this.f23800l) {
            long[] jArr = this.f23801m;
            Object[] objArr = this.f23802n;
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj = objArr[i10];
                if (obj != AbstractC1795i.f23804a) {
                    if (i10 != i9) {
                        jArr[i9] = jArr[i10];
                        objArr[i9] = obj;
                        objArr[i10] = null;
                    }
                    i9++;
                }
            }
            this.f23800l = false;
            this.f23803o = i9;
        }
        return this.f23802n[i7];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f23803o * 28);
        sb.append('{');
        int i7 = this.f23803o;
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

    public C1794h(int i7) {
        if (i7 == 0) {
            this.f23801m = AbstractC1826a.f24025b;
            this.f23802n = AbstractC1826a.f24026c;
        } else {
            int iF = AbstractC1826a.f(i7);
            this.f23801m = new long[iF];
            this.f23802n = new Object[iF];
        }
    }

    public /* synthetic */ C1794h(int i7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 10 : i7);
    }
}
