package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: classes7.dex */
public class f {
    public static Interpolator a(Context context, int i12) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(context, i12);
    }
}
