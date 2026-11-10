package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;

/* loaded from: classes.dex */
public class l extends e implements SubMenu {

    /* renamed from: B, reason: collision with root package name */
    public e f11271B;

    /* renamed from: C, reason: collision with root package name */
    public g f11272C;

    public l(Context context, e eVar, g gVar) {
        super(context);
        this.f11271B = eVar;
        this.f11272C = gVar;
    }

    @Override // androidx.appcompat.view.menu.e
    public e D() {
        return this.f11271B.D();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean F() {
        return this.f11271B.F();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean G() {
        return this.f11271B.G();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean H() {
        return this.f11271B.H();
    }

    @Override // androidx.appcompat.view.menu.e
    public void R(e.a aVar) {
        this.f11271B.R(aVar);
    }

    public Menu e0() {
        return this.f11271B;
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean f(g gVar) {
        return this.f11271B.f(gVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f11272C;
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean h(e eVar, MenuItem menuItem) {
        return super.h(eVar, menuItem) || this.f11271B.h(eVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean k(g gVar) {
        return this.f11271B.k(gVar);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f11271B.setGroupDividerEnabled(z7);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.V(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.Y(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.Z(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f11272C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f11271B.setQwertyMode(z7);
    }

    @Override // androidx.appcompat.view.menu.e
    public String t() {
        g gVar = this.f11272C;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i7) {
        return (SubMenu) super.U(i7);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i7) {
        return (SubMenu) super.X(i7);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i7) {
        this.f11272C.setIcon(i7);
        return this;
    }
}
