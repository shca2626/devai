package com.google.android.gms.measurement.internal;

import com.incognia.core.f1;

/* loaded from: classes.dex */
public enum zzjb {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED(f1.f34733k),
    GRANTED("granted");

    private final String zzf;

    zzjb(String str) {
        this.zzf = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzf;
    }
}
