package com.google.android.gms.internal.gtm;

/* loaded from: classes8.dex */
final class zzxe {
    private final Object zza;
    private final int zzb;

    zzxe(Object obj, int i12) {
        this.zza = obj;
        this.zzb = i12;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxe)) {
            return false;
        }
        zzxe zzxeVar = (zzxe) obj;
        return this.zza == zzxeVar.zza && this.zzb == zzxeVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
