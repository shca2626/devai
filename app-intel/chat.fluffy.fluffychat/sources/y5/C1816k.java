package y5;

import java.io.Serializable;

/* renamed from: y5.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1816k implements InterfaceC1809d, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public L5.a f24007l;

    /* renamed from: m, reason: collision with root package name */
    public volatile Object f24008m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f24009n;

    public C1816k(L5.a aVar, Object obj) {
        M5.m.e(aVar, "initializer");
        this.f24007l = aVar;
        this.f24008m = C1822q.f24013a;
        this.f24009n = obj == null ? this : obj;
    }

    @Override // y5.InterfaceC1809d
    public boolean a() {
        return this.f24008m != C1822q.f24013a;
    }

    @Override // y5.InterfaceC1809d
    public Object getValue() {
        Object objD;
        Object obj = this.f24008m;
        C1822q c1822q = C1822q.f24013a;
        if (obj != c1822q) {
            return obj;
        }
        synchronized (this.f24009n) {
            objD = this.f24008m;
            if (objD == c1822q) {
                L5.a aVar = this.f24007l;
                M5.m.b(aVar);
                objD = aVar.d();
                this.f24008m = objD;
                this.f24007l = null;
            }
        }
        return objD;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C1816k(L5.a aVar, Object obj, int i7, M5.g gVar) {
        this(aVar, (i7 & 2) != 0 ? null : obj);
    }
}
