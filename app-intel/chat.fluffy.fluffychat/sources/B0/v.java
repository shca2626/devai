package B0;

import E0.U;
import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import k3.AbstractC1278v;
import k3.AbstractC1280x;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: i, reason: collision with root package name */
    public static final v f819i = new c().a();

    /* renamed from: j, reason: collision with root package name */
    public static final String f820j = U.A0(0);

    /* renamed from: k, reason: collision with root package name */
    public static final String f821k = U.A0(1);

    /* renamed from: l, reason: collision with root package name */
    public static final String f822l = U.A0(2);

    /* renamed from: m, reason: collision with root package name */
    public static final String f823m = U.A0(3);

    /* renamed from: n, reason: collision with root package name */
    public static final String f824n = U.A0(4);

    /* renamed from: o, reason: collision with root package name */
    public static final String f825o = U.A0(5);

    /* renamed from: a, reason: collision with root package name */
    public final String f826a;

    /* renamed from: b, reason: collision with root package name */
    public final h f827b;

    /* renamed from: c, reason: collision with root package name */
    public final h f828c;

    /* renamed from: d, reason: collision with root package name */
    public final g f829d;

    /* renamed from: e, reason: collision with root package name */
    public final x f830e;

    /* renamed from: f, reason: collision with root package name */
    public final d f831f;

    /* renamed from: g, reason: collision with root package name */
    public final e f832g;

    /* renamed from: h, reason: collision with root package name */
    public final i f833h;

    public static final class b {
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public String f834a;

        /* renamed from: b, reason: collision with root package name */
        public Uri f835b;

        /* renamed from: c, reason: collision with root package name */
        public String f836c;

        /* renamed from: d, reason: collision with root package name */
        public d.a f837d;

        /* renamed from: e, reason: collision with root package name */
        public f.a f838e;

        /* renamed from: f, reason: collision with root package name */
        public List f839f;

        /* renamed from: g, reason: collision with root package name */
        public String f840g;

        /* renamed from: h, reason: collision with root package name */
        public AbstractC1278v f841h;

        /* renamed from: i, reason: collision with root package name */
        public Object f842i;

        /* renamed from: j, reason: collision with root package name */
        public long f843j;

        /* renamed from: k, reason: collision with root package name */
        public x f844k;

        /* renamed from: l, reason: collision with root package name */
        public g.a f845l;

        /* renamed from: m, reason: collision with root package name */
        public i f846m;

        public v a() {
            h hVar;
            j3.o.v(this.f838e.f891b == null || this.f838e.f890a != null);
            Uri uri = this.f835b;
            if (uri != null) {
                hVar = new h(uri, this.f836c, this.f838e.f890a != null ? this.f838e.i() : null, null, this.f839f, this.f840g, this.f841h, this.f842i, this.f843j);
            } else {
                hVar = null;
            }
            String str = this.f834a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarH = this.f837d.h();
            g gVarF = this.f845l.f();
            x xVar = this.f844k;
            if (xVar == null) {
                xVar = x.f950J;
            }
            return new v(str2, eVarH, hVar, gVarF, xVar, this.f846m);
        }

        public c b(g gVar) {
            this.f845l = gVar.a();
            return this;
        }

        public c c(String str) {
            this.f834a = (String) j3.o.q(str);
            return this;
        }

        public c d(String str) {
            this.f836c = str;
            return this;
        }

        public c e(List list) {
            this.f841h = AbstractC1278v.r(list);
            return this;
        }

        public c f(Object obj) {
            this.f842i = obj;
            return this;
        }

        public c g(Uri uri) {
            this.f835b = uri;
            return this;
        }

        public c h(String str) {
            return g(str == null ? null : Uri.parse(str));
        }

        public c() {
            this.f837d = new d.a();
            this.f838e = new f.a();
            this.f839f = Collections.EMPTY_LIST;
            this.f841h = AbstractC1278v.v();
            this.f845l = new g.a();
            this.f846m = i.f931d;
            this.f843j = -9223372036854775807L;
        }

        public c(v vVar) {
            f.a aVar;
            this();
            this.f837d = vVar.f831f.a();
            this.f834a = vVar.f826a;
            this.f844k = vVar.f830e;
            this.f845l = vVar.f829d.a();
            this.f846m = vVar.f833h;
            h hVar = vVar.f827b;
            if (hVar != null) {
                this.f840g = hVar.f926e;
                this.f836c = hVar.f923b;
                this.f835b = hVar.f922a;
                this.f839f = hVar.f925d;
                this.f841h = hVar.f927f;
                this.f842i = hVar.f929h;
                f fVar = hVar.f924c;
                if (fVar != null) {
                    aVar = fVar.b();
                } else {
                    aVar = new f.a();
                }
                this.f838e = aVar;
                this.f843j = hVar.f930i;
            }
        }
    }

    public static class d {

        /* renamed from: i, reason: collision with root package name */
        public static final d f847i = new a().g();

        /* renamed from: j, reason: collision with root package name */
        public static final String f848j = U.A0(0);

        /* renamed from: k, reason: collision with root package name */
        public static final String f849k = U.A0(1);

        /* renamed from: l, reason: collision with root package name */
        public static final String f850l = U.A0(2);

        /* renamed from: m, reason: collision with root package name */
        public static final String f851m = U.A0(3);

        /* renamed from: n, reason: collision with root package name */
        public static final String f852n = U.A0(4);

        /* renamed from: o, reason: collision with root package name */
        public static final String f853o = U.A0(5);

        /* renamed from: p, reason: collision with root package name */
        public static final String f854p = U.A0(6);

        /* renamed from: q, reason: collision with root package name */
        public static final String f855q = U.A0(7);

        /* renamed from: a, reason: collision with root package name */
        public final long f856a;

        /* renamed from: b, reason: collision with root package name */
        public final long f857b;

        /* renamed from: c, reason: collision with root package name */
        public final long f858c;

        /* renamed from: d, reason: collision with root package name */
        public final long f859d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f860e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f861f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f862g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f863h;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public long f864a;

            /* renamed from: b, reason: collision with root package name */
            public long f865b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f866c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f867d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f868e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f869f;

            public d g() {
                return new d(this);
            }

            public e h() {
                return new e(this);
            }

            public a() {
                this.f865b = Long.MIN_VALUE;
            }

            public a(d dVar) {
                this.f864a = dVar.f857b;
                this.f865b = dVar.f859d;
                this.f866c = dVar.f860e;
                this.f867d = dVar.f861f;
                this.f868e = dVar.f862g;
                this.f869f = dVar.f863h;
            }
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f857b == dVar.f857b && this.f859d == dVar.f859d && this.f860e == dVar.f860e && this.f861f == dVar.f861f && this.f862g == dVar.f862g && this.f863h == dVar.f863h;
        }

        public int hashCode() {
            long j7 = this.f857b;
            int i7 = ((int) (j7 ^ (j7 >>> 32))) * 31;
            long j8 = this.f859d;
            return ((((((((i7 + ((int) ((j8 >>> 32) ^ j8))) * 31) + (this.f860e ? 1 : 0)) * 31) + (this.f861f ? 1 : 0)) * 31) + (this.f862g ? 1 : 0)) * 31) + (this.f863h ? 1 : 0);
        }

        public d(a aVar) {
            this.f856a = U.s1(aVar.f864a);
            this.f858c = U.s1(aVar.f865b);
            this.f857b = aVar.f864a;
            this.f859d = aVar.f865b;
            this.f860e = aVar.f866c;
            this.f861f = aVar.f867d;
            this.f862g = aVar.f868e;
            this.f863h = aVar.f869f;
        }
    }

    public static final class e extends d {

        /* renamed from: r, reason: collision with root package name */
        public static final e f870r = new d.a().h();

        public e(d.a aVar) {
            super(aVar);
        }
    }

    public static final class f {

        /* renamed from: l, reason: collision with root package name */
        public static final String f871l = U.A0(0);

        /* renamed from: m, reason: collision with root package name */
        public static final String f872m = U.A0(1);

        /* renamed from: n, reason: collision with root package name */
        public static final String f873n = U.A0(2);

        /* renamed from: o, reason: collision with root package name */
        public static final String f874o = U.A0(3);

        /* renamed from: p, reason: collision with root package name */
        public static final String f875p = U.A0(4);

        /* renamed from: q, reason: collision with root package name */
        public static final String f876q = U.A0(5);

        /* renamed from: r, reason: collision with root package name */
        public static final String f877r = U.A0(6);

        /* renamed from: s, reason: collision with root package name */
        public static final String f878s = U.A0(7);

        /* renamed from: a, reason: collision with root package name */
        public final UUID f879a;

        /* renamed from: b, reason: collision with root package name */
        public final UUID f880b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f881c;

        /* renamed from: d, reason: collision with root package name */
        public final AbstractC1280x f882d;

        /* renamed from: e, reason: collision with root package name */
        public final AbstractC1280x f883e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f884f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f885g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f886h;

        /* renamed from: i, reason: collision with root package name */
        public final AbstractC1278v f887i;

        /* renamed from: j, reason: collision with root package name */
        public final AbstractC1278v f888j;

        /* renamed from: k, reason: collision with root package name */
        public final byte[] f889k;

        public a b() {
            return new a();
        }

        public byte[] c() {
            byte[] bArr = this.f889k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f879a.equals(fVar.f879a) && Objects.equals(this.f881c, fVar.f881c) && Objects.equals(this.f883e, fVar.f883e) && this.f884f == fVar.f884f && this.f886h == fVar.f886h && this.f885g == fVar.f885g && this.f888j.equals(fVar.f888j) && Arrays.equals(this.f889k, fVar.f889k);
        }

        public int hashCode() {
            int iHashCode = this.f879a.hashCode() * 31;
            Uri uri = this.f881c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f883e.hashCode()) * 31) + (this.f884f ? 1 : 0)) * 31) + (this.f886h ? 1 : 0)) * 31) + (this.f885g ? 1 : 0)) * 31) + this.f888j.hashCode()) * 31) + Arrays.hashCode(this.f889k);
        }

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public UUID f890a;

            /* renamed from: b, reason: collision with root package name */
            public Uri f891b;

            /* renamed from: c, reason: collision with root package name */
            public AbstractC1280x f892c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f893d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f894e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f895f;

            /* renamed from: g, reason: collision with root package name */
            public AbstractC1278v f896g;

            /* renamed from: h, reason: collision with root package name */
            public byte[] f897h;

            public f i() {
                return new f(this);
            }

            public a() {
                this.f892c = AbstractC1280x.j();
                this.f894e = true;
                this.f896g = AbstractC1278v.v();
            }

            public a(f fVar) {
                this.f890a = fVar.f879a;
                this.f891b = fVar.f881c;
                this.f892c = fVar.f883e;
                this.f893d = fVar.f884f;
                this.f894e = fVar.f885g;
                this.f895f = fVar.f886h;
                this.f896g = fVar.f888j;
                this.f897h = fVar.f889k;
            }
        }

        public f(a aVar) {
            j3.o.v((aVar.f895f && aVar.f891b == null) ? false : true);
            UUID uuid = (UUID) j3.o.q(aVar.f890a);
            this.f879a = uuid;
            this.f880b = uuid;
            this.f881c = aVar.f891b;
            this.f882d = aVar.f892c;
            this.f883e = aVar.f892c;
            this.f884f = aVar.f893d;
            this.f886h = aVar.f895f;
            this.f885g = aVar.f894e;
            this.f887i = aVar.f896g;
            this.f888j = aVar.f896g;
            this.f889k = aVar.f897h != null ? Arrays.copyOf(aVar.f897h, aVar.f897h.length) : null;
        }
    }

    public static final class g {

        /* renamed from: f, reason: collision with root package name */
        public static final g f898f = new a().f();

        /* renamed from: g, reason: collision with root package name */
        public static final String f899g = U.A0(0);

        /* renamed from: h, reason: collision with root package name */
        public static final String f900h = U.A0(1);

        /* renamed from: i, reason: collision with root package name */
        public static final String f901i = U.A0(2);

        /* renamed from: j, reason: collision with root package name */
        public static final String f902j = U.A0(3);

        /* renamed from: k, reason: collision with root package name */
        public static final String f903k = U.A0(4);

        /* renamed from: a, reason: collision with root package name */
        public final long f904a;

        /* renamed from: b, reason: collision with root package name */
        public final long f905b;

        /* renamed from: c, reason: collision with root package name */
        public final long f906c;

        /* renamed from: d, reason: collision with root package name */
        public final float f907d;

        /* renamed from: e, reason: collision with root package name */
        public final float f908e;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public long f909a;

            /* renamed from: b, reason: collision with root package name */
            public long f910b;

            /* renamed from: c, reason: collision with root package name */
            public long f911c;

            /* renamed from: d, reason: collision with root package name */
            public float f912d;

            /* renamed from: e, reason: collision with root package name */
            public float f913e;

            public g f() {
                return new g(this);
            }

            public a g(long j7) {
                this.f911c = j7;
                return this;
            }

            public a h(float f7) {
                this.f913e = f7;
                return this;
            }

            public a i(long j7) {
                this.f910b = j7;
                return this;
            }

            public a j(float f7) {
                this.f912d = f7;
                return this;
            }

            public a k(long j7) {
                this.f909a = j7;
                return this;
            }

            public a() {
                this.f909a = -9223372036854775807L;
                this.f910b = -9223372036854775807L;
                this.f911c = -9223372036854775807L;
                this.f912d = -3.4028235E38f;
                this.f913e = -3.4028235E38f;
            }

            public a(g gVar) {
                this.f909a = gVar.f904a;
                this.f910b = gVar.f905b;
                this.f911c = gVar.f906c;
                this.f912d = gVar.f907d;
                this.f913e = gVar.f908e;
            }
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f904a == gVar.f904a && this.f905b == gVar.f905b && this.f906c == gVar.f906c && this.f907d == gVar.f907d && this.f908e == gVar.f908e;
        }

        public int hashCode() {
            long j7 = this.f904a;
            long j8 = this.f905b;
            int i7 = ((((int) (j7 ^ (j7 >>> 32))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31;
            long j9 = this.f906c;
            int i8 = (i7 + ((int) ((j9 >>> 32) ^ j9))) * 31;
            float f7 = this.f907d;
            int iFloatToIntBits = (i8 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f908e;
            return iFloatToIntBits + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
        }

        public g(a aVar) {
            this(aVar.f909a, aVar.f910b, aVar.f911c, aVar.f912d, aVar.f913e);
        }

        public g(long j7, long j8, long j9, float f7, float f8) {
            this.f904a = j7;
            this.f905b = j8;
            this.f906c = j9;
            this.f907d = f7;
            this.f908e = f8;
        }
    }

    public static final class h {

        /* renamed from: j, reason: collision with root package name */
        public static final String f914j = U.A0(0);

        /* renamed from: k, reason: collision with root package name */
        public static final String f915k = U.A0(1);

        /* renamed from: l, reason: collision with root package name */
        public static final String f916l = U.A0(2);

        /* renamed from: m, reason: collision with root package name */
        public static final String f917m = U.A0(3);

        /* renamed from: n, reason: collision with root package name */
        public static final String f918n = U.A0(4);

        /* renamed from: o, reason: collision with root package name */
        public static final String f919o = U.A0(5);

        /* renamed from: p, reason: collision with root package name */
        public static final String f920p = U.A0(6);

        /* renamed from: q, reason: collision with root package name */
        public static final String f921q = U.A0(7);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f922a;

        /* renamed from: b, reason: collision with root package name */
        public final String f923b;

        /* renamed from: c, reason: collision with root package name */
        public final f f924c;

        /* renamed from: d, reason: collision with root package name */
        public final List f925d;

        /* renamed from: e, reason: collision with root package name */
        public final String f926e;

        /* renamed from: f, reason: collision with root package name */
        public final AbstractC1278v f927f;

        /* renamed from: g, reason: collision with root package name */
        public final List f928g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f929h;

        /* renamed from: i, reason: collision with root package name */
        public final long f930i;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f922a.equals(hVar.f922a) && Objects.equals(this.f923b, hVar.f923b) && Objects.equals(this.f924c, hVar.f924c) && this.f925d.equals(hVar.f925d) && Objects.equals(this.f926e, hVar.f926e) && this.f927f.equals(hVar.f927f) && Objects.equals(this.f929h, hVar.f929h) && this.f930i == hVar.f930i;
        }

        public int hashCode() {
            int iHashCode = this.f922a.hashCode() * 31;
            String str = this.f923b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f924c;
            int iHashCode3 = (((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.f925d.hashCode()) * 31;
            String str2 = this.f926e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f927f.hashCode()) * 31;
            return (int) (((iHashCode4 + (this.f929h != null ? r1.hashCode() : 0)) * 31) + this.f930i);
        }

        public h(Uri uri, String str, f fVar, b bVar, List list, String str2, AbstractC1278v abstractC1278v, Object obj, long j7) {
            this.f922a = uri;
            this.f923b = z.u(str);
            this.f924c = fVar;
            this.f925d = list;
            this.f926e = str2;
            this.f927f = abstractC1278v;
            AbstractC1278v.a aVarO = AbstractC1278v.o();
            for (int i7 = 0; i7 < abstractC1278v.size(); i7++) {
                aVarO.a(((k) abstractC1278v.get(i7)).a().b());
            }
            this.f928g = aVarO.k();
            this.f929h = obj;
            this.f930i = j7;
        }
    }

    public static final class i {

        /* renamed from: d, reason: collision with root package name */
        public static final i f931d = new a().d();

        /* renamed from: e, reason: collision with root package name */
        public static final String f932e = U.A0(0);

        /* renamed from: f, reason: collision with root package name */
        public static final String f933f = U.A0(1);

        /* renamed from: g, reason: collision with root package name */
        public static final String f934g = U.A0(2);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f935a;

        /* renamed from: b, reason: collision with root package name */
        public final String f936b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f937c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public Uri f938a;

            /* renamed from: b, reason: collision with root package name */
            public String f939b;

            /* renamed from: c, reason: collision with root package name */
            public Bundle f940c;

            public i d() {
                return new i(this);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (Objects.equals(this.f935a, iVar.f935a) && Objects.equals(this.f936b, iVar.f936b)) {
                if ((this.f937c == null) == (iVar.f937c == null)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Uri uri = this.f935a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f936b;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f937c != null ? 1 : 0);
        }

        public i(a aVar) {
            this.f935a = aVar.f938a;
            this.f936b = aVar.f939b;
            this.f937c = aVar.f940c;
        }
    }

    public static final class j extends k {
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f941a;

        /* renamed from: b, reason: collision with root package name */
        public final String f942b;

        /* renamed from: c, reason: collision with root package name */
        public final String f943c;

        /* renamed from: d, reason: collision with root package name */
        public final int f944d;

        /* renamed from: e, reason: collision with root package name */
        public final int f945e;

        /* renamed from: f, reason: collision with root package name */
        public final String f946f;

        /* renamed from: g, reason: collision with root package name */
        public final String f947g;

        public static final class a {
            public abstract j b();
        }

        public abstract a a();
    }

    public static v b(String str) {
        return new c().h(str).a();
    }

    public c a() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return Objects.equals(this.f826a, vVar.f826a) && this.f831f.equals(vVar.f831f) && Objects.equals(this.f827b, vVar.f827b) && Objects.equals(this.f829d, vVar.f829d) && Objects.equals(this.f830e, vVar.f830e) && Objects.equals(this.f833h, vVar.f833h);
    }

    public int hashCode() {
        int iHashCode = this.f826a.hashCode() * 31;
        h hVar = this.f827b;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f829d.hashCode()) * 31) + this.f831f.hashCode()) * 31) + this.f830e.hashCode()) * 31) + this.f833h.hashCode();
    }

    public v(String str, e eVar, h hVar, g gVar, x xVar, i iVar) {
        this.f826a = str;
        this.f827b = hVar;
        this.f828c = hVar;
        this.f829d = gVar;
        this.f830e = xVar;
        this.f831f = eVar;
        this.f832g = eVar;
        this.f833h = iVar;
    }
}
