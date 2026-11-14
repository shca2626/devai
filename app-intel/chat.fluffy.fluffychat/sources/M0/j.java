package M0;

import B0.s;
import M0.k;
import android.net.Uri;
import java.util.Collections;
import java.util.List;
import k3.AbstractC1278v;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final long f5583a;

    /* renamed from: b, reason: collision with root package name */
    public final s f5584b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC1278v f5585c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5586d;

    /* renamed from: e, reason: collision with root package name */
    public final List f5587e;

    /* renamed from: f, reason: collision with root package name */
    public final List f5588f;

    /* renamed from: g, reason: collision with root package name */
    public final List f5589g;

    /* renamed from: h, reason: collision with root package name */
    public final i f5590h;

    public static class c extends j {

        /* renamed from: i, reason: collision with root package name */
        public final Uri f5592i;

        /* renamed from: j, reason: collision with root package name */
        public final long f5593j;

        /* renamed from: k, reason: collision with root package name */
        public final String f5594k;

        /* renamed from: l, reason: collision with root package name */
        public final i f5595l;

        /* renamed from: m, reason: collision with root package name */
        public final m f5596m;

        public c(long j7, s sVar, List list, k.e eVar, List list2, List list3, List list4, String str, long j8) {
            super(j7, sVar, list, eVar, list2, list3, list4);
            this.f5592i = Uri.parse(((M0.b) list.get(0)).f5529a);
            i iVarC = eVar.c();
            this.f5595l = iVarC;
            this.f5594k = str;
            this.f5593j = j8;
            this.f5596m = iVarC != null ? null : new m(new i(null, 0L, j8));
        }

        @Override // M0.j
        public String k() {
            return this.f5594k;
        }

        @Override // M0.j
        public L0.g l() {
            return this.f5596m;
        }

        @Override // M0.j
        public i m() {
            return this.f5595l;
        }
    }

    public static j o(long j7, s sVar, List list, k kVar, List list2, List list3, List list4, String str) {
        if (kVar instanceof k.e) {
            return new c(j7, sVar, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j7, sVar, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String k();

    public abstract L0.g l();

    public abstract i m();

    public i n() {
        return this.f5590h;
    }

    public j(long j7, s sVar, List list, k kVar, List list2, List list3, List list4) {
        j3.o.d(!list.isEmpty());
        this.f5583a = j7;
        this.f5584b = sVar;
        this.f5585c = AbstractC1278v.r(list);
        this.f5587e = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list2);
        this.f5588f = list3;
        this.f5589g = list4;
        this.f5590h = kVar.a(this);
        this.f5586d = kVar.b();
    }

    public static class b extends j implements L0.g {

        /* renamed from: i, reason: collision with root package name */
        public final k.a f5591i;

        public b(long j7, s sVar, List list, k.a aVar, List list2, List list3, List list4) {
            super(j7, sVar, list, aVar, list2, list3, list4);
            this.f5591i = aVar;
        }

        @Override // L0.g
        public long a(long j7) {
            return this.f5591i.j(j7);
        }

        @Override // L0.g
        public long b(long j7, long j8) {
            return this.f5591i.h(j7, j8);
        }

        @Override // L0.g
        public long c(long j7, long j8) {
            return this.f5591i.d(j7, j8);
        }

        @Override // L0.g
        public long d(long j7, long j8) {
            return this.f5591i.f(j7, j8);
        }

        @Override // L0.g
        public i e(long j7) {
            return this.f5591i.k(this, j7);
        }

        @Override // L0.g
        public long f(long j7, long j8) {
            return this.f5591i.i(j7, j8);
        }

        @Override // L0.g
        public boolean g() {
            return this.f5591i.l();
        }

        @Override // L0.g
        public long h() {
            return this.f5591i.e();
        }

        @Override // L0.g
        public long i(long j7) {
            return this.f5591i.g(j7);
        }

        @Override // L0.g
        public long j(long j7, long j8) {
            return this.f5591i.c(j7, j8);
        }

        @Override // M0.j
        public String k() {
            return null;
        }

        @Override // M0.j
        public i m() {
            return null;
        }

        @Override // M0.j
        public L0.g l() {
            return this;
        }
    }
}
