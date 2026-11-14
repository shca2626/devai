package r5;

import java.util.List;
import z5.C1884o;

/* renamed from: r5.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1584o {

    /* renamed from: j, reason: collision with root package name */
    public static final a f22313j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22314a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22315b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22316c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22317d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f22318e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f22319f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f22320g;

    /* renamed from: h, reason: collision with root package name */
    public final Double f22321h;

    /* renamed from: i, reason: collision with root package name */
    public final String f22322i;

    /* renamed from: r5.o$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1584o a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue2 = ((Long) obj2).longValue();
            String str = (String) list.get(2);
            Object obj3 = list.get(3);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new C1584o(jLongValue, jLongValue2, str, ((Boolean) obj3).booleanValue(), (Long) list.get(4), (Long) list.get(5), (Long) list.get(6), (Double) list.get(7), (String) list.get(8));
        }

        public a() {
        }
    }

    public C1584o(long j7, long j8, String str, boolean z7, Long l7, Long l8, Long l9, Double d7, String str2) {
        this.f22314a = j7;
        this.f22315b = j8;
        this.f22316c = str;
        this.f22317d = z7;
        this.f22318e = l7;
        this.f22319f = l8;
        this.f22320g = l9;
        this.f22321h = d7;
        this.f22322i = str2;
    }

    public final List a() {
        return C1884o.l(Long.valueOf(this.f22314a), Long.valueOf(this.f22315b), this.f22316c, Boolean.valueOf(this.f22317d), this.f22318e, this.f22319f, this.f22320g, this.f22321h, this.f22322i);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1584o.class)) {
            if (this == obj) {
                return true;
            }
            C1584o c1584o = (C1584o) obj;
            C1592x c1592x = C1592x.f22337a;
            if (c1592x.a(Long.valueOf(this.f22314a), Long.valueOf(c1584o.f22314a)) && c1592x.a(Long.valueOf(this.f22315b), Long.valueOf(c1584o.f22315b)) && c1592x.a(this.f22316c, c1584o.f22316c) && c1592x.a(Boolean.valueOf(this.f22317d), Boolean.valueOf(c1584o.f22317d)) && c1592x.a(this.f22318e, c1584o.f22318e) && c1592x.a(this.f22319f, c1584o.f22319f) && c1592x.a(this.f22320g, c1584o.f22320g) && c1592x.a(this.f22321h, c1584o.f22321h) && c1592x.a(this.f22322i, c1584o.f22322i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1584o.class.hashCode() * 31;
        C1592x c1592x = C1592x.f22337a;
        return ((((((((((((((((iHashCode + c1592x.b(Long.valueOf(this.f22314a))) * 31) + c1592x.b(Long.valueOf(this.f22315b))) * 31) + c1592x.b(this.f22316c)) * 31) + c1592x.b(Boolean.valueOf(this.f22317d))) * 31) + c1592x.b(this.f22318e)) * 31) + c1592x.b(this.f22319f)) * 31) + c1592x.b(this.f22320g)) * 31) + c1592x.b(this.f22321h)) * 31) + c1592x.b(this.f22322i);
    }

    public String toString() {
        return "ExoPlayerVideoTrackData(groupIndex=" + this.f22314a + ", trackIndex=" + this.f22315b + ", label=" + this.f22316c + ", isSelected=" + this.f22317d + ", bitrate=" + this.f22318e + ", width=" + this.f22319f + ", height=" + this.f22320g + ", frameRate=" + this.f22321h + ", codec=" + this.f22322i + ")";
    }
}
