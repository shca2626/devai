package androidx.preference;

import N.k;
import R1.c;
import android.R;
import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
    }

    @Override // androidx.preference.Preference
    public boolean G() {
        return !super.s();
    }

    @Override // androidx.preference.Preference
    public boolean s() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7878e, R.attr.preferenceCategoryStyle));
    }
}
