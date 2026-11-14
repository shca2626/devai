package p;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import y.C1796k;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20647a;

    /* renamed from: b, reason: collision with root package name */
    public C1796k f20648b;

    /* renamed from: c, reason: collision with root package name */
    public C1796k f20649c;

    public b(Context context) {
        this.f20647a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof R.b)) {
            return menuItem;
        }
        R.b bVar = (R.b) menuItem;
        if (this.f20648b == null) {
            this.f20648b = new C1796k();
        }
        MenuItem menuItem2 = (MenuItem) this.f20648b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f20647a, bVar);
        this.f20648b.put(bVar, cVar);
        return cVar;
    }

    public final void e() {
        C1796k c1796k = this.f20648b;
        if (c1796k != null) {
            c1796k.clear();
        }
        C1796k c1796k2 = this.f20649c;
        if (c1796k2 != null) {
            c1796k2.clear();
        }
    }

    public final void f(int i7) {
        if (this.f20648b == null) {
            return;
        }
        int i8 = 0;
        while (i8 < this.f20648b.size()) {
            if (((R.b) this.f20648b.f(i8)).getGroupId() == i7) {
                this.f20648b.h(i8);
                i8--;
            }
            i8++;
        }
    }

    public final void g(int i7) {
        if (this.f20648b == null) {
            return;
        }
        for (int i8 = 0; i8 < this.f20648b.size(); i8++) {
            if (((R.b) this.f20648b.f(i8)).getItemId() == i7) {
                this.f20648b.h(i8);
                return;
            }
        }
    }

    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }
}
