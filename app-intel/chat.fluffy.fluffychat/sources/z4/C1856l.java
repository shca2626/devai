package z4;

import M5.m;
import android.os.Handler;
import android.os.Looper;
import h5.j;

/* renamed from: z4.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1856l implements j.d {

    /* renamed from: a, reason: collision with root package name */
    public final j.d f24156a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f24157b;

    public C1856l(j.d dVar) {
        m.e(dVar, "methodResult");
        this.f24156a = dVar;
        this.f24157b = new Handler(Looper.getMainLooper());
    }

    public static final void d(C1856l c1856l, String str, String str2, Object obj) {
        c1856l.f24156a.error(str, str2, obj);
    }

    public static final void e(C1856l c1856l) {
        c1856l.f24156a.notImplemented();
    }

    public static final void f(C1856l c1856l, Object obj) {
        try {
            c1856l.f24156a.success(obj);
        } catch (OutOfMemoryError unused) {
            c1856l.f24156a.error("out_of_memory", "Selected files are too large to load into memory.", null);
        }
    }

    @Override // h5.j.d
    public void error(final String str, final String str2, final Object obj) {
        m.e(str, "errorCode");
        this.f24157b.post(new Runnable() { // from class: z4.i
            @Override // java.lang.Runnable
            public final void run() {
                C1856l.d(this.f24149l, str, str2, obj);
            }
        });
    }

    @Override // h5.j.d
    public void notImplemented() {
        this.f24157b.post(new Runnable() { // from class: z4.k
            @Override // java.lang.Runnable
            public final void run() {
                C1856l.e(this.f24155l);
            }
        });
    }

    @Override // h5.j.d
    public void success(final Object obj) {
        this.f24157b.post(new Runnable() { // from class: z4.j
            @Override // java.lang.Runnable
            public final void run() {
                C1856l.f(this.f24153l, obj);
            }
        });
    }
}
