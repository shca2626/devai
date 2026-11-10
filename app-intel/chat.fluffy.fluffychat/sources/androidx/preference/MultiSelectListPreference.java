package androidx.preference;

import N.k;
import R1.c;
import R1.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: V, reason: collision with root package name */
    public CharSequence[] f12894V;

    /* renamed from: W, reason: collision with root package name */
    public CharSequence[] f12895W;

    /* renamed from: X, reason: collision with root package name */
    public Set f12896X;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f12896X = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7893D, i7, i8);
        this.f12894V = k.o(typedArrayObtainStyledAttributes, g.f7899G, g.f7895E);
        this.f12895W = k.o(typedArrayObtainStyledAttributes, g.f7901H, g.f7897F);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public Object y(TypedArray typedArray, int i7) {
        CharSequence[] textArray = typedArray.getTextArray(i7);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7875b, R.attr.dialogPreferenceStyle));
    }
}
