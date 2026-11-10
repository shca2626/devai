package T4;

import android.app.Activity;
import android.content.Context;
import c5.InterfaceC0910a;
import d5.InterfaceC0998a;
import d5.InterfaceC1000c;
import h5.j;

/* loaded from: classes.dex */
public class a implements InterfaceC0910a, InterfaceC0998a {

    /* renamed from: l, reason: collision with root package name */
    public j f8280l;

    /* renamed from: m, reason: collision with root package name */
    public c f8281m;

    public static String a() {
        return "[Flutter Shortcuts]";
    }

    public final void b(h5.b bVar, Context context, Activity activity) {
        this.f8280l = new j(bVar, "im.fluffychat.flutter_shortcuts_new");
        c cVar = new c(context, activity);
        this.f8281m = cVar;
        this.f8280l.e(cVar);
    }

    public final void c() {
        this.f8280l.e(null);
        this.f8280l = null;
        this.f8281m = null;
    }

    @Override // d5.InterfaceC0998a
    public void onAttachedToActivity(InterfaceC1000c interfaceC1000c) {
        this.f8281m.n(interfaceC1000c.getActivity());
    }

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        b(bVar.b(), bVar.a(), null);
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivity() {
        this.f8281m.n(null);
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        c();
    }

    @Override // d5.InterfaceC0998a
    public void onReattachedToActivityForConfigChanges(InterfaceC1000c interfaceC1000c) {
        onAttachedToActivity(interfaceC1000c);
    }
}
