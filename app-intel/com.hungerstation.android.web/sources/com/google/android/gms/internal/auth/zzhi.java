package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* loaded from: classes8.dex */
abstract class zzhi {
    final Unsafe zza;

    zzhi(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j12);

    public abstract float zzb(Object obj, long j12);

    public abstract void zzc(Object obj, long j12, boolean z12);

    public abstract void zzd(Object obj, long j12, double d12);

    public abstract void zze(Object obj, long j12, float f12);

    public abstract boolean zzf(Object obj, long j12);
}
