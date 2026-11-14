package k6;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.r;

/* loaded from: classes3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final s f19497a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19498b;

    /* renamed from: c, reason: collision with root package name */
    public final r f19499c;

    /* renamed from: d, reason: collision with root package name */
    public final z f19500d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f19501e;

    /* renamed from: f, reason: collision with root package name */
    public volatile C1289d f19502f;

    public y(a aVar) {
        this.f19497a = aVar.f19503a;
        this.f19498b = aVar.f19504b;
        this.f19499c = aVar.f19505c.d();
        this.f19500d = aVar.f19506d;
        this.f19501e = l6.c.t(aVar.f19507e);
    }

    public z a() {
        return this.f19500d;
    }

    public C1289d b() {
        C1289d c1289d = this.f19502f;
        if (c1289d != null) {
            return c1289d;
        }
        C1289d c1289dK = C1289d.k(this.f19499c);
        this.f19502f = c1289dK;
        return c1289dK;
    }

    public String c(String str) {
        return this.f19499c.c(str);
    }

    public List d(String str) {
        return this.f19499c.i(str);
    }

    public r e() {
        return this.f19499c;
    }

    public boolean f() {
        return this.f19497a.m();
    }

    public String g() {
        return this.f19498b;
    }

    public a h() {
        return new a(this);
    }

    public s i() {
        return this.f19497a;
    }

    public String toString() {
        return "Request{method=" + this.f19498b + ", url=" + this.f19497a + ", tags=" + this.f19501e + '}';
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public s f19503a;

        /* renamed from: b, reason: collision with root package name */
        public String f19504b;

        /* renamed from: c, reason: collision with root package name */
        public r.a f19505c;

        /* renamed from: d, reason: collision with root package name */
        public z f19506d;

        /* renamed from: e, reason: collision with root package name */
        public Map f19507e;

        public a() {
            this.f19507e = Collections.EMPTY_MAP;
            this.f19504b = "GET";
            this.f19505c = new r.a();
        }

        public a a(String str, String str2) {
            this.f19505c.a(str, str2);
            return this;
        }

        public y b() {
            if (this.f19503a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c(C1289d c1289d) {
            String string = c1289d.toString();
            return string.isEmpty() ? g("Cache-Control") : d("Cache-Control", string);
        }

        public a d(String str, String str2) {
            this.f19505c.g(str, str2);
            return this;
        }

        public a e(r rVar) {
            this.f19505c = rVar.f();
            return this;
        }

        public a f(String str, z zVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (zVar != null && !o6.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (zVar != null || !o6.f.e(str)) {
                this.f19504b = str;
                this.f19506d = zVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a g(String str) {
            this.f19505c.f(str);
            return this;
        }

        public a h(String str) {
            String str2;
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str2 = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str2 = "https:" + str.substring(4);
            } else {
                str2 = str;
            }
            return i(s.k(str2));
        }

        public a i(s sVar) {
            if (sVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f19503a = sVar;
            return this;
        }

        public a(y yVar) {
            Map map = Collections.EMPTY_MAP;
            this.f19507e = map;
            this.f19503a = yVar.f19497a;
            this.f19504b = yVar.f19498b;
            this.f19506d = yVar.f19500d;
            this.f19507e = yVar.f19501e.isEmpty() ? map : new LinkedHashMap(yVar.f19501e);
            this.f19505c = yVar.f19499c.f();
        }
    }
}
