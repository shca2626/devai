package androidx.preference;

import N.k;
import R1.c;
import android.R;
import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: X, reason: collision with root package name */
    public boolean f12937X;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, k.a(context, c.f7879f, R.attr.preferenceScreenStyle));
        this.f12937X = true;
    }

    @Override // androidx.preference.Preference
    public void w() {
        if (i() == null && h() == null && J() != 0) {
            n();
            throw null;
        }
    }
}
