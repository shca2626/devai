package androidx.media3.exoplayer.drm;

/* loaded from: classes7.dex */
public final class UnsupportedDrmException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    public final int f8893b;

    public UnsupportedDrmException(int i12) {
        this.f8893b = i12;
    }

    public UnsupportedDrmException(int i12, Exception exc) {
        super(exc);
        this.f8893b = i12;
    }
}
