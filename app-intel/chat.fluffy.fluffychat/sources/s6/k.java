package s6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import k6.v;
import k6.w;

/* loaded from: classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f22493a = k();

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f22494b = Logger.getLogger(v.class.getName());

    public static List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            w wVar = (w) list.get(i7);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public static byte[] e(List list) {
        v6.e eVar = new v6.e();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            w wVar = (w) list.get(i7);
            if (wVar != w.HTTP_1_0) {
                eVar.writeByte(wVar.toString().length());
                eVar.v(wVar.toString());
            }
        }
        return eVar.y();
    }

    public static k i() {
        k kVarX = e.x();
        if (kVarX != null) {
            return kVarX;
        }
        k kVarX2 = f.x();
        if (kVarX2 != null) {
            return kVarX2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    public static k j() {
        g gVarV;
        if (s() && (gVarV = g.v()) != null) {
            return gVarV;
        }
        h hVarV = h.v();
        if (hVarV != null) {
            return hVarV;
        }
        k kVarV = i.v();
        return kVarV != null ? kVarV : new k();
    }

    public static k k() {
        return q() ? i() : j();
    }

    public static k l() {
        return f22493a;
    }

    public static boolean q() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean s() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public u6.c c(X509TrustManager x509TrustManager) {
        return new u6.a(d(x509TrustManager));
    }

    public u6.e d(X509TrustManager x509TrustManager) {
        return new u6.b(x509TrustManager.getAcceptedIssuers());
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i7) throws IOException {
        socket.connect(inetSocketAddress, i7);
    }

    public String m() {
        return "OkHttp";
    }

    public SSLContext n() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e7) {
            throw new IllegalStateException("No TLS provider", e7);
        }
    }

    public String o(SSLSocket sSLSocket) {
        return null;
    }

    public Object p(String str) {
        if (f22494b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean r(String str) {
        return true;
    }

    public void t(int i7, String str, Throwable th) {
        f22494b.log(i7 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void u(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        t(5, str, (Throwable) obj);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void g(SSLSocket sSLSocket, String str, List list) {
    }
}
