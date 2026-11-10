package be1;

import android.annotation.SuppressLint;
import com.braze.models.inappmessage.InAppMessageBase;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.incognia.core.MIj;
import com.instabug.library.model.StepType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class u implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    private long f13631b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13632c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13633d;

    /* renamed from: e, reason: collision with root package name */
    private String f13634e;

    /* renamed from: f, reason: collision with root package name */
    private String f13635f;

    /* renamed from: g, reason: collision with root package name */
    private String f13636g;

    /* renamed from: h, reason: collision with root package name */
    private String f13637h;

    /* renamed from: i, reason: collision with root package name */
    private String f13638i;

    /* renamed from: j, reason: collision with root package name */
    private String f13639j;

    /* renamed from: k, reason: collision with root package name */
    private String f13640k;

    /* renamed from: l, reason: collision with root package name */
    private String f13641l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13642m;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private long f13643a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13644b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f13645c;

        /* renamed from: d, reason: collision with root package name */
        private String f13646d;

        /* renamed from: e, reason: collision with root package name */
        private String f13647e;

        /* renamed from: f, reason: collision with root package name */
        private String f13648f;

        /* renamed from: g, reason: collision with root package name */
        private String f13649g;

        /* renamed from: h, reason: collision with root package name */
        private String f13650h;

        /* renamed from: i, reason: collision with root package name */
        private String f13651i;

        /* renamed from: j, reason: collision with root package name */
        private String f13652j;

        /* renamed from: k, reason: collision with root package name */
        private String f13653k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f13654l;

        public b a(long j12) {
            this.f13643a = j12;
            return this;
        }

        public b b(String str) {
            this.f13652j = str;
            return this;
        }

        public b c(boolean z12) {
            this.f13644b = z12;
            return this;
        }

        public u d() {
            return new u(this);
        }

        public b f(String str) {
            this.f13646d = str;
            return this;
        }

        public b g(boolean z12) {
            this.f13645c = z12;
            return this;
        }

        public b i(String str) {
            this.f13649g = str;
            return this;
        }

        public b j(boolean z12) {
            this.f13654l = z12;
            return this;
        }

        public b l(String str) {
            this.f13647e = str;
            return this;
        }

        public b n(String str) {
            this.f13648f = str;
            return this;
        }

        public b p(String str) {
            this.f13650h = str;
            return this;
        }

        public b r(String str) {
            this.f13651i = str;
            return this;
        }

        private b(String str) {
            this.f13643a = System.currentTimeMillis();
            this.f13653k = str;
        }
    }

    public static String C(ArrayList<u> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<u> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().B());
            }
        }
        return jSONArray.toString();
    }

    public static b a(String str) {
        return new b(str);
    }

    public static ArrayList<u> b(JSONArray jSONArray) throws JSONException {
        ArrayList<u> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                arrayList.add(c(jSONArray.getJSONObject(i12)));
            }
        }
        return arrayList;
    }

    public static u c(JSONObject jSONObject) throws JSONException {
        String upperCase = (!jSONObject.has(MIj.K7w) || JSONObject.NULL.toString().equals(jSONObject.getString(MIj.K7w))) ? StepType.UNKNOWN : jSONObject.getString(MIj.K7w).toUpperCase();
        String str = null;
        String string = jSONObject.has("screen_name") ? jSONObject.getString("screen_name") : null;
        String string2 = jSONObject.has("screen_identifier") ? jSONObject.getString("screen_identifier") : null;
        String string3 = jSONObject.has("screenshot_identifier") ? jSONObject.getString("screenshot_identifier") : null;
        String string4 = jSONObject.has("date") ? jSONObject.getString("date") : null;
        String string5 = jSONObject.has("parent_screen_identifier") ? jSONObject.getString("parent_screen_identifier") : null;
        boolean z12 = jSONObject.has("is_contains") ? jSONObject.getBoolean("is_contains") : false;
        String string6 = jSONObject.has("button_icon") ? jSONObject.getString("button_icon") : null;
        String string7 = jSONObject.has(Promotion.ACTION_VIEW) ? jSONObject.getString(Promotion.ACTION_VIEW) : null;
        if (jSONObject.has(InAppMessageBase.ORIENTATION)) {
            String string8 = jSONObject.getString(InAppMessageBase.ORIENTATION);
            int iHashCode = string8.hashCode();
            if (iHashCode == 729267099) {
                string8.equals("portrait");
            } else if (iHashCode == 1430647483 && string8.equals("landscape")) {
                str = "landscape";
            }
            str = "portrait";
        }
        boolean zOptBoolean = jSONObject.has("is_flag_secure") ? jSONObject.optBoolean("is_flag_secure", false) : false;
        boolean zOptBoolean2 = jSONObject.has("manually_captured") ? jSONObject.optBoolean("manually_captured", false) : false;
        if (string7 == null) {
            string7 = "";
        }
        b bVarN = a(upperCase).l(string).n(string3);
        if (string4 == null) {
            string4 = ExpiryDateConstantsKt.EXPIRY_DATE_PREFIX_ZERO;
        }
        return bVarN.a(Long.parseLong(string4)).f(string5).p(string7).r(str).i(string2).c(z12).b(string6).j(zOptBoolean).g(zOptBoolean2).d();
    }

    private String d() {
        return this.f13641l;
    }

    private boolean m() {
        return this.f13632c;
    }

    private void v(String str) {
        this.f13635f = str;
    }

    private void y(String str) {
        this.f13638i = str;
    }

    public void A(String str) {
        this.f13640k = str;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public JSONObject B() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("parent_screen_identifier", (f() == null || f().equals("null")) ? JSONObject.NULL : f());
            jSONObject.put("screen_name", (h() == null || h().equals("null")) ? JSONObject.NULL : h());
            jSONObject.put("screenshot_identifier", (i() == null || i().equals("null")) ? JSONObject.NULL : i());
            jSONObject.put("screen_identifier", (g() == null || g().equals("null")) ? JSONObject.NULL : g());
            jSONObject.put(MIj.K7w, (j() == null || j().equals(StepType.UNKNOWN)) ? JSONObject.NULL : j().toLowerCase());
            jSONObject.put("date", e());
            jSONObject.put(Promotion.ACTION_VIEW, (k() == null || k().equals("null")) ? JSONObject.NULL : k());
            jSONObject.put(InAppMessageBase.ORIENTATION, (l() == null || l().equals("null")) ? JSONObject.NULL : l());
            jSONObject.put("is_contains", m());
            jSONObject.put("button_icon", d());
            jSONObject.put("is_flag_secure", o());
            if (this.f13633d) {
                jSONObject.put("manually_captured", n());
            }
        } catch (JSONException e12) {
            e12.printStackTrace();
        }
        return jSONObject;
    }

    public long e() {
        return this.f13631b;
    }

    public String f() {
        return this.f13634e;
    }

    public String g() {
        return this.f13637h;
    }

    public String h() {
        return this.f13635f;
    }

    public String i() {
        return this.f13636g;
    }

    public String j() {
        return this.f13638i;
    }

    public String k() {
        return this.f13639j;
    }

    public String l() {
        return this.f13640k;
    }

    public boolean n() {
        return this.f13633d;
    }

    public boolean o() {
        return this.f13642m;
    }

    void p(String str) {
        this.f13641l = str;
    }

    void q(boolean z12) {
        this.f13632c = z12;
    }

    public void r(long j12) {
        this.f13631b = j12;
    }

    public void s(boolean z12) {
        this.f13633d = z12;
    }

    public void t(String str) {
        this.f13634e = str;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toString() {
        return "VisualUserStep{parentScreenId='" + this.f13634e + "', screenName='" + this.f13635f + "', screenshotId='" + this.f13636g + "', screenId='" + this.f13637h + "', eventType='" + this.f13638i + "', date=" + this.f13631b + ", view='" + this.f13639j + "'}";
    }

    public void u(String str) {
        this.f13637h = str;
    }

    public void w(boolean z12) {
        this.f13642m = z12;
    }

    public void x(String str) {
        this.f13636g = str;
    }

    public void z(String str) {
        this.f13639j = str;
    }

    private u(b bVar) {
        this.f13638i = StepType.UNKNOWN;
        t(bVar.f13646d);
        v(bVar.f13647e);
        x(bVar.f13648f);
        u(bVar.f13649g);
        y(bVar.f13653k);
        r(bVar.f13643a);
        z(bVar.f13650h);
        A(bVar.f13651i);
        p(bVar.f13652j);
        q(bVar.f13644b);
        w(bVar.f13654l);
        s(bVar.f13645c);
    }
}
