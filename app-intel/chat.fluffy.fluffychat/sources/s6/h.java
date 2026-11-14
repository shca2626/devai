package s6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public final class h extends k {

    /* renamed from: c, reason: collision with root package name */
    public final Method f22480c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f22481d;

    public h(Method method, Method method2) {
        this.f22480c = method;
        this.f22481d = method2;
    }

    public static h v() {
        try {
            return new h(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // s6.k
    public void g(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List listB = k.b(list);
            this.f22480c.invoke(sSLParameters, listB.toArray(new String[listB.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e7) {
            throw l6.c.b("unable to set ssl parameters", e7);
        }
    }

    @Override // s6.k
    public String o(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f22481d.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e7) {
            throw l6.c.b("failed to get ALPN selected protocol", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw l6.c.b("failed to get ALPN selected protocol", e8);
        }
    }
}
