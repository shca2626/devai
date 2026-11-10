package com.google.android.recaptcha.internal;

/* loaded from: classes8.dex */
final class zzgc {
    static void zza(boolean z12, String str, long j12, long j13) {
        if (z12) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j12 + ", " + j13 + ")");
    }

    static void zzb(boolean z12) {
        if (!z12) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
