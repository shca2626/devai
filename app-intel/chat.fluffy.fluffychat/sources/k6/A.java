package k6;

import java.io.Closeable;
import java.io.IOException;
import k6.r;

/* loaded from: classes3.dex */
public final class A implements Closeable {

    /* renamed from: l, reason: collision with root package name */
    public final y f19113l;

    /* renamed from: m, reason: collision with root package name */
    public final w f19114m;

    /* renamed from: n, reason: collision with root package name */
    public final int f19115n;

    /* renamed from: o, reason: collision with root package name */
    public final String f19116o;

    /* renamed from: p, reason: collision with root package name */
    public final q f19117p;

    /* renamed from: q, reason: collision with root package name */
    public final r f19118q;

    /* renamed from: r, reason: collision with root package name */
    public final B f19119r;

    /* renamed from: s, reason: collision with root package name */
    public final A f19120s;

    /* renamed from: t, reason: collision with root package name */
    public final A f19121t;

    /* renamed from: u, reason: collision with root package name */
    public final A f19122u;

    /* renamed from: v, reason: collision with root package name */
    public final long f19123v;

    /* renamed from: w, reason: collision with root package name */
    public final long f19124w;

    /* renamed from: x, reason: collision with root package name */
    public volatile C1290d f19125x;

    public A(a aVar) {
        this.f19113l = aVar.f19126a;
        this.f19114m = aVar.f19127b;
        this.f19115n = aVar.f19128c;
        this.f19116o = aVar.f19129d;
        this.f19117p = aVar.f19130e;
        this.f19118q = aVar.f19131f.d();
        this.f19119r = aVar.f19132g;
        this.f19120s = aVar.f19133h;
        this.f19121t = aVar.f19134i;
        this.f19122u = aVar.f19135j;
        this.f19123v = aVar.f19136k;
        this.f19124w = aVar.f19137l;
    }

    public w B() {
        return this.f19114m;
    }

    public long C() {
        return this.f19124w;
    }

    public y E() {
        return this.f19113l;
    }

    public long F() {
        return this.f19123v;
    }

    public B a() {
        return this.f19119r;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        B b7 = this.f19119r;
        if (b7 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        b7.close();
    }

    public C1290d d() {
        C1290d c1290d = this.f19125x;
        if (c1290d != null) {
            return c1290d;
        }
        C1290d c1290dK = C1290d.k(this.f19118q);
        this.f19125x = c1290dK;
        return c1290dK;
    }

    public A e() {
        return this.f19121t;
    }

    public int f() {
        return this.f19115n;
    }

    public q i() {
        return this.f19117p;
    }

    public String j(String str) {
        return n(str, null);
    }

    public String n(String str, String str2) {
        String strC = this.f19118q.c(str);
        return strC != null ? strC : str2;
    }

    public r o() {
        return this.f19118q;
    }

    public boolean r() {
        int i7 = this.f19115n;
        return i7 >= 200 && i7 < 300;
    }

    public String t() {
        return this.f19116o;
    }

    public String toString() {
        return "Response{protocol=" + this.f19114m + ", code=" + this.f19115n + ", message=" + this.f19116o + ", url=" + this.f19113l.i() + '}';
    }

    public A u() {
        return this.f19120s;
    }

    public a x() {
        return new a(this);
    }

    public A y() {
        return this.f19122u;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public y f19126a;

        /* renamed from: b, reason: collision with root package name */
        public w f19127b;

        /* renamed from: c, reason: collision with root package name */
        public int f19128c;

        /* renamed from: d, reason: collision with root package name */
        public String f19129d;

        /* renamed from: e, reason: collision with root package name */
        public q f19130e;

        /* renamed from: f, reason: collision with root package name */
        public r.a f19131f;

        /* renamed from: g, reason: collision with root package name */
        public B f19132g;

        /* renamed from: h, reason: collision with root package name */
        public A f19133h;

        /* renamed from: i, reason: collision with root package name */
        public A f19134i;

        /* renamed from: j, reason: collision with root package name */
        public A f19135j;

        /* renamed from: k, reason: collision with root package name */
        public long f19136k;

        /* renamed from: l, reason: collision with root package name */
        public long f19137l;

        public a() {
            this.f19128c = -1;
            this.f19131f = new r.a();
        }

        public a a(String str, String str2) {
            this.f19131f.a(str, str2);
            return this;
        }

        public a b(B b7) {
            this.f19132g = b7;
            return this;
        }

        public A c() {
            if (this.f19126a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f19127b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f19128c >= 0) {
                if (this.f19129d != null) {
                    return new A(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f19128c);
        }

        public a d(A a7) {
            if (a7 != null) {
                f("cacheResponse", a7);
            }
            this.f19134i = a7;
            return this;
        }

        public final void e(A a7) {
            if (a7.f19119r != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, A a7) {
            if (a7.f19119r != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (a7.f19120s != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (a7.f19121t != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (a7.f19122u == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a g(int i7) {
            this.f19128c = i7;
            return this;
        }

        public a h(q qVar) {
            this.f19130e = qVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f19131f.g(str, str2);
            return this;
        }

        public a j(r rVar) {
            this.f19131f = rVar.f();
            return this;
        }

        public a k(String str) {
            this.f19129d = str;
            return this;
        }

        public a l(A a7) {
            if (a7 != null) {
                f("networkResponse", a7);
            }
            this.f19133h = a7;
            return this;
        }

        public a m(A a7) {
            if (a7 != null) {
                e(a7);
            }
            this.f19135j = a7;
            return this;
        }

        public a n(w wVar) {
            this.f19127b = wVar;
            return this;
        }

        public a o(long j7) {
            this.f19137l = j7;
            return this;
        }

        public a p(y yVar) {
            this.f19126a = yVar;
            return this;
        }

        public a q(long j7) {
            this.f19136k = j7;
            return this;
        }

        public a(A a7) {
            this.f19128c = -1;
            this.f19126a = a7.f19113l;
            this.f19127b = a7.f19114m;
            this.f19128c = a7.f19115n;
            this.f19129d = a7.f19116o;
            this.f19130e = a7.f19117p;
            this.f19131f = a7.f19118q.f();
            this.f19132g = a7.f19119r;
            this.f19133h = a7.f19120s;
            this.f19134i = a7.f19121t;
            this.f19135j = a7.f19122u;
            this.f19136k = a7.f19123v;
            this.f19137l = a7.f19124w;
        }
    }
}
