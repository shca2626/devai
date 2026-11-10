package Z1;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
public class u implements v {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f10340a;

    public u(ViewGroup viewGroup) {
        this.f10340a = viewGroup.getOverlay();
    }

    @Override // Z1.z
    public void a(Drawable drawable) {
        this.f10340a.add(drawable);
    }

    @Override // Z1.z
    public void b(Drawable drawable) {
        this.f10340a.remove(drawable);
    }

    @Override // Z1.v
    public void c(View view) {
        this.f10340a.add(view);
    }

    @Override // Z1.v
    public void d(View view) {
        this.f10340a.remove(view);
    }
}
