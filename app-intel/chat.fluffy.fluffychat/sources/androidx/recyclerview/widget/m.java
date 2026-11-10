package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class m extends RecyclerView.l {

    /* renamed from: g, reason: collision with root package name */
    public boolean f13452g = true;

    public final void A(RecyclerView.C c7) {
        I(c7);
        h(c7);
    }

    public final void B(RecyclerView.C c7) {
        J(c7);
    }

    public final void C(RecyclerView.C c7, boolean z7) {
        K(c7, z7);
        h(c7);
    }

    public final void D(RecyclerView.C c7, boolean z7) {
        L(c7, z7);
    }

    public final void E(RecyclerView.C c7) {
        M(c7);
        h(c7);
    }

    public final void F(RecyclerView.C c7) {
        N(c7);
    }

    public final void G(RecyclerView.C c7) {
        O(c7);
        h(c7);
    }

    public final void H(RecyclerView.C c7) {
        P(c7);
    }

    public void I(RecyclerView.C c7) {
    }

    public void J(RecyclerView.C c7) {
    }

    public void K(RecyclerView.C c7, boolean z7) {
    }

    public void L(RecyclerView.C c7, boolean z7) {
    }

    public void M(RecyclerView.C c7) {
    }

    public void N(RecyclerView.C c7) {
    }

    public void O(RecyclerView.C c7) {
    }

    public void P(RecyclerView.C c7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.C c7, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i7;
        int i8;
        return (bVar == null || ((i7 = bVar.f13167a) == (i8 = bVar2.f13167a) && bVar.f13168b == bVar2.f13168b)) ? w(c7) : y(c7, i7, bVar.f13168b, i8, bVar2.f13168b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.C c7, RecyclerView.C c8, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i7;
        int i8;
        int i9 = bVar.f13167a;
        int i10 = bVar.f13168b;
        if (c8.J()) {
            int i11 = bVar.f13167a;
            i8 = bVar.f13168b;
            i7 = i11;
        } else {
            i7 = bVar2.f13167a;
            i8 = bVar2.f13168b;
        }
        return x(c7, c8, i9, i10, i7, i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.C c7, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i7 = bVar.f13167a;
        int i8 = bVar.f13168b;
        View view = c7.f13136a;
        int left = bVar2 == null ? view.getLeft() : bVar2.f13167a;
        int top = bVar2 == null ? view.getTop() : bVar2.f13168b;
        if (c7.v() || (i7 == left && i8 == top)) {
            return z(c7);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return y(c7, i7, i8, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.C c7, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i7 = bVar.f13167a;
        int i8 = bVar2.f13167a;
        if (i7 != i8 || bVar.f13168b != bVar2.f13168b) {
            return y(c7, i7, bVar.f13168b, i8, bVar2.f13168b);
        }
        E(c7);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.C c7) {
        return !this.f13452g || c7.t();
    }

    public abstract boolean w(RecyclerView.C c7);

    public abstract boolean x(RecyclerView.C c7, RecyclerView.C c8, int i7, int i8, int i9, int i10);

    public abstract boolean y(RecyclerView.C c7, int i7, int i8, int i9, int i10);

    public abstract boolean z(RecyclerView.C c7);
}
