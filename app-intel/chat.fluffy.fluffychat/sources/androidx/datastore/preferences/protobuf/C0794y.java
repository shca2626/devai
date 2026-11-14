package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0794y {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC0776f f12268a;

    /* renamed from: b, reason: collision with root package name */
    public C0783m f12269b;

    /* renamed from: c, reason: collision with root package name */
    public volatile K f12270c;

    /* renamed from: d, reason: collision with root package name */
    public volatile AbstractC0776f f12271d;

    public void a(K k7) {
        if (this.f12270c != null) {
            return;
        }
        synchronized (this) {
            if (this.f12270c != null) {
                return;
            }
            try {
                if (this.f12268a != null) {
                    this.f12270c = (K) k7.k().a(this.f12268a, this.f12269b);
                    this.f12271d = this.f12268a;
                } else {
                    this.f12270c = k7;
                    this.f12271d = AbstractC0776f.f12025m;
                }
            } catch (C0791v unused) {
                this.f12270c = k7;
                this.f12271d = AbstractC0776f.f12025m;
            }
        }
    }

    public int b() {
        if (this.f12271d != null) {
            return this.f12271d.size();
        }
        AbstractC0776f abstractC0776f = this.f12268a;
        if (abstractC0776f != null) {
            return abstractC0776f.size();
        }
        if (this.f12270c != null) {
            return this.f12270c.f();
        }
        return 0;
    }

    public K c(K k7) {
        a(k7);
        return this.f12270c;
    }

    public AbstractC0776f d() {
        if (this.f12271d != null) {
            return this.f12271d;
        }
        AbstractC0776f abstractC0776f = this.f12268a;
        if (abstractC0776f != null) {
            return abstractC0776f;
        }
        synchronized (this) {
            try {
                if (this.f12271d != null) {
                    return this.f12271d;
                }
                if (this.f12270c == null) {
                    this.f12271d = AbstractC0776f.f12025m;
                } else {
                    this.f12271d = this.f12270c.c();
                }
                return this.f12271d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0794y)) {
            return false;
        }
        C0794y c0794y = (C0794y) obj;
        K k7 = this.f12270c;
        K k8 = c0794y.f12270c;
        return (k7 == null && k8 == null) ? d().equals(c0794y.d()) : (k7 == null || k8 == null) ? k7 != null ? k7.equals(c0794y.c(k7.b())) : c(k8.b()).equals(k8) : k7.equals(k8);
    }

    public int hashCode() {
        return 1;
    }
}
