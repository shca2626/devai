package Z1;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
public class y implements z {

    /* renamed from: a, reason: collision with root package name */
    public final ViewOverlay f10342a;

    public y(View view) {
        this.f10342a = view.getOverlay();
    }

    @Override // Z1.z
    public void a(Drawable drawable) {
        this.f10342a.add(drawable);
    }

    @Override // Z1.z
    public void b(Drawable drawable) {
        this.f10342a.remove(drawable);
    }
}
