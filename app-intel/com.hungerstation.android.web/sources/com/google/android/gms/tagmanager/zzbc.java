package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* loaded from: classes8.dex */
final class zzbc {
    final String zza;
    final byte[] zzb;

    zzbc(String str, byte[] bArr) {
        this.zza = str;
        this.zzb = bArr;
    }

    public final String toString() {
        return "KeyAndSerialized: key = " + this.zza + " serialized hash = " + Arrays.hashCode(this.zzb);
    }
}
