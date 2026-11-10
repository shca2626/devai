package z2;

import M5.m;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public interface c {

    public static final class a {
        public static void a(c cVar, Drawable drawable) {
            m.e(cVar, "this");
        }

        public static void b(c cVar, Drawable drawable) {
            m.e(cVar, "this");
        }

        public static void c(c cVar, Drawable drawable) {
            m.e(cVar, "this");
            m.e(drawable, "result");
        }
    }

    void onError(Drawable drawable);

    void onStart(Drawable drawable);

    void onSuccess(Drawable drawable);
}
