package q;

import N.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import b0.C0819c;
import c0.AbstractC0896h;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes.dex */
public class B {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f21038a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f21039b;

    /* renamed from: c, reason: collision with root package name */
    public b0 f21040c;

    /* renamed from: d, reason: collision with root package name */
    public b0 f21041d;

    /* renamed from: e, reason: collision with root package name */
    public b0 f21042e;

    /* renamed from: f, reason: collision with root package name */
    public b0 f21043f;

    /* renamed from: g, reason: collision with root package name */
    public b0 f21044g;

    /* renamed from: h, reason: collision with root package name */
    public b0 f21045h;

    /* renamed from: i, reason: collision with root package name */
    public final D f21046i;

    /* renamed from: j, reason: collision with root package name */
    public int f21047j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f21048k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f21049l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21050m;

    public class b implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ TextView f21055l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Typeface f21056m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f21057n;

        public b(TextView textView, Typeface typeface, int i7) {
            this.f21055l = textView;
            this.f21056m = typeface;
            this.f21057n = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21055l.setTypeface(this.f21056m, this.f21057n);
        }
    }

    public static class c {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    public static class d {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    public static class e {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i7, int i8, int i9, int i10) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }

        public static void c(TextView textView, int[] iArr, int i7) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    public static class f {
        public static Typeface a(Typeface typeface, int i7, boolean z7) {
            return Typeface.create(typeface, i7, z7);
        }
    }

    public B(TextView textView) {
        this.f21038a = textView;
        this.f21046i = new D(textView);
    }

    public static b0 d(Context context, C1473j c1473j, int i7) {
        ColorStateList colorStateListF = c1473j.f(context, i7);
        if (colorStateListF == null) {
            return null;
        }
        b0 b0Var = new b0();
        b0Var.f21239d = true;
        b0Var.f21236a = colorStateListF;
        return b0Var;
    }

    public void A(int i7, float f7) {
        if (n0.f21324b || l()) {
            return;
        }
        B(i7, f7);
    }

    public final void B(int i7, float f7) {
        this.f21046i.t(i7, f7);
    }

    public final void C(Context context, d0 d0Var) {
        String strO;
        this.f21047j = d0Var.k(i.j.f17208V2, this.f21047j);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            int iK = d0Var.k(i.j.f17220Y2, -1);
            this.f21048k = iK;
            if (iK != -1) {
                this.f21047j &= 2;
            }
        }
        if (!d0Var.s(i.j.f17216X2) && !d0Var.s(i.j.f17224Z2)) {
            if (d0Var.s(i.j.f17204U2)) {
                this.f21050m = false;
                int iK2 = d0Var.k(i.j.f17204U2, 1);
                if (iK2 == 1) {
                    this.f21049l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f21049l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f21049l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f21049l = null;
        int i8 = d0Var.s(i.j.f17224Z2) ? i.j.f17224Z2 : i.j.f17216X2;
        int i9 = this.f21048k;
        int i10 = this.f21047j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = d0Var.j(i8, this.f21047j, new a(i9, i10, new WeakReference(this.f21038a)));
                if (typefaceJ != null) {
                    if (i7 < 28 || this.f21048k == -1) {
                        this.f21049l = typefaceJ;
                    } else {
                        this.f21049l = f.a(Typeface.create(typefaceJ, 0), this.f21048k, (this.f21047j & 2) != 0);
                    }
                }
                this.f21050m = this.f21049l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f21049l != null || (strO = d0Var.o(i8)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f21048k == -1) {
            this.f21049l = Typeface.create(strO, this.f21047j);
        } else {
            this.f21049l = f.a(Typeface.create(strO, 0), this.f21048k, (this.f21047j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, b0 b0Var) {
        if (drawable == null || b0Var == null) {
            return;
        }
        C1473j.i(drawable, b0Var, this.f21038a.getDrawableState());
    }

    public void b() {
        if (this.f21039b != null || this.f21040c != null || this.f21041d != null || this.f21042e != null) {
            Drawable[] compoundDrawables = this.f21038a.getCompoundDrawables();
            a(compoundDrawables[0], this.f21039b);
            a(compoundDrawables[1], this.f21040c);
            a(compoundDrawables[2], this.f21041d);
            a(compoundDrawables[3], this.f21042e);
        }
        if (this.f21043f == null && this.f21044g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.f21038a);
        a(drawableArrA[0], this.f21043f);
        a(drawableArrA[2], this.f21044g);
    }

    public void c() {
        this.f21046i.a();
    }

    public int e() {
        return this.f21046i.f();
    }

    public int f() {
        return this.f21046i.g();
    }

    public int g() {
        return this.f21046i.h();
    }

    public int[] h() {
        return this.f21046i.i();
    }

    public int i() {
        return this.f21046i.j();
    }

    public ColorStateList j() {
        b0 b0Var = this.f21045h;
        if (b0Var != null) {
            return b0Var.f21236a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        b0 b0Var = this.f21045h;
        if (b0Var != null) {
            return b0Var.f21237b;
        }
        return null;
    }

    public boolean l() {
        return this.f21046i.n();
    }

    public void m(AttributeSet attributeSet, int i7) {
        boolean zA;
        boolean z7;
        String strO;
        String strO2;
        Context context = this.f21038a.getContext();
        C1473j c1473jB = C1473j.b();
        d0 d0VarV = d0.v(context, attributeSet, i.j.f17217Y, i7, 0);
        TextView textView = this.f21038a;
        Z.W.j0(textView, textView.getContext(), i.j.f17217Y, attributeSet, d0VarV.r(), i7, 0);
        int iN = d0VarV.n(i.j.f17221Z, -1);
        if (d0VarV.s(i.j.f17236c0)) {
            this.f21039b = d(context, c1473jB, d0VarV.n(i.j.f17236c0, 0));
        }
        if (d0VarV.s(i.j.f17226a0)) {
            this.f21040c = d(context, c1473jB, d0VarV.n(i.j.f17226a0, 0));
        }
        if (d0VarV.s(i.j.f17241d0)) {
            this.f21041d = d(context, c1473jB, d0VarV.n(i.j.f17241d0, 0));
        }
        if (d0VarV.s(i.j.f17231b0)) {
            this.f21042e = d(context, c1473jB, d0VarV.n(i.j.f17231b0, 0));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (d0VarV.s(i.j.f17246e0)) {
            this.f21043f = d(context, c1473jB, d0VarV.n(i.j.f17246e0, 0));
        }
        if (d0VarV.s(i.j.f17251f0)) {
            this.f21044g = d(context, c1473jB, d0VarV.n(i.j.f17251f0, 0));
        }
        d0VarV.w();
        boolean z8 = this.f21038a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            d0 d0VarT = d0.t(context, iN, i.j.f17196S2);
            if (z8 || !d0VarT.s(i.j.f17234b3)) {
                zA = false;
                z7 = false;
            } else {
                zA = d0VarT.a(i.j.f17234b3, false);
                z7 = true;
            }
            C(context, d0VarT);
            strO2 = d0VarT.s(i.j.f17239c3) ? d0VarT.o(i.j.f17239c3) : null;
            strO = (i8 < 26 || !d0VarT.s(i.j.f17229a3)) ? null : d0VarT.o(i.j.f17229a3);
            d0VarT.w();
        } else {
            zA = false;
            z7 = false;
            strO = null;
            strO2 = null;
        }
        d0 d0VarV2 = d0.v(context, attributeSet, i.j.f17196S2, i7, 0);
        if (!z8 && d0VarV2.s(i.j.f17234b3)) {
            zA = d0VarV2.a(i.j.f17234b3, false);
            z7 = true;
        }
        if (d0VarV2.s(i.j.f17239c3)) {
            strO2 = d0VarV2.o(i.j.f17239c3);
        }
        if (i8 >= 26 && d0VarV2.s(i.j.f17229a3)) {
            strO = d0VarV2.o(i.j.f17229a3);
        }
        if (i8 >= 28 && d0VarV2.s(i.j.f17200T2) && d0VarV2.f(i.j.f17200T2, -1) == 0) {
            this.f21038a.setTextSize(0, 0.0f);
        }
        C(context, d0VarV2);
        d0VarV2.w();
        if (!z8 && z7) {
            s(zA);
        }
        Typeface typeface = this.f21049l;
        if (typeface != null) {
            if (this.f21048k == -1) {
                this.f21038a.setTypeface(typeface, this.f21047j);
            } else {
                this.f21038a.setTypeface(typeface);
            }
        }
        if (strO != null) {
            e.d(this.f21038a, strO);
        }
        if (strO2 != null) {
            d.b(this.f21038a, d.a(strO2));
        }
        this.f21046i.o(attributeSet, i7);
        if (n0.f21324b && this.f21046i.j() != 0) {
            int[] iArrI = this.f21046i.i();
            if (iArrI.length > 0) {
                if (e.a(this.f21038a) != -1.0f) {
                    e.b(this.f21038a, this.f21046i.g(), this.f21046i.f(), this.f21046i.h(), 0);
                } else {
                    e.c(this.f21038a, iArrI, 0);
                }
            }
        }
        d0 d0VarU = d0.u(context, attributeSet, i.j.f17256g0);
        int iN2 = d0VarU.n(i.j.f17296o0, -1);
        Drawable drawableC = iN2 != -1 ? c1473jB.c(context, iN2) : null;
        int iN3 = d0VarU.n(i.j.f17321t0, -1);
        Drawable drawableC2 = iN3 != -1 ? c1473jB.c(context, iN3) : null;
        int iN4 = d0VarU.n(i.j.f17301p0, -1);
        Drawable drawableC3 = iN4 != -1 ? c1473jB.c(context, iN4) : null;
        int iN5 = d0VarU.n(i.j.f17286m0, -1);
        Drawable drawableC4 = iN5 != -1 ? c1473jB.c(context, iN5) : null;
        int iN6 = d0VarU.n(i.j.f17306q0, -1);
        Drawable drawableC5 = iN6 != -1 ? c1473jB.c(context, iN6) : null;
        int iN7 = d0VarU.n(i.j.f17291n0, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? c1473jB.c(context, iN7) : null);
        if (d0VarU.s(i.j.f17311r0)) {
            AbstractC0896h.g(this.f21038a, d0VarU.c(i.j.f17311r0));
        }
        if (d0VarU.s(i.j.f17316s0)) {
            AbstractC0896h.h(this.f21038a, N.e(d0VarU.k(i.j.f17316s0, -1), null));
        }
        int iF = d0VarU.f(i.j.f17331v0, -1);
        int iF2 = d0VarU.f(i.j.f17336w0, -1);
        int iF3 = d0VarU.f(i.j.f17341x0, -1);
        d0VarU.w();
        if (iF != -1) {
            AbstractC0896h.j(this.f21038a, iF);
        }
        if (iF2 != -1) {
            AbstractC0896h.k(this.f21038a, iF2);
        }
        if (iF3 != -1) {
            AbstractC0896h.l(this.f21038a, iF3);
        }
    }

    public void n(WeakReference weakReference, Typeface typeface) {
        if (this.f21050m) {
            this.f21049l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (Z.W.P(textView)) {
                    textView.post(new b(textView, typeface, this.f21047j));
                } else {
                    textView.setTypeface(typeface, this.f21047j);
                }
            }
        }
    }

    public void o(boolean z7, int i7, int i8, int i9, int i10) {
        if (n0.f21324b) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i7) {
        String strO;
        d0 d0VarT = d0.t(context, i7, i.j.f17196S2);
        if (d0VarT.s(i.j.f17234b3)) {
            s(d0VarT.a(i.j.f17234b3, false));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (d0VarT.s(i.j.f17200T2) && d0VarT.f(i.j.f17200T2, -1) == 0) {
            this.f21038a.setTextSize(0, 0.0f);
        }
        C(context, d0VarT);
        if (i8 >= 26 && d0VarT.s(i.j.f17229a3) && (strO = d0VarT.o(i.j.f17229a3)) != null) {
            e.d(this.f21038a, strO);
        }
        d0VarT.w();
        Typeface typeface = this.f21049l;
        if (typeface != null) {
            this.f21038a.setTypeface(typeface, this.f21047j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        C0819c.f(editorInfo, textView.getText());
    }

    public void s(boolean z7) {
        this.f21038a.setAllCaps(z7);
    }

    public void t(int i7, int i8, int i9, int i10) {
        this.f21046i.p(i7, i8, i9, i10);
    }

    public void u(int[] iArr, int i7) {
        this.f21046i.q(iArr, i7);
    }

    public void v(int i7) {
        this.f21046i.r(i7);
    }

    public void w(ColorStateList colorStateList) {
        if (this.f21045h == null) {
            this.f21045h = new b0();
        }
        b0 b0Var = this.f21045h;
        b0Var.f21236a = colorStateList;
        b0Var.f21239d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.f21045h == null) {
            this.f21045h = new b0();
        }
        b0 b0Var = this.f21045h;
        b0Var.f21237b = mode;
        b0Var.f21238c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.f21038a);
            TextView textView = this.f21038a;
            if (drawable5 == null) {
                drawable5 = drawableArrA[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrA[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrA[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrA[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrA2 = c.a(this.f21038a);
        Drawable drawable7 = drawableArrA2[0];
        if (drawable7 != null || drawableArrA2[2] != null) {
            TextView textView2 = this.f21038a;
            if (drawable2 == null) {
                drawable2 = drawableArrA2[1];
            }
            Drawable drawable8 = drawableArrA2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrA2[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f21038a.getCompoundDrawables();
        TextView textView3 = this.f21038a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void z() {
        b0 b0Var = this.f21045h;
        this.f21039b = b0Var;
        this.f21040c = b0Var;
        this.f21041d = b0Var;
        this.f21042e = b0Var;
        this.f21043f = b0Var;
        this.f21044g = b0Var;
    }

    public class a extends h.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21051a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21052b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f21053c;

        public a(int i7, int i8, WeakReference weakReference) {
            this.f21051a = i7;
            this.f21052b = i8;
            this.f21053c = weakReference;
        }

        @Override // N.h.c
        public void g(Typeface typeface) {
            int i7;
            if (Build.VERSION.SDK_INT >= 28 && (i7 = this.f21051a) != -1) {
                typeface = f.a(typeface, i7, (this.f21052b & 2) != 0);
            }
            B.this.n(this.f21053c, typeface);
        }

        @Override // N.h.c
        public void f(int i7) {
        }
    }
}
