package p;

import Z.AbstractC0685b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: p.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1434a implements R.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f20627a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20628b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20629c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f20630d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f20631e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f20632f;

    /* renamed from: g, reason: collision with root package name */
    public char f20633g;

    /* renamed from: i, reason: collision with root package name */
    public char f20635i;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f20637k;

    /* renamed from: l, reason: collision with root package name */
    public Context f20638l;

    /* renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f20639m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f20640n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f20641o;

    /* renamed from: h, reason: collision with root package name */
    public int f20634h = 4096;

    /* renamed from: j, reason: collision with root package name */
    public int f20636j = 4096;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f20642p = null;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f20643q = null;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20644r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20645s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f20646t = 16;

    public C1434a(Context context, int i7, int i8, int i9, int i10, CharSequence charSequence) {
        this.f20638l = context;
        this.f20627a = i8;
        this.f20628b = i7;
        this.f20629c = i10;
        this.f20630d = charSequence;
    }

    @Override // R.b
    public R.b a(AbstractC0685b abstractC0685b) {
        throw new UnsupportedOperationException();
    }

    @Override // R.b
    public AbstractC0685b b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f20637k;
        if (drawable != null) {
            if (this.f20644r || this.f20645s) {
                Drawable drawableR = P.a.r(drawable);
                this.f20637k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f20637k = drawableMutate;
                if (this.f20644r) {
                    P.a.o(drawableMutate, this.f20642p);
                }
                if (this.f20645s) {
                    P.a.p(this.f20637k, this.f20643q);
                }
            }
        }
    }

    @Override // R.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // R.b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public R.b setActionView(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // R.b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public R.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // R.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // R.b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public R.b setShowAsActionFlags(int i7) {
        setShowAsAction(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // R.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // R.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f20636j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f20635i;
    }

    @Override // R.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f20640n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f20628b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f20637k;
    }

    @Override // R.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f20642p;
    }

    @Override // R.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f20643q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f20632f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f20627a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // R.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f20634h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f20633g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f20629c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f20630d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f20631e;
        return charSequence != null ? charSequence : this.f20630d;
    }

    @Override // R.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f20641o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // R.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f20646t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f20646t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f20646t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f20646t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7) {
        this.f20635i = Character.toLowerCase(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f20646t = (z7 ? 1 : 0) | (this.f20646t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.f20646t = (z7 ? 2 : 0) | (this.f20646t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f20646t = (z7 ? 16 : 0) | (this.f20646t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f20637k = drawable;
        c();
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f20642p = colorStateList;
        this.f20644r = true;
        c();
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f20643q = mode;
        this.f20645s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f20632f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7) {
        this.f20633g = c7;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f20639m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8) {
        this.f20633g = c7;
        this.f20635i = Character.toLowerCase(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f20630d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f20631e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        this.f20646t = (this.f20646t & 8) | (z7 ? 0 : 8);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7, int i7) {
        this.f20635i = Character.toLowerCase(c7);
        this.f20636j = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public R.b setContentDescription(CharSequence charSequence) {
        this.f20640n = charSequence;
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c7, int i7) {
        this.f20633g = c7;
        this.f20634h = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        this.f20630d = this.f20638l.getResources().getString(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public R.b setTooltipText(CharSequence charSequence) {
        this.f20641o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f20637k = L.b.d(this.f20638l, i7);
        c();
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f20633g = c7;
        this.f20634h = KeyEvent.normalizeMetaState(i7);
        this.f20635i = Character.toLowerCase(c8);
        this.f20636j = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public void setShowAsAction(int i7) {
    }
}
