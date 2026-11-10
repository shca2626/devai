package k3;

/* loaded from: classes.dex */
public final class Z extends AbstractC1258B {

    /* renamed from: s, reason: collision with root package name */
    public static final Object[] f18912s;

    /* renamed from: t, reason: collision with root package name */
    public static final Z f18913t;

    /* renamed from: n, reason: collision with root package name */
    public final transient Object[] f18914n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int f18915o;

    /* renamed from: p, reason: collision with root package name */
    public final transient Object[] f18916p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f18917q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f18918r;

    static {
        Object[] objArr = new Object[0];
        f18912s = objArr;
        f18913t = new Z(objArr, 0, objArr, 0, 0);
    }

    public Z(Object[] objArr, int i7, Object[] objArr2, int i8, int i9) {
        this.f18914n = objArr;
        this.f18915o = i7;
        this.f18916p = objArr2;
        this.f18917q = i8;
        this.f18918r = i9;
    }

    @Override // k3.AbstractC1277t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f18916p;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iC = AbstractC1276s.c(obj);
        while (true) {
            int i7 = iC & this.f18917q;
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

    @Override // k3.AbstractC1277t
    public int g(Object[] objArr, int i7) {
        System.arraycopy(this.f18914n, 0, objArr, i7, this.f18918r);
        return i7 + this.f18918r;
    }

    @Override // k3.AbstractC1277t
    public Object[] h() {
        return this.f18914n;
    }

    @Override // k3.AbstractC1258B, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f18915o;
    }

    @Override // k3.AbstractC1277t
    public int i() {
        return this.f18918r;
    }

    @Override // k3.AbstractC1277t
    public int j() {
        return 0;
    }

    @Override // k3.AbstractC1277t
    public boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: l */
    public h0 iterator() {
        return f().iterator();
    }

    @Override // k3.AbstractC1258B
    public AbstractC1279v s() {
        return AbstractC1279v.n(this.f18914n, this.f18918r);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f18918r;
    }

    @Override // k3.AbstractC1258B
    public boolean t() {
        return true;
    }
}
