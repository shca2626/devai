package Z;

import android.os.Build;
import android.view.Display;

/* loaded from: classes.dex */
public abstract class r {
    public static P a(Display display, int i7) {
        if (Build.VERSION.SDK_INT >= 31) {
            return P.d(display.getRoundedCorner(i7));
        }
        return null;
    }
}
