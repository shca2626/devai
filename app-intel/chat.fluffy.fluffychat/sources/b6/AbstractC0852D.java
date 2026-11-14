package b6;

import a.C0741a;
import y5.AbstractC1814j;
import y5.C1813i;

/* renamed from: b6.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0852D {

    /* renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f13759a = new C0741a().a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f13760b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f13761c;

    static {
        Object objB;
        Object objB2;
        try {
            C1813i.a aVar = C1813i.f24010m;
            objB = C1813i.b(E5.a.class.getCanonicalName());
        } catch (Throwable th) {
            C1813i.a aVar2 = C1813i.f24010m;
            objB = C1813i.b(AbstractC1814j.a(th));
        }
        if (C1813i.d(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f13760b = (String) objB;
        try {
            objB2 = C1813i.b(AbstractC0852D.class.getCanonicalName());
        } catch (Throwable th2) {
            C1813i.a aVar3 = C1813i.f24010m;
            objB2 = C1813i.b(AbstractC1814j.a(th2));
        }
        if (C1813i.d(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f13761c = (String) objB2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
