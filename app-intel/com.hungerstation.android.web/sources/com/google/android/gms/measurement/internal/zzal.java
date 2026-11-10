package com.google.android.gms.measurement.internal;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;

/* loaded from: classes8.dex */
enum zzal {
    UNSET('0'),
    REMOTE_DEFAULT(ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzl;

    zzal(char c12) {
        this.zzl = c12;
    }

    public static zzal zza(char c12) {
        for (zzal zzalVar : values()) {
            if (zzalVar.zzl == c12) {
                return zzalVar;
            }
        }
        return UNSET;
    }
}
