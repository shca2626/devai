package v2;

import android.graphics.Bitmap;
import p2.InterfaceC1440c;
import v2.p;

/* loaded from: classes.dex */
public interface u {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22996a = a.f22997a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f22997a = new a();

        public final u a(y yVar, InterfaceC1440c interfaceC1440c, int i7, C2.l lVar) {
            M5.m.e(yVar, "weakMemoryCache");
            M5.m.e(interfaceC1440c, "referenceCounter");
            return i7 > 0 ? new q(yVar, interfaceC1440c, i7, lVar) : yVar instanceof r ? new f(yVar) : c.f22921b;
        }
    }

    void a(int i7);

    p.a b(m mVar);

    void c(m mVar, Bitmap bitmap, boolean z7);
}
