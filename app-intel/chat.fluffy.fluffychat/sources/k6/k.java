package k6;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    public static final h[] f19354e;

    /* renamed from: f, reason: collision with root package name */
    public static final h[] f19355f;

    /* renamed from: g, reason: collision with root package name */
    public static final k f19356g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f19357h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f19358i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f19359j;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19360a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19361b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f19362c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f19363d;

    static {
        h hVar = h.f19316n1;
        h hVar2 = h.f19319o1;
        h hVar3 = h.f19322p1;
        h hVar4 = h.f19325q1;
        h hVar5 = h.f19328r1;
        h hVar6 = h.f19275Z0;
        h hVar7 = h.f19286d1;
        h hVar8 = h.f19277a1;
        h hVar9 = h.f19289e1;
        h hVar10 = h.f19307k1;
        h hVar11 = h.f19304j1;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11};
        f19354e = hVarArr;
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, h.f19245K0, h.f19247L0, h.f19300i0, h.f19303j0, h.f19236G, h.f19244K, h.f19305k};
        f19355f = hVarArr2;
        a aVarC = new a(true).c(hVarArr);
        D d7 = D.TLS_1_3;
        D d8 = D.TLS_1_2;
        f19356g = aVarC.f(d7, d8).d(true).a();
        a aVarC2 = new a(true).c(hVarArr2);
        D d9 = D.TLS_1_1;
        D d10 = D.TLS_1_0;
        f19357h = aVarC2.f(d7, d8, d9, d10).d(true).a();
        f19358i = new a(true).c(hVarArr2).f(d10).d(true).a();
        f19359j = new a(false).a();
    }

    public k(a aVar) {
        this.f19360a = aVar.f19364a;
        this.f19362c = aVar.f19365b;
        this.f19363d = aVar.f19366c;
        this.f19361b = aVar.f19367d;
    }

    public void a(SSLSocket sSLSocket, boolean z7) {
        k kVarE = e(sSLSocket, z7);
        String[] strArr = kVarE.f19363d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = kVarE.f19362c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List b() {
        String[] strArr = this.f19362c;
        if (strArr != null) {
            return h.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f19360a) {
            return false;
        }
        String[] strArr = this.f19363d;
        if (strArr != null && !l6.c.z(l6.c.f19685q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f19362c;
        return strArr2 == null || l6.c.z(h.f19278b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f19360a;
    }

    public final k e(SSLSocket sSLSocket, boolean z7) {
        String[] strArrX = this.f19362c != null ? l6.c.x(h.f19278b, sSLSocket.getEnabledCipherSuites(), this.f19362c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrX2 = this.f19363d != null ? l6.c.x(l6.c.f19685q, sSLSocket.getEnabledProtocols(), this.f19363d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iU = l6.c.u(h.f19278b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z7 && iU != -1) {
            strArrX = l6.c.g(strArrX, supportedCipherSuites[iU]);
        }
        return new a(this).b(strArrX).e(strArrX2).a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z7 = this.f19360a;
        if (z7 != kVar.f19360a) {
            return false;
        }
        return !z7 || (Arrays.equals(this.f19362c, kVar.f19362c) && Arrays.equals(this.f19363d, kVar.f19363d) && this.f19361b == kVar.f19361b);
    }

    public boolean f() {
        return this.f19361b;
    }

    public List g() {
        String[] strArr = this.f19363d;
        if (strArr != null) {
            return D.d(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f19360a) {
            return ((((527 + Arrays.hashCode(this.f19362c)) * 31) + Arrays.hashCode(this.f19363d)) * 31) + (!this.f19361b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f19360a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f19362c != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f19363d != null ? g().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f19361b + ")";
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19364a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f19365b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f19366c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f19367d;

        public a(boolean z7) {
            this.f19364a = z7;
        }

        public k a() {
            return new k(this);
        }

        public a b(String... strArr) {
            if (!this.f19364a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f19365b = (String[]) strArr.clone();
            return this;
        }

        public a c(h... hVarArr) {
            if (!this.f19364a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i7 = 0; i7 < hVarArr.length; i7++) {
                strArr[i7] = hVarArr[i7].f19345a;
            }
            return b(strArr);
        }

        public a d(boolean z7) {
            if (!this.f19364a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f19367d = z7;
            return this;
        }

        public a e(String... strArr) {
            if (!this.f19364a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f19366c = (String[]) strArr.clone();
            return this;
        }

        public a f(D... dArr) {
            if (!this.f19364a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[dArr.length];
            for (int i7 = 0; i7 < dArr.length; i7++) {
                strArr[i7] = dArr[i7].f19150l;
            }
            return e(strArr);
        }

        public a(k kVar) {
            this.f19364a = kVar.f19360a;
            this.f19365b = kVar.f19362c;
            this.f19366c = kVar.f19363d;
            this.f19367d = kVar.f19361b;
        }
    }
}
