package X3;

import D3.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f9287a = b.f9288f;

    public int a(int[] iArr, int i7, int[] iArr2) throws d {
        c cVar = new c(this.f9287a, iArr);
        int[] iArr3 = new int[i7];
        boolean z7 = false;
        for (int i8 = i7; i8 > 0; i8--) {
            int iB = cVar.b(this.f9287a.c(i8));
            iArr3[i7 - i8] = iB;
            if (iB != 0) {
                z7 = true;
            }
        }
        if (!z7) {
            return 0;
        }
        c cVarD = this.f9287a.d();
        if (iArr2 != null) {
            for (int i9 : iArr2) {
                int iC = this.f9287a.c((iArr.length - 1) - i9);
                b bVar = this.f9287a;
                cVarD = cVarD.g(new c(bVar, new int[]{bVar.j(0, iC), 1}));
            }
        }
        c[] cVarArrD = d(this.f9287a.b(i7, 1), new c(this.f9287a, iArr3), i7);
        c cVar2 = cVarArrD[0];
        c cVar3 = cVarArrD[1];
        int[] iArrB = b(cVar2);
        int[] iArrC = c(cVar3, cVar2, iArrB);
        for (int i10 = 0; i10 < iArrB.length; i10++) {
            int length = (iArr.length - 1) - this.f9287a.h(iArrB[i10]);
            if (length < 0) {
                throw d.a();
            }
            iArr[length] = this.f9287a.j(iArr[length], iArrC[i10]);
        }
        return iArrB.length;
    }

    public final int[] b(c cVar) throws d {
        int iD = cVar.d();
        int[] iArr = new int[iD];
        int i7 = 0;
        for (int i8 = 1; i8 < this.f9287a.e() && i7 < iD; i8++) {
            if (cVar.b(i8) == 0) {
                iArr[i7] = this.f9287a.g(i8);
                i7++;
            }
        }
        if (i7 == iD) {
            return iArr;
        }
        throw d.a();
    }

    public final int[] c(c cVar, c cVar2, int[] iArr) {
        int iD = cVar2.d();
        if (iD < 1) {
            return new int[0];
        }
        int[] iArr2 = new int[iD];
        for (int i7 = 1; i7 <= iD; i7++) {
            iArr2[iD - i7] = this.f9287a.i(i7, cVar2.c(i7));
        }
        c cVar3 = new c(this.f9287a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            int iG = this.f9287a.g(iArr[i8]);
            iArr3[i8] = this.f9287a.i(this.f9287a.j(0, cVar.b(iG)), this.f9287a.g(cVar3.b(iG)));
        }
        return iArr3;
    }

    public final c[] d(c cVar, c cVar2, int i7) throws d {
        if (cVar.d() < cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarF = this.f9287a.f();
        c cVarD = this.f9287a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = cVarD;
            c cVar5 = cVarF;
            cVarF = cVar4;
            if (cVar.d() < i7 / 2) {
                int iC = cVarF.c(0);
                if (iC == 0) {
                    throw d.a();
                }
                int iG = this.f9287a.g(iC);
                return new c[]{cVarF.f(iG), cVar.f(iG)};
            }
            if (cVar.e()) {
                throw d.a();
            }
            c cVarF2 = this.f9287a.f();
            int iG2 = this.f9287a.g(cVar.c(cVar.d()));
            while (cVar2.d() >= cVar.d() && !cVar2.e()) {
                int iD = cVar2.d() - cVar.d();
                int i8 = this.f9287a.i(cVar2.c(cVar2.d()), iG2);
                cVarF2 = cVarF2.a(this.f9287a.b(iD, i8));
                cVar2 = cVar2.j(cVar.h(iD, i8));
            }
            cVarD = cVarF2.g(cVarF).j(cVar5).i();
        }
    }
}
