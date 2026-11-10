package N0;

import E0.AbstractC0332s;
import E0.U;
import android.os.Build;
import com.fasterxml.jackson.core.JsonPointer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: N0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0530a {
    public static byte[] a(byte[] bArr) {
        return Build.VERSION.SDK_INT >= 27 ? bArr : U.v0(c(U.H(bArr)));
    }

    public static byte[] b(byte[] bArr) throws JSONException {
        if (Build.VERSION.SDK_INT >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(U.H(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                if (i7 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return U.v0(sb.toString());
        } catch (JSONException e7) {
            AbstractC0332s.d("ClearKeyUtil", "Failed to adjust response data: " + U.H(bArr), e7);
            return bArr;
        }
    }

    public static String c(String str) {
        return str.replace('+', '-').replace(JsonPointer.SEPARATOR, '_');
    }

    public static String d(String str) {
        return str.replace('-', '+').replace('_', JsonPointer.SEPARATOR);
    }
}
