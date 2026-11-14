package s6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public class i extends k {

    /* renamed from: c, reason: collision with root package name */
    public final Method f22482c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f22483d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f22484e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f22485f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f22486g;

    public static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final List f22487a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f22488b;

        /* renamed from: c, reason: collision with root package name */
        public String f22489c;

        public a(List list) {
            this.f22487a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l6.c.f19669b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f22488b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f22487a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f22487a.contains(list.get(i7))) {
                            String str = (String) list.get(i7);
                            this.f22489c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f22487a.get(0);
                    this.f22489c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f22489c = (String) objArr[0];
            return null;
        }
    }

    public i(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f22482c = method;
        this.f22483d = method2;
        this.f22484e = method3;
        this.f22485f = cls;
        this.f22486g = cls2;
    }

    public static k v() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new i(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // s6.k
    public void a(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f22484e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e7) {
            throw l6.c.b("unable to remove alpn", e7);
        }
    }

    @Override // s6.k
    public void g(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f22482c.invoke(null, sSLSocket, Proxy.newProxyInstance(k.class.getClassLoader(), new Class[]{this.f22485f, this.f22486g}, new a(k.b(list))));
        } catch (IllegalAccessException | InvocationTargetException e7) {
            throw l6.c.b("unable to set alpn", e7);
        }
    }

    @Override // s6.k
    public String o(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f22483d.invoke(null, sSLSocket));
            boolean z7 = aVar.f22488b;
            if (!z7 && aVar.f22489c == null) {
                k.l().t(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z7) {
                return null;
            }
            return aVar.f22489c;
        } catch (IllegalAccessException e7) {
            e = e7;
            throw l6.c.b("unable to get selected protocol", e);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw l6.c.b("unable to get selected protocol", e);
        }
    }
}
