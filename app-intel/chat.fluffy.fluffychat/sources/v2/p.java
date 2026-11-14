package v2;

import android.graphics.Bitmap;
import p2.InterfaceC1438a;
import p2.InterfaceC1440c;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final u f22971a;

    /* renamed from: b, reason: collision with root package name */
    public final y f22972b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1440c f22973c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1438a f22974d;

    public interface a {
        boolean a();

        Bitmap b();
    }

    public p(u uVar, y yVar, InterfaceC1440c interfaceC1440c, InterfaceC1438a interfaceC1438a) {
        M5.m.e(uVar, "strongMemoryCache");
        M5.m.e(yVar, "weakMemoryCache");
        M5.m.e(interfaceC1440c, "referenceCounter");
        M5.m.e(interfaceC1438a, "bitmapPool");
        this.f22971a = uVar;
        this.f22972b = yVar;
        this.f22973c = interfaceC1440c;
        this.f22974d = interfaceC1438a;
    }

    public final InterfaceC1438a a() {
        return this.f22974d;
    }

    public final InterfaceC1440c b() {
        return this.f22973c;
    }

    public final u c() {
        return this.f22971a;
    }

    public final y d() {
        return this.f22972b;
    }
}
