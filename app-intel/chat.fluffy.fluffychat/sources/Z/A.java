package Z;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f9933a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f9934b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Map f9935c = new HashMap();

    public A(Runnable runnable) {
        this.f9933a = runnable;
    }

    public void a(C c7) {
        this.f9934b.add(c7);
        this.f9933a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f9934b.iterator();
        while (it.hasNext()) {
            ((C) it.next()).c(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator it = this.f9934b.iterator();
        while (it.hasNext()) {
            ((C) it.next()).b(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator it = this.f9934b.iterator();
        while (it.hasNext()) {
            if (((C) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator it = this.f9934b.iterator();
        while (it.hasNext()) {
            ((C) it.next()).d(menu);
        }
    }

    public void f(C c7) {
        this.f9934b.remove(c7);
        android.support.v4.media.session.b.a(this.f9935c.remove(c7));
        this.f9933a.run();
    }
}
