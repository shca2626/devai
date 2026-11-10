package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class CircleImageView extends ImageView {

    /* renamed from: F, reason: collision with root package name */
    public static final ImageView.ScaleType f15289F = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: G, reason: collision with root package name */
    public static final Bitmap.Config f15290G = Bitmap.Config.ARGB_8888;

    /* renamed from: A, reason: collision with root package name */
    public ColorFilter f15291A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f15292B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f15293C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f15294D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f15295E;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f15296l;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f15297m;

    /* renamed from: n, reason: collision with root package name */
    public final Matrix f15298n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f15299o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f15300p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f15301q;

    /* renamed from: r, reason: collision with root package name */
    public int f15302r;

    /* renamed from: s, reason: collision with root package name */
    public int f15303s;

    /* renamed from: t, reason: collision with root package name */
    public int f15304t;

    /* renamed from: u, reason: collision with root package name */
    public Bitmap f15305u;

    /* renamed from: v, reason: collision with root package name */
    public BitmapShader f15306v;

    /* renamed from: w, reason: collision with root package name */
    public int f15307w;

    /* renamed from: x, reason: collision with root package name */
    public int f15308x;

    /* renamed from: y, reason: collision with root package name */
    public float f15309y;

    /* renamed from: z, reason: collision with root package name */
    public float f15310z;

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (CircleImageView.this.f15295E) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                return;
            }
            Rect rect = new Rect();
            CircleImageView.this.f15297m.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c() {
        Paint paint = this.f15299o;
        if (paint != null) {
            paint.setColorFilter(this.f15291A);
        }
    }

    public final RectF d() {
        int iMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((r0 - iMin) / 2.0f);
        float paddingTop = getPaddingTop() + ((r1 - iMin) / 2.0f);
        float f7 = iMin;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f7, f7 + paddingTop);
    }

    public final Bitmap e(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f15290G) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f15290G);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public final boolean f(float f7, float f8) {
        return this.f15297m.isEmpty() || Math.pow((double) (f7 - this.f15297m.centerX()), 2.0d) + Math.pow((double) (f8 - this.f15297m.centerY()), 2.0d) <= Math.pow((double) this.f15310z, 2.0d);
    }

    public final void g() {
        super.setScaleType(f15289F);
        this.f15292B = true;
        setOutlineProvider(new b());
        if (this.f15293C) {
            i();
            this.f15293C = false;
        }
    }

    public int getBorderColor() {
        return this.f15302r;
    }

    public int getBorderWidth() {
        return this.f15303s;
    }

    public int getCircleBackgroundColor() {
        return this.f15304t;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f15291A;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f15289F;
    }

    public final void h() {
        if (this.f15295E) {
            this.f15305u = null;
        } else {
            this.f15305u = e(getDrawable());
        }
        i();
    }

    public final void i() {
        int i7;
        if (!this.f15292B) {
            this.f15293C = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.f15305u == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.f15305u;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f15306v = new BitmapShader(bitmap, tileMode, tileMode);
        this.f15299o.setAntiAlias(true);
        this.f15299o.setDither(true);
        this.f15299o.setFilterBitmap(true);
        this.f15299o.setShader(this.f15306v);
        this.f15300p.setStyle(Paint.Style.STROKE);
        this.f15300p.setAntiAlias(true);
        this.f15300p.setColor(this.f15302r);
        this.f15300p.setStrokeWidth(this.f15303s);
        this.f15301q.setStyle(Paint.Style.FILL);
        this.f15301q.setAntiAlias(true);
        this.f15301q.setColor(this.f15304t);
        this.f15308x = this.f15305u.getHeight();
        this.f15307w = this.f15305u.getWidth();
        this.f15297m.set(d());
        this.f15310z = Math.min((this.f15297m.height() - this.f15303s) / 2.0f, (this.f15297m.width() - this.f15303s) / 2.0f);
        this.f15296l.set(this.f15297m);
        if (!this.f15294D && (i7 = this.f15303s) > 0) {
            this.f15296l.inset(i7 - 1.0f, i7 - 1.0f);
        }
        this.f15309y = Math.min(this.f15296l.height() / 2.0f, this.f15296l.width() / 2.0f);
        c();
        j();
        invalidate();
    }

    public final void j() {
        float fWidth;
        float fHeight;
        this.f15298n.set(null);
        float fWidth2 = 0.0f;
        if (this.f15307w * this.f15296l.height() > this.f15296l.width() * this.f15308x) {
            fWidth = this.f15296l.height() / this.f15308x;
            fHeight = 0.0f;
            fWidth2 = (this.f15296l.width() - (this.f15307w * fWidth)) * 0.5f;
        } else {
            fWidth = this.f15296l.width() / this.f15307w;
            fHeight = (this.f15296l.height() - (this.f15308x * fWidth)) * 0.5f;
        }
        this.f15298n.setScale(fWidth, fWidth);
        Matrix matrix = this.f15298n;
        RectF rectF = this.f15296l;
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF.left, ((int) (fHeight + 0.5f)) + rectF.top);
        this.f15306v.setLocalMatrix(this.f15298n);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f15295E) {
            super.onDraw(canvas);
            return;
        }
        if (this.f15305u == null) {
            return;
        }
        if (this.f15304t != 0) {
            canvas.drawCircle(this.f15296l.centerX(), this.f15296l.centerY(), this.f15309y, this.f15301q);
        }
        canvas.drawCircle(this.f15296l.centerX(), this.f15296l.centerY(), this.f15309y, this.f15299o);
        if (this.f15303s > 0) {
            canvas.drawCircle(this.f15297m.centerX(), this.f15297m.centerY(), this.f15310z, this.f15300p);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        i();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f15295E ? super.onTouchEvent(motionEvent) : f(motionEvent.getX(), motionEvent.getY()) && super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z7) {
        if (z7) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i7) {
        if (i7 == this.f15302r) {
            return;
        }
        this.f15302r = i7;
        this.f15300p.setColor(i7);
        invalidate();
    }

    public void setBorderOverlay(boolean z7) {
        if (z7 == this.f15294D) {
            return;
        }
        this.f15294D = z7;
        i();
    }

    public void setBorderWidth(int i7) {
        if (i7 == this.f15303s) {
            return;
        }
        this.f15303s = i7;
        i();
    }

    public void setCircleBackgroundColor(int i7) {
        if (i7 == this.f15304t) {
            return;
        }
        this.f15304t = i7;
        this.f15301q.setColor(i7);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int i7) {
        setCircleBackgroundColor(getContext().getResources().getColor(i7));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.f15291A) {
            return;
        }
        this.f15291A = colorFilter;
        c();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z7) {
        if (this.f15295E == z7) {
            return;
        }
        this.f15295E = z7;
        h();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i7) {
        super.setImageResource(i7);
        h();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h();
    }

    @Override // android.view.View
    public void setPadding(int i7, int i8, int i9, int i10) {
        super.setPadding(i7, i8, i9, i10);
        i();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i7, int i8, int i9, int i10) {
        super.setPaddingRelative(i7, i8, i9, i10);
        i();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f15289F) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f15296l = new RectF();
        this.f15297m = new RectF();
        this.f15298n = new Matrix();
        this.f15299o = new Paint();
        this.f15300p = new Paint();
        this.f15301q = new Paint();
        this.f15302r = -16777216;
        this.f15303s = 0;
        this.f15304t = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, M4.a.f5696a, i7, 0);
        this.f15303s = typedArrayObtainStyledAttributes.getDimensionPixelSize(M4.a.f5699d, 0);
        this.f15302r = typedArrayObtainStyledAttributes.getColor(M4.a.f5697b, -16777216);
        this.f15294D = typedArrayObtainStyledAttributes.getBoolean(M4.a.f5698c, false);
        this.f15304t = typedArrayObtainStyledAttributes.getColor(M4.a.f5700e, 0);
        typedArrayObtainStyledAttributes.recycle();
        g();
    }
}
