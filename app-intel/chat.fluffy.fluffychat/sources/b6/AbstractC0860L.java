package b6;

import C5.i;
import W5.R0;

/* renamed from: b6.L, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0860L {

    /* renamed from: a, reason: collision with root package name */
    public static final C0853E f13764a = new C0853E("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    public static final L5.p f13765b = new L5.p() { // from class: b6.I
        @Override // L5.p
        public final Object n(Object obj, Object obj2) {
            return AbstractC0860L.d(obj, (i.b) obj2);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final L5.p f13766c = new L5.p() { // from class: b6.J
        @Override // L5.p
        public final Object n(Object obj, Object obj2) {
            return AbstractC0860L.e((R0) obj, (i.b) obj2);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final L5.p f13767d = new L5.p() { // from class: b6.K
        @Override // L5.p
        public final Object n(Object obj, Object obj2) {
            return AbstractC0860L.h((C0864P) obj, (i.b) obj2);
        }
    };

    public static final Object d(Object obj, i.b bVar) {
        if (!(bVar instanceof R0)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
    }

    public static final R0 e(R0 r02, i.b bVar) {
        if (r02 != null) {
            return r02;
        }
        if (bVar instanceof R0) {
            return (R0) bVar;
        }
        return null;
    }

    public static final void f(C5.i iVar, Object obj) {
        if (obj == f13764a) {
            return;
        }
        if (obj instanceof C0864P) {
            ((C0864P) obj).b(iVar);
            return;
        }
        Object objR = iVar.R(null, f13766c);
        M5.m.c(objR, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((R0) objR).J(iVar, obj);
    }

    public static final Object g(C5.i iVar) {
        Object objR = iVar.R(0, f13765b);
        M5.m.b(objR);
        return objR;
    }

    public static final C0864P h(C0864P c0864p, i.b bVar) {
        if (bVar instanceof R0) {
            R0 r02 = (R0) bVar;
            c0864p.a(r02, r02.i(c0864p.f13770a));
        }
        return c0864p;
    }

    public static final Object i(C5.i iVar, Object obj) {
        if (obj == null) {
            obj = g(iVar);
        }
        if (obj == 0) {
            return f13764a;
        }
        if (obj instanceof Integer) {
            return iVar.R(new C0864P(iVar, ((Number) obj).intValue()), f13767d);
        }
        M5.m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((R0) obj).i(iVar);
    }
}
