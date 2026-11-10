package k5;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import c5.InterfaceC0910a;
import d5.InterfaceC0998a;
import d5.InterfaceC1000c;
import g5.q;
import h5.j;
import h5.l;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c implements InterfaceC0910a, InterfaceC0998a, l, q.b {

    /* renamed from: l, reason: collision with root package name */
    public final q f19108l;

    /* renamed from: m, reason: collision with root package name */
    public final PackageManager f19109m;

    /* renamed from: n, reason: collision with root package name */
    public InterfaceC1000c f19110n;

    /* renamed from: o, reason: collision with root package name */
    public Map f19111o;

    /* renamed from: p, reason: collision with root package name */
    public Map f19112p = new HashMap();

    public c(q qVar) {
        this.f19108l = qVar;
        this.f19109m = qVar.f16443b;
        qVar.b(this);
    }

    @Override // g5.q.b
    public void a(String str, String str2, boolean z7, j.d dVar) {
        if (this.f19110n == null) {
            dVar.error("error", "Plugin not bound to an Activity", null);
            return;
        }
        Map map = this.f19111o;
        if (map == null) {
            dVar.error("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) map.get(str);
        if (resolveInfo == null) {
            dVar.error("error", "Text processing activity not found", null);
            return;
        }
        int iHashCode = dVar.hashCode();
        this.f19112p.put(Integer.valueOf(iHashCode), dVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z7);
        this.f19110n.getActivity().startActivityForResult(intent, iHashCode);
    }

    @Override // g5.q.b
    public Map b() {
        if (this.f19111o == null) {
            c();
        }
        HashMap map = new HashMap();
        for (String str : this.f19111o.keySet()) {
            map.put(str, ((ResolveInfo) this.f19111o.get(str)).loadLabel(this.f19109m).toString());
        }
        return map;
    }

    public final void c() {
        this.f19111o = new HashMap();
        Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        for (ResolveInfo resolveInfo : Build.VERSION.SDK_INT >= 33 ? this.f19109m.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0L)) : this.f19109m.queryIntentActivities(type, 0)) {
            this.f19111o.put(resolveInfo.activityInfo.name, resolveInfo);
        }
    }

    @Override // h5.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        if (!this.f19112p.containsKey(Integer.valueOf(i7))) {
            return false;
        }
        ((j.d) this.f19112p.remove(Integer.valueOf(i7))).success(i8 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
        return true;
    }

    @Override // d5.InterfaceC0998a
    public void onAttachedToActivity(InterfaceC1000c interfaceC1000c) {
        this.f19110n = interfaceC1000c;
        interfaceC1000c.d(this);
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivity() {
        this.f19110n.b(this);
        this.f19110n = null;
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivityForConfigChanges() {
        this.f19110n.b(this);
        this.f19110n = null;
    }

    @Override // d5.InterfaceC0998a
    public void onReattachedToActivityForConfigChanges(InterfaceC1000c interfaceC1000c) {
        this.f19110n = interfaceC1000c;
        interfaceC1000c.d(this);
    }

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
    }
}
