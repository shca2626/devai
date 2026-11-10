package W;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f8903a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8904b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8905c;

    /* renamed from: d, reason: collision with root package name */
    public final List f8906d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8907e;

    /* renamed from: f, reason: collision with root package name */
    public final String f8908f;

    /* renamed from: g, reason: collision with root package name */
    public final String f8909g;

    /* renamed from: h, reason: collision with root package name */
    public final String f8910h;

    public e(String str, String str2, String str3, List list) {
        this(str, str2, str3, list, null, null);
    }

    public final String a(String str, String str2, String str3, String str4, String str5) {
        return str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public List b() {
        return this.f8906d;
    }

    public int c() {
        return this.f8907e;
    }

    public String d() {
        return this.f8910h;
    }

    public String e() {
        return this.f8903a;
    }

    public String f() {
        return this.f8904b;
    }

    public String g() {
        return this.f8905c;
    }

    public String h() {
        return this.f8908f;
    }

    public String i() {
        return this.f8909g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f8903a + ", mProviderPackage: " + this.f8904b + ", mQuery: " + this.f8905c + ", mSystemFont: " + this.f8908f + ", mVariationSettings: " + this.f8909g + ", mCertificates:");
        for (int i7 = 0; i7 < this.f8906d.size(); i7++) {
            sb.append(" [");
            List list = (List) this.f8906d.get(i7);
            for (int i8 = 0; i8 < list.size(); i8++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i8), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f8907e);
        return sb.toString();
    }

    public e(String str, String str2, String str3, List list, String str4, String str5) {
        this.f8903a = (String) Y.h.j(str);
        this.f8904b = (String) Y.h.j(str2);
        this.f8905c = (String) Y.h.j(str3);
        this.f8906d = (List) Y.h.j(list);
        this.f8907e = 0;
        this.f8908f = str4;
        this.f8909g = str5;
        this.f8910h = a(str, str2, str3, str4, str5);
    }
}
