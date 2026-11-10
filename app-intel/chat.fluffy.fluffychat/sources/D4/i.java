package D4;

import M5.m;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final a f1804c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f1805a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1806b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final i a(String str) throws JSONException {
            String string;
            m.e(str, "jsonString");
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("metaDataName")) {
                string = "";
            } else {
                string = jSONObject.getString("metaDataName");
                m.b(string);
            }
            return new i(string, jSONObject.isNull("backgroundColorRgb") ? null : jSONObject.getString("backgroundColorRgb"));
        }

        public a() {
        }
    }

    public i(String str, String str2) {
        m.e(str, "metaDataName");
        this.f1805a = str;
        this.f1806b = str2;
    }

    public final String a() {
        return this.f1806b;
    }

    public final String b() {
        return this.f1805a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return m.a(this.f1805a, iVar.f1805a) && m.a(this.f1806b, iVar.f1806b);
    }

    public int hashCode() {
        int iHashCode = this.f1805a.hashCode() * 31;
        String str = this.f1806b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NotificationIcon(metaDataName=" + this.f1805a + ", backgroundColorRgb=" + this.f1806b + ")";
    }
}
