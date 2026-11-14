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
public class C1479q extends ImageView {

    /* renamed from: l, reason: collision with root package name */
    public final C1466d f21339l;

    /* renamed from: m, reason: collision with root package name */
    public final C1478p f21340m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21341n;

    public C1479q(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1466d c1466d = this.f21339l;
        if (c1466d != null) {
            c1466d.b();
        }
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            c1478p.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1466d c1466d = this.f21339l;
        if (c1466d != null) {
            return c1466d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1466d c1466d = this.f21339l;
        if (c1466d != null) {
            return c1466d.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            return c1478p.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            return c1478p.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f21340m.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1466d c1466d = this.f21339l;
        if (c1466d != null) {
            c1466d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C1466d c1466d = this.f21339l;
        if (c1466d != null) {
            c1466d.g(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            c1478p.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C1478p c1478p = this.f21340m;
        if (c1478p != null && drawable != null && !this.f21341n) {
            c1478p.h(drawable);
        }
        super.setImageDrawable(drawable);
        C1478p c1478p2 = this.f21340m;
        if (c1478p2 != null) {
            c1478p2.c();
            if (this.f21341n) {
                return;
            }
            this.f21340m.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i7) {
        super.setImageLevel(i7);
        this.f21341n = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i7) {
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            c1478p.i(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            c1478p.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1466d c1466d = this.f21339l;
        if (c1466d != null) {
            c1466d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1466d c1466d = this.f21339l;
        if (c1466d != null) {
            c1466d.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            c1478p.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C1478p c1478p = this.f21340m;
        if (c1478p != null) {
            c1478p.k(mode);
        }
    }

    public C1479q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1479q(Context context, AttributeSet attributeSet, int i7) {
        super(a0.b(context), attributeSet, i7);
        this.f21341n = false;
        Z.a(this, getContext());
        C1466d c1466d = new C1466d(this);
        this.f21339l = c1466d;
        c1466d.e(attributeSet, i7);
        C1478p c1478p = new C1478p(this);
        this.f21340m = c1478p;
        c1478p.g(attributeSet, i7);
    }
}
