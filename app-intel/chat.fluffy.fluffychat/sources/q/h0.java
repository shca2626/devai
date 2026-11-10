package q;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public abstract class h0 {

    public static class a {
        public static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            k0.g(view, charSequence);
        }
    }
}
