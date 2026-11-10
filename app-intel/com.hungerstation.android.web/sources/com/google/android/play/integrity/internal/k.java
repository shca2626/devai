package com.google.android.play.integrity.internal;

/* loaded from: classes8.dex */
public final class k {
    public static void a(Object obj, Class cls) {
        if (obj == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
