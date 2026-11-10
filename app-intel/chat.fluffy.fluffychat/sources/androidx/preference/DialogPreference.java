package androidx.preference;

import N.k;
import R1.c;
import R1.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: P, reason: collision with root package name */
    public CharSequence f12875P;

    /* renamed from: Q, reason: collision with root package name */
    public CharSequence f12876Q;

    /* renamed from: R, reason: collision with root package name */
    public Drawable f12877R;

    /* renamed from: S, reason: collision with root package name */
    public CharSequence f12878S;

    /* renamed from: T, reason: collision with root package name */
    public CharSequence f12879T;

    /* renamed from: U, reason: collision with root package name */
    public int f12880U;

    public DialogPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7960i, i7, i8);
        String strM = k.m(typedArrayObtainStyledAttributes, g.f7980s, g.f7962j);
        this.f12875P = strM;
        if (strM == null) {
            this.f12875P = q();
        }
        this.f12876Q = k.m(typedArrayObtainStyledAttributes, g.f7978r, g.f7964k);
        this.f12877R = k.c(typedArrayObtainStyledAttributes, g.f7974p, g.f7966l);
        this.f12878S = k.m(typedArrayObtainStyledAttributes, g.f7984u, g.f7968m);
        this.f12879T = k.m(typedArrayObtainStyledAttributes, g.f7982t, g.f7970n);
        this.f12880U = k.l(typedArrayObtainStyledAttributes, g.f7976q, g.f7972o, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void w() {
        n();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7875b, R.attr.dialogPreferenceStyle));
    }
}
