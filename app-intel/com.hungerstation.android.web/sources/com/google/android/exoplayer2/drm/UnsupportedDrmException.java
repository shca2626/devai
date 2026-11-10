package com.google.android.exoplayer2.drm;

/* loaded from: classes8.dex */
public final class UnsupportedDrmException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    public final int f20560b;

    public UnsupportedDrmException(int i12) {
        this.f20560b = i12;
    }

    public UnsupportedDrmException(int i12, Exception exc) {
        super(exc);
        this.f20560b = i12;
    }
}
