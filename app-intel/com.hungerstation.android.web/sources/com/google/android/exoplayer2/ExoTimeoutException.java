package com.google.android.exoplayer2;

/* loaded from: classes8.dex */
public final class ExoTimeoutException extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    public final int f20102b;

    public ExoTimeoutException(int i12) {
        super(a(i12));
        this.f20102b = i12;
    }

    private static String a(int i12) {
        return i12 != 1 ? i12 != 2 ? i12 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}
