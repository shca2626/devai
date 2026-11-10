package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class zzqp {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzqp zzc;
    private static final zzqp zzd = new zzqp(true);
    private final Map<Object, Object> zze;

    zzqp() {
        this.zze = new HashMap();
    }

    public static zzqp zza() {
        zzqp zzqpVar = zzc;
        if (zzqpVar == null) {
            synchronized (zzqp.class) {
                try {
                    zzqpVar = zzc;
                    if (zzqpVar == null) {
                        zzqpVar = zzd;
                        zzc = zzqpVar;
                    }
                } finally {
                }
            }
        }
        return zzqpVar;
    }

    private zzqp(boolean z12) {
        this.zze = Collections.emptyMap();
    }
}
