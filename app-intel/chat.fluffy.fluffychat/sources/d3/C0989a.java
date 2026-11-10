package d3;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import f3.g;
import f3.k;
import f3.n;

/* renamed from: d3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0989a extends Drawable implements n {

    /* renamed from: l, reason: collision with root package name */
    public b f15160l;

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0989a mutate() {
        this.f15160l = new b(this.f15160l);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f15160l;
        if (bVar.f15162b) {
            bVar.f15161a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f15160l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f15160l.f15161a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15160l.f15161a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f15160l.f15161a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zB = AbstractC0990b.b(iArr);
        b bVar = this.f15160l;
        if (bVar.f15162b == zB) {
            return zOnStateChange;
        }
        bVar.f15162b = zB;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f15160l.f15161a.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15160l.f15161a.setColorFilter(colorFilter);
    }

    @Override // f3.n
    public void setShapeAppearanceModel(k kVar) {
        this.f15160l.f15161a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i7) {
        this.f15160l.f15161a.setTint(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f15160l.f15161a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f15160l.f15161a.setTintMode(mode);
    }

    public C0989a(k kVar) {
        this(new b(new g(kVar)));
    }

    /* renamed from: d3.a$b */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public g f15161a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f15162b;

        public b(g gVar) {
            this.f15161a = gVar;
            this.f15162b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0989a newDrawable() {
            return new C0989a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f15161a = (g) bVar.f15161a.getConstantState().newDrawable();
            this.f15162b = bVar.f15162b;
        }
    }

    public C0989a(b bVar) {
        this.f15160l = bVar;
    }
}
