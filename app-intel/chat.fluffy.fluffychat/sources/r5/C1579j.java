package r5;

import java.util.List;
import z5.C1884o;

/* renamed from: r5.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1579j {

    /* renamed from: i, reason: collision with root package name */
    public static final a f22260i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f22261a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22262b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22263c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22264d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f22265e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f22266f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f22267g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22268h;

    /* renamed from: r5.j$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1579j a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj2;
            Object obj3 = list.get(2);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj3;
            Object obj4 = list.get(3);
            M5.m.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
            return new C1579j(str, str2, str3, ((Boolean) obj4).booleanValue(), (Long) list.get(4), (Long) list.get(5), (Long) list.get(6), (String) list.get(7));
        }

        public a() {
        }
    }

    public C1579j(String str, String str2, String str3, boolean z7, Long l7, Long l8, Long l9, String str4) {
        M5.m.e(str, "id");
        M5.m.e(str2, "label");
        M5.m.e(str3, "language");
        this.f22261a = str;
        this.f22262b = str2;
        this.f22263c = str3;
        this.f22264d = z7;
        this.f22265e = l7;
        this.f22266f = l8;
        this.f22267g = l9;
        this.f22268h = str4;
    }

    public final List a() {
        return C1884o.l(this.f22261a, this.f22262b, this.f22263c, Boolean.valueOf(this.f22264d), this.f22265e, this.f22266f, this.f22267g, this.f22268h);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1579j.class)) {
            if (this == obj) {
                return true;
            }
            C1579j c1579j = (C1579j) obj;
            C1592x c1592x = C1592x.f22337a;
            if (c1592x.a(this.f22261a, c1579j.f22261a) && c1592x.a(this.f22262b, c1579j.f22262b) && c1592x.a(this.f22263c, c1579j.f22263c) && c1592x.a(Boolean.valueOf(this.f22264d), Boolean.valueOf(c1579j.f22264d)) && c1592x.a(this.f22265e, c1579j.f22265e) && c1592x.a(this.f22266f, c1579j.f22266f) && c1592x.a(this.f22267g, c1579j.f22267g) && c1592x.a(this.f22268h, c1579j.f22268h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1579j.class.hashCode() * 31;
        C1592x c1592x = C1592x.f22337a;
        return ((((((((((((((iHashCode + c1592x.b(this.f22261a)) * 31) + c1592x.b(this.f22262b)) * 31) + c1592x.b(this.f22263c)) * 31) + c1592x.b(Boolean.valueOf(this.f22264d))) * 31) + c1592x.b(this.f22265e)) * 31) + c1592x.b(this.f22266f)) * 31) + c1592x.b(this.f22267g)) * 31) + c1592x.b(this.f22268h);
    }

    public String toString() {
        return "AudioTrackMessage(id=" + this.f22261a + ", label=" + this.f22262b + ", language=" + this.f22263c + ", isSelected=" + this.f22264d + ", bitrate=" + this.f22265e + ", sampleRate=" + this.f22266f + ", channelCount=" + this.f22267g + ", codec=" + this.f22268h + ")";
    }
}
