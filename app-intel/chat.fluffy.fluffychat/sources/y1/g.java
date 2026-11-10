package y1;

import g1.r;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f23970d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23971a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f23972b;

    /* renamed from: c, reason: collision with root package name */
    public int f23973c;

    public static long a(byte[] bArr, int i7, boolean z7) {
        long j7 = bArr[0] & 255;
        if (z7) {
            j7 &= ~f23970d[i7 - 1];
        }
        for (int i8 = 1; i8 < i7; i8++) {
            j7 = (j7 << 8) | (bArr[i8] & 255);
        }
        return j7;
    }

    public static int c(int i7) {
        int i8 = 0;
        while (true) {
            long[] jArr = f23970d;
            if (i8 >= jArr.length) {
                return -1;
            }
            if ((jArr[i8] & i7) != 0) {
                return i8 + 1;
            }
            i8++;
        }
    }

    public int b() {
        return this.f23973c;
    }

    public long d(r rVar, boolean z7, boolean z8, int i7) {
        if (this.f23972b == 0) {
            if (!rVar.c(this.f23971a, 0, 1, z7)) {
                return -1L;
            }
            int iC = c(this.f23971a[0] & 255);
            this.f23973c = iC;
            if (iC == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f23972b = 1;
        }
        int i8 = this.f23973c;
        if (i8 > i7) {
            this.f23972b = 0;
            return -2L;
        }
        if (i8 != 1) {
            rVar.readFully(this.f23971a, 1, i8 - 1);
        }
        this.f23972b = 0;
        return a(this.f23971a, this.f23973c, z8);
    }

    public void e() {
        this.f23972b = 0;
        this.f23973c = 0;
    }
}
