package K0;

import B0.C0300b;
import E0.InterfaceC0321g;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* renamed from: K0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0490l {

    /* renamed from: K0.l$b */
    public static final class b extends Exception {
        public b(String str) {
            super((String) Y.h.j(str));
        }
    }

    /* renamed from: K0.l$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final B0.s f5257a;

        /* renamed from: b, reason: collision with root package name */
        public final C0300b f5258b;

        /* renamed from: c, reason: collision with root package name */
        public final AudioDeviceInfo f5259c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f5260d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f5261e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f5262f;

        /* renamed from: g, reason: collision with root package name */
        public final int f5263g;

        /* renamed from: h, reason: collision with root package name */
        public final int f5264h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f5265i;

        /* renamed from: j, reason: collision with root package name */
        public final int f5266j;

        /* renamed from: K0.l$c$a */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final B0.s f5267a;

            /* renamed from: c, reason: collision with root package name */
            public AudioDeviceInfo f5269c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f5270d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f5271e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f5272f;

            /* renamed from: i, reason: collision with root package name */
            public boolean f5275i;

            /* renamed from: b, reason: collision with root package name */
            public C0300b f5268b = C0300b.f612i;

            /* renamed from: g, reason: collision with root package name */
            public int f5273g = 0;

            /* renamed from: h, reason: collision with root package name */
            public int f5274h = -1;

            /* renamed from: j, reason: collision with root package name */
            public int f5276j = -1;

            public a(B0.s sVar) {
                this.f5267a = sVar;
            }

            public c k() {
                return new c(this);
            }

            public a l(C0300b c0300b) {
                this.f5268b = c0300b;
                return this;
            }

            public a m(int i7) {
                this.f5273g = i7;
                return this;
            }

            public a n(boolean z7) {
                this.f5270d = z7;
                return this;
            }

            public a o(boolean z7) {
                this.f5272f = z7;
                return this;
            }

            public a p(boolean z7) {
                this.f5271e = z7;
                return this;
            }

            public a q(boolean z7) {
                this.f5275i = z7;
                return this;
            }

            public a r(int i7) {
                this.f5276j = i7;
                return this;
            }

            public a s(AudioDeviceInfo audioDeviceInfo) {
                this.f5269c = audioDeviceInfo;
                return this;
            }

            public a t(int i7) {
                this.f5274h = i7;
                return this;
            }
        }

        public c(a aVar) {
            this.f5257a = aVar.f5267a;
            this.f5258b = aVar.f5268b;
            this.f5259c = aVar.f5269c;
            this.f5260d = aVar.f5270d;
            this.f5261e = aVar.f5271e;
            this.f5262f = aVar.f5272f;
            this.f5263g = aVar.f5273g;
            this.f5264h = aVar.f5274h;
            this.f5265i = aVar.f5275i;
            this.f5266j = aVar.f5276j;
        }
    }

    /* renamed from: K0.l$d */
    public static final class d {

        /* renamed from: e, reason: collision with root package name */
        public static final d f5277e = new a().e();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f5278a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5279b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5280c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5281d;

        /* renamed from: K0.l$d$a */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f5282a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f5283b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f5284c;

            /* renamed from: d, reason: collision with root package name */
            public int f5285d = 0;

            public d e() {
                if (this.f5282a || !(this.f5283b || this.f5284c)) {
                    return new d(this);
                }
                throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupportedForOffload is false");
            }

            public a f(int i7) {
                this.f5285d = i7;
                return this;
            }

            public a g(boolean z7) {
                this.f5282a = z7;
                return this;
            }

            public a h(boolean z7) {
                this.f5283b = z7;
                return this;
            }

            public a i(boolean z7) {
                this.f5284c = z7;
                return this;
            }
        }

        public d(a aVar) {
            this.f5278a = aVar.f5282a;
            this.f5279b = aVar.f5283b;
            this.f5280c = aVar.f5284c;
            this.f5281d = aVar.f5285d;
        }
    }

    /* renamed from: K0.l$e */
    public static final class e extends Exception {
        public e() {
        }

        public e(Throwable th) {
            super(th);
        }
    }

    /* renamed from: K0.l$f */
    public interface f {
        void a();
    }

    /* renamed from: K0.l$g */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f5286a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5287b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5288c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f5289d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f5290e;

        /* renamed from: f, reason: collision with root package name */
        public final int f5291f;

        /* renamed from: g, reason: collision with root package name */
        public final C0300b f5292g;

        /* renamed from: h, reason: collision with root package name */
        public final int f5293h;

        /* renamed from: i, reason: collision with root package name */
        public final int f5294i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f5295j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f5296k;

        /* renamed from: K0.l$g$a */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public int f5297a;

            /* renamed from: b, reason: collision with root package name */
            public int f5298b;

            /* renamed from: c, reason: collision with root package name */
            public int f5299c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f5300d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f5301e;

            /* renamed from: f, reason: collision with root package name */
            public int f5302f;

            /* renamed from: g, reason: collision with root package name */
            public C0300b f5303g;

            /* renamed from: h, reason: collision with root package name */
            public int f5304h;

            /* renamed from: i, reason: collision with root package name */
            public int f5305i;

            /* renamed from: j, reason: collision with root package name */
            public boolean f5306j;

            /* renamed from: k, reason: collision with root package name */
            public boolean f5307k;

            public g l() {
                return new g(this);
            }

            public a m(C0300b c0300b) {
                this.f5303g = c0300b;
                return this;
            }

            public a n(int i7) {
                this.f5304h = i7;
                return this;
            }

            public a o(int i7) {
                this.f5302f = i7;
                return this;
            }

            public a p(int i7) {
                this.f5299c = i7;
                return this;
            }

            public a q(int i7) {
                this.f5297a = i7;
                return this;
            }

            public a r(boolean z7) {
                this.f5301e = z7;
                return this;
            }

            public a s(boolean z7) {
                this.f5300d = z7;
                return this;
            }

            public a t(int i7) {
                this.f5298b = i7;
                return this;
            }

            public a u(boolean z7) {
                this.f5307k = z7;
                return this;
            }

            public a v(boolean z7) {
                this.f5306j = z7;
                return this;
            }

            public a w(int i7) {
                this.f5305i = i7;
                return this;
            }

            public a() {
                this.f5303g = C0300b.f612i;
                this.f5304h = 0;
                this.f5305i = -1;
            }

            public a(g gVar) {
                this.f5297a = gVar.f5286a;
                this.f5298b = gVar.f5287b;
                this.f5299c = gVar.f5288c;
                this.f5300d = gVar.f5289d;
                this.f5301e = gVar.f5290e;
                this.f5302f = gVar.f5291f;
                this.f5303g = gVar.f5292g;
                this.f5304h = gVar.f5293h;
                this.f5305i = gVar.f5294i;
                this.f5306j = gVar.f5295j;
                this.f5307k = gVar.f5296k;
            }
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && g.class == obj.getClass()) {
                g gVar = (g) obj;
                if (this.f5286a == gVar.f5286a && this.f5287b == gVar.f5287b && this.f5288c == gVar.f5288c && this.f5289d == gVar.f5289d && this.f5290e == gVar.f5290e && this.f5291f == gVar.f5291f && this.f5293h == gVar.f5293h && this.f5294i == gVar.f5294i && this.f5295j == gVar.f5295j && this.f5296k == gVar.f5296k && this.f5292g.equals(gVar.f5292g)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f5286a), Integer.valueOf(this.f5287b), Integer.valueOf(this.f5288c), Boolean.valueOf(this.f5289d), Boolean.valueOf(this.f5290e), Integer.valueOf(this.f5291f), this.f5292g, Integer.valueOf(this.f5293h), Integer.valueOf(this.f5294i), Boolean.valueOf(this.f5296k), Boolean.valueOf(this.f5295j));
        }

        public g(a aVar) {
            this.f5286a = aVar.f5297a;
            this.f5287b = aVar.f5298b;
            this.f5288c = aVar.f5299c;
            this.f5289d = aVar.f5300d;
            this.f5290e = aVar.f5301e;
            this.f5291f = aVar.f5302f;
            this.f5292g = aVar.f5303g;
            this.f5293h = aVar.f5304h;
            this.f5294i = aVar.f5305i;
            this.f5295j = aVar.f5306j;
            this.f5296k = aVar.f5307k;
        }
    }

    void i(InterfaceC0321g interfaceC0321g);

    d j(c cVar);

    InterfaceC0489k k(g gVar);

    g l(c cVar);

    void m(f fVar);

    void release();
}
