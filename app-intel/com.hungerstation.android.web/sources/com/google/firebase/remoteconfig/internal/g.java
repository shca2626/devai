package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    private static final Date f24710h = new Date(0);

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f24711a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f24712b;

    /* renamed from: c, reason: collision with root package name */
    private Date f24713c;

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f24714d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f24715e;

    /* renamed from: f, reason: collision with root package name */
    private long f24716f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f24717g;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f24718a;

        /* renamed from: b, reason: collision with root package name */
        private Date f24719b;

        /* renamed from: c, reason: collision with root package name */
        private JSONArray f24720c;

        /* renamed from: d, reason: collision with root package name */
        private JSONObject f24721d;

        /* renamed from: e, reason: collision with root package name */
        private long f24722e;

        /* renamed from: f, reason: collision with root package name */
        private JSONArray f24723f;

        public g a() throws JSONException {
            return new g(this.f24718a, this.f24719b, this.f24720c, this.f24721d, this.f24722e, this.f24723f);
        }

        public b b(JSONObject jSONObject) {
            try {
                this.f24718a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b c(JSONArray jSONArray) {
            try {
                this.f24720c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b d(Date date) {
            this.f24719b = date;
            return this;
        }

        public b e(JSONObject jSONObject) {
            try {
                this.f24721d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b f(JSONArray jSONArray) {
            try {
                this.f24723f = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b g(long j12) {
            this.f24722e = j12;
            return this;
        }

        private b() {
            this.f24718a = new JSONObject();
            this.f24719b = g.f24710h;
            this.f24720c = new JSONArray();
            this.f24721d = new JSONObject();
            this.f24722e = 0L;
            this.f24723f = new JSONArray();
        }
    }

    static g b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rollout_metadata_key");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        return new g(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObject2, jSONObject.optLong("template_version_number_key"), jSONArrayOptJSONArray);
    }

    private Map<String, Map<String, String>> c() throws JSONException {
        HashMap map = new HashMap();
        for (int i12 = 0; i12 < j().length(); i12++) {
            JSONObject jSONObject = j().getJSONObject(i12);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i13 = 0; i13 < jSONArray.length(); i13++) {
                String string3 = jSONArray.getString(i13);
                if (!map.containsKey(string3)) {
                    map.put(string3, new HashMap());
                }
                Map map2 = (Map) map.get(string3);
                if (map2 != null) {
                    map2.put(string, string2);
                }
            }
        }
        return map;
    }

    private static g d(JSONObject jSONObject) throws JSONException {
        return b(new JSONObject(jSONObject.toString()));
    }

    public static b l() {
        return new b();
    }

    public JSONArray e() {
        return this.f24714d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return this.f24711a.toString().equals(((g) obj).toString());
        }
        return false;
    }

    public Set<String> f(g gVar) throws JSONException {
        JSONObject jSONObjectG = d(gVar.f24711a).g();
        Map<String, Map<String, String>> mapC = c();
        Map<String, Map<String, String>> mapC2 = gVar.c();
        HashSet hashSet = new HashSet();
        Iterator<String> itKeys = g().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!gVar.g().has(next)) {
                hashSet.add(next);
            } else if (!g().get(next).equals(gVar.g().get(next))) {
                hashSet.add(next);
            } else if ((i().has(next) && !gVar.i().has(next)) || (!i().has(next) && gVar.i().has(next))) {
                hashSet.add(next);
            } else if (i().has(next) && gVar.i().has(next) && !i().getJSONObject(next).toString().equals(gVar.i().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else if (mapC.containsKey(next) != mapC2.containsKey(next)) {
                hashSet.add(next);
            } else if (mapC.containsKey(next) && mapC2.containsKey(next) && !mapC.get(next).equals(mapC2.get(next))) {
                hashSet.add(next);
            } else {
                jSONObjectG.remove(next);
            }
        }
        Iterator<String> itKeys2 = jSONObjectG.keys();
        while (itKeys2.hasNext()) {
            hashSet.add(itKeys2.next());
        }
        return hashSet;
    }

    public JSONObject g() {
        return this.f24712b;
    }

    public Date h() {
        return this.f24713c;
    }

    public int hashCode() {
        return this.f24711a.hashCode();
    }

    public JSONObject i() {
        return this.f24715e;
    }

    public JSONArray j() {
        return this.f24717g;
    }

    public long k() {
        return this.f24716f;
    }

    public String toString() {
        return this.f24711a.toString();
    }

    private g(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j12, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j12);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.f24712b = jSONObject;
        this.f24713c = date;
        this.f24714d = jSONArray;
        this.f24715e = jSONObject2;
        this.f24716f = j12;
        this.f24717g = jSONArray2;
        this.f24711a = jSONObject3;
    }
}
