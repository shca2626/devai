package U0;

import B0.A;
import E0.U;
import java.util.HashMap;
import java.util.Objects;
import k3.AbstractC1281x;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8286a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8287b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8288c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8289d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8290e;

    /* renamed from: f, reason: collision with root package name */
    public final String f8291f;

    /* renamed from: g, reason: collision with root package name */
    public final String f8292g;

    /* renamed from: h, reason: collision with root package name */
    public final String f8293h;

    /* renamed from: i, reason: collision with root package name */
    public final AbstractC1281x f8294i;

    /* renamed from: j, reason: collision with root package name */
    public final c f8295j;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f8296a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8297b;

        /* renamed from: c, reason: collision with root package name */
        public final String f8298c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8299d;

        /* renamed from: e, reason: collision with root package name */
        public final HashMap f8300e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        public int f8301f = -1;

        /* renamed from: g, reason: collision with root package name */
        public String f8302g;

        /* renamed from: h, reason: collision with root package name */
        public String f8303h;

        /* renamed from: i, reason: collision with root package name */
        public String f8304i;

        public b(String str, int i7, String str2, int i8) {
            this.f8296a = str;
            this.f8297b = i7;
            this.f8298c = str2;
            this.f8299d = i8;
        }

        public static String k(int i7, String str, int i8, int i9) {
            return U.G("%d %s/%d/%d", Integer.valueOf(i7), str, Integer.valueOf(i8), Integer.valueOf(i9));
        }

        public static String l(int i7) {
            j3.o.d(i7 < 96);
            if (i7 == 0) {
                return k(0, "PCMU", 8000, 1);
            }
            if (i7 == 8) {
                return k(8, "PCMA", 8000, 1);
            }
            if (i7 == 10) {
                return k(10, "L16", 44100, 2);
            }
            if (i7 == 11) {
                return k(11, "L16", 44100, 1);
            }
            throw new IllegalStateException("Unsupported static paylod type " + i7);
        }

        public b i(String str, String str2) {
            this.f8300e.put(str, str2);
            return this;
        }

        public a j() {
            try {
                return new a(this, AbstractC1281x.c(this.f8300e), this.f8300e.containsKey("rtpmap") ? c.a((String) U.i((String) this.f8300e.get("rtpmap"))) : c.a(l(this.f8299d)));
            } catch (A e7) {
                throw new IllegalStateException(e7);
            }
        }

        public b m(int i7) {
            this.f8301f = i7;
            return this;
        }

        public b n(String str) {
            this.f8303h = str;
            return this;
        }

        public b o(String str) {
            this.f8304i = str;
            return this;
        }

        public b p(String str) {
            this.f8302g = str;
            return this;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f8305a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8306b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8307c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8308d;

        public c(int i7, String str, int i8, int i9) {
            this.f8305a = i7;
            this.f8306b = str;
            this.f8307c = i8;
            this.f8308d = i9;
        }

        public static c a(String str) {
            String[] strArrL1 = U.l1(str, " ");
            j3.o.d(strArrL1.length == 2);
            int iH = androidx.media3.exoplayer.rtsp.h.h(strArrL1[0]);
            String[] strArrK1 = U.k1(strArrL1[1].trim(), "/");
            j3.o.d(strArrK1.length >= 2);
            return new c(iH, strArrK1[0], androidx.media3.exoplayer.rtsp.h.h(strArrK1[1]), strArrK1.length == 3 ? androidx.media3.exoplayer.rtsp.h.h(strArrK1[2]) : -1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f8305a == cVar.f8305a && this.f8306b.equals(cVar.f8306b) && this.f8307c == cVar.f8307c && this.f8308d == cVar.f8308d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((((217 + this.f8305a) * 31) + this.f8306b.hashCode()) * 31) + this.f8307c) * 31) + this.f8308d;
        }
    }

    public AbstractC1281x a() {
        String str = (String) this.f8294i.get("fmtp");
        if (str == null) {
            return AbstractC1281x.j();
        }
        String[] strArrL1 = U.l1(str, " ");
        j3.o.e(strArrL1.length == 2, str);
        String[] strArrSplit = strArrL1[1].split(";\\s?", 0);
        AbstractC1281x.a aVar = new AbstractC1281x.a();
        for (String str2 : strArrSplit) {
            String[] strArrL12 = U.l1(str2, "=");
            aVar.g(strArrL12[0], strArrL12[1]);
        }
        return aVar.d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f8286a.equals(aVar.f8286a) && this.f8287b == aVar.f8287b && this.f8288c.equals(aVar.f8288c) && this.f8289d == aVar.f8289d && this.f8290e == aVar.f8290e && this.f8294i.equals(aVar.f8294i) && this.f8295j.equals(aVar.f8295j) && Objects.equals(this.f8291f, aVar.f8291f) && Objects.equals(this.f8292g, aVar.f8292g) && Objects.equals(this.f8293h, aVar.f8293h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((((((((217 + this.f8286a.hashCode()) * 31) + this.f8287b) * 31) + this.f8288c.hashCode()) * 31) + this.f8289d) * 31) + this.f8290e) * 31) + this.f8294i.hashCode()) * 31) + this.f8295j.hashCode()) * 31;
        String str = this.f8291f;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8292g;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f8293h;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public a(b bVar, AbstractC1281x abstractC1281x, c cVar) {
        this.f8286a = bVar.f8296a;
        this.f8287b = bVar.f8297b;
        this.f8288c = bVar.f8298c;
        this.f8289d = bVar.f8299d;
        this.f8291f = bVar.f8302g;
        this.f8292g = bVar.f8303h;
        this.f8290e = bVar.f8301f;
        this.f8293h = bVar.f8304i;
        this.f8294i = abstractC1281x;
        this.f8295j = cVar;
    }
}
