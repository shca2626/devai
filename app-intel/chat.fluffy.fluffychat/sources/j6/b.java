package j6;

import M5.m;
import c5.InterfaceC0910a;
import d5.InterfaceC0998a;
import d5.InterfaceC1000c;
import io.flutter.plugin.platform.InterfaceC1181m;

/* loaded from: classes3.dex */
public final class b implements InterfaceC0910a, InterfaceC0998a {

    /* renamed from: l, reason: collision with root package name */
    public static final a f18784l = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    @Override // d5.InterfaceC0998a
    public void onAttachedToActivity(InterfaceC1000c interfaceC1000c) {
        m.e(interfaceC1000c, "activityPluginBinding");
        h hVar = h.f18806a;
        hVar.c(interfaceC1000c.getActivity());
        hVar.d(interfaceC1000c);
    }

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
        InterfaceC1181m interfaceC1181mD = bVar.d();
        h5.b bVarB = bVar.b();
        m.d(bVarB, "getBinaryMessenger(...)");
        interfaceC1181mD.a("net.touchcapture.qr.flutterqrplus/qrview", new f(bVarB));
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivity() {
        h hVar = h.f18806a;
        hVar.c(null);
        hVar.d(null);
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivityForConfigChanges() {
        h hVar = h.f18806a;
        hVar.c(null);
        hVar.d(null);
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "binding");
    }

    @Override // d5.InterfaceC0998a
    public void onReattachedToActivityForConfigChanges(InterfaceC1000c interfaceC1000c) {
        m.e(interfaceC1000c, "activityPluginBinding");
        h hVar = h.f18806a;
        hVar.c(interfaceC1000c.getActivity());
        hVar.d(interfaceC1000c);
    }
}
