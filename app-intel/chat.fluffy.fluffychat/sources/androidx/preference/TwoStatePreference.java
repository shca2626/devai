package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: P, reason: collision with root package name */
    public boolean f12960P;

    /* renamed from: Q, reason: collision with root package name */
    public CharSequence f12961Q;

    /* renamed from: R, reason: collision with root package name */
    public CharSequence f12962R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f12963S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f12964T;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
    }

    @Override // androidx.preference.Preference
    public boolean G() {
        return (this.f12964T ? this.f12960P : !this.f12960P) || super.G();
    }

    public boolean I() {
        return this.f12960P;
    }

    public void J(boolean z7) {
        boolean z8 = this.f12960P != z7;
        if (z8 || !this.f12963S) {
            this.f12960P = z7;
            this.f12963S = true;
            C(z7);
            if (z8) {
                v(G());
                u();
            }
        }
    }

    public void K(boolean z7) {
        this.f12964T = z7;
    }

    public void L(CharSequence charSequence) {
        this.f12962R = charSequence;
        if (I()) {
            return;
        }
        u();
    }

    public void M(CharSequence charSequence) {
        this.f12961Q = charSequence;
        if (I()) {
            u();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void N(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.f12960P
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r4.f12961Q
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r4.f12961Q
            r5.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r4.f12960P
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.f12962R
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.f12962R
            r5.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r2 = r4.o()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3e
            r5.setText(r2)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.N(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    public void w() {
        super.w();
        boolean z7 = !I();
        if (a(Boolean.valueOf(z7))) {
            J(z7);
        }
    }

    @Override // androidx.preference.Preference
    public Object y(TypedArray typedArray, int i7) {
        return Boolean.valueOf(typedArray.getBoolean(i7, false));
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
