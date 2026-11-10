package com.bumptech.glide.load;

import java.io.IOException;

/* loaded from: classes7.dex */
public final class HttpException extends IOException {

    /* renamed from: b, reason: collision with root package name */
    private final int f19101b;

    public HttpException(int i12) {
        this("Http request failed", i12);
    }

    public HttpException(String str, int i12) {
        this(str, i12, null);
    }

    public HttpException(String str, int i12, Throwable th2) {
        super(str + ", status code: " + i12, th2);
        this.f19101b = i12;
    }
}
