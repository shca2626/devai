package D3;

/* loaded from: classes.dex */
public final class k extends h {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f1739c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1740d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1741e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1742f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1743g;

    public k(byte[] bArr, int i7, int i8, int i9, int i10, int i11, int i12, boolean z7) {
        super(i11, i12);
        if (i9 + i11 > i7 || i10 + i12 > i8) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f1739c = bArr;
        this.f1740d = i7;
        this.f1741e = i8;
        this.f1742f = i9;
        this.f1743g = i10;
        if (z7) {
            h(i11, i12);
        }
    }

    @Override // D3.h
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i7 = this.f1740d;
        if (iD == i7 && iA == this.f1741e) {
            return this.f1739c;
        }
        int i8 = iD * iA;
        byte[] bArr = new byte[i8];
        int i9 = (this.f1743g * i7) + this.f1742f;
        if (iD == i7) {
            System.arraycopy(this.f1739c, i9, bArr, 0, i8);
            return bArr;
        }
        for (int i10 = 0; i10 < iA; i10++) {
            System.arraycopy(this.f1739c, i9, bArr, i10 * iD, iD);
            i9 += this.f1740d;
        }
        return bArr;
    }

    @Override // D3.h
    public byte[] c(int i7, byte[] bArr) {
        if (i7 < 0 || i7 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i7);
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.f1739c, ((i7 + this.f1743g) * this.f1740d) + this.f1742f, bArr, 0, iD);
        return bArr;
    }

    public final void h(int i7, int i8) {
        byte[] bArr = this.f1739c;
        int i9 = (this.f1743g * this.f1740d) + this.f1742f;
        int i10 = 0;
        while (i10 < i8) {
            int i11 = (i7 / 2) + i9;
            int i12 = (i9 + i7) - 1;
            int i13 = i9;
            while (i13 < i11) {
                byte b7 = bArr[i13];
                bArr[i13] = bArr[i12];
                bArr[i12] = b7;
                i13++;
                i12--;
            }
            i10++;
            i9 += this.f1740d;
        }
    }
}
