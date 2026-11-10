package q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: q.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1480q extends ImageView {

    /* renamed from: l, reason: collision with root package name */
    public final C1467d f21333l;

    /* renamed from: m, reason: collision with root package name */
    public final C1479p f21334m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21335n;

    public C1480q(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1467d c1467d = this.f21333l;
        if (c1467d != null) {
            c1467d.b();
        }
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            c1479p.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1467d c1467d = this.f21333l;
        if (c1467d != null) {
            return c1467d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1467d c1467d = this.f21333l;
        if (c1467d != null) {
            return c1467d.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            return c1479p.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            return c1479p.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f21334m.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1467d c1467d = this.f21333l;
        if (c1467d != null) {
            c1467d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C1467d c1467d = this.f21333l;
        if (c1467d != null) {
            c1467d.g(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            c1479p.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C1479p c1479p = this.f21334m;
        if (c1479p != null && drawable != null && !this.f21335n) {
            c1479p.h(drawable);
        }
        super.setImageDrawable(drawable);
        C1479p c1479p2 = this.f21334m;
        if (c1479p2 != null) {
            c1479p2.c();
            if (this.f21335n) {
                return;
            }
            this.f21334m.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i7) {
        super.setImageLevel(i7);
        this.f21335n = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i7) {
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            c1479p.i(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            c1479p.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1467d c1467d = this.f21333l;
        if (c1467d != null) {
            c1467d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1467d c1467d = this.f21333l;
        if (c1467d != null) {
            c1467d.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            c1479p.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C1479p c1479p = this.f21334m;
        if (c1479p != null) {
            c1479p.k(mode);
        }
    }

    public C1480q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1480q(Context context, AttributeSet attributeSet, int i7) {
        super(a0.b(context), attributeSet, i7);
        this.f21335n = false;
        Z.a(this, getContext());
        C1467d c1467d = new C1467d(this);
        this.f21333l = c1467d;
        c1467d.e(attributeSet, i7);
        C1479p c1479p = new C1479p(this);
        this.f21334m = c1479p;
        c1479p.g(attributeSet, i7);
    }
}
