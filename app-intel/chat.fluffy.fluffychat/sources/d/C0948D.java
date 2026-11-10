package d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import y5.C1824s;

/* renamed from: d.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0948D {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f15004a;

    /* renamed from: b, reason: collision with root package name */
    public final L5.a f15005b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f15006c;

    /* renamed from: d, reason: collision with root package name */
    public int f15007d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15008e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15009f;

    /* renamed from: g, reason: collision with root package name */
    public final List f15010g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f15011h;

    public C0948D(Executor executor, L5.a aVar) {
        M5.m.e(executor, "executor");
        M5.m.e(aVar, "reportFullyDrawn");
        this.f15004a = executor;
        this.f15005b = aVar;
        this.f15006c = new Object();
        this.f15010g = new ArrayList();
        this.f15011h = new Runnable() { // from class: d.C
            @Override // java.lang.Runnable
            public final void run() {
                C0948D.d(this.f15003l);
            }
        };
    }

    public static final void d(C0948D c0948d) {
        synchronized (c0948d.f15006c) {
            try {
                c0948d.f15008e = false;
                if (c0948d.f15007d == 0 && !c0948d.f15009f) {
                    c0948d.f15005b.d();
                    c0948d.b();
                }
                C1824s c1824s = C1824s.f24014a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f15006c) {
            try {
                this.f15009f = true;
                Iterator it = this.f15010g.iterator();
                while (it.hasNext()) {
                    ((L5.a) it.next()).d();
                }
                this.f15010g.clear();
                C1824s c1824s = C1824s.f24014a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z7;
        synchronized (this.f15006c) {
            z7 = this.f15009f;
        }
        return z7;
    }
}
