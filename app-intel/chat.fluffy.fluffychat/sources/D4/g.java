package D4;

import M5.m;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1794d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f1795a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1796b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1797c;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final g a(JSONObject jSONObject) throws JSONException {
            String string;
            String string2;
            m.e(jSONObject, "jsonObj");
            if (jSONObject.isNull("id")) {
                string = "unknown";
            } else {
                string = jSONObject.getString("id");
                m.b(string);
            }
            if (jSONObject.isNull("text")) {
                string2 = "";
            } else {
                string2 = jSONObject.getString("text");
                m.b(string2);
            }
            return new g(string, string2, jSONObject.isNull("textColorRgb") ? null : jSONObject.getString("textColorRgb"));
        }

        public a() {
        }
    }

    public g(String str, String str2, String str3) {
        m.e(str, "id");
        m.e(str2, "text");
        this.f1795a = str;
        this.f1796b = str2;
        this.f1797c = str3;
    }

    public final String a() {
        return this.f1795a;
    }

    public final String b() {
        return this.f1796b;
    }

    public final String c() {
        return this.f1797c;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof g)) {
            g gVar = (g) obj;
            if (m.a(this.f1795a, gVar.f1795a) && m.a(this.f1796b, gVar.f1796b) && m.a(this.f1797c, gVar.f1797c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f1795a, this.f1796b, this.f1797c);
    }

    public String toString() {
        return "NotificationButton(id=" + this.f1795a + ", text=" + this.f1796b + ", textColorRgb=" + this.f1797c + ")";
    }
}
