package com.paramsen.noise;

/* loaded from: classes.dex */
public final class NoiseNativeBridge {

    /* renamed from: a, reason: collision with root package name */
    public static final NoiseNativeBridge f14972a = new NoiseNativeBridge();

    static {
        System.loadLibrary("noise");
    }

    public final native void imaginary(float[] fArr, float[] fArr2, long j7);

    public final native long imaginaryConfigDispose(long j7);

    public final native void real(float[] fArr, float[] fArr2, long j7);

    public final native long realConfig(int i7);

    public final native long realConfigDispose(long j7);
}
