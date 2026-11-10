package E0;

import B0.D;
import B0.H;
import android.os.Handler;
import android.os.Message;
import java.util.Objects;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public final B0.D f2037a;

    /* renamed from: b, reason: collision with root package name */
    public final D.d f2038b;

    /* renamed from: c, reason: collision with root package name */
    public final b f2039c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0321g f2040d;

    /* renamed from: e, reason: collision with root package name */
    public final H.b f2041e = new H.b();

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0329o f2042f;

    /* renamed from: g, reason: collision with root package name */
    public final c f2043g;

    /* renamed from: h, reason: collision with root package name */
    public final d f2044h;

    /* renamed from: i, reason: collision with root package name */
    public final e f2045i;

    /* renamed from: j, reason: collision with root package name */
    public final f f2046j;

    public class a implements D.d {
        public a() {
        }

        @Override // B0.D.d
        public void Y(B0.D d7, D.c cVar) {
            H.this.i();
        }
    }

    public interface b {
        void G(I i7);
    }

    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f2048a;

        /* renamed from: b, reason: collision with root package name */
        public Object f2049b;

        /* renamed from: c, reason: collision with root package name */
        public int f2050c;

        /* renamed from: d, reason: collision with root package name */
        public int f2051d;

        /* renamed from: e, reason: collision with root package name */
        public long f2052e;

        /* renamed from: f, reason: collision with root package name */
        public long f2053f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2054g;

        /* renamed from: h, reason: collision with root package name */
        public long f2055h;

        public c(int i7) {
            this.f2048a = i7;
        }

        public void a() {
            if (H.this.f2037a.N() != 2 || !H.this.f2037a.r() || H.this.f2037a.Z() != 0) {
                if (this.f2054g) {
                    H.this.f2042f.k(1);
                }
                this.f2054g = false;
                return;
            }
            B0.H hB0 = H.this.f2037a.b0();
            Object objM = hB0.q() ? null : hB0.m(H.this.f2037a.x());
            int iS = H.this.f2037a.S();
            int iD = H.this.f2037a.D();
            long j7 = H.this.f2037a.j();
            long jMax = Math.max(0L, H.this.f2037a.p() - Math.max(0L, j7 - H.this.f2037a.m()));
            if (objM != null && iS == -1) {
                j7 -= hB0.h(objM, H.this.f2041e).n();
            }
            long jE = H.this.f2040d.e();
            if (this.f2054g && Objects.equals(objM, this.f2049b) && iS == this.f2050c && iD == this.f2051d && j7 == this.f2052e && jMax == this.f2053f) {
                if (jE - this.f2055h >= this.f2048a) {
                    H.this.f2039c.G(new I(1, this.f2048a));
                    return;
                }
                return;
            }
            this.f2054g = true;
            this.f2055h = jE;
            this.f2049b = objM;
            this.f2050c = iS;
            this.f2051d = iD;
            this.f2052e = j7;
            this.f2053f = jMax;
            H.this.f2042f.k(1);
            H.this.f2042f.b(1, this.f2048a);
        }
    }

    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f2057a;

        /* renamed from: b, reason: collision with root package name */
        public Object f2058b;

        /* renamed from: c, reason: collision with root package name */
        public int f2059c;

        /* renamed from: d, reason: collision with root package name */
        public int f2060d;

        /* renamed from: e, reason: collision with root package name */
        public long f2061e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f2062f;

        /* renamed from: g, reason: collision with root package name */
        public long f2063g;

        public d(int i7) {
            this.f2057a = i7;
        }

        public void a() {
            if (!H.this.f2037a.R()) {
                if (this.f2062f) {
                    H.this.f2042f.k(2);
                }
                this.f2062f = false;
                return;
            }
            B0.H hB0 = H.this.f2037a.b0();
            Object objM = hB0.q() ? null : hB0.m(H.this.f2037a.x());
            int iS = H.this.f2037a.S();
            int iD = H.this.f2037a.D();
            long jM = H.this.f2037a.m();
            if (objM != null && iS == -1) {
                jM -= hB0.h(objM, H.this.f2041e).n();
            }
            long jE = H.this.f2040d.e();
            if (this.f2062f && Objects.equals(objM, this.f2058b) && iS == this.f2059c && iD == this.f2060d && jM == this.f2061e) {
                if (jE - this.f2063g >= this.f2057a) {
                    H.this.f2039c.G(new I(2, this.f2057a));
                    return;
                }
                return;
            }
            this.f2062f = true;
            this.f2063g = jE;
            this.f2058b = objM;
            this.f2059c = iS;
            this.f2060d = iD;
            this.f2061e = jM;
            H.this.f2042f.k(2);
            H.this.f2042f.b(2, this.f2057a);
        }
    }

    public final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f2065a;

        /* renamed from: b, reason: collision with root package name */
        public Object f2066b;

        /* renamed from: c, reason: collision with root package name */
        public int f2067c;

        /* renamed from: d, reason: collision with root package name */
        public int f2068d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2069e;

        /* renamed from: f, reason: collision with root package name */
        public long f2070f;

        public e(int i7) {
            this.f2065a = i7;
        }

        public void a() {
            long duration;
            B0.H hB0 = H.this.f2037a.b0();
            Object objM = hB0.q() ? null : hB0.m(H.this.f2037a.x());
            int iS = H.this.f2037a.S();
            int iD = H.this.f2037a.D();
            long jM = H.this.f2037a.m();
            if (objM == null || iS != -1) {
                duration = iS != -1 ? H.this.f2037a.getDuration() : -9223372036854775807L;
            } else {
                hB0.h(objM, H.this.f2041e);
                jM -= H.this.f2041e.n();
                duration = H.this.f2041e.j();
            }
            boolean zR = H.this.f2037a.R();
            if (!zR || duration == -9223372036854775807L || jM < duration) {
                H.this.f2042f.k(3);
                if (zR && duration != -9223372036854775807L) {
                    H.this.f2042f.b(3, (int) Math.ceil((duration - jM) / H.this.f2037a.f().f340a));
                }
                this.f2069e = false;
                return;
            }
            long jE = H.this.f2040d.e();
            if (this.f2069e && Objects.equals(objM, this.f2066b) && iS == this.f2067c && iD == this.f2068d) {
                if (jE - this.f2070f >= this.f2065a) {
                    H.this.f2039c.G(new I(3, this.f2065a));
                    return;
                }
                return;
            }
            this.f2069e = true;
            this.f2070f = jE;
            this.f2066b = objM;
            this.f2067c = iS;
            this.f2068d = iD;
            H.this.f2042f.k(3);
            H.this.f2042f.b(3, this.f2065a);
        }
    }

    public final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f2072a;

        /* renamed from: b, reason: collision with root package name */
        public int f2073b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2074c;

        /* renamed from: d, reason: collision with root package name */
        public long f2075d;

        public f(int i7) {
            this.f2072a = i7;
        }

        public void a() {
            int iZ = H.this.f2037a.Z();
            if (!H.this.f2037a.r() || H.this.f2037a.N() == 1 || H.this.f2037a.N() == 4 || iZ == 0 || iZ == 1) {
                if (this.f2074c) {
                    H.this.f2042f.k(4);
                }
                this.f2074c = false;
                return;
            }
            long jE = H.this.f2040d.e();
            if (this.f2074c && this.f2073b == iZ) {
                if (jE - this.f2075d >= this.f2072a) {
                    H.this.f2039c.G(new I(4, this.f2072a));
                }
            } else {
                this.f2074c = true;
                this.f2075d = jE;
                this.f2073b = iZ;
                H.this.f2042f.k(4);
                H.this.f2042f.b(4, this.f2072a);
            }
        }
    }

    public H(B0.D d7, b bVar, InterfaceC0321g interfaceC0321g, int i7, int i8, int i9, int i10) {
        this.f2037a = d7;
        this.f2039c = bVar;
        this.f2040d = interfaceC0321g;
        this.f2042f = interfaceC0321g.c(d7.c0(), new Handler.Callback() { // from class: E0.G
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f2036l.h(message);
            }
        });
        this.f2043g = new c(i7);
        this.f2044h = new d(i8);
        this.f2045i = new e(i9);
        this.f2046j = new f(i10);
        a aVar = new a();
        this.f2038b = aVar;
        d7.B(aVar);
    }

    public final boolean h(Message message) {
        int i7 = message.what;
        if (i7 == 1) {
            this.f2043g.a();
            return true;
        }
        if (i7 == 2) {
            this.f2044h.a();
            return true;
        }
        if (i7 == 3) {
            this.f2045i.a();
            return true;
        }
        if (i7 != 4) {
            return false;
        }
        this.f2046j.a();
        return true;
    }

    public final void i() {
        this.f2043g.a();
        this.f2044h.a();
        this.f2045i.a();
        this.f2046j.a();
    }

    public void j() {
        this.f2042f.m(null);
        this.f2037a.w(this.f2038b);
    }
}
