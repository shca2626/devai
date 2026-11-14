package k6;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    public static final h[] f19353e;

    /* renamed from: f, reason: collision with root package name */
    public static final h[] f19354f;

    /* renamed from: g, reason: collision with root package name */
    public static final k f19355g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f19356h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f19357i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f19358j;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19359a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19360b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f19361c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f19362d;

    static {
        h hVar = h.f19315n1;
        h hVar2 = h.f19318o1;
        h hVar3 = h.f19321p1;
        h hVar4 = h.f19324q1;
        h hVar5 = h.f19327r1;
        h hVar6 = h.f19274Z0;
        h hVar7 = h.f19285d1;
        h hVar8 = h.f19276a1;
        h hVar9 = h.f19288e1;
        h hVar10 = h.f19306k1;
        h hVar11 = h.f19303j1;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11};
        f19353e = hVarArr;
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, h.f19244K0, h.f19246L0, h.f19299i0, h.f19302j0, h.f19235G, h.f19243K, h.f19304k};
        f19354f = hVarArr2;
        a aVarC = new a(true).c(hVarArr);
        D d7 = D.TLS_1_3;
        D d8 = D.TLS_1_2;
        f19355g = aVarC.f(d7, d8).d(true).a();
        a aVarC2 = new a(true).c(hVarArr2);
        D d9 = D.TLS_1_1;
        D d10 = D.TLS_1_0;
        f19356h = aVarC2.f(d7, d8, d9, d10).d(true).a();
        f19357i = new a(true).c(hVarArr2).f(d10).d(true).a();
        f19358j = new a(false).a();
    }

    public k(a aVar) {
        this.f19359a = aVar.f19363a;
        this.f19361c = aVar.f19364b;
        this.f19362d = aVar.f19365c;
        this.f19360b = aVar.f19366d;
    }

    public void a(SSLSocket sSLSocket, boolean z7) {
        k kVarE = e(sSLSocket, z7);
        String[] strArr = kVarE.f19362d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = kVarE.f19361c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List b() {
        String[] strArr = this.f19361c;
        if (strArr != null) {
            return h.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f19359a) {
            return false;
        }
        String[] strArr = this.f19362d;
        if (strArr != null && !l6.c.z(l6.c.f19684q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f19361c;
        return strArr2 == null || l6.c.z(h.f19277b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f19359a;
    }

    public final k e(SSLSocket sSLSocket, boolean z7) {
        String[] strArrX = this.f19361c != null ? l6.c.x(h.f19277b, sSLSocket.getEnabledCipherSuites(), this.f19361c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrX2 = this.f19362d != null ? l6.c.x(l6.c.f19684q, sSLSocket.getEnabledProtocols(), this.f19362d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iU = l6.c.u(h.f19277b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
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
        boolean z7 = this.f19359a;
        if (z7 != kVar.f19359a) {
            return false;
        }
        return !z7 || (Arrays.equals(this.f19361c, kVar.f19361c) && Arrays.equals(this.f19362d, kVar.f19362d) && this.f19360b == kVar.f19360b);
    }

    public boolean f() {
        return this.f19360b;
    }

    public List g() {
        String[] strArr = this.f19362d;
        if (strArr != null) {
            return D.d(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f19359a) {
            return ((((527 + Arrays.hashCode(this.f19361c)) * 31) + Arrays.hashCode(this.f19362d)) * 31) + (!this.f19360b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f19359a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f19361c != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f19362d != null ? g().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f19360b + ")";
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19363a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f19364b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f19365c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f19366d;

        public a(boolean z7) {
            this.f19363a = z7;
        }

        public k a() {
            return new k(this);
        }

        public a b(String... strArr) {
            if (!this.f19363a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f19364b = (String[]) strArr.clone();
            return this;
        }

        public a c(h... hVarArr) {
            if (!this.f19363a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i7 = 0; i7 < hVarArr.length; i7++) {
                strArr[i7] = hVarArr[i7].f19344a;
            }
            return b(strArr);
        }

        public a d(boolean z7) {
            if (!this.f19363a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f19366d = z7;
            return this;
        }

        public a e(String... strArr) {
            if (!this.f19363a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f19365c = (String[]) strArr.clone();
            return this;
        }

        public a f(D... dArr) {
            if (!this.f19363a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[dArr.length];
            for (int i7 = 0; i7 < dArr.length; i7++) {
                strArr[i7] = dArr[i7].f19149l;
            }
            return e(strArr);
        }

        public a(k kVar) {
            this.f19363a = kVar.f19359a;
            this.f19364b = kVar.f19361c;
            this.f19365c = kVar.f19362d;
            this.f19366d = kVar.f19360b;
        }
    }
}
