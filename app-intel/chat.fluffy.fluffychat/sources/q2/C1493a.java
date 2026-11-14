package q2;

import M5.A;
import M5.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import z5.C1889t;

/* renamed from: q2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1493a {

    /* renamed from: a, reason: collision with root package name */
    public final C0255a f21410a = new C0255a(null);

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f21411b = new HashMap();

    /* renamed from: q2.a$a, reason: collision with other inner class name */
    public static final class C0255a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f21412a;

        /* renamed from: b, reason: collision with root package name */
        public List f21413b;

        /* renamed from: c, reason: collision with root package name */
        public C0255a f21414c = this;

        /* renamed from: d, reason: collision with root package name */
        public C0255a f21415d = this;

        public C0255a(Object obj) {
            this.f21412a = obj;
        }

        public final void a(Object obj) {
            List arrayList = this.f21413b;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f21413b = arrayList;
            }
            arrayList.add(obj);
        }

        public final Object b() {
            return this.f21412a;
        }

        public final C0255a c() {
            return this.f21415d;
        }

        public final C0255a d() {
            return this.f21414c;
        }

        public final int e() {
            List list = this.f21413b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final Object f() {
            List list = this.f21413b;
            if (list == null) {
                return null;
            }
            return C1889t.x(list);
        }

        public final void g(C0255a c0255a) {
            m.e(c0255a, "<set-?>");
            this.f21415d = c0255a;
        }

        public final void h(C0255a c0255a) {
            m.e(c0255a, "<set-?>");
            this.f21414c = c0255a;
        }
    }

    public final void a(C0255a c0255a) {
        c0255a.c().h(c0255a);
        c0255a.d().g(c0255a);
    }

    public final void b(C0255a c0255a) {
        e(c0255a);
        c0255a.h(this.f21410a);
        c0255a.g(this.f21410a.c());
        a(c0255a);
    }

    public final void c(C0255a c0255a) {
        e(c0255a);
        c0255a.h(this.f21410a.d());
        c0255a.g(this.f21410a);
        a(c0255a);
    }

    public final void d(Object obj, Object obj2) {
        HashMap map = this.f21411b;
        Object obj3 = map.get(obj);
        Object obj4 = obj3;
        if (obj3 == null) {
            C0255a c0255a = new C0255a(obj);
            c(c0255a);
            map.put(obj, c0255a);
            obj4 = c0255a;
        }
        ((C0255a) obj4).a(obj2);
    }

    public final void e(C0255a c0255a) {
        c0255a.d().g(c0255a.c());
        c0255a.c().h(c0255a.d());
    }

    public final Object f() {
        for (C0255a c0255aD = this.f21410a.d(); !m.a(c0255aD, this.f21410a); c0255aD = c0255aD.d()) {
            Object objF = c0255aD.f();
            if (objF != null) {
                return objF;
            }
            e(c0255aD);
            HashMap map = this.f21411b;
            Object objB = c0255aD.b();
            if (map == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            A.b(map).remove(objB);
        }
        return null;
    }

    public final Object g(Object obj) {
        HashMap map = this.f21411b;
        Object c0255a = map.get(obj);
        if (c0255a == null) {
            c0255a = new C0255a(obj);
            map.put(obj, c0255a);
        }
        C0255a c0255a2 = (C0255a) c0255a;
        b(c0255a2);
        return c0255a2.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedMultimap( ");
        C0255a c0255aC = this.f21410a.c();
        while (!m.a(c0255aC, this.f21410a)) {
            sb.append('{');
            sb.append(c0255aC.b());
            sb.append(':');
            sb.append(c0255aC.e());
            sb.append('}');
            c0255aC = c0255aC.c();
            if (!m.a(c0255aC, this.f21410a)) {
                sb.append(", ");
            }
        }
        sb.append(" )");
        String string = sb.toString();
        m.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
