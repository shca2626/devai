package Y5;

import W5.AbstractC0632l0;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract /* synthetic */ class o {
    public static final void a(v vVar, Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = AbstractC0632l0.a("Channel was consumed, consumer had failed", th);
            }
        }
        vVar.d(cancellationExceptionA);
    }
}
