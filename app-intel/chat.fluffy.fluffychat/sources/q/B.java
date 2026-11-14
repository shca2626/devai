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
import b0.C0820c;
import c0.AbstractC0897h;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class B {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f21044a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f21045b;

    /* renamed from: c, reason: collision with root package name */
    public b0 f21046c;

    /* renamed from: d, reason: collision with root package name */
    public b0 f21047d;

    /* renamed from: e, reason: collision with root package name */
    public b0 f21048e;

    /* renamed from: f, reason: collision with root package name */
    public b0 f21049f;

    /* renamed from: g, reason: collision with root package name */
    public b0 f21050g;

    /* renamed from: h, reason: collision with root package name */
    public b0 f21051h;

    /* renamed from: i, reason: collision with root package name */
    public final D f21052i;

    /* renamed from: j, reason: collision with root package name */
    public int f21053j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f21054k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f21055l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21056m;

    public class b implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ TextView f21061l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Typeface f21062m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f21063n;

        public b(TextView textView, Typeface typeface, int i7) {
            this.f21061l = textView;
            this.f21062m = typeface;
            this.f21063n = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21061l.setTypeface(this.f21062m, this.f21063n);
        }
    }

    public static class c {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
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
        this.f21044a = textView;
        this.f21052i = new D(textView);
    }

    public static b0 d(Context context, C1472j c1472j, int i7) {
        ColorStateList colorStateListF = c1472j.f(context, i7);
        if (colorStateListF == null) {
            return null;
        }
        b0 b0Var = new b0();
        b0Var.f21245d = true;
        b0Var.f21242a = colorStateListF;
        return b0Var;
    }

    public void A(int i7, float f7) {
        if (n0.f21330b || l()) {
            return;
        }
        B(i7, f7);
    }

    public final void B(int i7, float f7) {
        this.f21052i.t(i7, f7);
    }

    public final void C(Context context, d0 d0Var) {
        String strO;
        this.f21053j = d0Var.k(i.j.f17208V2, this.f21053j);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            int iK = d0Var.k(i.j.f17220Y2, -1);
            this.f21054k = iK;
            if (iK != -1) {
                this.f21053j &= 2;
            }
        }
        if (!d0Var.s(i.j.f17216X2) && !d0Var.s(i.j.f17224Z2)) {
            if (d0Var.s(i.j.f17204U2)) {
                this.f21056m = false;
                int iK2 = d0Var.k(i.j.f17204U2, 1);
                if (iK2 == 1) {
                    this.f21055l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f21055l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f21055l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f21055l = null;
        int i8 = d0Var.s(i.j.f17224Z2) ? i.j.f17224Z2 : i.j.f17216X2;
        int i9 = this.f21054k;
        int i10 = this.f21053j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = d0Var.j(i8, this.f21053j, new a(i9, i10, new WeakReference(this.f21044a)));
                if (typefaceJ != null) {
                    if (i7 < 28 || this.f21054k == -1) {
                        this.f21055l = typefaceJ;
                    } else {
                        this.f21055l = f.a(Typeface.create(typefaceJ, 0), this.f21054k, (this.f21053j & 2) != 0);
                    }
                }
                this.f21056m = this.f21055l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f21055l != null || (strO = d0Var.o(i8)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f21054k == -1) {
            this.f21055l = Typeface.create(strO, this.f21053j);
        } else {
            this.f21055l = f.a(Typeface.create(strO, 0), this.f21054k, (this.f21053j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, b0 b0Var) {
        if (drawable == null || b0Var == null) {
            return;
        }
        C1472j.i(drawable, b0Var, this.f21044a.getDrawableState());
    }

    public void b() {
        if (this.f21045b != null || this.f21046c != null || this.f21047d != null || this.f21048e != null) {
            Drawable[] compoundDrawables = this.f21044a.getCompoundDrawables();
            a(compoundDrawables[0], this.f21045b);
            a(compoundDrawables[1], this.f21046c);
            a(compoundDrawables[2], this.f21047d);
            a(compoundDrawables[3], this.f21048e);
        }
        if (this.f21049f == null && this.f21050g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.f21044a);
        a(drawableArrA[0], this.f21049f);
        a(drawableArrA[2], this.f21050g);
    }

    public void c() {
        this.f21052i.a();
    }

    public int e() {
        return this.f21052i.f();
    }

    public int f() {
        return this.f21052i.g();
    }

    public int g() {
        return this.f21052i.h();
    }

    public int[] h() {
        return this.f21052i.i();
    }

    public int i() {
        return this.f21052i.j();
    }

    public ColorStateList j() {
        b0 b0Var = this.f21051h;
        if (b0Var != null) {
            return b0Var.f21242a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        b0 b0Var = this.f21051h;
        if (b0Var != null) {
            return b0Var.f21243b;
        }
        return null;
    }

    public boolean l() {
        return this.f21052i.n();
    }

    public void m(AttributeSet attributeSet, int i7) {
        boolean zA;
        boolean z7;
        String strO;
        String strO2;
        Context context = this.f21044a.getContext();
        C1472j c1472jB = C1472j.b();
        d0 d0VarV = d0.v(context, attributeSet, i.j.f17217Y, i7, 0);
        TextView textView = this.f21044a;
        Z.W.j0(textView, textView.getContext(), i.j.f17217Y, attributeSet, d0VarV.r(), i7, 0);
        int iN = d0VarV.n(i.j.f17221Z, -1);
        if (d0VarV.s(i.j.f17236c0)) {
            this.f21045b = d(context, c1472jB, d0VarV.n(i.j.f17236c0, 0));
        }
        if (d0VarV.s(i.j.f17226a0)) {
            this.f21046c = d(context, c1472jB, d0VarV.n(i.j.f17226a0, 0));
        }
        if (d0VarV.s(i.j.f17241d0)) {
            this.f21047d = d(context, c1472jB, d0VarV.n(i.j.f17241d0, 0));
        }
        if (d0VarV.s(i.j.f17231b0)) {
            this.f21048e = d(context, c1472jB, d0VarV.n(i.j.f17231b0, 0));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (d0VarV.s(i.j.f17246e0)) {
            this.f21049f = d(context, c1472jB, d0VarV.n(i.j.f17246e0, 0));
        }
        if (d0VarV.s(i.j.f17251f0)) {
            this.f21050g = d(context, c1472jB, d0VarV.n(i.j.f17251f0, 0));
        }
        d0VarV.w();
        boolean z8 = this.f21044a.getTransformationMethod() instanceof PasswordTransformationMethod;
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
            this.f21044a.setTextSize(0, 0.0f);
        }
        C(context, d0VarV2);
        d0VarV2.w();
        if (!z8 && z7) {
            s(zA);
        }
        Typeface typeface = this.f21055l;
        if (typeface != null) {
            if (this.f21054k == -1) {
                this.f21044a.setTypeface(typeface, this.f21053j);
            } else {
                this.f21044a.setTypeface(typeface);
            }
        }
        if (strO != null) {
            e.d(this.f21044a, strO);
        }
        if (strO2 != null) {
            d.b(this.f21044a, d.a(strO2));
        }
        this.f21052i.o(attributeSet, i7);
        if (n0.f21330b && this.f21052i.j() != 0) {
            int[] iArrI = this.f21052i.i();
            if (iArrI.length > 0) {
                if (e.a(this.f21044a) != -1.0f) {
                    e.b(this.f21044a, this.f21052i.g(), this.f21052i.f(), this.f21052i.h(), 0);
                } else {
                    e.c(this.f21044a, iArrI, 0);
                }
            }
        }
        d0 d0VarU = d0.u(context, attributeSet, i.j.f17256g0);
        int iN2 = d0VarU.n(i.j.f17296o0, -1);
        Drawable drawableC = iN2 != -1 ? c1472jB.c(context, iN2) : null;
        int iN3 = d0VarU.n(i.j.f17321t0, -1);
        Drawable drawableC2 = iN3 != -1 ? c1472jB.c(context, iN3) : null;
        int iN4 = d0VarU.n(i.j.f17301p0, -1);
        Drawable drawableC3 = iN4 != -1 ? c1472jB.c(context, iN4) : null;
        int iN5 = d0VarU.n(i.j.f17286m0, -1);
        Drawable drawableC4 = iN5 != -1 ? c1472jB.c(context, iN5) : null;
        int iN6 = d0VarU.n(i.j.f17306q0, -1);
        Drawable drawableC5 = iN6 != -1 ? c1472jB.c(context, iN6) : null;
        int iN7 = d0VarU.n(i.j.f17291n0, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? c1472jB.c(context, iN7) : null);
        if (d0VarU.s(i.j.f17311r0)) {
            AbstractC0897h.g(this.f21044a, d0VarU.c(i.j.f17311r0));
        }
        if (d0VarU.s(i.j.f17316s0)) {
            AbstractC0897h.h(this.f21044a, N.e(d0VarU.k(i.j.f17316s0, -1), null));
        }
        int iF = d0VarU.f(i.j.f17331v0, -1);
        int iF2 = d0VarU.f(i.j.f17336w0, -1);
        int iF3 = d0VarU.f(i.j.f17341x0, -1);
        d0VarU.w();
        if (iF != -1) {
            AbstractC0897h.j(this.f21044a, iF);
        }
        if (iF2 != -1) {
            AbstractC0897h.k(this.f21044a, iF2);
        }
        if (iF3 != -1) {
            AbstractC0897h.l(this.f21044a, iF3);
        }
    }

    public void n(WeakReference weakReference, Typeface typeface) {
        if (this.f21056m) {
            this.f21055l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (Z.W.P(textView)) {
                    textView.post(new b(textView, typeface, this.f21053j));
                } else {
                    textView.setTypeface(typeface, this.f21053j);
                }
            }
        }
    }

    public void o(boolean z7, int i7, int i8, int i9, int i10) {
        if (n0.f21330b) {
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
            this.f21044a.setTextSize(0, 0.0f);
        }
        C(context, d0VarT);
        if (i8 >= 26 && d0VarT.s(i.j.f17229a3) && (strO = d0VarT.o(i.j.f17229a3)) != null) {
            e.d(this.f21044a, strO);
        }
        d0VarT.w();
        Typeface typeface = this.f21055l;
        if (typeface != null) {
            this.f21044a.setTypeface(typeface, this.f21053j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        C0820c.f(editorInfo, textView.getText());
    }

    public void s(boolean z7) {
        this.f21044a.setAllCaps(z7);
    }

    public void t(int i7, int i8, int i9, int i10) {
        this.f21052i.p(i7, i8, i9, i10);
    }

    public void u(int[] iArr, int i7) {
        this.f21052i.q(iArr, i7);
    }

    public void v(int i7) {
        this.f21052i.r(i7);
    }

    public void w(ColorStateList colorStateList) {
        if (this.f21051h == null) {
            this.f21051h = new b0();
        }
        b0 b0Var = this.f21051h;
        b0Var.f21242a = colorStateList;
        b0Var.f21245d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.f21051h == null) {
            this.f21051h = new b0();
        }
        b0 b0Var = this.f21051h;
        b0Var.f21243b = mode;
        b0Var.f21244c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.f21044a);
            TextView textView = this.f21044a;
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
        Drawable[] drawableArrA2 = c.a(this.f21044a);
        Drawable drawable7 = drawableArrA2[0];
        if (drawable7 != null || drawableArrA2[2] != null) {
            TextView textView2 = this.f21044a;
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
        Drawable[] compoundDrawables = this.f21044a.getCompoundDrawables();
        TextView textView3 = this.f21044a;
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
        b0 b0Var = this.f21051h;
        this.f21045b = b0Var;
        this.f21046c = b0Var;
        this.f21047d = b0Var;
        this.f21048e = b0Var;
        this.f21049f = b0Var;
        this.f21050g = b0Var;
    }

    public class a extends h.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21057a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21058b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f21059c;

        public a(int i7, int i8, WeakReference weakReference) {
            this.f21057a = i7;
            this.f21058b = i8;
            this.f21059c = weakReference;
        }

        @Override // N.h.c
        public void g(Typeface typeface) {
            int i7;
            if (Build.VERSION.SDK_INT >= 28 && (i7 = this.f21057a) != -1) {
                typeface = f.a(typeface, i7, (this.f21058b & 2) != 0);
            }
            B.this.n(this.f21059c, typeface);
        }

        @Override // N.h.c
        public void f(int i7) {
        }
    }
}
