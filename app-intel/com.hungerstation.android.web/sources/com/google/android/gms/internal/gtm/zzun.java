package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes8.dex */
public final class zzun extends IOException {
    zzun() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzun(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    zzun(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
