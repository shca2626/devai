package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f22935a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private b f22936b = null;

    /* renamed from: c, reason: collision with root package name */
    ValueAnimator f22937c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f22938d = new a();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l lVar = l.this;
            if (lVar.f22937c == animator) {
                lVar.f22937c = null;
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int[] f22940a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f22941b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f22940a = iArr;
            this.f22941b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f22938d);
        this.f22935a.add(bVar);
    }
}
