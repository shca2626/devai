package k6;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f19219c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public final Set f19220a;

    /* renamed from: b, reason: collision with root package name */
    public final u6.c f19221b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f19222a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f19222a), null);
        }
    }

    public g(Set set, u6.c cVar) {
        this.f19220a = set;
        this.f19221b = cVar;
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + d((X509Certificate) certificate).a();
    }

    public static v6.h d(X509Certificate x509Certificate) {
        return v6.h.s(x509Certificate.getPublicKey().getEncoded()).x();
    }

    public void a(String str, List list) {
        List listB = b(str);
        if (listB.isEmpty()) {
            return;
        }
        u6.c cVar = this.f19221b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (listB.size() > 0) {
                android.support.v4.media.session.b.a(listB.get(0));
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i8 = 0; i8 < size2; i8++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i8);
            sb.append("\n    ");
            sb.append(c(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size3 = listB.size();
        for (int i9 = 0; i9 < size3; i9++) {
            android.support.v4.media.session.b.a(listB.get(i9));
            sb.append("\n    ");
            sb.append((Object) null);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List b(String str) {
        List list = Collections.EMPTY_LIST;
        Iterator it = this.f19220a.iterator();
        if (!it.hasNext()) {
            return list;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }

    public g e(u6.c cVar) {
        return l6.c.o(this.f19221b, cVar) ? this : new g(this.f19220a, cVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return l6.c.o(this.f19221b, gVar.f19221b) && this.f19220a.equals(gVar.f19220a);
    }

    public int hashCode() {
        u6.c cVar = this.f19221b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f19220a.hashCode();
    }
}
