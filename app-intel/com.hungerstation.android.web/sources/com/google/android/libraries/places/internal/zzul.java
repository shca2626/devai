package com.google.android.libraries.places.internal;

/* loaded from: classes8.dex */
public final class zzul {
    public static <T> T zza(T t12) {
        t12.getClass();
        return t12;
    }

    public static <T> T zza(T t12, String str) {
        if (t12 != null) {
            return t12;
        }
        throw new NullPointerException(str);
    }

    public static <T> void zza(T t12, Class<T> cls) {
        if (t12 == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
