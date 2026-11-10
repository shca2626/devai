package b6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: b6.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0881q {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13801a = AtomicReferenceFieldUpdater.newUpdater(C0881q.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public C0881q(boolean z7) {
        this._cur$volatile = new C0882r(8, z7);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13801a;
        while (true) {
            C0882r c0882r = (C0882r) atomicReferenceFieldUpdater.get(this);
            int iA = c0882r.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                A.b.a(f13801a, this, c0882r, c0882r.l());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13801a;
        while (true) {
            C0882r c0882r = (C0882r) atomicReferenceFieldUpdater.get(this);
            if (c0882r.d()) {
                return;
            } else {
                A.b.a(f13801a, this, c0882r, c0882r.l());
            }
        }
    }

    public final int c() {
        return ((C0882r) f13801a.get(this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13801a;
        while (true) {
            C0882r c0882r = (C0882r) atomicReferenceFieldUpdater.get(this);
            Object objM = c0882r.m();
            if (objM != C0882r.f13805h) {
                return objM;
            }
            A.b.a(f13801a, this, c0882r, c0882r.l());
        }
    }
}
