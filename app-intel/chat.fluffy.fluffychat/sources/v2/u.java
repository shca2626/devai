package v2;

import android.graphics.Bitmap;
import p2.InterfaceC1441c;
import v2.p;

/* loaded from: classes.dex */
public interface u {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22990a = a.f22991a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f22991a = new a();

        public final u a(y yVar, InterfaceC1441c interfaceC1441c, int i7, C2.l lVar) {
            M5.m.e(yVar, "weakMemoryCache");
            M5.m.e(interfaceC1441c, "referenceCounter");
            return i7 > 0 ? new q(yVar, interfaceC1441c, i7, lVar) : yVar instanceof r ? new f(yVar) : c.f22915b;
        }
    }

    void a(int i7);

    p.a b(m mVar);

    void c(m mVar, Bitmap bitmap, boolean z7);
}
