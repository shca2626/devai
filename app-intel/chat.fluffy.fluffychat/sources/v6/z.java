package v6;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: classes3.dex */
public final class z extends C1721c {

    /* renamed from: o, reason: collision with root package name */
    public final Socket f23237o;

    public z(Socket socket) {
        M5.m.e(socket, "socket");
        this.f23237o = socket;
    }

    @Override // v6.C1721c
    public void B() throws IOException {
        try {
            this.f23237o.close();
        } catch (AssertionError e7) {
            if (!o.e(e7)) {
                throw e7;
            }
            p.f23206a.log(Level.WARNING, "Failed to close timed out socket " + this.f23237o, (Throwable) e7);
        } catch (Exception e8) {
            p.f23206a.log(Level.WARNING, "Failed to close timed out socket " + this.f23237o, (Throwable) e8);
        }
    }

    @Override // v6.C1721c
    public IOException x(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
