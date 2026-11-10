package com.google.android.gms.internal.identity;

import com.braze.Constants;
import com.incognia.core.SeH;
import com.instabug.library.util.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes8.dex */
public final class zzej {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc;

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        zzc = new StringBuilder(33);
    }

    public static String zza(long j12) {
        return j12 >= 0 ? zza.format(new Date(j12)) : Long.toString(j12);
    }

    public static String zzb(long j12) {
        String string;
        StringBuilder sb2 = zzc;
        synchronized (sb2) {
            sb2.setLength(0);
            zzc(j12, sb2);
            string = sb2.toString();
        }
        return string;
    }

    public static StringBuilder zzc(long j12, StringBuilder sb2) {
        if (j12 == 0) {
            sb2.append("0s");
            return sb2;
        }
        sb2.ensureCapacity(sb2.length() + 27);
        boolean z12 = false;
        if (j12 < 0) {
            sb2.append("-");
            if (j12 != Long.MIN_VALUE) {
                j12 = -j12;
            } else {
                j12 = Long.MAX_VALUE;
                z12 = true;
            }
        }
        if (j12 >= SeH.f34149e) {
            sb2.append(j12 / SeH.f34149e);
            sb2.append(Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE);
            j12 %= SeH.f34149e;
        }
        if (true == z12) {
            j12 = 25975808;
        }
        if (j12 >= 3600000) {
            sb2.append(j12 / 3600000);
            sb2.append("h");
            j12 %= 3600000;
        }
        if (j12 >= TimeUtils.MINUTE) {
            sb2.append(j12 / TimeUtils.MINUTE);
            sb2.append("m");
            j12 %= TimeUtils.MINUTE;
        }
        if (j12 >= 1000) {
            sb2.append(j12 / 1000);
            sb2.append(Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY);
            j12 %= 1000;
        }
        if (j12 > 0) {
            sb2.append(j12);
            sb2.append("ms");
        }
        return sb2;
    }
}
