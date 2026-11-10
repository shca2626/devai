package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a implements i {

    /* renamed from: l, reason: collision with root package name */
    public Context f11108l;

    /* renamed from: m, reason: collision with root package name */
    public Context f11109m;

    /* renamed from: n, reason: collision with root package name */
    public e f11110n;

    /* renamed from: o, reason: collision with root package name */
    public LayoutInflater f11111o;

    /* renamed from: p, reason: collision with root package name */
    public LayoutInflater f11112p;

    /* renamed from: q, reason: collision with root package name */
    public i.a f11113q;

    /* renamed from: r, reason: collision with root package name */
    public int f11114r;

    /* renamed from: s, reason: collision with root package name */
    public int f11115s;

    /* renamed from: t, reason: collision with root package name */
    public j f11116t;

    /* renamed from: u, reason: collision with root package name */
    public int f11117u;

    public a(Context context, int i7, int i8) {
        this.f11108l = context;
        this.f11111o = LayoutInflater.from(context);
        this.f11114r = i7;
        this.f11115s = i8;
    }

    public void a(View view, int i7) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f11116t).addView(view, i7);
    }

    public abstract void b(g gVar, j.a aVar);

    @Override // androidx.appcompat.view.menu.i
    public void c(e eVar, boolean z7) {
        i.a aVar = this.f11113q;
        if (aVar != null) {
            aVar.c(eVar, z7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.i
    public void d(boolean z7) {
        ViewGroup viewGroup = (ViewGroup) this.f11116t;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f11110n;
        int i7 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList arrayListE = this.f11110n.E();
            int size = arrayListE.size();
            int i8 = 0;
            for (int i9 = 0; i9 < size; i9++) {
                g gVar = (g) arrayListE.get(i9);
                if (q(i8, gVar)) {
                    View childAt = viewGroup.getChildAt(i8);
                    g itemData = childAt instanceof j.a ? ((j.a) childAt).getItemData() : null;
                    View viewN = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        a(viewN, i8);
                    }
                    i8++;
                }
            }
            i7 = i8;
        }
        while (i7 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i7)) {
                i7++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void h(i.a aVar) {
        this.f11113q = aVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void i(Context context, e eVar) {
        this.f11109m = context;
        this.f11112p = LayoutInflater.from(context);
        this.f11110n = eVar;
    }

    public j.a j(ViewGroup viewGroup) {
        return (j.a) this.f11111o.inflate(this.f11115s, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.i
    public boolean k(l lVar) {
        i.a aVar = this.f11113q;
        l lVar2 = lVar;
        if (aVar == null) {
            return false;
        }
        if (lVar == null) {
            lVar2 = this.f11110n;
        }
        return aVar.d(lVar2);
    }

    public boolean l(ViewGroup viewGroup, int i7) {
        viewGroup.removeViewAt(i7);
        return true;
    }

    public i.a m() {
        return this.f11113q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(g gVar, View view, ViewGroup viewGroup) {
        j.a aVarJ = view instanceof j.a ? (j.a) view : j(viewGroup);
        b(gVar, aVarJ);
        return (View) aVarJ;
    }

    public j o(ViewGroup viewGroup) {
        if (this.f11116t == null) {
            j jVar = (j) this.f11111o.inflate(this.f11114r, viewGroup, false);
            this.f11116t = jVar;
            jVar.b(this.f11110n);
            d(true);
        }
        return this.f11116t;
    }

    public void p(int i7) {
        this.f11117u = i7;
    }

    public abstract boolean q(int i7, g gVar);
}
