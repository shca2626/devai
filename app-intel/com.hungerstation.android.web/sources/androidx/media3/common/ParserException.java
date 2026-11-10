package androidx.media3.common;

import java.io.IOException;

/* loaded from: classes7.dex */
public class ParserException extends IOException {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8272b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8273c;

    protected ParserException(String str, Throwable th2, boolean z12, int i12) {
        super(str, th2);
        this.f8272b = z12;
        this.f8273c = i12;
    }

    public static ParserException a(String str, Throwable th2) {
        return new ParserException(str, th2, true, 1);
    }

    public static ParserException b(String str, Throwable th2) {
        return new ParserException(str, th2, true, 0);
    }

    public static ParserException c(String str, Throwable th2) {
        return new ParserException(str, th2, true, 4);
    }

    public static ParserException d(String str, Throwable th2) {
        return new ParserException(str, th2, false, 4);
    }

    public static ParserException e(String str) {
        return new ParserException(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + "{contentIsMalformed=" + this.f8272b + ", dataType=" + this.f8273c + "}";
    }
}
