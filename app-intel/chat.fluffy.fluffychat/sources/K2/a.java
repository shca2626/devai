package K2;

import M5.m;
import c5.InterfaceC0910a;

/* loaded from: classes.dex */
public final class a implements InterfaceC0910a {
    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "binding");
    }
}
