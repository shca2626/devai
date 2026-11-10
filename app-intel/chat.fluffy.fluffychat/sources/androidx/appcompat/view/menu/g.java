package androidx.appcompat.view.menu;

import Z.AbstractC0684b;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.j;
import k.AbstractC1244a;

/* loaded from: classes.dex */
public final class g implements R.b {

    /* renamed from: A, reason: collision with root package name */
    public View f11203A;

    /* renamed from: B, reason: collision with root package name */
    public AbstractC0684b f11204B;

    /* renamed from: C, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f11205C;

    /* renamed from: E, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f11207E;

    /* renamed from: a, reason: collision with root package name */
    public final int f11208a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11209b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11210c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11211d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f11212e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f11213f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f11214g;

    /* renamed from: h, reason: collision with root package name */
    public char f11215h;

    /* renamed from: j, reason: collision with root package name */
    public char f11217j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f11219l;

    /* renamed from: n, reason: collision with root package name */
    public e f11221n;

    /* renamed from: o, reason: collision with root package name */
    public l f11222o;

    /* renamed from: p, reason: collision with root package name */
    public Runnable f11223p;

    /* renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f11224q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f11225r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f11226s;

    /* renamed from: z, reason: collision with root package name */
    public int f11233z;

    /* renamed from: i, reason: collision with root package name */
    public int f11216i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f11218k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f11220m = 0;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f11227t = null;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f11228u = null;

    /* renamed from: v, reason: collision with root package name */
    public boolean f11229v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11230w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11231x = false;

    /* renamed from: y, reason: collision with root package name */
    public int f11232y = 16;

    /* renamed from: D, reason: collision with root package name */
    public boolean f11206D = false;

    public class a implements AbstractC0684b.InterfaceC0084b {
        public a() {
        }

        @Override // Z.AbstractC0684b.InterfaceC0084b
        public void onActionProviderVisibilityChanged(boolean z7) {
            g gVar = g.this;
            gVar.f11221n.J(gVar);
        }
    }

    public g(e eVar, int i7, int i8, int i9, int i10, CharSequence charSequence, int i11) {
        this.f11221n = eVar;
        this.f11208a = i8;
        this.f11209b = i7;
        this.f11210c = i9;
        this.f11211d = i10;
        this.f11212e = charSequence;
        this.f11233z = i11;
    }

    public static void d(StringBuilder sb, int i7, int i8, String str) {
        if ((i7 & i8) == i8) {
            sb.append(str);
        }
    }

