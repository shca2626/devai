package U0;

import E0.U;
import android.net.Uri;

/* loaded from: classes.dex */
public abstract class h {
    public static G0.j a(int i7) {
        return new G0.j(Uri.parse(U.G("%s:%d", "rtp://0.0.0.0", Integer.valueOf(i7))));
    }
}
