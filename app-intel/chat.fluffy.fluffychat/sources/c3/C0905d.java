package c3;

import N.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;

/* renamed from: c3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0905d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f13966a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f13967b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f13968c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13969d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13970e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13971f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f13972g;

    /* renamed from: h, reason: collision with root package name */
    public final float f13973h;

    /* renamed from: i, reason: collision with root package name */
    public final float f13974i;

    /* renamed from: j, reason: collision with root package name */
    public final float f13975j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f13976k;

    /* renamed from: l, reason: collision with root package name */
    public final float f13977l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f13978m;

    /* renamed from: n, reason: collision with root package name */
    public float f13979n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13980o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13981p = false;

    /* renamed from: q, reason: collision with root package name */
    public Typeface f13982q;

    /* renamed from: c3.d$a */
    public class a extends h.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f13983a;

        public a(f fVar) {
            this.f13983a = fVar;
        }

        @Override // N.h.c
        public void f(int i7) {
            C0905d.this.f13981p = true;
            this.f13983a.a(i7);
        }

        @Override // N.h.c
        public void g(Typeface typeface) {
            C0905d c0905d = C0905d.this;
            c0905d.f13982q = Typeface.create(typeface, c0905d.f13970e);
            C0905d.this.f13981p = true;
            this.f13983a.b(C0905d.this.f13982q, false);
        }
    }

    /* renamed from: c3.d$b */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13985a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f13986b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f13987c;

        public b(Context context, TextPaint textPaint, f fVar) {
            this.f13985a = context;
            this.f13986b = textPaint;
            this.f13987c = fVar;
        }

        @Override // c3.f
        public void a(int i7) {
            this.f13987c.a(i7);
        }

        @Override // c3.f
        public void b(Typeface typeface, boolean z7) {
            C0905d.this.p(this.f13985a, this.f13986b, typeface);
            this.f13987c.b(typeface, z7);
        }
    }

    public C0905d(Context context, int i7) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i7, O2.j.f6933C4);
        l(typedArrayObtainStyledAttributes.getDimension(O2.j.f6940D4, 0.0f));
        k(AbstractC0904c.a(context, typedArrayObtainStyledAttributes, O2.j.f6961G4));
        this.f13966a = AbstractC0904c.a(context, typedArrayObtainStyledAttributes, O2.j.f6968H4);
        this.f13967b = AbstractC0904c.a(context, typedArrayObtainStyledAttributes, O2.j.f6975I4);
        this.f13970e = typedArrayObtainStyledAttributes.getInt(O2.j.f6954F4, 0);
        this.f13971f = typedArrayObtainStyledAttributes.getInt(O2.j.f6947E4, 1);
        int iE = AbstractC0904c.e(typedArrayObtainStyledAttributes, O2.j.f7017O4, O2.j.f7010N4);
        this.f13980o = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f13969d = typedArrayObtainStyledAttributes.getString(iE);
        this.f13972g = typedArrayObtainStyledAttributes.getBoolean(O2.j.f7024P4, false);
        this.f13968c = AbstractC0904c.a(context, typedArrayObtainStyledAttributes, O2.j.f6982J4);
        this.f13973h = typedArrayObtainStyledAttributes.getFloat(O2.j.f6989K4, 0.0f);
        this.f13974i = typedArrayObtainStyledAttributes.getFloat(O2.j.f6996L4, 0.0f);
        this.f13975j = typedArrayObtainStyledAttributes.getFloat(O2.j.f7003M4, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i7, O2.j.f7172j3);
        this.f13976k = typedArrayObtainStyledAttributes2.hasValue(O2.j.f7180k3);
        this.f13977l = typedArrayObtainStyledAttributes2.getFloat(O2.j.f7180k3, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void d() {
        String str;
        if (this.f13982q == null && (str = this.f13969d) != null) {
            this.f13982q = Typeface.create(str, this.f13970e);
        }
        if (this.f13982q == null) {
            int i7 = this.f13971f;
            if (i7 == 1) {
                this.f13982q = Typeface.SANS_SERIF;
            } else if (i7 == 2) {
                this.f13982q = Typeface.SERIF;
            } else if (i7 != 3) {
                this.f13982q = Typeface.DEFAULT;
            } else {
                this.f13982q = Typeface.MONOSPACE;
            }
            this.f13982q = Typeface.create(this.f13982q, this.f13970e);
        }
    }

    public Typeface e() {
        d();
        return this.f13982q;
    }

    public Typeface f(Context context) {
        if (this.f13981p) {
            return this.f13982q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = N.h.g(context, this.f13980o);
                this.f13982q = typefaceG;
                if (typefaceG != null) {
                    this.f13982q = Typeface.create(typefaceG, this.f13970e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e7) {
                Log.d("TextAppearance", "Error loading font " + this.f13969d, e7);
            }
        }
        d();
        this.f13981p = true;
        return this.f13982q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i7 = this.f13980o;
        if (i7 == 0) {
            this.f13981p = true;
        }
        if (this.f13981p) {
            fVar.b(this.f13982q, true);
            return;
        }
        try {
            N.h.i(context, i7, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f13981p = true;
            fVar.a(1);
        } catch (Exception e7) {
            Log.d("TextAppearance", "Error loading font " + this.f13969d, e7);
            this.f13981p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f13978m;
    }

    public float j() {
        return this.f13979n;
    }

    public void k(ColorStateList colorStateList) {
        this.f13978m = colorStateList;
    }

    public void l(float f7) {
        this.f13979n = f7;
    }

    public final boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i7 = this.f13980o;
        return (i7 != 0 ? N.h.c(context, i7) : null) != null;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f13978m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f7 = this.f13975j;
        float f8 = this.f13973h;
        float f9 = this.f13974i;
        ColorStateList colorStateList2 = this.f13968c;
        textPaint.setShadowLayer(f7, f8, f9, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = j.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i7 = this.f13970e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i7 & 1) != 0);
        textPaint.setTextSkewX((i7 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f13979n);
        if (this.f13976k) {
            textPaint.setLetterSpacing(this.f13977l);
        }
    }
}
