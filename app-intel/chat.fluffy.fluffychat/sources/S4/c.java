package S4;

import M5.m;
import android.app.Activity;
import android.view.Window;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8195a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f8196b;

    public final void a() {
        Window window;
        Activity activity = this.f8196b;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        if (this.f8195a) {
            window.addFlags(128);
        } else {
            window.clearFlags(128);
        }
    }

    public final a b() {
        return new a(Boolean.valueOf(this.f8195a));
    }

    public final void c(Activity activity) {
        this.f8196b = activity;
        if (this.f8195a) {
            a();
        }
    }

    public final void d(b bVar) {
        m.e(bVar, "message");
        Boolean boolA = bVar.a();
        m.b(boolA);
        this.f8195a = boolA.booleanValue();
        a();
    }
}
