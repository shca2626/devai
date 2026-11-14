package l5;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import g5.t;

/* renamed from: l5.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1315c implements t.b {

    /* renamed from: a, reason: collision with root package name */
    public Activity f19663a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19664b;

    /* renamed from: c, reason: collision with root package name */
    public final t f19665c;

    public C1315c(int i7, Activity activity, t tVar) {
        this.f19663a = activity;
        this.f19664b = i7;
        this.f19665c = tVar;
        tVar.f(this);
    }

    @Override // g5.t.b
    public boolean a() {
        return Build.VERSION.SDK_INT >= 35;
    }

    @Override // g5.t.b
    public int b() {
        if (!a()) {
            return 2;
        }
        View viewFindViewById = this.f19663a.findViewById(this.f19664b);
        if (viewFindViewById != null) {
            return viewFindViewById.getContentSensitivity();
        }
        throw new IllegalArgumentException(e());
    }

    @Override // g5.t.b
    public void c(int i7) {
        if (!a()) {
            throw new IllegalStateException(f());
        }
        View viewFindViewById = this.f19663a.findViewById(this.f19664b);
        if (viewFindViewById == null) {
            throw new IllegalArgumentException(e());
        }
        if (viewFindViewById.getContentSensitivity() == i7) {
            return;
        }
        viewFindViewById.setContentSensitivity(i7);
        viewFindViewById.invalidate();
    }

    public void d() {
        this.f19665c.f(null);
        this.f19663a = null;
    }

    public final String e() {
        return "FlutterView with ID " + this.f19664b + "not found";
    }

    public final String f() {
        return "isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.";
    }
}
