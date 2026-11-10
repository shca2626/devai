package o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: o.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1379b {

    /* renamed from: l, reason: collision with root package name */
    public Object f20241l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20242m;

    /* renamed from: o.b$a */
    public interface a {
        boolean a(AbstractC1379b abstractC1379b, MenuItem menuItem);

        boolean b(AbstractC1379b abstractC1379b, Menu menu);

        boolean c(AbstractC1379b abstractC1379b, Menu menu);

        void d(AbstractC1379b abstractC1379b);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f20241l;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f20242m;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public abstract void m(View view);

    public abstract void n(int i7);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f20241l = obj;
    }

    public abstract void q(int i7);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z7) {
        this.f20242m = z7;
    }
}
