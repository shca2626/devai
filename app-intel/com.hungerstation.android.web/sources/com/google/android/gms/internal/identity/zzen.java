package com.google.android.gms.internal.identity;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes8.dex */
public final class zzen {
    public static String zza(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            length = objArr.length;
            if (i13 >= length) {
                break;
            }
            Object obj = objArr[i13];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e12) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb2.append(name);
                    sb2.append("@");
                    sb2.append(hexString);
                    String string2 = sb2.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(string2), (Throwable) e12);
                    String name2 = e12.getClass().getName();
                    StringBuilder sb3 = new StringBuilder(string2.length() + 8 + name2.length() + 1);
                    sb3.append("<");
                    sb3.append(string2);
                    sb3.append(" threw ");
                    sb3.append(name2);
                    sb3.append(">");
                    string = sb3.toString();
                }
            }
            objArr[i13] = string;
            i13++;
        }
        StringBuilder sb4 = new StringBuilder(str.length() + (length * 16));
        int i14 = 0;
        while (true) {
            length2 = objArr.length;
            if (i12 >= length2 || (iIndexOf = str.indexOf("%s", i14)) == -1) {
                break;
            }
            sb4.append((CharSequence) str, i14, iIndexOf);
            sb4.append(objArr[i12]);
            i14 = iIndexOf + 2;
            i12++;
        }
        sb4.append((CharSequence) str, i14, str.length());
        if (i12 < length2) {
            sb4.append(" [");
            sb4.append(objArr[i12]);
            for (int i15 = i12 + 1; i15 < objArr.length; i15++) {
                sb4.append(", ");
                sb4.append(objArr[i15]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }
}
