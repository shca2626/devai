package p;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import y.C1797k;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20641a;

    /* renamed from: b, reason: collision with root package name */
    public C1797k f20642b;

    /* renamed from: c, reason: collision with root package name */
    public C1797k f20643c;

    public b(Context context) {
        this.f20641a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof R.b)) {
            return menuItem;
        }
        R.b bVar = (R.b) menuItem;
        if (this.f20642b == null) {
            this.f20642b = new C1797k();
        }
        MenuItem menuItem2 = (MenuItem) this.f20642b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f20641a, bVar);
        this.f20642b.put(bVar, cVar);
        return cVar;
    }

    public final void e() {
        C1797k c1797k = this.f20642b;
        if (c1797k != null) {
            c1797k.clear();
        }
        C1797k c1797k2 = this.f20643c;
        if (c1797k2 != null) {
            c1797k2.clear();
        }
    }

    public final void f(int i7) {
        if (this.f20642b == null) {
            return;
        }
        int i8 = 0;
        while (i8 < this.f20642b.size()) {
            if (((R.b) this.f20642b.f(i8)).getGroupId() == i7) {
                this.f20642b.h(i8);
                i8--;
            }
            i8++;
        }
    }

    public final void g(int i7) {
        if (this.f20642b == null) {
            return;
        }
        for (int i8 = 0; i8 < this.f20642b.size(); i8++) {
            if (((R.b) this.f20642b.f(i8)).getItemId() == i7) {
                this.f20642b.h(i8);
                return;
            }
        }
    }

    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }
}
