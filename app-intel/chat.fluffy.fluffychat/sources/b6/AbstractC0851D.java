package b6;

import a.C0740a;
import y5.AbstractC1815j;
import y5.C1814i;

/* renamed from: b6.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0851D {

    /* renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f13759a = new C0740a().a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f13760b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f13761c;

    static {
        Object objB;
        Object objB2;
        try {
            C1814i.a aVar = C1814i.f24004m;
            objB = C1814i.b(E5.a.class.getCanonicalName());
        } catch (Throwable th) {
            C1814i.a aVar2 = C1814i.f24004m;
            objB = C1814i.b(AbstractC1815j.a(th));
        }
        if (C1814i.d(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f13760b = (String) objB;
        try {
            objB2 = C1814i.b(AbstractC0851D.class.getCanonicalName());
        } catch (Throwable th2) {
            C1814i.a aVar3 = C1814i.f24004m;
            objB2 = C1814i.b(AbstractC1815j.a(th2));
        }
        if (C1814i.d(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f13761c = (String) objB2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
