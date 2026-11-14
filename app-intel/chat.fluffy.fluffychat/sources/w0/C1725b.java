package w0;

import M5.g;
import M5.m;
import java.util.Map;
import w0.AbstractC1724a;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1725b extends AbstractC1724a {
    /* JADX WARN: Multi-variable type inference failed */
    public C1725b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // w0.AbstractC1724a
    public Object a(AbstractC1724a.c cVar) {
        m.e(cVar, "key");
        return b().get(cVar);
    }

    public final void c(AbstractC1724a.c cVar, Object obj) {
        m.e(cVar, "key");
        b().put(cVar, obj);
    }

    public C1725b(Map map) {
        m.e(map, "initialExtras");
        b().putAll(map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1725b(AbstractC1724a abstractC1724a) {
        this(abstractC1724a.b());
        m.e(abstractC1724a, "initialExtras");
    }

    public /* synthetic */ C1725b(AbstractC1724a abstractC1724a, int i7, g gVar) {
        this((i7 & 1) != 0 ? AbstractC1724a.b.f23259c : abstractC1724a);
    }
}
