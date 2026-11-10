package org.webrtc;

/* loaded from: classes3.dex */
class Histogram {
    private final long handle;

    private Histogram(long j7) {
        this.handle = j7;
    }

    public static Histogram createCounts(String str, int i7, int i8, int i9) {
        return new Histogram(nativeCreateCounts(str, i7, i8, i9));
    }

    public static Histogram createEnumeration(String str, int i7) {
        return new Histogram(nativeCreateEnumeration(str, i7));
    }

    private static native void nativeAddSample(long j7, int i7);

    private static native long nativeCreateCounts(String str, int i7, int i8, int i9);

    private static native long nativeCreateEnumeration(String str, int i7);

    public void addSample(int i7) {
        nativeAddSample(this.handle, i7);
    }
}
