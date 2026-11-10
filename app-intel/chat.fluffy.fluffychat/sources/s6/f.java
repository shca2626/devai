package s6;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public class f extends k {

    /* renamed from: c, reason: collision with root package name */
    public final Class f22461c;

    /* renamed from: d, reason: collision with root package name */
    public final j f22462d;

    /* renamed from: e, reason: collision with root package name */
    public final j f22463e;

    /* renamed from: f, reason: collision with root package name */
    public final j f22464f;

    /* renamed from: g, reason: collision with root package name */
    public final j f22465g;

    /* renamed from: h, reason: collision with root package name */
    public final c f22466h = c.b();

    public static final class a extends u6.c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f22467a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f22468b;

        public a(Object obj, Method method) {
            this.f22467a = obj;
            this.f22468b = method;
        }

        @Override // u6.c
        public List a(List list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f22468b.invoke(this.f22467a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e7) {
                throw new AssertionError(e7);
            } catch (InvocationTargetException e8) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e8.getMessage());
                sSLPeerUnverifiedException.initCause(e8);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class b implements u6.e {

        /* renamed from: a, reason: collision with root package name */
        public final X509TrustManager f22469a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f22470b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f22470b = method;
            this.f22469a = x509TrustManager;
        }

        @Override // u6.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f22470b.invoke(this.f22469a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e7) {
                throw l6.c.b("unable to get issues and signature", e7);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f22469a.equals(bVar.f22469a) && this.f22470b.equals(bVar.f22470b);
        }

        public int hashCode() {
            return this.f22469a.hashCode() + (this.f22470b.hashCode() * 31);
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Method f22471a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f22472b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f22473c;

        public c(Method method, Method method2, Method method3) {
            this.f22471a = method;
            this.f22472b = method2;
            this.f22473c = method3;
        }

        public static c b() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }

        public Object a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f22471a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, null);
                    this.f22472b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean c(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.f22473c.invoke(obj, null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public f(Class cls, j jVar, j jVar2, j jVar3, j jVar4) {
        this.f22461c = cls;
        this.f22462d = jVar;
        this.f22463e = jVar2;
        this.f22464f = jVar3;
        this.f22465g = jVar4;
    }

    public static k x() {
        Class<?> cls;
        j jVar;
        j jVar2;
        try {
            if (!k.q()) {
                return null;
            }
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            j jVar3 = new j(null, "setUseSessionTickets", Boolean.TYPE);
            j jVar4 = new j(null, "setHostname", String.class);
            if (z()) {
                jVar = new j(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                jVar2 = new j(null, "setAlpnProtocols", byte[].class);
            } else {
                jVar = null;
                jVar2 = null;
            }
            return new f(cls2, jVar3, jVar4, jVar, jVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    public static int y() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    public static boolean z() throws ClassNotFoundException {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // s6.k
    public u6.c c(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // s6.k
    public u6.e d(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // s6.k
    public void g(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f22462d.e(sSLSocket, Boolean.TRUE);
            this.f22463e.e(sSLSocket, str);
        }
        j jVar = this.f22465g;
        if (jVar == null || !jVar.g(sSLSocket)) {
            return;
        }
        this.f22465g.f(sSLSocket, k.e(list));
    }

    @Override // s6.k
    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i7) throws IOException {
        try {
            socket.connect(inetSocketAddress, i7);
        } catch (AssertionError e7) {
            if (!l6.c.y(e7)) {
                throw e7;
            }
            throw new IOException(e7);
        } catch (ClassCastException e8) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e8;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e8);
            throw iOException;
        } catch (SecurityException e9) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e9);
            throw iOException2;
        }
    }

    @Override // s6.k
    public SSLContext n() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e7) {
            throw new IllegalStateException("No TLS provider", e7);
        }
    }

    @Override // s6.k
    public String o(SSLSocket sSLSocket) {
        byte[] bArr;
        j jVar = this.f22464f;
        if (jVar == null || !jVar.g(sSLSocket) || (bArr = (byte[]) this.f22464f.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, l6.c.f19678j);
    }

    @Override // s6.k
    public Object p(String str) {
        return this.f22466h.a(str);
    }

    @Override // s6.k
    public boolean r(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return w(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.r(str);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw l6.c.b("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e8) {
            e = e8;
            throw l6.c.b("unable to determine cleartext support", e);
        } catch (InvocationTargetException e9) {
            e = e9;
            throw l6.c.b("unable to determine cleartext support", e);
        }
    }

    @Override // s6.k
    public void t(int i7, String str, Throwable th) {
        int iMin;
        int i8 = i7 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i9 = 0;
        while (i9 < length) {
            int iIndexOf = str.indexOf(10, i9);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i9 + 4000);
                Log.println(i8, "OkHttp", str.substring(i9, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i9 = iMin;
                }
            }
            i9 = iMin + 1;
        }
    }

    @Override // s6.k
    public void u(String str, Object obj) {
        if (this.f22466h.c(obj)) {
            return;
        }
        t(5, str, null);
    }

    public final boolean v(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.r(str);
        }
    }

    public final boolean w(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return v(str, cls, obj);
        }
    }
}
