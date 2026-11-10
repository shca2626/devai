package O0;

import B0.y;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class v implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6665a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6666b;

    /* renamed from: c, reason: collision with root package name */
    public final List f6667c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f6668a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6669b;

        /* renamed from: c, reason: collision with root package name */
        public final String f6670c;

        /* renamed from: d, reason: collision with root package name */
        public final String f6671d;

        /* renamed from: e, reason: collision with root package name */
        public final String f6672e;

        /* renamed from: f, reason: collision with root package name */
        public final String f6673f;

        public a(int i7, int i8, String str, String str2, String str3, String str4) {
            this.f6668a = i7;
            this.f6669b = i8;
            this.f6670c = str;
            this.f6671d = str2;
            this.f6672e = str3;
            this.f6673f = str4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f6668a == aVar.f6668a && this.f6669b == aVar.f6669b && TextUtils.equals(this.f6670c, aVar.f6670c) && TextUtils.equals(this.f6671d, aVar.f6671d) && TextUtils.equals(this.f6672e, aVar.f6672e) && TextUtils.equals(this.f6673f, aVar.f6673f)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i7 = ((this.f6668a * 31) + this.f6669b) * 31;
            String str = this.f6670c;
            int iHashCode = (i7 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f6671d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f6672e;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f6673f;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    public v(String str, String str2, List list) {
        this.f6665a = str;
        this.f6666b = str2;
        this.f6667c = Collections.unmodifiableList(new ArrayList(list));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v.class == obj.getClass()) {
            v vVar = (v) obj;
            if (TextUtils.equals(this.f6665a, vVar.f6665a) && TextUtils.equals(this.f6666b, vVar.f6666b) && this.f6667c.equals(vVar.f6667c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f6665a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f6666b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f6667c.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        if (this.f6665a != null) {
            str = " [" + this.f6665a + ", " + this.f6666b + "]";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
