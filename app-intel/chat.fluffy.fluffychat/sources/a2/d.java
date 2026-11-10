package a2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;

/* loaded from: classes.dex */
public abstract class d {
    public static Animator a(Context context, int i7) {
        return AnimatorInflater.loadAnimator(context, i7);
    }
}
