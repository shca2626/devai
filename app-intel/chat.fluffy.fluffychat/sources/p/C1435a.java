package p;

import Z.AbstractC0684b;
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
public class C1435a implements R.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f20621a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20622b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20623c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f20624d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f20625e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f20626f;

    /* renamed from: g, reason: collision with root package name */
    public char f20627g;

    /* renamed from: i, reason: collision with root package name */
    public char f20629i;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f20631k;

    /* renamed from: l, reason: collision with root package name */
    public Context f20632l;

    /* renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f20633m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f20634n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f20635o;

    /* renamed from: h, reason: collision with root package name */
    public int f20628h = 4096;

    /* renamed from: j, reason: collision with root package name */
    public int f20630j = 4096;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f20636p = null;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f20637q = null;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20638r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20639s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f20640t = 16;

    public C1435a(Context context, int i7, int i8, int i9, int i10, CharSequence charSequence) {
        this.f20632l = context;
        this.f20621a = i8;
        this.f20622b = i7;
        this.f20623c = i10;
        this.f20624d = charSequence;
    }

    @Override // R.b
    public R.b a(AbstractC0684b abstractC0684b) {
        throw new UnsupportedOperationException();
    }

    @Override // R.b
    public AbstractC0684b b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f20631k;
        if (drawable != null) {
            if (this.f20638r || this.f20639s) {
                Drawable drawableR = P.a.r(drawable);
                this.f20631k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f20631k = drawableMutate;
                if (this.f20638r) {
                    P.a.o(drawableMutate, this.f20636p);
                }
                if (this.f20639s) {
                    P.a.p(this.f20631k, this.f20637q);
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
        return this.f20630j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f20629i;
    }

    @Override // R.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f20634n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f20622b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f20631k;
    }

    @Override // R.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f20636p;
    }

    @Override // R.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f20637q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f20626f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f20621a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // R.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f20628h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f20627g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f20623c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f20624d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f20625e;
        return charSequence != null ? charSequence : this.f20624d;
    }

    @Override // R.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f20635o;
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
        return (this.f20640t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f20640t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f20640t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f20640t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7) {
        this.f20629i = Character.toLowerCase(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f20640t = (z7 ? 1 : 0) | (this.f20640t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.f20640t = (z7 ? 2 : 0) | (this.f20640t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f20640t = (z7 ? 16 : 0) | (this.f20640t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f20631k = drawable;
        c();
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f20636p = colorStateList;
        this.f20638r = true;
        c();
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f20637q = mode;
        this.f20639s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f20626f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7) {
        this.f20627g = c7;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f20633m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8) {
        this.f20627g = c7;
        this.f20629i = Character.toLowerCase(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f20624d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f20625e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        this.f20640t = (this.f20640t & 8) | (z7 ? 0 : 8);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7, int i7) {
        this.f20629i = Character.toLowerCase(c7);
        this.f20630j = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public R.b setContentDescription(CharSequence charSequence) {
        this.f20634n = charSequence;
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c7, int i7) {
        this.f20627g = c7;
        this.f20628h = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        this.f20624d = this.f20632l.getResources().getString(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public R.b setTooltipText(CharSequence charSequence) {
        this.f20635o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f20631k = L.b.d(this.f20632l, i7);
        c();
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f20627g = c7;
        this.f20628h = KeyEvent.normalizeMetaState(i7);
        this.f20629i = Character.toLowerCase(c8);
        this.f20630j = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // R.b, android.view.MenuItem
    public void setShowAsAction(int i7) {
    }
}
