package f3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public class k {

    /* renamed from: m, reason: collision with root package name */
    public static final f3.c f15772m = new i(0.5f);

    /* renamed from: a, reason: collision with root package name */
    public d f15773a;

    /* renamed from: b, reason: collision with root package name */
    public d f15774b;

    /* renamed from: c, reason: collision with root package name */
    public d f15775c;

    /* renamed from: d, reason: collision with root package name */
    public d f15776d;

    /* renamed from: e, reason: collision with root package name */
    public f3.c f15777e;

    /* renamed from: f, reason: collision with root package name */
    public f3.c f15778f;

    /* renamed from: g, reason: collision with root package name */
    public f3.c f15779g;

    /* renamed from: h, reason: collision with root package name */
    public f3.c f15780h;

    /* renamed from: i, reason: collision with root package name */
    public f f15781i;

    /* renamed from: j, reason: collision with root package name */
    public f f15782j;

    /* renamed from: k, reason: collision with root package name */
    public f f15783k;

    /* renamed from: l, reason: collision with root package name */
    public f f15784l;

    public interface c {
        f3.c a(f3.c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i7, int i8) {
        return c(context, i7, i8, 0);
    }

    public static b c(Context context, int i7, int i8, int i9) {
        return d(context, i7, i8, new C1052a(i9));
    }

    public static b d(Context context, int i7, int i8, f3.c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i7);
        if (i8 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i8);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(O2.j.f7058U3);
        try {
            int i9 = typedArrayObtainStyledAttributes.getInt(O2.j.f7065V3, 0);
            int i10 = typedArrayObtainStyledAttributes.getInt(O2.j.f7086Y3, i9);
            int i11 = typedArrayObtainStyledAttributes.getInt(O2.j.f7093Z3, i9);
            int i12 = typedArrayObtainStyledAttributes.getInt(O2.j.f7079X3, i9);
            int i13 = typedArrayObtainStyledAttributes.getInt(O2.j.f7072W3, i9);
            f3.c cVarM = m(typedArrayObtainStyledAttributes, O2.j.f7101a4, cVar);
            f3.c cVarM2 = m(typedArrayObtainStyledAttributes, O2.j.f7125d4, cVarM);
            f3.c cVarM3 = m(typedArrayObtainStyledAttributes, O2.j.f7133e4, cVarM);
            f3.c cVarM4 = m(typedArrayObtainStyledAttributes, O2.j.f7117c4, cVarM);
            return new b().y(i10, cVarM2).C(i11, cVarM3).u(i12, cVarM4).q(i13, m(typedArrayObtainStyledAttributes, O2.j.f7109b4, cVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i7, int i8) {
        return f(context, attributeSet, i7, i8, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i7, int i8, int i9) {
        return g(context, attributeSet, i7, i8, new C1052a(i9));
    }

    public static b g(Context context, AttributeSet attributeSet, int i7, int i8, f3.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O2.j.f7140f3, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(O2.j.f7148g3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(O2.j.f7156h3, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    public static f3.c m(TypedArray typedArray, int i7, f3.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i7);
        if (typedValuePeekValue != null) {
            int i8 = typedValuePeekValue.type;
            if (i8 == 5) {
                return new C1052a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i8 == 6) {
                return new i(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cVar;
    }

    public f h() {
        return this.f15783k;
    }

    public d i() {
        return this.f15776d;
    }

    public f3.c j() {
        return this.f15780h;
    }

    public d k() {
        return this.f15775c;
    }

    public f3.c l() {
        return this.f15779g;
    }

    public f n() {
        return this.f15784l;
    }

    public f o() {
        return this.f15782j;
    }

    public f p() {
        return this.f15781i;
    }

    public d q() {
        return this.f15773a;
    }

    public f3.c r() {
        return this.f15777e;
    }

    public d s() {
        return this.f15774b;
    }

    public f3.c t() {
        return this.f15778f;
    }

    public boolean u(RectF rectF) {
        boolean z7 = this.f15784l.getClass().equals(f.class) && this.f15782j.getClass().equals(f.class) && this.f15781i.getClass().equals(f.class) && this.f15783k.getClass().equals(f.class);
        float fA = this.f15777e.a(rectF);
        return z7 && ((this.f15778f.a(rectF) > fA ? 1 : (this.f15778f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f15780h.a(rectF) > fA ? 1 : (this.f15780h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f15779g.a(rectF) > fA ? 1 : (this.f15779g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f15774b instanceof j) && (this.f15773a instanceof j) && (this.f15775c instanceof j) && (this.f15776d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f7) {
        return v().o(f7).m();
    }

    public k x(f3.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    public k(b bVar) {
        this.f15773a = bVar.f15785a;
        this.f15774b = bVar.f15786b;
        this.f15775c = bVar.f15787c;
        this.f15776d = bVar.f15788d;
        this.f15777e = bVar.f15789e;
        this.f15778f = bVar.f15790f;
        this.f15779g = bVar.f15791g;
        this.f15780h = bVar.f15792h;
        this.f15781i = bVar.f15793i;
        this.f15782j = bVar.f15794j;
        this.f15783k = bVar.f15795k;
        this.f15784l = bVar.f15796l;
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public d f15785a;

        /* renamed from: b, reason: collision with root package name */
        public d f15786b;

        /* renamed from: c, reason: collision with root package name */
        public d f15787c;

        /* renamed from: d, reason: collision with root package name */
        public d f15788d;

        /* renamed from: e, reason: collision with root package name */
        public f3.c f15789e;

        /* renamed from: f, reason: collision with root package name */
        public f3.c f15790f;

        /* renamed from: g, reason: collision with root package name */
        public f3.c f15791g;

        /* renamed from: h, reason: collision with root package name */
        public f3.c f15792h;

        /* renamed from: i, reason: collision with root package name */
        public f f15793i;

        /* renamed from: j, reason: collision with root package name */
        public f f15794j;

        /* renamed from: k, reason: collision with root package name */
        public f f15795k;

        /* renamed from: l, reason: collision with root package name */
        public f f15796l;

        public b() {
            this.f15785a = h.b();
            this.f15786b = h.b();
            this.f15787c = h.b();
            this.f15788d = h.b();
            this.f15789e = new C1052a(0.0f);
            this.f15790f = new C1052a(0.0f);
            this.f15791g = new C1052a(0.0f);
            this.f15792h = new C1052a(0.0f);
            this.f15793i = h.c();
            this.f15794j = h.c();
            this.f15795k = h.c();
            this.f15796l = h.c();
        }

        public static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f15771a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f15719a;
            }
            return -1.0f;
        }

        public b A(float f7) {
            this.f15789e = new C1052a(f7);
            return this;
        }

        public b B(f3.c cVar) {
            this.f15789e = cVar;
            return this;
        }

        public b C(int i7, f3.c cVar) {
            return D(h.a(i7)).F(cVar);
        }

        public b D(d dVar) {
            this.f15786b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                E(fN);
            }
            return this;
        }

        public b E(float f7) {
            this.f15790f = new C1052a(f7);
            return this;
        }

        public b F(f3.c cVar) {
            this.f15790f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f7) {
            return A(f7).E(f7).w(f7).s(f7);
        }

        public b p(f3.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i7, f3.c cVar) {
            return r(h.a(i7)).t(cVar);
        }

        public b r(d dVar) {
            this.f15788d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                s(fN);
            }
            return this;
        }

        public b s(float f7) {
            this.f15792h = new C1052a(f7);
            return this;
        }

        public b t(f3.c cVar) {
            this.f15792h = cVar;
            return this;
        }

        public b u(int i7, f3.c cVar) {
            return v(h.a(i7)).x(cVar);
        }

        public b v(d dVar) {
            this.f15787c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        public b w(float f7) {
            this.f15791g = new C1052a(f7);
            return this;
        }

        public b x(f3.c cVar) {
            this.f15791g = cVar;
            return this;
        }

        public b y(int i7, f3.c cVar) {
            return z(h.a(i7)).B(cVar);
        }

        public b z(d dVar) {
            this.f15785a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                A(fN);
            }
            return this;
        }

        public b(k kVar) {
            this.f15785a = h.b();
            this.f15786b = h.b();
            this.f15787c = h.b();
            this.f15788d = h.b();
            this.f15789e = new C1052a(0.0f);
            this.f15790f = new C1052a(0.0f);
            this.f15791g = new C1052a(0.0f);
            this.f15792h = new C1052a(0.0f);
            this.f15793i = h.c();
            this.f15794j = h.c();
            this.f15795k = h.c();
            this.f15796l = h.c();
            this.f15785a = kVar.f15773a;
            this.f15786b = kVar.f15774b;
            this.f15787c = kVar.f15775c;
            this.f15788d = kVar.f15776d;
            this.f15789e = kVar.f15777e;
            this.f15790f = kVar.f15778f;
            this.f15791g = kVar.f15779g;
            this.f15792h = kVar.f15780h;
            this.f15793i = kVar.f15781i;
            this.f15794j = kVar.f15782j;
            this.f15795k = kVar.f15783k;
            this.f15796l = kVar.f15784l;
        }
    }

    public k() {
        this.f15773a = h.b();
        this.f15774b = h.b();
        this.f15775c = h.b();
        this.f15776d = h.b();
        this.f15777e = new C1052a(0.0f);
        this.f15778f = new C1052a(0.0f);
        this.f15779g = new C1052a(0.0f);
        this.f15780h = new C1052a(0.0f);
        this.f15781i = h.c();
        this.f15782j = h.c();
        this.f15783k = h.c();
        this.f15784l = h.c();
    }
}
