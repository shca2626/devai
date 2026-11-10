package i2;

import M5.m;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import g2.j;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import y5.C1824s;

/* loaded from: classes.dex */
public final class g implements Y.a, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17418a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f17419b;

    /* renamed from: c, reason: collision with root package name */
    public j f17420c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f17421d;

    public g(Context context) {
        m.e(context, "context");
        this.f17418a = context;
        this.f17419b = new ReentrantLock();
        this.f17421d = new LinkedHashSet();
    }

    @Override // Y.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(WindowLayoutInfo windowLayoutInfo) {
        m.e(windowLayoutInfo, "value");
        ReentrantLock reentrantLock = this.f17419b;
        reentrantLock.lock();
        try {
            this.f17420c = f.f17417a.b(this.f17418a, windowLayoutInfo);
            Iterator it = this.f17421d.iterator();
            while (it.hasNext()) {
                ((Y.a) it.next()).accept(this.f17420c);
            }
            C1824s c1824s = C1824s.f24014a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(Y.a aVar) {
        m.e(aVar, "listener");
        ReentrantLock reentrantLock = this.f17419b;
        reentrantLock.lock();
        try {
            j jVar = this.f17420c;
            if (jVar != null) {
                aVar.accept(jVar);
            }
            this.f17421d.add(aVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c() {
        return this.f17421d.isEmpty();
    }

    public final void d(Y.a aVar) {
        m.e(aVar, "listener");
        ReentrantLock reentrantLock = this.f17419b;
        reentrantLock.lock();
        try {
            this.f17421d.remove(aVar);
        } finally {
            reentrantLock.unlock();
        }
    }
}
