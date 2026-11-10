package androidx.preference;

import N.k;
import R1.c;
import R1.f;
import R1.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: V, reason: collision with root package name */
    public String f12886V;

    public static final class a implements Preference.b {

        /* renamed from: a, reason: collision with root package name */
        public static a f12887a;

        public static a b() {
            if (f12887a == null) {
                f12887a = new a();
            }
            return f12887a;
        }

        @Override // androidx.preference.Preference.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.I()) ? editTextPreference.e().getString(f.f7886a) : editTextPreference.I();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7986v, i7, i8);
        int i9 = g.f7988w;
        if (k.b(typedArrayObtainStyledAttributes, i9, i9, false)) {
            F(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public boolean G() {
        return TextUtils.isEmpty(this.f12886V) || super.G();
    }

    public String I() {
        return this.f12886V;
    }

    @Override // androidx.preference.Preference
    public Object y(TypedArray typedArray, int i7) {
        return typedArray.getString(i7);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7877d, R.attr.editTextPreferenceStyle));
    }
}
