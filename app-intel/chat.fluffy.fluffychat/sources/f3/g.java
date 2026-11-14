package f3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import e3.C1033a;
import f3.k;
import f3.l;
import f3.m;
import java.util.BitSet;

/* loaded from: classes.dex */
public class g extends Drawable implements n {

    /* renamed from: I, reason: collision with root package name */
    public static final String f15720I = "g";

    /* renamed from: J, reason: collision with root package name */
    public static final Paint f15721J;

    /* renamed from: A, reason: collision with root package name */
    public final C1033a f15722A;

    /* renamed from: B, reason: collision with root package name */
    public final l.b f15723B;

    /* renamed from: C, reason: collision with root package name */
    public final l f15724C;

    /* renamed from: D, reason: collision with root package name */
    public PorterDuffColorFilter f15725D;

    /* renamed from: E, reason: collision with root package name */
    public PorterDuffColorFilter f15726E;

    /* renamed from: F, reason: collision with root package name */
    public int f15727F;

    /* renamed from: G, reason: collision with root package name */
    public final RectF f15728G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f15729H;

    /* renamed from: l, reason: collision with root package name */
    public c f15730l;

    /* renamed from: m, reason: collision with root package name */
    public final m.g[] f15731m;

    /* renamed from: n, reason: collision with root package name */
    public final m.g[] f15732n;

    /* renamed from: o, reason: collision with root package name */
    public final BitSet f15733o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15734p;

    /* renamed from: q, reason: collision with root package name */
    public final Matrix f15735q;

    /* renamed from: r, reason: collision with root package name */
    public final Path f15736r;

    /* renamed from: s, reason: collision with root package name */
    public final Path f15737s;

    /* renamed from: t, reason: collision with root package name */
    public final RectF f15738t;

    /* renamed from: u, reason: collision with root package name */
    public final RectF f15739u;

    /* renamed from: v, reason: collision with root package name */
    public final Region f15740v;

    /* renamed from: w, reason: collision with root package name */
    public final Region f15741w;

    /* renamed from: x, reason: collision with root package name */
    public k f15742x;

    /* renamed from: y, reason: collision with root package name */
    public final Paint f15743y;

    /* renamed from: z, reason: collision with root package name */
    public final Paint f15744z;

    public class a implements l.b {
        public a() {
        }

        @Override // f3.l.b
        public void a(m mVar, Matrix matrix, int i7) {
            g.this.f15733o.set(i7, mVar.e());
            g.this.f15731m[i7] = mVar.f(matrix);
        }

        @Override // f3.l.b
        public void b(m mVar, Matrix matrix, int i7) {
            g.this.f15733o.set(i7 + 4, mVar.e());
            g.this.f15732n[i7] = mVar.f(matrix);
        }
    }

    public class b implements k.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f15746a;

        public b(float f7) {
            this.f15746a = f7;
        }

