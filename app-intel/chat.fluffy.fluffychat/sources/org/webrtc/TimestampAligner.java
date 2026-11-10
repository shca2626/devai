package org.webrtc;

/* loaded from: classes3.dex */
public class TimestampAligner {
    private volatile long nativeTimestampAligner;

    @Deprecated
    public TimestampAligner() {
        this(Environment.builder().build());
    }

    private void checkNativeAlignerExists() {
        if (this.nativeTimestampAligner == 0) {
            throw new IllegalStateException("TimestampAligner has been disposed.");
        }
    }

    @Deprecated
    public static long getRtcTimeNanos() {
        return Environment.builder().build().getCurrentTimeNanos();
    }

    private static native long nativeCreateTimestampAligner(long j7);

    private static native void nativeReleaseTimestampAligner(long j7);

    private static native long nativeTranslateTimestamp(long j7, long j8);

    public void dispose() {
        checkNativeAlignerExists();
        nativeReleaseTimestampAligner(this.nativeTimestampAligner);
        this.nativeTimestampAligner = 0L;
    }

    public long translateTimestamp(long j7) {
        checkNativeAlignerExists();
        return nativeTranslateTimestamp(this.nativeTimestampAligner, j7);
    }

    public TimestampAligner(Environment environment) {
        this.nativeTimestampAligner = nativeCreateTimestampAligner(environment.ref());
    }
}
