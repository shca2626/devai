package U0;

import B0.A;
import E0.U;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final u f8382c = new u(0, -9223372036854775807L);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f8383d = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    /* renamed from: a, reason: collision with root package name */
    public final long f8384a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8385b;

    public u(long j7, long j8) {
        this.f8384a = j7;
        this.f8385b = j8;
    }

    public static String b(long j7) {
        return U.G("npt=%.3f-", Double.valueOf(j7 / 1000.0d));
    }

    public static u d(String str) throws A {
        long j7;
        Matcher matcher = f8383d.matcher(str);
        androidx.media3.exoplayer.rtsp.h.a(matcher.matches(), str);
        String strGroup = matcher.group(1);
        androidx.media3.exoplayer.rtsp.h.a(strGroup != null, str);
        long j8 = ((String) U.i(strGroup)).equals("now") ? 0L : (long) (Float.parseFloat(strGroup) * 1000.0f);
        String strGroup2 = matcher.group(2);
        if (strGroup2 != null) {
            try {
                j7 = (long) (Float.parseFloat(strGroup2) * 1000.0f);
                androidx.media3.exoplayer.rtsp.h.a(j7 >= j8, str);
            } catch (NumberFormatException e7) {
                throw A.c(strGroup2, e7);
            }
        } else {
            j7 = -9223372036854775807L;
        }
        return new u(j8, j7);
    }

    public long a() {
        return this.f8385b - this.f8384a;
    }

    public boolean c() {
        return this.f8385b == -9223372036854775807L;
    }
}
