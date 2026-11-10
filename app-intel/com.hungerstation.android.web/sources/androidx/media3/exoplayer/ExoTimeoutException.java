package androidx.media3.exoplayer;

/* loaded from: classes7.dex */
public final class ExoTimeoutException extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    public final int f8417b;

    public ExoTimeoutException(int i12) {
        super(a(i12));
        this.f8417b = i12;
    }

    private static String a(int i12) {
        return i12 != 1 ? i12 != 2 ? i12 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}
