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
import android.util.Log;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: V, reason: collision with root package name */
    public CharSequence[] f12888V;

    /* renamed from: W, reason: collision with root package name */
    public CharSequence[] f12889W;

    /* renamed from: X, reason: collision with root package name */
    public String f12890X;

    /* renamed from: Y, reason: collision with root package name */
    public String f12891Y;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f12892Z;

    public static final class a implements Preference.b {

        /* renamed from: a, reason: collision with root package name */
        public static a f12893a;

        public static a b() {
            if (f12893a == null) {
                f12893a = new a();
            }
            return f12893a;
        }

        @Override // androidx.preference.Preference.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.K()) ? listPreference.e().getString(f.f7886a) : listPreference.K();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7990x, i7, i8);
        this.f12888V = k.o(typedArrayObtainStyledAttributes, g.f7887A, g.f7992y);
        this.f12889W = k.o(typedArrayObtainStyledAttributes, g.f7889B, g.f7994z);
        int i9 = g.f7891C;
        if (k.b(typedArrayObtainStyledAttributes, i9, i9, false)) {
            F(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.f7903I, i7, i8);
        this.f12891Y = k.m(typedArrayObtainStyledAttributes2, g.f7977q0, g.f7919Q);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public int I(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f12889W) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.f12889W[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] J() {
        return this.f12888V;
    }

    public CharSequence K() {
        CharSequence[] charSequenceArr;
        int iN = N();
        if (iN < 0 || (charSequenceArr = this.f12888V) == null) {
            return null;
        }
        return charSequenceArr[iN];
    }

    public CharSequence[] L() {
        return this.f12889W;
    }

    public String M() {
        return this.f12890X;
    }

    public final int N() {
        return I(this.f12890X);
    }

    public void O(String str) {
        boolean zEquals = TextUtils.equals(this.f12890X, str);
        if (zEquals && this.f12892Z) {
            return;
        }
        this.f12890X = str;
        this.f12892Z = true;
        E(str);
        if (zEquals) {
            return;
        }
        u();
    }

    @Override // androidx.preference.Preference
    public CharSequence o() {
        if (p() != null) {
            return p().a(this);
        }
        CharSequence charSequenceK = K();
        CharSequence charSequenceO = super.o();
        String str = this.f12891Y;
        if (str != null) {
            if (charSequenceK == null) {
                charSequenceK = "";
            }
            String str2 = String.format(str, charSequenceK);
            if (!TextUtils.equals(str2, charSequenceO)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceO;
    }

    @Override // androidx.preference.Preference
    public Object y(TypedArray typedArray, int i7) {
        return typedArray.getString(i7);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, c.f7875b, R.attr.dialogPreferenceStyle));
    }
}
