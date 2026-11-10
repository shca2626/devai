package k6;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.r;

/* loaded from: classes3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final s f19498a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19499b;

    /* renamed from: c, reason: collision with root package name */
    public final r f19500c;

    /* renamed from: d, reason: collision with root package name */
    public final z f19501d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f19502e;

    /* renamed from: f, reason: collision with root package name */
    public volatile C1290d f19503f;

    public y(a aVar) {
        this.f19498a = aVar.f19504a;
        this.f19499b = aVar.f19505b;
        this.f19500c = aVar.f19506c.d();
        this.f19501d = aVar.f19507d;
        this.f19502e = l6.c.t(aVar.f19508e);
    }

    public z a() {
        return this.f19501d;
    }

    public C1290d b() {
        C1290d c1290d = this.f19503f;
        if (c1290d != null) {
            return c1290d;
        }
        C1290d c1290dK = C1290d.k(this.f19500c);
        this.f19503f = c1290dK;
        return c1290dK;
    }

    public String c(String str) {
        return this.f19500c.c(str);
    }

    public List d(String str) {
        return this.f19500c.i(str);
    }

    public r e() {
        return this.f19500c;
    }

    public boolean f() {
        return this.f19498a.m();
    }

    public String g() {
        return this.f19499b;
    }

    public a h() {
        return new a(this);
    }

    public s i() {
        return this.f19498a;
    }

    public String toString() {
        return "Request{method=" + this.f19499b + ", url=" + this.f19498a + ", tags=" + this.f19502e + '}';
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public s f19504a;

        /* renamed from: b, reason: collision with root package name */
        public String f19505b;

        /* renamed from: c, reason: collision with root package name */
        public r.a f19506c;

        /* renamed from: d, reason: collision with root package name */
        public z f19507d;

        /* renamed from: e, reason: collision with root package name */
        public Map f19508e;

        public a() {
            this.f19508e = Collections.EMPTY_MAP;
            this.f19505b = "GET";
            this.f19506c = new r.a();
        }

        public a a(String str, String str2) {
            this.f19506c.a(str, str2);
            return this;
        }

        public y b() {
            if (this.f19504a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c(C1290d c1290d) {
            String string = c1290d.toString();
            return string.isEmpty() ? g("Cache-Control") : d("Cache-Control", string);
        }

        public a d(String str, String str2) {
            this.f19506c.g(str, str2);
            return this;
        }

        public a e(r rVar) {
            this.f19506c = rVar.f();
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
                this.f19505b = str;
                this.f19507d = zVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a g(String str) {
            this.f19506c.f(str);
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
            this.f19504a = sVar;
            return this;
        }

        public a(y yVar) {
            Map map = Collections.EMPTY_MAP;
            this.f19508e = map;
            this.f19504a = yVar.f19498a;
            this.f19505b = yVar.f19499b;
            this.f19507d = yVar.f19501d;
            this.f19508e = yVar.f19502e.isEmpty() ? map : new LinkedHashMap(yVar.f19502e);
            this.f19506c = yVar.f19500c.f();
        }
    }
}