        @Override // f3.k.c
        public f3.c a(f3.c cVar) {
            return cVar instanceof i ? cVar : new f3.b(this.f15746a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        f15721J = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public static int P(int i7, int i8) {
        return (i7 * (i8 + (i8 >>> 7))) >>> 8;
    }

    public static g m(Context context, float f7) {
        int iC = V2.b.c(context, O2.a.f6748k, g.class.getSimpleName());
        g gVar = new g();
        gVar.K(context);
        gVar.U(ColorStateList.valueOf(iC));
        gVar.T(f7);
        return gVar;
    }

    public int A() {
        c cVar = this.f15730l;
        return (int) (cVar.f15766s * Math.cos(Math.toRadians(cVar.f15767t)));
    }

    public k B() {
        return this.f15730l.f15748a;
    }

    public final float C() {
        if (J()) {
            return this.f15744z.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float D() {
        return this.f15730l.f15748a.r().a(u());
    }

    public float E() {
        return this.f15730l.f15748a.t().a(u());
    }

    public float F() {
        return this.f15730l.f15763p;
    }

    public float G() {
        return w() + F();
    }

    public final boolean H() {
        c cVar = this.f15730l;
        int i7 = cVar.f15764q;
        if (i7 == 1 || cVar.f15765r <= 0) {
            return false;
        }
        return i7 == 2 || R();
    }

    public final boolean I() {
        Paint.Style style = this.f15730l.f15769v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean J() {
        Paint.Style style = this.f15730l.f15769v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f15744z.getStrokeWidth() > 0.0f;
    }

    public void K(Context context) {
        this.f15730l.f15749b = new Y2.a(context);
        e0();
    }

    public final void L() {
        super.invalidateSelf();
    }

    public boolean M() {
        Y2.a aVar = this.f15730l.f15749b;
        return aVar != null && aVar.d();
    }

    public boolean N() {
        return this.f15730l.f15748a.u(u());
    }

    public final void O(Canvas canvas) {
        if (H()) {
            canvas.save();
            Q(canvas);
            if (!this.f15729H) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f15728G.width() - getBounds().width());
            int iHeight = (int) (this.f15728G.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f15728G.width()) + (this.f15730l.f15765r * 2) + iWidth, ((int) this.f15728G.height()) + (this.f15730l.f15765r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f7 = (getBounds().left - this.f15730l.f15765r) - iWidth;
            float f8 = (getBounds().top - this.f15730l.f15765r) - iHeight;
            canvas2.translate(-f7, -f8);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f7, f8, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    public final void Q(Canvas canvas) {
        canvas.translate(z(), A());
    }

    public boolean R() {
        return (N() || this.f15736r.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void S(f3.c cVar) {
        setShapeAppearanceModel(this.f15730l.f15748a.x(cVar));
    }

    public void T(float f7) {
        c cVar = this.f15730l;
        if (cVar.f15762o != f7) {
            cVar.f15762o = f7;
            e0();
        }
    }

    public void U(ColorStateList colorStateList) {
        c cVar = this.f15730l;
        if (cVar.f15751d != colorStateList) {
            cVar.f15751d = colorStateList;
            onStateChange(getState());
        }
    }

    public void V(float f7) {
        c cVar = this.f15730l;
        if (cVar.f15758k != f7) {
            cVar.f15758k = f7;
            this.f15734p = true;
            invalidateSelf();
        }
    }

    public void W(int i7, int i8, int i9, int i10) {
        c cVar = this.f15730l;
        if (cVar.f15756i == null) {
            cVar.f15756i = new Rect();
        }
        this.f15730l.f15756i.set(i7, i8, i9, i10);
        invalidateSelf();
    }

    public void X(float f7) {
        c cVar = this.f15730l;
        if (cVar.f15761n != f7) {
            cVar.f15761n = f7;
            e0();
        }
    }

    public void Y(float f7, int i7) {
        b0(f7);
        a0(ColorStateList.valueOf(i7));
    }

    public void Z(float f7, ColorStateList colorStateList) {
        b0(f7);
        a0(colorStateList);
    }

    public void a0(ColorStateList colorStateList) {
        c cVar = this.f15730l;
        if (cVar.f15752e != colorStateList) {
            cVar.f15752e = colorStateList;
            onStateChange(getState());
        }
    }

    public void b0(float f7) {
        this.f15730l.f15759l = f7;
        invalidateSelf();
    }

    public final boolean c0(int[] iArr) {
        boolean z7;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f15730l.f15751d == null || color2 == (colorForState2 = this.f15730l.f15751d.getColorForState(iArr, (color2 = this.f15743y.getColor())))) {
            z7 = false;
        } else {
            this.f15743y.setColor(colorForState2);
            z7 = true;
        }
        if (this.f15730l.f15752e == null || color == (colorForState = this.f15730l.f15752e.getColorForState(iArr, (color = this.f15744z.getColor())))) {
            return z7;
        }
        this.f15744z.setColor(colorForState);
        return true;
    }

    public final boolean d0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f15725D;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f15726E;
        c cVar = this.f15730l;
        this.f15725D = k(cVar.f15754g, cVar.f15755h, this.f15743y, true);
        c cVar2 = this.f15730l;
        this.f15726E = k(cVar2.f15753f, cVar2.f15755h, this.f15744z, false);
        c cVar3 = this.f15730l;
        if (cVar3.f15768u) {
            this.f15722A.d(cVar3.f15754g.getColorForState(getState(), 0));
        }
        return (Y.c.a(porterDuffColorFilter, this.f15725D) && Y.c.a(porterDuffColorFilter2, this.f15726E)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f15743y.setColorFilter(this.f15725D);
        int alpha = this.f15743y.getAlpha();
        this.f15743y.setAlpha(P(alpha, this.f15730l.f15760m));
        this.f15744z.setColorFilter(this.f15726E);
        this.f15744z.setStrokeWidth(this.f15730l.f15759l);
        int alpha2 = this.f15744z.getAlpha();
        this.f15744z.setAlpha(P(alpha2, this.f15730l.f15760m));
        if (this.f15734p) {
            i();
            g(u(), this.f15736r);
            this.f15734p = false;
        }
        O(canvas);
        if (I()) {
            o(canvas);
        }
        if (J()) {
            r(canvas);
        }
        this.f15743y.setAlpha(alpha);
        this.f15744z.setAlpha(alpha2);
    }

    public final void e0() {
        float fG = G();
        this.f15730l.f15765r = (int) Math.ceil(0.75f * fG);
        this.f15730l.f15766s = (int) Math.ceil(fG * 0.25f);
        d0();
        L();
    }

    public final PorterDuffColorFilter f(Paint paint, boolean z7) {
        if (!z7) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f15727F = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public final void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f15730l.f15757j != 1.0f) {
            this.f15735q.reset();
            Matrix matrix = this.f15735q;
            float f7 = this.f15730l.f15757j;
            matrix.setScale(f7, f7, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f15735q);
        }
        path.computeBounds(this.f15728G, true);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f15730l.f15760m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f15730l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f15730l.f15764q == 2) {
            return;
        }
        if (N()) {
            outline.setRoundRect(getBounds(), D() * this.f15730l.f15758k);
            return;
        }
        g(u(), this.f15736r);
        if (this.f15736r.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f15736r);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f15730l.f15756i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f15740v.set(getBounds());
        g(u(), this.f15736r);
        this.f15741w.setPath(this.f15736r, this.f15740v);
        this.f15740v.op(this.f15741w, Region.Op.DIFFERENCE);
        return this.f15740v;
    }

    public final void h(RectF rectF, Path path) {
        l lVar = this.f15724C;
        c cVar = this.f15730l;
        lVar.e(cVar.f15748a, cVar.f15758k, rectF, this.f15723B, path);
    }

    public final void i() {
        k kVarY = B().y(new b(-C()));
        this.f15742x = kVarY;
        this.f15724C.d(kVarY, this.f15730l.f15758k, v(), this.f15737s);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f15734p = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f15730l.f15754g;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f15730l.f15753f;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f15730l.f15752e;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        ColorStateList colorStateList4 = this.f15730l.f15751d;
        return colorStateList4 != null && colorStateList4.isStateful();
    }

    public final PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z7) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z7) {
            colorForState = l(colorForState);
        }
        this.f15727F = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z7) {
        return (colorStateList == null || mode == null) ? f(paint, z7) : j(colorStateList, mode, z7);
    }

    public int l(int i7) {
        float fG = G() + y();
        Y2.a aVar = this.f15730l.f15749b;
        return aVar != null ? aVar.c(i7, fG) : i7;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f15730l = new c(this.f15730l);
        return this;
    }

    public final void n(Canvas canvas) {
        if (this.f15733o.cardinality() > 0) {
            Log.w(f15720I, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f15730l.f15766s != 0) {
            canvas.drawPath(this.f15736r, this.f15722A.c());
        }
        for (int i7 = 0; i7 < 4; i7++) {
            this.f15731m[i7].b(this.f15722A, this.f15730l.f15765r, canvas);
            this.f15732n[i7].b(this.f15722A, this.f15730l.f15765r, canvas);
        }
        if (this.f15729H) {
            int iZ = z();
            int iA = A();
            canvas.translate(-iZ, -iA);
            canvas.drawPath(this.f15736r, f15721J);
            canvas.translate(iZ, iA);
        }
    }

    public final void o(Canvas canvas) {
        q(canvas, this.f15743y, this.f15736r, this.f15730l.f15748a, u());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f15734p = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, a3.i.b
    public boolean onStateChange(int[] iArr) {
        boolean z7 = c0(iArr) || d0();
        if (z7) {
            invalidateSelf();
        }
        return z7;
    }

    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f15730l.f15748a, rectF);
    }

    public final void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF) * this.f15730l.f15758k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void r(Canvas canvas) {
        q(canvas, this.f15744z, this.f15737s, this.f15742x, v());
    }

    public float s() {
        return this.f15730l.f15748a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        c cVar = this.f15730l;
        if (cVar.f15760m != i7) {
            cVar.f15760m = i7;
            L();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15730l.f15750c = colorFilter;
        L();
    }

    @Override // f3.n
    public void setShapeAppearanceModel(k kVar) {
        this.f15730l.f15748a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i7) {
        setTintList(ColorStateList.valueOf(i7));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f15730l.f15754g = colorStateList;
        d0();
        L();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f15730l;
        if (cVar.f15755h != mode) {
            cVar.f15755h = mode;
            d0();
            L();
        }
    }

    public float t() {
        return this.f15730l.f15748a.l().a(u());
    }

    public RectF u() {
        this.f15738t.set(getBounds());
        return this.f15738t;
    }

    public final RectF v() {
        this.f15739u.set(u());
        float fC = C();
        this.f15739u.inset(fC, fC);
        return this.f15739u;
    }

    public float w() {
        return this.f15730l.f15762o;
    }

    public ColorStateList x() {
        return this.f15730l.f15751d;
    }

    public float y() {
        return this.f15730l.f15761n;
    }

    public int z() {
        c cVar = this.f15730l;
        return (int) (cVar.f15766s * Math.sin(Math.toRadians(cVar.f15767t)));
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i7, int i8) {
        this(k.e(context, attributeSet, i7, i8).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    public g(c cVar) {
        l lVar;
        this.f15731m = new m.g[4];
        this.f15732n = new m.g[4];
        this.f15733o = new BitSet(8);
        this.f15735q = new Matrix();
        this.f15736r = new Path();
        this.f15737s = new Path();
        this.f15738t = new RectF();
        this.f15739u = new RectF();
        this.f15740v = new Region();
        this.f15741w = new Region();
        Paint paint = new Paint(1);
        this.f15743y = paint;
        Paint paint2 = new Paint(1);
        this.f15744z = paint2;
        this.f15722A = new C1033a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.f15724C = lVar;
        this.f15728G = new RectF();
        this.f15729H = true;
        this.f15730l = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        d0();
        c0(getState());
        this.f15723B = new a();
    }

    public static final class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public k f15748a;

        /* renamed from: b, reason: collision with root package name */
        public Y2.a f15749b;

        /* renamed from: c, reason: collision with root package name */
        public ColorFilter f15750c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f15751d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f15752e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f15753f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f15754g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f15755h;

        /* renamed from: i, reason: collision with root package name */
        public Rect f15756i;

        /* renamed from: j, reason: collision with root package name */
        public float f15757j;

        /* renamed from: k, reason: collision with root package name */
        public float f15758k;

        /* renamed from: l, reason: collision with root package name */
        public float f15759l;

        /* renamed from: m, reason: collision with root package name */
        public int f15760m;

        /* renamed from: n, reason: collision with root package name */
        public float f15761n;

        /* renamed from: o, reason: collision with root package name */
        public float f15762o;

        /* renamed from: p, reason: collision with root package name */
        public float f15763p;

        /* renamed from: q, reason: collision with root package name */
        public int f15764q;

        /* renamed from: r, reason: collision with root package name */
        public int f15765r;

        /* renamed from: s, reason: collision with root package name */
        public int f15766s;

        /* renamed from: t, reason: collision with root package name */
        public int f15767t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f15768u;

        /* renamed from: v, reason: collision with root package name */
        public Paint.Style f15769v;

        public c(k kVar, Y2.a aVar) {
            this.f15751d = null;
            this.f15752e = null;
            this.f15753f = null;
            this.f15754g = null;
            this.f15755h = PorterDuff.Mode.SRC_IN;
            this.f15756i = null;
            this.f15757j = 1.0f;
            this.f15758k = 1.0f;
            this.f15760m = 255;
            this.f15761n = 0.0f;
            this.f15762o = 0.0f;
            this.f15763p = 0.0f;
            this.f15764q = 0;
            this.f15765r = 0;
            this.f15766s = 0;
            this.f15767t = 0;
            this.f15768u = false;
            this.f15769v = Paint.Style.FILL_AND_STROKE;
            this.f15748a = kVar;
            this.f15749b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f15734p = true;
            return gVar;
        }

        public c(c cVar) {
            this.f15751d = null;
            this.f15752e = null;
            this.f15753f = null;
            this.f15754g = null;
            this.f15755h = PorterDuff.Mode.SRC_IN;
            this.f15756i = null;
            this.f15757j = 1.0f;
            this.f15758k = 1.0f;
            this.f15760m = 255;
            this.f15761n = 0.0f;
            this.f15762o = 0.0f;
            this.f15763p = 0.0f;
            this.f15764q = 0;
            this.f15765r = 0;
            this.f15766s = 0;
            this.f15767t = 0;
            this.f15768u = false;
            this.f15769v = Paint.Style.FILL_AND_STROKE;
            this.f15748a = cVar.f15748a;
            this.f15749b = cVar.f15749b;
            this.f15759l = cVar.f15759l;
            this.f15750c = cVar.f15750c;
            this.f15751d = cVar.f15751d;
            this.f15752e = cVar.f15752e;
            this.f15755h = cVar.f15755h;
            this.f15754g = cVar.f15754g;
            this.f15760m = cVar.f15760m;
            this.f15757j = cVar.f15757j;
            this.f15766s = cVar.f15766s;
            this.f15764q = cVar.f15764q;
            this.f15768u = cVar.f15768u;
            this.f15758k = cVar.f15758k;
            this.f15761n = cVar.f15761n;
            this.f15762o = cVar.f15762o;
            this.f15763p = cVar.f15763p;
            this.f15765r = cVar.f15765r;
            this.f15767t = cVar.f15767t;
            this.f15753f = cVar.f15753f;
            this.f15769v = cVar.f15769v;
            if (cVar.f15756i != null) {
                this.f15756i = new Rect(cVar.f15756i);
            }
        }
    }
}
