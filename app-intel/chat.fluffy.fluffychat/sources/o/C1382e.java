package o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import o.AbstractC1379b;

/* renamed from: o.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1382e extends AbstractC1379b implements e.a {

    /* renamed from: n, reason: collision with root package name */
    public Context f20249n;

    /* renamed from: o, reason: collision with root package name */
    public ActionBarContextView f20250o;

    /* renamed from: p, reason: collision with root package name */
    public AbstractC1379b.a f20251p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f20252q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20253r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20254s;

    /* renamed from: t, reason: collision with root package name */
    public androidx.appcompat.view.menu.e f20255t;

    public C1382e(Context context, ActionBarContextView actionBarContextView, AbstractC1379b.a aVar, boolean z7) {
        this.f20249n = context;
        this.f20250o = actionBarContextView;
        this.f20251p = aVar;
        androidx.appcompat.view.menu.e eVarS = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.f20255t = eVarS;
        eVarS.R(this);
        this.f20254s = z7;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f20251p.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f20250o.l();
    }

    @Override // o.AbstractC1379b
    public void c() {
        if (this.f20253r) {
            return;
        }
        this.f20253r = true;
        this.f20251p.d(this);
    }

    @Override // o.AbstractC1379b
    public View d() {
        WeakReference weakReference = this.f20252q;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // o.AbstractC1379b
    public Menu e() {
        return this.f20255t;
    }

    @Override // o.AbstractC1379b
    public MenuInflater f() {
        return new C1384g(this.f20250o.getContext());
    }

    @Override // o.AbstractC1379b
    public CharSequence g() {
        return this.f20250o.getSubtitle();
    }

    @Override // o.AbstractC1379b
    public CharSequence i() {
        return this.f20250o.getTitle();
    }

    @Override // o.AbstractC1379b
    public void k() {
        this.f20251p.b(this, this.f20255t);
    }

    @Override // o.AbstractC1379b
    public boolean l() {
        return this.f20250o.j();
    }

    @Override // o.AbstractC1379b
    public void m(View view) {
        this.f20250o.setCustomView(view);
        this.f20252q = view != null ? new WeakReference(view) : null;
    }

    @Override // o.AbstractC1379b
    public void n(int i7) {
        o(this.f20249n.getString(i7));
    }

    @Override // o.AbstractC1379b
    public void o(CharSequence charSequence) {
        this.f20250o.setSubtitle(charSequence);
    }

    @Override // o.AbstractC1379b
    public void q(int i7) {
        r(this.f20249n.getString(i7));
    }

    @Override // o.AbstractC1379b
    public void r(CharSequence charSequence) {
        this.f20250o.setTitle(charSequence);
    }

    @Override // o.AbstractC1379b
    public void s(boolean z7) {
        super.s(z7);
        this.f20250o.setTitleOptional(z7);
    }
}
