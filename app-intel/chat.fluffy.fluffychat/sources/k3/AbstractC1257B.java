package k3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import k3.AbstractC1276t;

/* renamed from: k3.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1257B extends AbstractC1276t implements Set {

    /* renamed from: m, reason: collision with root package name */
    public transient AbstractC1278v f18832m;

    /* renamed from: k3.B$a */
    public static class a extends AbstractC1276t.a {

        /* renamed from: d, reason: collision with root package name */
        public Object[] f18833d;

        /* renamed from: e, reason: collision with root package name */
        public int f18834e;

        public a() {
            super(4);
        }

        @Override // k3.AbstractC1276t.b
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            j3.o.q(obj);
            if (this.f18833d != null && AbstractC1257B.o(this.f19014b) <= this.f18833d.length) {
                k(obj);
                return this;
            }
            this.f18833d = null;
            super.d(obj);
            return this;
        }

        public a i(Object... objArr) {
            if (this.f18833d == null) {
                super.e(objArr);
                return this;
            }
            for (Object obj : objArr) {
                a(obj);
            }
            return this;
        }

        public a j(Iterable iterable) {
            j3.o.q(iterable);
            if (this.f18833d == null) {
                super.b(iterable);
                return this;
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public final void k(Object obj) {
            Objects.requireNonNull(this.f18833d);
            int length = this.f18833d.length - 1;
            int iHashCode = obj.hashCode();
            int iB = AbstractC1275s.b(iHashCode);
            while (true) {
                int i7 = iB & length;
                Object[] objArr = this.f18833d;
                Object obj2 = objArr[i7];
                if (obj2 == null) {
                    objArr[i7] = obj;
                    this.f18834e += iHashCode;
                    super.d(obj);
                    return;
                } else if (obj2.equals(obj)) {
                    return;
                } else {
                    iB = i7 + 1;
                }
            }
        }

        public AbstractC1257B l() {
            AbstractC1257B abstractC1257BP;
            int i7 = this.f19014b;
            if (i7 == 0) {
                return AbstractC1257B.u();
            }
            if (i7 == 1) {
                Object obj = this.f19013a[0];
                Objects.requireNonNull(obj);
                return AbstractC1257B.v(obj);
            }
            if (this.f18833d == null || AbstractC1257B.o(i7) != this.f18833d.length) {
                abstractC1257BP = AbstractC1257B.p(this.f19014b, this.f19013a);
                this.f19014b = abstractC1257BP.size();
            } else {
                Object[] objArrCopyOf = AbstractC1257B.z(this.f19014b, this.f19013a.length) ? Arrays.copyOf(this.f19013a, this.f19014b) : this.f19013a;
                abstractC1257BP = new Z(objArrCopyOf, this.f18834e, this.f18833d, r5.length - 1, this.f19014b);
            }
            this.f19015c = true;
            this.f18833d = null;
            return abstractC1257BP;
        }
    }

    public static int o(int i7) {
        int iMax = Math.max(i7, 2);
        if (iMax >= 751619276) {
            j3.o.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static AbstractC1257B p(int i7, Object... objArr) {
        if (i7 == 0) {
            return u();
        }
        if (i7 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return v(obj);
        }
        int iO = o(i7);
        Object[] objArr2 = new Object[iO];
        int i8 = iO - 1;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i7; i11++) {
            Object objA = S.a(objArr[i11], i11);
            int iHashCode = objA.hashCode();
            int iB = AbstractC1275s.b(iHashCode);
            while (true) {
                int i12 = iB & i8;
                Object obj2 = objArr2[i12];
                if (obj2 == null) {
                    objArr[i10] = objA;
                    objArr2[i12] = objA;
                    i9 += iHashCode;
                    i10++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i10, i7, (Object) null);
        if (i10 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new e0(obj3);
        }
        if (o(i10) < iO / 2) {
            return p(i10, objArr);
        }
        if (z(i10, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i10);
        }
        return new Z(objArr, i9, objArr2, i8, i10);
    }

    public static AbstractC1257B q(Collection collection) {
        if ((collection instanceof AbstractC1257B) && !(collection instanceof SortedSet)) {
            AbstractC1257B abstractC1257B = (AbstractC1257B) collection;
            if (!abstractC1257B.k()) {
                return abstractC1257B;
            }
        }
        Object[] array = collection.toArray();
        return p(array.length, array);
    }

    public static AbstractC1257B r(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? p(objArr.length, (Object[]) objArr.clone()) : v(objArr[0]) : u();
    }

    public static AbstractC1257B u() {
        return Z.f18912t;
    }

    public static AbstractC1257B v(Object obj) {
        return new e0(obj);
    }

    public static AbstractC1257B w(Object obj, Object obj2) {
        return p(2, obj, obj2);
    }

    public static AbstractC1257B x(Object obj, Object obj2, Object obj3) {
        return p(3, obj, obj2, obj3);
    }

    public static AbstractC1257B y(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return p(5, obj, obj2, obj3, obj4, obj5);
    }

    public static boolean z(int i7, int i8) {
        return i7 < (i8 >> 1) + (i8 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC1257B) && t() && ((AbstractC1257B) obj).t() && hashCode() != obj.hashCode()) {
            return false;
        }
        return d0.a(this, obj);
    }

    @Override // k3.AbstractC1276t
    public AbstractC1278v f() {
        AbstractC1278v abstractC1278v = this.f18832m;
        if (abstractC1278v != null) {
            return abstractC1278v;
        }
        AbstractC1278v abstractC1278vS = s();
        this.f18832m = abstractC1278vS;
        return abstractC1278vS;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return d0.d(this);
    }

    @Override // k3.AbstractC1276t
    /* renamed from: l */
    public abstract h0 iterator();

    public AbstractC1278v s() {
        return AbstractC1278v.m(toArray());
    }

    public boolean t() {
        return false;
    }
}
