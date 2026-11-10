package w0;

import M5.g;
import M5.m;
import java.util.Map;
import w0.AbstractC1725a;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1726b extends AbstractC1725a {
    /* JADX WARN: Multi-variable type inference failed */
    public C1726b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // w0.AbstractC1725a
    public Object a(AbstractC1725a.c cVar) {
        m.e(cVar, "key");
        return b().get(cVar);
    }

    public final void c(AbstractC1725a.c cVar, Object obj) {
        m.e(cVar, "key");
        b().put(cVar, obj);
    }

    public C1726b(Map map) {
        m.e(map, "initialExtras");
        b().putAll(map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1726b(AbstractC1725a abstractC1725a) {
        this(abstractC1725a.b());
        m.e(abstractC1725a, "initialExtras");
    }

    public /* synthetic */ C1726b(AbstractC1725a abstractC1725a, int i7, g gVar) {
        this((i7 & 1) != 0 ? AbstractC1725a.b.f23253c : abstractC1725a);
    }
}
