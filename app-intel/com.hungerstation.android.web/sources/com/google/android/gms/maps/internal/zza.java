package com.google.android.gms.maps.internal;

/* loaded from: classes.dex */
public final class zza {
    public static byte zza(Boolean bool) {
        if (bool != null) {
            return !bool.booleanValue() ? (byte) 0 : (byte) 1;
        }
        return (byte) -1;
    }

    public static Boolean zzb(byte b12) {
        if (b12 == 0) {
            return Boolean.FALSE;
        }
        if (b12 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }
}
