package z2;

import M5.m;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0809n;

/* renamed from: z2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1842a implements b, B2.c, DefaultLifecycleObserver {

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f24096l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f24097m;

    public C1842a(ImageView imageView) {
        m.e(imageView, "view");
        this.f24096l = imageView;
    }

    @Override // z2.b
    public void b() {
        e(null);
    }

    @Override // z2.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ImageView a() {
        return this.f24096l;
    }

    public void e(Drawable drawable) {
        Object drawable2 = a().getDrawable();
        Animatable animatable = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable != null) {
            animatable.stop();
        }
        a().setImageDrawable(drawable);
        f();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C1842a) && m.a(a(), ((C1842a) obj).a());
        }
        return true;
    }

    public void f() {
        Object drawable = a().getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable == null) {
            return;
        }
        if (this.f24097m) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // z2.c
    public void onError(Drawable drawable) {
        e(drawable);
    }

    @Override // z2.c
    public void onStart(Drawable drawable) {
        e(drawable);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(InterfaceC0809n interfaceC0809n) {
        m.e(interfaceC0809n, "owner");
        this.f24097m = false;
        f();
    }

    @Override // z2.c
    public void onSuccess(Drawable drawable) {
        m.e(drawable, "result");
        e(drawable);
    }

    public String toString() {
        return "ImageViewTarget(view=" + a() + ')';
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(InterfaceC0809n interfaceC0809n) {
        m.e(interfaceC0809n, "owner");
        this.f24097m = true;
        f();
    }
}
