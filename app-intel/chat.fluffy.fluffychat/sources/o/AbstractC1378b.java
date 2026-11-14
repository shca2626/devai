package o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: o.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1378b {

    /* renamed from: l, reason: collision with root package name */
    public Object f20240l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20241m;

    /* renamed from: o.b$a */
    public interface a {
        boolean a(AbstractC1378b abstractC1378b, MenuItem menuItem);

        boolean b(AbstractC1378b abstractC1378b, Menu menu);

        boolean c(AbstractC1378b abstractC1378b, Menu menu);

        void d(AbstractC1378b abstractC1378b);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f20240l;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f20241m;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public abstract void m(View view);

    public abstract void n(int i7);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f20240l = obj;
    }

    public abstract void q(int i7);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z7) {
        this.f20241m = z7;
    }
}
