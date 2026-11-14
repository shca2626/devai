package c0;

import Z.W;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.fasterxml.jackson.core.JsonLocation;

/* renamed from: c0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0890a implements View.OnTouchListener {

    /* renamed from: C, reason: collision with root package name */
    public static final int f13826C = ViewConfiguration.getTapTimeout();

    /* renamed from: A, reason: collision with root package name */
    public boolean f13827A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f13828B;

    /* renamed from: n, reason: collision with root package name */
    public final View f13831n;

    /* renamed from: o, reason: collision with root package name */
    public Runnable f13832o;

    /* renamed from: r, reason: collision with root package name */
    public int f13835r;

    /* renamed from: s, reason: collision with root package name */
    public int f13836s;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13840w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13841x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13842y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f13843z;

    /* renamed from: l, reason: collision with root package name */
    public final C0135a f13829l = new C0135a();

    /* renamed from: m, reason: collision with root package name */
    public final Interpolator f13830m = new AccelerateInterpolator();

    /* renamed from: p, reason: collision with root package name */
    public float[] f13833p = {0.0f, 0.0f};

    /* renamed from: q, reason: collision with root package name */
    public float[] f13834q = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: t, reason: collision with root package name */
    public float[] f13837t = {0.0f, 0.0f};

    /* renamed from: u, reason: collision with root package name */
    public float[] f13838u = {0.0f, 0.0f};

    /* renamed from: v, reason: collision with root package name */
    public float[] f13839v = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: c0.a$a, reason: collision with other inner class name */
    public static class C0135a {

        /* renamed from: a, reason: collision with root package name */
        public int f13844a;

        /* renamed from: b, reason: collision with root package name */
        public int f13845b;

        /* renamed from: c, reason: collision with root package name */
        public float f13846c;

        /* renamed from: d, reason: collision with root package name */
        public float f13847d;

        /* renamed from: j, reason: collision with root package name */
        public float f13853j;

        /* renamed from: k, reason: collision with root package name */
        public int f13854k;

        /* renamed from: e, reason: collision with root package name */
        public long f13848e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        public long f13852i = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f13849f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f13850g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f13851h = 0;

        public void a() {
            if (this.f13849f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j7 = jCurrentAnimationTimeMillis - this.f13849f;
            this.f13849f = jCurrentAnimationTimeMillis;
            float f7 = j7 * fG;
            this.f13850g = (int) (this.f13846c * f7);
            this.f13851h = (int) (f7 * this.f13847d);
        }

        public int b() {
            return this.f13850g;
        }

        public int c() {
            return this.f13851h;
        }

        public int d() {
            float f7 = this.f13846c;
            return (int) (f7 / Math.abs(f7));
        }

        public final float e(long j7) {
            if (j7 < this.f13848e) {
                return 0.0f;
            }
            long j8 = this.f13852i;
            if (j8 < 0 || j7 < j8) {
                return AbstractViewOnTouchListenerC0890a.e((j7 - r0) / this.f13844a, 0.0f, 1.0f) * 0.5f;
            }
            float f7 = this.f13853j;
            return (1.0f - f7) + (f7 * AbstractViewOnTouchListenerC0890a.e((j7 - j8) / this.f13854k, 0.0f, 1.0f));
        }

        public int f() {
            float f7 = this.f13847d;
            return (int) (f7 / Math.abs(f7));
        }

        public final float g(float f7) {
            return ((-4.0f) * f7 * f7) + (f7 * 4.0f);
        }

        public boolean h() {
            return this.f13852i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f13852i + ((long) this.f13854k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f13854k = AbstractViewOnTouchListenerC0890a.f((int) (jCurrentAnimationTimeMillis - this.f13848e), 0, this.f13845b);
            this.f13853j = e(jCurrentAnimationTimeMillis);
            this.f13852i = jCurrentAnimationTimeMillis;
        }

        public void j(int i7) {
            this.f13845b = i7;
        }

        public void k(int i7) {
            this.f13844a = i7;
        }

        public void l(float f7, float f8) {
            this.f13846c = f7;
            this.f13847d = f8;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f13848e = jCurrentAnimationTimeMillis;
            this.f13852i = -1L;
            this.f13849f = jCurrentAnimationTimeMillis;
            this.f13853j = 0.5f;
            this.f13850g = 0;
            this.f13851h = 0;
        }
    }

    /* renamed from: c0.a$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnTouchListenerC0890a abstractViewOnTouchListenerC0890a = AbstractViewOnTouchListenerC0890a.this;
            if (abstractViewOnTouchListenerC0890a.f13843z) {
                if (abstractViewOnTouchListenerC0890a.f13841x) {
                    abstractViewOnTouchListenerC0890a.f13841x = false;
                    abstractViewOnTouchListenerC0890a.f13829l.m();
                }
                C0135a c0135a = AbstractViewOnTouchListenerC0890a.this.f13829l;
                if (c0135a.h() || !AbstractViewOnTouchListenerC0890a.this.u()) {
                    AbstractViewOnTouchListenerC0890a.this.f13843z = false;
                    return;
                }
                AbstractViewOnTouchListenerC0890a abstractViewOnTouchListenerC0890a2 = AbstractViewOnTouchListenerC0890a.this;
                if (abstractViewOnTouchListenerC0890a2.f13842y) {
                    abstractViewOnTouchListenerC0890a2.f13842y = false;
                    abstractViewOnTouchListenerC0890a2.c();
                }
                c0135a.a();
                AbstractViewOnTouchListenerC0890a.this.j(c0135a.b(), c0135a.c());
                W.d0(AbstractViewOnTouchListenerC0890a.this.f13831n, this);
            }
        }
    }

    public AbstractViewOnTouchListenerC0890a(View view) {
        this.f13831n = view;
        float f7 = Resources.getSystem().getDisplayMetrics().density;
        float f8 = (int) ((1575.0f * f7) + 0.5f);
        o(f8, f8);
        float f9 = (int) ((f7 * 315.0f) + 0.5f);
        p(f9, f9);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f13826C);
        r(JsonLocation.MAX_CONTENT_SNIPPET);
        q(JsonLocation.MAX_CONTENT_SNIPPET);
    }

    public static float e(float f7, float f8, float f9) {
        return f7 > f9 ? f9 : f7 < f8 ? f8 : f7;
    }

    public static int f(int i7, int i8, int i9) {
        return i7 > i9 ? i9 : i7 < i8 ? i8 : i7;
    }

    public abstract boolean a(int i7);

    public abstract boolean b(int i7);

    public void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f13831n.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final float d(int i7, float f7, float f8, float f9) {
        float fH = h(this.f13833p[i7], f8, this.f13834q[i7], f7);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f10 = this.f13837t[i7];
        float f11 = this.f13838u[i7];
        float f12 = this.f13839v[i7];
        float f13 = f10 * f9;
        return fH > 0.0f ? e(fH * f13, f11, f12) : -e((-fH) * f13, f11, f12);
    }

    public final float g(float f7, float f8) {
        if (f8 == 0.0f) {
            return 0.0f;
        }
        int i7 = this.f13835r;
        if (i7 == 0 || i7 == 1) {
            if (f7 < f8) {
                if (f7 >= 0.0f) {
                    return 1.0f - (f7 / f8);
                }
                if (this.f13843z && i7 == 1) {
                    return 1.0f;
                }
            }
        } else if (i7 == 2 && f7 < 0.0f) {
            return f7 / (-f8);
        }
        return 0.0f;
    }

    public final float h(float f7, float f8, float f9, float f10) {
        float interpolation;
        float fE = e(f7 * f8, 0.0f, f9);
        float fG = g(f8 - f10, fE) - g(f10, fE);
        if (fG < 0.0f) {
            interpolation = -this.f13830m.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f13830m.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f13841x) {
            this.f13843z = false;
        } else {
            this.f13829l.i();
        }
    }

    public abstract void j(int i7, int i8);

    public AbstractViewOnTouchListenerC0890a k(int i7) {
        this.f13836s = i7;
        return this;
    }

    public AbstractViewOnTouchListenerC0890a l(int i7) {
        this.f13835r = i7;
        return this;
    }

    public AbstractViewOnTouchListenerC0890a m(boolean z7) {
        if (this.f13827A && !z7) {
            i();
        }
        this.f13827A = z7;
        return this;
    }

    public AbstractViewOnTouchListenerC0890a n(float f7, float f8) {
        float[] fArr = this.f13834q;
        fArr[0] = f7;
        fArr[1] = f8;
        return this;
    }

    public AbstractViewOnTouchListenerC0890a o(float f7, float f8) {
        float[] fArr = this.f13839v;
        fArr[0] = f7 / 1000.0f;
        fArr[1] = f8 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f13827A
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f13842y = r2
            r5.f13840w = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f13831n
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f13831n
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            c0.a$a r7 = r5.f13829l
            r7.l(r0, r6)
            boolean r6 = r5.f13843z
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f13828B
            if (r6 == 0) goto L61
            boolean r6 = r5.f13843z
            if (r6 == 0) goto L61
            return r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.AbstractViewOnTouchListenerC0890a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public AbstractViewOnTouchListenerC0890a p(float f7, float f8) {
        float[] fArr = this.f13838u;
        fArr[0] = f7 / 1000.0f;
        fArr[1] = f8 / 1000.0f;
        return this;
    }

    public AbstractViewOnTouchListenerC0890a q(int i7) {
        this.f13829l.j(i7);
        return this;
    }

    public AbstractViewOnTouchListenerC0890a r(int i7) {
        this.f13829l.k(i7);
        return this;
    }

    public AbstractViewOnTouchListenerC0890a s(float f7, float f8) {
        float[] fArr = this.f13833p;
        fArr[0] = f7;
        fArr[1] = f8;
        return this;
    }

    public AbstractViewOnTouchListenerC0890a t(float f7, float f8) {
        float[] fArr = this.f13837t;
        fArr[0] = f7 / 1000.0f;
        fArr[1] = f8 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0135a c0135a = this.f13829l;
        int iF = c0135a.f();
        int iD = c0135a.d();
        if (iF == 0 || !b(iF)) {
            return iD != 0 && a(iD);
        }
        return true;
    }

    public final void v() {
        int i7;
        if (this.f13832o == null) {
            this.f13832o = new b();
        }
        this.f13843z = true;
        this.f13841x = true;
        if (this.f13840w || (i7 = this.f13836s) <= 0) {
            this.f13832o.run();
        } else {
            W.e0(this.f13831n, this.f13832o, i7);
        }
        this.f13840w = true;
    }
}
