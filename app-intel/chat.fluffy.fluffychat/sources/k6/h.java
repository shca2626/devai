package k6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f19345a;

    /* renamed from: b, reason: collision with root package name */
    public static final Comparator f19278b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f19281c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final h f19284d = c("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: e, reason: collision with root package name */
    public static final h f19287e = c("SSL_RSA_WITH_NULL_SHA", 2);

    /* renamed from: f, reason: collision with root package name */
    public static final h f19290f = c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* renamed from: g, reason: collision with root package name */
    public static final h f19293g = c("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* renamed from: h, reason: collision with root package name */
    public static final h f19296h = c("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* renamed from: i, reason: collision with root package name */
    public static final h f19299i = c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* renamed from: j, reason: collision with root package name */
    public static final h f19302j = c("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* renamed from: k, reason: collision with root package name */
    public static final h f19305k = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* renamed from: l, reason: collision with root package name */
    public static final h f19308l = c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* renamed from: m, reason: collision with root package name */
    public static final h f19311m = c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* renamed from: n, reason: collision with root package name */
    public static final h f19314n = c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* renamed from: o, reason: collision with root package name */
    public static final h f19317o = c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* renamed from: p, reason: collision with root package name */
    public static final h f19320p = c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* renamed from: q, reason: collision with root package name */
    public static final h f19323q = c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* renamed from: r, reason: collision with root package name */
    public static final h f19326r = c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* renamed from: s, reason: collision with root package name */
    public static final h f19329s = c("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* renamed from: t, reason: collision with root package name */
    public static final h f19331t = c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* renamed from: u, reason: collision with root package name */
    public static final h f19333u = c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* renamed from: v, reason: collision with root package name */
    public static final h f19335v = c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* renamed from: w, reason: collision with root package name */
    public static final h f19337w = c("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* renamed from: x, reason: collision with root package name */
    public static final h f19339x = c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* renamed from: y, reason: collision with root package name */
    public static final h f19341y = c("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* renamed from: z, reason: collision with root package name */
    public static final h f19343z = c("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* renamed from: A, reason: collision with root package name */
    public static final h f19224A = c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* renamed from: B, reason: collision with root package name */
    public static final h f19226B = c("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* renamed from: C, reason: collision with root package name */
    public static final h f19228C = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* renamed from: D, reason: collision with root package name */
    public static final h f19230D = c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* renamed from: E, reason: collision with root package name */
    public static final h f19232E = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* renamed from: F, reason: collision with root package name */
    public static final h f19234F = c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* renamed from: G, reason: collision with root package name */
    public static final h f19236G = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: H, reason: collision with root package name */
    public static final h f19238H = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* renamed from: I, reason: collision with root package name */
    public static final h f19240I = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* renamed from: J, reason: collision with root package name */
    public static final h f19242J = c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* renamed from: K, reason: collision with root package name */
    public static final h f19244K = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: L, reason: collision with root package name */
    public static final h f19246L = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* renamed from: M, reason: collision with root package name */
    public static final h f19248M = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* renamed from: N, reason: collision with root package name */
    public static final h f19250N = c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* renamed from: O, reason: collision with root package name */
    public static final h f19252O = c("TLS_RSA_WITH_NULL_SHA256", 59);

    /* renamed from: P, reason: collision with root package name */
    public static final h f19254P = c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* renamed from: Q, reason: collision with root package name */
    public static final h f19256Q = c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* renamed from: R, reason: collision with root package name */
    public static final h f19258R = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* renamed from: S, reason: collision with root package name */
    public static final h f19260S = c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* renamed from: T, reason: collision with root package name */
    public static final h f19262T = c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* renamed from: U, reason: collision with root package name */
    public static final h f19264U = c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* renamed from: V, reason: collision with root package name */
    public static final h f19266V = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* renamed from: W, reason: collision with root package name */
    public static final h f19268W = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* renamed from: X, reason: collision with root package name */
    public static final h f19270X = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* renamed from: Y, reason: collision with root package name */
    public static final h f19272Y = c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* renamed from: Z, reason: collision with root package name */
    public static final h f19274Z = c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* renamed from: a0, reason: collision with root package name */
    public static final h f19276a0 = c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* renamed from: b0, reason: collision with root package name */
    public static final h f19279b0 = c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* renamed from: c0, reason: collision with root package name */
    public static final h f19282c0 = c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* renamed from: d0, reason: collision with root package name */
    public static final h f19285d0 = c("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* renamed from: e0, reason: collision with root package name */
    public static final h f19288e0 = c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* renamed from: f0, reason: collision with root package name */
    public static final h f19291f0 = c("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* renamed from: g0, reason: collision with root package name */
    public static final h f19294g0 = c("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* renamed from: h0, reason: collision with root package name */
    public static final h f19297h0 = c("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* renamed from: i0, reason: collision with root package name */
    public static final h f19300i0 = c("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* renamed from: j0, reason: collision with root package name */
    public static final h f19303j0 = c("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: k0, reason: collision with root package name */
    public static final h f19306k0 = c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* renamed from: l0, reason: collision with root package name */
    public static final h f19309l0 = c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* renamed from: m0, reason: collision with root package name */
    public static final h f19312m0 = c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* renamed from: n0, reason: collision with root package name */
    public static final h f19315n0 = c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* renamed from: o0, reason: collision with root package name */
    public static final h f19318o0 = c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* renamed from: p0, reason: collision with root package name */
    public static final h f19321p0 = c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* renamed from: q0, reason: collision with root package name */
    public static final h f19324q0 = c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* renamed from: r0, reason: collision with root package name */
    public static final h f19327r0 = c("TLS_FALLBACK_SCSV", 22016);

    /* renamed from: s0, reason: collision with root package name */
    public static final h f19330s0 = c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: t0, reason: collision with root package name */
    public static final h f19332t0 = c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* renamed from: u0, reason: collision with root package name */
    public static final h f19334u0 = c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* renamed from: v0, reason: collision with root package name */
    public static final h f19336v0 = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* renamed from: w0, reason: collision with root package name */
    public static final h f19338w0 = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* renamed from: x0, reason: collision with root package name */
    public static final h f19340x0 = c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* renamed from: y0, reason: collision with root package name */
    public static final h f19342y0 = c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* renamed from: z0, reason: collision with root package name */
    public static final h f19344z0 = c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: A0, reason: collision with root package name */
    public static final h f19225A0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* renamed from: B0, reason: collision with root package name */
    public static final h f19227B0 = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* renamed from: C0, reason: collision with root package name */
    public static final h f19229C0 = c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* renamed from: D0, reason: collision with root package name */
    public static final h f19231D0 = c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* renamed from: E0, reason: collision with root package name */
    public static final h f19233E0 = c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* renamed from: F0, reason: collision with root package name */
    public static final h f19235F0 = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* renamed from: G0, reason: collision with root package name */
    public static final h f19237G0 = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* renamed from: H0, reason: collision with root package name */
    public static final h f19239H0 = c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* renamed from: I0, reason: collision with root package name */
    public static final h f19241I0 = c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* renamed from: J0, reason: collision with root package name */
    public static final h f19243J0 = c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* renamed from: K0, reason: collision with root package name */
    public static final h f19245K0 = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: L0, reason: collision with root package name */
    public static final h f19247L0 = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: M0, reason: collision with root package name */
    public static final h f19249M0 = c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* renamed from: N0, reason: collision with root package name */
    public static final h f19251N0 = c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* renamed from: O0, reason: collision with root package name */
    public static final h f19253O0 = c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* renamed from: P0, reason: collision with root package name */
    public static final h f19255P0 = c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* renamed from: Q0, reason: collision with root package name */
    public static final h f19257Q0 = c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* renamed from: R0, reason: collision with root package name */
    public static final h f19259R0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* renamed from: S0, reason: collision with root package name */
    public static final h f19261S0 = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* renamed from: T0, reason: collision with root package name */
    public static final h f19263T0 = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* renamed from: U0, reason: collision with root package name */
    public static final h f19265U0 = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* renamed from: V0, reason: collision with root package name */
    public static final h f19267V0 = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* renamed from: W0, reason: collision with root package name */
    public static final h f19269W0 = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* renamed from: X0, reason: collision with root package name */
    public static final h f19271X0 = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* renamed from: Y0, reason: collision with root package name */
    public static final h f19273Y0 = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* renamed from: Z0, reason: collision with root package name */
    public static final h f19275Z0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* renamed from: a1, reason: collision with root package name */
    public static final h f19277a1 = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: b1, reason: collision with root package name */
    public static final h f19280b1 = c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: c1, reason: collision with root package name */
    public static final h f19283c1 = c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: d1, reason: collision with root package name */
    public static final h f19286d1 = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: e1, reason: collision with root package name */
    public static final h f19289e1 = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: f1, reason: collision with root package name */
    public static final h f19292f1 = c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: g1, reason: collision with root package name */
    public static final h f19295g1 = c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: h1, reason: collision with root package name */
    public static final h f19298h1 = c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: i1, reason: collision with root package name */
    public static final h f19301i1 = c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: j1, reason: collision with root package name */
    public static final h f19304j1 = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: k1, reason: collision with root package name */
    public static final h f19307k1 = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: l1, reason: collision with root package name */
    public static final h f19310l1 = c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: m1, reason: collision with root package name */
    public static final h f19313m1 = c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: n1, reason: collision with root package name */
    public static final h f19316n1 = c("TLS_AES_128_GCM_SHA256", 4865);

    /* renamed from: o1, reason: collision with root package name */
    public static final h f19319o1 = c("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: p1, reason: collision with root package name */
    public static final h f19322p1 = c("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: q1, reason: collision with root package name */
    public static final h f19325q1 = c("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: r1, reason: collision with root package name */
    public static final h f19328r1 = c("TLS_AES_256_CCM_8_SHA256", 4869);

    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iMin = Math.min(str.length(), str2.length());
            for (int i7 = 4; i7 < iMin; i7++) {
                char cCharAt = str.charAt(i7);
                char cCharAt2 = str2.charAt(i7);
                if (cCharAt != cCharAt2) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    public h(String str) {
        str.getClass();
        this.f19345a = str;
    }

    public static synchronized h a(String str) {
        h hVar;
        try {
            Map map = f19281c;
            hVar = (h) map.get(str);
            if (hVar == null) {
                hVar = (h) map.get(e(str));
                if (hVar == null) {
                    hVar = new h(str);
                }
                map.put(str, hVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return hVar;
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static h c(String str, int i7) {
        h hVar = new h(str);
        f19281c.put(str, hVar);
        return hVar;
    }

    public static String e(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String d() {
        return this.f19345a;
    }

    public String toString() {
        return this.f19345a;
    }
}
