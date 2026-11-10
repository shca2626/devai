package r5;

import java.util.List;
import z5.C1881o;

/* renamed from: r5.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1585o {

    /* renamed from: j, reason: collision with root package name */
    public static final a f22307j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22308a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22309b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22310c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22311d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f22312e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f22313f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f22314g;

    /* renamed from: h, reason: collision with root package name */
    public final Double f22315h;

    /* renamed from: i, reason: collision with root package name */
    public final String f22316i;

    /* renamed from: r5.o$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1585o a(List list) {
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
            return new C1585o(jLongValue, jLongValue2, str, ((Boolean) obj3).booleanValue(), (Long) list.get(4), (Long) list.get(5), (Long) list.get(6), (Double) list.get(7), (String) list.get(8));
        }

        public a() {
        }
    }

    public C1585o(long j7, long j8, String str, boolean z7, Long l7, Long l8, Long l9, Double d7, String str2) {
        this.f22308a = j7;
        this.f22309b = j8;
        this.f22310c = str;
        this.f22311d = z7;
        this.f22312e = l7;
        this.f22313f = l8;
        this.f22314g = l9;
        this.f22315h = d7;
        this.f22316i = str2;
    }

    public final List a() {
        return C1881o.l(Long.valueOf(this.f22308a), Long.valueOf(this.f22309b), this.f22310c, Boolean.valueOf(this.f22311d), this.f22312e, this.f22313f, this.f22314g, this.f22315h, this.f22316i);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1585o.class)) {
            if (this == obj) {
                return true;
            }
            C1585o c1585o = (C1585o) obj;
            C1593x c1593x = C1593x.f22331a;
            if (c1593x.a(Long.valueOf(this.f22308a), Long.valueOf(c1585o.f22308a)) && c1593x.a(Long.valueOf(this.f22309b), Long.valueOf(c1585o.f22309b)) && c1593x.a(this.f22310c, c1585o.f22310c) && c1593x.a(Boolean.valueOf(this.f22311d), Boolean.valueOf(c1585o.f22311d)) && c1593x.a(this.f22312e, c1585o.f22312e) && c1593x.a(this.f22313f, c1585o.f22313f) && c1593x.a(this.f22314g, c1585o.f22314g) && c1593x.a(this.f22315h, c1585o.f22315h) && c1593x.a(this.f22316i, c1585o.f22316i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1585o.class.hashCode() * 31;
        C1593x c1593x = C1593x.f22331a;
        return ((((((((((((((((iHashCode + c1593x.b(Long.valueOf(this.f22308a))) * 31) + c1593x.b(Long.valueOf(this.f22309b))) * 31) + c1593x.b(this.f22310c)) * 31) + c1593x.b(Boolean.valueOf(this.f22311d))) * 31) + c1593x.b(this.f22312e)) * 31) + c1593x.b(this.f22313f)) * 31) + c1593x.b(this.f22314g)) * 31) + c1593x.b(this.f22315h)) * 31) + c1593x.b(this.f22316i);
    }

    public String toString() {
        return "ExoPlayerVideoTrackData(groupIndex=" + this.f22308a + ", trackIndex=" + this.f22309b + ", label=" + this.f22310c + ", isSelected=" + this.f22311d + ", bitrate=" + this.f22312e + ", width=" + this.f22313f + ", height=" + this.f22314g + ", frameRate=" + this.f22315h + ", codec=" + this.f22316i + ")";
    }
}
