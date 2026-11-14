package k3;

import java.util.Objects;

/* loaded from: classes.dex */
public class W extends AbstractC1278v {

    /* renamed from: p, reason: collision with root package name */
    public static final AbstractC1278v f18889p = new W(new Object[0], 0);

    /* renamed from: n, reason: collision with root package name */
    public final transient Object[] f18890n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int f18891o;

    public W(Object[] objArr, int i7) {
        this.f18890n = objArr;
        this.f18891o = i7;
    }

    @Override // k3.AbstractC1278v, k3.AbstractC1276t
    public int g(Object[] objArr, int i7) {
        System.arraycopy(this.f18890n, 0, objArr, i7, this.f18891o);
        return i7 + this.f18891o;
    }

    @Override // java.util.List
    public Object get(int i7) {
        j3.o.o(i7, this.f18891o);
        Object obj = this.f18890n[i7];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // k3.AbstractC1276t
    public Object[] h() {
        return this.f18890n;
    }

    @Override // k3.AbstractC1276t
    public int i() {
        return this.f18891o;
    }

    @Override // k3.AbstractC1276t
    public int j() {
        return 0;
    }

    @Override // k3.AbstractC1276t
    public boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f18891o;
    }
}
