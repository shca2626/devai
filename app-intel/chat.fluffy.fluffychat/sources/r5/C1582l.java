package r5;

import java.util.List;
import z5.C1881o;

/* renamed from: r5.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1582l {

    /* renamed from: j, reason: collision with root package name */
    public static final a f22272j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f22273a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22274b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22275c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22276d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22277e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f22278f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f22279g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f22280h;

    /* renamed from: i, reason: collision with root package name */
    public final String f22281i;

    /* renamed from: r5.l$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1582l a(List list) {
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
            return new C1582l(jLongValue, jLongValue2, str, str2, ((Boolean) obj3).booleanValue(), (Long) list.get(5), (Long) list.get(6), (Long) list.get(7), (String) list.get(8));
        }

        public a() {
        }
    }

    public C1582l(long j7, long j8, String str, String str2, boolean z7, Long l7, Long l8, Long l9, String str3) {
        this.f22273a = j7;
        this.f22274b = j8;
        this.f22275c = str;
        this.f22276d = str2;
        this.f22277e = z7;
        this.f22278f = l7;
        this.f22279g = l8;
        this.f22280h = l9;
        this.f22281i = str3;
    }

    public final List a() {
        return C1881o.l(Long.valueOf(this.f22273a), Long.valueOf(this.f22274b), this.f22275c, this.f22276d, Boolean.valueOf(this.f22277e), this.f22278f, this.f22279g, this.f22280h, this.f22281i);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1582l.class)) {
            if (this == obj) {
                return true;
            }
            C1582l c1582l = (C1582l) obj;
            C1593x c1593x = C1593x.f22331a;
            if (c1593x.a(Long.valueOf(this.f22273a), Long.valueOf(c1582l.f22273a)) && c1593x.a(Long.valueOf(this.f22274b), Long.valueOf(c1582l.f22274b)) && c1593x.a(this.f22275c, c1582l.f22275c) && c1593x.a(this.f22276d, c1582l.f22276d) && c1593x.a(Boolean.valueOf(this.f22277e), Boolean.valueOf(c1582l.f22277e)) && c1593x.a(this.f22278f, c1582l.f22278f) && c1593x.a(this.f22279g, c1582l.f22279g) && c1593x.a(this.f22280h, c1582l.f22280h) && c1593x.a(this.f22281i, c1582l.f22281i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1582l.class.hashCode() * 31;
        C1593x c1593x = C1593x.f22331a;
        return ((((((((((((((((iHashCode + c1593x.b(Long.valueOf(this.f22273a))) * 31) + c1593x.b(Long.valueOf(this.f22274b))) * 31) + c1593x.b(this.f22275c)) * 31) + c1593x.b(this.f22276d)) * 31) + c1593x.b(Boolean.valueOf(this.f22277e))) * 31) + c1593x.b(this.f22278f)) * 31) + c1593x.b(this.f22279g)) * 31) + c1593x.b(this.f22280h)) * 31) + c1593x.b(this.f22281i);
    }

    public String toString() {
        return "ExoPlayerAudioTrackData(groupIndex=" + this.f22273a + ", trackIndex=" + this.f22274b + ", label=" + this.f22275c + ", language=" + this.f22276d + ", isSelected=" + this.f22277e + ", bitrate=" + this.f22278f + ", sampleRate=" + this.f22279g + ", channelCount=" + this.f22280h + ", codec=" + this.f22281i + ")";
    }
}
