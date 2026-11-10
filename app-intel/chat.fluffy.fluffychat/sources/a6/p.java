package a6;

import M5.A;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final L5.q f10895a;

    public static final /* synthetic */ class a extends M5.k implements L5.q {

        /* renamed from: u, reason: collision with root package name */
        public static final a f10896u = new a();

        public a() {
            super(3, Z5.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // L5.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Object i(Z5.e eVar, Object obj, C5.e eVar2) {
            return eVar.b(obj, eVar2);
        }
    }

    static {
        a aVar = a.f10896u;
        M5.m.c(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f10895a = (L5.q) A.d(aVar, 3);
    }
}
