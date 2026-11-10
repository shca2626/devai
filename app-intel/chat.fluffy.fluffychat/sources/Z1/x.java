package Z1;

import android.os.Build;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f10341a = true;

    public static v a(ViewGroup viewGroup) {
        return new u(viewGroup);
    }

    public static void b(ViewGroup viewGroup, boolean z7) {
        if (f10341a) {
            try {
                viewGroup.suppressLayout(z7);
            } catch (NoSuchMethodError unused) {
                f10341a = false;
            }
        }
    }

    public static void c(ViewGroup viewGroup, boolean z7) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z7);
        } else {
            b(viewGroup, z7);
        }
    }
}
