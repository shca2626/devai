package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.incognia.core.JJ;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f24440a;

    public p0(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.f24440a = new Bundle(bundle);
    }

    private static int d(String str) {
        int color = Color.parseColor(str);
        if (color != -16777216) {
            return color;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        return str.startsWith("google.c.a.") || str.equals("from");
    }

    public static boolean t(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(v("gcm.n.e")));
    }

    private static boolean u(String str) {
        return str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.");
    }

    private static String v(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.f24440a.containsKey(str) && str.startsWith("gcm.n.")) {
            String strV = v(str);
            if (this.f24440a.containsKey(strV)) {
                return strV;
            }
        }
        return str;
    }

    private static String z(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean a(String str) {
        String strP = p(str);
        return "1".equals(strP) || Boolean.parseBoolean(strP);
    }

    public Integer b(String str) {
        String strP = p(str);
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strP));
        } catch (NumberFormatException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't parse value of ");
            sb2.append(z(str));
            sb2.append("(");
            sb2.append(strP);
            sb2.append(") into an int");
            return null;
        }
    }

    public JSONArray c(String str) {
        String strP = p(str);
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        try {
            return new JSONArray(strP);
        } catch (JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Malformed JSON for key ");
            sb2.append(z(str));
            sb2.append(": ");
            sb2.append(strP);
            sb2.append(", falling back to default");
            return null;
        }
    }

    int[] e() throws JSONException {
        JSONArray jSONArrayC = c("gcm.n.light_settings");
        if (jSONArrayC == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArrayC.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = d(jSONArrayC.optString(0));
            iArr[1] = jSONArrayC.optInt(1);
            iArr[2] = jSONArrayC.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e12) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("LightSettings is invalid: ");
            sb2.append(jSONArrayC);
            sb2.append(". ");
            sb2.append(e12.getMessage());
            sb2.append(". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("LightSettings is invalid: ");
            sb3.append(jSONArrayC);
            sb3.append(". Skipping setting LightSettings");
            return null;
        }
    }

    public Uri f() {
        String strP = p("gcm.n.link_android");
        if (TextUtils.isEmpty(strP)) {
            strP = p("gcm.n.link");
        }
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        return Uri.parse(strP);
    }

    public Object[] g(String str) {
        JSONArray jSONArrayC = c(str + "_loc_args");
        if (jSONArrayC == null) {
            return null;
        }
        int length = jSONArrayC.length();
        String[] strArr = new String[length];
        for (int i12 = 0; i12 < length; i12++) {
            strArr[i12] = jSONArrayC.optString(i12);
        }
        return strArr;
    }

    public String h(String str) {
        return p(str + "_loc_key");
    }

    public String i(Resources resources, String str, String str2) {
        String strH = h(str2);
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        int identifier = resources.getIdentifier(strH, JJ.E, str);
        if (identifier == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z(str2 + "_loc_key"));
            sb2.append(" resource not found: ");
            sb2.append(str2);
            sb2.append(" Default value will be used.");
            return null;
        }
        Object[] objArrG = g(str2);
        if (objArrG == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, objArrG);
        } catch (MissingFormatArgumentException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing format argument for ");
            sb3.append(z(str2));
            sb3.append(": ");
            sb3.append(Arrays.toString(objArrG));
            sb3.append(" Default value will be used.");
            return null;
        }
    }

    public Long j(String str) {
        String strP = p(str);
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(strP));
        } catch (NumberFormatException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't parse value of ");
            sb2.append(z(str));
            sb2.append("(");
            sb2.append(strP);
            sb2.append(") into a long");
            return null;
        }
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    Integer l() {
        Integer numB = b("gcm.n.notification_count");
        if (numB == null) {
            return null;
        }
        if (numB.intValue() >= 0) {
            return numB;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notificationCount is invalid: ");
        sb2.append(numB);
        sb2.append(". Skipping setting notificationCount.");
        return null;
    }

    Integer m() {
        Integer numB = b("gcm.n.notification_priority");
        if (numB == null) {
            return null;
        }
        if (numB.intValue() >= -2 && numB.intValue() <= 2) {
            return numB;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notificationPriority is invalid ");
        sb2.append(numB);
        sb2.append(". Skipping setting notificationPriority.");
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String strP = p(str2);
        return !TextUtils.isEmpty(strP) ? strP : i(resources, str, str2);
    }

    public String o() {
        String strP = p("gcm.n.sound2");
        return TextUtils.isEmpty(strP) ? p("gcm.n.sound") : strP;
    }

    public String p(String str) {
        return this.f24440a.getString(w(str));
    }

    public long[] q() throws JSONException {
        JSONArray jSONArrayC = c("gcm.n.vibrate_timings");
        if (jSONArrayC == null) {
            return null;
        }
        try {
            if (jSONArrayC.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArrayC.length();
            long[] jArr = new long[length];
            for (int i12 = 0; i12 < length; i12++) {
                jArr[i12] = jSONArrayC.optLong(i12);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("User defined vibrateTimings is invalid: ");
            sb2.append(jSONArrayC);
            sb2.append(". Skipping setting vibrateTimings.");
            return null;
        }
    }

    Integer r() {
        Integer numB = b("gcm.n.visibility");
        if (numB == null) {
            return null;
        }
        if (numB.intValue() >= -1 && numB.intValue() <= 1) {
            return numB;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("visibility is invalid: ");
        sb2.append(numB);
        sb2.append(". Skipping setting visibility.");
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.f24440a);
        for (String str : this.f24440a.keySet()) {
            if (!s(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.f24440a);
        for (String str : this.f24440a.keySet()) {
            if (u(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
