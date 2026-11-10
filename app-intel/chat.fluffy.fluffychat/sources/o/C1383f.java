package o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import o.AbstractC1379b;
import y.C1797k;

/* renamed from: o.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1383f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20256a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1379b f20257b;

    /* renamed from: o.f$a */
    public static class a implements AbstractC1379b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f20258a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f20259b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f20260c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final C1797k f20261d = new C1797k();

        public a(Context context, ActionMode.Callback callback) {
            this.f20259b = context;
            this.f20258a = callback;
        }

        @Override // o.AbstractC1379b.a
        public boolean a(AbstractC1379b abstractC1379b, MenuItem menuItem) {
            return this.f20258a.onActionItemClicked(e(abstractC1379b), new p.c(this.f20259b, (R.b) menuItem));
        }

        @Override // o.AbstractC1379b.a
        public boolean b(AbstractC1379b abstractC1379b, Menu menu) {
            return this.f20258a.onPrepareActionMode(e(abstractC1379b), f(menu));
        }

        @Override // o.AbstractC1379b.a
        public boolean c(AbstractC1379b abstractC1379b, Menu menu) {
            return this.f20258a.onCreateActionMode(e(abstractC1379b), f(menu));
        }

        @Override // o.AbstractC1379b.a
        public void d(AbstractC1379b abstractC1379b) {
            this.f20258a.onDestroyActionMode(e(abstractC1379b));
        }

        public ActionMode e(AbstractC1379b abstractC1379b) {
            int size = this.f20260c.size();
            for (int i7 = 0; i7 < size; i7++) {
                C1383f c1383f = (C1383f) this.f20260c.get(i7);
                if (c1383f != null && c1383f.f20257b == abstractC1379b) {
                    return c1383f;
                }
            }
            C1383f c1383f2 = new C1383f(this.f20259b, abstractC1379b);
            this.f20260c.add(c1383f2);
            return c1383f2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f20261d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            p.e eVar = new p.e(this.f20259b, (R.a) menu);
            this.f20261d.put(menu, eVar);
            return eVar;
        }
    }

    public C1383f(Context context, AbstractC1379b abstractC1379b) {
        this.f20256a = context;
        this.f20257b = abstractC1379b;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f20257b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f20257b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new p.e(this.f20256a, (R.a) this.f20257b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f20257b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f20257b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f20257b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f20257b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f20257b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f20257b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f20257b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f20257b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f20257b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f20257b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f20257b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z7) {
        this.f20257b.s(z7);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i7) {
        this.f20257b.n(i7);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i7) {
        this.f20257b.q(i7);
    }
}
