package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes8.dex */
public final class zziz {
    public static <T> T zza(Bundle bundle, String str, Class<T> cls, T t12) {
        T t13 = (T) bundle.get(str);
        if (t13 == null) {
            return t12;
        }
        if (cls.isAssignableFrom(t13.getClass())) {
            return t13;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", str, cls.getCanonicalName(), t13.getClass().getCanonicalName()));
    }

    public static void zza(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }
}
