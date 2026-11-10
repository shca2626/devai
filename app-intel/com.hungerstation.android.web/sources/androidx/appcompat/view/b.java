package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: b, reason: collision with root package name */
    private Object f2180b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2181c;

    public interface a {
        void a(b bVar);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, MenuItem menuItem);

        boolean d(b bVar, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f2180b;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f2181c;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i12);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f2180b = obj;
    }

    public abstract void q(int i12);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z12) {
        this.f2181c = z12;
    }
}
