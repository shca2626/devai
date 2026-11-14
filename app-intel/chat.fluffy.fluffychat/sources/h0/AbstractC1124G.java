package h0;

import y5.AbstractC1814j;
import y5.C1823s;

/* renamed from: h0.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1124G {

    /* renamed from: h0.G$a */
    public static final class a extends E5.l implements L5.q {

        /* renamed from: p, reason: collision with root package name */
        public int f16567p;

        /* renamed from: q, reason: collision with root package name */
        public /* synthetic */ Object f16568q;

        public a(C5.e eVar) {
            super(3, eVar);
        }

        @Override // L5.q
        public /* bridge */ /* synthetic */ Object i(Object obj, Object obj2, Object obj3) {
            return u((y) obj, ((Boolean) obj2).booleanValue(), (C5.e) obj3);
        }

        @Override // E5.a
        public final Object q(Object obj) throws Throwable {
            Object objE = D5.c.e();
            int i7 = this.f16567p;
            if (i7 != 0) {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC1814j.b(obj);
                return obj;
            }
            AbstractC1814j.b(obj);
            y yVar = (y) this.f16568q;
            this.f16567p = 1;
            Object objC = yVar.c(this);
            return objC == objE ? objE : objC;
        }

        public final Object u(y yVar, boolean z7, C5.e eVar) {
            a aVar = new a(eVar);
            aVar.f16568q = yVar;
            return aVar.q(C1823s.f24020a);
        }
    }

    public static final Object a(InterfaceC1123F interfaceC1123F, C5.e eVar) {
        return interfaceC1123F.b(new a(null), eVar);
    }
}
