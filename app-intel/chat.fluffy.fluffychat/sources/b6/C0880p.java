package b6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: b6.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0880p {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13798l = AtomicReferenceFieldUpdater.newUpdater(C0880p.class, Object.class, "_next$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13799m = AtomicReferenceFieldUpdater.newUpdater(C0880p.class, Object.class, "_prev$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13800n = AtomicReferenceFieldUpdater.newUpdater(C0880p.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean c(C0880p c0880p, int i7) {
        C0880p c0880pM;
        do {
            c0880pM = m();
            if (c0880pM instanceof C0878n) {
                return (((C0878n) c0880pM).f13797o & i7) == 0 && c0880pM.c(c0880p, i7);
            }
        } while (!c0880pM.d(c0880p, this));
        return true;
    }

    public final boolean d(C0880p c0880p, C0880p c0880p2) {
        f13799m.set(c0880p, this);
        f13798l.set(c0880p, c0880p2);
        if (!A.b.a(f13798l, this, c0880p2, c0880p)) {
            return false;
        }
        c0880p.j(c0880p2);
        return true;
    }

    public final boolean f(C0880p c0880p) {
        f13799m.set(c0880p, this);
        f13798l.set(c0880p, this);
        while (k() == this) {
            if (A.b.a(f13798l, this, this, c0880p)) {
                c0880p.j(this);
                return true;
            }
        }
        return false;
    }

    public final void g(int i7) {
        c(new C0878n(i7), i7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (A.b.a(b6.C0880p.f13798l, r3, r2, ((b6.y) r4).f13816a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b6.C0880p h() {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = o()
            java.lang.Object r0 = r0.get(r7)
            b6.p r0 = (b6.C0880p) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = n()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            goto L25
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = o()
            boolean r0 = A.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.q()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            boolean r5 = r4 instanceof b6.y
            if (r5 == 0) goto L4f
            if (r3 == 0) goto L44
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = n()
            b6.y r4 = (b6.y) r4
            b6.p r4 = r4.f13816a
            boolean r2 = A.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L42
            goto L0
        L42:
            r2 = r3
            goto Lc
        L44:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = o()
            java.lang.Object r2 = r4.get(r2)
            b6.p r2 = (b6.C0880p) r2
            goto Ld
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            M5.m.c(r4, r3)
            r3 = r4
            b6.p r3 = (b6.C0880p) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.C0880p.h():b6.p");
    }

    public final C0880p i(C0880p c0880p) {
        while (c0880p.q()) {
            c0880p = (C0880p) f13799m.get(c0880p);
        }
        return c0880p;
    }

    public final void j(C0880p c0880p) {
        C0880p c0880p2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13799m;
        do {
            c0880p2 = (C0880p) atomicReferenceFieldUpdater.get(c0880p);
            if (k() != c0880p) {
                return;
            }
        } while (!A.b.a(f13799m, c0880p, c0880p2, this));
        if (q()) {
            c0880p.h();
        }
    }

    public final Object k() {
        return f13798l.get(this);
    }

    public final C0880p l() {
        C0880p c0880p;
        Object objK = k();
        y yVar = objK instanceof y ? (y) objK : null;
        if (yVar != null && (c0880p = yVar.f13816a) != null) {
            return c0880p;
        }
        M5.m.c(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (C0880p) objK;
    }

    public final C0880p m() {
        C0880p c0880pH = h();
        return c0880pH == null ? i((C0880p) f13799m.get(this)) : c0880pH;
    }

    public boolean q() {
        return k() instanceof y;
    }

    public boolean r() {
        return s() == null;
    }

    public final C0880p s() {
        Object objK;
        C0880p c0880p;
        do {
            objK = k();
            if (objK instanceof y) {
                return ((y) objK).f13816a;
            }
            if (objK == this) {
                return (C0880p) objK;
            }
            M5.m.c(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            c0880p = (C0880p) objK;
        } while (!A.b.a(f13798l, this, objK, c0880p.t()));
        c0880p.h();
        return null;
    }

    public final y t() {
        y yVar = (y) f13800n.get(this);
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(this);
        f13800n.set(this, yVar2);
        return yVar2;
    }

    public String toString() {
        return new M5.q(this) { // from class: b6.p.a
            @Override // T5.f
            public Object get() {
                return W5.Q.a(this.f5705m);
            }
        } + '@' + W5.Q.b(this);
    }
}
