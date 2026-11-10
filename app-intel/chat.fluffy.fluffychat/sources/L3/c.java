package L3;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f5476a;

    public c(a aVar) {
        this.f5476a = aVar;
    }

    public int a(int[] iArr, int i7) throws d {
        b bVar = new b(this.f5476a, iArr);
        int[] iArr2 = new int[i7];
        boolean z7 = true;
        for (int i8 = 0; i8 < i7; i8++) {
            a aVar = this.f5476a;
            int iB = bVar.b(aVar.c(aVar.d() + i8));
            iArr2[(i7 - 1) - i8] = iB;
            if (iB != 0) {
                z7 = false;
            }
        }
        if (z7) {
            return 0;
        }
        b[] bVarArrD = d(this.f5476a.b(i7, 1), new b(this.f5476a, iArr2), i7);
        b bVar2 = bVarArrD[0];
        b bVar3 = bVarArrD[1];
        int[] iArrB = b(bVar2);
        int[] iArrC = c(bVar3, iArrB);
        for (int i9 = 0; i9 < iArrB.length; i9++) {
            int length = (iArr.length - 1) - this.f5476a.i(iArrB[i9]);
            if (length < 0) {
                throw new d("Bad error location");
            }
            iArr[length] = a.a(iArr[length], iArrC[i9]);
        }
        return iArrB.length;
    }

    public final int[] b(b bVar) throws d {
        int iD = bVar.d();
        if (iD == 1) {
            return new int[]{bVar.c(1)};
        }
        int[] iArr = new int[iD];
        int i7 = 0;
        for (int i8 = 1; i8 < this.f5476a.f() && i7 < iD; i8++) {
            if (bVar.b(i8) == 0) {
                iArr[i7] = this.f5476a.h(i8);
                i7++;
            }
        }
        if (i7 == iD) {
            return iArr;
        }
        throw new d("Error locator degree does not match number of roots");
    }

    public final int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            int iH = this.f5476a.h(iArr[i7]);
            int iJ = 1;
            for (int i8 = 0; i8 < length; i8++) {
                if (i7 != i8) {
                    int iJ2 = this.f5476a.j(iArr[i8], iH);
                    iJ = this.f5476a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i7] = this.f5476a.j(bVar.b(iH), this.f5476a.h(iJ));
            if (this.f5476a.d() != 0) {
                iArr2[i7] = this.f5476a.j(iArr2[i7], iH);
            }
        }
        return iArr2;
    }

    public final b[] d(b bVar, b bVar2, int i7) throws d {
        if (bVar.d() < bVar2.d()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b bVarG = this.f5476a.g();
        b bVarE = this.f5476a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = bVarE;
            b bVar5 = bVarG;
            bVarG = bVar4;
            if (bVar.d() * 2 < i7) {
                int iC = bVarG.c(0);
                if (iC == 0) {
                    throw new d("sigmaTilde(0) was zero");
                }
                int iH = this.f5476a.h(iC);
                return new b[]{bVarG.f(iH), bVar.f(iH)};
            }
            if (bVar.e()) {
                throw new d("r_{i-1} was zero");
            }
            b bVarG2 = this.f5476a.g();
            int iH2 = this.f5476a.h(bVar.c(bVar.d()));
            while (bVar2.d() >= bVar.d() && !bVar2.e()) {
                int iD = bVar2.d() - bVar.d();
                int iJ = this.f5476a.j(bVar2.c(bVar2.d()), iH2);
                bVarG2 = bVarG2.a(this.f5476a.b(iD, iJ));
                bVar2 = bVar2.a(bVar.h(iD, iJ));
            }
            bVarE = bVarG2.g(bVarG).a(bVar5);
        } while (bVar2.d() < bVar.d());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial? r: " + bVar2 + ", rLast: " + bVar);
    }
}
