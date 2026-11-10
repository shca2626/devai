package C0;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f1272a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1273b;

    /* renamed from: c, reason: collision with root package name */
    public final float f1274c;

    /* renamed from: d, reason: collision with root package name */
    public final float f1275d;

    /* renamed from: e, reason: collision with root package name */
    public final float f1276e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1277f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1278g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1279h;

    /* renamed from: i, reason: collision with root package name */
    public final b f1280i;

    /* renamed from: j, reason: collision with root package name */
    public int f1281j;

    /* renamed from: k, reason: collision with root package name */
    public int f1282k;

    /* renamed from: l, reason: collision with root package name */
    public int f1283l;

    /* renamed from: m, reason: collision with root package name */
    public int f1284m;

    /* renamed from: n, reason: collision with root package name */
    public int f1285n;

    /* renamed from: o, reason: collision with root package name */
    public int f1286o;

    /* renamed from: p, reason: collision with root package name */
    public int f1287p;

    /* renamed from: q, reason: collision with root package name */
    public double f1288q;

    public final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f1289a;

        /* renamed from: b, reason: collision with root package name */
        public float[] f1290b;

        /* renamed from: c, reason: collision with root package name */
        public float[] f1291c;

        /* renamed from: d, reason: collision with root package name */
        public float[] f1292d;

        /* renamed from: e, reason: collision with root package name */
        public double f1293e;

        /* renamed from: f, reason: collision with root package name */
        public double f1294f;

        /* renamed from: g, reason: collision with root package name */
        public double f1295g;

        public a() {
            this.f1289a = new float[x.this.f1279h];
            this.f1290b = new float[x.this.f1279h * x.this.f1273b];
            this.f1291c = new float[x.this.f1279h * x.this.f1273b];
            this.f1292d = new float[x.this.f1279h * x.this.f1273b];
        }

        @Override // C0.x.b
        public int a(int i7, int i8, int i9) {
            return s(this.f1289a, i7, i8, i9);
        }

        @Override // C0.x.b
        public void b(int i7, long j7, long j8) {
            int i8 = 0;
            while (i8 < x.this.f1273b) {
                long j9 = j7;
                this.f1291c[(x.this.f1282k * x.this.f1273b) + i8] = w(this.f1292d, (x.this.f1273b * i7) + i8, j9, j8);
                i8++;
                j7 = j9;
            }
        }

        @Override // C0.x.b
        public void c(int i7, int i8) {
            for (int i9 = 0; i9 < x.this.f1273b * i8; i9++) {
                this.f1290b[i7 + i9] = 0.0f;
            }
        }

        @Override // C0.x.b
        public void d(int i7, int i8) {
            int i9 = x.this.f1279h / i8;
            int i10 = x.this.f1273b * i8;
            int i11 = i7 * x.this.f1273b;
            for (int i12 = 0; i12 < i9; i12++) {
                double d7 = 0.0d;
                for (int i13 = 0; i13 < i10; i13++) {
                    d7 += this.f1290b[(i12 * i10) + i11 + i13];
                }
                this.f1289a[i12] = (float) (d7 / i10);
            }
        }

        @Override // C0.x.b
        public int e(int i7, int i8, int i9) {
            return s(this.f1290b, i7, i8, i9);
        }

        @Override // C0.x.b
        public void f() {
            this.f1295g = this.f1293e;
        }

        @Override // C0.x.b
        public void flush() {
            this.f1295g = 0.0d;
            this.f1293e = 0.0d;
            this.f1294f = 0.0d;
        }

        @Override // C0.x.b
        public void i(int i7) {
            this.f1291c = r(this.f1291c, x.this.f1282k, i7);
        }

        @Override // C0.x.b
        public boolean j() {
            if (this.f1293e == 0.0d || x.this.f1287p == 0) {
                return false;
            }
            double d7 = this.f1294f;
            double d8 = this.f1293e;
            return d7 <= d8 * 3.0d && d8 * 2.0d > this.f1295g * 3.0d;
        }

        @Override // C0.x.b
        public void l(int i7, int i8, int i9, int i10, int i11) {
            float[] fArr = this.f1291c;
            float[] fArr2 = this.f1290b;
            x(i7, i8, fArr, i9, fArr2, i10, fArr2, i11);
        }

        @Override // C0.x.b
        public void m(ByteBuffer byteBuffer, int i7) {
            byteBuffer.asFloatBuffer().get(this.f1290b, x.this.f1281j * x.this.f1273b, i7 / o());
            byteBuffer.position(byteBuffer.position() + i7);
        }

        @Override // C0.x.b
        public void n(int i7) {
            this.f1292d = r(this.f1292d, x.this.f1283l, i7);
        }

        @Override // C0.x.b
        public int o() {
            return 4;
        }

        @Override // C0.x.b
        public void p(int i7) {
            this.f1290b = r(this.f1290b, x.this.f1281j, i7);
        }

        @Override // C0.x.b
        public void q(ByteBuffer byteBuffer, int i7) {
            byteBuffer.asFloatBuffer().put(this.f1291c, 0, x.this.f1273b * i7);
            byteBuffer.position(byteBuffer.position() + (i7 * o() * x.this.f1273b));
        }

        public final float[] r(float[] fArr, int i7, int i8) {
            int length = fArr.length / x.this.f1273b;
            return i7 + i8 <= length ? fArr : Arrays.copyOf(fArr, (((length * 3) / 2) + i8) * x.this.f1273b);
        }

        public final int s(float[] fArr, int i7, int i8, int i9) {
            int i10 = x.this.f1273b * i7;
            double d7 = 1.0d;
            int i11 = 0;
            double d8 = 0.0d;
            int i12 = 255;
            int i13 = i8;
            while (i13 <= i9) {
                double dAbs = 0.0d;
                for (int i14 = 0; i14 < i13; i14++) {
                    dAbs += Math.abs(fArr[i10 + i14] - fArr[(i10 + i13) + i14]);
                }
                int i15 = i10;
                double d9 = i13;
                if (i11 * dAbs < d7 * d9) {
                    i11 = i13;
                    d7 = dAbs;
                }
                if (i12 * dAbs > d9 * d8) {
                    i12 = i13;
                    d8 = dAbs;
                }
                i13++;
                i10 = i15;
            }
            this.f1293e = d7 / i11;
            this.f1294f = d8 / i12;
            return i11;
        }

        @Override // C0.x.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public float[] g() {
            return this.f1290b;
        }

        @Override // C0.x.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public float[] h() {
            return this.f1291c;
        }

        @Override // C0.x.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public float[] k() {
            return this.f1292d;
        }

        public final float w(float[] fArr, int i7, long j7, long j8) {
            long j9 = (x.this.f1284m + 1) * j8;
            long j10 = j9 - (x.this.f1285n * j7);
            return ((j10 * fArr[i7]) + ((r3 - j10) * fArr[i7 + x.this.f1273b])) / (j9 - (x.this.f1284m * j8));
        }

        public final void x(int i7, int i8, float[] fArr, int i9, float[] fArr2, int i10, float[] fArr3, int i11) {
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = (i9 * i8) + i12;
                int i14 = (i11 * i8) + i12;
                int i15 = (i10 * i8) + i12;
                for (int i16 = 0; i16 < i7; i16++) {
                    fArr[i13] = ((fArr2[i15] * (i7 - i16)) + (fArr3[i14] * i16)) / i7;
                    i13 += i8;
                    i15 += i8;
                    i14 += i8;
                }
            }
        }
    }

    public interface b {
        int a(int i7, int i8, int i9);

        void b(int i7, long j7, long j8);

        void c(int i7, int i8);

        void d(int i7, int i8);

        int e(int i7, int i8, int i9);

        void f();

        void flush();

        Object g();

        Object h();

        void i(int i7);

        boolean j();

        Object k();

        void l(int i7, int i8, int i9, int i10, int i11);

        void m(ByteBuffer byteBuffer, int i7);

        void n(int i7);

        int o();

        void p(int i7);

        void q(ByteBuffer byteBuffer, int i7);
    }

    public final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final short[] f1297a;

        /* renamed from: b, reason: collision with root package name */
        public short[] f1298b;

        /* renamed from: c, reason: collision with root package name */
        public short[] f1299c;

        /* renamed from: d, reason: collision with root package name */
        public short[] f1300d;

        /* renamed from: e, reason: collision with root package name */
        public int f1301e;

        /* renamed from: f, reason: collision with root package name */
        public int f1302f;

        /* renamed from: g, reason: collision with root package name */
        public int f1303g;

        public c() {
            this.f1297a = new short[x.this.f1279h];
            this.f1298b = new short[x.this.f1279h * x.this.f1273b];
            this.f1299c = new short[x.this.f1279h * x.this.f1273b];
            this.f1300d = new short[x.this.f1279h * x.this.f1273b];
        }

        @Override // C0.x.b
        public int a(int i7, int i8, int i9) {
            return s(this.f1297a, i7, i8, i9);
        }

        @Override // C0.x.b
        public void b(int i7, long j7, long j8) {
            int i8 = 0;
            while (i8 < x.this.f1273b) {
                long j9 = j7;
                this.f1299c[(x.this.f1282k * x.this.f1273b) + i8] = w(this.f1300d, (x.this.f1273b * i7) + i8, j9, j8);
                i8++;
                j7 = j9;
            }
        }

        @Override // C0.x.b
        public void c(int i7, int i8) {
            for (int i9 = 0; i9 < x.this.f1273b * i8; i9++) {
                this.f1298b[i7 + i9] = 0;
            }
        }

        @Override // C0.x.b
        public void d(int i7, int i8) {
            short[] sArr = this.f1298b;
            int i9 = x.this.f1279h / i8;
            int i10 = x.this.f1273b * i8;
            int i11 = i7 * x.this.f1273b;
            for (int i12 = 0; i12 < i9; i12++) {
                int i13 = 0;
                for (int i14 = 0; i14 < i10; i14++) {
                    i13 += sArr[(i12 * i10) + i11 + i14];
                }
                this.f1297a[i12] = (short) (i13 / i10);
            }
        }

        @Override // C0.x.b
        public int e(int i7, int i8, int i9) {
            return s(this.f1298b, i7, i8, i9);
        }

        @Override // C0.x.b
        public void f() {
            this.f1303g = this.f1301e;
        }

        @Override // C0.x.b
        public void flush() {
            this.f1303g = 0;
            this.f1301e = 0;
            this.f1302f = 0;
        }

        @Override // C0.x.b
        public void i(int i7) {
            this.f1299c = r(this.f1299c, x.this.f1282k, i7);
        }

        @Override // C0.x.b
        public boolean j() {
            if (this.f1301e == 0 || x.this.f1287p == 0) {
                return false;
            }
            int i7 = this.f1302f;
            int i8 = this.f1301e;
            return i7 <= i8 * 3 && i8 * 2 > this.f1303g * 3;
        }

        @Override // C0.x.b
        public void l(int i7, int i8, int i9, int i10, int i11) {
            short[] sArr = this.f1299c;
            short[] sArr2 = this.f1298b;
            x(i7, i8, sArr, i9, sArr2, i10, sArr2, i11);
        }

        @Override // C0.x.b
        public void m(ByteBuffer byteBuffer, int i7) {
            byteBuffer.asShortBuffer().get(this.f1298b, x.this.f1281j * x.this.f1273b, i7 / 2);
            byteBuffer.position(byteBuffer.position() + i7);
        }

        @Override // C0.x.b
        public void n(int i7) {
            this.f1300d = r(this.f1300d, x.this.f1283l, i7);
        }

        @Override // C0.x.b
        public int o() {
            return 2;
        }

        @Override // C0.x.b
        public void p(int i7) {
            this.f1298b = r(this.f1298b, x.this.f1281j, i7);
        }

        @Override // C0.x.b
        public void q(ByteBuffer byteBuffer, int i7) {
            byteBuffer.asShortBuffer().put(this.f1299c, 0, x.this.f1273b * i7);
            byteBuffer.position(byteBuffer.position() + (i7 * o() * x.this.f1273b));
        }

        public final short[] r(short[] sArr, int i7, int i8) {
            int length = sArr.length / x.this.f1273b;
            return i7 + i8 <= length ? sArr : Arrays.copyOf(sArr, (((length * 3) / 2) + i8) * x.this.f1273b);
        }

        public final int s(short[] sArr, int i7, int i8, int i9) {
            int i10 = i7 * x.this.f1273b;
            int i11 = 255;
            int i12 = 1;
            int i13 = 0;
            int i14 = 0;
            while (i8 <= i9) {
                int iAbs = 0;
                for (int i15 = 0; i15 < i8; i15++) {
                    iAbs += Math.abs(sArr[i10 + i15] - sArr[(i10 + i8) + i15]);
                }
                if (iAbs * i13 < i12 * i8) {
                    i13 = i8;
                    i12 = iAbs;
                }
                if (iAbs * i11 > i14 * i8) {
                    i11 = i8;
                    i14 = iAbs;
                }
                i8++;
            }
            this.f1301e = i12 / i13;
            this.f1302f = i14 / i11;
            return i13;
        }

        @Override // C0.x.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public short[] g() {
            return this.f1298b;
        }

        @Override // C0.x.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public short[] h() {
            return this.f1299c;
        }

        @Override // C0.x.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public short[] k() {
            return this.f1300d;
        }

        public final short w(short[] sArr, int i7, long j7, long j8) {
            short s7 = sArr[i7];
            short s8 = sArr[i7 + x.this.f1273b];
            long j9 = (x.this.f1284m + 1) * j8;
            long j10 = j9 - (x.this.f1285n * j7);
            long j11 = j9 - (x.this.f1284m * j8);
            return (short) (((s7 * j10) + ((j11 - j10) * s8)) / j11);
        }

        public final void x(int i7, int i8, short[] sArr, int i9, short[] sArr2, int i10, short[] sArr3, int i11) {
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = (i9 * i8) + i12;
                int i14 = (i11 * i8) + i12;
                int i15 = (i10 * i8) + i12;
                for (int i16 = 0; i16 < i7; i16++) {
                    sArr[i13] = (short) (((sArr2[i15] * (i7 - i16)) + (sArr3[i14] * i16)) / i7);
                    i13 += i8;
                    i15 += i8;
                    i14 += i8;
                }
            }
        }
    }

    public x(int i7, int i8, float f7, float f8, int i9, boolean z7) {
        this.f1272a = i7;
        this.f1273b = i8;
        this.f1274c = f7;
        this.f1275d = f8;
        this.f1276e = i7 / i9;
        this.f1277f = i7 / 400;
        int i10 = i7 / 65;
        this.f1278g = i10;
        this.f1279h = i10 * 2;
        this.f1280i = z7 ? new a() : new c();
    }

    public final void i(float f7, int i7) {
        int i8;
        int i9;
        if (this.f1282k == i7) {
            return;
        }
        int i10 = this.f1272a;
        long j7 = (long) (i10 / f7);
        long j8 = i10;
        while (j7 != 0 && j8 != 0 && j7 % 2 == 0 && j8 % 2 == 0) {
            j7 /= 2;
            j8 /= 2;
        }
        s(i7);
        int i11 = 0;
        while (true) {
            int i12 = this.f1283l;
            if (i11 >= i12 - 1) {
                w(i12 - 1);
                return;
            }
            while (true) {
                i8 = this.f1284m;
                long j9 = (i8 + 1) * j7;
                i9 = this.f1285n;
                if (j9 <= i9 * j8) {
                    break;
                }
                this.f1280i.i(1);
                this.f1280i.b(i11, j8, j7);
                this.f1285n++;
                this.f1282k++;
            }
            int i13 = i8 + 1;
            this.f1284m = i13;
            if (i13 == j8) {
                this.f1284m = 0;
                j3.o.v(((long) i9) == j7);
                this.f1285n = 0;
            }
            i11++;
        }
    }

    public final void j(double d7) {
        int iY;
        int i7 = this.f1281j;
        if (i7 < this.f1279h) {
            return;
        }
        int i8 = 0;
        do {
            if (this.f1286o > 0) {
                iY = k(i8);
            } else {
                int iM = m(i8);
                iY = d7 > 1.0d ? iM + y(i8, d7, iM) : r(i8, d7, iM);
            }
            i8 += iY;
        } while (this.f1279h + i8 <= i7);
        x(i8);
    }

    public final int k(int i7) {
        int iMin = Math.min(this.f1279h, this.f1286o);
        l(i7, iMin);
        this.f1286o -= iMin;
        return iMin;
    }

    public final void l(int i7, int i8) {
        this.f1280i.i(i8);
        Object objG = this.f1280i.g();
        int i9 = i7 * this.f1273b;
        Object objH = this.f1280i.h();
        int i10 = this.f1282k;
        int i11 = this.f1273b;
        System.arraycopy(objG, i9, objH, i10 * i11, i11 * i8);
        this.f1282k += i8;
    }

    public final int m(int i7) {
        int iA;
        int i8 = this.f1272a;
        int i9 = i8 > 4000 ? i8 / 4000 : 1;
        if (this.f1273b == 1 && i9 == 1) {
            iA = this.f1280i.e(i7, this.f1277f, this.f1278g);
        } else {
            this.f1280i.d(i7, i9);
            int iA2 = this.f1280i.a(0, this.f1277f / i9, this.f1278g / i9);
            if (i9 != 1) {
                int i10 = iA2 * i9;
                int i11 = i9 * 4;
                int i12 = i10 - i11;
                int i13 = i10 + i11;
                int i14 = this.f1277f;
                if (i12 < i14) {
                    i12 = i14;
                }
                int i15 = this.f1278g;
                if (i13 > i15) {
                    i13 = i15;
                }
                if (this.f1273b == 1) {
                    iA = this.f1280i.e(i7, i12, i13);
                } else {
                    this.f1280i.d(i7, 1);
                    iA = this.f1280i.a(0, i12, i13);
                }
            } else {
                iA = iA2;
            }
        }
        int i16 = this.f1280i.j() ? this.f1287p : iA;
        this.f1280i.f();
        this.f1287p = iA;
        return i16;
    }

    public void n() {
        this.f1281j = 0;
        this.f1282k = 0;
        this.f1283l = 0;
        this.f1284m = 0;
        this.f1285n = 0;
        this.f1286o = 0;
        this.f1287p = 0;
        this.f1288q = 0.0d;
        this.f1280i.flush();
    }

    public void o(ByteBuffer byteBuffer) {
        j3.o.v(this.f1282k >= 0);
        int iMin = Math.min(byteBuffer.remaining() / (this.f1273b * this.f1280i.o()), this.f1282k);
        this.f1280i.q(byteBuffer, iMin);
        this.f1282k -= iMin;
        System.arraycopy(this.f1280i.h(), iMin * this.f1273b, this.f1280i.h(), 0, this.f1282k * this.f1273b);
    }

    public int p() {
        j3.o.v(this.f1282k >= 0);
        return this.f1282k * this.f1273b * this.f1280i.o();
    }

    public int q() {
        return this.f1281j * this.f1273b * this.f1280i.o();
    }

    public final int r(int i7, double d7, int i8) {
        int i9;
        if (d7 < 0.5d) {
            double d8 = ((i8 * d7) / (1.0d - d7)) + this.f1288q;
            int iRound = (int) Math.round(d8);
            this.f1288q = d8 - iRound;
            i9 = iRound;
        } else {
            double d9 = ((i8 * ((2.0d * d7) - 1.0d)) / (1.0d - d7)) + this.f1288q;
            int iRound2 = (int) Math.round(d9);
            this.f1286o = iRound2;
            this.f1288q = d9 - iRound2;
            i9 = i8;
        }
        int i10 = i8 + i9;
        this.f1280i.i(i10);
        Object objG = this.f1280i.g();
        int i11 = this.f1273b * i7;
        Object objH = this.f1280i.h();
        int i12 = this.f1282k;
        int i13 = this.f1273b;
        System.arraycopy(objG, i11, objH, i12 * i13, i13 * i8);
        this.f1280i.l(i9, this.f1273b, this.f1282k + i8, i7 + i8, i7);
        this.f1282k += i10;
        return i9;
    }

    public final void s(int i7) {
        int i8 = this.f1282k - i7;
        this.f1280i.n(i8);
        Object objH = this.f1280i.h();
        int i9 = this.f1273b * i7;
        Object objK = this.f1280i.k();
        int i10 = this.f1283l;
        int i11 = this.f1273b;
        System.arraycopy(objH, i9, objK, i10 * i11, i11 * i8);
        this.f1282k = i7;
        this.f1283l += i8;
    }

    public final void t() {
        int i7 = this.f1282k;
        float f7 = this.f1274c;
        float f8 = this.f1275d;
        double d7 = f7 / f8;
        float f9 = this.f1276e * f8;
        if (d7 > 1.0000100135803223d || d7 < 0.9999899864196777d) {
            j(d7);
        } else {
            l(0, this.f1281j);
            this.f1281j = 0;
        }
        if (f9 != 1.0f) {
            i(f9, i7);
        }
    }

    public void u() {
        int i7 = this.f1281j;
        float f7 = this.f1274c;
        float f8 = this.f1275d;
        double d7 = f7 / f8;
        int i8 = this.f1282k + ((int) (((((((i7 - r5) / d7) + this.f1286o) + this.f1288q) + this.f1283l) / (this.f1276e * f8)) + 0.5d));
        this.f1288q = 0.0d;
        this.f1280i.p((this.f1279h * 2) + i7);
        this.f1280i.c(i7 * this.f1273b, this.f1279h * 2);
        this.f1281j += this.f1279h * 2;
        t();
        if (this.f1282k > i8) {
            this.f1282k = Math.max(i8, 0);
        }
        this.f1281j = 0;
        this.f1286o = 0;
        this.f1283l = 0;
    }

    public void v(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        int iO = iRemaining / (this.f1273b * this.f1280i.o());
        this.f1280i.p(iO);
        this.f1280i.m(byteBuffer, iRemaining);
        this.f1281j += iO;
        t();
    }

    public final void w(int i7) {
        if (i7 == 0) {
            return;
        }
        System.arraycopy(this.f1280i.k(), this.f1273b * i7, this.f1280i.k(), 0, (this.f1283l - i7) * this.f1273b);
        this.f1283l -= i7;
    }

    public final void x(int i7) {
        int i8 = this.f1281j - i7;
        System.arraycopy(this.f1280i.g(), i7 * this.f1273b, this.f1280i.g(), 0, this.f1273b * i8);
        this.f1281j = i8;
    }

    public final int y(int i7, double d7, int i8) {
        int i9;
        if (d7 >= 2.0d) {
            double d8 = (i8 / (d7 - 1.0d)) + this.f1288q;
            int iRound = (int) Math.round(d8);
            this.f1288q = d8 - iRound;
            i9 = iRound;
        } else {
            double d9 = ((i8 * (2.0d - d7)) / (d7 - 1.0d)) + this.f1288q;
            int iRound2 = (int) Math.round(d9);
            this.f1286o = iRound2;
            this.f1288q = d9 - iRound2;
            i9 = i8;
        }
        this.f1280i.i(i9);
        this.f1280i.l(i9, this.f1273b, this.f1282k, i7, i7 + i8);
        this.f1282k += i9;
        return i9;
    }
}
