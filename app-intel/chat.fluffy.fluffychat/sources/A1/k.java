package A1;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class k {
    public static String a(B0.s sVar) {
        String str = sVar.f759o;
        return B0.z.t(str) ? "video/mp4" : B0.z.o(str) ? "audio/mp4" : B0.z.q(str) ? Objects.equals(str, "image/heic") ? "image/heif" : Objects.equals(str, "image/avif") ? "image/avif" : "application/mp4" : "application/mp4";
    }

    public static String b(List list) {
        Iterator it = list.iterator();
        boolean z7 = false;
        String str = null;
        while (it.hasNext()) {
            String str2 = ((z) it.next()).f245a.f216g.f759o;
            if (B0.z.t(str2)) {
                return "video/mp4";
            }
            if (B0.z.o(str2)) {
                z7 = true;
            } else if (B0.z.q(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z7 ? "audio/mp4" : str != null ? str : "application/mp4";
    }
}
