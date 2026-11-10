package w1;

import E0.E;

/* renamed from: w1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1727a extends AbstractC1728b {

    /* renamed from: a, reason: collision with root package name */
    public final long f23255a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23256b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f23257c;

    public C1727a(long j7, byte[] bArr, long j8) {
        this.f23255a = j8;
        this.f23256b = j7;
        this.f23257c = bArr;
    }

    public static C1727a d(E e7, int i7, long j7) {
        long jS = e7.S();
        int i8 = i7 - 4;
        byte[] bArr = new byte[i8];
        e7.u(bArr, 0, i8);
        return new C1727a(jS, bArr, j7);
    }

    @Override // w1.AbstractC1728b
    public String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.f23255a + ", identifier= " + this.f23256b + " }";
    }
}
