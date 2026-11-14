package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import v.AbstractC1672a;

@Deprecated
/* loaded from: classes.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: l, reason: collision with root package name */
    public final int f11610l;

    /* renamed from: m, reason: collision with root package name */
    public final int f11611m;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11610l = getResources().getDimensionPixelOffset(AbstractC1672a.f22903b);
        this.f11611m = getResources().getDimensionPixelOffset(AbstractC1672a.f22902a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f11610l * 2), this.f11611m), 1073741824), i8);
    }
}
