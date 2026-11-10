package D5;

import C5.e;
import C5.i;
import E5.h;
import E5.j;
import L5.p;
import M5.A;
import M5.m;
import y5.AbstractC1815j;

/* loaded from: classes.dex */
public class b {

    public static final class a extends j {

        /* renamed from: m, reason: collision with root package name */
        public int f1830m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ p f1831n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Object f1832o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, p pVar, Object obj) {
            super(eVar);
            this.f1831n = pVar;
            this.f1832o = obj;
            m.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // E5.a
        public Object q(Object obj) throws Throwable {
            int i7 = this.f1830m;
            if (i7 == 0) {
                this.f1830m = 1;
                AbstractC1815j.b(obj);
                m.c(this.f1831n, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) A.d(this.f1831n, 2)).n(this.f1832o, this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f1830m = 2;
            AbstractC1815j.b(obj);
            return obj;
        }
    }

    /* renamed from: D5.b$b, reason: collision with other inner class name */
    public static final class C0017b extends E5.d {

        /* renamed from: o, reason: collision with root package name */
        public int f1833o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ p f1834p;

        /* renamed from: q, reason: collision with root package name */
        public final /* synthetic */ Object f1835q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0017b(e eVar, i iVar, p pVar, Object obj) {
            super(eVar, iVar);
            this.f1834p = pVar;
            this.f1835q = obj;
            m.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // E5.a
        public Object q(Object obj) throws Throwable {
            int i7 = this.f1833o;
            if (i7 == 0) {
                this.f1833o = 1;
                AbstractC1815j.b(obj);
                m.c(this.f1834p, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                return ((p) A.d(this.f1834p, 2)).n(this.f1835q, this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f1833o = 2;
            AbstractC1815j.b(obj);
            return obj;
        }
    }

    public static final class c extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(eVar);
            m.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // E5.a
        public Object q(Object obj) throws Throwable {
            AbstractC1815j.b(obj);
            return obj;
        }
    }

    public static final class d extends E5.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, i iVar) {
            super(eVar, iVar);
            m.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // E5.a
        public Object q(Object obj) throws Throwable {
            AbstractC1815j.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e a(p pVar, Object obj, e eVar) {
        m.e(pVar, "<this>");
        m.e(eVar, "completion");
        e eVarA = h.a(eVar);
        if (pVar instanceof E5.a) {
            return ((E5.a) pVar).l(obj, eVarA);
        }
        i context = eVarA.getContext();
        return context == C5.j.f1392l ? new a(eVarA, pVar, obj) : new C0017b(eVarA, context, pVar, obj);
    }

    public static final e b(e eVar) {
        i context = eVar.getContext();
        return context == C5.j.f1392l ? new c(eVar) : new d(eVar, context);
    }

    public static e c(e eVar) {
        e eVarT;
        m.e(eVar, "<this>");
        E5.d dVar = eVar instanceof E5.d ? (E5.d) eVar : null;
        return (dVar == null || (eVarT = dVar.t()) == null) ? eVar : eVarT;
    }

    public static Object d(p pVar, Object obj, e eVar) {
        m.e(pVar, "<this>");
        m.e(eVar, "completion");
        return ((p) A.d(pVar, 2)).n(obj, b(h.a(eVar)));
    }
}
