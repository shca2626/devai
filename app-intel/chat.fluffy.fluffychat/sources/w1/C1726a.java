package w1;

import E0.E;

/* renamed from: w1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1726a extends AbstractC1727b {

    /* renamed from: a, reason: collision with root package name */
    public final long f23261a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23262b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f23263c;

    public C1726a(long j7, byte[] bArr, long j8) {
        this.f23261a = j8;
        this.f23262b = j7;
        this.f23263c = bArr;
    }

    public static C1726a d(E e7, int i7, long j7) {
        long jS = e7.S();
        int i8 = i7 - 4;
        byte[] bArr = new byte[i8];
        e7.u(bArr, 0, i8);
        return new C1726a(jS, bArr, j7);
    }

    @Override // w1.AbstractC1727b
    public String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.f23261a + ", identifier= " + this.f23262b + " }";
    }
}
