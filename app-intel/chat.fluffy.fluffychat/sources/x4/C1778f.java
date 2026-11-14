package x4;

import M5.m;
import android.os.Handler;
import android.os.Looper;
import h5.c;
import v4.EnumC1686d;

/* renamed from: x4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1778f implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public c.b f23744l;

    /* renamed from: m, reason: collision with root package name */
    public EnumC1686d f23745m = EnumC1686d.f23049o;

    /* renamed from: n, reason: collision with root package name */
    public final Handler f23746n = new Handler(Looper.getMainLooper());

    public static final void d(C1778f c1778f, Exception exc) {
        c.b bVar = c1778f.f23744l;
        if (bVar != null) {
            bVar.error("-1", exc.getMessage(), exc);
        }
    }

    public static final void f(C1778f c1778f, EnumC1686d enumC1686d) {
        c.b bVar = c1778f.f23744l;
        if (bVar != null) {
            bVar.success(Integer.valueOf(enumC1686d.d()));
        }
    }

    public final void c(final Exception exc) {
        m.e(exc, "ex");
        this.f23746n.post(new Runnable() { // from class: x4.e
            @Override // java.lang.Runnable
            public final void run() {
                C1778f.d(this.f23742l, exc);
            }
        });
    }

    public final void e(final EnumC1686d enumC1686d) {
        m.e(enumC1686d, "state");
        if (this.f23745m != enumC1686d) {
            this.f23745m = enumC1686d;
            this.f23746n.post(new Runnable() { // from class: x4.d
                @Override // java.lang.Runnable
                public final void run() {
                    C1778f.f(this.f23740l, enumC1686d);
                }
            });
        }
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        this.f23744l = null;
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        this.f23744l = bVar;
    }
}
