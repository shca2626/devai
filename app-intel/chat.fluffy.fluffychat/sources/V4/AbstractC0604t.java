package V4;

import android.view.View;

/* renamed from: V4.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0604t {

    /* renamed from: V4.t$a */
    public interface a {
        void a(int i7, int i8);
    }

    public static void a(int i7, int i8, a aVar) {
        int mode = View.MeasureSpec.getMode(i7);
        aVar.a(Math.max(View.MeasureSpec.getSize(i7), mode == 0 ? 1 : 0), Math.max(View.MeasureSpec.getSize(i8), View.MeasureSpec.getMode(i8) == 0 ? 1 : 0));
    }
}
