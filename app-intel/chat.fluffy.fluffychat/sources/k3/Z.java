package k3;

/* loaded from: classes.dex */
public final class Z extends AbstractC1257B {

    /* renamed from: s, reason: collision with root package name */
    public static final Object[] f18911s;

    /* renamed from: t, reason: collision with root package name */
    public static final Z f18912t;

    /* renamed from: n, reason: collision with root package name */
    public final transient Object[] f18913n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int f18914o;

    /* renamed from: p, reason: collision with root package name */
    public final transient Object[] f18915p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f18916q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f18917r;

    static {
        Object[] objArr = new Object[0];
        f18911s = objArr;
        f18912t = new Z(objArr, 0, objArr, 0, 0);
    }

    public Z(Object[] objArr, int i7, Object[] objArr2, int i8, int i9) {
        this.f18913n = objArr;
        this.f18914o = i7;
        this.f18915p = objArr2;
        this.f18916q = i8;
        this.f18917r = i9;
    }

    @Override // k3.AbstractC1276t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f18915p;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iC = AbstractC1275s.c(obj);
        while (true) {
            int i7 = iC & this.f18916q;
            Object obj2 = objArr[i7];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iC = i7 + 1;
        }
    }

    @Override // k3.AbstractC1276t
    public int g(Object[] objArr, int i7) {
        System.arraycopy(this.f18913n, 0, objArr, i7, this.f18917r);
        return i7 + this.f18917r;
    }

    @Override // k3.AbstractC1276t
    public Object[] h() {
        return this.f18913n;
    }

    @Override // k3.AbstractC1257B, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f18914o;
    }

    @Override // k3.AbstractC1276t
    public int i() {
        return this.f18917r;
    }

    @Override // k3.AbstractC1276t
    public int j() {
        return 0;
    }

    @Override // k3.AbstractC1276t
    public boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: l */
    public h0 iterator() {
        return f().iterator();
    }

    @Override // k3.AbstractC1257B
    public AbstractC1278v s() {
        return AbstractC1278v.n(this.f18913n, this.f18917r);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f18917r;
    }

    @Override // k3.AbstractC1257B
    public boolean t() {
        return true;
    }
}
