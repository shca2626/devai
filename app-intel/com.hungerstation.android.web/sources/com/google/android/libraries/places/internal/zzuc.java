package com.google.android.libraries.places.internal;

/* loaded from: classes8.dex */
final class zzuc extends IllegalArgumentException {
    zzuc(int i12, int i13) {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Unpaired surrogate at index ");
        sb2.append(i12);
        sb2.append(" of ");
        sb2.append(i13);
        super(sb2.toString());
    }
}
