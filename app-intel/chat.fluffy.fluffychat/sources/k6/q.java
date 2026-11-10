package k6;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final D f19392a;

    /* renamed from: b, reason: collision with root package name */
    public final h f19393b;

    /* renamed from: c, reason: collision with root package name */
    public final List f19394c;

    /* renamed from: d, reason: collision with root package name */
    public final List f19395d;

    public q(D d7, h hVar, List list, List list2) {
        this.f19392a = d7;
        this.f19393b = hVar;
        this.f19394c = list;
        this.f19395d = list2;
    }

    public static q b(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        h hVarA = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        D dA = D.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listS = peerCertificates != null ? l6.c.s(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new q(dA, hVarA, listS, localCertificates != null ? l6.c.s(localCertificates) : Collections.EMPTY_LIST);
    }

    public static q c(D d7, h hVar, List list, List list2) {
        if (d7 == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (hVar != null) {
            return new q(d7, hVar, l6.c.r(list), l6.c.r(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    public h a() {
        return this.f19393b;
    }

    public List d() {
        return this.f19395d;
    }

    public List e() {
        return this.f19394c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f19392a.equals(qVar.f19392a) && this.f19393b.equals(qVar.f19393b) && this.f19394c.equals(qVar.f19394c) && this.f19395d.equals(qVar.f19395d);
    }

    public D f() {
        return this.f19392a;
    }

    public int hashCode() {
        return ((((((527 + this.f19392a.hashCode()) * 31) + this.f19393b.hashCode()) * 31) + this.f19394c.hashCode()) * 31) + this.f19395d.hashCode();
    }
}
