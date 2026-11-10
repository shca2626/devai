package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes8.dex */
final class zzhb {
    private final long zza;
    private final long zzb;
    private String zzc;
    private String zzd;
    private Map zze;
    private String zzf;

    zzhb(long j12, long j13, long j14) {
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
        return this.zzf;
    }

    final String zzd() {
        return this.zzd;
    }

    final String zze() {
        return this.zzc;
    }

    final Map zzf() {
        return this.zze;
    }

    final void zzg(String str) {
        this.zzf = str;
    }

    final void zzh(Map map) {
        this.zze = map;
    }

    final void zzi(String str) {
        this.zzd = str;
    }

    final void zzj(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return;
        }
        this.zzc = str;
    }
}
