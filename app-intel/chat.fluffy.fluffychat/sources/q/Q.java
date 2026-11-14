package q;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class Q implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: l, reason: collision with root package name */
    public final float f21120l;

    /* renamed from: m, reason: collision with root package name */
    public final int f21121m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21122n;

    /* renamed from: o, reason: collision with root package name */
    public final View f21123o;

    /* renamed from: p, reason: collision with root package name */
    public Runnable f21124p;

    /* renamed from: q, reason: collision with root package name */
    public Runnable f21125q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21126r;

    /* renamed from: s, reason: collision with root package name */
    public int f21127s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f21128t = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = Q.this.f21123o.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Q.this.e();
        }
    }

    public Q(View view) {
        this.f21123o = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f21120l = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f21121m = tapTimeout;
        this.f21122n = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f7, float f8, float f9) {
        float f10 = -f9;
        return f7 >= f10 && f8 >= f10 && f7 < ((float) (view.getRight() - view.getLeft())) + f9 && f8 < ((float) (view.getBottom() - view.getTop())) + f9;
    }

    public final void a() {
        Runnable runnable = this.f21125q;
        if (runnable != null) {
            this.f21123o.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f21124p;
        if (runnable2 != null) {
            this.f21123o.removeCallbacks(runnable2);
        }
    }

    public abstract p.f b();

    public abstract boolean c();

    public boolean d() {
        p.f fVarB = b();
        if (fVarB == null || !fVarB.a()) {
            return true;
        }
        fVarB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f21123o;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f21126r = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        O o7;
        View view = this.f21123o;
        p.f fVarB = b();
        if (fVarB != null && fVarB.a() && (o7 = (O) fVarB.j()) != null && o7.isShown()) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            i(view, motionEventObtainNoHistory);
            j(o7, motionEventObtainNoHistory);
            boolean zE = o7.e(motionEventObtainNoHistory, this.f21127s);
            motionEventObtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z7 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (zE && z7) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f21123o
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f21127s
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f21120l
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f21127s = r6
            java.lang.Runnable r6 = r5.f21124p
            if (r6 != 0) goto L52
            q.Q$a r6 = new q.Q$a
            r6.<init>()
            r5.f21124p = r6
        L52:
            java.lang.Runnable r6 = r5.f21124p
            int r1 = r5.f21121m
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f21125q
            if (r6 != 0) goto L65
            q.Q$b r6 = new q.Q$b
            r6.<init>()
            r5.f21125q = r6
        L65:
            java.lang.Runnable r6 = r5.f21125q
            int r1 = r5.f21122n
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q.Q.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f21128t);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f21128t);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z7;
        boolean z8 = this.f21126r;
        if (z8) {
            z7 = f(motionEvent) || !d();
        } else {
            z7 = g(motionEvent) && c();
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f21123o.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f21126r = z7;
        return z7 || z8;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f21126r = false;
        this.f21127s = -1;
        Runnable runnable = this.f21124p;
        if (runnable != null) {
            this.f21123o.removeCallbacks(runnable);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
