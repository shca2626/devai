package k6;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import k6.s;

/* renamed from: k6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1286a {

    /* renamed from: a, reason: collision with root package name */
    public final s f19150a;

    /* renamed from: b, reason: collision with root package name */
    public final o f19151b;

    /* renamed from: c, reason: collision with root package name */
    public final SocketFactory f19152c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1287b f19153d;

    /* renamed from: e, reason: collision with root package name */
    public final List f19154e;

    /* renamed from: f, reason: collision with root package name */
    public final List f19155f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f19156g;

    /* renamed from: h, reason: collision with root package name */
    public final Proxy f19157h;

    /* renamed from: i, reason: collision with root package name */
    public final SSLSocketFactory f19158i;

    /* renamed from: j, reason: collision with root package name */
    public final HostnameVerifier f19159j;

    /* renamed from: k, reason: collision with root package name */
    public final g f19160k;

    public C1286a(String str, int i7, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, InterfaceC1287b interfaceC1287b, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.f19150a = new s.a().q(sSLSocketFactory != null ? "https" : "http").e(str).l(i7).a();
        if (oVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f19151b = oVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f19152c = socketFactory;
        if (interfaceC1287b == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f19153d = interfaceC1287b;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f19154e = l6.c.r(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f19155f = l6.c.r(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f19156g = proxySelector;
        this.f19157h = proxy;
        this.f19158i = sSLSocketFactory;
        this.f19159j = hostnameVerifier;
        this.f19160k = gVar;
    }

    public g a() {
        return this.f19160k;
    }

    public List b() {
        return this.f19155f;
    }

    public o c() {
        return this.f19151b;
    }

    public boolean d(C1286a c1286a) {
        return this.f19151b.equals(c1286a.f19151b) && this.f19153d.equals(c1286a.f19153d) && this.f19154e.equals(c1286a.f19154e) && this.f19155f.equals(c1286a.f19155f) && this.f19156g.equals(c1286a.f19156g) && l6.c.o(this.f19157h, c1286a.f19157h) && l6.c.o(this.f19158i, c1286a.f19158i) && l6.c.o(this.f19159j, c1286a.f19159j) && l6.c.o(this.f19160k, c1286a.f19160k) && l().w() == c1286a.l().w();
    }

    public HostnameVerifier e() {
        return this.f19159j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1286a)) {
            return false;
        }
        C1286a c1286a = (C1286a) obj;
        return this.f19150a.equals(c1286a.f19150a) && d(c1286a);
    }

    public List f() {
        return this.f19154e;
    }

    public Proxy g() {
        return this.f19157h;
    }

    public InterfaceC1287b h() {
        return this.f19153d;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f19150a.hashCode()) * 31) + this.f19151b.hashCode()) * 31) + this.f19153d.hashCode()) * 31) + this.f19154e.hashCode()) * 31) + this.f19155f.hashCode()) * 31) + this.f19156g.hashCode()) * 31;
        Proxy proxy = this.f19157h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f19158i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f19159j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.f19160k;
        return iHashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public ProxySelector i() {
        return this.f19156g;
    }

    public SocketFactory j() {
        return this.f19152c;
    }

    public SSLSocketFactory k() {
        return this.f19158i;
    }

    public s l() {
        return this.f19150a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f19150a.l());
        sb.append(":");
        sb.append(this.f19150a.w());
        if (this.f19157h != null) {
            sb.append(", proxy=");
            sb.append(this.f19157h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f19156g);
        }
        sb.append("}");
        return sb.toString();
    }
}
