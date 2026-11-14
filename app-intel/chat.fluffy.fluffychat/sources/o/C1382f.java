package o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import o.AbstractC1378b;
import y.C1796k;

/* renamed from: o.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1382f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20255a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1378b f20256b;

    /* renamed from: o.f$a */
    public static class a implements AbstractC1378b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f20257a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f20258b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f20259c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final C1796k f20260d = new C1796k();

        public a(Context context, ActionMode.Callback callback) {
            this.f20258b = context;
            this.f20257a = callback;
        }

        @Override // o.AbstractC1378b.a
        public boolean a(AbstractC1378b abstractC1378b, MenuItem menuItem) {
            return this.f20257a.onActionItemClicked(e(abstractC1378b), new p.c(this.f20258b, (R.b) menuItem));
        }

        @Override // o.AbstractC1378b.a
        public boolean b(AbstractC1378b abstractC1378b, Menu menu) {
            return this.f20257a.onPrepareActionMode(e(abstractC1378b), f(menu));
        }

        @Override // o.AbstractC1378b.a
        public boolean c(AbstractC1378b abstractC1378b, Menu menu) {
            return this.f20257a.onCreateActionMode(e(abstractC1378b), f(menu));
        }

        @Override // o.AbstractC1378b.a
        public void d(AbstractC1378b abstractC1378b) {
            this.f20257a.onDestroyActionMode(e(abstractC1378b));
        }

        public ActionMode e(AbstractC1378b abstractC1378b) {
            int size = this.f20259c.size();
            for (int i7 = 0; i7 < size; i7++) {
                C1382f c1382f = (C1382f) this.f20259c.get(i7);
                if (c1382f != null && c1382f.f20256b == abstractC1378b) {
                    return c1382f;
                }
            }
            C1382f c1382f2 = new C1382f(this.f20258b, abstractC1378b);
            this.f20259c.add(c1382f2);
            return c1382f2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f20260d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            p.e eVar = new p.e(this.f20258b, (R.a) menu);
            this.f20260d.put(menu, eVar);
            return eVar;
        }
    }

    public C1382f(Context context, AbstractC1378b abstractC1378b) {
        this.f20255a = context;
        this.f20256b = abstractC1378b;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f20256b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f20256b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new p.e(this.f20255a, (R.a) this.f20256b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f20256b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f20256b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f20256b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f20256b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f20256b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f20256b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f20256b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f20256b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f20256b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f20256b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f20256b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z7) {
        this.f20256b.s(z7);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i7) {
        this.f20256b.n(i7);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i7) {
        this.f20256b.q(i7);
    }
}
