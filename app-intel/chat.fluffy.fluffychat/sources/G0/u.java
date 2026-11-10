package G0;

import E0.AbstractC0332s;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f3217a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f3218b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static String a(long j7, long j8) {
        if (j7 == 0 && j8 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j7);
        sb.append("-");
        if (j8 != -1) {
            sb.append((j7 + j8) - 1);
        }
        return sb.toString();
    }

    public static long b(String str, String str2) throws NumberFormatException {
        long j7;
        if (TextUtils.isEmpty(str)) {
            j7 = -1;
        } else {
            try {
                j7 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                AbstractC0332s.c("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j7;
        }
        Matcher matcher = f3217a.matcher(str2);
        if (!matcher.matches()) {
            return j7;
        }
        try {
            long j8 = (Long.parseLong((String) j3.o.q(matcher.group(2))) - Long.parseLong((String) j3.o.q(matcher.group(1)))) + 1;
            if (j7 < 0) {
                return j8;
            }
            if (j7 == j8) {
                return j7;
            }
            AbstractC0332s.h("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j7, j8);
        } catch (NumberFormatException unused2) {
            AbstractC0332s.c("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j7;
        }
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f3218b.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) j3.o.q(matcher.group(1)));
        }
        return -1L;
    }
}
