package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
/* loaded from: classes8.dex */
public final class zzah {
    static Object[] zza(Object[] objArr, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (objArr[i13] == null) {
                throw new NullPointerException("at index " + i13);
            }
        }
        return objArr;
    }
}
