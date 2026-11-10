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
import android.widget.Switch;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: U, reason: collision with root package name */
    public final a f12952U;

    /* renamed from: V, reason: collision with root package name */
    public CharSequence f12953V;

    /* renamed from: W, reason: collision with root package name */
    public CharSequence f12954W;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (SwitchPreference.this.a(Boolean.valueOf(z7))) {
                SwitchPreference.this.J(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f12952U = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7906J0, i7, i8);
        M(k.m(typedArrayObtainStyledAttributes, g.f7922R0, g.f7908K0));
        L(k.m(typedArrayObtainStyledAttributes, g.f7920Q0, g.f7910L0));
        P(k.m(typedArrayObtainStyledAttributes, g.f7926T0, g.f7914N0));
        O(k.m(typedArrayObtainStyledAttributes, g.f7924S0, g.f7916O0));
        K(k.b(typedArrayObtainStyledAttributes, g.f7918P0, g.f7912M0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void R(View view) {
        if (((AccessibilityManager) e().getSystemService("accessibility")).isEnabled()) {
            Q(view.findViewById(R.id.switch_widget));
            N(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void B(View view) {
        super.B(view);
        R(view);
    }

    public void O(CharSequence charSequence) {
        this.f12954W = charSequence;
        u();
    }

    public void P(CharSequence charSequence) {
        this.f12953V = charSequence;
        u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(View view) {
        boolean z7 = view instanceof Switch;
        if (z7) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f12960P);
        }
        if (z7) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.f12953V);
            r42.setTextOff(this.f12954W);
            r42.setOnCheckedChangeListener(this.f12952U);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7883j, R.attr.switchPreferenceStyle));
    }
}
