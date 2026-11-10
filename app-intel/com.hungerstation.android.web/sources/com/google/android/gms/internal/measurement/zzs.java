package com.google.android.gms.internal.measurement;

/* loaded from: classes8.dex */
public enum zzs {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    zzs(int i12) {
    }

    public static zzs zza(int i12) {
        return i12 != 2 ? i12 != 3 ? i12 != 5 ? i12 != 6 ? INFO : ERROR : WARN : DEBUG : VERBOSE;
    }
}
