package D1;

import D1.s;
import android.util.SparseArray;
import g1.InterfaceC1088s;
import g1.N;
import g1.V;

/* loaded from: classes.dex */
public final class t implements InterfaceC1088s {

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC1088s f1642l;

    /* renamed from: m, reason: collision with root package name */
    public final s.a f1643m;

    /* renamed from: n, reason: collision with root package name */
    public final SparseArray f1644n = new SparseArray();

    /* renamed from: o, reason: collision with root package name */
    public boolean f1645o;

    public t(InterfaceC1088s interfaceC1088s, s.a aVar) {
        this.f1642l = interfaceC1088s;
        this.f1643m = aVar;
    }

    @Override // g1.InterfaceC1088s
    public V e(int i7, int i8) {
        if (i8 != 3) {
            this.f1645o = true;
            return this.f1642l.e(i7, i8);
        }
        v vVar = (v) this.f1644n.get(i7);
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this.f1642l.e(i7, i8), this.f1643m);
        this.f1644n.put(i7, vVar2);
        return vVar2;
    }

    @Override // g1.InterfaceC1088s
    public void o() {
        this.f1642l.o();
        if (this.f1645o) {
            for (int i7 = 0; i7 < this.f1644n.size(); i7++) {
                ((v) this.f1644n.valueAt(i7)).k(true);
            }
        }
    }

    @Override // g1.InterfaceC1088s
    public void w(N n7) {
        this.f1642l.w(n7);
    }
}
