package n2;

import M5.g;
import M5.m;
import java.util.ArrayList;
import java.util.List;
import r2.h;
import y5.AbstractC1817l;
import z5.C1881o;
import z5.C1889w;

/* renamed from: n2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1346a {

    /* renamed from: a, reason: collision with root package name */
    public final List f19876a;

    /* renamed from: b, reason: collision with root package name */
    public final List f19877b;

    /* renamed from: c, reason: collision with root package name */
    public final List f19878c;

    /* renamed from: d, reason: collision with root package name */
    public final List f19879d;

    public /* synthetic */ C1346a(List list, List list2, List list3, List list4, g gVar) {
        this(list, list2, list3, list4);
    }

    public final List a() {
        return this.f19879d;
    }

    public final List b() {
        return this.f19878c;
    }

    public final List c() {
        return this.f19876a;
    }

    public final List d() {
        return this.f19877b;
    }

    public final C0226a e() {
        return new C0226a(this);
    }

    public C1346a(List list, List list2, List list3, List list4) {
        this.f19876a = list;
        this.f19877b = list2;
        this.f19878c = list3;
        this.f19879d = list4;
    }

    /* renamed from: n2.a$a, reason: collision with other inner class name */
    public static final class C0226a {

        /* renamed from: a, reason: collision with root package name */
        public final List f19880a;

        /* renamed from: b, reason: collision with root package name */
        public final List f19881b;

        /* renamed from: c, reason: collision with root package name */
        public final List f19882c;

        /* renamed from: d, reason: collision with root package name */
        public final List f19883d;

        public C0226a() {
            this.f19880a = new ArrayList();
            this.f19881b = new ArrayList();
            this.f19882c = new ArrayList();
            this.f19883d = new ArrayList();
        }

        public final C0226a a(h hVar) {
            m.e(hVar, "decoder");
            this.f19883d.add(hVar);
            return this;
        }

        public final C0226a b(s2.g gVar, Class cls) {
            m.e(gVar, "fetcher");
            m.e(cls, "type");
            this.f19882c.add(AbstractC1817l.a(gVar, cls));
            return this;
        }

        public final C0226a c(u2.b bVar, Class cls) {
            m.e(bVar, "mapper");
            m.e(cls, "type");
            this.f19881b.add(AbstractC1817l.a(bVar, cls));
            return this;
        }

        public final C1346a d() {
            return new C1346a(C1889w.X(this.f19880a), C1889w.X(this.f19881b), C1889w.X(this.f19882c), C1889w.X(this.f19883d), null);
        }

        public C0226a(C1346a c1346a) {
            m.e(c1346a, "registry");
            this.f19880a = C1889w.Z(c1346a.c());
            this.f19881b = C1889w.Z(c1346a.d());
            this.f19882c = C1889w.Z(c1346a.b());
            this.f19883d = C1889w.Z(c1346a.a());
        }
    }

    public C1346a() {
        this(C1881o.i(), C1881o.i(), C1881o.i(), C1881o.i());
    }
}
