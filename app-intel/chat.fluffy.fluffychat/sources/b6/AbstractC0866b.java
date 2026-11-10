package b6;

/* renamed from: b6.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0866b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0852E f13775a = new C0852E("CLOSED");

    public static final AbstractC0867c b(AbstractC0867c abstractC0867c) {
        while (true) {
            Object objG = abstractC0867c.g();
            if (objG == f13775a) {
                return abstractC0867c;
            }
            AbstractC0867c abstractC0867c2 = (AbstractC0867c) objG;
            if (abstractC0867c2 != null) {
                abstractC0867c = abstractC0867c2;
            } else if (abstractC0867c.m()) {
                return abstractC0867c;
            }
        }
    }

    public static final Object c(AbstractC0849B abstractC0849B, long j7, L5.p pVar) {
        while (true) {
            if (abstractC0849B.f13758c >= j7 && !abstractC0849B.k()) {
                return AbstractC0850C.a(abstractC0849B);
            }
            Object objG = abstractC0849B.g();
            if (objG == f13775a) {
                return AbstractC0850C.a(f13775a);
            }
            AbstractC0849B abstractC0849B2 = (AbstractC0849B) ((AbstractC0867c) objG);
            if (abstractC0849B2 == null) {
                abstractC0849B2 = (AbstractC0849B) pVar.n(Long.valueOf(abstractC0849B.f13758c + 1), abstractC0849B);
                if (abstractC0849B.o(abstractC0849B2)) {
                    if (abstractC0849B.k()) {
                        abstractC0849B.n();
                    }
                }
            }
            abstractC0849B = abstractC0849B2;
        }
    }
}
