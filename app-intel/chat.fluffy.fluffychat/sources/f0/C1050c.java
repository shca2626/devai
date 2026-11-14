package f0;

import Z.W;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* renamed from: f0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1050c {

    /* renamed from: x, reason: collision with root package name */
    public static final Interpolator f15685x = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f15686a;

    /* renamed from: b, reason: collision with root package name */
    public int f15687b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f15689d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f15690e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f15691f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f15692g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f15693h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f15694i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f15695j;

    /* renamed from: k, reason: collision with root package name */
    public int f15696k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f15697l;

    /* renamed from: m, reason: collision with root package name */
    public float f15698m;

    /* renamed from: n, reason: collision with root package name */
    public float f15699n;

    /* renamed from: o, reason: collision with root package name */
    public int f15700o;

    /* renamed from: p, reason: collision with root package name */
    public final int f15701p;

    /* renamed from: q, reason: collision with root package name */
    public int f15702q;

    /* renamed from: r, reason: collision with root package name */
    public OverScroller f15703r;

    /* renamed from: s, reason: collision with root package name */
    public final AbstractC0166c f15704s;

    /* renamed from: t, reason: collision with root package name */
    public View f15705t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f15706u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewGroup f15707v;

    /* renamed from: c, reason: collision with root package name */
    public int f15688c = -1;

    /* renamed from: w, reason: collision with root package name */
    public final Runnable f15708w = new b();

    /* renamed from: f0.c$a */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f7) {
            float f8 = f7 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    }

    /* renamed from: f0.c$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1050c.this.E(0);
        }
    }

    public C1050c(Context context, ViewGroup viewGroup, AbstractC0166c abstractC0166c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0166c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f15707v = viewGroup;
        this.f15704s = abstractC0166c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i7 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f15701p = i7;
        this.f15700o = i7;
        this.f15687b = viewConfiguration.getScaledTouchSlop();
        this.f15698m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f15699n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f15703r = new OverScroller(context, f15685x);
    }

    public static C1050c l(ViewGroup viewGroup, float f7, AbstractC0166c abstractC0166c) {
        C1050c c1050cM = m(viewGroup, abstractC0166c);
        c1050cM.f15687b = (int) (c1050cM.f15687b * (1.0f / f7));
        return c1050cM;
    }

    public static C1050c m(ViewGroup viewGroup, AbstractC0166c abstractC0166c) {
        return new C1050c(viewGroup.getContext(), viewGroup, abstractC0166c);
    }

    public final void A() {
        this.f15697l.computeCurrentVelocity(1000, this.f15698m);
        n(e(this.f15697l.getXVelocity(this.f15688c), this.f15699n, this.f15698m), e(this.f15697l.getYVelocity(this.f15688c), this.f15699n, this.f15698m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [f0.c$c] */
    public final void B(float f7, float f8, int i7) {
        boolean zC = c(f7, f8, i7, 1);
        boolean z7 = zC;
        if (c(f8, f7, i7, 4)) {
            z7 = (zC ? 1 : 0) | 4;
        }
        boolean z8 = z7;
        if (c(f7, f8, i7, 2)) {
            z8 = (z7 ? 1 : 0) | 2;
        }
        ?? r02 = z8;
        if (c(f8, f7, i7, 8)) {
            r02 = (z8 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f15694i;
            iArr[i7] = iArr[i7] | r02;
            this.f15704s.f(r02, i7);
        }
    }

    public final void C(float f7, float f8, int i7) {
        q(i7);
        float[] fArr = this.f15689d;
        this.f15691f[i7] = f7;
        fArr[i7] = f7;
        float[] fArr2 = this.f15690e;
        this.f15692g[i7] = f8;
        fArr2[i7] = f8;
        this.f15693h[i7] = t((int) f7, (int) f8);
        this.f15696k |= 1 << i7;
    }

    public final void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i7 = 0; i7 < pointerCount; i7++) {
            int pointerId = motionEvent.getPointerId(i7);
            if (x(pointerId)) {
                float x7 = motionEvent.getX(i7);
                float y7 = motionEvent.getY(i7);
                this.f15691f[pointerId] = x7;
                this.f15692g[pointerId] = y7;
            }
        }
    }

    public void E(int i7) {
        this.f15707v.removeCallbacks(this.f15708w);
        if (this.f15686a != i7) {
            this.f15686a = i7;
            this.f15704s.j(i7);
            if (this.f15686a == 0) {
                this.f15705t = null;
            }
        }
    }

    public boolean F(int i7, int i8) {
        if (this.f15706u) {
            return s(i7, i8, (int) this.f15697l.getXVelocity(this.f15688c), (int) this.f15697l.getYVelocity(this.f15688c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean G(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.C1050c.G(android.view.MotionEvent):boolean");
    }

    public boolean H(View view, int i7, int i8) {
        this.f15705t = view;
        this.f15688c = -1;
        boolean zS = s(i7, i8, 0, 0);
        if (!zS && this.f15686a == 0 && this.f15705t != null) {
            this.f15705t = null;
        }
        return zS;
    }

    public boolean I(View view, int i7) {
        if (view == this.f15705t && this.f15688c == i7) {
            return true;
        }
        if (view == null || !this.f15704s.m(view, i7)) {
            return false;
        }
        this.f15688c = i7;
        b(view, i7);
        return true;
    }

    public void a() {
        this.f15688c = -1;
        g();
        VelocityTracker velocityTracker = this.f15697l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f15697l = null;
        }
    }

    public void b(View view, int i7) {
        if (view.getParent() == this.f15707v) {
            this.f15705t = view;
            this.f15688c = i7;
            this.f15704s.i(view, i7);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f15707v + ")");
    }

    public final boolean c(float f7, float f8, int i7, int i8) {
        float fAbs = Math.abs(f7);
        float fAbs2 = Math.abs(f8);
        if ((this.f15693h[i7] & i8) == i8 && (this.f15702q & i8) != 0 && (this.f15695j[i7] & i8) != i8 && (this.f15694i[i7] & i8) != i8) {
            int i9 = this.f15687b;
            if (fAbs > i9 || fAbs2 > i9) {
                if (fAbs < fAbs2 * 0.5f && this.f15704s.g(i8)) {
                    int[] iArr = this.f15695j;
                    iArr[i7] = iArr[i7] | i8;
                    return false;
                }
                if ((this.f15694i[i7] & i8) == 0 && fAbs > this.f15687b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean d(View view, float f7, float f8) {
        if (view == null) {
            return false;
        }
        boolean z7 = this.f15704s.d(view) > 0;
        boolean z8 = this.f15704s.e(view) > 0;
        if (!z7 || !z8) {
            return z7 ? Math.abs(f7) > ((float) this.f15687b) : z8 && Math.abs(f8) > ((float) this.f15687b);
        }
        float f9 = (f7 * f7) + (f8 * f8);
        int i7 = this.f15687b;
        return f9 > ((float) (i7 * i7));
    }

    public final float e(float f7, float f8, float f9) {
        float fAbs = Math.abs(f7);
        if (fAbs < f8) {
            return 0.0f;
        }
        return fAbs > f9 ? f7 > 0.0f ? f9 : -f9 : f7;
    }

    public final int f(int i7, int i8, int i9) {
        int iAbs = Math.abs(i7);
        if (iAbs < i8) {
            return 0;
        }
        return iAbs > i9 ? i7 > 0 ? i9 : -i9 : i7;
    }

    public final void g() {
        float[] fArr = this.f15689d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f15690e, 0.0f);
        Arrays.fill(this.f15691f, 0.0f);
        Arrays.fill(this.f15692g, 0.0f);
        Arrays.fill(this.f15693h, 0);
        Arrays.fill(this.f15694i, 0);
        Arrays.fill(this.f15695j, 0);
        this.f15696k = 0;
    }

    public final void h(int i7) {
        if (this.f15689d == null || !w(i7)) {
            return;
        }
        this.f15689d[i7] = 0.0f;
        this.f15690e[i7] = 0.0f;
        this.f15691f[i7] = 0.0f;
        this.f15692g[i7] = 0.0f;
        this.f15693h[i7] = 0;
        this.f15694i[i7] = 0;
        this.f15695j[i7] = 0;
        this.f15696k = (~(1 << i7)) & this.f15696k;
    }

    public final int i(int i7, int i8, int i9) {
        if (i7 == 0) {
            return 0;
        }
        int width = this.f15707v.getWidth();
        float f7 = width / 2;
        float fO = f7 + (o(Math.min(1.0f, Math.abs(i7) / width)) * f7);
        int iAbs = Math.abs(i8);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i7) / i9) + 1.0f) * 256.0f), 600);
    }

    public final int j(View view, int i7, int i8, int i9, int i10) {
        float f7;
        float f8;
        float f9;
        float f10;
        int iF = f(i9, (int) this.f15699n, (int) this.f15698m);
        int iF2 = f(i10, (int) this.f15699n, (int) this.f15698m);
        int iAbs = Math.abs(i7);
        int iAbs2 = Math.abs(i8);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i11 = iAbs3 + iAbs4;
        int i12 = iAbs + iAbs2;
        if (iF != 0) {
            f7 = iAbs3;
            f8 = i11;
        } else {
            f7 = iAbs;
            f8 = i12;
        }
        float f11 = f7 / f8;
        if (iF2 != 0) {
            f9 = iAbs4;
            f10 = i11;
        } else {
            f9 = iAbs2;
            f10 = i12;
        }
        return (int) ((i(i7, iF, this.f15704s.d(view)) * f11) + (i(i8, iF2, this.f15704s.e(view)) * (f9 / f10)));
    }

    public boolean k(boolean z7) {
        if (this.f15686a == 2) {
            boolean zComputeScrollOffset = this.f15703r.computeScrollOffset();
            int currX = this.f15703r.getCurrX();
            int currY = this.f15703r.getCurrY();
            int left = currX - this.f15705t.getLeft();
            int top = currY - this.f15705t.getTop();
            if (left != 0) {
                W.V(this.f15705t, left);
            }
            if (top != 0) {
                W.W(this.f15705t, top);
            }
            if (left != 0 || top != 0) {
                this.f15704s.k(this.f15705t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f15703r.getFinalX() && currY == this.f15703r.getFinalY()) {
                this.f15703r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z7) {
                    this.f15707v.post(this.f15708w);
                } else {
                    E(0);
                }
            }
        }
        return this.f15686a == 2;
    }

    public final void n(float f7, float f8) {
        this.f15706u = true;
        this.f15704s.l(this.f15705t, f7, f8);
        this.f15706u = false;
        if (this.f15686a == 1) {
            E(0);
        }
    }

    public final float o(float f7) {
        return (float) Math.sin((f7 - 0.5f) * 0.47123894f);
    }

    public final void p(int i7, int i8, int i9, int i10) {
        int left = this.f15705t.getLeft();
        int top = this.f15705t.getTop();
        if (i9 != 0) {
            i7 = this.f15704s.a(this.f15705t, i7, i9);
            W.V(this.f15705t, i7 - left);
        }
        int i11 = i7;
        if (i10 != 0) {
            i8 = this.f15704s.b(this.f15705t, i8, i10);
            W.W(this.f15705t, i8 - top);
        }
        int i12 = i8;
        if (i9 == 0 && i10 == 0) {
            return;
        }
        this.f15704s.k(this.f15705t, i11, i12, i11 - left, i12 - top);
    }

    public final void q(int i7) {
        float[] fArr = this.f15689d;
        if (fArr == null || fArr.length <= i7) {
            int i8 = i7 + 1;
            float[] fArr2 = new float[i8];
            float[] fArr3 = new float[i8];
            float[] fArr4 = new float[i8];
            float[] fArr5 = new float[i8];
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int[] iArr3 = new int[i8];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f15690e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f15691f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f15692g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f15693h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f15694i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f15695j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f15689d = fArr2;
            this.f15690e = fArr3;
            this.f15691f = fArr4;
            this.f15692g = fArr5;
            this.f15693h = iArr;
            this.f15694i = iArr2;
            this.f15695j = iArr3;
        }
    }

    public View r(int i7, int i8) {
        for (int childCount = this.f15707v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f15707v.getChildAt(this.f15704s.c(childCount));
            if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && i8 >= childAt.getTop() && i8 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i7, int i8, int i9, int i10) {
        int left = this.f15705t.getLeft();
        int top = this.f15705t.getTop();
        int i11 = i7 - left;
        int i12 = i8 - top;
        if (i11 == 0 && i12 == 0) {
            this.f15703r.abortAnimation();
            E(0);
            return false;
        }
        this.f15703r.startScroll(left, top, i11, i12, j(this.f15705t, i11, i12, i9, i10));
        E(2);
        return true;
    }

    public final int t(int i7, int i8) {
        int i9 = i7 < this.f15707v.getLeft() + this.f15700o ? 1 : 0;
        if (i8 < this.f15707v.getTop() + this.f15700o) {
            i9 |= 4;
        }
        if (i7 > this.f15707v.getRight() - this.f15700o) {
            i9 |= 2;
        }
        return i8 > this.f15707v.getBottom() - this.f15700o ? i9 | 8 : i9;
    }

    public int u() {
        return this.f15687b;
    }

    public boolean v(int i7, int i8) {
        return y(this.f15705t, i7, i8);
    }

    public boolean w(int i7) {
        return ((1 << i7) & this.f15696k) != 0;
    }

    public final boolean x(int i7) {
        if (w(i7)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i7 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean y(View view, int i7, int i8) {
        return view != null && i7 >= view.getLeft() && i7 < view.getRight() && i8 >= view.getTop() && i8 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i7;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f15697l == null) {
            this.f15697l = VelocityTracker.obtain();
        }
        this.f15697l.addMovement(motionEvent);
        int i8 = 0;
        if (actionMasked == 0) {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x7, (int) y7);
            C(x7, y7, pointerId);
            I(viewR, pointerId);
            int i9 = this.f15693h[pointerId];
            int i10 = this.f15702q;
            if ((i9 & i10) != 0) {
                this.f15704s.h(i9 & i10, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f15686a == 1) {
                A();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f15686a == 1) {
                if (x(this.f15688c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f15688c);
                    float x8 = motionEvent.getX(iFindPointerIndex);
                    float y8 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f15691f;
                    int i11 = this.f15688c;
                    int i12 = (int) (x8 - fArr[i11]);
                    int i13 = (int) (y8 - this.f15692g[i11]);
                    p(this.f15705t.getLeft() + i12, this.f15705t.getTop() + i13, i12, i13);
                    D(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i8 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i8);
                if (x(pointerId2)) {
                    float x9 = motionEvent.getX(i8);
                    float y9 = motionEvent.getY(i8);
                    float f7 = x9 - this.f15689d[pointerId2];
                    float f8 = y9 - this.f15690e[pointerId2];
                    B(f7, f8, pointerId2);
                    if (this.f15686a != 1) {
                        View viewR2 = r((int) x9, (int) y9);
                        if (d(viewR2, f7, f8) && I(viewR2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i8++;
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f15686a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x10 = motionEvent.getX(actionIndex);
            float y10 = motionEvent.getY(actionIndex);
            C(x10, y10, pointerId3);
            if (this.f15686a != 0) {
                if (v((int) x10, (int) y10)) {
                    I(this.f15705t, pointerId3);
                    return;
                }
                return;
            } else {
                I(r((int) x10, (int) y10), pointerId3);
                int i14 = this.f15693h[pointerId3];
                int i15 = this.f15702q;
                if ((i14 & i15) != 0) {
                    this.f15704s.h(i14 & i15, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f15686a == 1 && pointerId4 == this.f15688c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i8 >= pointerCount2) {
                    i7 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i8);
                if (pointerId5 != this.f15688c) {
                    View viewR3 = r((int) motionEvent.getX(i8), (int) motionEvent.getY(i8));
                    View view = this.f15705t;
                    if (viewR3 == view && I(view, pointerId5)) {
                        i7 = this.f15688c;
                        break;
                    }
                }
                i8++;
            }
            if (i7 == -1) {
                A();
            }
        }
        h(pointerId4);
    }

    /* renamed from: f0.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0166c {
        public int a(View view, int i7, int i8) {
            return 0;
        }

        public int b(View view, int i7, int i8) {
            return 0;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public boolean g(int i7) {
            return false;
        }

        public abstract boolean m(View view, int i7);

        public int c(int i7) {
            return i7;
        }

        public void j(int i7) {
        }

        public void f(int i7, int i8) {
        }

        public void h(int i7, int i8) {
        }

        public void i(View view, int i7) {
        }

        public void l(View view, float f7, float f8) {
        }

        public void k(View view, int i7, int i8, int i9, int i10) {
        }
    }
}
