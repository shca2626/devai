package e1;

import E0.AbstractC0332s;
import E0.U;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer$VsyncCallback;
import android.view.Surface;
import e1.u;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: b, reason: collision with root package name */
    public final Context f15566b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15567c;

    /* renamed from: d, reason: collision with root package name */
    public c f15568d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15569e;

    /* renamed from: f, reason: collision with root package name */
    public Surface f15570f;

    /* renamed from: h, reason: collision with root package name */
    public float f15572h;

    /* renamed from: i, reason: collision with root package name */
    public float f15573i;

    /* renamed from: l, reason: collision with root package name */
    public long f15576l;

    /* renamed from: m, reason: collision with root package name */
    public long f15577m;

    /* renamed from: n, reason: collision with root package name */
    public long f15578n;

    /* renamed from: o, reason: collision with root package name */
    public long f15579o;

    /* renamed from: p, reason: collision with root package name */
    public long f15580p;

    /* renamed from: q, reason: collision with root package name */
    public long f15581q;

    /* renamed from: r, reason: collision with root package name */
    public long f15582r;

    /* renamed from: s, reason: collision with root package name */
    public long f15583s;

    /* renamed from: t, reason: collision with root package name */
    public long f15584t;

    /* renamed from: a, reason: collision with root package name */
    public final C1023i f15565a = new C1023i();

    /* renamed from: g, reason: collision with root package name */
    public float f15571g = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f15574j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public int f15575k = 0;

    public static final class b {
        public static void a(Surface surface, float f7) {
            try {
                surface.setFrameRate(f7, f7 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e7) {
                AbstractC0332s.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e7);
            }
        }
    }

    public static abstract class c implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        public final Choreographer f15585a;

        /* renamed from: b, reason: collision with root package name */
        public final DisplayManager f15586b;

        /* renamed from: c, reason: collision with root package name */
        public volatile long f15587c;

        /* renamed from: d, reason: collision with root package name */
        public volatile long f15588d;

        public static c b(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return null;
            }
            try {
                Choreographer choreographer = Choreographer.getInstance();
                return Build.VERSION.SDK_INT >= 33 ? new e(choreographer, displayManager) : new d(choreographer, displayManager);
            } catch (RuntimeException e7) {
                AbstractC0332s.i("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e7);
                return null;
            }
        }

        public void c() {
            this.f15586b.registerDisplayListener(this, U.z());
        }

        public void d() {
            this.f15586b.unregisterDisplayListener(this);
        }

        public c(Choreographer choreographer, DisplayManager displayManager) {
            this.f15585a = choreographer;
            this.f15586b = displayManager;
            this.f15587c = -9223372036854775807L;
            this.f15588d = -9223372036854775807L;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i7) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i7) {
        }
    }

    public static final class d extends c implements Choreographer.FrameCallback {
        public static long e(DisplayManager displayManager) {
            if (displayManager.getDisplay(0) != null) {
                return (long) (1.0E9d / r4.getRefreshRate());
            }
            AbstractC0332s.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            return -9223372036854775807L;
        }

        @Override // e1.u.c
        public void c() {
            super.c();
            this.f15585a.postFrameCallback(this);
            this.f15588d = e(this.f15586b);
        }

        @Override // e1.u.c
        public void d() {
            super.d();
            this.f15585a.removeFrameCallback(this);
            this.f15587c = -9223372036854775807L;
            this.f15588d = -9223372036854775807L;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j7) {
            this.f15587c = j7;
            this.f15585a.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i7) {
            if (i7 == 0) {
                this.f15585a.postFrameCallback(this);
                this.f15588d = e(this.f15586b);
            }
        }

        public d(Choreographer choreographer, DisplayManager displayManager) {
            super(choreographer, displayManager);
        }
    }

    public static final class e extends c implements Choreographer$VsyncCallback {

        /* renamed from: e, reason: collision with root package name */
        public final Handler f15589e;

        @Override // e1.u.c
        public void c() {
            super.c();
            this.f15585a.postVsyncCallback(this);
        }

        @Override // e1.u.c
        public void d() {
            super.d();
            this.f15589e.removeCallbacksAndMessages(null);
            this.f15585a.removeVsyncCallback(this);
            this.f15587c = -9223372036854775807L;
            this.f15588d = -9223372036854775807L;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i7) {
            if (i7 == 0) {
                this.f15585a.postVsyncCallback(this);
            }
        }

        public void onVsync(Choreographer.FrameData frameData) {
            this.f15587c = frameData.getFrameTimeNanos();
            Choreographer.FrameTimeline[] frameTimelines = frameData.getFrameTimelines();
            if (frameTimelines.length >= 2) {
                long expectedPresentationTimeNanos = frameTimelines[1].getExpectedPresentationTimeNanos() - frameTimelines[0].getExpectedPresentationTimeNanos();
                this.f15588d = expectedPresentationTimeNanos != 0 ? expectedPresentationTimeNanos : -9223372036854775807L;
            } else {
                this.f15588d = -9223372036854775807L;
            }
            this.f15589e.postDelayed(new Runnable() { // from class: e1.B
                @Override // java.lang.Runnable
                public final void run() {
                    u.e eVar = this.f15322l;
                    eVar.f15585a.postVsyncCallback(eVar);
                }
            }, 500L);
        }

        public e(Choreographer choreographer, DisplayManager displayManager) {
            super(choreographer, displayManager);
            this.f15589e = U.z();
        }
    }

    public u(Context context) {
        this.f15566b = context;
    }

    public static boolean b(long j7, long j8) {
        return Math.abs(j7 - j8) <= 20000000;
    }

    public long a(long j7, long j8) {
        long j9;
        float fA;
        float f7;
        if (this.f15582r == -1) {
            j9 = j7;
        } else {
            if (this.f15565a.e()) {
                fA = this.f15565a.a() * (this.f15578n - this.f15582r);
                f7 = this.f15574j;
            } else {
                fA = (j8 - this.f15584t) * 1000;
                f7 = this.f15574j;
            }
            long j10 = this.f15583s + ((long) (fA / f7));
            if (b(j7, j10)) {
                j9 = j10;
            } else {
                l();
                j9 = j7;
            }
        }
        this.f15579o = this.f15578n;
        this.f15580p = j9;
        this.f15581q = j8;
        c cVar = this.f15568d;
        if (cVar != null) {
            long j11 = cVar.f15587c;
            long j12 = this.f15568d.f15588d;
            if (j11 != -9223372036854775807L && j12 != -9223372036854775807L) {
                return d(j9, j11, j12) - ((j12 * 80) / 100);
            }
        }
        return j9;
    }

    public final void c() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.f15570f) == null || this.f15575k == Integer.MIN_VALUE || this.f15573i == 0.0f || !surface.isValid()) {
            return;
        }
        this.f15573i = 0.0f;
        b.a(this.f15570f, 0.0f);
    }

    public final long d(long j7, long j8, long j9) {
        long j10;
        long j11 = j8 + (((j7 - j8) / j9) * j9);
        if (j7 <= j11) {
            j10 = j11 - j9;
        } else {
            j10 = j11;
            j11 += j9;
        }
        long j12 = j11 - j7;
        long j13 = j7 - j10;
        long jAbs = Math.abs(j12 - j13);
        if (jAbs < j9 / 2) {
            long j14 = j9 / 4;
            if (jAbs < j14) {
                long j15 = this.f15576l;
                if (j15 != 0) {
                    this.f15577m = j15;
                } else {
                    if (j12 < j13) {
                        j14 = -j14;
                    }
                    this.f15577m = j14;
                }
            } else {
                this.f15577m = 0L;
            }
        } else {
            this.f15577m = this.f15576l;
        }
        return j12 + this.f15577m < j13 ? j11 : j10;
    }

    public void e(float f7) {
        this.f15571g = f7;
        this.f15565a.g();
        n();
    }

    public void f(long j7) {
        long j8 = this.f15579o;
        if (j8 != -1) {
            this.f15582r = j8;
            this.f15583s = this.f15580p;
            this.f15584t = this.f15581q;
            this.f15576l = this.f15577m;
        }
        this.f15578n++;
        this.f15565a.f(j7 * 1000);
        n();
    }

    public void g(float f7) {
        this.f15574j = f7;
        o(false);
    }

    public void h() {
        l();
    }

    public void i() {
        this.f15569e = true;
        l();
        if (!this.f15567c) {
            this.f15568d = c.b(this.f15566b);
        }
        c cVar = this.f15568d;
        if (cVar != null) {
            cVar.c();
        }
        o(false);
    }

    public void j() {
        this.f15569e = false;
        c cVar = this.f15568d;
        if (cVar != null) {
            cVar.d();
        }
        c();
    }

    public void k(Surface surface) {
        if (this.f15570f == surface) {
            return;
        }
        c();
        this.f15570f = surface;
        o(true);
    }

    public final void l() {
        this.f15578n = 0L;
        this.f15582r = -1L;
        this.f15579o = -1L;
        this.f15576l = 0L;
        this.f15577m = 0L;
    }

    public void m(int i7) {
        if (this.f15575k == i7) {
            return;
        }
        this.f15575k = i7;
        o(true);
    }

    public final void n() {
        if (Build.VERSION.SDK_INT < 30 || this.f15570f == null) {
            return;
        }
        float fB = this.f15565a.e() ? this.f15565a.b() : this.f15571g;
        float f7 = this.f15572h;
        if (fB == f7) {
            return;
        }
        if (fB != -1.0f && f7 != -1.0f) {
            if (Math.abs(fB - this.f15572h) < ((!this.f15565a.e() || this.f15565a.d() < 5000000000L) ? 1.0f : 0.1f)) {
                return;
            }
        } else if (fB == -1.0f && this.f15565a.c() < 30) {
            return;
        }
        this.f15572h = fB;
        o(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(boolean r4) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L38
            android.view.Surface r0 = r3.f15570f
            if (r0 == 0) goto L38
            int r1 = r3.f15575k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r2) goto L38
            boolean r0 = r0.isValid()
            if (r0 != 0) goto L17
            goto L38
        L17:
            boolean r0 = r3.f15569e
            if (r0 == 0) goto L27
            float r0 = r3.f15572h
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 == 0) goto L27
            float r1 = r3.f15574j
            float r0 = r0 * r1
            goto L28
        L27:
            r0 = 0
        L28:
            if (r4 != 0) goto L31
            float r4 = r3.f15573i
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L31
            goto L38
        L31:
            r3.f15573i = r0
            android.view.Surface r4 = r3.f15570f
            e1.u.b.a(r4, r0)
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.u.o(boolean):void");
    }
}
