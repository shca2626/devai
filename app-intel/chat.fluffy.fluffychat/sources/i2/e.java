package i2;

import M5.m;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import h2.InterfaceC1139a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import y5.C1823s;

/* loaded from: classes.dex */
public final class e implements InterfaceC1139a {

    /* renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f17413a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f17414b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f17415c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f17416d;

    public e(WindowLayoutComponent windowLayoutComponent) {
        m.e(windowLayoutComponent, "component");
        this.f17413a = windowLayoutComponent;
        this.f17414b = new ReentrantLock();
        this.f17415c = new LinkedHashMap();
        this.f17416d = new LinkedHashMap();
    }

    @Override // h2.InterfaceC1139a
    public void a(Y.a aVar) {
        m.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f17414b;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f17416d.get(aVar);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            g gVar = (g) this.f17415c.get(context);
            if (gVar == null) {
                reentrantLock.unlock();
                return;
            }
            gVar.d(aVar);
            this.f17416d.remove(aVar);
            if (gVar.c()) {
                this.f17415c.remove(context);
                this.f17413a.removeWindowLayoutInfoListener(gVar);
            }
            C1823s c1823s = C1823s.f24020a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // h2.InterfaceC1139a
    public void b(Context context, Executor executor, Y.a aVar) {
        C1823s c1823s;
        m.e(context, "context");
        m.e(executor, "executor");
        m.e(aVar, "callback");
        ReentrantLock reentrantLock = this.f17414b;
        reentrantLock.lock();
        try {
            g gVar = (g) this.f17415c.get(context);
            if (gVar != null) {
                gVar.b(aVar);
                this.f17416d.put(aVar, context);
                c1823s = C1823s.f24020a;
            } else {
                c1823s = null;
            }
            if (c1823s == null) {
                g gVar2 = new g(context);
                this.f17415c.put(context, gVar2);
                this.f17416d.put(aVar, context);
                gVar2.b(aVar);
                this.f17413a.addWindowLayoutInfoListener(context, gVar2);
            }
            C1823s c1823s2 = C1823s.f24020a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
