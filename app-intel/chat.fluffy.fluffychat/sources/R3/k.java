package R3;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class k implements D3.l {
    public static float e(int[] iArr, int[] iArr2, float f7) {
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            i7 += iArr[i9];
            i8 += iArr2[i9];
        }
        if (i7 < i8) {
            return Float.POSITIVE_INFINITY;
        }
        float f8 = i7;
        float f9 = f8 / i8;
        float f10 = f7 * f9;
        float f11 = 0.0f;
        for (int i10 = 0; i10 < length; i10++) {
            float f12 = iArr2[i10] * f9;
            float f13 = iArr[i10];
            float f14 = f13 > f12 ? f13 - f12 : f12 - f13;
            if (f14 > f10) {
                return Float.POSITIVE_INFINITY;
            }
            f11 += f14;
        }
        return f11 / f8;
    }

    public static void f(J3.a aVar, int i7, int[] iArr) throws D3.j {
        int length = iArr.length;
        int i8 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iK = aVar.k();
        if (i7 >= iK) {
            throw D3.j.a();
        }
        boolean z7 = !aVar.c(i7);
        while (i7 < iK) {
            if (aVar.c(i7) != z7) {
                iArr[i8] = iArr[i8] + 1;
            } else {
                i8++;
                if (i8 == length) {
                    break;
                }
                iArr[i8] = 1;
                z7 = !z7;
            }
            i7++;
        }
        if (i8 != length) {
            if (i8 != length - 1 || i7 != iK) {
                throw D3.j.a();
            }
        }
    }

    public static void g(J3.a aVar, int i7, int[] iArr) throws D3.j {
        int length = iArr.length;
        boolean zC = aVar.c(i7);
        while (i7 > 0 && length >= 0) {
            i7--;
            if (aVar.c(i7) != zC) {
                length--;
                zC = !zC;
            }
        }
        if (length >= 0) {
            throw D3.j.a();
        }
        f(aVar, i7 + 1, iArr);
    }

    @Override // D3.l
    public D3.n a(D3.c cVar) {
        return b(cVar, null);
    }

    @Override // D3.l
    public D3.n b(D3.c cVar, Map map) throws D3.j {
        try {
            return d(cVar, map);
        } catch (D3.j e7) {
            if (map == null || !map.containsKey(D3.e.TRY_HARDER) || !cVar.e()) {
                throw e7;
            }
            D3.c cVarF = cVar.f();
            D3.n nVarD = d(cVarF, map);
            Map mapD = nVarD.d();
            int iIntValue = 270;
            if (mapD != null) {
                D3.o oVar = D3.o.ORIENTATION;
                if (mapD.containsKey(oVar)) {
                    iIntValue = (((Integer) mapD.get(oVar)).intValue() + 270) % 360;
                }
            }
            nVarD.h(D3.o.ORIENTATION, Integer.valueOf(iIntValue));
            D3.p[] pVarArrE = nVarD.e();
            if (pVarArrE != null) {
                int iC = cVarF.c();
                for (int i7 = 0; i7 < pVarArrE.length; i7++) {
                    pVarArrE[i7] = new D3.p((iC - pVarArrE[i7].d()) - 1.0f, pVarArrE[i7].c());
                }
            }
            return nVarD;
        }
    }

    public abstract D3.n c(int i7, J3.a aVar, Map map);

    public final D3.n d(D3.c cVar, Map map) throws D3.j {
        Map map2;
        int i7;
        int i8;
        Map map3 = map;
        int iD = cVar.d();
        int iC = cVar.c();
        J3.a aVar = new J3.a(iD);
        int i9 = 1;
        boolean z7 = map3 != null && map3.containsKey(D3.e.TRY_HARDER);
        int iMax = Math.max(1, iC >> (z7 ? 8 : 5));
        int i10 = z7 ? iC : 15;
        int i11 = iC / 2;
        int i12 = 0;
        while (i12 < i10) {
            int i13 = i12 + 1;
            int i14 = i13 / 2;
            if ((i12 & 1) != 0) {
                i14 = -i14;
            }
            int i15 = (i14 * iMax) + i11;
            if (i15 < 0 || i15 >= iC) {
                break;
            }
            try {
                aVar = cVar.b(i15, aVar);
                int i16 = 0;
                while (i16 < 2) {
                    if (i16 == i9) {
                        aVar.n();
                        if (map3 != null) {
                            D3.e eVar = D3.e.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(eVar)) {
                                EnumMap enumMap = new EnumMap(D3.e.class);
                                enumMap.putAll(map3);
                                enumMap.remove(eVar);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        D3.n nVarC = c(i15, aVar, map3);
                        if (i16 == i9) {
                            try {
                                nVarC.h(D3.o.ORIENTATION, 180);
                                D3.p[] pVarArrE = nVarC.e();
                                if (pVarArrE != null) {
                                    i8 = i9;
                                    float f7 = iD;
                                    try {
                                        map2 = map3;
                                    } catch (D3.m unused) {
                                        map2 = map3;
                                    }
                                    try {
                                        i7 = iD;
                                    } catch (D3.m unused2) {
                                        i7 = iD;
                                        i16++;
                                        map3 = map2;
                                        i9 = i8;
                                        iD = i7;
                                    }
                                    try {
                                        pVarArrE[0] = new D3.p((f7 - pVarArrE[0].c()) - 1.0f, pVarArrE[0].d());
                                        pVarArrE[i8] = new D3.p((f7 - pVarArrE[i8].c()) - 1.0f, pVarArrE[i8].d());
                                    } catch (D3.m unused3) {
                                        continue;
                                        i16++;
                                        map3 = map2;
                                        i9 = i8;
                                        iD = i7;
                                    }
                                }
                            } catch (D3.m unused4) {
                                map2 = map3;
                                i7 = iD;
                                i8 = i9;
                            }
                        }
                        return nVarC;
                    } catch (D3.m unused5) {
                        map2 = map3;
                        i7 = iD;
                        i8 = i9;
                    }
                }
            } catch (D3.j unused6) {
            }
            i12 = i13;
            i9 = i9;
            iD = iD;
        }
        throw D3.j.a();
    }

    @Override // D3.l
    public void reset() {
    }
}
