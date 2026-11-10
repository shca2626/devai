package k3;

/* loaded from: classes.dex */
public final class e0 extends AbstractC1258B {

    /* renamed from: n, reason: collision with root package name */
    public final transient Object f18969n;

    public e0(Object obj) {
        this.f18969n = j3.o.q(obj);
    }

    @Override // k3.AbstractC1277t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f18969n.equals(obj);
    }

    @Override // k3.AbstractC1258B, k3.AbstractC1277t
    public AbstractC1279v f() {
        return AbstractC1279v.w(this.f18969n);
    }

    @Override // k3.AbstractC1277t
    public int g(Object[] objArr, int i7) {
        objArr[i7] = this.f18969n;
        return i7 + 1;
    }

    @Override // k3.AbstractC1258B, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f18969n.hashCode();
    }

    @Override // k3.AbstractC1277t
    public boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: l */
    public h0 iterator() {
        return E.s(this.f18969n);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f18969n.toString() + ']';
    }
}
