package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class zzj {
    public static String zza(Object obj) {
        return zzd(obj, 0);
    }

    public static String zzb(Map map) {
        return zzd(map, 1);
    }

    private static String zzd(Object obj, int i12) {
        if (i12 > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuilder sb2 = new StringBuilder();
            if (i12 > 0) {
                sb2.append("[");
            }
            int length = sb2.length();
            for (Object obj2 : (List) obj) {
                if (sb2.length() > length) {
                    sb2.append(", ");
                }
                sb2.append(zzd(obj2, i12 + 1));
            }
            if (i12 > 0) {
                sb2.append("]");
            }
            return sb2.toString();
        }
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        boolean z12 = false;
        int length2 = 0;
        for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
            String strZzd = zzd(entry.getValue(), i12 + 1);
            if (!TextUtils.isEmpty(strZzd)) {
                if (i12 > 0 && !z12) {
                    sb3.append("{");
                    length2 = sb3.length();
                    z12 = true;
                }
                if (sb3.length() > length2) {
                    sb3.append(", ");
                }
                sb3.append((String) entry.getKey());
                sb3.append('=');
                sb3.append(strZzd);
            }
        }
        if (z12) {
            sb3.append("}");
        }
        return sb3.toString();
    }

    public abstract void zzc(zzj zzjVar);
}
