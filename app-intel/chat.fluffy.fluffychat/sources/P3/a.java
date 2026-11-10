package P3;

import D3.d;
import D3.f;
import D3.j;
import D3.l;
import D3.n;
import D3.o;
import D3.p;
import J3.b;
import J3.e;
import Q3.c;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final p[] f7554b = new p[0];

    /* renamed from: a, reason: collision with root package name */
    public final c f7555a = new c();

    private static b c(b bVar) throws j {
        int[] iArrK = bVar.k();
        if (iArrK == null) {
            throw j.a();
        }
        int i7 = iArrK[0];
        int i8 = iArrK[1];
        int i9 = iArrK[2];
        int i10 = iArrK[3];
        b bVar2 = new b(30, 33);
        for (int i11 = 0; i11 < 33; i11++) {
            int iMin = Math.min((((i11 * i10) + (i10 / 2)) / 33) + i8, i10 - 1);
            for (int i12 = 0; i12 < 30; i12++) {
                if (bVar.g(Math.min((((i12 * i9) + (i9 / 2)) + (((i11 & 1) * i9) / 2)) / 30, i9 - 1) + i7, iMin)) {
                    bVar2.s(i12, i11);
                }
            }
        }
        return bVar2;
    }

    @Override // D3.l
    public n a(D3.c cVar) {
        return b(cVar, null);
    }

    @Override // D3.l
    public n b(D3.c cVar, Map map) throws j, f, d {
        e eVarB = this.f7555a.b(c(cVar.a()), map);
        n nVar = new n(eVarB.k(), eVarB.g(), f7554b, D3.a.MAXICODE);
        nVar.h(o.ERRORS_CORRECTED, eVarB.d());
        String strB = eVarB.b();
        if (strB != null) {
            nVar.h(o.ERROR_CORRECTION_LEVEL, strB);
        }
        return nVar;
    }

    @Override // D3.l
    public void reset() {
    }
}
