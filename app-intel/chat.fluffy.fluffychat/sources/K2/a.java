package K2;

import M5.m;
import c5.InterfaceC0911a;

/* loaded from: classes.dex */
public final class a implements InterfaceC0911a {
    @Override // c5.InterfaceC0911a
    public void onAttachedToEngine(InterfaceC0911a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
    }

    @Override // c5.InterfaceC0911a
    public void onDetachedFromEngine(InterfaceC0911a.b bVar) {
        m.e(bVar, "binding");
    }
}
