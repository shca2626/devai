package af1;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: classes12.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f999a = 5;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1000b = false;

    /* renamed from: c, reason: collision with root package name */
    private static float f1001c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private static int f1002d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static float f1003e;

    /* renamed from: f, reason: collision with root package name */
    private static float f1004f;

    /* renamed from: g, reason: collision with root package name */
    private static WeakReference f1005g;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1006a;

        a(View view) {
            this.f1006a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.f1006a.getLayoutParams();
            layoutParams.height = iIntValue;
            this.f1006a.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: af1.b$b, reason: collision with other inner class name */
    public interface InterfaceC0024b {
        void b();

        void f();
    }

    public static void a() {
        WeakReference weakReference = f1005g;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r0 < af1.b.f1002d) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104 A[PHI: r8
      0x0104: PHI (r8v4 int) = (r8v3 int), (r8v5 int), (r8v5 int) binds: [B:69:0x0102, B:64:0x00f4, B:59:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.view.MotionEvent r7, boolean r8, boolean r9, af1.b.InterfaceC0024b r10, android.view.View r11, android.view.ViewGroup.LayoutParams r12) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: af1.b.b(android.view.MotionEvent, boolean, boolean, af1.b$b, android.view.View, android.view.ViewGroup$LayoutParams):void");
    }

    private static void c(View view, int i12, int i13) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i12, i13);
        valueAnimatorOfInt.addUpdateListener(new a(view));
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.start();
    }

    public static void d(View view, MotionEvent motionEvent, InterfaceC0024b interfaceC0024b) {
        WeakReference weakReference = f1005g;
        if (weakReference == null || weakReference.get() == null) {
            f1005g = new WeakReference(interfaceC0024b);
        }
        View view2 = (View) view.getParent();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (f1002d == -1) {
            f1002d = layoutParams.height;
        }
        b(motionEvent, false, false, interfaceC0024b, view2, layoutParams);
    }

    public static void e(View view, MotionEvent motionEvent, boolean z12, boolean z13, InterfaceC0024b interfaceC0024b) {
        WeakReference weakReference = f1005g;
        if (weakReference == null || weakReference.get() == null) {
            f1005g = new WeakReference(interfaceC0024b);
        }
        ViewParent parent = view.getParent();
        Object parent2 = parent;
        if (!z12) {
            parent2 = parent.getParent().getParent().getParent();
        }
        View view2 = (View) parent2;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (f1002d == -1) {
            f1002d = layoutParams.height;
        }
        b(motionEvent, z12, z13, interfaceC0024b, view2, layoutParams);
    }

    private static boolean f(float f12, float f13, float f14, float f15) {
        float fAbs = Math.abs(f12 - f13);
        float fAbs2 = Math.abs(f14 - f15);
        float f16 = f999a;
        return fAbs <= f16 && fAbs2 <= f16;
    }

    public static void g() {
        f1002d = -1;
        f1001c = -1.0f;
    }
}
