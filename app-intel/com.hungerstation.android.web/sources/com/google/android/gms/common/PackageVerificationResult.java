package com.google.android.gms.common;

/* loaded from: classes8.dex */
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;
    private final String zzc;
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i12, boolean z12, String str2, Throwable th2) {
        this.zza = str;
        this.zzb = z12;
        this.zzc = str2;
        this.zzd = th2;
    }

    public static PackageVerificationResult zza(String str, String str2, Throwable th2) {
        return new PackageVerificationResult(str, 1, false, str2, th2);
    }

    public static PackageVerificationResult zzd(String str, int i12) {
        return new PackageVerificationResult(str, i12, true, null, null);
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        String str = this.zzc;
        Throwable th2 = this.zzd;
        String strConcat = "PackageVerificationRslt: ".concat(String.valueOf(str));
        if (th2 == null) {
            throw new SecurityException(strConcat);
        }
        throw new SecurityException(strConcat, th2);
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
