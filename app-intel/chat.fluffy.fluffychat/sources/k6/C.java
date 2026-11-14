package k6;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes3.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public final C1286a f19140a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f19141b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f19142c;

    public C(C1286a c1286a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c1286a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f19140a = c1286a;
        this.f19141b = proxy;
        this.f19142c = inetSocketAddress;
    }

    public C1286a a() {
        return this.f19140a;
    }

    public Proxy b() {
        return this.f19141b;
    }

    public boolean c() {
        return this.f19140a.f19158i != null && this.f19141b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f19142c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C)) {
            return false;
        }
        C c7 = (C) obj;
        return c7.f19140a.equals(this.f19140a) && c7.f19141b.equals(this.f19141b) && c7.f19142c.equals(this.f19142c);
    }

    public int hashCode() {
        return ((((527 + this.f19140a.hashCode()) * 31) + this.f19141b.hashCode()) * 31) + this.f19142c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f19142c + "}";
    }
}
