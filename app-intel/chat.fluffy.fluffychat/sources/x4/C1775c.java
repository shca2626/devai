package x4;

import M5.m;
import android.os.Handler;
import android.os.Looper;
import h5.c;

/* renamed from: x4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1775c implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public c.b f23738l;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f23739m = new Handler(Looper.getMainLooper());

    public static final void d(C1775c c1775c, Exception exc) {
        c.b bVar = c1775c.f23738l;
        if (bVar != null) {
            bVar.error("-1", exc.getMessage(), exc);
        }
    }

    public static final void f(C1775c c1775c, byte[] bArr) {
        c.b bVar = c1775c.f23738l;
        if (bVar != null) {
            bVar.success(bArr);
        }
    }

    public final void c(final Exception exc) {
        m.e(exc, "ex");
        this.f23739m.post(new Runnable() { // from class: x4.a
            @Override // java.lang.Runnable
            public final void run() {
                C1775c.d(this.f23734l, exc);
            }
        });
    }

    public final void e(final byte[] bArr) {
        m.e(bArr, "buffer");
        this.f23739m.post(new Runnable() { // from class: x4.b
            @Override // java.lang.Runnable
            public final void run() {
                C1775c.f(this.f23736l, bArr);
            }
        });
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
