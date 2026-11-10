package p;

import Z.AbstractC0684b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import o.InterfaceC1380c;

/* loaded from: classes.dex */
public class c extends p.b implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    public final R.b f20644d;

    /* renamed from: e, reason: collision with root package name */
    public Method f20645e;

    public class a extends AbstractC0684b {

        /* renamed from: d, reason: collision with root package name */
        public final ActionProvider f20646d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f20646d = actionProvider;
        }

        @Override // Z.AbstractC0684b
        public boolean a() {
            return this.f20646d.hasSubMenu();
        }

        @Override // Z.AbstractC0684b
        public boolean d() {
            return this.f20646d.onPerformDefaultAction();
        }

        @Override // Z.AbstractC0684b
        public void e(SubMenu subMenu) {
            this.f20646d.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f, reason: collision with root package name */
        public AbstractC0684b.InterfaceC0084b f20648f;

        public b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // Z.AbstractC0684b
        public boolean b() {
            return this.f20646d.isVisible();
        }

        @Override // Z.AbstractC0684b
        public View c(MenuItem menuItem) {
            return this.f20646d.onCreateActionView(menuItem);
        }

        @Override // Z.AbstractC0684b
        public boolean f() {
            return this.f20646d.overridesItemVisibility();
        }

        @Override // Z.AbstractC0684b
        public void i(AbstractC0684b.InterfaceC0084b interfaceC0084b) {
            this.f20648f = interfaceC0084b;
            this.f20646d.setVisibilityListener(interfaceC0084b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z7) {
            AbstractC0684b.InterfaceC0084b interfaceC0084b = this.f20648f;
            if (interfaceC0084b != null) {
                interfaceC0084b.onActionProviderVisibilityChanged(z7);
            }
        }
    }

    /* renamed from: p.c$c, reason: collision with other inner class name */
    public static class C0238c extends FrameLayout implements InterfaceC1380c {

        /* renamed from: l, reason: collision with root package name */
        public final CollapsibleActionView f20650l;

        /* JADX WARN: Multi-variable type inference failed */
        public C0238c(View view) {
            super(view.getContext());
            this.f20650l = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f20650l;
        }

        @Override // o.InterfaceC1380c
        public void onActionViewCollapsed() {
            this.f20650l.onActionViewCollapsed();
        }

        @Override // o.InterfaceC1380c
        public void onActionViewExpanded() {
            this.f20650l.onActionViewExpanded();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f20651a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f20651a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f20651a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f20651a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f20653a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f20653a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f20653a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, R.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f20644d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f20644d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f20644d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0684b abstractC0684bB = this.f20644d.b();
        if (abstractC0684bB instanceof a) {
            return ((a) abstractC0684bB).f20646d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f20644d.getActionView();
        return actionView instanceof C0238c ? ((C0238c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f20644d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f20644d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f20644d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f20644d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f20644d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f20644d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f20644d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f20644d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f20644d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f20644d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f20644d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f20644d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f20644d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f20644d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f20644d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f20644d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f20644d.getTooltipText();
    }

    public void h(boolean z7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f20645e == null) {
                this.f20645e = this.f20644d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f20645e.invoke(this.f20644d, Boolean.valueOf(z7));
        } catch (Exception e7) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e7);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f20644d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f20644d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f20644d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f20644d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f20644d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f20644d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f20641a, actionProvider);
        R.b bVar2 = this.f20644d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0238c(view);
        }
        this.f20644d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7) {
        this.f20644d.setAlphabeticShortcut(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f20644d.setCheckable(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.f20644d.setChecked(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f20644d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f20644d.setEnabled(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f20644d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f20644d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f20644d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f20644d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7) {
        this.f20644d.setNumericShortcut(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f20644d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f20644d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8) {
        this.f20644d.setShortcut(c7, c8);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i7) {
        this.f20644d.setShowAsAction(i7);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i7) {
        this.f20644d.setShowAsActionFlags(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f20644d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f20644d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f20644d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        return this.f20644d.setVisible(z7);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7, int i7) {
        this.f20644d.setAlphabeticShortcut(c7, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f20644d.setIcon(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7, int i7) {
        this.f20644d.setNumericShortcut(c7, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f20644d.setShortcut(c7, c8, i7, i8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        this.f20644d.setTitle(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i7) {
        this.f20644d.setActionView(i7);
        View actionView = this.f20644d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f20644d.setActionView(new C0238c(actionView));
        }
        return this;
    }
}
