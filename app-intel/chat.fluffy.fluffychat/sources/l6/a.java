package l6;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import k6.A;
import k6.C;
import k6.C1286a;
import k6.e;
import k6.j;
import k6.k;
import k6.r;
import n6.g;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f19666a;

    public abstract void a(r.a aVar, String str);

    public abstract void b(r.a aVar, String str, String str2);

    public abstract void c(k kVar, SSLSocket sSLSocket, boolean z7);

    public abstract int d(A.a aVar);

    public abstract boolean e(j jVar, n6.c cVar);

    public abstract Socket f(j jVar, C1286a c1286a, g gVar);

    public abstract boolean g(C1286a c1286a, C1286a c1286a2);

    public abstract n6.c h(j jVar, C1286a c1286a, g gVar, C c7);

    public abstract void i(j jVar, n6.c cVar);

    public abstract n6.d j(j jVar);

    public abstract IOException k(e eVar, IOException iOException);
}
