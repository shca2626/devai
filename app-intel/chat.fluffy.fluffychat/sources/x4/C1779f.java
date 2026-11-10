package x4;

import M5.m;
import android.os.Handler;
import android.os.Looper;
import h5.c;
import v4.EnumC1687d;

/* renamed from: x4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1779f implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public c.b f23738l;

    /* renamed from: m, reason: collision with root package name */
    public EnumC1687d f23739m = EnumC1687d.f23043o;

    /* renamed from: n, reason: collision with root package name */
    public final Handler f23740n = new Handler(Looper.getMainLooper());

    public static final void d(C1779f c1779f, Exception exc) {
        c.b bVar = c1779f.f23738l;
        if (bVar != null) {
            bVar.error("-1", exc.getMessage(), exc);
        }
    }

    public static final void f(C1779f c1779f, EnumC1687d enumC1687d) {
        c.b bVar = c1779f.f23738l;
        if (bVar != null) {
            bVar.success(Integer.valueOf(enumC1687d.d()));
        }
    }

    public final void c(final Exception exc) {
        m.e(exc, "ex");
        this.f23740n.post(new Runnable() { // from class: x4.e
            @Override // java.lang.Runnable
            public final void run() {
                C1779f.d(this.f23736l, exc);
            }
        });
    }

    public final void e(final EnumC1687d enumC1687d) {
        m.e(enumC1687d, "state");
        if (this.f23739m != enumC1687d) {
            this.f23739m = enumC1687d;
            this.f23740n.post(new Runnable() { // from class: x4.d
                @Override // java.lang.Runnable
                public final void run() {
                    C1779f.f(this.f23734l, enumC1687d);
                }
            });
        }
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        this.f23738l = null;
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        this.f23738l = bVar;
    }
}
