package d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import y5.C1823s;

/* renamed from: d.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0949D {

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

    public C0949D(Executor executor, L5.a aVar) {
        M5.m.e(executor, "executor");
        M5.m.e(aVar, "reportFullyDrawn");
        this.f15004a = executor;
        this.f15005b = aVar;
        this.f15006c = new Object();
        this.f15010g = new ArrayList();
        this.f15011h = new Runnable() { // from class: d.C
            @Override // java.lang.Runnable
            public final void run() {
                C0949D.d(this.f15003l);
            }
        };
    }

    public static final void d(C0949D c0949d) {
        synchronized (c0949d.f15006c) {
            try {
                c0949d.f15008e = false;
                if (c0949d.f15007d == 0 && !c0949d.f15009f) {
                    c0949d.f15005b.d();
                    c0949d.b();
                }
                C1823s c1823s = C1823s.f24020a;
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
                C1823s c1823s = C1823s.f24020a;
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
