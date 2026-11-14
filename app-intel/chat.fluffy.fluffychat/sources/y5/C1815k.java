package y5;

import java.io.Serializable;

/* renamed from: y5.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1815k implements InterfaceC1808d, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public L5.a f24013l;

    /* renamed from: m, reason: collision with root package name */
    public volatile Object f24014m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f24015n;

    public C1815k(L5.a aVar, Object obj) {
        M5.m.e(aVar, "initializer");
        this.f24013l = aVar;
        this.f24014m = C1821q.f24019a;
        this.f24015n = obj == null ? this : obj;
    }

    @Override // y5.InterfaceC1808d
    public boolean a() {
        return this.f24014m != C1821q.f24019a;
    }

    @Override // y5.InterfaceC1808d
    public Object getValue() {
        Object objD;
        Object obj = this.f24014m;
        C1821q c1821q = C1821q.f24019a;
        if (obj != c1821q) {
            return obj;
        }
        synchronized (this.f24015n) {
            objD = this.f24014m;
            if (objD == c1821q) {
                L5.a aVar = this.f24013l;
                M5.m.b(aVar);
                objD = aVar.d();
                this.f24014m = objD;
                this.f24013l = null;
            }
        }
        return objD;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C1815k(L5.a aVar, Object obj, int i7, M5.g gVar) {
        this(aVar, (i7 & 2) != 0 ? null : obj);
    }
}
