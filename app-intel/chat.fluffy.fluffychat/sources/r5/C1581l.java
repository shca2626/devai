package r5;

import java.util.List;
import z5.C1884o;

/* renamed from: r5.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1581l {

    /* renamed from: j, reason: collision with root package name */
    public static final a f22278j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22279a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22280b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22281c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22282d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22283e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f22284f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f22285g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f22286h;

    /* renamed from: i, reason: collision with root package name */
    public final String f22287i;

    /* renamed from: r5.l$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1581l a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue2 = ((Long) obj2).longValue();
            String str = (String) list.get(2);
            String str2 = (String) list.get(3);
            Object obj3 = list.get(4);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new C1581l(jLongValue, jLongValue2, str, str2, ((Boolean) obj3).booleanValue(), (Long) list.get(5), (Long) list.get(6), (Long) list.get(7), (String) list.get(8));
        }

        public a() {
        }
    }

    public C1581l(long j7, long j8, String str, String str2, boolean z7, Long l7, Long l8, Long l9, String str3) {
        this.f22279a = j7;
        this.f22280b = j8;
        this.f22281c = str;
        this.f22282d = str2;
        this.f22283e = z7;
        this.f22284f = l7;
        this.f22285g = l8;
        this.f22286h = l9;
        this.f22287i = str3;
    }

    public final List a() {
        return C1884o.l(Long.valueOf(this.f22279a), Long.valueOf(this.f22280b), this.f22281c, this.f22282d, Boolean.valueOf(this.f22283e), this.f22284f, this.f22285g, this.f22286h, this.f22287i);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1581l.class)) {
            if (this == obj) {
                return true;
            }
            C1581l c1581l = (C1581l) obj;
            C1592x c1592x = C1592x.f22337a;
            if (c1592x.a(Long.valueOf(this.f22279a), Long.valueOf(c1581l.f22279a)) && c1592x.a(Long.valueOf(this.f22280b), Long.valueOf(c1581l.f22280b)) && c1592x.a(this.f22281c, c1581l.f22281c) && c1592x.a(this.f22282d, c1581l.f22282d) && c1592x.a(Boolean.valueOf(this.f22283e), Boolean.valueOf(c1581l.f22283e)) && c1592x.a(this.f22284f, c1581l.f22284f) && c1592x.a(this.f22285g, c1581l.f22285g) && c1592x.a(this.f22286h, c1581l.f22286h) && c1592x.a(this.f22287i, c1581l.f22287i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1581l.class.hashCode() * 31;
        C1592x c1592x = C1592x.f22337a;
        return ((((((((((((((((iHashCode + c1592x.b(Long.valueOf(this.f22279a))) * 31) + c1592x.b(Long.valueOf(this.f22280b))) * 31) + c1592x.b(this.f22281c)) * 31) + c1592x.b(this.f22282d)) * 31) + c1592x.b(Boolean.valueOf(this.f22283e))) * 31) + c1592x.b(this.f22284f)) * 31) + c1592x.b(this.f22285g)) * 31) + c1592x.b(this.f22286h)) * 31) + c1592x.b(this.f22287i);
    }

    public String toString() {
        return "ExoPlayerAudioTrackData(groupIndex=" + this.f22279a + ", trackIndex=" + this.f22280b + ", label=" + this.f22281c + ", language=" + this.f22282d + ", isSelected=" + this.f22283e + ", bitrate=" + this.f22284f + ", sampleRate=" + this.f22285g + ", channelCount=" + this.f22286h + ", codec=" + this.f22287i + ")";
    }
}
