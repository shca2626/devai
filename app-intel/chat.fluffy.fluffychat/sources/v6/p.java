package v6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class p {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f23206a = Logger.getLogger("okio.Okio");

    public static final y b(File file) {
        M5.m.e(file, "<this>");
        return o.h(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        M5.m.e(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? V5.y.B(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }

    public static final y d(File file) {
        M5.m.e(file, "<this>");
        return h(file, false, 1, null);
    }

    public static final y e(File file, boolean z7) {
        M5.m.e(file, "<this>");
        return o.h(new FileOutputStream(file, z7));
    }

    public static final y f(OutputStream outputStream) {
        M5.m.e(outputStream, "<this>");
        return new r(outputStream, new B());
    }

    public static final y g(Socket socket) throws IOException {
        M5.m.e(socket, "<this>");
        z zVar = new z(socket);
        OutputStream outputStream = socket.getOutputStream();
        M5.m.d(outputStream, "getOutputStream()");
        return zVar.z(new r(outputStream, zVar));
    }

    public static /* synthetic */ y h(File file, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return o.g(file, z7);
    }

    public static final A i(File file) {
        M5.m.e(file, "<this>");
        return new n(new FileInputStream(file), B.f23157e);
    }

    public static final A j(InputStream inputStream) {
        M5.m.e(inputStream, "<this>");
        return new n(inputStream, new B());
    }

    public static final A k(Socket socket) throws IOException {
        M5.m.e(socket, "<this>");
        z zVar = new z(socket);
        InputStream inputStream = socket.getInputStream();
        M5.m.d(inputStream, "getInputStream()");
        return zVar.A(new n(inputStream, zVar));
    }
}
