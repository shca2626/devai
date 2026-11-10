package W5;

import java.util.concurrent.CancellationException;

/* renamed from: W5.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0631l0 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
