package Z5;

import b6.C0852E;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final C0852E f10461a = new C0852E("NO_VALUE");

    public static final o a(int i7, int i8, Y5.a aVar) {
        if (i7 < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i7).toString());
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i8).toString());
        }
        if (i7 > 0 || i8 > 0 || aVar == Y5.a.f9870l) {
            int i9 = i8 + i7;
            if (i9 < 0) {
                i9 = Integer.MAX_VALUE;
            }
            return new t(i7, i9, aVar);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + aVar).toString());
    }

    public static /* synthetic */ o b(int i7, int i8, Y5.a aVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            aVar = Y5.a.f9870l;
        }
        return a(i7, i8, aVar);
    }

    public static final d e(s sVar, C5.i iVar, int i7, Y5.a aVar) {
        return ((i7 == 0 || i7 == -3) && aVar == Y5.a.f9870l) ? sVar : new a6.h(sVar, iVar, i7, aVar);
    }

    public static final Object f(Object[] objArr, long j7) {
        return objArr[((int) j7) & (objArr.length - 1)];
    }

    public static final void g(Object[] objArr, long j7, Object obj) {
        objArr[((int) j7) & (objArr.length - 1)] = obj;
    }
}
