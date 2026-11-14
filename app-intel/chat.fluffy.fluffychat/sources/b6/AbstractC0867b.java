package b6;

/* renamed from: b6.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0867b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0853E f13775a = new C0853E("CLOSED");

    public static final AbstractC0868c b(AbstractC0868c abstractC0868c) {
        while (true) {
            Object objG = abstractC0868c.g();
            if (objG == f13775a) {
                return abstractC0868c;
            }
            AbstractC0868c abstractC0868c2 = (AbstractC0868c) objG;
            if (abstractC0868c2 != null) {
                abstractC0868c = abstractC0868c2;
            } else if (abstractC0868c.m()) {
                return abstractC0868c;
            }
        }
    }

    public static final Object c(AbstractC0850B abstractC0850B, long j7, L5.p pVar) {
        while (true) {
            if (abstractC0850B.f13758c >= j7 && !abstractC0850B.k()) {
                return AbstractC0851C.a(abstractC0850B);
            }
            Object objG = abstractC0850B.g();
            if (objG == f13775a) {
                return AbstractC0851C.a(f13775a);
            }
            AbstractC0850B abstractC0850B2 = (AbstractC0850B) ((AbstractC0868c) objG);
            if (abstractC0850B2 == null) {
                abstractC0850B2 = (AbstractC0850B) pVar.n(Long.valueOf(abstractC0850B.f13758c + 1), abstractC0850B);
                if (abstractC0850B.o(abstractC0850B2)) {
                    if (abstractC0850B.k()) {
                        abstractC0850B.n();
                    }
                }
            }
            abstractC0850B = abstractC0850B2;
        }
    }
}
