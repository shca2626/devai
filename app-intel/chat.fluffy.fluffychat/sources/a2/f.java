package a2;

import N.k;
import O.d;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import y.C1787a;

/* loaded from: classes.dex */
public class f extends a2.e {

    /* renamed from: v, reason: collision with root package name */
    public static final PorterDuff.Mode f10596v = PorterDuff.Mode.SRC_IN;

    /* renamed from: m, reason: collision with root package name */
    public h f10597m;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuffColorFilter f10598n;

    /* renamed from: o, reason: collision with root package name */
    public ColorFilter f10599o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10600p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10601q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable.ConstantState f10602r;

    /* renamed from: s, reason: collision with root package name */
    public final float[] f10603s;

    /* renamed from: t, reason: collision with root package name */
    public final Matrix f10604t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f10605u;

    public static class b extends AbstractC0092f {
        public b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f10632b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f10631a = O.d.d(string2);
            }
            this.f10633c = k.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // a2.f.AbstractC0092f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.p(xmlPullParser, "pathData")) {
                TypedArray typedArrayQ = k.q(resources, theme, attributeSet, AbstractC0756a.f10569d);
                f(typedArrayQ, xmlPullParser);
                typedArrayQ.recycle();
            }
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f10652a;

        /* renamed from: b, reason: collision with root package name */
        public g f10653b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f10654c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f10655d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10656e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f10657f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f10658g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f10659h;

        /* renamed from: i, reason: collision with root package name */
        public int f10660i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f10661j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f10662k;

        /* renamed from: l, reason: collision with root package name */
        public Paint f10663l;

        public h(h hVar) {
            this.f10654c = null;
            this.f10655d = f.f10596v;
            if (hVar != null) {
                this.f10652a = hVar.f10652a;
                g gVar = new g(hVar.f10653b);
                this.f10653b = gVar;
                if (hVar.f10653b.f10640e != null) {
                    gVar.f10640e = new Paint(hVar.f10653b.f10640e);
                }
                if (hVar.f10653b.f10639d != null) {
                    this.f10653b.f10639d = new Paint(hVar.f10653b.f10639d);
                }
                this.f10654c = hVar.f10654c;
                this.f10655d = hVar.f10655d;
                this.f10656e = hVar.f10656e;
            }
        }

        public boolean a(int i7, int i8) {
            return i7 == this.f10657f.getWidth() && i8 == this.f10657f.getHeight();
        }

        public boolean b() {
            return !this.f10662k && this.f10658g == this.f10654c && this.f10659h == this.f10655d && this.f10661j == this.f10656e && this.f10660i == this.f10653b.getRootAlpha();
        }

        public void c(int i7, int i8) {
            if (this.f10657f == null || !a(i7, i8)) {
                this.f10657f = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
                this.f10662k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f10657f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f10663l == null) {
                Paint paint = new Paint();
                this.f10663l = paint;
                paint.setFilterBitmap(true);
            }
            this.f10663l.setAlpha(this.f10653b.getRootAlpha());
            this.f10663l.setColorFilter(colorFilter);
            return this.f10663l;
        }

        public boolean f() {
            return this.f10653b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f10653b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f10652a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f10653b.g(iArr);
            this.f10662k |= zG;
            return zG;
        }

        public void i() {
            this.f10658g = this.f10654c;
            this.f10659h = this.f10655d;
            this.f10660i = this.f10653b.getRootAlpha();
            this.f10661j = this.f10656e;
            this.f10662k = false;
        }

        public void j(int i7, int i8) {
            this.f10657f.eraseColor(0);
            this.f10653b.b(new Canvas(this.f10657f), i7, i8, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }

        public h() {
            this.f10654c = null;
            this.f10655d = f.f10596v;
            this.f10653b = new g();
        }
    }

    public f() {
        this.f10601q = true;
        this.f10603s = new float[9];
        this.f10604t = new Matrix();
        this.f10605u = new Rect();
        this.f10597m = new h();
    }

    public static int a(int i7, float f7) {
        return (i7 & 16777215) | (((int) (Color.alpha(i7) * f7)) << 24);
    }

    public static f b(Resources resources, int i7, Resources.Theme theme) {
        f fVar = new f();
        fVar.f10595l = N.h.e(resources, i7, theme);
        fVar.f10602r = new i(fVar.f10595l.getConstantState());
        return fVar;
    }

    public static PorterDuff.Mode f(int i7, PorterDuff.Mode mode) {
        if (i7 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i7 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i7 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i7) {
            case StdKeyDeserializer.TYPE_URL /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public Object c(String str) {
        return this.f10597m.f10653b.f10651p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f10595l;
        if (drawable == null) {
            return false;
        }
        P.a.b(drawable);
        return false;
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final void d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f10597m;
        g gVar = hVar.f10653b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f10643h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z7 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f10619b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f10651p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f10652a = cVar.f10634d | hVar.f10652a;
                    z7 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f10619b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f10651p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f10652a = bVar.f10634d | hVar.f10652a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f10619b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f10651p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f10652a = dVar2.f10628k | hVar.f10652a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z7) {
            throw new XmlPullParserException("no path defined");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f10605u);
        if (this.f10605u.width() <= 0 || this.f10605u.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f10599o;
        if (colorFilter == null) {
            colorFilter = this.f10598n;
        }
        canvas.getMatrix(this.f10604t);
        this.f10604t.getValues(this.f10603s);
        float fAbs = Math.abs(this.f10603s[0]);
        float fAbs2 = Math.abs(this.f10603s[4]);
        float fAbs3 = Math.abs(this.f10603s[1]);
        float fAbs4 = Math.abs(this.f10603s[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f10605u.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f10605u.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f10605u;
        canvas.translate(rect.left, rect.top);
        if (e()) {
            canvas.translate(this.f10605u.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f10605u.offsetTo(0, 0);
        this.f10597m.c(iMin, iMin2);
        if (!this.f10601q) {
            this.f10597m.j(iMin, iMin2);
        } else if (!this.f10597m.b()) {
            this.f10597m.j(iMin, iMin2);
            this.f10597m.i();
        }
        this.f10597m.d(canvas, colorFilter, this.f10605u);
        canvas.restoreToCount(iSave);
    }

    public final boolean e() {
        return isAutoMirrored() && P.a.f(this) == 1;
    }

    public void g(boolean z7) {
        this.f10601q = z7;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f10595l;
        return drawable != null ? P.a.d(drawable) : this.f10597m.f10653b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f10595l;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f10597m.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f10595l;
        return drawable != null ? P.a.e(drawable) : this.f10599o;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f10595l != null) {
            return new i(this.f10595l.getConstantState());
        }
        this.f10597m.f10652a = getChangingConfigurations();
        return this.f10597m;
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f10595l;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f10597m.f10653b.f10645j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f10595l;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f10597m.f10653b.f10644i;
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f10597m;
        g gVar = hVar.f10653b;
        hVar.f10655d = f(k.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = k.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            hVar.f10654c = colorStateListG;
        }
        hVar.f10656e = k.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f10656e);
        gVar.f10646k = k.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f10646k);
        float fJ = k.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f10647l);
        gVar.f10647l = fJ;
        if (gVar.f10646k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f10644i = typedArray.getDimension(3, gVar.f10644i);
        float dimension = typedArray.getDimension(2, gVar.f10645j);
        gVar.f10645j = dimension;
        if (gVar.f10644i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(k.j(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f10649n = string;
            gVar.f10651p.put(string, gVar);
        }
    }

    public PorterDuffColorFilter i(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f10595l;
        return drawable != null ? P.a.h(drawable) : this.f10597m.f10656e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        h hVar = this.f10597m;
        if (hVar == null) {
            return false;
        }
        if (hVar.g()) {
            return true;
        }
        ColorStateList colorStateList = this.f10597m.f10654c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f10600p && super.mutate() == this) {
            this.f10597m = new h(this.f10597m);
            this.f10600p = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z7;
        PorterDuff.Mode mode;
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f10597m;
        ColorStateList colorStateList = hVar.f10654c;
        if (colorStateList == null || (mode = hVar.f10655d) == null) {
            z7 = false;
        } else {
            this.f10598n = i(this.f10598n, colorStateList, mode);
            invalidateSelf();
            z7 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z7;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j7) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j7);
        } else {
            super.scheduleSelf(runnable, j7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.setAlpha(i7);
        } else if (this.f10597m.f10653b.getRootAlpha() != i7) {
            this.f10597m.f10653b.setRootAlpha(i7);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            P.a.j(drawable, z7);
        } else {
            this.f10597m.f10656e = z7;
        }
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i7) {
        super.setChangingConfigurations(i7);
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i7, PorterDuff.Mode mode) {
        super.setColorFilter(i7, mode);
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z7) {
        super.setFilterBitmap(z7);
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f7, float f8) {
        super.setHotspot(f7, f8);
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i7, int i8, int i9, int i10) {
        super.setHotspotBounds(i7, i8, i9, i10);
    }

    @Override // a2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i7) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            P.a.n(drawable, i7);
        } else {
            setTintList(ColorStateList.valueOf(i7));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            P.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f10597m;
        if (hVar.f10654c != colorStateList) {
            hVar.f10654c = colorStateList;
            this.f10598n = i(this.f10598n, colorStateList, hVar.f10655d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            P.a.p(drawable, mode);
            return;
        }
        h hVar = this.f10597m;
        if (hVar.f10655d != mode) {
            hVar.f10655d = mode;
            this.f10598n = i(this.f10598n, hVar.f10654c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        Drawable drawable = this.f10595l;
        return drawable != null ? drawable.setVisible(z7, z8) : super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f10664a;

        public i(Drawable.ConstantState constantState) {
            this.f10664a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f10664a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f10664a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f10595l = (VectorDrawable) this.f10664a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f10595l = (VectorDrawable) this.f10664a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f10595l = (VectorDrawable) this.f10664a.newDrawable(resources, theme);
            return fVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f10599o = colorFilter;
            invalidateSelf();
        }
    }

    /* renamed from: a2.f$f, reason: collision with other inner class name */
    public static abstract class AbstractC0092f extends e {

        /* renamed from: a, reason: collision with root package name */
        public d.b[] f10631a;

        /* renamed from: b, reason: collision with root package name */
        public String f10632b;

        /* renamed from: c, reason: collision with root package name */
        public int f10633c;

        /* renamed from: d, reason: collision with root package name */
        public int f10634d;

        public AbstractC0092f() {
            super();
            this.f10631a = null;
            this.f10633c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f10631a;
            if (bVarArr != null) {
                d.b.h(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f10631a;
        }

        public String getPathName() {
            return this.f10632b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (O.d.b(this.f10631a, bVarArr)) {
                O.d.j(this.f10631a, bVarArr);
            } else {
                this.f10631a = O.d.e(bVarArr);
            }
        }

        public AbstractC0092f(AbstractC0092f abstractC0092f) {
            super();
            this.f10631a = null;
            this.f10633c = 0;
            this.f10632b = abstractC0092f.f10632b;
            this.f10634d = abstractC0092f.f10634d;
            this.f10631a = O.d.e(abstractC0092f.f10631a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f10595l;
        if (drawable != null) {
            P.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f10597m;
        hVar.f10653b = new g();
        TypedArray typedArrayQ = k.q(resources, theme, attributeSet, AbstractC0756a.f10566a);
        h(typedArrayQ, xmlPullParser, theme);
        typedArrayQ.recycle();
        hVar.f10652a = getChangingConfigurations();
        hVar.f10662k = true;
        d(resources, xmlPullParser, attributeSet, theme);
        this.f10598n = i(this.f10598n, hVar.f10654c, hVar.f10655d);
    }

    public f(h hVar) {
        this.f10601q = true;
        this.f10603s = new float[9];
        this.f10604t = new Matrix();
        this.f10605u = new Rect();
        this.f10597m = hVar;
        this.f10598n = i(this.f10598n, hVar.f10654c, hVar.f10655d);
    }

    public static class c extends AbstractC0092f {

        /* renamed from: e, reason: collision with root package name */
        public int[] f10606e;

        /* renamed from: f, reason: collision with root package name */
        public N.d f10607f;

        /* renamed from: g, reason: collision with root package name */
        public float f10608g;

        /* renamed from: h, reason: collision with root package name */
        public N.d f10609h;

        /* renamed from: i, reason: collision with root package name */
        public float f10610i;

        /* renamed from: j, reason: collision with root package name */
        public float f10611j;

        /* renamed from: k, reason: collision with root package name */
        public float f10612k;

        /* renamed from: l, reason: collision with root package name */
        public float f10613l;

        /* renamed from: m, reason: collision with root package name */
        public float f10614m;

        /* renamed from: n, reason: collision with root package name */
        public Paint.Cap f10615n;

        /* renamed from: o, reason: collision with root package name */
        public Paint.Join f10616o;

        /* renamed from: p, reason: collision with root package name */
        public float f10617p;

        public c() {
            this.f10608g = 0.0f;
            this.f10610i = 1.0f;
            this.f10611j = 1.0f;
            this.f10612k = 0.0f;
            this.f10613l = 1.0f;
            this.f10614m = 0.0f;
            this.f10615n = Paint.Cap.BUTT;
            this.f10616o = Paint.Join.MITER;
            this.f10617p = 4.0f;
        }

        @Override // a2.f.e
        public boolean a() {
            return this.f10609h.i() || this.f10607f.i();
        }

        @Override // a2.f.e
        public boolean b(int[] iArr) {
            return this.f10607f.j(iArr) | this.f10609h.j(iArr);
        }

        public final Paint.Cap e(int i7, Paint.Cap cap) {
            return i7 != 0 ? i7 != 1 ? i7 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        public final Paint.Join f(int i7, Paint.Join join) {
            return i7 != 0 ? i7 != 1 ? i7 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = k.q(resources, theme, attributeSet, AbstractC0756a.f10568c);
            h(typedArrayQ, xmlPullParser, theme);
            typedArrayQ.recycle();
        }

        public float getFillAlpha() {
            return this.f10611j;
        }

        public int getFillColor() {
            return this.f10609h.e();
        }

        public float getStrokeAlpha() {
            return this.f10610i;
        }

        public int getStrokeColor() {
            return this.f10607f.e();
        }

        public float getStrokeWidth() {
            return this.f10608g;
        }

        public float getTrimPathEnd() {
            return this.f10613l;
        }

        public float getTrimPathOffset() {
            return this.f10614m;
        }

        public float getTrimPathStart() {
            return this.f10612k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f10606e = null;
            if (k.p(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f10632b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f10631a = O.d.d(string2);
                }
                this.f10609h = k.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f10611j = k.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f10611j);
                this.f10615n = e(k.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f10615n);
                this.f10616o = f(k.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f10616o);
                this.f10617p = k.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f10617p);
                this.f10607f = k.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f10610i = k.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f10610i);
                this.f10608g = k.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f10608g);
                this.f10613l = k.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f10613l);
                this.f10614m = k.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f10614m);
                this.f10612k = k.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f10612k);
                this.f10633c = k.k(typedArray, xmlPullParser, "fillType", 13, this.f10633c);
            }
        }

        public void setFillAlpha(float f7) {
            this.f10611j = f7;
        }

        public void setFillColor(int i7) {
            this.f10609h.k(i7);
        }

        public void setStrokeAlpha(float f7) {
            this.f10610i = f7;
        }

        public void setStrokeColor(int i7) {
            this.f10607f.k(i7);
        }

        public void setStrokeWidth(float f7) {
            this.f10608g = f7;
        }

        public void setTrimPathEnd(float f7) {
            this.f10613l = f7;
        }

        public void setTrimPathOffset(float f7) {
            this.f10614m = f7;
        }

        public void setTrimPathStart(float f7) {
            this.f10612k = f7;
        }

        public c(c cVar) {
            super(cVar);
            this.f10608g = 0.0f;
            this.f10610i = 1.0f;
            this.f10611j = 1.0f;
            this.f10612k = 0.0f;
            this.f10613l = 1.0f;
            this.f10614m = 0.0f;
            this.f10615n = Paint.Cap.BUTT;
            this.f10616o = Paint.Join.MITER;
            this.f10617p = 4.0f;
            this.f10606e = cVar.f10606e;
            this.f10607f = cVar.f10607f;
            this.f10608g = cVar.f10608g;
            this.f10610i = cVar.f10610i;
            this.f10609h = cVar.f10609h;
            this.f10633c = cVar.f10633c;
            this.f10611j = cVar.f10611j;
            this.f10612k = cVar.f10612k;
            this.f10613l = cVar.f10613l;
            this.f10614m = cVar.f10614m;
            this.f10615n = cVar.f10615n;
            this.f10616o = cVar.f10616o;
            this.f10617p = cVar.f10617p;
        }
    }

    public static class g {

        /* renamed from: q, reason: collision with root package name */
        public static final Matrix f10635q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f10636a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f10637b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f10638c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f10639d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f10640e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f10641f;

        /* renamed from: g, reason: collision with root package name */
        public int f10642g;

        /* renamed from: h, reason: collision with root package name */
        public final d f10643h;

        /* renamed from: i, reason: collision with root package name */
        public float f10644i;

        /* renamed from: j, reason: collision with root package name */
        public float f10645j;

        /* renamed from: k, reason: collision with root package name */
        public float f10646k;

        /* renamed from: l, reason: collision with root package name */
        public float f10647l;

        /* renamed from: m, reason: collision with root package name */
        public int f10648m;

        /* renamed from: n, reason: collision with root package name */
        public String f10649n;

        /* renamed from: o, reason: collision with root package name */
        public Boolean f10650o;

        /* renamed from: p, reason: collision with root package name */
        public final C1787a f10651p;

        public g() {
            this.f10638c = new Matrix();
            this.f10644i = 0.0f;
            this.f10645j = 0.0f;
            this.f10646k = 0.0f;
            this.f10647l = 0.0f;
            this.f10648m = 255;
            this.f10649n = null;
            this.f10650o = null;
            this.f10651p = new C1787a();
            this.f10643h = new d();
            this.f10636a = new Path();
            this.f10637b = new Path();
        }

        public static float a(float f7, float f8, float f9, float f10) {
            return (f7 * f10) - (f8 * f9);
        }

        public void b(Canvas canvas, int i7, int i8, ColorFilter colorFilter) {
            c(this.f10643h, f10635q, canvas, i7, i8, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i7, int i8, ColorFilter colorFilter) {
            d dVar2 = dVar;
            dVar2.f10618a.set(matrix);
            dVar2.f10618a.preConcat(dVar2.f10627j);
            canvas.save();
            int i9 = 0;
            while (i9 < dVar2.f10619b.size()) {
                e eVar = (e) dVar2.f10619b.get(i9);
                if (eVar instanceof d) {
                    c((d) eVar, dVar2.f10618a, canvas, i7, i8, colorFilter);
                } else if (eVar instanceof AbstractC0092f) {
                    d(dVar2, (AbstractC0092f) eVar, canvas, i7, i8, colorFilter);
                }
                i9++;
                dVar2 = dVar;
            }
            canvas.restore();
        }

        public final void d(d dVar, AbstractC0092f abstractC0092f, Canvas canvas, int i7, int i8, ColorFilter colorFilter) {
            float f7 = i7 / this.f10646k;
            float f8 = i8 / this.f10647l;
            float fMin = Math.min(f7, f8);
            Matrix matrix = dVar.f10618a;
            this.f10638c.set(matrix);
            this.f10638c.postScale(f7, f8);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            abstractC0092f.d(this.f10636a);
            Path path = this.f10636a;
            this.f10637b.reset();
            if (abstractC0092f.c()) {
                this.f10637b.setFillType(abstractC0092f.f10633c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f10637b.addPath(path, this.f10638c);
                canvas.clipPath(this.f10637b);
                return;
            }
            c cVar = (c) abstractC0092f;
            float f9 = cVar.f10612k;
            if (f9 != 0.0f || cVar.f10613l != 1.0f) {
                float f10 = cVar.f10614m;
                float f11 = (f9 + f10) % 1.0f;
                float f12 = (cVar.f10613l + f10) % 1.0f;
                if (this.f10641f == null) {
                    this.f10641f = new PathMeasure();
                }
                this.f10641f.setPath(this.f10636a, false);
                float length = this.f10641f.getLength();
                float f13 = f11 * length;
                float f14 = f12 * length;
                path.reset();
                if (f13 > f14) {
                    this.f10641f.getSegment(f13, length, path, true);
                    this.f10641f.getSegment(0.0f, f14, path, true);
                } else {
                    this.f10641f.getSegment(f13, f14, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f10637b.addPath(path, this.f10638c);
            if (cVar.f10609h.l()) {
                N.d dVar2 = cVar.f10609h;
                if (this.f10640e == null) {
                    Paint paint = new Paint(1);
                    this.f10640e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f10640e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f10638c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f10611j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(f.a(dVar2.e(), cVar.f10611j));
                }
                paint2.setColorFilter(colorFilter);
                this.f10637b.setFillType(cVar.f10633c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f10637b, paint2);
            }
            if (cVar.f10607f.l()) {
                N.d dVar3 = cVar.f10607f;
                if (this.f10639d == null) {
                    Paint paint3 = new Paint(1);
                    this.f10639d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f10639d;
                Paint.Join join = cVar.f10616o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f10615n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f10617p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f10638c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f10610i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(f.a(dVar3.e(), cVar.f10610i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f10608g * fMin * fE);
                canvas.drawPath(this.f10637b, paint4);
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f10650o == null) {
                this.f10650o = Boolean.valueOf(this.f10643h.a());
            }
            return this.f10650o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f10643h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f10648m;
        }

        public void setAlpha(float f7) {
            setRootAlpha((int) (f7 * 255.0f));
        }

        public void setRootAlpha(int i7) {
            this.f10648m = i7;
        }

        public g(g gVar) {
            this.f10638c = new Matrix();
            this.f10644i = 0.0f;
            this.f10645j = 0.0f;
            this.f10646k = 0.0f;
            this.f10647l = 0.0f;
            this.f10648m = 255;
            this.f10649n = null;
            this.f10650o = null;
            C1787a c1787a = new C1787a();
            this.f10651p = c1787a;
            this.f10643h = new d(gVar.f10643h, c1787a);
            this.f10636a = new Path(gVar.f10636a);
            this.f10637b = new Path(gVar.f10637b);
            this.f10644i = gVar.f10644i;
            this.f10645j = gVar.f10645j;
            this.f10646k = gVar.f10646k;
            this.f10647l = gVar.f10647l;
            this.f10642g = gVar.f10642g;
            this.f10648m = gVar.f10648m;
            this.f10649n = gVar.f10649n;
            String str = gVar.f10649n;
            if (str != null) {
                c1787a.put(str, this);
            }
            this.f10650o = gVar.f10650o;
        }
    }

    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f10618a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f10619b;

        /* renamed from: c, reason: collision with root package name */
        public float f10620c;

        /* renamed from: d, reason: collision with root package name */
        public float f10621d;

        /* renamed from: e, reason: collision with root package name */
        public float f10622e;

        /* renamed from: f, reason: collision with root package name */
        public float f10623f;

        /* renamed from: g, reason: collision with root package name */
        public float f10624g;

        /* renamed from: h, reason: collision with root package name */
        public float f10625h;

        /* renamed from: i, reason: collision with root package name */
        public float f10626i;

        /* renamed from: j, reason: collision with root package name */
        public final Matrix f10627j;

        /* renamed from: k, reason: collision with root package name */
        public int f10628k;

        /* renamed from: l, reason: collision with root package name */
        public int[] f10629l;

        /* renamed from: m, reason: collision with root package name */
        public String f10630m;

        public d(d dVar, C1787a c1787a) {
            AbstractC0092f bVar;
            super();
            this.f10618a = new Matrix();
            this.f10619b = new ArrayList();
            this.f10620c = 0.0f;
            this.f10621d = 0.0f;
            this.f10622e = 0.0f;
            this.f10623f = 1.0f;
            this.f10624g = 1.0f;
            this.f10625h = 0.0f;
            this.f10626i = 0.0f;
            Matrix matrix = new Matrix();
            this.f10627j = matrix;
            this.f10630m = null;
            this.f10620c = dVar.f10620c;
            this.f10621d = dVar.f10621d;
            this.f10622e = dVar.f10622e;
            this.f10623f = dVar.f10623f;
            this.f10624g = dVar.f10624g;
            this.f10625h = dVar.f10625h;
            this.f10626i = dVar.f10626i;
            this.f10629l = dVar.f10629l;
            String str = dVar.f10630m;
            this.f10630m = str;
            this.f10628k = dVar.f10628k;
            if (str != null) {
                c1787a.put(str, this);
            }
            matrix.set(dVar.f10627j);
            ArrayList arrayList = dVar.f10619b;
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                Object obj = arrayList.get(i7);
                if (obj instanceof d) {
                    this.f10619b.add(new d((d) obj, c1787a));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else {
                        if (!(obj instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) obj);
                    }
                    this.f10619b.add(bVar);
                    Object obj2 = bVar.f10632b;
                    if (obj2 != null) {
                        c1787a.put(obj2, bVar);
                    }
                }
            }
        }

        @Override // a2.f.e
        public boolean a() {
            for (int i7 = 0; i7 < this.f10619b.size(); i7++) {
                if (((e) this.f10619b.get(i7)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // a2.f.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i7 = 0; i7 < this.f10619b.size(); i7++) {
                zB |= ((e) this.f10619b.get(i7)).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = k.q(resources, theme, attributeSet, AbstractC0756a.f10567b);
            e(typedArrayQ, xmlPullParser);
            typedArrayQ.recycle();
        }

        public final void d() {
            this.f10627j.reset();
            this.f10627j.postTranslate(-this.f10621d, -this.f10622e);
            this.f10627j.postScale(this.f10623f, this.f10624g);
            this.f10627j.postRotate(this.f10620c, 0.0f, 0.0f);
            this.f10627j.postTranslate(this.f10625h + this.f10621d, this.f10626i + this.f10622e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f10629l = null;
            this.f10620c = k.j(typedArray, xmlPullParser, "rotation", 5, this.f10620c);
            this.f10621d = typedArray.getFloat(1, this.f10621d);
            this.f10622e = typedArray.getFloat(2, this.f10622e);
            this.f10623f = k.j(typedArray, xmlPullParser, "scaleX", 3, this.f10623f);
            this.f10624g = k.j(typedArray, xmlPullParser, "scaleY", 4, this.f10624g);
            this.f10625h = k.j(typedArray, xmlPullParser, "translateX", 6, this.f10625h);
            this.f10626i = k.j(typedArray, xmlPullParser, "translateY", 7, this.f10626i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f10630m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f10630m;
        }

        public Matrix getLocalMatrix() {
            return this.f10627j;
        }

        public float getPivotX() {
            return this.f10621d;
        }

        public float getPivotY() {
            return this.f10622e;
        }

        public float getRotation() {
            return this.f10620c;
        }

        public float getScaleX() {
            return this.f10623f;
        }

        public float getScaleY() {
            return this.f10624g;
        }

        public float getTranslateX() {
            return this.f10625h;
        }

        public float getTranslateY() {
            return this.f10626i;
        }

        public void setPivotX(float f7) {
            if (f7 != this.f10621d) {
                this.f10621d = f7;
                d();
            }
        }

        public void setPivotY(float f7) {
            if (f7 != this.f10622e) {
                this.f10622e = f7;
                d();
            }
        }

        public void setRotation(float f7) {
            if (f7 != this.f10620c) {
                this.f10620c = f7;
                d();
            }
        }

        public void setScaleX(float f7) {
            if (f7 != this.f10623f) {
                this.f10623f = f7;
                d();
            }
        }

        public void setScaleY(float f7) {
            if (f7 != this.f10624g) {
                this.f10624g = f7;
                d();
            }
        }

        public void setTranslateX(float f7) {
            if (f7 != this.f10625h) {
                this.f10625h = f7;
                d();
            }
        }

        public void setTranslateY(float f7) {
            if (f7 != this.f10626i) {
                this.f10626i = f7;
                d();
            }
        }

        public d() {
            super();
            this.f10618a = new Matrix();
            this.f10619b = new ArrayList();
            this.f10620c = 0.0f;
            this.f10621d = 0.0f;
            this.f10622e = 0.0f;
            this.f10623f = 1.0f;
            this.f10624g = 1.0f;
            this.f10625h = 0.0f;
            this.f10626i = 0.0f;
            this.f10627j = new Matrix();
            this.f10630m = null;
        }
    }
}
