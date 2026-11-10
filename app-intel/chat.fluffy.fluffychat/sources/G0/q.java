package G0;

import j3.AbstractC1229c;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public class q extends g {

    /* renamed from: m, reason: collision with root package name */
    public final j f3208m;

    /* renamed from: n, reason: collision with root package name */
    public final int f3209n;

    public q(j jVar, int i7, int i8) {
        super(a(i7, i8));
        this.f3208m = jVar;
        this.f3209n = i8;
    }

    public static int a(int i7, int i8) {
        if (i7 == 2000 && i8 == 1) {
            return 2001;
        }
        return i7;
    }

    public static q b(IOException iOException, j jVar, int i7) {
        String message = iOException.getMessage();
        int i8 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !AbstractC1229c.f(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i8 == 2007 ? new p(iOException, jVar) : new q(iOException, jVar, i8, i7);
    }

    public q(String str, j jVar, int i7, int i8) {
        super(str, a(i7, i8));
        this.f3208m = jVar;
        this.f3209n = i8;
    }

    public q(IOException iOException, j jVar, int i7, int i8) {
        super(iOException, a(i7, i8));
        this.f3208m = jVar;
        this.f3209n = i8;
    }

    public q(String str, IOException iOException, j jVar, int i7, int i8) {
        super(str, iOException, a(i7, i8));
        this.f3208m = jVar;
        this.f3209n = i8;
    }
}
