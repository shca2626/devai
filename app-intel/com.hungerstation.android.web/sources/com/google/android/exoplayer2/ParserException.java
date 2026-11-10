package com.google.android.exoplayer2;

import java.io.IOException;

/* loaded from: classes8.dex */
public class ParserException extends IOException {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20106b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20107c;

    protected ParserException(String str, Throwable th2, boolean z12, int i12) {
        super(str, th2);
        this.f20106b = z12;
        this.f20107c = i12;
    }

    public static ParserException a(String str, Throwable th2) {
        return new ParserException(str, th2, true, 1);
    }

    public static ParserException b(String str, Throwable th2) {
        return new ParserException(str, th2, true, 0);
    }

    public static ParserException c(String str, Throwable th2) {
        return new ParserException(str, th2, true, 4);
    }

    public static ParserException d(String str) {
        return new ParserException(str, null, false, 1);
    }
}
