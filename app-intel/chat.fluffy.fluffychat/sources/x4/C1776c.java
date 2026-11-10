package x4;

import M5.m;
import android.os.Handler;
import android.os.Looper;
import h5.c;

/* renamed from: x4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1776c implements c.d {

    /* renamed from: l, reason: collision with root package name */
    public c.b f23732l;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f23733m = new Handler(Looper.getMainLooper());

    public static final void d(C1776c c1776c, Exception exc) {
        c.b bVar = c1776c.f23732l;
        if (bVar != null) {
            bVar.error("-1", exc.getMessage(), exc);
        }
    }

    public static final void f(C1776c c1776c, byte[] bArr) {
        c.b bVar = c1776c.f23732l;
        if (bVar != null) {
            bVar.success(bArr);
        }
    }

    public final void c(final Exception exc) {
        m.e(exc, "ex");
        this.f23733m.post(new Runnable() { // from class: x4.a
            @Override // java.lang.Runnable
            public final void run() {
                C1776c.d(this.f23728l, exc);
            }
        });
    }

    public final void e(final byte[] bArr) {
        m.e(bArr, "buffer");
        this.f23733m.post(new Runnable() { // from class: x4.b
            @Override // java.lang.Runnable
            public final void run() {
                C1776c.f(this.f23730l, bArr);
            }
        });
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        this.f23732l = null;
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        this.f23732l = bVar;
    }
}
