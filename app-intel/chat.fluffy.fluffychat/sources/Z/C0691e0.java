package Z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: Z.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0691e0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f10016a;

    /* renamed from: Z.e0$a */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0693f0 f10017a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f10018b;

        public a(InterfaceC0693f0 interfaceC0693f0, View view) {
            this.f10017a = interfaceC0693f0;
            this.f10018b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10017a.a(this.f10018b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10017a.b(this.f10018b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f10017a.c(this.f10018b);
        }
    }

    public C0691e0(View view) {
        this.f10016a = new WeakReference(view);
    }

    public C0691e0 b(float f7) {
        View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().alpha(f7);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f10016a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public C0691e0 e(long j7) {
        View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().setDuration(j7);
        }
        return this;
    }

    public C0691e0 f(Interpolator interpolator) {
        View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public C0691e0 g(InterfaceC0693f0 interfaceC0693f0) {
        View view = (View) this.f10016a.get();
        if (view != null) {
            h(view, interfaceC0693f0);
        }
        return this;
    }

    public final void h(View view, InterfaceC0693f0 interfaceC0693f0) {
        if (interfaceC0693f0 != null) {
            view.animate().setListener(new a(interfaceC0693f0, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public C0691e0 i(long j7) {
        View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().setStartDelay(j7);
        }
        return this;
    }

    public C0691e0 j(final InterfaceC0697h0 interfaceC0697h0) {
        final View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().setUpdateListener(interfaceC0697h0 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: Z.d0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    interfaceC0697h0.a(view);
                }
            } : null);
        }
        return this;
    }

    public void k() {
        View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public C0691e0 l(float f7) {
        View view = (View) this.f10016a.get();
        if (view != null) {
            view.animate().translationY(f7);
        }
        return this;
    }
}
