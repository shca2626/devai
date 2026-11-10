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
public final class C1287a {

    /* renamed from: a, reason: collision with root package name */
    public final s f19151a;

    /* renamed from: b, reason: collision with root package name */
    public final o f19152b;

    /* renamed from: c, reason: collision with root package name */
    public final SocketFactory f19153c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1288b f19154d;

    /* renamed from: e, reason: collision with root package name */
    public final List f19155e;

    /* renamed from: f, reason: collision with root package name */
    public final List f19156f;

    /* renamed from: g, reason: collision with root package name */
    public final ProxySelector f19157g;

    /* renamed from: h, reason: collision with root package name */
    public final Proxy f19158h;

    /* renamed from: i, reason: collision with root package name */
    public final SSLSocketFactory f19159i;

    /* renamed from: j, reason: collision with root package name */
    public final HostnameVerifier f19160j;

    /* renamed from: k, reason: collision with root package name */
    public final g f19161k;

    public C1287a(String str, int i7, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, InterfaceC1288b interfaceC1288b, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.f19151a = new s.a().q(sSLSocketFactory != null ? "https" : "http").e(str).l(i7).a();
        if (oVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f19152b = oVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f19153c = socketFactory;
        if (interfaceC1288b == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f19154d = interfaceC1288b;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f19155e = l6.c.r(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f19156f = l6.c.r(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f19157g = proxySelector;
        this.f19158h = proxy;
        this.f19159i = sSLSocketFactory;
        this.f19160j = hostnameVerifier;
        this.f19161k = gVar;
    }

    public g a() {
        return this.f19161k;
    }

    public List b() {
        return this.f19156f;
    }

    public o c() {
        return this.f19152b;
    }

    public boolean d(C1287a c1287a) {
        return this.f19152b.equals(c1287a.f19152b) && this.f19154d.equals(c1287a.f19154d) && this.f19155e.equals(c1287a.f19155e) && this.f19156f.equals(c1287a.f19156f) && this.f19157g.equals(c1287a.f19157g) && l6.c.o(this.f19158h, c1287a.f19158h) && l6.c.o(this.f19159i, c1287a.f19159i) && l6.c.o(this.f19160j, c1287a.f19160j) && l6.c.o(this.f19161k, c1287a.f19161k) && l().w() == c1287a.l().w();
    }

    public HostnameVerifier e() {
        return this.f19160j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1287a)) {
            return false;
        }
        C1287a c1287a = (C1287a) obj;
        return this.f19151a.equals(c1287a.f19151a) && d(c1287a);
    }

    public List f() {
        return this.f19155e;
    }

    public Proxy g() {
        return this.f19158h;
    }

    public InterfaceC1288b h() {
        return this.f19154d;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f19151a.hashCode()) * 31) + this.f19152b.hashCode()) * 31) + this.f19154d.hashCode()) * 31) + this.f19155e.hashCode()) * 31) + this.f19156f.hashCode()) * 31) + this.f19157g.hashCode()) * 31;
        Proxy proxy = this.f19158h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f19159i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f19160j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.f19161k;
        return iHashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public ProxySelector i() {
        return this.f19157g;
    }

    public SocketFactory j() {
        return this.f19153c;
    }

    public SSLSocketFactory k() {
        return this.f19159i;
    }

    public s l() {
        return this.f19151a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f19151a.l());
        sb.append(":");
        sb.append(this.f19151a.w());
        if (this.f19158h != null) {
            sb.append(", proxy=");
            sb.append(this.f19158h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f19157g);
        }
        sb.append("}");
        return sb.toString();
    }
}
