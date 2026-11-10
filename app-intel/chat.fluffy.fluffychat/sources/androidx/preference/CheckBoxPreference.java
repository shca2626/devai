package androidx.preference;

import N.k;
import R1.c;
import R1.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: U, reason: collision with root package name */
    public final a f12873U;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (CheckBoxPreference.this.a(Boolean.valueOf(z7))) {
                CheckBoxPreference.this.J(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    @Override // androidx.preference.Preference
    public void B(View view) {
        super.B(view);
        P(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O(View view) {
        boolean z7 = view instanceof CompoundButton;
        if (z7) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f12960P);
        }
        if (z7) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f12873U);
        }
    }

    public final void P(View view) {
        if (((AccessibilityManager) e().getSystemService("accessibility")).isEnabled()) {
            O(view.findViewById(R.id.checkbox));
            N(view.findViewById(R.id.summary));
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f12873U = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7942b, i7, i8);
        M(k.m(typedArrayObtainStyledAttributes, g.f7958h, g.f7945c));
        L(k.m(typedArrayObtainStyledAttributes, g.f7956g, g.f7948d));
        K(k.b(typedArrayObtainStyledAttributes, g.f7954f, g.f7951e, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7874a, R.attr.checkBoxPreferenceStyle));
    }
}
