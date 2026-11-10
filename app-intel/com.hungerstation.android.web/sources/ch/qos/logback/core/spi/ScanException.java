package ch.qos.logback.core.spi;

/* loaded from: classes7.dex */
public class ScanException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    Throwable f17201b;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f17201b;
    }
}
