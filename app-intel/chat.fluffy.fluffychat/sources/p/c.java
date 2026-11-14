package p;

import Z.AbstractC0685b;
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
import o.InterfaceC1379c;

/* loaded from: classes.dex */
public class c extends p.b implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    public final R.b f20650d;

    /* renamed from: e, reason: collision with root package name */
    public Method f20651e;

    public class a extends AbstractC0685b {

        /* renamed from: d, reason: collision with root package name */
        public final ActionProvider f20652d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f20652d = actionProvider;
        }

        @Override // Z.AbstractC0685b
        public boolean a() {
            return this.f20652d.hasSubMenu();
        }

        @Override // Z.AbstractC0685b
        public boolean d() {
            return this.f20652d.onPerformDefaultAction();
        }

        @Override // Z.AbstractC0685b
        public void e(SubMenu subMenu) {
            this.f20652d.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f, reason: collision with root package name */
        public AbstractC0685b.InterfaceC0084b f20654f;

        public b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // Z.AbstractC0685b
        public boolean b() {
            return this.f20652d.isVisible();
        }

        @Override // Z.AbstractC0685b
        public View c(MenuItem menuItem) {
            return this.f20652d.onCreateActionView(menuItem);
        }

        @Override // Z.AbstractC0685b
        public boolean f() {
            return this.f20652d.overridesItemVisibility();
        }

        @Override // Z.AbstractC0685b
        public void i(AbstractC0685b.InterfaceC0084b interfaceC0084b) {
            this.f20654f = interfaceC0084b;
            this.f20652d.setVisibilityListener(interfaceC0084b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z7) {
            AbstractC0685b.InterfaceC0084b interfaceC0084b = this.f20654f;
            if (interfaceC0084b != null) {
                interfaceC0084b.onActionProviderVisibilityChanged(z7);
            }
        }
    }

    /* renamed from: p.c$c, reason: collision with other inner class name */
    public static class C0238c extends FrameLayout implements InterfaceC1379c {

        /* renamed from: l, reason: collision with root package name */
        public final CollapsibleActionView f20656l;

        /* JADX WARN: Multi-variable type inference failed */
        public C0238c(View view) {
            super(view.getContext());
            this.f20656l = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f20656l;
        }

        @Override // o.InterfaceC1379c
        public void onActionViewCollapsed() {
            this.f20656l.onActionViewCollapsed();
        }

        @Override // o.InterfaceC1379c
        public void onActionViewExpanded() {
            this.f20656l.onActionViewExpanded();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f20657a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f20657a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f20657a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f20657a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f20659a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f20659a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f20659a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, R.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f20650d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f20650d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f20650d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0685b abstractC0685bB = this.f20650d.b();
        if (abstractC0685bB instanceof a) {
            return ((a) abstractC0685bB).f20652d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f20650d.getActionView();
        return actionView instanceof C0238c ? ((C0238c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f20650d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f20650d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f20650d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f20650d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f20650d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f20650d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f20650d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f20650d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f20650d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f20650d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f20650d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f20650d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f20650d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f20650d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f20650d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f20650d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f20650d.getTooltipText();
    }

    public void h(boolean z7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f20651e == null) {
                this.f20651e = this.f20650d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f20651e.invoke(this.f20650d, Boolean.valueOf(z7));
        } catch (Exception e7) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e7);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f20650d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f20650d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f20650d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f20650d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f20650d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f20650d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f20647a, actionProvider);
        R.b bVar2 = this.f20650d;
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
        this.f20650d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7) {
        this.f20650d.setAlphabeticShortcut(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f20650d.setCheckable(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.f20650d.setChecked(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f20650d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f20650d.setEnabled(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f20650d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f20650d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f20650d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f20650d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7) {
        this.f20650d.setNumericShortcut(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f20650d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f20650d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8) {
        this.f20650d.setShortcut(c7, c8);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i7) {
        this.f20650d.setShowAsAction(i7);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i7) {
        this.f20650d.setShowAsActionFlags(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f20650d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f20650d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f20650d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        return this.f20650d.setVisible(z7);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7, int i7) {
        this.f20650d.setAlphabeticShortcut(c7, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f20650d.setIcon(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7, int i7) {
        this.f20650d.setNumericShortcut(c7, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f20650d.setShortcut(c7, c8, i7, i8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        this.f20650d.setTitle(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i7) {
        this.f20650d.setActionView(i7);
        View actionView = this.f20650d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f20650d.setActionView(new C0238c(actionView));
        }
        return this;
    }
}
