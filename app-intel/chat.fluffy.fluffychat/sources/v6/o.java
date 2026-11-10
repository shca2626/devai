package v6;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes3.dex */
public abstract class o {
    public static final y a(File file) {
        return p.b(file);
    }

    public static final y b() {
        return q.a();
    }

    public static final f c(y yVar) {
        return q.b(yVar);
    }

    public static final g d(A a7) {
        return q.c(a7);
    }

    public static final boolean e(AssertionError assertionError) {
        return p.c(assertionError);
    }

    public static final y f(File file) {
        return p.d(file);
    }

    public static final y g(File file, boolean z7) {
        return p.e(file, z7);
    }

    public static final y h(OutputStream outputStream) {
        return p.f(outputStream);
    }

    public static final y i(Socket socket) {
        return p.g(socket);
    }

    public static final A k(File file) {
        return p.i(file);
    }

    public static final A l(InputStream inputStream) {
        return p.j(inputStream);
    }

    public static final A m(Socket socket) {
        return p.k(socket);
    }
}
