package androidx.preference;

import N.k;
import R1.c;
import R1.d;
import R1.g;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: U, reason: collision with root package name */
    public final a f12956U;

    /* renamed from: V, reason: collision with root package name */
    public CharSequence f12957V;

    /* renamed from: W, reason: collision with root package name */
    public CharSequence f12958W;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (SwitchPreferenceCompat.this.a(Boolean.valueOf(z7))) {
                SwitchPreferenceCompat.this.J(z7);
            } else {
                compoundButton.setChecked(!z7);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f12956U = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7928U0, i7, i8);
        M(k.m(typedArrayObtainStyledAttributes, g.f7947c1, g.f7930V0));
        L(k.m(typedArrayObtainStyledAttributes, g.f7944b1, g.f7932W0));
        P(k.m(typedArrayObtainStyledAttributes, g.f7953e1, g.f7936Y0));
        O(k.m(typedArrayObtainStyledAttributes, g.f7950d1, g.f7938Z0));
        K(k.b(typedArrayObtainStyledAttributes, g.f7941a1, g.f7934X0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Q(View view) throws Resources.NotFoundException {
        boolean z7 = view instanceof SwitchCompat;
        if (z7) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f12960P);
        }
        if (z7) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f12957V);
            switchCompat.setTextOff(this.f12958W);
            switchCompat.setOnCheckedChangeListener(this.f12956U);
        }
    }

    private void R(View view) throws Resources.NotFoundException {
        if (((AccessibilityManager) e().getSystemService("accessibility")).isEnabled()) {
            Q(view.findViewById(d.f7884a));
            N(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void B(View view) throws Resources.NotFoundException {
        super.B(view);
        R(view);
    }

    public void O(CharSequence charSequence) {
        this.f12958W = charSequence;
        u();
    }

    public void P(CharSequence charSequence) {
        this.f12957V = charSequence;
        u();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f7882i);
    }
}
