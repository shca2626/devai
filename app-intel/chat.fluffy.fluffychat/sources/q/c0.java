package q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class c0 extends W {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f21244b;

    public c0(Context context, Resources resources) {
        super(resources);
        this.f21244b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i7) {
        Drawable drawableA = a(i7);
        Context context = (Context) this.f21244b.get();
        if (drawableA != null && context != null) {
            V.g().w(context, i7, drawableA);
        }
        return drawableA;
    }
}
