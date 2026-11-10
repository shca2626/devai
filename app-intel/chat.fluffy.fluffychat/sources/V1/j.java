package V1;

import android.os.Bundle;
import java.util.List;

/* loaded from: classes.dex */
public abstract class j {
    public static Bundle a(Bundle bundle) {
        M5.m.e(bundle, "source");
        return bundle;
    }

    public static final void b(Bundle bundle, Bundle bundle2) {
        M5.m.e(bundle2, "from");
        bundle.putAll(bundle2);
    }

    public static final void c(Bundle bundle, String str, Bundle bundle2) {
        M5.m.e(str, "key");
        M5.m.e(bundle2, "value");
        bundle.putBundle(str, bundle2);
    }

    public static final void d(Bundle bundle, String str, List list) {
        M5.m.e(str, "key");
        M5.m.e(list, "value");
        bundle.putStringArrayList(str, k.a(list));
    }

    public static final void e(Bundle bundle, String str) {
        M5.m.e(str, "key");
        bundle.remove(str);
    }
}
