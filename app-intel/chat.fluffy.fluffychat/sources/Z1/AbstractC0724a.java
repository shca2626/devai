package Z1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: Z1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0724a {
    public static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public static void b(Animator animator) {
        animator.pause();
    }

    public static void c(Animator animator) {
        animator.resume();
    }
}
