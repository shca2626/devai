package D4;

import D4.g;
import M5.m;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1798f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f1799a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1800b;

    /* renamed from: c, reason: collision with root package name */
    public final i f1801c;

    /* renamed from: d, reason: collision with root package name */
    public final List f1802d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1803e;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        }

        public final h b(Context context) throws JSONException {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0);
            String string = sharedPreferences.getString("notificationContentTitle", null);
            String str = string == null ? "" : string;
            String string2 = sharedPreferences.getString("notificationContentText", null);
            String str2 = string2 == null ? "" : string2;
            String string3 = sharedPreferences.getString("icon", null);
            i iVarA = string3 != null ? i.f1804c.a(string3) : null;
            String string4 = sharedPreferences.getString("buttons", null);
            ArrayList arrayList = new ArrayList();
            if (string4 != null) {
                JSONArray jSONArray = new JSONArray(string4);
                int length = jSONArray.length();
                for (int i7 = 0; i7 < length; i7++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i7);
                    g.a aVar = g.f1794d;
                    m.b(jSONObject);
                    arrayList.add(aVar.a(jSONObject));
                }
            }
            return new h(str, str2, iVarA, arrayList, sharedPreferences.getString("initialRoute", null));
        }

        public final void c(Context context, Map map) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0);
            Object obj = map != null ? map.get("notificationContentTitle") : null;
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                str = "";
            }
            Object obj2 = map != null ? map.get("notificationContentText") : null;
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            String str3 = str2 != null ? str2 : "";
            Object obj3 = map != null ? map.get("icon") : null;
            Map map2 = obj3 instanceof Map ? (Map) obj3 : null;
            String string = map2 != null ? new JSONObject(map2).toString() : null;
            Object obj4 = map != null ? map.get("buttons") : null;
            List list = obj4 instanceof List ? (List) obj4 : null;
            String string2 = list != null ? new JSONArray((Collection) list).toString() : null;
            Object obj5 = map != null ? map.get("initialRoute") : null;
            String str4 = obj5 instanceof String ? (String) obj5 : null;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("notificationContentTitle", str);
            editorEdit.putString("notificationContentText", str3);
            editorEdit.putString("icon", string);
            editorEdit.putString("buttons", string2);
            editorEdit.putString("initialRoute", str4);
            editorEdit.commit();
        }

        public final void d(Context context, Map map) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0);
            Object obj = map != null ? map.get("notificationContentTitle") : null;
            String str = obj instanceof String ? (String) obj : null;
            Object obj2 = map != null ? map.get("notificationContentText") : null;
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = map != null ? map.get("icon") : null;
            Map map2 = obj3 instanceof Map ? (Map) obj3 : null;
            String string = map2 != null ? new JSONObject(map2).toString() : null;
            Object obj4 = map != null ? map.get("buttons") : null;
            List list = obj4 instanceof List ? (List) obj4 : null;
            String string2 = list != null ? new JSONArray((Collection) list).toString() : null;
            Object obj5 = map != null ? map.get("initialRoute") : null;
            String str3 = obj5 instanceof String ? (String) obj5 : null;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (str != null) {
                editorEdit.putString("notificationContentTitle", str);
            }
            if (str2 != null) {
                editorEdit.putString("notificationContentText", str2);
            }
            if (string != null) {
                editorEdit.putString("icon", string);
            }
            if (string2 != null) {
                editorEdit.putString("buttons", string2);
            }
            if (str3 != null) {
                editorEdit.putString("initialRoute", str3);
            }
            editorEdit.commit();
        }

        public a() {
        }
    }

    public h(String str, String str2, i iVar, List list, String str3) {
        m.e(str, "title");
        m.e(str2, "text");
        m.e(list, "buttons");
        this.f1799a = str;
        this.f1800b = str2;
        this.f1801c = iVar;
        this.f1802d = list;
        this.f1803e = str3;
    }

    public final List a() {
        return this.f1802d;
    }

    public final i b() {
        return this.f1801c;
    }

    public final String c() {
        return this.f1803e;
    }

    public final String d() {
        return this.f1800b;
    }

    public final String e() {
        return this.f1799a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return m.a(this.f1799a, hVar.f1799a) && m.a(this.f1800b, hVar.f1800b) && m.a(this.f1801c, hVar.f1801c) && m.a(this.f1802d, hVar.f1802d) && m.a(this.f1803e, hVar.f1803e);
    }

    public int hashCode() {
        int iHashCode = ((this.f1799a.hashCode() * 31) + this.f1800b.hashCode()) * 31;
        i iVar = this.f1801c;
        int iHashCode2 = (((iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31) + this.f1802d.hashCode()) * 31;
        String str = this.f1803e;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "NotificationContent(title=" + this.f1799a + ", text=" + this.f1800b + ", icon=" + this.f1801c + ", buttons=" + this.f1802d + ", initialRoute=" + this.f1803e + ")";
    }
}
