package y;

import z.AbstractC1826a;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f23821a = new Object();

    public static final Object c(l lVar, int i7) {
        Object obj;
        M5.m.e(lVar, "<this>");
        int iA = AbstractC1826a.a(lVar.f23818m, lVar.f23820o, i7);
        if (iA < 0 || (obj = lVar.f23819n[iA]) == f23821a) {
            return null;
        }
        return obj;
    }

    public static final void d(l lVar, int i7) {
        M5.m.e(lVar, "<this>");
        int iA = AbstractC1826a.a(lVar.f23818m, lVar.f23820o, i7);
        if (iA >= 0) {
            Object[] objArr = lVar.f23819n;
            Object obj = objArr[iA];
            Object obj2 = f23821a;
            if (obj != obj2) {
                objArr[iA] = obj2;
                lVar.f23817l = true;
            }
        }
    }

    public static final void e(l lVar) {
        int i7 = lVar.f23820o;
        int[] iArr = lVar.f23818m;
        Object[] objArr = lVar.f23819n;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            Object obj = objArr[i9];
            if (obj != f23821a) {
                if (i9 != i8) {
                    iArr[i8] = iArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        lVar.f23817l = false;
        lVar.f23820o = i8;
    }
}
