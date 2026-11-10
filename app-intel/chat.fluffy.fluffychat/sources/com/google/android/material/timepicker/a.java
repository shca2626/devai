package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes.dex */
public class a implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public int f14786a;

    public a(int i7) {
        this.f14786a = i7;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i9, i10, charSequence.subSequence(i7, i8).toString());
            if (Integer.parseInt(sb.toString()) <= this.f14786a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
