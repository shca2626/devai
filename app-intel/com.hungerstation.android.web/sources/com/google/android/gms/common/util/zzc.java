package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
final class zzc {
    private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String zza(String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = zza.matcher(str);
        StringBuilder sb2 = null;
        int iEnd = 0;
        while (matcher.find()) {
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            int iStart = matcher.start();
            int i12 = iStart;
            while (i12 >= 0 && str.charAt(i12) == '\\') {
                i12--;
            }
            if ((iStart - i12) % 2 != 0) {
                int i13 = Integer.parseInt(matcher.group().substring(2), 16);
                sb2.append((CharSequence) str, iEnd, matcher.start());
                if (i13 == 92) {
                    sb2.append("\\\\");
                } else {
                    sb2.append(Character.toChars(i13));
                }
                iEnd = matcher.end();
            }
        }
        if (sb2 == null) {
            return str;
        }
        if (iEnd < matcher.regionEnd()) {
            sb2.append((CharSequence) str, iEnd, matcher.regionEnd());
        }
        return sb2.toString();
    }
}
