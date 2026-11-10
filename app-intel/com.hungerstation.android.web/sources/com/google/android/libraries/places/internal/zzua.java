package com.google.android.libraries.places.internal;

/* loaded from: classes8.dex */
abstract class zzua {
    zzua() {
    }

    abstract int zza(int i12, byte[] bArr, int i13, int i14);

    abstract int zza(CharSequence charSequence, byte[] bArr, int i12, int i13);

    final boolean zza(byte[] bArr, int i12, int i13) {
        return zza(0, bArr, i12, i13) == 0;
    }
}
