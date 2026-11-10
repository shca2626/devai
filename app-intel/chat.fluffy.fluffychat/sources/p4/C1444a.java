package p4;

import M5.g;
import M5.m;
import android.app.Activity;
import h5.n;

/* renamed from: p4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1444a implements n {

    /* renamed from: n, reason: collision with root package name */
    public static final C0240a f20784n = new C0240a(null);

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC1445b f20785l;

    /* renamed from: m, reason: collision with root package name */
    public Activity f20786m;

    /* renamed from: p4.a$a, reason: collision with other inner class name */
    public static final class C0240a {
        public /* synthetic */ C0240a(g gVar) {
            this();
        }

        public C0240a() {
        }
    }

    public final void a(boolean z7, InterfaceC1445b interfaceC1445b) {
        m.e(interfaceC1445b, "resultCallback");
        Activity activity = this.f20786m;
        if (activity == null) {
            interfaceC1445b.b(false);
            return;
        }
        m.b(activity);
        boolean zB = b(activity);
        if (zB || !z7) {
            interfaceC1445b.b(zB);
            return;
        }
        this.f20785l = interfaceC1445b;
        Activity activity2 = this.f20786m;
        m.b(activity2);
        K.b.r(activity2, new String[]{"android.permission.RECORD_AUDIO"}, 1001);
    }

    public final boolean b(Activity activity) {
        return L.b.a(activity, "android.permission.RECORD_AUDIO") == 0;
    }

    public final void c(Activity activity) {
        this.f20786m = activity;
    }

    @Override // h5.n
    public boolean onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        InterfaceC1445b interfaceC1445b;
        m.e(strArr, "permissions");
        m.e(iArr, "grantResults");
        boolean z7 = false;
        if (i7 != 1001 || (interfaceC1445b = this.f20785l) == null) {
            return false;
        }
        if (!(iArr.length == 0) && iArr[0] == 0) {
            z7 = true;
        }
        m.b(interfaceC1445b);
        interfaceC1445b.b(z7);
        this.f20785l = null;
        return true;
    }
}
