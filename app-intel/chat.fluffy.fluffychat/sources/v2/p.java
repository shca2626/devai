package v2;

import android.graphics.Bitmap;
import p2.InterfaceC1439a;
import p2.InterfaceC1441c;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final u f22965a;

    /* renamed from: b, reason: collision with root package name */
    public final y f22966b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1441c f22967c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1439a f22968d;

    public interface a {
        boolean a();

        Bitmap b();
    }

    public p(u uVar, y yVar, InterfaceC1441c interfaceC1441c, InterfaceC1439a interfaceC1439a) {
        M5.m.e(uVar, "strongMemoryCache");
        M5.m.e(yVar, "weakMemoryCache");
        M5.m.e(interfaceC1441c, "referenceCounter");
        M5.m.e(interfaceC1439a, "bitmapPool");
        this.f22965a = uVar;
        this.f22966b = yVar;
        this.f22967c = interfaceC1441c;
        this.f22968d = interfaceC1439a;
    }

    public final InterfaceC1439a a() {
        return this.f22968d;
    }

    public final InterfaceC1441c b() {
        return this.f22967c;
    }

    public final u c() {
        return this.f22965a;
    }

    public final y d() {
        return this.f22966b;
    }
}
