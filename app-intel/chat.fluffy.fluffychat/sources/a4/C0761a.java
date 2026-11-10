package a4;

/* renamed from: a4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0761a {

    /* renamed from: a, reason: collision with root package name */
    public final J3.b f10777a;

    /* renamed from: b, reason: collision with root package name */
    public j f10778b;

    /* renamed from: c, reason: collision with root package name */
    public g f10779c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10780d;

    public C0761a(J3.b bVar) throws D3.f {
        int iL = bVar.l();
        if (iL < 21 || (iL & 3) != 1) {
            throw D3.f.a();
        }
        this.f10777a = bVar;
    }

    public final int a(int i7, int i8, int i9) {
        return this.f10780d ? this.f10777a.g(i8, i7) : this.f10777a.g(i7, i8) ? (i9 << 1) | 1 : i9 << 1;
    }

    public void b() {
        int i7 = 0;
        while (i7 < this.f10777a.o()) {
            int i8 = i7 + 1;
            for (int i9 = i8; i9 < this.f10777a.l(); i9++) {
                if (this.f10777a.g(i7, i9) != this.f10777a.g(i9, i7)) {
                    this.f10777a.f(i9, i7);
                    this.f10777a.f(i7, i9);
                }
            }
            i7 = i8;
        }
    }

    public byte[] c() throws D3.f {
        g gVarD = d();
        j jVarE = e();
        c cVar = c.values()[gVarD.c()];
        int iL = this.f10777a.l();
        cVar.e(this.f10777a, iL);
        J3.b bVarA = jVarE.a();
        byte[] bArr = new byte[jVarE.h()];
        int i7 = iL - 1;
        boolean z7 = true;
        int i8 = i7;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 > 0) {
            if (i8 == 6) {
                i8--;
            }
            for (int i12 = 0; i12 < iL; i12++) {
                int i13 = z7 ? i7 - i12 : i12;
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = i8 - i14;
                    if (!bVarA.g(i15, i13)) {
                        i10++;
                        i11 <<= 1;
                        if (this.f10777a.g(i15, i13)) {
                            i11 |= 1;
                        }
                        if (i10 == 8) {
                            bArr[i9] = (byte) i11;
                            i9++;
                            i10 = 0;
                            i11 = 0;
                        }
                    }
                }
            }
            z7 = !z7;
            i8 -= 2;
        }
        if (i9 == jVarE.h()) {
            return bArr;
        }
        throw D3.f.a();
    }

    public g d() throws D3.f {
        g gVar = this.f10779c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i7 = 0; i7 < 6; i7++) {
            iA2 = a(i7, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i8 = 5; i8 >= 0; i8--) {
            iA3 = a(8, i8, iA3);
        }
        int iL = this.f10777a.l();
        int i9 = iL - 7;
        for (int i10 = iL - 1; i10 >= i9; i10--) {
            iA = a(8, i10, iA);
        }
        for (int i11 = iL - 8; i11 < iL; i11++) {
            iA = a(i11, 8, iA);
        }
        g gVarA = g.a(iA3, iA);
        this.f10779c = gVarA;
        if (gVarA != null) {
            return gVarA;
        }
        throw D3.f.a();
    }

    public j e() throws D3.f {
        j jVar = this.f10778b;
        if (jVar != null) {
            return jVar;
        }
        int iL = this.f10777a.l();
        int i7 = (iL - 17) / 4;
        if (i7 <= 6) {
            return j.i(i7);
        }
        int i8 = iL - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i9 = 5; i9 >= 0; i9--) {
            for (int i10 = iL - 9; i10 >= i8; i10--) {
                iA2 = a(i10, i9, iA2);
            }
        }
        j jVarC = j.c(iA2);
        if (jVarC != null && jVarC.e() == iL) {
            this.f10778b = jVarC;
            return jVarC;
        }
        for (int i11 = 5; i11 >= 0; i11--) {
            for (int i12 = iL - 9; i12 >= i8; i12--) {
                iA = a(i11, i12, iA);
            }
        }
        j jVarC2 = j.c(iA);
        if (jVarC2 == null || jVarC2.e() != iL) {
            throw D3.f.a();
        }
        this.f10778b = jVarC2;
        return jVarC2;
    }

    public void f() {
        if (this.f10779c == null) {
            return;
        }
        c.values()[this.f10779c.c()].e(this.f10777a, this.f10777a.l());
    }

    public void g(boolean z7) {
        this.f10778b = null;
        this.f10779c = null;
        this.f10780d = z7;
    }
}
