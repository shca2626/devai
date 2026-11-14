package z4;

import android.content.Context;
import android.content.SharedPreferences;
import h5.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z5.AbstractC1863D;
import z5.C1885p;

/* renamed from: z4.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1852i {

    /* renamed from: a, reason: collision with root package name */
    public static final C1852i f24156a = new C1852i();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f24157b;

    /* renamed from: c, reason: collision with root package name */
    public static j.d f24158c;

    /* renamed from: z4.i$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f24159a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24160b;

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f24161c;

        public a(String str, int i7, HashMap map) {
            M5.m.e(str, "type");
            this.f24159a = str;
            this.f24160b = i7;
            this.f24161c = map;
        }

        public final HashMap a() {
            return this.f24161c;
        }

        public final int b() {
            return this.f24160b;
        }

        public final String c() {
            return this.f24159a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return M5.m.a(this.f24159a, aVar.f24159a) && this.f24160b == aVar.f24160b && M5.m.a(this.f24161c, aVar.f24161c);
        }

        public int hashCode() {
            int iHashCode = ((this.f24159a.hashCode() * 31) + Integer.hashCode(this.f24160b)) * 31;
            HashMap map = this.f24161c;
            return iHashCode + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            return "PendingRequest(type=" + this.f24159a + ", compressionQuality=" + this.f24160b + ", androidSafOptions=" + this.f24161c + ")";
        }
    }

    public final synchronized a a(Context context) {
        M5.m.e(context, "context");
        a aVarM = m(context);
        if (aVarM == null) {
            return null;
        }
        f24157b = true;
        return aVarM;
    }

    public final void b(Context context) {
        M5.m.e(context, "context");
        n(context).edit().remove("pending_request").apply();
    }

    public final a c(String str) throws JSONException {
        M5.m.e(str, "raw");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            M5.m.d(string, "getString(...)");
            int iOptInt = jSONObject.optInt("compressionQuality", 0);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("androidSafOptions");
            return new a(string, iOptInt, jSONObjectOptJSONObject != null ? f24156a.u(jSONObjectOptJSONObject) : null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final HashMap d(String str) {
        M5.m.e(str, "raw");
        try {
            return u(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public final String e(String str, String str2) {
        M5.m.e(str, "code");
        String string = new JSONObject().put("errorCode", str).put("errorMessage", str2).toString();
        M5.m.d(string, "toString(...)");
        return string;
    }

    public final String f(List list) {
        M5.m.e(list, "files");
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(new JSONObject((Map) it.next()));
        }
        String string = new JSONObject().put("files", jSONArray).toString();
        M5.m.d(string, "toString(...)");
        return string;
    }

    public final String g(a aVar) throws JSONException {
        M5.m.e(aVar, "request");
        JSONObject jSONObjectPut = new JSONObject().put("type", aVar.c()).put("compressionQuality", aVar.b());
        HashMap mapA = aVar.a();
        String string = jSONObjectPut.put("androidSafOptions", mapA != null ? new JSONObject(mapA) : null).toString();
        M5.m.d(string, "toString(...)");
        return string;
    }

    public final void h(Context context) {
        f24157b = false;
        j.d dVar = f24158c;
        if (dVar != null) {
            f24158c = null;
            dVar.success(f24156a.t(context));
        }
    }

    public final synchronized void i(Context context, List list) {
        try {
            M5.m.e(context, "context");
            if (list != null) {
                q(context, list);
            } else {
                b(context);
            }
            h(context);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void j(Context context, String str, String str2) {
        M5.m.e(context, "context");
        M5.m.e(str, "code");
        p(context, str, str2);
        h(context);
    }

    public final Object k(Object obj) {
        if (M5.m.a(obj, JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return u((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        S5.c cVarO = S5.e.o(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(C1885p.o(cVarO, 10));
        Iterator it = cVarO.iterator();
        while (it.hasNext()) {
            arrayList.add(f24156a.k(jSONArray.get(((AbstractC1863D) it).nextInt())));
        }
        return arrayList;
    }

    public final synchronized boolean l() {
        return f24157b;
    }

    public final a m(Context context) {
        String string = n(context).getString("pending_request", null);
        if (string == null) {
            return null;
        }
        return c(string);
    }

    public final SharedPreferences n(Context context) {
        return context.getSharedPreferences("flutter_file_picker_lost_data", 0);
    }

    public final synchronized void o(Context context, j.d dVar) {
        try {
            M5.m.e(context, "context");
            M5.m.e(dVar, "result");
            if (f24157b) {
                f24158c = dVar;
            } else {
                dVar.success(t(context));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void p(Context context, String str, String str2) {
        s(context, e(str, str2));
    }

    public final void q(Context context, List list) {
        ArrayList arrayList = new ArrayList(C1885p.o(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((C1844a) it.next()).a());
        }
        s(context, f(arrayList));
    }

    public final void r(Context context, a aVar) {
        M5.m.e(context, "context");
        M5.m.e(aVar, "request");
        n(context).edit().putString("pending_request", g(aVar)).apply();
    }

    public final void s(Context context, String str) {
        n(context).edit().putString("lost_result", str).remove("pending_request").apply();
    }

    public final HashMap t(Context context) {
        SharedPreferences sharedPreferencesN = n(context);
        String string = sharedPreferencesN.getString("lost_result", null);
        if (string == null) {
            return null;
        }
        sharedPreferencesN.edit().remove("lost_result").apply();
        return d(string);
    }

    public final HashMap u(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        M5.m.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, f24156a.k(jSONObject.get(next)));
        }
        return map;
    }
}
