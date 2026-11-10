package D3;

/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: c, reason: collision with root package name */
    public final h f1732c;

    public g(h hVar) {
        super(hVar.d(), hVar.a());
        this.f1732c = hVar;
    }

    @Override // D3.h
    public byte[] b() {
        byte[] bArrB = this.f1732c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i7 = 0; i7 < iD; i7++) {
            bArr[i7] = (byte) (255 - (bArrB[i7] & 255));
        }
        return bArr;
    }

    @Override // D3.h
    public byte[] c(int i7, byte[] bArr) {
        byte[] bArrC = this.f1732c.c(i7, bArr);
        int iD = d();
        for (int i8 = 0; i8 < iD; i8++) {
            bArrC[i8] = (byte) (255 - (bArrC[i8] & 255));
        }
        return bArrC;
    }

    @Override // D3.h
    public h e() {
        return this.f1732c;
    }

    @Override // D3.h
    public boolean f() {
        return this.f1732c.f();
    }

    @Override // D3.h
    public h g() {
        return new g(this.f1732c.g());
    }
}
