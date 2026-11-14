package z4;

import android.os.Handler;
import android.os.Looper;
import h5.j;

/* renamed from: z4.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1856m implements j.d {

    /* renamed from: a, reason: collision with root package name */
    public final j.d f24169a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f24170b;

    public C1856m(j.d dVar) {
        M5.m.e(dVar, "methodResult");
        this.f24169a = dVar;
        this.f24170b = new Handler(Looper.getMainLooper());
    }

    public static final void d(C1856m c1856m, String str, String str2, Object obj) {
        c1856m.f24169a.error(str, str2, obj);
    }

    public static final void e(C1856m c1856m) {
        c1856m.f24169a.notImplemented();
    }

    public static final void f(C1856m c1856m, Object obj) {
        try {
            c1856m.f24169a.success(obj);
        } catch (OutOfMemoryError unused) {
            c1856m.f24169a.error("out_of_memory", "Selected files are too large to load into memory.", null);
        }
    }

    @Override // h5.j.d
    public void error(final String str, final String str2, final Object obj) {
        M5.m.e(str, "errorCode");
        this.f24170b.post(new Runnable() { // from class: z4.j
            @Override // java.lang.Runnable
            public final void run() {
                C1856m.d(this.f24162l, str, str2, obj);
            }
        });
    }

    @Override // h5.j.d
    public void notImplemented() {
        this.f24170b.post(new Runnable() { // from class: z4.l
            @Override // java.lang.Runnable
            public final void run() {
                C1856m.e(this.f24168l);
            }
        });
    }

    @Override // h5.j.d
    public void success(final Object obj) {
        this.f24170b.post(new Runnable() { // from class: z4.k
            @Override // java.lang.Runnable
            public final void run() {
                C1856m.f(this.f24166l, obj);
            }
        });
    }
}
