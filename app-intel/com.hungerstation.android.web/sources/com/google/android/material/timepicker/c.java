package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes8.dex */
class c implements InputFilter {

    /* renamed from: b, reason: collision with root package name */
    private int f23567b;

    public c(int i12) {
        this.f23567b = i12;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i12, int i13, Spanned spanned, int i14, int i15) {
        try {
            StringBuilder sb2 = new StringBuilder(spanned);
            sb2.replace(i14, i15, charSequence.subSequence(i12, i13).toString());
            if (Integer.parseInt(sb2.toString()) <= this.f23567b) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
