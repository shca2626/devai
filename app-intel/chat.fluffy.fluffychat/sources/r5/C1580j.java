package r5;

import java.util.List;
import z5.C1881o;

/* renamed from: r5.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1580j {

    /* renamed from: i, reason: collision with root package name */
    public static final a f22254i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f22255a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22256b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22257c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22258d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f22259e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f22260f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f22261g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22262h;

    /* renamed from: r5.j$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1580j a(List list) {
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
            return new C1580j(str, str2, str3, ((Boolean) obj4).booleanValue(), (Long) list.get(4), (Long) list.get(5), (Long) list.get(6), (String) list.get(7));
        }

        public a() {
        }
    }

    public C1580j(String str, String str2, String str3, boolean z7, Long l7, Long l8, Long l9, String str4) {
        M5.m.e(str, "id");
        M5.m.e(str2, "label");
        M5.m.e(str3, "language");
        this.f22255a = str;
        this.f22256b = str2;
        this.f22257c = str3;
        this.f22258d = z7;
        this.f22259e = l7;
        this.f22260f = l8;
        this.f22261g = l9;
        this.f22262h = str4;
    }

    public final List a() {
        return C1881o.l(this.f22255a, this.f22256b, this.f22257c, Boolean.valueOf(this.f22258d), this.f22259e, this.f22260f, this.f22261g, this.f22262h);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1580j.class)) {
            if (this == obj) {
                return true;
            }
            C1580j c1580j = (C1580j) obj;
            C1593x c1593x = C1593x.f22331a;
            if (c1593x.a(this.f22255a, c1580j.f22255a) && c1593x.a(this.f22256b, c1580j.f22256b) && c1593x.a(this.f22257c, c1580j.f22257c) && c1593x.a(Boolean.valueOf(this.f22258d), Boolean.valueOf(c1580j.f22258d)) && c1593x.a(this.f22259e, c1580j.f22259e) && c1593x.a(this.f22260f, c1580j.f22260f) && c1593x.a(this.f22261g, c1580j.f22261g) && c1593x.a(this.f22262h, c1580j.f22262h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1580j.class.hashCode() * 31;
        C1593x c1593x = C1593x.f22331a;
        return ((((((((((((((iHashCode + c1593x.b(this.f22255a)) * 31) + c1593x.b(this.f22256b)) * 31) + c1593x.b(this.f22257c)) * 31) + c1593x.b(Boolean.valueOf(this.f22258d))) * 31) + c1593x.b(this.f22259e)) * 31) + c1593x.b(this.f22260f)) * 31) + c1593x.b(this.f22261g)) * 31) + c1593x.b(this.f22262h);
    }

    public String toString() {
        return "AudioTrackMessage(id=" + this.f22255a + ", label=" + this.f22256b + ", language=" + this.f22257c + ", isSelected=" + this.f22258d + ", bitrate=" + this.f22259e + ", sampleRate=" + this.f22260f + ", channelCount=" + this.f22261g + ", codec=" + this.f22262h + ")";
    }
}
