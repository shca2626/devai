package k6;

import java.io.Closeable;
import java.io.IOException;
import k6.r;

/* loaded from: classes3.dex */
public final class A implements Closeable {

    /* renamed from: l, reason: collision with root package name */
    public final y f19112l;

    /* renamed from: m, reason: collision with root package name */
    public final w f19113m;

    /* renamed from: n, reason: collision with root package name */
    public final int f19114n;

    /* renamed from: o, reason: collision with root package name */
    public final String f19115o;

    /* renamed from: p, reason: collision with root package name */
    public final q f19116p;

    /* renamed from: q, reason: collision with root package name */
    public final r f19117q;

    /* renamed from: r, reason: collision with root package name */
    public final B f19118r;

    /* renamed from: s, reason: collision with root package name */
    public final A f19119s;

    /* renamed from: t, reason: collision with root package name */
    public final A f19120t;

    /* renamed from: u, reason: collision with root package name */
    public final A f19121u;

    /* renamed from: v, reason: collision with root package name */
    public final long f19122v;

    /* renamed from: w, reason: collision with root package name */
    public final long f19123w;

    /* renamed from: x, reason: collision with root package name */
    public volatile C1289d f19124x;

    public A(a aVar) {
        this.f19112l = aVar.f19125a;
        this.f19113m = aVar.f19126b;
        this.f19114n = aVar.f19127c;
        this.f19115o = aVar.f19128d;
        this.f19116p = aVar.f19129e;
        this.f19117q = aVar.f19130f.d();
        this.f19118r = aVar.f19131g;
        this.f19119s = aVar.f19132h;
        this.f19120t = aVar.f19133i;
        this.f19121u = aVar.f19134j;
        this.f19122v = aVar.f19135k;
        this.f19123w = aVar.f19136l;
    }

    public w B() {
        return this.f19113m;
    }

    public long C() {
        return this.f19123w;
    }

    public y E() {
        return this.f19112l;
    }

    public long F() {
        return this.f19122v;
    }

    public B a() {
        return this.f19118r;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        B b7 = this.f19118r;
        if (b7 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        b7.close();
    }

    public C1289d d() {
        C1289d c1289d = this.f19124x;
        if (c1289d != null) {
            return c1289d;
        }
        C1289d c1289dK = C1289d.k(this.f19117q);
        this.f19124x = c1289dK;
        return c1289dK;
    }

    public A e() {
        return this.f19120t;
    }

    public int f() {
        return this.f19114n;
    }

    public q i() {
        return this.f19116p;
    }

    public String j(String str) {
        return n(str, null);
    }

    public String n(String str, String str2) {
        String strC = this.f19117q.c(str);
        return strC != null ? strC : str2;
    }

    public r o() {
        return this.f19117q;
    }

    public boolean r() {
        int i7 = this.f19114n;
        return i7 >= 200 && i7 < 300;
    }

    public String t() {
        return this.f19115o;
    }

    public String toString() {
        return "Response{protocol=" + this.f19113m + ", code=" + this.f19114n + ", message=" + this.f19115o + ", url=" + this.f19112l.i() + '}';
    }

    public A u() {
        return this.f19119s;
    }

    public a x() {
        return new a(this);
    }

    public A y() {
        return this.f19121u;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public y f19125a;

        /* renamed from: b, reason: collision with root package name */
        public w f19126b;

        /* renamed from: c, reason: collision with root package name */
        public int f19127c;

        /* renamed from: d, reason: collision with root package name */
        public String f19128d;

        /* renamed from: e, reason: collision with root package name */
        public q f19129e;

        /* renamed from: f, reason: collision with root package name */
        public r.a f19130f;

        /* renamed from: g, reason: collision with root package name */
        public B f19131g;

        /* renamed from: h, reason: collision with root package name */
        public A f19132h;

        /* renamed from: i, reason: collision with root package name */
        public A f19133i;

        /* renamed from: j, reason: collision with root package name */
        public A f19134j;

        /* renamed from: k, reason: collision with root package name */
        public long f19135k;

        /* renamed from: l, reason: collision with root package name */
        public long f19136l;

        public a() {
            this.f19127c = -1;
            this.f19130f = new r.a();
        }

        public a a(String str, String str2) {
            this.f19130f.a(str, str2);
            return this;
        }

        public a b(B b7) {
            this.f19131g = b7;
            return this;
        }

        public A c() {
            if (this.f19125a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f19126b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f19127c >= 0) {
                if (this.f19128d != null) {
                    return new A(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f19127c);
        }

        public a d(A a7) {
            if (a7 != null) {
                f("cacheResponse", a7);
            }
            this.f19133i = a7;
            return this;
        }

        public final void e(A a7) {
            if (a7.f19118r != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, A a7) {
            if (a7.f19118r != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (a7.f19119s != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (a7.f19120t != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (a7.f19121u == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a g(int i7) {
            this.f19127c = i7;
            return this;
        }

        public a h(q qVar) {
            this.f19129e = qVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f19130f.g(str, str2);
            return this;
        }

        public a j(r rVar) {
            this.f19130f = rVar.f();
            return this;
        }

        public a k(String str) {
            this.f19128d = str;
            return this;
        }

        public a l(A a7) {
            if (a7 != null) {
                f("networkResponse", a7);
            }
            this.f19132h = a7;
            return this;
        }

        public a m(A a7) {
            if (a7 != null) {
                e(a7);
            }
            this.f19134j = a7;
            return this;
        }

        public a n(w wVar) {
            this.f19126b = wVar;
            return this;
        }

        public a o(long j7) {
            this.f19136l = j7;
            return this;
        }

        public a p(y yVar) {
            this.f19125a = yVar;
            return this;
        }

        public a q(long j7) {
            this.f19135k = j7;
            return this;
        }

        public a(A a7) {
            this.f19127c = -1;
            this.f19125a = a7.f19112l;
            this.f19126b = a7.f19113m;
            this.f19127c = a7.f19114n;
            this.f19128d = a7.f19115o;
            this.f19129e = a7.f19116p;
            this.f19130f = a7.f19117q.f();
            this.f19131g = a7.f19118r;
            this.f19132h = a7.f19119s;
            this.f19133i = a7.f19120t;
            this.f19134j = a7.f19121u;
            this.f19135k = a7.f19122v;
            this.f19136l = a7.f19123w;
        }
    }
}
