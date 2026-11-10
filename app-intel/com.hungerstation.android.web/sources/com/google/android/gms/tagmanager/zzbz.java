package com.google.android.gms.tagmanager;

import android.text.TextUtils;

/* loaded from: classes8.dex */
final class zzbz {
    private final long zza;
    private final long zzb;
    private String zzc;

    zzbz(long j12, long j13, long j14) {
        this.zza = j12;
        this.zzb = j14;
    }

    final long zza() {
        return this.zzb;
    }

    final long zzb() {
        return this.zza;
    }

    final String zzc() {
        return this.zzc;
    }

    final void zzd(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return;
        }
        this.zzc = str;
    }
}
