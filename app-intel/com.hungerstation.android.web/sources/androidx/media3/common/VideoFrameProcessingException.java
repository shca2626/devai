package androidx.media3.common;

/* loaded from: classes7.dex */
public final class VideoFrameProcessingException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    public final long f8286b;

    public VideoFrameProcessingException(Throwable th2, long j12) {
        super(th2);
        this.f8286b = j12;
    }

    public static VideoFrameProcessingException a(Exception exc) {
        return b(exc, -9223372036854775807L);
    }

    public static VideoFrameProcessingException b(Exception exc, long j12) {
        return exc instanceof VideoFrameProcessingException ? (VideoFrameProcessingException) exc : new VideoFrameProcessingException(exc, j12);
    }
}
