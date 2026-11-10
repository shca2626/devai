package F2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class h implements h5.l {

    /* renamed from: m, reason: collision with root package name */
    public static h f2684m;

    /* renamed from: l, reason: collision with root package name */
    public final List f2685l = new CopyOnWriteArrayList();

    public static synchronized h b() {
        try {
            if (f2684m == null) {
                f2684m = new h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2684m;
    }

    public l a(Context context, boolean z7, z zVar) {
        return new m(context, zVar);
    }

    public void c(Context context, boolean z7, E e7, E2.a aVar) {
        a(context, z7, null).e(e7, aVar);
    }

    public void d(Context context, A a7) {
        if (context == null) {
            a7.b(E2.b.locationServicesDisabled);
        }
        a(context, false, null).c(a7);
    }

    public void e(l lVar, Activity activity, E e7, E2.a aVar) {
        this.f2685l.add(lVar);
        lVar.b(activity, e7, aVar);
    }

    public void f(l lVar) {
        this.f2685l.remove(lVar);
        lVar.f();
    }

    @Override // h5.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        Iterator it = this.f2685l.iterator();
        while (it.hasNext()) {
            if (((l) it.next()).d(i7, i8)) {
                return true;
            }
        }
        return false;
    }
}
