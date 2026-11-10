package androidx.recyclerview.widget;

import Z.C0682a;
import Z.D;
import Z.E;
import Z.W;
import Z.Z;
import a0.AbstractC0745b;
import a0.x;
import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import e0.AbstractC1008a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: H0, reason: collision with root package name */
    public static final int[] f13048H0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: I0, reason: collision with root package name */
    public static final boolean f13049I0 = false;

    /* renamed from: J0, reason: collision with root package name */
    public static final boolean f13050J0 = true;

    /* renamed from: K0, reason: collision with root package name */
    public static final boolean f13051K0 = true;

    /* renamed from: L0, reason: collision with root package name */
    public static final boolean f13052L0 = true;

    /* renamed from: M0, reason: collision with root package name */
    public static final boolean f13053M0 = false;

    /* renamed from: N0, reason: collision with root package name */
    public static final boolean f13054N0 = false;

    /* renamed from: O0, reason: collision with root package name */
    public static final Class[] f13055O0;

    /* renamed from: P0, reason: collision with root package name */
    public static final Interpolator f13056P0;

    /* renamed from: A, reason: collision with root package name */
    public r f13057A;

    /* renamed from: A0, reason: collision with root package name */
    public E f13058A0;

    /* renamed from: B, reason: collision with root package name */
    public boolean f13059B;

    /* renamed from: B0, reason: collision with root package name */
    public final int[] f13060B0;

    /* renamed from: C, reason: collision with root package name */
    public boolean f13061C;

    /* renamed from: C0, reason: collision with root package name */
    public final int[] f13062C0;

    /* renamed from: D, reason: collision with root package name */
    public boolean f13063D;

    /* renamed from: D0, reason: collision with root package name */
    public final int[] f13064D0;

    /* renamed from: E, reason: collision with root package name */
    public boolean f13065E;

    /* renamed from: E0, reason: collision with root package name */
    public final List f13066E0;

    /* renamed from: F, reason: collision with root package name */
    public int f13067F;

    /* renamed from: F0, reason: collision with root package name */
    public Runnable f13068F0;

    /* renamed from: G, reason: collision with root package name */
    public boolean f13069G;

    /* renamed from: G0, reason: collision with root package name */
    public final p.b f13070G0;

    /* renamed from: H, reason: collision with root package name */
    public boolean f13071H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f13072I;

    /* renamed from: J, reason: collision with root package name */
    public int f13073J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f13074K;

    /* renamed from: L, reason: collision with root package name */
    public final AccessibilityManager f13075L;

    /* renamed from: M, reason: collision with root package name */
    public List f13076M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f13077N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f13078O;

    /* renamed from: P, reason: collision with root package name */
    public int f13079P;

    /* renamed from: Q, reason: collision with root package name */
    public int f13080Q;

    /* renamed from: R, reason: collision with root package name */
    public k f13081R;

    /* renamed from: S, reason: collision with root package name */
    public EdgeEffect f13082S;

    /* renamed from: T, reason: collision with root package name */
    public EdgeEffect f13083T;

    /* renamed from: U, reason: collision with root package name */
    public EdgeEffect f13084U;

    /* renamed from: V, reason: collision with root package name */
    public EdgeEffect f13085V;

    /* renamed from: W, reason: collision with root package name */
    public l f13086W;

    /* renamed from: a0, reason: collision with root package name */
    public int f13087a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f13088b0;

    /* renamed from: c0, reason: collision with root package name */
    public VelocityTracker f13089c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f13090d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f13091e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f13092f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f13093g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f13094h0;

    /* renamed from: i0, reason: collision with root package name */
    public q f13095i0;

    /* renamed from: j0, reason: collision with root package name */
    public final int f13096j0;

    /* renamed from: k0, reason: collision with root package name */
    public final int f13097k0;

    /* renamed from: l, reason: collision with root package name */
    public final w f13098l;

    /* renamed from: l0, reason: collision with root package name */
    public float f13099l0;

    /* renamed from: m, reason: collision with root package name */
    public final u f13100m;

    /* renamed from: m0, reason: collision with root package name */
    public float f13101m0;

    /* renamed from: n, reason: collision with root package name */
    public x f13102n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f13103n0;

    /* renamed from: o, reason: collision with root package name */
    public a f13104o;

    /* renamed from: o0, reason: collision with root package name */
    public final B f13105o0;

    /* renamed from: p, reason: collision with root package name */
    public b f13106p;

    /* renamed from: p0, reason: collision with root package name */
    public androidx.recyclerview.widget.e f13107p0;

    /* renamed from: q, reason: collision with root package name */
    public final androidx.recyclerview.widget.p f13108q;

    /* renamed from: q0, reason: collision with root package name */
    public e.b f13109q0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13110r;

    /* renamed from: r0, reason: collision with root package name */
    public final z f13111r0;

    /* renamed from: s, reason: collision with root package name */
    public final Runnable f13112s;

    /* renamed from: s0, reason: collision with root package name */
    public s f13113s0;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f13114t;

    /* renamed from: t0, reason: collision with root package name */
    public List f13115t0;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f13116u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f13117u0;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f13118v;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f13119v0;

    /* renamed from: w, reason: collision with root package name */
    public g f13120w;

    /* renamed from: w0, reason: collision with root package name */
    public l.a f13121w0;

    /* renamed from: x, reason: collision with root package name */
    public o f13122x;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f13123x0;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f13124y;

    /* renamed from: y0, reason: collision with root package name */
    public androidx.recyclerview.widget.k f13125y0;

    /* renamed from: z, reason: collision with root package name */
    public final ArrayList f13126z;

    /* renamed from: z0, reason: collision with root package name */
    public final int[] f13127z0;

    public static abstract class A {
        public abstract View a(u uVar, int i7, int i8);
    }

    public class B implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public int f13128l;

        /* renamed from: m, reason: collision with root package name */
        public int f13129m;

        /* renamed from: n, reason: collision with root package name */
        public OverScroller f13130n;

        /* renamed from: o, reason: collision with root package name */
        public Interpolator f13131o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f13132p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f13133q;

        public B() {
            Interpolator interpolator = RecyclerView.f13056P0;
            this.f13131o = interpolator;
            this.f13132p = false;
            this.f13133q = false;
            this.f13130n = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i7, int i8, int i9, int i10) {
            int iRound;
            int iAbs = Math.abs(i7);
            int iAbs2 = Math.abs(i8);
            boolean z7 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i9 * i9) + (i10 * i10));
            int iSqrt2 = (int) Math.sqrt((i7 * i7) + (i8 * i8));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z7 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i11 = width / 2;
            float f7 = width;
            float f8 = i11;
            float fB = f8 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f7)) * f8);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z7) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f7) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final float b(float f7) {
            return (float) Math.sin((f7 - 0.5f) * 0.47123894f);
        }

        public void c(int i7, int i8) {
            RecyclerView.this.setScrollState(2);
            this.f13129m = 0;
            this.f13128l = 0;
            Interpolator interpolator = this.f13131o;
            Interpolator interpolator2 = RecyclerView.f13056P0;
            if (interpolator != interpolator2) {
                this.f13131o = interpolator2;
                this.f13130n = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f13130n.fling(0, 0, i7, i8, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        public final void d() {
            RecyclerView.this.removeCallbacks(this);
            W.d0(RecyclerView.this, this);
        }

        public void e() {
            if (this.f13132p) {
                this.f13133q = true;
            } else {
                d();
            }
        }

        public void f(int i7, int i8, int i9, Interpolator interpolator) {
            if (i9 == Integer.MIN_VALUE) {
                i9 = a(i7, i8, 0, 0);
            }
            int i10 = i9;
            if (interpolator == null) {
                interpolator = RecyclerView.f13056P0;
            }
            if (this.f13131o != interpolator) {
                this.f13131o = interpolator;
                this.f13130n = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f13129m = 0;
            this.f13128l = 0;
            RecyclerView.this.setScrollState(2);
            this.f13130n.startScroll(0, 0, i7, i8, i10);
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f13130n.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7;
            int i8;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f13122x == null) {
                g();
                return;
            }
            this.f13133q = false;
            this.f13132p = true;
            recyclerView.u();
            OverScroller overScroller = this.f13130n;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i9 = currX - this.f13128l;
                int i10 = currY - this.f13129m;
                this.f13128l = currX;
                this.f13129m = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f13064D0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.F(i9, i10, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f13064D0;
                    i9 -= iArr2[0];
                    i10 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.t(i9, i10);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f13120w != null) {
                    int[] iArr3 = recyclerView3.f13064D0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.f1(i9, i10, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f13064D0;
                    int i11 = iArr4[0];
                    int i12 = iArr4[1];
                    i9 -= i11;
                    i10 -= i12;
                    y yVar = recyclerView4.f13122x.f13178g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int iB = RecyclerView.this.f13111r0.b();
                        if (iB == 0) {
                            yVar.r();
                        } else if (yVar.f() >= iB) {
                            yVar.p(iB - 1);
                            yVar.j(i11, i12);
                        } else {
                            yVar.j(i11, i12);
                        }
                    }
                    i8 = i12;
                    i7 = i11;
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i13 = i9;
                int i14 = i10;
                if (!RecyclerView.this.f13124y.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f13064D0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.G(i7, i8, i13, i14, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f13064D0;
                int i15 = i13 - iArr6[0];
                int i16 = i14 - iArr6[1];
                if (i7 != 0 || i8 != 0) {
                    recyclerView6.I(i7, i8);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z7 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i15 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i16 != 0));
                y yVar2 = RecyclerView.this.f13122x.f13178g;
                if ((yVar2 == null || !yVar2.g()) && z7) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i17 = i15 < 0 ? -currVelocity : i15 > 0 ? currVelocity : 0;
                        if (i16 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i16 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i17, currVelocity);
                    }
                    if (RecyclerView.f13052L0) {
                        RecyclerView.this.f13109q0.b();
                    }
                } else {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView7.f13107p0;
                    if (eVar != null) {
                        eVar.f(recyclerView7, i7, i8);
                    }
                }
            }
            y yVar3 = RecyclerView.this.f13122x.f13178g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.f13132p = false;
            if (this.f13133q) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.s1(1);
            }
        }
    }

    public static abstract class C {

        /* renamed from: s, reason: collision with root package name */
        public static final List f13135s = Collections.EMPTY_LIST;

        /* renamed from: a, reason: collision with root package name */
        public final View f13136a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference f13137b;

        /* renamed from: j, reason: collision with root package name */
        public int f13145j;

        /* renamed from: r, reason: collision with root package name */
        public RecyclerView f13153r;

        /* renamed from: c, reason: collision with root package name */
        public int f13138c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f13139d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f13140e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f13141f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f13142g = -1;

        /* renamed from: h, reason: collision with root package name */
        public C f13143h = null;

        /* renamed from: i, reason: collision with root package name */
        public C f13144i = null;

        /* renamed from: k, reason: collision with root package name */
        public List f13146k = null;

        /* renamed from: l, reason: collision with root package name */
        public List f13147l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f13148m = 0;

        /* renamed from: n, reason: collision with root package name */
        public u f13149n = null;

        /* renamed from: o, reason: collision with root package name */
        public boolean f13150o = false;

        /* renamed from: p, reason: collision with root package name */
        public int f13151p = 0;

        /* renamed from: q, reason: collision with root package name */
        public int f13152q = -1;

        public C(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f13136a = view;
        }

        public void A(int i7, boolean z7) {
            if (this.f13139d == -1) {
                this.f13139d = this.f13138c;
            }
            if (this.f13142g == -1) {
                this.f13142g = this.f13138c;
            }
            if (z7) {
                this.f13142g += i7;
            }
            this.f13138c += i7;
            if (this.f13136a.getLayoutParams() != null) {
                ((p) this.f13136a.getLayoutParams()).f13198c = true;
            }
        }

        public void B(RecyclerView recyclerView) {
            int i7 = this.f13152q;
            if (i7 != -1) {
                this.f13151p = i7;
            } else {
                this.f13151p = W.y(this.f13136a);
            }
            recyclerView.i1(this, 4);
        }

        public void C(RecyclerView recyclerView) {
            recyclerView.i1(this, this.f13151p);
            this.f13151p = 0;
        }

        public void D() {
            this.f13145j = 0;
            this.f13138c = -1;
            this.f13139d = -1;
            this.f13140e = -1L;
            this.f13142g = -1;
            this.f13148m = 0;
            this.f13143h = null;
            this.f13144i = null;
            d();
            this.f13151p = 0;
            this.f13152q = -1;
            RecyclerView.r(this);
        }

        public void E() {
            if (this.f13139d == -1) {
                this.f13139d = this.f13138c;
            }
        }

        public void F(int i7, int i8) {
            this.f13145j = (i7 & i8) | (this.f13145j & (~i8));
        }

        public final void G(boolean z7) {
            int i7 = this.f13148m;
            int i8 = z7 ? i7 - 1 : i7 + 1;
            this.f13148m = i8;
            if (i8 < 0) {
                this.f13148m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z7 && i8 == 1) {
                this.f13145j |= 16;
            } else if (z7 && i8 == 0) {
                this.f13145j &= -17;
            }
        }

        public void H(u uVar, boolean z7) {
            this.f13149n = uVar;
            this.f13150o = z7;
        }

        public boolean I() {
            return (this.f13145j & 16) != 0;
        }

        public boolean J() {
            return (this.f13145j & 128) != 0;
        }

        public void K() {
            this.f13149n.J(this);
        }

        public boolean L() {
            return (this.f13145j & 32) != 0;
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f13145j) == 0) {
                g();
                this.f13146k.add(obj);
            }
        }

        public void b(int i7) {
            this.f13145j = i7 | this.f13145j;
        }

        public void c() {
            this.f13139d = -1;
            this.f13142g = -1;
        }

        public void d() {
            List list = this.f13146k;
            if (list != null) {
                list.clear();
            }
            this.f13145j &= -1025;
        }

        public void e() {
            this.f13145j &= -33;
        }

        public void f() {
            this.f13145j &= -257;
        }

        public final void g() {
            if (this.f13146k == null) {
                ArrayList arrayList = new ArrayList();
                this.f13146k = arrayList;
                this.f13147l = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean h() {
            return (this.f13145j & 16) == 0 && W.N(this.f13136a);
        }

        public void i(int i7, int i8, boolean z7) {
            b(8);
            A(i8, z7);
            this.f13138c = i7;
        }

        public final int j() {
            RecyclerView recyclerView = this.f13153r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b0(this);
        }

        public final long k() {
            return this.f13140e;
        }

        public final int l() {
            return this.f13141f;
        }

        public final int m() {
            int i7 = this.f13142g;
            return i7 == -1 ? this.f13138c : i7;
        }

        public final int n() {
            return this.f13139d;
        }

        public List o() {
            if ((this.f13145j & 1024) != 0) {
                return f13135s;
            }
            List list = this.f13146k;
            return (list == null || list.size() == 0) ? f13135s : this.f13147l;
        }

        public boolean p(int i7) {
            return (i7 & this.f13145j) != 0;
        }

        public boolean q() {
            return (this.f13145j & 512) != 0 || t();
        }

        public boolean r() {
            return (this.f13136a.getParent() == null || this.f13136a.getParent() == this.f13153r) ? false : true;
        }

        public boolean s() {
            return (this.f13145j & 1) != 0;
        }

        public boolean t() {
            return (this.f13145j & 4) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f13138c + " id=" + this.f13140e + ", oldPos=" + this.f13139d + ", pLpos:" + this.f13142g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.f13150o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.f13148m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f13136a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.f13145j & 16) == 0 && !W.N(this.f13136a);
        }

        public boolean v() {
            return (this.f13145j & 8) != 0;
        }

        public boolean w() {
            return this.f13149n != null;
        }

        public boolean x() {
            return (this.f13145j & 256) != 0;
        }

        public boolean y() {
            return (this.f13145j & 2) != 0;
        }

        public boolean z() {
            return (this.f13145j & 2) != 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a, reason: case insensitive filesystem */
    public class RunnableC0813a implements Runnable {
        public RunnableC0813a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f13065E || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f13059B) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f13071H) {
                recyclerView2.f13069G = true;
            } else {
                recyclerView2.u();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b, reason: case insensitive filesystem */
    public class RunnableC0814b implements Runnable {
        public RunnableC0814b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.f13086W;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.f13123x0 = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c, reason: case insensitive filesystem */
    public static class InterpolatorC0815c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f7) {
            float f8 = f7 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    }

    public class d implements p.b {
        public d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(C c7) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f13122x.m1(c7.f13136a, recyclerView.f13100m);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(C c7, l.b bVar, l.b bVar2) {
            RecyclerView.this.l(c7, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(C c7, l.b bVar, l.b bVar2) {
            RecyclerView.this.f13100m.J(c7);
            RecyclerView.this.n(c7, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(C c7, l.b bVar, l.b bVar2) {
            c7.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f13077N) {
                if (recyclerView.f13086W.b(c7, c7, bVar, bVar2)) {
                    RecyclerView.this.L0();
                }
            } else if (recyclerView.f13086W.d(c7, bVar, bVar2)) {
                RecyclerView.this.L0();
            }
        }
    }

    public class e implements b.InterfaceC0123b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public View a(int i7) {
            return RecyclerView.this.getChildAt(i7);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public void b(View view) {
            C cF0 = RecyclerView.f0(view);
            if (cF0 != null) {
                cF0.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public void d() {
            int iC = c();
            for (int i7 = 0; i7 < iC; i7++) {
                View viewA = a(i7);
                RecyclerView.this.z(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public C f(View view) {
            return RecyclerView.f0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public void g(int i7) {
            C cF0;
            View viewA = a(i7);
            if (viewA != null && (cF0 = RecyclerView.f0(viewA)) != null) {
                if (cF0.x() && !cF0.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + cF0 + RecyclerView.this.P());
                }
                cF0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i7);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public void h(View view) {
            C cF0 = RecyclerView.f0(view);
            if (cF0 != null) {
                cF0.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public void i(View view, int i7) {
            RecyclerView.this.addView(view, i7);
            RecyclerView.this.y(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public void j(int i7) {
            View childAt = RecyclerView.this.getChildAt(i7);
            if (childAt != null) {
                RecyclerView.this.z(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i7);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0123b
        public void k(View view, int i7, ViewGroup.LayoutParams layoutParams) {
            C cF0 = RecyclerView.f0(view);
            if (cF0 != null) {
                if (!cF0.x() && !cF0.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + cF0 + RecyclerView.this.P());
                }
                cF0.f();
            }
            RecyclerView.this.attachViewToParent(view, i7, layoutParams);
        }
    }

    public class f implements a.InterfaceC0122a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public void a(int i7, int i8) {
            RecyclerView.this.B0(i7, i8);
            RecyclerView.this.f13117u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public void c(int i7, int i8, Object obj) {
            RecyclerView.this.v1(i7, i8, obj);
            RecyclerView.this.f13119v0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public C e(int i7) {
            C cZ = RecyclerView.this.Z(i7, true);
            if (cZ == null || RecyclerView.this.f13106p.n(cZ.f13136a)) {
                return null;
            }
            return cZ;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public void f(int i7, int i8) {
            RecyclerView.this.C0(i7, i8, false);
            RecyclerView.this.f13117u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public void g(int i7, int i8) {
            RecyclerView.this.A0(i7, i8);
            RecyclerView.this.f13117u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0122a
        public void h(int i7, int i8) {
            RecyclerView.this.C0(i7, i8, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f13117u0 = true;
            recyclerView.f13111r0.f13235d += i8;
        }

        public void i(a.b bVar) {
            int i7 = bVar.f13313a;
            if (i7 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f13122x.R0(recyclerView, bVar.f13314b, bVar.f13316d);
                return;
            }
            if (i7 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f13122x.U0(recyclerView2, bVar.f13314b, bVar.f13316d);
            } else if (i7 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f13122x.W0(recyclerView3, bVar.f13314b, bVar.f13316d, bVar.f13315c);
            } else {
                if (i7 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f13122x.T0(recyclerView4, bVar.f13314b, bVar.f13316d, 1);
            }
        }
    }

    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        public final h f13159a = new h();

        /* renamed from: b, reason: collision with root package name */
        public boolean f13160b = false;

        public final void a(C c7, int i7) {
            c7.f13138c = i7;
            if (g()) {
                c7.f13140e = d(i7);
            }
            c7.F(1, 519);
            V.k.a("RV OnBindView");
            j(c7, i7, c7.o());
            c7.d();
            ViewGroup.LayoutParams layoutParams = c7.f13136a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f13198c = true;
            }
            V.k.b();
        }

        public final C b(ViewGroup viewGroup, int i7) {
            try {
                V.k.a("RV CreateView");
                C cK = k(viewGroup, i7);
                if (cK.f13136a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                cK.f13141f = i7;
                return cK;
            } finally {
                V.k.b();
            }
        }

        public abstract int c();

        public long d(int i7) {
            return -1L;
        }

        public int e(int i7) {
            return 0;
        }

        public final boolean f() {
            return this.f13159a.a();
        }

        public final boolean g() {
            return this.f13160b;
        }

        public void h(RecyclerView recyclerView) {
        }

        public abstract void i(C c7, int i7);

        public void j(C c7, int i7, List list) {
            i(c7, i7);
        }

        public abstract C k(ViewGroup viewGroup, int i7);

        public void l(RecyclerView recyclerView) {
        }

        public boolean m(C c7) {
            return false;
        }

        public void n(C c7) {
        }

        public void o(C c7) {
        }

        public void p(C c7) {
        }

        public void q(i iVar) {
            this.f13159a.registerObserver(iVar);
        }

        public void r(boolean z7) {
            if (f()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f13160b = z7;
        }

        public void s(i iVar) {
            this.f13159a.unregisterObserver(iVar);
        }
    }

    public static class h extends Observable {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }
    }

    public static abstract class i {
    }

    public interface j {
    }

    public static class k {
        public EdgeEffect a(RecyclerView recyclerView, int i7) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        public a f13161a = null;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f13162b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public long f13163c = 120;

        /* renamed from: d, reason: collision with root package name */
        public long f13164d = 120;

        /* renamed from: e, reason: collision with root package name */
        public long f13165e = 250;

        /* renamed from: f, reason: collision with root package name */
        public long f13166f = 250;

        public interface a {
            void a(C c7);
        }

        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public int f13167a;

            /* renamed from: b, reason: collision with root package name */
            public int f13168b;

            /* renamed from: c, reason: collision with root package name */
            public int f13169c;

            /* renamed from: d, reason: collision with root package name */
            public int f13170d;

            public b a(C c7) {
                return b(c7, 0);
            }

            public b b(C c7, int i7) {
                View view = c7.f13136a;
                this.f13167a = view.getLeft();
                this.f13168b = view.getTop();
                this.f13169c = view.getRight();
                this.f13170d = view.getBottom();
                return this;
            }
        }

        public static int e(C c7) {
            int i7 = c7.f13145j;
            int i8 = i7 & 14;
            if (c7.t()) {
                return 4;
            }
            if ((i7 & 4) == 0) {
                int iN = c7.n();
                int iJ = c7.j();
                if (iN != -1 && iJ != -1 && iN != iJ) {
                    return i8 | 2048;
                }
            }
            return i8;
        }

        public abstract boolean a(C c7, b bVar, b bVar2);

        public abstract boolean b(C c7, C c8, b bVar, b bVar2);

        public abstract boolean c(C c7, b bVar, b bVar2);

        public abstract boolean d(C c7, b bVar, b bVar2);

        public boolean f(C c7) {
            return true;
        }

        public boolean g(C c7, List list) {
            return f(c7);
        }

        public final void h(C c7) {
            r(c7);
            a aVar = this.f13161a;
            if (aVar != null) {
                aVar.a(c7);
            }
        }

        public final void i() {
            if (this.f13162b.size() <= 0) {
                this.f13162b.clear();
            } else {
                android.support.v4.media.session.b.a(this.f13162b.get(0));
                throw null;
            }
        }

        public abstract void j(C c7);

        public abstract void k();

        public long l() {
            return this.f13163c;
        }

        public long m() {
            return this.f13166f;
        }

        public long n() {
            return this.f13165e;
        }

        public long o() {
            return this.f13164d;
        }

        public abstract boolean p();

        public b q() {
            return new b();
        }

        public void r(C c7) {
        }

        public b s(z zVar, C c7) {
            return q().a(c7);
        }

        public b t(z zVar, C c7, int i7, List list) {
            return q().a(c7);
        }

        public abstract void u();

        public void v(a aVar) {
            this.f13161a = aVar;
        }
    }

    public class m implements l.a {
        public m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.a
        public void a(C c7) {
            c7.G(true);
            if (c7.f13143h != null && c7.f13144i == null) {
                c7.f13143h = null;
            }
            c7.f13144i = null;
            if (c7.I() || RecyclerView.this.U0(c7.f13136a) || !c7.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(c7.f13136a, false);
        }
    }

    public static abstract class n {
        public void d(Rect rect, int i7, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            d(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, z zVar) {
            f(canvas, recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.b f13172a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f13173b;

        /* renamed from: c, reason: collision with root package name */
        public final o.b f13174c;

        /* renamed from: d, reason: collision with root package name */
        public final o.b f13175d;

        /* renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.o f13176e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.recyclerview.widget.o f13177f;

        /* renamed from: g, reason: collision with root package name */
        public y f13178g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f13179h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f13180i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f13181j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f13182k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f13183l;

        /* renamed from: m, reason: collision with root package name */
        public int f13184m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f13185n;

        /* renamed from: o, reason: collision with root package name */
        public int f13186o;

        /* renamed from: p, reason: collision with root package name */
        public int f13187p;

        /* renamed from: q, reason: collision with root package name */
        public int f13188q;

        /* renamed from: r, reason: collision with root package name */
        public int f13189r;

        public class a implements o.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i7) {
                return o.this.I(i7);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b(View view) {
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.o0() - o.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        public class b implements o.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i7) {
                return o.this.I(i7);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b(View view) {
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.g0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.W() - o.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        public interface c {
            void a(int i7, int i8);
        }

        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f13192a;

            /* renamed from: b, reason: collision with root package name */
            public int f13193b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f13194c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f13195d;
        }

        public o() {
            a aVar = new a();
            this.f13174c = aVar;
            b bVar = new b();
            this.f13175d = bVar;
            this.f13176e = new androidx.recyclerview.widget.o(aVar);
            this.f13177f = new androidx.recyclerview.widget.o(bVar);
            this.f13179h = false;
            this.f13180i = false;
            this.f13181j = false;
            this.f13182k = true;
            this.f13183l = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int K(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1d
                if (r7 < 0) goto L12
            L10:
                r5 = r3
                goto L30
            L12:
                if (r7 != r1) goto L1a
                if (r5 == r2) goto L22
                if (r5 == 0) goto L1a
                if (r5 == r3) goto L22
            L1a:
                r5 = r6
                r7 = r5
                goto L30
            L1d:
                if (r7 < 0) goto L20
                goto L10
            L20:
                if (r7 != r1) goto L24
            L22:
                r7 = r4
                goto L30
            L24:
                if (r7 != r0) goto L1a
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2b
                goto L2e
            L2b:
                r7 = r4
                r5 = r6
                goto L30
            L2e:
                r7 = r4
                r5 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.K(int, int, int, int, boolean):int");
        }

        public static d i0(Context context, AttributeSet attributeSet, int i7, int i8) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, T1.c.f8225f, i7, i8);
            dVar.f13192a = typedArrayObtainStyledAttributes.getInt(T1.c.f8226g, 1);
            dVar.f13193b = typedArrayObtainStyledAttributes.getInt(T1.c.f8236q, 1);
            dVar.f13194c = typedArrayObtainStyledAttributes.getBoolean(T1.c.f8235p, false);
            dVar.f13195d = typedArrayObtainStyledAttributes.getBoolean(T1.c.f8237r, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i7);
            int size = View.MeasureSpec.getSize(i7);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i8, i9) : size : Math.min(size, Math.max(i8, i9));
        }

        public static boolean w0(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i8);
            int size = View.MeasureSpec.getSize(i8);
            if (i9 > 0 && i7 != i9) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i7;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i7;
            }
            return true;
        }

        public void A(RecyclerView recyclerView, u uVar) {
            this.f13180i = false;
            I0(recyclerView, uVar);
        }

        public void A0(View view, int i7, int i8) {
            p pVar = (p) view.getLayoutParams();
            Rect rectJ0 = this.f13173b.j0(view);
            int i9 = i7 + rectJ0.left + rectJ0.right;
            int i10 = i8 + rectJ0.top + rectJ0.bottom;
            int iK = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i9, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int iK2 = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i10, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (F1(view, iK, iK2, pVar)) {
                view.measure(iK, iK2);
            }
        }

        public void A1(int i7, int i8) {
            this.f13188q = View.MeasureSpec.getSize(i7);
            int mode = View.MeasureSpec.getMode(i7);
            this.f13186o = mode;
            if (mode == 0 && !RecyclerView.f13050J0) {
                this.f13188q = 0;
            }
            this.f13189r = View.MeasureSpec.getSize(i8);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.f13187p = mode2;
            if (mode2 != 0 || RecyclerView.f13050J0) {
                return;
            }
            this.f13189r = 0;
        }

        public View B(View view) {
            View viewR;
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView == null || (viewR = recyclerView.R(view)) == null || this.f13172a.n(viewR)) {
                return null;
            }
            return viewR;
        }

        public void B0(int i7, int i8) {
            View viewI = I(i7);
            if (viewI != null) {
                x(i7);
                h(viewI, i8);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i7 + this.f13173b.toString());
            }
        }

        public void B1(int i7, int i8) {
            this.f13173b.setMeasuredDimension(i7, i8);
        }

        public View C(int i7) {
            int iJ = J();
            for (int i8 = 0; i8 < iJ; i8++) {
                View viewI = I(i8);
                C cF0 = RecyclerView.f0(viewI);
                if (cF0 != null && cF0.m() == i7 && !cF0.J() && (this.f13173b.f13111r0.e() || !cF0.v())) {
                    return viewI;
                }
            }
            return null;
        }

        public void C0(int i7) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                recyclerView.y0(i7);
            }
        }

        public void C1(Rect rect, int i7, int i8) {
            B1(n(i7, rect.width() + e0() + f0(), c0()), n(i8, rect.height() + g0() + d0(), b0()));
        }

        public abstract p D();

        public void D0(int i7) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                recyclerView.z0(i7);
            }
        }

        public void D1(int i7, int i8) {
            int iJ = J();
            if (iJ == 0) {
                this.f13173b.w(i7, i8);
                return;
            }
            int i9 = Integer.MIN_VALUE;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MIN_VALUE;
            int i12 = Integer.MAX_VALUE;
            for (int i13 = 0; i13 < iJ; i13++) {
                View viewI = I(i13);
                Rect rect = this.f13173b.f13114t;
                P(viewI, rect);
                int i14 = rect.left;
                if (i14 < i12) {
                    i12 = i14;
                }
                int i15 = rect.right;
                if (i15 > i9) {
                    i9 = i15;
                }
                int i16 = rect.top;
                if (i16 < i10) {
                    i10 = i16;
                }
                int i17 = rect.bottom;
                if (i17 > i11) {
                    i11 = i17;
                }
            }
            this.f13173b.f13114t.set(i12, i10, i9, i11);
            C1(this.f13173b.f13114t, i7, i8);
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void E0(g gVar, g gVar2) {
        }

        public void E1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f13173b = null;
                this.f13172a = null;
                this.f13188q = 0;
                this.f13189r = 0;
            } else {
                this.f13173b = recyclerView;
                this.f13172a = recyclerView.f13106p;
                this.f13188q = recyclerView.getWidth();
                this.f13189r = recyclerView.getHeight();
            }
            this.f13186o = 1073741824;
            this.f13187p = 1073741824;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean F0(RecyclerView recyclerView, ArrayList arrayList, int i7, int i8) {
            return false;
        }

        public boolean F1(View view, int i7, int i8, p pVar) {
            return (!view.isLayoutRequested() && this.f13182k && w0(view.getWidth(), i7, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getHeight(), i8, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        public boolean G1() {
            return false;
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).f13197b.bottom;
        }

        public void H0(RecyclerView recyclerView) {
        }

        public boolean H1(View view, int i7, int i8, p pVar) {
            return (this.f13182k && w0(view.getMeasuredWidth(), i7, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getMeasuredHeight(), i8, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View I(int i7) {
            androidx.recyclerview.widget.b bVar = this.f13172a;
            if (bVar != null) {
                return bVar.f(i7);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView, u uVar) {
            H0(recyclerView);
        }

        public void I1(RecyclerView recyclerView, z zVar, int i7) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int J() {
            androidx.recyclerview.widget.b bVar = this.f13172a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View J0(View view, int i7, u uVar, z zVar) {
            return null;
        }

        public void J1(y yVar) {
            y yVar2 = this.f13178g;
            if (yVar2 != null && yVar != yVar2 && yVar2.h()) {
                this.f13178g.r();
            }
            this.f13178g = yVar;
            yVar.q(this.f13173b, this);
        }

        public void K0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f13173b;
            L0(recyclerView.f13100m, recyclerView.f13111r0, accessibilityEvent);
        }

        public void K1() {
            y yVar = this.f13178g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public final int[] L(View view, Rect rect) {
            int iE0 = e0();
            int iG0 = g0();
            int iO0 = o0() - f0();
            int iW = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i7 = left - iE0;
            int iMin = Math.min(0, i7);
            int i8 = top - iG0;
            int iMin2 = Math.min(0, i8);
            int i9 = iWidth - iO0;
            int iMax = Math.max(0, i9);
            int iMax2 = Math.max(0, iHeight - iW);
            if (Z() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i7, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i9);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i8, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        public void L0(u uVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z7 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f13173b.canScrollVertically(-1) && !this.f13173b.canScrollHorizontally(-1) && !this.f13173b.canScrollHorizontally(1)) {
                z7 = false;
            }
            accessibilityEvent.setScrollable(z7);
            g gVar = this.f13173b.f13120w;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.c());
            }
        }

        public boolean L1() {
            return false;
        }

        public boolean M() {
            RecyclerView recyclerView = this.f13173b;
            return recyclerView != null && recyclerView.f13110r;
        }

        public void M0(a0.x xVar) {
            RecyclerView recyclerView = this.f13173b;
            N0(recyclerView.f13100m, recyclerView.f13111r0, xVar);
        }

        public int N(u uVar, z zVar) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView == null || recyclerView.f13120w == null || !k()) {
                return 1;
            }
            return this.f13173b.f13120w.c();
        }

        public void N0(u uVar, z zVar, a0.x xVar) {
            if (this.f13173b.canScrollVertically(-1) || this.f13173b.canScrollHorizontally(-1)) {
                xVar.a(8192);
                xVar.H0(true);
            }
            if (this.f13173b.canScrollVertically(1) || this.f13173b.canScrollHorizontally(1)) {
                xVar.a(4096);
                xVar.H0(true);
            }
            xVar.r0(x.g.a(k0(uVar, zVar), N(uVar, zVar), v0(uVar, zVar), l0(uVar, zVar)));
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        public void O0(View view, a0.x xVar) {
            C cF0 = RecyclerView.f0(view);
            if (cF0 == null || cF0.v() || this.f13172a.n(cF0.f13136a)) {
                return;
            }
            RecyclerView recyclerView = this.f13173b;
            P0(recyclerView.f13100m, recyclerView.f13111r0, view, xVar);
        }

        public void P(View view, Rect rect) {
            RecyclerView.g0(view, rect);
        }

        public void P0(u uVar, z zVar, View view, a0.x xVar) {
            xVar.s0(x.h.a(l() ? h0(view) : 0, 1, k() ? h0(view) : 0, 1, false, false));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        public View Q0(View view, int i7) {
            return null;
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).f13197b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView, int i7, int i8) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f13197b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public int T(View view) {
            return view.getRight() + j0(view);
        }

        public void T0(RecyclerView recyclerView, int i7, int i8, int i9) {
        }

        public int U(View view) {
            return view.getTop() - m0(view);
        }

        public void U0(RecyclerView recyclerView, int i7, int i8) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f13172a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i7, int i8) {
        }

        public int W() {
            return this.f13189r;
        }

        public void W0(RecyclerView recyclerView, int i7, int i8, Object obj) {
            V0(recyclerView, i7, i8);
        }

        public int X() {
            return this.f13187p;
        }

        public void X0(u uVar, z zVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int Y() {
            RecyclerView recyclerView = this.f13173b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void Y0(z zVar) {
        }

        public int Z() {
            return W.A(this.f13173b);
        }

        public void Z0(u uVar, z zVar, int i7, int i8) {
            this.f13173b.w(i7, i8);
        }

        public int a0(View view) {
            return ((p) view.getLayoutParams()).f13197b.left;
        }

        public boolean a1(RecyclerView recyclerView, View view, View view2) {
            return x0() || recyclerView.t0();
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return W.B(this.f13173b);
        }

        public boolean b1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return a1(recyclerView, view, view2);
        }

        public void c(View view, int i7) {
            f(view, i7, true);
        }

        public int c0() {
            return W.C(this.f13173b);
        }

        public void c1(Parcelable parcelable) {
        }

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable d1() {
            return null;
        }

        public void e(View view, int i7) {
            f(view, i7, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void e1(int i7) {
        }

        public final void f(View view, int i7, boolean z7) {
            C cF0 = RecyclerView.f0(view);
            if (z7 || cF0.v()) {
                this.f13173b.f13108q.b(cF0);
            } else {
                this.f13173b.f13108q.p(cF0);
            }
            p pVar = (p) view.getLayoutParams();
            if (cF0.L() || cF0.w()) {
                if (cF0.w()) {
                    cF0.K();
                } else {
                    cF0.e();
                }
                this.f13172a.c(view, i7, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f13173b) {
                int iM = this.f13172a.m(view);
                if (i7 == -1) {
                    i7 = this.f13172a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f13173b.indexOfChild(view) + this.f13173b.P());
                }
                if (iM != i7) {
                    this.f13173b.f13122x.B0(iM, i7);
                }
            } else {
                this.f13172a.a(view, i7, false);
                pVar.f13198c = true;
                y yVar = this.f13178g;
                if (yVar != null && yVar.h()) {
                    this.f13178g.k(view);
                }
            }
            if (pVar.f13199d) {
                cF0.f13136a.invalidate();
                pVar.f13199d = false;
            }
        }

        public int f0() {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void f1(y yVar) {
            if (this.f13178g == yVar) {
                this.f13178g = null;
            }
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                recyclerView.o(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean g1(int i7, Bundle bundle) {
            RecyclerView recyclerView = this.f13173b;
            return h1(recyclerView.f13100m, recyclerView.f13111r0, i7, bundle);
        }

        public void h(View view, int i7) {
            i(view, i7, (p) view.getLayoutParams());
        }

        public int h0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public boolean h1(u uVar, z zVar, int i7, Bundle bundle) {
            int iW;
            int iO0;
            int i8;
            int i9;
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView == null) {
                return false;
            }
            if (i7 == 4096) {
                iW = recyclerView.canScrollVertically(1) ? (W() - g0()) - d0() : 0;
                if (this.f13173b.canScrollHorizontally(1)) {
                    iO0 = (o0() - e0()) - f0();
                    i8 = iW;
                    i9 = iO0;
                }
                i8 = iW;
                i9 = 0;
            } else if (i7 != 8192) {
                i9 = 0;
                i8 = 0;
            } else {
                iW = recyclerView.canScrollVertically(-1) ? -((W() - g0()) - d0()) : 0;
                if (this.f13173b.canScrollHorizontally(-1)) {
                    iO0 = -((o0() - e0()) - f0());
                    i8 = iW;
                    i9 = iO0;
                }
                i8 = iW;
                i9 = 0;
            }
            if (i8 == 0 && i9 == 0) {
                return false;
            }
            this.f13173b.n1(i9, i8, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void i(View view, int i7, p pVar) {
            C cF0 = RecyclerView.f0(view);
            if (cF0.v()) {
                this.f13173b.f13108q.b(cF0);
            } else {
                this.f13173b.f13108q.p(cF0);
            }
            this.f13172a.c(view, i7, pVar, cF0.v());
        }

        public boolean i1(View view, int i7, Bundle bundle) {
            RecyclerView recyclerView = this.f13173b;
            return j1(recyclerView.f13100m, recyclerView.f13111r0, view, i7, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.j0(view));
            }
        }

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f13197b.right;
        }

        public boolean j1(u uVar, z zVar, View view, int i7, Bundle bundle) {
            return false;
        }

        public boolean k() {
            return false;
        }

        public int k0(u uVar, z zVar) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView == null || recyclerView.f13120w == null || !l()) {
                return 1;
            }
            return this.f13173b.f13120w.c();
        }

        public void k1(u uVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                if (!RecyclerView.f0(I(iJ)).J()) {
                    n1(iJ, uVar);
                }
            }
        }

        public boolean l() {
            return false;
        }

        public int l0(u uVar, z zVar) {
            return 0;
        }

        public void l1(u uVar) {
            int iJ = uVar.j();
            for (int i7 = iJ - 1; i7 >= 0; i7--) {
                View viewN = uVar.n(i7);
                C cF0 = RecyclerView.f0(viewN);
                if (!cF0.J()) {
                    cF0.G(false);
                    if (cF0.x()) {
                        this.f13173b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f13173b.f13086W;
                    if (lVar != null) {
                        lVar.j(cF0);
                    }
                    cF0.G(true);
                    uVar.y(viewN);
                }
            }
            uVar.e();
            if (iJ > 0) {
                this.f13173b.invalidate();
            }
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).f13197b.top;
        }

        public void m1(View view, u uVar) {
            p1(view);
            uVar.B(view);
        }

        public void n0(View view, boolean z7, Rect rect) {
            Matrix matrix;
            if (z7) {
                Rect rect2 = ((p) view.getLayoutParams()).f13197b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f13173b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f13173b.f13118v;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n1(int i7, u uVar) {
            View viewI = I(i7);
            q1(i7);
            uVar.B(viewI);
        }

        public void o(int i7, int i8, z zVar, c cVar) {
        }

        public int o0() {
            return this.f13188q;
        }

        public boolean o1(Runnable runnable) {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void p(int i7, c cVar) {
        }

        public int p0() {
            return this.f13186o;
        }

        public void p1(View view) {
            this.f13172a.p(view);
        }

        public int q(z zVar) {
            return 0;
        }

        public boolean q0() {
            int iJ = J();
            for (int i7 = 0; i7 < iJ; i7++) {
                ViewGroup.LayoutParams layoutParams = I(i7).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void q1(int i7) {
            if (I(i7) != null) {
                this.f13172a.q(i7);
            }
        }

        public int r(z zVar) {
            return 0;
        }

        public boolean r0() {
            return this.f13180i;
        }

        public boolean r1(RecyclerView recyclerView, View view, Rect rect, boolean z7) {
            return s1(recyclerView, view, rect, z7, false);
        }

        public int s(z zVar) {
            return 0;
        }

        public boolean s0() {
            return this.f13181j;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z7, boolean z8) {
            int[] iArrL = L(view, rect);
            int i7 = iArrL[0];
            int i8 = iArrL[1];
            if ((z8 && !t0(recyclerView, i7, i8)) || (i7 == 0 && i8 == 0)) {
                return false;
            }
            if (z7) {
                recyclerView.scrollBy(i7, i8);
            } else {
                recyclerView.k1(i7, i8);
            }
            return true;
        }

        public int t(z zVar) {
            return 0;
        }

        public final boolean t0(RecyclerView recyclerView, int i7, int i8) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iE0 = e0();
            int iG0 = g0();
            int iO0 = o0() - f0();
            int iW = W() - d0();
            Rect rect = this.f13173b.f13114t;
            P(focusedChild, rect);
            return rect.left - i7 < iO0 && rect.right - i7 > iE0 && rect.top - i8 < iW && rect.bottom - i8 > iG0;
        }

        public void t1() {
            RecyclerView recyclerView = this.f13173b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int u(z zVar) {
            return 0;
        }

        public final boolean u0() {
            return this.f13183l;
        }

        public void u1() {
            this.f13179h = true;
        }

        public int v(z zVar) {
            return 0;
        }

        public boolean v0(u uVar, z zVar) {
            return false;
        }

        public final void v1(u uVar, int i7, View view) {
            C cF0 = RecyclerView.f0(view);
            if (cF0.J()) {
                return;
            }
            if (cF0.t() && !cF0.v() && !this.f13173b.f13120w.g()) {
                q1(i7);
                uVar.C(cF0);
            } else {
                x(i7);
                uVar.D(view);
                this.f13173b.f13108q.k(cF0);
            }
        }

        public void w(u uVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                v1(uVar, iJ, I(iJ));
            }
        }

        public int w1(int i7, u uVar, z zVar) {
            return 0;
        }

        public void x(int i7) {
            y(i7, I(i7));
        }

        public boolean x0() {
            y yVar = this.f13178g;
            return yVar != null && yVar.h();
        }

        public void x1(int i7) {
        }

        public final void y(int i7, View view) {
            this.f13172a.d(i7);
        }

        public boolean y0(View view, boolean z7, boolean z8) {
            boolean z9 = this.f13176e.b(view, 24579) && this.f13177f.b(view, 24579);
            return z7 ? z9 : !z9;
        }

        public int y1(int i7, u uVar, z zVar) {
            return 0;
        }

        public void z(RecyclerView recyclerView) {
            this.f13180i = true;
            G0(recyclerView);
        }

        public void z0(View view, int i7, int i8, int i9, int i10) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f13197b;
            view.layout(i7 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i8 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i9 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i10 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
    }

    public static abstract class q {
        public abstract boolean a(int i7, int i8);
    }

    public interface r {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z7);
    }

    public static abstract class s {
        public void a(RecyclerView recyclerView, int i7) {
        }

        public void b(RecyclerView recyclerView, int i7, int i8) {
        }
    }

    public static class t {

        /* renamed from: a, reason: collision with root package name */
        public SparseArray f13200a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        public int f13201b = 0;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ArrayList f13202a = new ArrayList();

            /* renamed from: b, reason: collision with root package name */
            public int f13203b = 5;

            /* renamed from: c, reason: collision with root package name */
            public long f13204c = 0;

            /* renamed from: d, reason: collision with root package name */
            public long f13205d = 0;
        }

        public void a() {
            this.f13201b++;
        }

        public void b() {
            for (int i7 = 0; i7 < this.f13200a.size(); i7++) {
                ((a) this.f13200a.valueAt(i7)).f13202a.clear();
            }
        }

        public void c() {
            this.f13201b--;
        }

        public void d(int i7, long j7) {
            a aVarG = g(i7);
            aVarG.f13205d = j(aVarG.f13205d, j7);
        }

        public void e(int i7, long j7) {
            a aVarG = g(i7);
            aVarG.f13204c = j(aVarG.f13204c, j7);
        }

        public C f(int i7) {
            a aVar = (a) this.f13200a.get(i7);
            if (aVar == null || aVar.f13202a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f13202a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((C) arrayList.get(size)).r()) {
                    return (C) arrayList.remove(size);
                }
            }
            return null;
        }

        public final a g(int i7) {
            a aVar = (a) this.f13200a.get(i7);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f13200a.put(i7, aVar2);
            return aVar2;
        }

        public void h(g gVar, g gVar2, boolean z7) {
            if (gVar != null) {
                c();
            }
            if (!z7 && this.f13201b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(C c7) {
            int iL = c7.l();
            ArrayList arrayList = g(iL).f13202a;
            if (((a) this.f13200a.get(iL)).f13203b <= arrayList.size()) {
                return;
            }
            c7.D();
            arrayList.add(c7);
        }

        public long j(long j7, long j8) {
            return j7 == 0 ? j8 : ((j7 / 4) * 3) + (j8 / 4);
        }

        public boolean k(int i7, long j7, long j8) {
            long j9 = g(i7).f13205d;
            return j9 == 0 || j7 + j9 < j8;
        }

        public boolean l(int i7, long j7, long j8) {
            long j9 = g(i7).f13204c;
            return j9 == 0 || j7 + j9 < j8;
        }
    }

    public final class u {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f13206a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f13207b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f13208c;

        /* renamed from: d, reason: collision with root package name */
        public final List f13209d;

        /* renamed from: e, reason: collision with root package name */
        public int f13210e;

        /* renamed from: f, reason: collision with root package name */
        public int f13211f;

        /* renamed from: g, reason: collision with root package name */
        public t f13212g;

        /* renamed from: h, reason: collision with root package name */
        public A f13213h;

        public u() {
            ArrayList arrayList = new ArrayList();
            this.f13206a = arrayList;
            this.f13207b = null;
            this.f13208c = new ArrayList();
            this.f13209d = Collections.unmodifiableList(arrayList);
            this.f13210e = 2;
            this.f13211f = 2;
        }

        public void A(int i7) {
            a((C) this.f13208c.get(i7), true);
            this.f13208c.remove(i7);
        }

        public void B(View view) {
            C cF0 = RecyclerView.f0(view);
            if (cF0.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (cF0.w()) {
                cF0.K();
            } else if (cF0.L()) {
                cF0.e();
            }
            C(cF0);
            if (RecyclerView.this.f13086W == null || cF0.u()) {
                return;
            }
            RecyclerView.this.f13086W.j(cF0);
        }

        public void C(C c7) {
            boolean z7;
            boolean z8 = true;
            if (c7.w() || c7.f13136a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c7.w());
                sb.append(" isAttached:");
                sb.append(c7.f13136a.getParent() != null);
                sb.append(RecyclerView.this.P());
                throw new IllegalArgumentException(sb.toString());
            }
            if (c7.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c7 + RecyclerView.this.P());
            }
            if (c7.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.P());
            }
            boolean zH = c7.h();
            g gVar = RecyclerView.this.f13120w;
            if ((gVar != null && zH && gVar.m(c7)) || c7.u()) {
                if (this.f13211f <= 0 || c7.p(526)) {
                    z7 = false;
                } else {
                    int size = this.f13208c.size();
                    if (size >= this.f13211f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.f13052L0 && size > 0 && !RecyclerView.this.f13109q0.d(c7.f13138c)) {
                        int i7 = size - 1;
                        while (i7 >= 0) {
                            if (!RecyclerView.this.f13109q0.d(((C) this.f13208c.get(i7)).f13138c)) {
                                break;
                            } else {
                                i7--;
                            }
                        }
                        size = i7 + 1;
                    }
                    this.f13208c.add(size, c7);
                    z7 = true;
                }
                if (z7) {
                    z8 = false;
                } else {
                    a(c7, true);
                }
                z = z7;
            } else {
                z8 = false;
            }
            RecyclerView.this.f13108q.q(c7);
            if (z || z8 || !zH) {
                return;
            }
            c7.f13153r = null;
        }

        public void D(View view) {
            C cF0 = RecyclerView.f0(view);
            if (!cF0.p(12) && cF0.y() && !RecyclerView.this.p(cF0)) {
                if (this.f13207b == null) {
                    this.f13207b = new ArrayList();
                }
                cF0.H(this, true);
                this.f13207b.add(cF0);
                return;
            }
            if (!cF0.t() || cF0.v() || RecyclerView.this.f13120w.g()) {
                cF0.H(this, false);
                this.f13206a.add(cF0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.P());
            }
        }

        public void E(t tVar) {
            t tVar2 = this.f13212g;
            if (tVar2 != null) {
                tVar2.c();
            }
            this.f13212g = tVar;
            if (tVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f13212g.a();
        }

        public void F(A a7) {
            this.f13213h = a7;
        }

        public void G(int i7) {
            this.f13210e = i7;
            K();
        }

        public final boolean H(C c7, int i7, int i8, long j7) {
            c7.f13153r = RecyclerView.this;
            int iL = c7.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j7 != Long.MAX_VALUE && !this.f13212g.k(iL, nanoTime, j7)) {
                return false;
            }
            RecyclerView.this.f13120w.a(c7, i7);
            this.f13212g.d(c7.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(c7);
            if (!RecyclerView.this.f13111r0.e()) {
                return true;
            }
            c7.f13142g = i8;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x0220 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0223  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x019f  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x01f6  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0204  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.C I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 607
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$C");
        }

        public void J(C c7) {
            if (c7.f13150o) {
                this.f13207b.remove(c7);
            } else {
                this.f13206a.remove(c7);
            }
            c7.f13149n = null;
            c7.f13150o = false;
            c7.e();
        }

        public void K() {
            o oVar = RecyclerView.this.f13122x;
            this.f13211f = this.f13210e + (oVar != null ? oVar.f13184m : 0);
            for (int size = this.f13208c.size() - 1; size >= 0 && this.f13208c.size() > this.f13211f; size--) {
                A(size);
            }
        }

        public boolean L(C c7) {
            if (c7.v()) {
                return RecyclerView.this.f13111r0.e();
            }
            int i7 = c7.f13138c;
            if (i7 >= 0 && i7 < RecyclerView.this.f13120w.c()) {
                if (RecyclerView.this.f13111r0.e() || RecyclerView.this.f13120w.e(c7.f13138c) == c7.l()) {
                    return !RecyclerView.this.f13120w.g() || c7.k() == RecyclerView.this.f13120w.d(c7.f13138c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c7 + RecyclerView.this.P());
        }

        public void M(int i7, int i8) {
            int i9;
            int i10 = i8 + i7;
            for (int size = this.f13208c.size() - 1; size >= 0; size--) {
                C c7 = (C) this.f13208c.get(size);
                if (c7 != null && (i9 = c7.f13138c) >= i7 && i9 < i10) {
                    c7.b(2);
                    A(size);
                }
            }
        }

        public void a(C c7, boolean z7) {
            RecyclerView.r(c7);
            View view = c7.f13136a;
            androidx.recyclerview.widget.k kVar = RecyclerView.this.f13125y0;
            if (kVar != null) {
                C0682a c0682aN = kVar.n();
                W.l0(view, c0682aN instanceof k.a ? ((k.a) c0682aN).n(view) : null);
            }
            if (z7) {
                g(c7);
            }
            c7.f13153r = null;
            i().i(c7);
        }

        public final void b(C c7) {
            if (RecyclerView.this.s0()) {
                View view = c7.f13136a;
                if (W.y(view) == 0) {
                    W.v0(view, 1);
                }
                androidx.recyclerview.widget.k kVar = RecyclerView.this.f13125y0;
                if (kVar == null) {
                    return;
                }
                C0682a c0682aN = kVar.n();
                if (c0682aN instanceof k.a) {
                    ((k.a) c0682aN).o(view);
                }
                W.l0(view, c0682aN);
            }
        }

        public void c() {
            this.f13206a.clear();
            z();
        }

        public void d() {
            int size = this.f13208c.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((C) this.f13208c.get(i7)).c();
            }
            int size2 = this.f13206a.size();
            for (int i8 = 0; i8 < size2; i8++) {
                ((C) this.f13206a.get(i8)).c();
            }
            ArrayList arrayList = this.f13207b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i9 = 0; i9 < size3; i9++) {
                    ((C) this.f13207b.get(i9)).c();
                }
            }
        }

        public void e() {
            this.f13206a.clear();
            ArrayList arrayList = this.f13207b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i7) {
            if (i7 >= 0 && i7 < RecyclerView.this.f13111r0.b()) {
                return !RecyclerView.this.f13111r0.e() ? i7 : RecyclerView.this.f13104o.m(i7);
            }
            throw new IndexOutOfBoundsException("invalid position " + i7 + ". State item count is " + RecyclerView.this.f13111r0.b() + RecyclerView.this.P());
        }

        public void g(C c7) {
            RecyclerView.this.getClass();
            g gVar = RecyclerView.this.f13120w;
            if (gVar != null) {
                gVar.p(c7);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f13111r0 != null) {
                recyclerView.f13108q.q(c7);
            }
        }

        public C h(int i7) {
            int size;
            int iM;
            ArrayList arrayList = this.f13207b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i8 = 0; i8 < size; i8++) {
                    C c7 = (C) this.f13207b.get(i8);
                    if (!c7.L() && c7.m() == i7) {
                        c7.b(32);
                        return c7;
                    }
                }
                if (RecyclerView.this.f13120w.g() && (iM = RecyclerView.this.f13104o.m(i7)) > 0 && iM < RecyclerView.this.f13120w.c()) {
                    long jD = RecyclerView.this.f13120w.d(iM);
                    for (int i9 = 0; i9 < size; i9++) {
                        C c8 = (C) this.f13207b.get(i9);
                        if (!c8.L() && c8.k() == jD) {
                            c8.b(32);
                            return c8;
                        }
                    }
                }
            }
            return null;
        }

        public t i() {
            if (this.f13212g == null) {
                this.f13212g = new t();
            }
            return this.f13212g;
        }

        public int j() {
            return this.f13206a.size();
        }

        public List k() {
            return this.f13209d;
        }

        public C l(long j7, int i7, boolean z7) {
            for (int size = this.f13206a.size() - 1; size >= 0; size--) {
                C c7 = (C) this.f13206a.get(size);
                if (c7.k() == j7 && !c7.L()) {
                    if (i7 == c7.l()) {
                        c7.b(32);
                        if (c7.v() && !RecyclerView.this.f13111r0.e()) {
                            c7.F(2, 14);
                        }
                        return c7;
                    }
                    if (!z7) {
                        this.f13206a.remove(size);
                        RecyclerView.this.removeDetachedView(c7.f13136a, false);
                        y(c7.f13136a);
                    }
                }
            }
            int size2 = this.f13208c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C c8 = (C) this.f13208c.get(size2);
                if (c8.k() == j7 && !c8.r()) {
                    if (i7 == c8.l()) {
                        if (!z7) {
                            this.f13208c.remove(size2);
                        }
                        return c8;
                    }
                    if (!z7) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        public C m(int i7, boolean z7) {
            View viewE;
            int size = this.f13206a.size();
            for (int i8 = 0; i8 < size; i8++) {
                C c7 = (C) this.f13206a.get(i8);
                if (!c7.L() && c7.m() == i7 && !c7.t() && (RecyclerView.this.f13111r0.f13239h || !c7.v())) {
                    c7.b(32);
                    return c7;
                }
            }
            if (z7 || (viewE = RecyclerView.this.f13106p.e(i7)) == null) {
                int size2 = this.f13208c.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    C c8 = (C) this.f13208c.get(i9);
                    if (!c8.t() && c8.m() == i7 && !c8.r()) {
                        if (!z7) {
                            this.f13208c.remove(i9);
                        }
                        return c8;
                    }
                }
                return null;
            }
            C cF0 = RecyclerView.f0(viewE);
            RecyclerView.this.f13106p.s(viewE);
            int iM = RecyclerView.this.f13106p.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f13106p.d(iM);
                D(viewE);
                cF0.b(8224);
                return cF0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + cF0 + RecyclerView.this.P());
        }

        public View n(int i7) {
            return ((C) this.f13206a.get(i7)).f13136a;
        }

        public View o(int i7) {
            return p(i7, false);
        }

        public View p(int i7, boolean z7) {
            return I(i7, z7, Long.MAX_VALUE).f13136a;
        }

        public final void q(ViewGroup viewGroup, boolean z7) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z7) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void r(C c7) {
            View view = c7.f13136a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.f13208c.size();
            for (int i7 = 0; i7 < size; i7++) {
                p pVar = (p) ((C) this.f13208c.get(i7)).f13136a.getLayoutParams();
                if (pVar != null) {
                    pVar.f13198c = true;
                }
            }
        }

        public void t() {
            int size = this.f13208c.size();
            for (int i7 = 0; i7 < size; i7++) {
                C c7 = (C) this.f13208c.get(i7);
                if (c7 != null) {
                    c7.b(6);
                    c7.a(null);
                }
            }
            g gVar = RecyclerView.this.f13120w;
            if (gVar == null || !gVar.g()) {
                z();
            }
        }

        public void u(int i7, int i8) {
            int size = this.f13208c.size();
            for (int i9 = 0; i9 < size; i9++) {
                C c7 = (C) this.f13208c.get(i9);
                if (c7 != null && c7.f13138c >= i7) {
                    c7.A(i8, true);
                }
            }
        }

        public void v(int i7, int i8) {
            int i9;
            int i10;
            int i11;
            int i12;
            if (i7 < i8) {
                i9 = -1;
                i11 = i7;
                i10 = i8;
            } else {
                i9 = 1;
                i10 = i7;
                i11 = i8;
            }
            int size = this.f13208c.size();
            for (int i13 = 0; i13 < size; i13++) {
                C c7 = (C) this.f13208c.get(i13);
                if (c7 != null && (i12 = c7.f13138c) >= i11 && i12 <= i10) {
                    if (i12 == i7) {
                        c7.A(i8 - i7, false);
                    } else {
                        c7.A(i9, false);
                    }
                }
            }
        }

        public void w(int i7, int i8, boolean z7) {
            int i9 = i7 + i8;
            for (int size = this.f13208c.size() - 1; size >= 0; size--) {
                C c7 = (C) this.f13208c.get(size);
                if (c7 != null) {
                    int i10 = c7.f13138c;
                    if (i10 >= i9) {
                        c7.A(-i8, z7);
                    } else if (i10 >= i7) {
                        c7.b(8);
                        A(size);
                    }
                }
            }
        }

        public void x(g gVar, g gVar2, boolean z7) {
            c();
            i().h(gVar, gVar2, z7);
        }

        public void y(View view) {
            C cF0 = RecyclerView.f0(view);
            cF0.f13149n = null;
            cF0.f13150o = false;
            cF0.e();
            C(cF0);
        }

        public void z() {
            for (int size = this.f13208c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f13208c.clear();
            if (RecyclerView.f13052L0) {
                RecyclerView.this.f13109q0.b();
            }
        }
    }

    public interface v {
    }

    public class w extends i {
        public w() {
        }
    }

    public static abstract class y {

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f13218b;

        /* renamed from: c, reason: collision with root package name */
        public o f13219c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f13220d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f13221e;

        /* renamed from: f, reason: collision with root package name */
        public View f13222f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f13224h;

        /* renamed from: a, reason: collision with root package name */
        public int f13217a = -1;

        /* renamed from: g, reason: collision with root package name */
        public final a f13223g = new a(0, 0);

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f13225a;

            /* renamed from: b, reason: collision with root package name */
            public int f13226b;

            /* renamed from: c, reason: collision with root package name */
            public int f13227c;

            /* renamed from: d, reason: collision with root package name */
            public int f13228d;

            /* renamed from: e, reason: collision with root package name */
            public Interpolator f13229e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f13230f;

            /* renamed from: g, reason: collision with root package name */
            public int f13231g;

            public a(int i7, int i8) {
                this(i7, i8, Integer.MIN_VALUE, null);
            }

            public boolean a() {
                return this.f13228d >= 0;
            }

            public void b(int i7) {
                this.f13228d = i7;
            }

            public void c(RecyclerView recyclerView) {
                int i7 = this.f13228d;
                if (i7 >= 0) {
                    this.f13228d = -1;
                    recyclerView.v0(i7);
                    this.f13230f = false;
                } else {
                    if (!this.f13230f) {
                        this.f13231g = 0;
                        return;
                    }
                    e();
                    recyclerView.f13105o0.f(this.f13225a, this.f13226b, this.f13227c, this.f13229e);
                    int i8 = this.f13231g + 1;
                    this.f13231g = i8;
                    if (i8 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f13230f = false;
                }
            }

            public void d(int i7, int i8, int i9, Interpolator interpolator) {
                this.f13225a = i7;
                this.f13226b = i8;
                this.f13227c = i9;
                this.f13229e = interpolator;
                this.f13230f = true;
            }

            public final void e() {
                if (this.f13229e != null && this.f13227c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f13227c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public a(int i7, int i8, int i9, Interpolator interpolator) {
                this.f13228d = -1;
                this.f13230f = false;
                this.f13231g = 0;
                this.f13225a = i7;
                this.f13226b = i8;
                this.f13227c = i9;
                this.f13229e = interpolator;
            }
        }

        public interface b {
            PointF a(int i7);
        }

        public PointF a(int i7) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).a(i7);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i7) {
            return this.f13218b.f13122x.C(i7);
        }

        public int c() {
            return this.f13218b.f13122x.J();
        }

        public int d(View view) {
            return this.f13218b.d0(view);
        }

        public o e() {
            return this.f13219c;
        }

        public int f() {
            return this.f13217a;
        }

        public boolean g() {
            return this.f13220d;
        }

        public boolean h() {
            return this.f13221e;
        }

        public void i(PointF pointF) {
            float f7 = pointF.x;
            float f8 = pointF.y;
            float fSqrt = (float) Math.sqrt((f7 * f7) + (f8 * f8));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void j(int i7, int i8) {
            PointF pointFA;
            RecyclerView recyclerView = this.f13218b;
            if (this.f13217a == -1 || recyclerView == null) {
                r();
            }
            if (this.f13220d && this.f13222f == null && this.f13219c != null && (pointFA = a(this.f13217a)) != null) {
                float f7 = pointFA.x;
                if (f7 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.f1((int) Math.signum(f7), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f13220d = false;
            View view = this.f13222f;
            if (view != null) {
                if (d(view) == this.f13217a) {
                    o(this.f13222f, recyclerView.f13111r0, this.f13223g);
                    this.f13223g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f13222f = null;
                }
            }
            if (this.f13221e) {
                l(i7, i8, recyclerView.f13111r0, this.f13223g);
                boolean zA = this.f13223g.a();
                this.f13223g.c(recyclerView);
                if (zA && this.f13221e) {
                    this.f13220d = true;
                    recyclerView.f13105o0.e();
                }
            }
        }

        public void k(View view) {
            if (d(view) == f()) {
                this.f13222f = view;
            }
        }

        public abstract void l(int i7, int i8, z zVar, a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(View view, z zVar, a aVar);

        public void p(int i7) {
            this.f13217a = i7;
        }

        public void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f13105o0.g();
            if (this.f13224h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f13218b = recyclerView;
            this.f13219c = oVar;
            int i7 = this.f13217a;
            if (i7 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f13111r0.f13232a = i7;
            this.f13221e = true;
            this.f13220d = true;
            this.f13222f = b(f());
            m();
            this.f13218b.f13105o0.e();
            this.f13224h = true;
        }

        public final void r() {
            if (this.f13221e) {
                this.f13221e = false;
                n();
                this.f13218b.f13111r0.f13232a = -1;
                this.f13222f = null;
                this.f13217a = -1;
                this.f13220d = false;
                this.f13219c.f1(this);
                this.f13219c = null;
                this.f13218b = null;
            }
        }
    }

    public static class z {

        /* renamed from: b, reason: collision with root package name */
        public SparseArray f13233b;

        /* renamed from: m, reason: collision with root package name */
        public int f13244m;

        /* renamed from: n, reason: collision with root package name */
        public long f13245n;

        /* renamed from: o, reason: collision with root package name */
        public int f13246o;

        /* renamed from: p, reason: collision with root package name */
        public int f13247p;

        /* renamed from: q, reason: collision with root package name */
        public int f13248q;

        /* renamed from: a, reason: collision with root package name */
        public int f13232a = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f13234c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f13235d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f13236e = 1;

        /* renamed from: f, reason: collision with root package name */
        public int f13237f = 0;

        /* renamed from: g, reason: collision with root package name */
        public boolean f13238g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f13239h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f13240i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f13241j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f13242k = false;

        /* renamed from: l, reason: collision with root package name */
        public boolean f13243l = false;

        public void a(int i7) {
            if ((this.f13236e & i7) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i7) + " but it is " + Integer.toBinaryString(this.f13236e));
        }

        public int b() {
            return this.f13239h ? this.f13234c - this.f13235d : this.f13237f;
        }

        public int c() {
            return this.f13232a;
        }

        public boolean d() {
            return this.f13232a != -1;
        }

        public boolean e() {
            return this.f13239h;
        }

        public void f(g gVar) {
            this.f13236e = 1;
            this.f13237f = gVar.c();
            this.f13239h = false;
            this.f13240i = false;
            this.f13241j = false;
        }

        public boolean g() {
            return this.f13243l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f13232a + ", mData=" + this.f13233b + ", mItemCount=" + this.f13237f + ", mIsMeasuring=" + this.f13241j + ", mPreviousLayoutItemCount=" + this.f13234c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f13235d + ", mStructureChanged=" + this.f13238g + ", mInPreLayout=" + this.f13239h + ", mRunSimpleAnimations=" + this.f13242k + ", mRunPredictiveAnimations=" + this.f13243l + '}';
        }
    }

    static {
        Class cls = Integer.TYPE;
        f13055O0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f13056P0 = new InterpolatorC0815c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, T1.a.f8216a);
    }

    public static RecyclerView V(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            RecyclerView recyclerViewV = V(viewGroup.getChildAt(i7));
            if (recyclerViewV != null) {
                return recyclerViewV;
            }
        }
        return null;
    }

    public static C f0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f13196a;
    }

    public static void g0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f13197b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private E getScrollingChildHelper() {
        if (this.f13058A0 == null) {
            this.f13058A0 = new E(this);
        }
        return this.f13058A0;
    }

    public static void r(C c7) {
        WeakReference weakReference = c7.f13137b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == c7.f13136a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            c7.f13137b = null;
        }
    }

    public final void A() {
        int i7 = this.f13073J;
        this.f13073J = 0;
        if (i7 == 0 || !s0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AbstractC0745b.b(accessibilityEventObtain, i7);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public void A0(int i7, int i8) {
        int iJ = this.f13106p.j();
        for (int i9 = 0; i9 < iJ; i9++) {
            C cF0 = f0(this.f13106p.i(i9));
            if (cF0 != null && !cF0.J() && cF0.f13138c >= i7) {
                cF0.A(i8, false);
                this.f13111r0.f13238g = true;
            }
        }
        this.f13100m.u(i7, i8);
        requestLayout();
    }

    public void B() {
        if (this.f13120w == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f13122x == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        z zVar = this.f13111r0;
        zVar.f13241j = false;
        if (zVar.f13236e == 1) {
            C();
            this.f13122x.z1(this);
            D();
        } else if (!this.f13104o.q() && this.f13122x.o0() == getWidth() && this.f13122x.W() == getHeight()) {
            this.f13122x.z1(this);
        } else {
            this.f13122x.z1(this);
            D();
        }
        E();
    }

    public void B0(int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int iJ = this.f13106p.j();
        if (i7 < i8) {
            i11 = -1;
            i10 = i7;
            i9 = i8;
        } else {
            i9 = i7;
            i10 = i8;
            i11 = 1;
        }
        for (int i13 = 0; i13 < iJ; i13++) {
            C cF0 = f0(this.f13106p.i(i13));
            if (cF0 != null && (i12 = cF0.f13138c) >= i10 && i12 <= i9) {
                if (i12 == i7) {
                    cF0.A(i8 - i7, false);
                } else {
                    cF0.A(i11, false);
                }
                this.f13111r0.f13238g = true;
            }
        }
        this.f13100m.v(i7, i8);
        requestLayout();
    }

    public final void C() {
        this.f13111r0.a(1);
        Q(this.f13111r0);
        this.f13111r0.f13241j = false;
        p1();
        this.f13108q.f();
        F0();
        N0();
        c1();
        z zVar = this.f13111r0;
        zVar.f13240i = zVar.f13242k && this.f13119v0;
        this.f13119v0 = false;
        this.f13117u0 = false;
        zVar.f13239h = zVar.f13243l;
        zVar.f13237f = this.f13120w.c();
        U(this.f13127z0);
        if (this.f13111r0.f13242k) {
            int iG = this.f13106p.g();
            for (int i7 = 0; i7 < iG; i7++) {
                C cF0 = f0(this.f13106p.f(i7));
                if (!cF0.J() && (!cF0.t() || this.f13120w.g())) {
                    this.f13108q.e(cF0, this.f13086W.t(this.f13111r0, cF0, l.e(cF0), cF0.o()));
                    if (this.f13111r0.f13240i && cF0.y() && !cF0.v() && !cF0.J() && !cF0.t()) {
                        this.f13108q.c(c0(cF0), cF0);
                    }
                }
            }
        }
        if (this.f13111r0.f13243l) {
            d1();
            z zVar2 = this.f13111r0;
            boolean z7 = zVar2.f13238g;
            zVar2.f13238g = false;
            this.f13122x.X0(this.f13100m, zVar2);
            this.f13111r0.f13238g = z7;
            for (int i8 = 0; i8 < this.f13106p.g(); i8++) {
                C cF02 = f0(this.f13106p.f(i8));
                if (!cF02.J() && !this.f13108q.i(cF02)) {
                    int iE = l.e(cF02);
                    boolean zP = cF02.p(8192);
                    if (!zP) {
                        iE |= 4096;
                    }
                    l.b bVarT = this.f13086W.t(this.f13111r0, cF02, iE, cF02.o());
                    if (zP) {
                        Q0(cF02, bVarT);
                    } else {
                        this.f13108q.a(cF02, bVarT);
                    }
                }
            }
            s();
        } else {
            s();
        }
        G0();
        r1(false);
        this.f13111r0.f13236e = 2;
    }

    public void C0(int i7, int i8, boolean z7) {
        int i9 = i7 + i8;
        int iJ = this.f13106p.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            C cF0 = f0(this.f13106p.i(i10));
            if (cF0 != null && !cF0.J()) {
                int i11 = cF0.f13138c;
                if (i11 >= i9) {
                    cF0.A(-i8, z7);
                    this.f13111r0.f13238g = true;
                } else if (i11 >= i7) {
                    cF0.i(i7 - 1, -i8, z7);
                    this.f13111r0.f13238g = true;
                }
            }
        }
        this.f13100m.w(i7, i8, z7);
        requestLayout();
    }

    public final void D() {
        p1();
        F0();
        this.f13111r0.a(6);
        this.f13104o.j();
        this.f13111r0.f13237f = this.f13120w.c();
        z zVar = this.f13111r0;
        zVar.f13235d = 0;
        zVar.f13239h = false;
        this.f13122x.X0(this.f13100m, zVar);
        z zVar2 = this.f13111r0;
        zVar2.f13238g = false;
        this.f13102n = null;
        zVar2.f13242k = zVar2.f13242k && this.f13086W != null;
        zVar2.f13236e = 4;
        G0();
        r1(false);
    }

    public void D0(View view) {
    }

    public final void E() {
        RecyclerView recyclerView;
        this.f13111r0.a(4);
        p1();
        F0();
        z zVar = this.f13111r0;
        zVar.f13236e = 1;
        if (zVar.f13242k) {
            for (int iG = this.f13106p.g() - 1; iG >= 0; iG--) {
                C cF0 = f0(this.f13106p.f(iG));
                if (!cF0.J()) {
                    long jC0 = c0(cF0);
                    l.b bVarS = this.f13086W.s(this.f13111r0, cF0);
                    C cG = this.f13108q.g(jC0);
                    if (cG == null || cG.J()) {
                        this.f13108q.d(cF0, bVarS);
                    } else {
                        boolean zH = this.f13108q.h(cG);
                        boolean zH2 = this.f13108q.h(cF0);
                        if (zH && cG == cF0) {
                            this.f13108q.d(cF0, bVarS);
                        } else {
                            l.b bVarN = this.f13108q.n(cG);
                            this.f13108q.d(cF0, bVarS);
                            l.b bVarM = this.f13108q.m(cF0);
                            if (bVarN == null) {
                                k0(jC0, cF0, cG);
                            } else {
                                m(cG, cF0, bVarN, bVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            recyclerView = this;
            recyclerView.f13108q.o(recyclerView.f13070G0);
        } else {
            recyclerView = this;
        }
        recyclerView.f13122x.l1(recyclerView.f13100m);
        z zVar2 = recyclerView.f13111r0;
        zVar2.f13234c = zVar2.f13237f;
        recyclerView.f13077N = false;
        recyclerView.f13078O = false;
        zVar2.f13242k = false;
        zVar2.f13243l = false;
        recyclerView.f13122x.f13179h = false;
        ArrayList arrayList = recyclerView.f13100m.f13207b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = recyclerView.f13122x;
        if (oVar.f13185n) {
            oVar.f13184m = 0;
            oVar.f13185n = false;
            recyclerView.f13100m.K();
        }
        recyclerView.f13122x.Y0(recyclerView.f13111r0);
        G0();
        r1(false);
        recyclerView.f13108q.f();
        int[] iArr = recyclerView.f13127z0;
        if (x(iArr[0], iArr[1])) {
            I(0, 0);
        }
        R0();
        a1();
    }

    public void E0(View view) {
    }

    public boolean F(int i7, int i8, int[] iArr, int[] iArr2, int i9) {
        return getScrollingChildHelper().d(i7, i8, iArr, iArr2, i9);
    }

    public void F0() {
        this.f13079P++;
    }

    public final void G(int i7, int i8, int i9, int i10, int[] iArr, int i11, int[] iArr2) {
        getScrollingChildHelper().e(i7, i8, i9, i10, iArr, i11, iArr2);
    }

    public void G0() {
        H0(true);
    }

    public void H(int i7) {
        o oVar = this.f13122x;
        if (oVar != null) {
            oVar.e1(i7);
        }
        J0(i7);
        s sVar = this.f13113s0;
        if (sVar != null) {
            sVar.a(this, i7);
        }
        List list = this.f13115t0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.f13115t0.get(size)).a(this, i7);
            }
        }
    }

    public void H0(boolean z7) {
        int i7 = this.f13079P - 1;
        this.f13079P = i7;
        if (i7 < 1) {
            this.f13079P = 0;
            if (z7) {
                A();
                J();
            }
        }
    }

    public void I(int i7, int i8) {
        this.f13080Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i7, scrollY - i8);
        K0(i7, i8);
        s sVar = this.f13113s0;
        if (sVar != null) {
            sVar.b(this, i7, i8);
        }
        List list = this.f13115t0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.f13115t0.get(size)).b(this, i7, i8);
            }
        }
        this.f13080Q--;
    }

    public final void I0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f13088b0) {
            int i7 = actionIndex == 0 ? 1 : 0;
            this.f13088b0 = motionEvent.getPointerId(i7);
            int x7 = (int) (motionEvent.getX(i7) + 0.5f);
            this.f13092f0 = x7;
            this.f13090d0 = x7;
            int y7 = (int) (motionEvent.getY(i7) + 0.5f);
            this.f13093g0 = y7;
            this.f13091e0 = y7;
        }
    }

    public void J() {
        int i7;
        for (int size = this.f13066E0.size() - 1; size >= 0; size--) {
            C c7 = (C) this.f13066E0.get(size);
            if (c7.f13136a.getParent() == this && !c7.J() && (i7 = c7.f13152q) != -1) {
                W.v0(c7.f13136a, i7);
                c7.f13152q = -1;
            }
        }
        this.f13066E0.clear();
    }

    public void J0(int i7) {
    }

    public final boolean K(MotionEvent motionEvent) {
        r rVar = this.f13057A;
        if (rVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return T(motionEvent);
        }
        rVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f13057A = null;
        }
        return true;
    }

    public void K0(int i7, int i8) {
    }

    public void L() {
        if (this.f13085V != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f13081R.a(this, 3);
        this.f13085V = edgeEffectA;
        if (this.f13110r) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void L0() {
        if (this.f13123x0 || !this.f13059B) {
            return;
        }
        W.d0(this, this.f13068F0);
        this.f13123x0 = true;
    }

    public void M() {
        if (this.f13082S != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f13081R.a(this, 0);
        this.f13082S = edgeEffectA;
        if (this.f13110r) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final boolean M0() {
        return this.f13086W != null && this.f13122x.L1();
    }

    public void N() {
        if (this.f13084U != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f13081R.a(this, 2);
        this.f13084U = edgeEffectA;
        if (this.f13110r) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void N0() {
        boolean z7;
        if (this.f13077N) {
            this.f13104o.u();
            if (this.f13078O) {
                this.f13122x.S0(this);
            }
        }
        if (M0()) {
            this.f13104o.s();
        } else {
            this.f13104o.j();
        }
        boolean z8 = this.f13117u0 || this.f13119v0;
        this.f13111r0.f13242k = this.f13065E && this.f13086W != null && ((z7 = this.f13077N) || z8 || this.f13122x.f13179h) && (!z7 || this.f13120w.g());
        z zVar = this.f13111r0;
        zVar.f13243l = zVar.f13242k && z8 && !this.f13077N && M0();
    }

    public void O() {
        if (this.f13083T != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f13081R.a(this, 1);
        this.f13083T = edgeEffectA;
        if (this.f13110r) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void O0(boolean z7) {
        this.f13078O = z7 | this.f13078O;
        this.f13077N = true;
        x0();
    }

    public String P() {
        return " " + super.toString() + ", adapter:" + this.f13120w + ", layout:" + this.f13122x + ", context:" + getContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.M()
            android.widget.EdgeEffect r1 = r6.f13082S
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            c0.AbstractC0892d.c(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.N()
            android.widget.EdgeEffect r1 = r6.f13084U
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            c0.AbstractC0892d.c(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.O()
            android.widget.EdgeEffect r9 = r6.f13083T
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            c0.AbstractC0892d.c(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.L()
            android.widget.EdgeEffect r9 = r6.f13085V
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            c0.AbstractC0892d.c(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7e
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7e
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7d
            goto L7e
        L7d:
            return
        L7e:
            Z.W.c0(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.P0(float, float, float, float):void");
    }

    public final void Q(z zVar) {
        if (getScrollState() != 2) {
            zVar.f13247p = 0;
            zVar.f13248q = 0;
        } else {
            OverScroller overScroller = this.f13105o0.f13130n;
            zVar.f13247p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.f13248q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public void Q0(C c7, l.b bVar) {
        c7.F(0, 8192);
        if (this.f13111r0.f13240i && c7.y() && !c7.v() && !c7.J()) {
            this.f13108q.c(c0(c7), c7);
        }
        this.f13108q.e(c7, bVar);
    }

    public View R(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final void R0() {
        View viewFindViewById;
        if (!this.f13103n0 || this.f13120w == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!f13054N0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f13106p.n(focusedChild)) {
                    return;
                }
            } else if (this.f13106p.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewW = null;
        C cY = (this.f13111r0.f13245n == -1 || !this.f13120w.g()) ? null : Y(this.f13111r0.f13245n);
        if (cY != null && !this.f13106p.n(cY.f13136a) && cY.f13136a.hasFocusable()) {
            viewW = cY.f13136a;
        } else if (this.f13106p.g() > 0) {
            viewW = W();
        }
        if (viewW != null) {
            int i7 = this.f13111r0.f13246o;
            if (i7 != -1 && (viewFindViewById = viewW.findViewById(i7)) != null && viewFindViewById.isFocusable()) {
                viewW = viewFindViewById;
            }
            viewW.requestFocus();
        }
    }

    public C S(View view) {
        View viewR = R(view);
        if (viewR == null) {
            return null;
        }
        return e0(viewR);
    }

    public final void S0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f13082S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f13082S.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f13083T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f13083T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f13084U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f13084U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f13085V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f13085V.isFinished();
        }
        if (zIsFinished) {
            W.c0(this);
        }
    }

    public final boolean T(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f13126z.size();
        for (int i7 = 0; i7 < size; i7++) {
            r rVar = (r) this.f13126z.get(i7);
            if (rVar.b(this, motionEvent) && action != 3) {
                this.f13057A = rVar;
                return true;
            }
        }
        return false;
    }

    public void T0() {
        l lVar = this.f13086W;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f13122x;
        if (oVar != null) {
            oVar.k1(this.f13100m);
            this.f13122x.l1(this.f13100m);
        }
        this.f13100m.c();
    }

    public final void U(int[] iArr) {
        int iG = this.f13106p.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MIN_VALUE;
        for (int i9 = 0; i9 < iG; i9++) {
            C cF0 = f0(this.f13106p.f(i9));
            if (!cF0.J()) {
                int iM = cF0.m();
                if (iM < i7) {
                    i7 = iM;
                }
                if (iM > i8) {
                    i8 = iM;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
    }

    public boolean U0(View view) {
        p1();
        boolean zR = this.f13106p.r(view);
        if (zR) {
            C cF0 = f0(view);
            this.f13100m.J(cF0);
            this.f13100m.C(cF0);
        }
        r1(!zR);
        return zR;
    }

    public void V0(n nVar) {
        o oVar = this.f13122x;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.f13124y.remove(nVar);
        if (this.f13124y.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        w0();
        requestLayout();
    }

    public final View W() {
        C cX;
        z zVar = this.f13111r0;
        int i7 = zVar.f13244m;
        if (i7 == -1) {
            i7 = 0;
        }
        int iB = zVar.b();
        for (int i8 = i7; i8 < iB; i8++) {
            C cX2 = X(i8);
            if (cX2 == null) {
                break;
            }
            if (cX2.f13136a.hasFocusable()) {
                return cX2.f13136a;
            }
        }
        int iMin = Math.min(iB, i7);
        do {
            iMin--;
            if (iMin < 0 || (cX = X(iMin)) == null) {
                return null;
            }
        } while (!cX.f13136a.hasFocusable());
        return cX.f13136a;
    }

    public void W0(r rVar) {
        this.f13126z.remove(rVar);
        if (this.f13057A == rVar) {
            this.f13057A = null;
        }
    }

    public C X(int i7) {
        C c7 = null;
        if (this.f13077N) {
            return null;
        }
        int iJ = this.f13106p.j();
        for (int i8 = 0; i8 < iJ; i8++) {
            C cF0 = f0(this.f13106p.i(i8));
            if (cF0 != null && !cF0.v() && b0(cF0) == i7) {
                if (!this.f13106p.n(cF0.f13136a)) {
                    return cF0;
                }
                c7 = cF0;
            }
        }
        return c7;
    }

    public void X0(s sVar) {
        List list = this.f13115t0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    public C Y(long j7) {
        g gVar = this.f13120w;
        C c7 = null;
        if (gVar != null && gVar.g()) {
            int iJ = this.f13106p.j();
            for (int i7 = 0; i7 < iJ; i7++) {
                C cF0 = f0(this.f13106p.i(i7));
                if (cF0 != null && !cF0.v() && cF0.k() == j7) {
                    if (!this.f13106p.n(cF0.f13136a)) {
                        return cF0;
                    }
                    c7 = cF0;
                }
            }
        }
        return c7;
    }

    public void Y0() {
        C c7;
        int iG = this.f13106p.g();
        for (int i7 = 0; i7 < iG; i7++) {
            View viewF = this.f13106p.f(i7);
            C cE0 = e0(viewF);
            if (cE0 != null && (c7 = cE0.f13144i) != null) {
                View view = c7.f13136a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.C Z(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.f13106p
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.f13106p
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$C r3 = f0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.v()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f13138c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.f13106p
            android.view.View r4 = r3.f13136a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Z(int, boolean):androidx.recyclerview.widget.RecyclerView$C");
    }

    public final void Z0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f13114t.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f13198c) {
                Rect rect = pVar.f13197b;
                Rect rect2 = this.f13114t;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f13114t);
            offsetRectIntoDescendantCoords(view, this.f13114t);
        }
        this.f13122x.s1(this, view, this.f13114t, !this.f13065E, view2 == null);
    }

    public void a(int i7, int i8) {
        if (i7 < 0) {
            M();
            if (this.f13082S.isFinished()) {
                this.f13082S.onAbsorb(-i7);
            }
        } else if (i7 > 0) {
            N();
            if (this.f13084U.isFinished()) {
                this.f13084U.onAbsorb(i7);
            }
        }
        if (i8 < 0) {
            O();
            if (this.f13083T.isFinished()) {
                this.f13083T.onAbsorb(-i8);
            }
        } else if (i8 > 0) {
            L();
            if (this.f13085V.isFinished()) {
                this.f13085V.onAbsorb(i8);
            }
        }
        if (i7 == 0 && i8 == 0) {
            return;
        }
        W.c0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean a0(int i7, int i8) {
        o oVar = this.f13122x;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f13071H) {
            return false;
        }
        int iK = oVar.k();
        boolean zL = this.f13122x.l();
        if (iK == 0 || Math.abs(i7) < this.f13096j0) {
            i7 = 0;
        }
        if (!zL || Math.abs(i8) < this.f13096j0) {
            i8 = 0;
        }
        if (i7 == 0 && i8 == 0) {
            return false;
        }
        float f7 = i7;
        float f8 = i8;
        if (!dispatchNestedPreFling(f7, f8)) {
            boolean z7 = iK != 0 || zL;
            dispatchNestedFling(f7, f8, z7);
            q qVar = this.f13095i0;
            if (qVar != null && qVar.a(i7, i8)) {
                return true;
            }
            if (z7) {
                if (zL) {
                    iK = (iK == true ? 1 : 0) | 2;
                }
                q1(iK, 1);
                int i9 = this.f13097k0;
                int iMax = Math.max(-i9, Math.min(i7, i9));
                int i10 = this.f13097k0;
                this.f13105o0.c(iMax, Math.max(-i10, Math.min(i8, i10)));
                return true;
            }
        }
        return false;
    }

    public final void a1() {
        z zVar = this.f13111r0;
        zVar.f13245n = -1L;
        zVar.f13244m = -1;
        zVar.f13246o = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i7, int i8) {
        o oVar = this.f13122x;
        if (oVar == null || !oVar.F0(this, arrayList, i7, i8)) {
            super.addFocusables(arrayList, i7, i8);
        }
    }

    public int b0(C c7) {
        if (c7.p(524) || !c7.s()) {
            return -1;
        }
        return this.f13104o.e(c7.f13138c);
    }

    public final void b1() {
        VelocityTracker velocityTracker = this.f13089c0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        s1(0);
        S0();
    }

    public long c0(C c7) {
        return this.f13120w.g() ? c7.k() : c7.f13138c;
    }

    public final void c1() {
        View focusedChild = (this.f13103n0 && hasFocus() && this.f13120w != null) ? getFocusedChild() : null;
        C cS = focusedChild != null ? S(focusedChild) : null;
        if (cS == null) {
            a1();
            return;
        }
        this.f13111r0.f13245n = this.f13120w.g() ? cS.k() : -1L;
        this.f13111r0.f13244m = this.f13077N ? -1 : cS.v() ? cS.f13139d : cS.j();
        this.f13111r0.f13246o = h0(cS.f13136a);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f13122x.m((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f13122x;
        if (oVar != null && oVar.k()) {
            return this.f13122x.q(this.f13111r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f13122x;
        if (oVar != null && oVar.k()) {
            return this.f13122x.r(this.f13111r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f13122x;
        if (oVar != null && oVar.k()) {
            return this.f13122x.s(this.f13111r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f13122x;
        if (oVar != null && oVar.l()) {
            return this.f13122x.t(this.f13111r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f13122x;
        if (oVar != null && oVar.l()) {
            return this.f13122x.u(this.f13111r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f13122x;
        if (oVar != null && oVar.l()) {
            return this.f13122x.v(this.f13111r0);
        }
        return 0;
    }

    public int d0(View view) {
        C cF0 = f0(view);
        if (cF0 != null) {
            return cF0.m();
        }
        return -1;
    }

    public void d1() {
        int iJ = this.f13106p.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            C cF0 = f0(this.f13106p.i(i7));
            if (!cF0.J()) {
                cF0.E();
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f7, float f8, boolean z7) {
        return getScrollingChildHelper().a(f7, f8, z7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f7, float f8) {
        return getScrollingChildHelper().b(f7, f8);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i7, int i8, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i7, i8, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, int[] iArr) {
        return getScrollingChildHelper().f(i7, i8, i9, i10, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z7;
        super.draw(canvas);
        int size = this.f13124y.size();
        boolean z8 = false;
        for (int i7 = 0; i7 < size; i7++) {
            ((n) this.f13124y.get(i7)).i(canvas, this, this.f13111r0);
        }
        EdgeEffect edgeEffect = this.f13082S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z7 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f13110r ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f13082S;
            z7 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f13083T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f13110r) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f13083T;
            z7 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f13084U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f13110r ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f13084U;
            z7 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f13085V;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f13110r) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f13085V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z8 = true;
            }
            z7 |= z8;
            canvas.restoreToCount(iSave4);
        }
        if ((z7 || this.f13086W == null || this.f13124y.size() <= 0 || !this.f13086W.p()) ? z7 : true) {
            W.c0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j7) {
        return super.drawChild(canvas, view, j7);
    }

    public C e0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return f0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean e1(int i7, int i8, MotionEvent motionEvent) {
        int i9;
        int i10;
        int i11;
        int i12;
        u();
        if (this.f13120w != null) {
            int[] iArr = this.f13064D0;
            iArr[0] = 0;
            iArr[1] = 0;
            f1(i7, i8, iArr);
            int[] iArr2 = this.f13064D0;
            int i13 = iArr2[0];
            int i14 = iArr2[1];
            i11 = i7 - i13;
            i12 = i8 - i14;
            i10 = i14;
            i9 = i13;
        } else {
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        if (!this.f13124y.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f13064D0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        G(i9, i10, i11, i12, this.f13060B0, 0, iArr3);
        int[] iArr4 = this.f13064D0;
        int i15 = iArr4[0];
        int i16 = i11 - i15;
        int i17 = iArr4[1];
        int i18 = i12 - i17;
        boolean z7 = (i15 == 0 && i17 == 0) ? false : true;
        int i19 = this.f13092f0;
        int[] iArr5 = this.f13060B0;
        int i20 = iArr5[0];
        this.f13092f0 = i19 - i20;
        int i21 = this.f13093g0;
        int i22 = iArr5[1];
        this.f13093g0 = i21 - i22;
        int[] iArr6 = this.f13062C0;
        iArr6[0] = iArr6[0] + i20;
        iArr6[1] = iArr6[1] + i22;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !D.a(motionEvent, 8194)) {
                P0(motionEvent.getX(), i16, motionEvent.getY(), i18);
            }
            t(i7, i8);
        }
        if (i9 != 0 || i10 != 0) {
            I(i9, i10);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z7 && i9 == 0 && i10 == 0) ? false : true;
    }

    public void f1(int i7, int i8, int[] iArr) {
        p1();
        F0();
        V.k.a("RV Scroll");
        Q(this.f13111r0);
        int iW1 = i7 != 0 ? this.f13122x.w1(i7, this.f13100m, this.f13111r0) : 0;
        int iY1 = i8 != 0 ? this.f13122x.y1(i8, this.f13100m, this.f13111r0) : 0;
        V.k.b();
        Y0();
        G0();
        r1(false);
        if (iArr != null) {
            iArr[0] = iW1;
            iArr[1] = iY1;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i7) {
        View viewJ0;
        boolean z7;
        View viewQ0 = this.f13122x.Q0(view, i7);
        if (viewQ0 != null) {
            return viewQ0;
        }
        boolean z8 = (this.f13120w == null || this.f13122x == null || t0() || this.f13071H) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z8 && (i7 == 2 || i7 == 1)) {
            if (this.f13122x.l()) {
                int i8 = i7 == 2 ? 130 : 33;
                z7 = focusFinder.findNextFocus(this, view, i8) == null;
                if (f13053M0) {
                    i7 = i8;
                }
            } else {
                z7 = false;
            }
            if (!z7 && this.f13122x.k()) {
                int i9 = (this.f13122x.Z() == 1) ^ (i7 == 2) ? 66 : 17;
                boolean z9 = focusFinder.findNextFocus(this, view, i9) == null;
                if (f13053M0) {
                    i7 = i9;
                }
                z7 = z9;
            }
            if (z7) {
                u();
                if (R(view) == null) {
                    return null;
                }
                p1();
                this.f13122x.J0(view, i7, this.f13100m, this.f13111r0);
                r1(false);
            }
            viewJ0 = focusFinder.findNextFocus(this, view, i7);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i7);
            if (viewFindNextFocus == null && z8) {
                u();
                if (R(view) == null) {
                    return null;
                }
                p1();
                viewJ0 = this.f13122x.J0(view, i7, this.f13100m, this.f13111r0);
                r1(false);
            } else {
                viewJ0 = viewFindNextFocus;
            }
        }
        if (viewJ0 == null || viewJ0.hasFocusable()) {
            return u0(view, viewJ0, i7) ? viewJ0 : super.focusSearch(view, i7);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i7);
        }
        Z0(viewJ0, null);
        return view;
    }

    public final void g(C c7) {
        View view = c7.f13136a;
        boolean z7 = view.getParent() == this;
        this.f13100m.J(e0(view));
        if (c7.x()) {
            this.f13106p.c(view, -1, view.getLayoutParams(), true);
        } else if (z7) {
            this.f13106p.k(view);
        } else {
            this.f13106p.b(view, true);
        }
    }

    public void g1(int i7) {
        if (this.f13071H) {
            return;
        }
        t1();
        o oVar = this.f13122x;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.x1(i7);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f13122x;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f13122x;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.f13120w;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f13122x;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i7, int i8) {
        return super.getChildDrawingOrder(i7, i8);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f13110r;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.f13125y0;
    }

    public k getEdgeEffectFactory() {
        return this.f13081R;
    }

    public l getItemAnimator() {
        return this.f13086W;
    }

    public int getItemDecorationCount() {
        return this.f13124y.size();
    }

    public o getLayoutManager() {
        return this.f13122x;
    }

    public int getMaxFlingVelocity() {
        return this.f13097k0;
    }

    public int getMinFlingVelocity() {
        return this.f13096j0;
    }

    public long getNanoTime() {
        if (f13052L0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q getOnFlingListener() {
        return this.f13095i0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f13103n0;
    }

    public t getRecycledViewPool() {
        return this.f13100m.i();
    }

    public int getScrollState() {
        return this.f13087a0;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    public final int h0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public final void h1(g gVar, boolean z7, boolean z8) {
        g gVar2 = this.f13120w;
        if (gVar2 != null) {
            gVar2.s(this.f13098l);
            this.f13120w.l(this);
        }
        if (!z7 || z8) {
            T0();
        }
        this.f13104o.u();
        g gVar3 = this.f13120w;
        this.f13120w = gVar;
        if (gVar != null) {
            gVar.q(this.f13098l);
            gVar.h(this);
        }
        o oVar = this.f13122x;
        if (oVar != null) {
            oVar.E0(gVar3, this.f13120w);
        }
        this.f13100m.x(gVar3, this.f13120w, z7);
        this.f13111r0.f13238g = true;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i7) {
        o oVar = this.f13122x;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f13124y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i7 < 0) {
            this.f13124y.add(nVar);
        } else {
            this.f13124y.add(i7, nVar);
        }
        w0();
        requestLayout();
    }

    public final String i0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    public boolean i1(C c7, int i7) {
        if (!t0()) {
            W.v0(c7.f13136a, i7);
            return true;
        }
        c7.f13152q = i7;
        this.f13066E0.add(c7);
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f13059B;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f13071H;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(r rVar) {
        this.f13126z.add(rVar);
    }

    public Rect j0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f13198c) {
            return pVar.f13197b;
        }
        if (this.f13111r0.e() && (pVar.b() || pVar.d())) {
            return pVar.f13197b;
        }
        Rect rect = pVar.f13197b;
        rect.set(0, 0, 0, 0);
        int size = this.f13124y.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f13114t.set(0, 0, 0, 0);
            ((n) this.f13124y.get(i7)).e(this.f13114t, view, this, this.f13111r0);
            int i8 = rect.left;
            Rect rect2 = this.f13114t;
            rect.left = i8 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f13198c = false;
        return rect;
    }

    public boolean j1(AccessibilityEvent accessibilityEvent) {
        if (!t0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? AbstractC0745b.a(accessibilityEvent) : 0;
        this.f13073J |= iA != 0 ? iA : 0;
        return true;
    }

    public void k(s sVar) {
        if (this.f13115t0 == null) {
            this.f13115t0 = new ArrayList();
        }
        this.f13115t0.add(sVar);
    }

    public final void k0(long j7, C c7, C c8) {
        int iG = this.f13106p.g();
        for (int i7 = 0; i7 < iG; i7++) {
            C cF0 = f0(this.f13106p.f(i7));
            if (cF0 != c7 && c0(cF0) == j7) {
                g gVar = this.f13120w;
                if (gVar == null || !gVar.g()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + cF0 + " \n View Holder 2:" + c7 + P());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + cF0 + " \n View Holder 2:" + c7 + P());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c8 + " cannot be found but it is necessary for " + c7 + P());
    }

    public void k1(int i7, int i8) {
        l1(i7, i8, null);
    }

    public void l(C c7, l.b bVar, l.b bVar2) {
        c7.G(false);
        if (this.f13086W.a(c7, bVar, bVar2)) {
            L0();
        }
    }

    public boolean l0() {
        return !this.f13065E || this.f13077N || this.f13104o.p();
    }

    public void l1(int i7, int i8, Interpolator interpolator) {
        m1(i7, i8, interpolator, Integer.MIN_VALUE);
    }

    public final void m(C c7, C c8, l.b bVar, l.b bVar2, boolean z7, boolean z8) {
        c7.G(false);
        if (z7) {
            g(c7);
        }
        if (c7 != c8) {
            if (z8) {
                g(c8);
            }
            c7.f13143h = c8;
            g(c7);
            this.f13100m.J(c7);
            c8.G(false);
            c8.f13144i = c7;
        }
        if (this.f13086W.b(c7, c8, bVar, bVar2)) {
            L0();
        }
    }

    public final boolean m0() {
        int iG = this.f13106p.g();
        for (int i7 = 0; i7 < iG; i7++) {
            C cF0 = f0(this.f13106p.f(i7));
            if (cF0 != null && !cF0.J() && cF0.y()) {
                return true;
            }
        }
        return false;
    }

    public void m1(int i7, int i8, Interpolator interpolator, int i9) {
        n1(i7, i8, interpolator, i9, false);
    }

    public void n(C c7, l.b bVar, l.b bVar2) {
        g(c7);
        c7.G(false);
        if (this.f13086W.c(c7, bVar, bVar2)) {
            L0();
        }
    }

    public void n0() {
        this.f13104o = new a(new f());
    }

    public void n1(int i7, int i8, Interpolator interpolator, int i9, boolean z7) {
        o oVar = this.f13122x;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f13071H) {
            return;
        }
        if (!oVar.k()) {
            i7 = 0;
        }
        if (!this.f13122x.l()) {
            i8 = 0;
        }
        if (i7 == 0 && i8 == 0) {
            return;
        }
        if (i9 != Integer.MIN_VALUE && i9 <= 0) {
            scrollBy(i7, i8);
            return;
        }
        if (z7) {
            int i10 = i7 != 0 ? 1 : 0;
            if (i8 != 0) {
                i10 |= 2;
            }
            q1(i10, 1);
        }
        this.f13105o0.f(i7, i8, i9, interpolator);
    }

    public void o(String str) {
        if (t0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + P());
        }
        if (this.f13080Q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + P()));
        }
    }

    public final void o0() {
        if (W.z(this) == 0) {
            W.x0(this, 8);
        }
    }

    public void o1(int i7) {
        if (this.f13071H) {
            return;
        }
        o oVar = this.f13122x;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.I1(this, this.f13111r0, i7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f13079P = r0
            r1 = 1
            r5.f13059B = r1
            boolean r2 = r5.f13065E
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.f13065E = r1
            androidx.recyclerview.widget.RecyclerView$o r1 = r5.f13122x
            if (r1 == 0) goto L1e
            r1.z(r5)
        L1e:
            r5.f13123x0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f13052L0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.e.f13409p
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.f13107p0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.f13107p0 = r1
            android.view.Display r1 = Z.W.u(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.e r2 = r5.f13107p0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f13413n = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.f13107p0
            r0.a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.f13086W;
        if (lVar != null) {
            lVar.k();
        }
        t1();
        this.f13059B = false;
        o oVar = this.f13122x;
        if (oVar != null) {
            oVar.A(this, this.f13100m);
        }
        this.f13066E0.clear();
        removeCallbacks(this.f13068F0);
        this.f13108q.j();
        if (!f13052L0 || (eVar = this.f13107p0) == null) {
            return;
        }
        eVar.j(this);
        this.f13107p0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f13124y.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((n) this.f13124y.get(i7)).g(canvas, this, this.f13111r0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f13122x
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f13071H
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f13122x
            boolean r0 = r0.l()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f13122x
            boolean r3 = r3.k()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f13122x
            boolean r3 = r3.l()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f13122x
            boolean r3 = r3.k()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.f13099l0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f13101m0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.e1(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        if (this.f13071H) {
            return false;
        }
        this.f13057A = null;
        if (T(motionEvent)) {
            q();
            return true;
        }
        o oVar = this.f13122x;
        if (oVar == null) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.f13122x.l();
        if (this.f13089c0 == null) {
            this.f13089c0 = VelocityTracker.obtain();
        }
        this.f13089c0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f13072I) {
                this.f13072I = false;
            }
            this.f13088b0 = motionEvent.getPointerId(0);
            int x7 = (int) (motionEvent.getX() + 0.5f);
            this.f13092f0 = x7;
            this.f13090d0 = x7;
            int y7 = (int) (motionEvent.getY() + 0.5f);
            this.f13093g0 = y7;
            this.f13091e0 = y7;
            if (this.f13087a0 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                s1(1);
            }
            int[] iArr = this.f13062C0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i7 = zK;
            if (zL) {
                i7 = (zK ? 1 : 0) | 2;
            }
            q1(i7, 0);
        } else if (actionMasked == 1) {
            this.f13089c0.clear();
            s1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f13088b0);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f13088b0 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x8 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y8 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f13087a0 != 1) {
                int i8 = x8 - this.f13090d0;
                int i9 = y8 - this.f13091e0;
                if (zK == 0 || Math.abs(i8) <= this.f13094h0) {
                    z7 = false;
                } else {
                    this.f13092f0 = x8;
                    z7 = true;
                }
                if (zL && Math.abs(i9) > this.f13094h0) {
                    this.f13093g0 = y8;
                    z7 = true;
                }
                if (z7) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.f13088b0 = motionEvent.getPointerId(actionIndex);
            int x9 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f13092f0 = x9;
            this.f13090d0 = x9;
            int y9 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f13093g0 = y9;
            this.f13091e0 = y9;
        } else if (actionMasked == 6) {
            I0(motionEvent);
        }
        return this.f13087a0 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        V.k.a("RV OnLayout");
        B();
        V.k.b();
        this.f13065E = true;
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        o oVar = this.f13122x;
        if (oVar == null) {
            w(i7, i8);
            return;
        }
        if (oVar.s0()) {
            int mode = View.MeasureSpec.getMode(i7);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.f13122x.Z0(this.f13100m, this.f13111r0, i7, i8);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.f13120w == null) {
                return;
            }
            if (this.f13111r0.f13236e == 1) {
                C();
            }
            this.f13122x.A1(i7, i8);
            this.f13111r0.f13241j = true;
            D();
            this.f13122x.D1(i7, i8);
            if (this.f13122x.G1()) {
                this.f13122x.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f13111r0.f13241j = true;
                D();
                this.f13122x.D1(i7, i8);
                return;
            }
            return;
        }
        if (this.f13061C) {
            this.f13122x.Z0(this.f13100m, this.f13111r0, i7, i8);
            return;
        }
        if (this.f13074K) {
            p1();
            F0();
            N0();
            G0();
            z zVar = this.f13111r0;
            if (zVar.f13243l) {
                zVar.f13239h = true;
            } else {
                this.f13104o.j();
                this.f13111r0.f13239h = false;
            }
            this.f13074K = false;
            r1(false);
        } else if (this.f13111r0.f13243l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f13120w;
        if (gVar != null) {
            this.f13111r0.f13237f = gVar.c();
        } else {
            this.f13111r0.f13237f = 0;
        }
        p1();
        this.f13122x.Z0(this.f13100m, this.f13111r0, i7, i8);
        r1(false);
        this.f13111r0.f13239h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i7, Rect rect) {
        if (t0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i7, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        this.f13102n = xVar;
        super.onRestoreInstanceState(xVar.b());
        o oVar = this.f13122x;
        if (oVar == null || (parcelable2 = this.f13102n.f13216n) == null) {
            return;
        }
        oVar.c1(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        x xVar2 = this.f13102n;
        if (xVar2 != null) {
            xVar.c(xVar2);
            return xVar;
        }
        o oVar = this.f13122x;
        if (oVar != null) {
            xVar.f13216n = oVar.d1();
            return xVar;
        }
        xVar.f13216n = null;
        return xVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        if (i7 == i9 && i8 == i10) {
            return;
        }
        r0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r1
      0x00df: PHI (r1v45 int) = (r1v26 int), (r1v49 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean p(C c7) {
        l lVar = this.f13086W;
        return lVar == null || lVar.g(c7, c7.o());
    }

    public final void p0() {
        this.f13106p = new b(new e());
    }

    public void p1() {
        int i7 = this.f13067F + 1;
        this.f13067F = i7;
        if (i7 != 1 || this.f13071H) {
            return;
        }
        this.f13069G = false;
    }

    public final void q() {
        b1();
        setScrollState(0);
    }

    public void q0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(T1.b.f8217a), resources.getDimensionPixelSize(T1.b.f8219c), resources.getDimensionPixelOffset(T1.b.f8218b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + P());
        }
    }

    public boolean q1(int i7, int i8) {
        return getScrollingChildHelper().p(i7, i8);
    }

    public void r0() {
        this.f13085V = null;
        this.f13083T = null;
        this.f13084U = null;
        this.f13082S = null;
    }

    public void r1(boolean z7) {
        if (this.f13067F < 1) {
            this.f13067F = 1;
        }
        if (!z7 && !this.f13071H) {
            this.f13069G = false;
        }
        if (this.f13067F == 1) {
            if (z7 && this.f13069G && !this.f13071H && this.f13122x != null && this.f13120w != null) {
                B();
            }
            if (!this.f13071H) {
                this.f13069G = false;
            }
        }
        this.f13067F--;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z7) {
        C cF0 = f0(view);
        if (cF0 != null) {
            if (cF0.x()) {
                cF0.f();
            } else if (!cF0.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + cF0 + P());
            }
        }
        view.clearAnimation();
        z(view);
        super.removeDetachedView(view, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f13122x.b1(this, this.f13111r0, view, view2) && view2 != null) {
            Z0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        return this.f13122x.r1(this, view, rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        int size = this.f13126z.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((r) this.f13126z.get(i7)).c(z7);
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f13067F != 0 || this.f13071H) {
            this.f13069G = true;
        } else {
            super.requestLayout();
        }
    }

    public void s() {
        int iJ = this.f13106p.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            C cF0 = f0(this.f13106p.i(i7));
            if (!cF0.J()) {
                cF0.c();
            }
        }
        this.f13100m.d();
    }

    public boolean s0() {
        AccessibilityManager accessibilityManager = this.f13075L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void s1(int i7) {
        getScrollingChildHelper().r(i7);
    }

    @Override // android.view.View
    public void scrollBy(int i7, int i8) {
        o oVar = this.f13122x;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f13071H) {
            return;
        }
        boolean zK = oVar.k();
        boolean zL = this.f13122x.l();
        if (zK || zL) {
            if (!zK) {
                i7 = 0;
            }
            if (!zL) {
                i8 = 0;
            }
            e1(i7, i8, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i7, int i8) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (j1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k kVar) {
        this.f13125y0 = kVar;
        W.l0(this, kVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        h1(gVar, false, true);
        O0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z7) {
        if (z7 != this.f13110r) {
            r0();
        }
        this.f13110r = z7;
        super.setClipToPadding(z7);
        if (this.f13065E) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        Y.h.j(kVar);
        this.f13081R = kVar;
        r0();
    }

    public void setHasFixedSize(boolean z7) {
        this.f13061C = z7;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.f13086W;
        if (lVar2 != null) {
            lVar2.k();
            this.f13086W.v(null);
        }
        this.f13086W = lVar;
        if (lVar != null) {
            lVar.v(this.f13121w0);
        }
    }

    public void setItemViewCacheSize(int i7) {
        this.f13100m.G(i7);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z7) {
        suppressLayout(z7);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f13122x) {
            return;
        }
        t1();
        if (this.f13122x != null) {
            l lVar = this.f13086W;
            if (lVar != null) {
                lVar.k();
            }
            this.f13122x.k1(this.f13100m);
            this.f13122x.l1(this.f13100m);
            this.f13100m.c();
            if (this.f13059B) {
                this.f13122x.A(this, this.f13100m);
            }
            this.f13122x.E1(null);
            this.f13122x = null;
        } else {
            this.f13100m.c();
        }
        this.f13106p.o();
        this.f13122x = oVar;
        if (oVar != null) {
            if (oVar.f13173b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f13173b.P());
            }
            oVar.E1(this);
            if (this.f13059B) {
                this.f13122x.z(this);
            }
        }
        this.f13100m.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z7) {
        getScrollingChildHelper().m(z7);
    }

    public void setOnFlingListener(q qVar) {
        this.f13095i0 = qVar;
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.f13113s0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z7) {
        this.f13103n0 = z7;
    }

    public void setRecycledViewPool(t tVar) {
        this.f13100m.E(tVar);
    }

    public void setRecyclerListener(v vVar) {
    }

    public void setScrollState(int i7) {
        if (i7 == this.f13087a0) {
            return;
        }
        this.f13087a0 = i7;
        if (i7 != 2) {
            u1();
        }
        H(i7);
    }

    public void setScrollingTouchSlop(int i7) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i7 != 0) {
            if (i7 == 1) {
                this.f13094h0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i7 + "; using default value");
        }
        this.f13094h0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(A a7) {
        this.f13100m.F(a7);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i7) {
        return getScrollingChildHelper().o(i7);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z7) {
        if (z7 != this.f13071H) {
            o("Do not suppressLayout in layout or scroll");
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f13071H = true;
                this.f13072I = true;
                t1();
                return;
            }
            this.f13071H = false;
            if (this.f13069G && this.f13122x != null && this.f13120w != null) {
                requestLayout();
            }
            this.f13069G = false;
        }
    }

    public void t(int i7, int i8) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f13082S;
        if (edgeEffect == null || edgeEffect.isFinished() || i7 <= 0) {
            zIsFinished = false;
        } else {
            this.f13082S.onRelease();
            zIsFinished = this.f13082S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f13084U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i7 < 0) {
            this.f13084U.onRelease();
            zIsFinished |= this.f13084U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f13083T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i8 > 0) {
            this.f13083T.onRelease();
            zIsFinished |= this.f13083T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f13085V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i8 < 0) {
            this.f13085V.onRelease();
            zIsFinished |= this.f13085V.isFinished();
        }
        if (zIsFinished) {
            W.c0(this);
        }
    }

    public boolean t0() {
        return this.f13079P > 0;
    }

    public void t1() {
        setScrollState(0);
        u1();
    }

    public void u() {
        if (!this.f13065E || this.f13077N) {
            V.k.a("RV FullInvalidate");
            B();
            V.k.b();
            return;
        }
        if (this.f13104o.p()) {
            if (!this.f13104o.o(4) || this.f13104o.o(11)) {
                if (this.f13104o.p()) {
                    V.k.a("RV FullInvalidate");
                    B();
                    V.k.b();
                    return;
                }
                return;
            }
            V.k.a("RV PartialInvalidate");
            p1();
            F0();
            this.f13104o.s();
            if (!this.f13069G) {
                if (m0()) {
                    B();
                } else {
                    this.f13104o.i();
                }
            }
            r1(true);
            G0();
            V.k.b();
        }
    }

    public final boolean u0(View view, View view2, int i7) {
        int i8;
        if (view2 == null || view2 == this || R(view2) == null) {
            return false;
        }
        if (view == null || R(view) == null) {
            return true;
        }
        this.f13114t.set(0, 0, view.getWidth(), view.getHeight());
        this.f13116u.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f13114t);
        offsetDescendantRectToMyCoords(view2, this.f13116u);
        char c7 = 65535;
        int i9 = this.f13122x.Z() == 1 ? -1 : 1;
        Rect rect = this.f13114t;
        int i10 = rect.left;
        Rect rect2 = this.f13116u;
        int i11 = rect2.left;
        if ((i10 < i11 || rect.right <= i11) && rect.right < rect2.right) {
            i8 = 1;
        } else {
            int i12 = rect.right;
            int i13 = rect2.right;
            i8 = ((i12 > i13 || i10 >= i13) && i10 > i11) ? -1 : 0;
        }
        int i14 = rect.top;
        int i15 = rect2.top;
        if ((i14 < i15 || rect.bottom <= i15) && rect.bottom < rect2.bottom) {
            c7 = 1;
        } else {
            int i16 = rect.bottom;
            int i17 = rect2.bottom;
            if ((i16 <= i17 && i14 < i17) || i14 <= i15) {
                c7 = 0;
            }
        }
        if (i7 == 1) {
            return c7 < 0 || (c7 == 0 && i8 * i9 <= 0);
        }
        if (i7 == 2) {
            return c7 > 0 || (c7 == 0 && i8 * i9 >= 0);
        }
        if (i7 == 17) {
            return i8 < 0;
        }
        if (i7 == 33) {
            return c7 < 0;
        }
        if (i7 == 66) {
            return i8 > 0;
        }
        if (i7 == 130) {
            return c7 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i7 + P());
    }

    public final void u1() {
        this.f13105o0.g();
        o oVar = this.f13122x;
        if (oVar != null) {
            oVar.K1();
        }
    }

    public final void v(Context context, String str, AttributeSet attributeSet, int i7, int i8) throws NoSuchMethodException, SecurityException {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strI0 = i0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strI0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                try {
                    constructor = clsAsSubclass.getConstructor(f13055O0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i7), Integer.valueOf(i8)};
                } catch (NoSuchMethodException e7) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e8) {
                        e8.initCause(e7);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strI0, e8);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strI0, e9);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strI0, e10);
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strI0, e11);
            } catch (InstantiationException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strI0, e12);
            } catch (InvocationTargetException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strI0, e13);
            }
        }
    }

    public void v0(int i7) {
        if (this.f13122x == null) {
            return;
        }
        setScrollState(2);
        this.f13122x.x1(i7);
        awakenScrollBars();
    }

    public void v1(int i7, int i8, Object obj) {
        int i9;
        int iJ = this.f13106p.j();
        int i10 = i7 + i8;
        for (int i11 = 0; i11 < iJ; i11++) {
            View viewI = this.f13106p.i(i11);
            C cF0 = f0(viewI);
            if (cF0 != null && !cF0.J() && (i9 = cF0.f13138c) >= i7 && i9 < i10) {
                cF0.b(2);
                cF0.a(obj);
                ((p) viewI.getLayoutParams()).f13198c = true;
            }
        }
        this.f13100m.M(i7, i8);
    }

    public void w(int i7, int i8) {
        setMeasuredDimension(o.n(i7, getPaddingLeft() + getPaddingRight(), W.C(this)), o.n(i8, getPaddingTop() + getPaddingBottom(), W.B(this)));
    }

    public void w0() {
        int iJ = this.f13106p.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            ((p) this.f13106p.i(i7).getLayoutParams()).f13198c = true;
        }
        this.f13100m.s();
    }

    public final boolean x(int i7, int i8) {
        U(this.f13127z0);
        int[] iArr = this.f13127z0;
        return (iArr[0] == i7 && iArr[1] == i8) ? false : true;
    }

    public void x0() {
        int iJ = this.f13106p.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            C cF0 = f0(this.f13106p.i(i7));
            if (cF0 != null && !cF0.J()) {
                cF0.b(6);
            }
        }
        w0();
        this.f13100m.t();
    }

    public void y(View view) {
        int size;
        C cF0 = f0(view);
        D0(view);
        g gVar = this.f13120w;
        if (gVar != null && cF0 != null) {
            gVar.n(cF0);
        }
        if (this.f13076M == null || r2.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f13076M.get(size));
        throw null;
    }

    public void y0(int i7) {
        int iG = this.f13106p.g();
        for (int i8 = 0; i8 < iG; i8++) {
            this.f13106p.f(i8).offsetLeftAndRight(i7);
        }
    }

    public void z(View view) {
        int size;
        C cF0 = f0(view);
        E0(view);
        g gVar = this.f13120w;
        if (gVar != null && cF0 != null) {
            gVar.o(cF0);
        }
        if (this.f13076M == null || r2.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f13076M.get(size));
        throw null;
    }

    public void z0(int i7) {
        int iG = this.f13106p.g();
        for (int i8 = 0; i8 < iG; i8++) {
            this.f13106p.f(i8).offsetTopAndBottom(i7);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i7) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i7);
        this.f13098l = new w();
        this.f13100m = new u();
        this.f13108q = new androidx.recyclerview.widget.p();
        this.f13112s = new RunnableC0813a();
        this.f13114t = new Rect();
        this.f13116u = new Rect();
        this.f13118v = new RectF();
        this.f13124y = new ArrayList();
        this.f13126z = new ArrayList();
        this.f13067F = 0;
        this.f13077N = false;
        this.f13078O = false;
        this.f13079P = 0;
        this.f13080Q = 0;
        this.f13081R = new k();
        this.f13086W = new c();
        this.f13087a0 = 0;
        this.f13088b0 = -1;
        this.f13099l0 = Float.MIN_VALUE;
        this.f13101m0 = Float.MIN_VALUE;
        this.f13103n0 = true;
        this.f13105o0 = new B();
        this.f13109q0 = f13052L0 ? new e.b() : null;
        this.f13111r0 = new z();
        this.f13117u0 = false;
        this.f13119v0 = false;
        this.f13121w0 = new m();
        this.f13123x0 = false;
        this.f13127z0 = new int[2];
        this.f13060B0 = new int[2];
        this.f13062C0 = new int[2];
        this.f13064D0 = new int[2];
        this.f13066E0 = new ArrayList();
        this.f13068F0 = new RunnableC0814b();
        this.f13070G0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f13094h0 = viewConfiguration.getScaledTouchSlop();
        this.f13099l0 = Z.f(viewConfiguration, context);
        this.f13101m0 = Z.j(viewConfiguration, context);
        this.f13096j0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f13097k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f13086W.v(this.f13121w0);
        n0();
        p0();
        o0();
        if (W.y(this) == 0) {
            W.v0(this, 1);
        }
        this.f13075L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, T1.c.f8225f, i7, 0);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            saveAttributeDataForStyleable(context, T1.c.f8225f, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(T1.c.f8234o);
        if (typedArrayObtainStyledAttributes.getInt(T1.c.f8228i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f13110r = typedArrayObtainStyledAttributes.getBoolean(T1.c.f8227h, true);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(T1.c.f8229j, false);
        this.f13063D = z7;
        if (z7) {
            q0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(T1.c.f8232m), typedArrayObtainStyledAttributes.getDrawable(T1.c.f8233n), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(T1.c.f8230k), typedArrayObtainStyledAttributes.getDrawable(T1.c.f8231l));
        }
        typedArrayObtainStyledAttributes.recycle();
        v(context, string, attributeSet, i7, 0);
        int[] iArr = f13048H0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i7, 0);
        if (i8 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i7, 0);
        }
        boolean z8 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z8);
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public C f13196a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f13197b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f13198c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f13199d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13197b = new Rect();
            this.f13198c = true;
            this.f13199d = false;
        }

        public int a() {
            return this.f13196a.m();
        }

        public boolean b() {
            return this.f13196a.y();
        }

        public boolean c() {
            return this.f13196a.v();
        }

        public boolean d() {
            return this.f13196a.t();
        }

        public p(int i7, int i8) {
            super(i7, i8);
            this.f13197b = new Rect();
            this.f13198c = true;
            this.f13199d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f13197b = new Rect();
            this.f13198c = true;
            this.f13199d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f13197b = new Rect();
            this.f13198c = true;
            this.f13199d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f13197b = new Rect();
            this.f13198c = true;
            this.f13199d = false;
        }
    }

    public static class x extends AbstractC1008a {
        public static final Parcelable.Creator<x> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public Parcelable f13216n;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int i7) {
                return new x[i7];
            }
        }

        public x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13216n = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public void c(x xVar) {
            this.f13216n = xVar.f13216n;
        }

        @Override // e0.AbstractC1008a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeParcelable(this.f13216n, 0);
        }

        public x(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f13122x;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }
}