    public boolean A() {
        return this.f11221n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f11233z & 4) == 4;
    }

    @Override // R.b
    public R.b a(AbstractC0684b abstractC0684b) {
        AbstractC0684b abstractC0684b2 = this.f11204B;
        if (abstractC0684b2 != null) {
            abstractC0684b2.g();
        }
        this.f11203A = null;
        this.f11204B = abstractC0684b;
        this.f11221n.K(true);
        AbstractC0684b abstractC0684b3 = this.f11204B;
        if (abstractC0684b3 != null) {
            abstractC0684b3.i(new a());
        }
        return this;
    }

    @Override // R.b
    public AbstractC0684b b() {
        return this.f11204B;
    }

    public void c() {
        this.f11221n.I(this);
    }

    @Override // R.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f11233z & 8) == 0) {
            return false;
        }
        if (this.f11203A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f11205C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f11221n.f(this);
        }
        return false;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable != null && this.f11231x && (this.f11229v || this.f11230w)) {
            drawable = P.a.r(drawable).mutate();
            if (this.f11229v) {
                P.a.o(drawable, this.f11227t);
            }
            if (this.f11230w) {
                P.a.p(drawable, this.f11228u);
            }
            this.f11231x = false;
        }
        return drawable;
    }

    @Override // R.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f11205C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f11221n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f11211d;
    }

    public char g() {
        return this.f11221n.G() ? this.f11217j : this.f11215h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // R.b, android.view.MenuItem
    public View getActionView() {
        View view = this.f11203A;
        if (view != null) {
            return view;
        }
        AbstractC0684b abstractC0684b = this.f11204B;
        if (abstractC0684b == null) {
            return null;
        }
        View viewC = abstractC0684b.c(this);
        this.f11203A = viewC;
        return viewC;
    }

    @Override // R.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f11218k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f11217j;
    }

    @Override // R.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f11225r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f11209b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f11219l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f11220m == 0) {
            return null;
        }
        Drawable drawableB = AbstractC1244a.b(this.f11221n.u(), this.f11220m);
        this.f11220m = 0;
        this.f11219l = drawableB;
        return e(drawableB);
    }

    @Override // R.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f11227t;
    }

    @Override // R.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f11228u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f11214g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f11208a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f11207E;
    }

    @Override // R.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f11216i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f11215h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f11210c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f11222o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f11212e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f11213f;
        return charSequence != null ? charSequence : this.f11212e;
    }

    @Override // R.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f11226s;
    }

    public String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f11221n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f11221n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(i.h.f17097m));
        }
        int i7 = this.f11221n.G() ? this.f11218k : this.f11216i;
        d(sb, i7, 65536, resources.getString(i.h.f17093i));
        d(sb, i7, 4096, resources.getString(i.h.f17089e));
        d(sb, i7, 2, resources.getString(i.h.f17088d));
        d(sb, i7, 1, resources.getString(i.h.f17094j));
        d(sb, i7, 4, resources.getString(i.h.f17096l));
        d(sb, i7, 8, resources.getString(i.h.f17092h));
        if (cG == '\b') {
            sb.append(resources.getString(i.h.f17090f));
        } else if (cG == '\n') {
            sb.append(resources.getString(i.h.f17091g));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(i.h.f17095k));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f11222o != null;
    }

    public CharSequence i(j.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // R.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f11206D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f11232y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f11232y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f11232y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0684b abstractC0684b = this.f11204B;
        return (abstractC0684b == null || !abstractC0684b.f()) ? (this.f11232y & 8) == 0 : (this.f11232y & 8) == 0 && this.f11204B.b();
    }

    public boolean j() {
        AbstractC0684b abstractC0684b;
        if ((this.f11233z & 8) != 0) {
            if (this.f11203A == null && (abstractC0684b = this.f11204B) != null) {
                this.f11203A = abstractC0684b.c(this);
            }
            if (this.f11203A != null) {
                return true;
            }
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f11224q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f11221n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f11223p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f11214g != null) {
            try {
                this.f11221n.u().startActivity(this.f11214g);
                return true;
            } catch (ActivityNotFoundException e7) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e7);
            }
        }
        AbstractC0684b abstractC0684b = this.f11204B;
        return abstractC0684b != null && abstractC0684b.d();
    }

    public boolean l() {
        return (this.f11232y & 32) == 32;
    }

    public boolean m() {
        return (this.f11232y & 4) != 0;
    }

    public boolean n() {
        return (this.f11233z & 1) == 1;
    }

    public boolean o() {
        return (this.f11233z & 2) == 2;
    }

    @Override // R.b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public R.b setActionView(int i7) {
        Context contextU = this.f11221n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i7, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    @Override // R.b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public R.b setActionView(View view) {
        int i7;
        this.f11203A = view;
        this.f11204B = null;
        if (view != null && view.getId() == -1 && (i7 = this.f11208a) > 0) {
            view.setId(i7);
        }
        this.f11221n.I(this);
        return this;
    }

    public void r(boolean z7) {
        this.f11206D = z7;
        this.f11221n.K(false);
    }

    public void s(boolean z7) {
        int i7 = this.f11232y;
        int i8 = (z7 ? 2 : 0) | (i7 & (-3));
        this.f11232y = i8;
        if (i7 != i8) {
            this.f11221n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7) {
        if (this.f11217j == c7) {
            return this;
        }
        this.f11217j = Character.toLowerCase(c7);
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        int i7 = this.f11232y;
        int i8 = (z7 ? 1 : 0) | (i7 & (-2));
        this.f11232y = i8;
        if (i7 != i8) {
            this.f11221n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        if ((this.f11232y & 4) != 0) {
            this.f11221n.T(this);
            return this;
        }
        s(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        if (z7) {
            this.f11232y |= 16;
        } else {
            this.f11232y &= -17;
        }
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f11220m = 0;
        this.f11219l = drawable;
        this.f11231x = true;
        this.f11221n.K(false);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f11227t = colorStateList;
        this.f11229v = true;
        this.f11231x = true;
        this.f11221n.K(false);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f11228u = mode;
        this.f11230w = true;
        this.f11231x = true;
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f11214g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7) {
        if (this.f11215h == c7) {
            return this;
        }
        this.f11215h = c7;
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f11205C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f11224q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8) {
        this.f11215h = c7;
        this.f11217j = Character.toLowerCase(c8);
        this.f11221n.K(false);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public void setShowAsAction(int i7) {
        int i8 = i7 & 3;
        if (i8 != 0 && i8 != 1 && i8 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f11233z = i7;
        this.f11221n.I(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f11212e = charSequence;
        this.f11221n.K(false);
        l lVar = this.f11222o;
        if (lVar != null) {
            lVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f11213f = charSequence;
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        if (y(z7)) {
            this.f11221n.J(this);
        }
        return this;
    }

    public void t(boolean z7) {
        this.f11232y = (z7 ? 4 : 0) | (this.f11232y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f11212e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z7) {
        if (z7) {
            this.f11232y |= 32;
        } else {
            this.f11232y &= -33;
        }
    }

    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f11207E = contextMenuInfo;
    }

    @Override // R.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public R.b setShowAsActionFlags(int i7) {
        setShowAsAction(i7);
        return this;
    }

    public void x(l lVar) {
        this.f11222o = lVar;
        lVar.setHeaderTitle(getTitle());
    }

    public boolean y(boolean z7) {
        int i7 = this.f11232y;
        int i8 = (z7 ? 0 : 8) | (i7 & (-9));
        this.f11232y = i8;
        return i7 != i8;
    }

    public boolean z() {
        return this.f11221n.A();
    }

    @Override // android.view.MenuItem
    public R.b setContentDescription(CharSequence charSequence) {
        this.f11225r = charSequence;
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public R.b setTooltipText(CharSequence charSequence) {
        this.f11226s = charSequence;
        this.f11221n.K(false);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7, int i7) {
        if (this.f11217j == c7 && this.f11218k == i7) {
            return this;
        }
        this.f11217j = Character.toLowerCase(c7);
        this.f11218k = KeyEvent.normalizeMetaState(i7);
        this.f11221n.K(false);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c7, int i7) {
        if (this.f11215h == c7 && this.f11216i == i7) {
            return this;
        }
        this.f11215h = c7;
        this.f11216i = KeyEvent.normalizeMetaState(i7);
        this.f11221n.K(false);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f11215h = c7;
        this.f11216i = KeyEvent.normalizeMetaState(i7);
        this.f11217j = Character.toLowerCase(c8);
        this.f11218k = KeyEvent.normalizeMetaState(i8);
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f11219l = null;
        this.f11220m = i7;
        this.f11231x = true;
        this.f11221n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        return setTitle(this.f11221n.u().getString(i7));
    }
}
