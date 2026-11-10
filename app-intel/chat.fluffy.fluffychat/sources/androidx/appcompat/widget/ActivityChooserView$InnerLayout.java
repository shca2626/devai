package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import q.d0;

/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f11351l = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d0 d0VarU = d0.u(context, attributeSet, f11351l);
        setBackgroundDrawable(d0VarU.g(0));
        d0VarU.w();
    }
}
