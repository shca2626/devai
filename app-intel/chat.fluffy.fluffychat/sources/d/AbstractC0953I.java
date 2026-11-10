package d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: d.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0953I {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15013b;

    /* renamed from: a, reason: collision with root package name */
    public final List f15012a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f15014c = new CopyOnWriteArrayList();

    /* renamed from: d.I$a */
    public static final class a extends Q1.e {

        /* renamed from: h, reason: collision with root package name */
        public final AbstractC0953I f15015h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f15016i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC0953I abstractC0953I, Q1.g gVar) {
            super(gVar, abstractC0953I.g());
            M5.m.e(abstractC0953I, "onBackPressedCallback");
            M5.m.e(gVar, "info");
            this.f15015h = abstractC0953I;
            this.f15016i = true;
        }

        public final void A(boolean z7) {
            this.f15016i = z7;
            x(z7 && this.f15015h.g());
        }

        @Override // Q1.e
        public void o() {
            this.f15015h.c();
        }

        @Override // Q1.e
        public void p() {
            this.f15015h.d();
        }

        @Override // Q1.e
        public void q(Q1.b bVar) {
            M5.m.e(bVar, "event");
            this.f15015h.e(new C0959e(bVar));
        }

        @Override // Q1.e
        public void r(Q1.b bVar) {
            M5.m.e(bVar, "event");
            this.f15015h.f(new C0959e(bVar));
        }

        public final boolean z() {
            return this.f15016i;
        }
    }

    public AbstractC0953I(boolean z7) {
        this.f15013b = z7;
    }

    public final void a(AutoCloseable autoCloseable) {
        M5.m.e(autoCloseable, "closeable");
        this.f15014c.add(autoCloseable);
    }

    public final a b(Q1.g gVar) {
        M5.m.e(gVar, "info");
        a aVar = new a(this, gVar);
        this.f15012a.add(aVar);
        return aVar;
    }

    public abstract void d();

    public void e(C0959e c0959e) {
        M5.m.e(c0959e, "backEvent");
    }

    public void f(C0959e c0959e) {
        M5.m.e(c0959e, "backEvent");
    }

    public final boolean g() {
        return this.f15013b;
    }

    public final void h() {
        Iterator it = this.f15014c.iterator();
        M5.m.d(it, "iterator(...)");
        while (it.hasNext()) {
            AbstractC0950F.a((AutoCloseable) it.next());
        }
        this.f15014c.clear();
        Iterator it2 = this.f15012a.iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).w();
        }
        this.f15012a.clear();
    }

    public final void i(boolean z7) {
        this.f15013b = z7;
        for (a aVar : this.f15012a) {
            aVar.x(aVar.z() && z7);
        }
    }

    public void c() {
    }
}
