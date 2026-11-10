package G0;

import E0.U;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3122a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3123b = new ArrayList(1);

    /* renamed from: c, reason: collision with root package name */
    public int f3124c;

    /* renamed from: d, reason: collision with root package name */
    public j f3125d;

    public b(boolean z7) {
        this.f3122a = z7;
    }

    @Override // G0.f
    public final void l(x xVar) {
        j3.o.q(xVar);
        if (this.f3123b.contains(xVar)) {
            return;
        }
        this.f3123b.add(xVar);
        this.f3124c++;
    }

    public final void u(int i7) {
        j jVar = (j) U.i(this.f3125d);
        for (int i8 = 0; i8 < this.f3124c; i8++) {
            ((x) this.f3123b.get(i8)).g(this, jVar, this.f3122a, i7);
        }
    }

    public final void v() {
        j jVar = (j) U.i(this.f3125d);
        for (int i7 = 0; i7 < this.f3124c; i7++) {
            ((x) this.f3123b.get(i7)).a(this, jVar, this.f3122a);
        }
        this.f3125d = null;
    }

    public final void w(j jVar) {
        for (int i7 = 0; i7 < this.f3124c; i7++) {
            ((x) this.f3123b.get(i7)).h(this, jVar, this.f3122a);
        }
    }

    public final void x(j jVar) {
        this.f3125d = jVar;
        for (int i7 = 0; i7 < this.f3124c; i7++) {
            ((x) this.f3123b.get(i7)).e(this, jVar, this.f3122a);
        }
    }
}
