package com.fingerprintjs.android.fpjs_pro_internal;

import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public final class k0 extends Exception {

    /* renamed from: b, reason: collision with root package name */
    public final List f19916b;

    public k0(List list, TimeoutException timeoutException) {
        super(timeoutException);
        this.f19916b = list;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "";
    }
}
