package V1;

import android.os.Bundle;
import java.util.List;
import java.util.Map;
import y5.C1808c;
import z5.C1862F;

/* loaded from: classes.dex */
public abstract class c {
    public static Bundle a(Bundle bundle) {
        M5.m.e(bundle, "source");
        return bundle;
    }

    public static final boolean b(Bundle bundle, String str) {
        M5.m.e(str, "key");
        return bundle.containsKey(str);
    }

    public static final Bundle c(Bundle bundle, String str) {
        M5.m.e(str, "key");
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return bundle2;
        }
        d.a(str);
        throw new C1808c();
    }

    public static final Bundle d(Bundle bundle, String str) {
        M5.m.e(str, "key");
        return bundle.getBundle(str);
    }

    public static final List e(Bundle bundle, String str) {
        M5.m.e(str, "key");
        return bundle.getStringArrayList(str);
    }

    public static final boolean f(Bundle bundle) {
        return bundle.isEmpty();
    }

    public static final Map g(Bundle bundle) {
        Map mapD = C1862F.d(bundle.size());
        for (String str : bundle.keySet()) {
            M5.m.b(str);
            mapD.put(str, bundle.get(str));
        }
        return C1862F.b(mapD);
    }
}
