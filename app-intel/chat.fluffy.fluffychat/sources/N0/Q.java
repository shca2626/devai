package N0;

import android.util.Pair;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class Q {
    public static long a(Map map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = (String) map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    public static Pair b(InterfaceC0542m interfaceC0542m) {
        Map mapE = interfaceC0542m.e();
        if (mapE == null) {
            return null;
        }
        return new Pair(Long.valueOf(a(mapE, "LicenseDurationRemaining")), Long.valueOf(a(mapE, "PlaybackDurationRemaining")));
    }
}
