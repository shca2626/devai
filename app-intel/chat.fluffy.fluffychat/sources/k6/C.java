package k6;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes3.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public final C1287a f19141a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f19142b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f19143c;

    public C(C1287a c1287a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c1287a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f19141a = c1287a;
        this.f19142b = proxy;
        this.f19143c = inetSocketAddress;
    }

    public C1287a a() {
        return this.f19141a;
    }

    public Proxy b() {
        return this.f19142b;
    }

    public boolean c() {
        return this.f19141a.f19159i != null && this.f19142b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f19143c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C)) {
            return false;
        }
        C c7 = (C) obj;
        return c7.f19141a.equals(this.f19141a) && c7.f19142b.equals(this.f19142b) && c7.f19143c.equals(this.f19143c);
    }

    public int hashCode() {
        return ((((527 + this.f19141a.hashCode()) * 31) + this.f19142b.hashCode()) * 31) + this.f19143c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f19143c + "}";
    }
}
