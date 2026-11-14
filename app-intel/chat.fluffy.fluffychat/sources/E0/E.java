package E0;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.AbstractC1257B;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f2023d = {'\r', '\n'};

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f2024e = {'\n'};

    /* renamed from: f, reason: collision with root package name */
    public static final AbstractC1257B f2025f = AbstractC1257B.y(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f2026g = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2027a;

    /* renamed from: b, reason: collision with root package name */
    public int f2028b;

    /* renamed from: c, reason: collision with root package name */
    public int f2029c;

    public E() {
        this.f2027a = U.f2098f;
    }

    public static int c(int i7, int i8, int i9, int i10) {
        byte b7 = (byte) i9;
        return o3.g.i((byte) 0, o3.j.a(((i7 & 7) << 2) | ((i8 & 48) >> 4)), o3.j.a(((((byte) i8) & 15) << 4) | ((b7 & 60) >> 2)), o3.j.a(((b7 & 3) << 6) | (((byte) i10) & 63)));
    }

    public static int h(Charset charset) {
        j3.o.k(f2025f.contains(charset), "Unsupported charset: %s", charset);
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    public static boolean i(byte b7) {
        return (b7 & 192) == 128;
    }

    public int A() {
        k(3);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = ((bArr[i7] & 255) << 24) >> 8;
        int i10 = i7 + 2;
        this.f2028b = i10;
        int i11 = ((bArr[i8] & 255) << 8) | i9;
        this.f2028b = i7 + 3;
        return (bArr[i10] & 255) | i11;
    }

    public String B() {
        return C(StandardCharsets.UTF_8);
    }

    public String C(Charset charset) {
        j3.o.k(f2025f.contains(charset), "Unsupported charset: %s", charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(StandardCharsets.US_ASCII)) {
            a0();
        }
        String strO = O(e(charset) - this.f2028b, charset);
        if (this.f2028b == this.f2029c) {
            return strO;
        }
        i0(charset);
        return strO;
    }

    public int D() {
        k(4);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = bArr[i7] & 255;
        int i10 = i7 + 2;
        this.f2028b = i10;
        int i11 = ((bArr[i8] & 255) << 8) | i9;
        int i12 = i7 + 3;
        this.f2028b = i12;
        int i13 = i11 | ((bArr[i10] & 255) << 16);
        this.f2028b = i7 + 4;
        return ((bArr[i12] & 255) << 24) | i13;
    }

    public long E() {
        k(8);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        this.f2028b = i7 + 1;
        this.f2028b = i7 + 2;
        this.f2028b = i7 + 3;
        long j7 = (bArr[i7] & 255) | ((bArr[r3] & 255) << 8) | ((bArr[r8] & 255) << 16);
        this.f2028b = i7 + 4;
        long j8 = j7 | ((bArr[r5] & 255) << 24);
        this.f2028b = i7 + 5;
        long j9 = j8 | ((bArr[r8] & 255) << 32);
        this.f2028b = i7 + 6;
        long j10 = j9 | ((bArr[r5] & 255) << 40);
        this.f2028b = i7 + 7;
        long j11 = j10 | ((bArr[r8] & 255) << 48);
        this.f2028b = i7 + 8;
        return ((bArr[r5] & 255) << 56) | j11;
    }

    public short F() {
        k(2);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = bArr[i7] & 255;
        this.f2028b = i7 + 2;
        return (short) (((bArr[i8] & 255) << 8) | i9);
    }

    public long G() {
        k(4);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        this.f2028b = i7 + 1;
        this.f2028b = i7 + 2;
        this.f2028b = i7 + 3;
        long j7 = (bArr[i7] & 255) | ((bArr[r3] & 255) << 8) | ((bArr[r8] & 255) << 16);
        this.f2028b = i7 + 4;
        return ((bArr[r5] & 255) << 24) | j7;
    }

    public int H() {
        int iD = D();
        if (iD >= 0) {
            return iD;
        }
        throw new IllegalStateException("Top bit not zero: " + iD);
    }

    public int I() {
        k(2);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = bArr[i7] & 255;
        this.f2028b = i7 + 2;
        return ((bArr[i8] & 255) << 8) | i9;
    }

    public long J() {
        k(8);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        this.f2028b = i7 + 1;
        this.f2028b = i7 + 2;
        this.f2028b = i7 + 3;
        long j7 = ((bArr[i7] & 255) << 56) | ((bArr[r3] & 255) << 48) | ((bArr[r8] & 255) << 40);
        this.f2028b = i7 + 4;
        long j8 = j7 | ((bArr[r5] & 255) << 32);
        this.f2028b = i7 + 5;
        long j9 = j8 | ((bArr[r8] & 255) << 24);
        this.f2028b = i7 + 6;
        long j10 = j9 | ((bArr[r5] & 255) << 16);
        this.f2028b = i7 + 7;
        long j11 = j10 | ((bArr[r8] & 255) << 8);
        this.f2028b = i7 + 8;
        return (bArr[r5] & 255) | j11;
    }

    public String K() {
        return w((char) 0);
    }

    public String L(int i7) {
        k(i7);
        if (i7 == 0) {
            return "";
        }
        int i8 = this.f2028b;
        int i9 = (i8 + i7) - 1;
        String strI = U.I(this.f2027a, i8, (i9 >= this.f2029c || this.f2027a[i9] != 0) ? i7 : i7 - 1);
        this.f2028b += i7;
        return strI;
    }

    public short M() {
        k(2);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = (bArr[i7] & 255) << 8;
        this.f2028b = i7 + 2;
        return (short) ((bArr[i8] & 255) | i9);
    }

    public String N(int i7) {
        return O(i7, StandardCharsets.UTF_8);
    }

    public String O(int i7, Charset charset) {
        k(i7);
        String str = new String(this.f2027a, this.f2028b, i7, charset);
        this.f2028b += i7;
        return str;
    }

    public int P() {
        return (Q() << 21) | (Q() << 14) | (Q() << 7) | Q();
    }

    public int Q() {
        k(1);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        this.f2028b = i7 + 1;
        return bArr[i7] & 255;
    }

    public int R() {
        k(4);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = (bArr[i7] & 255) << 8;
        this.f2028b = i7 + 2;
        int i10 = (bArr[i8] & 255) | i9;
        this.f2028b = i7 + 4;
        return i10;
    }

    public long S() {
        k(4);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        this.f2028b = i7 + 1;
        this.f2028b = i7 + 2;
        this.f2028b = i7 + 3;
        long j7 = ((bArr[i7] & 255) << 24) | ((bArr[r3] & 255) << 16) | ((bArr[r8] & 255) << 8);
        this.f2028b = i7 + 4;
        return (bArr[r5] & 255) | j7;
    }

    public int T() {
        k(3);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = (bArr[i7] & 255) << 16;
        int i10 = i7 + 2;
        this.f2028b = i10;
        int i11 = ((bArr[i8] & 255) << 8) | i9;
        this.f2028b = i7 + 3;
        return (bArr[i10] & 255) | i11;
    }

    public int U() {
        int iZ = z();
        if (iZ >= 0) {
            return iZ;
        }
        throw new IllegalStateException("Top bit not zero: " + iZ);
    }

    public int V() {
        return o3.g.e(W());
    }

    public long W() {
        long j7 = 0;
        for (int i7 = 0; i7 < 9; i7++) {
            if (this.f2028b == this.f2029c) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long jQ = Q();
            j7 |= (127 & jQ) << (i7 * 7);
            if ((jQ & 128) == 0) {
                return j7;
            }
        }
        return j7;
    }

    public long X() {
        long J6 = J();
        if (J6 >= 0) {
            return J6;
        }
        throw new IllegalStateException("Top bit not zero: " + J6);
    }

    public int Y() {
        k(2);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = (bArr[i7] & 255) << 8;
        this.f2028b = i7 + 2;
        return (bArr[i8] & 255) | i9;
    }

    public long Z() {
        int i7;
        k(1);
        long j7 = this.f2027a[this.f2028b];
        int i8 = 7;
        while (true) {
            if (i8 < 0) {
                break;
            }
            if (((1 << i8) & j7) != 0) {
                i8--;
            } else if (i8 < 6) {
                j7 &= r6 - 1;
                i7 = 7 - i8;
            } else if (i8 == 7) {
                i7 = 1;
            }
        }
        i7 = 0;
        if (i7 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j7);
        }
        k(i7);
        for (int i9 = 1; i9 < i7; i9++) {
            if ((this.f2027a[this.f2028b + i9] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j7);
            }
            j7 = (j7 << 6) | (r4 & 63);
        }
        this.f2028b += i7;
        return j7;
    }

    public int a() {
        return Math.max(this.f2029c - this.f2028b, 0);
    }

    public Charset a0() {
        if (a() >= 3) {
            byte[] bArr = this.f2027a;
            int i7 = this.f2028b;
            if (bArr[i7] == -17 && bArr[i7 + 1] == -69 && bArr[i7 + 2] == -65) {
                this.f2028b = i7 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f2027a;
        int i8 = this.f2028b;
        byte b7 = bArr2[i8];
        if (b7 == -2 && bArr2[i8 + 1] == -1) {
            this.f2028b = i8 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b7 != -1 || bArr2[i8 + 1] != -2) {
            return null;
        }
        this.f2028b = i8 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public int b() {
        return this.f2027a.length;
    }

    public void b0(int i7) {
        d0(b() < i7 ? new byte[i7] : this.f2027a, i7);
    }

    public void c0(byte[] bArr) {
        d0(bArr, bArr.length);
    }

    public void d(int i7) {
        if (i7 > b()) {
            this.f2027a = Arrays.copyOf(this.f2027a, i7);
        }
    }

    public void d0(byte[] bArr, int i7) {
        this.f2027a = bArr;
        this.f2029c = i7;
        this.f2028b = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(java.nio.charset.Charset r5) {
        /*
            r4 = this;
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L43
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L11
            goto L43
        L11:
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L41
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L41
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L2a
            goto L41
        L2a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported charset: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L41:
            r0 = 2
            goto L44
        L43:
            r0 = 1
        L44:
            int r1 = r4.f2028b
        L46:
            int r2 = r4.f2029c
            int r3 = r0 + (-1)
            int r3 = r2 - r3
            if (r1 >= r3) goto La5
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L5e
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L69
        L5e:
            byte[] r2 = r4.f2027a
            r2 = r2[r1]
            boolean r2 = E0.U.G0(r2)
            if (r2 == 0) goto L69
            goto La2
        L69:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L79
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L8a
        L79:
            byte[] r2 = r4.f2027a
            r3 = r2[r1]
            if (r3 != 0) goto L8a
            int r3 = r1 + 1
            r2 = r2[r3]
            boolean r2 = E0.U.G0(r2)
            if (r2 == 0) goto L8a
            goto La2
        L8a:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto La3
            byte[] r2 = r4.f2027a
            int r3 = r1 + 1
            r3 = r2[r3]
            if (r3 != 0) goto La3
            r2 = r2[r1]
            boolean r2 = E0.U.G0(r2)
            if (r2 == 0) goto La3
        La2:
            return r1
        La3:
            int r1 = r1 + r0
            goto L46
        La5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: E0.E.e(java.nio.charset.Charset):int");
    }

    public void e0(int i7) {
        j3.o.d(i7 >= 0 && i7 <= this.f2027a.length);
        this.f2029c = i7;
    }

    public byte[] f() {
        return this.f2027a;
    }

    public void f0(int i7) {
        j3.o.d(i7 >= 0 && i7 <= this.f2029c);
        this.f2028b = i7;
    }

    public int g() {
        return this.f2028b;
    }

    public void g0(int i7) {
        f0(this.f2028b + i7);
    }

    public void h0() {
        while ((Q() & 128) != 0) {
        }
    }

    public final void i0(Charset charset) {
        if (v(charset, f2023d) == '\r') {
            v(charset, f2024e);
        }
    }

    public int j() {
        return this.f2029c;
    }

    public final void k(int i7) {
        if (!f2026g.get() || a() >= i7) {
            return;
        }
        throw new IndexOutOfBoundsException("bytesNeeded= " + i7 + ", bytesLeft=" + a());
    }

    public char l() {
        return m(ByteOrder.BIG_ENDIAN, 0);
    }

    public final char m(ByteOrder byteOrder, int i7) {
        k(2);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f2027a;
            int i8 = this.f2028b;
            return o3.c.c(bArr[i8 + i7], bArr[i8 + i7 + 1]);
        }
        byte[] bArr2 = this.f2027a;
        int i9 = this.f2028b;
        return o3.c.c(bArr2[i9 + i7 + 1], bArr2[i9 + i7]);
    }

    public int n(Charset charset) {
        if (o(charset) != 0) {
            return o3.g.e(r3 >>> 8);
        }
        return 1114112;
    }

    public final int o(Charset charset) {
        int codePoint;
        int iB;
        j3.o.k(f2025f.contains(charset), "Unsupported charset: %s", charset);
        if (a() < h(charset)) {
            throw new IndexOutOfBoundsException("position=" + this.f2028b + ", limit=" + this.f2029c);
        }
        byte b7 = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b8 = this.f2027a[this.f2028b];
            if ((b8 & 128) != 0) {
                return 0;
            }
            codePoint = o3.j.b(b8);
        } else if (charset.equals(StandardCharsets.UTF_8)) {
            byte bS = s();
            if (bS == 1) {
                iB = o3.j.b(this.f2027a[this.f2028b]);
            } else if (bS == 2) {
                byte[] bArr = this.f2027a;
                int i7 = this.f2028b;
                iB = c(0, 0, bArr[i7], bArr[i7 + 1]);
            } else if (bS == 3) {
                byte[] bArr2 = this.f2027a;
                int i8 = this.f2028b;
                iB = c(0, bArr2[i8] & 15, bArr2[i8 + 1], bArr2[i8 + 2]);
            } else {
                if (bS != 4) {
                    return 0;
                }
                byte[] bArr3 = this.f2027a;
                int i9 = this.f2028b;
                iB = c(bArr3[i9], bArr3[i9 + 1], bArr3[i9 + 2], bArr3[i9 + 3]);
            }
            b7 = bS;
            codePoint = iB;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char cM = m(byteOrder, 0);
            if (!Character.isHighSurrogate(cM) || a() < 4) {
                codePoint = cM;
                b7 = 2;
            } else {
                codePoint = Character.toCodePoint(cM, m(byteOrder, 2));
                b7 = 4;
            }
        }
        return (codePoint << 8) | b7;
    }

    public int p() {
        if (a() >= 4) {
            int iZ = z();
            this.f2028b -= 4;
            return iZ;
        }
        throw new IndexOutOfBoundsException("position=" + this.f2028b + ", limit=" + this.f2029c);
    }

    public int q() {
        k(1);
        return this.f2027a[this.f2028b] & 255;
    }

    public int r() {
        if (a() >= 3) {
            int iT = T();
            this.f2028b -= 3;
            return iT;
        }
        throw new IndexOutOfBoundsException("position=" + this.f2028b + ", limit=" + this.f2029c);
    }

    public final byte s() {
        byte b7 = this.f2027a[this.f2028b];
        if ((b7 & 128) == 0) {
            return (byte) 1;
        }
        if ((b7 & 224) == 192 && a() >= 2 && i(this.f2027a[this.f2028b + 1])) {
            return (byte) 2;
        }
        if ((this.f2027a[this.f2028b] & 240) == 224 && a() >= 3 && i(this.f2027a[this.f2028b + 1]) && i(this.f2027a[this.f2028b + 2])) {
            return (byte) 3;
        }
        return ((this.f2027a[this.f2028b] & 248) == 240 && a() >= 4 && i(this.f2027a[this.f2028b + 1]) && i(this.f2027a[this.f2028b + 2]) && i(this.f2027a[this.f2028b + 3])) ? (byte) 4 : (byte) 0;
    }

    public void t(D d7, int i7) {
        u(d7.f2019a, 0, i7);
        d7.p(0);
    }

    public void u(byte[] bArr, int i7, int i8) {
        k(i8);
        System.arraycopy(this.f2027a, this.f2028b, bArr, i7, i8);
        this.f2028b += i8;
    }

    public final char v(Charset charset, char[] cArr) {
        int iO;
        if (a() < h(charset) || (iO = o(charset)) == 0) {
            return (char) 0;
        }
        int iA = o3.k.a(iO >>> 8);
        if (Character.isSupplementaryCodePoint(iA)) {
            return (char) 0;
        }
        char cA = o3.c.a(iA);
        if (!o3.c.b(cArr, cA)) {
            return (char) 0;
        }
        this.f2028b += o3.g.e(iO & 255);
        return cA;
    }

    public String w(char c7) {
        if (a() == 0) {
            return null;
        }
        int i7 = this.f2028b;
        while (i7 < this.f2029c && this.f2027a[i7] != c7) {
            i7++;
        }
        byte[] bArr = this.f2027a;
        int i8 = this.f2028b;
        String strI = U.I(bArr, i8, i7 - i8);
        this.f2028b = i7;
        if (i7 < this.f2029c) {
            this.f2028b = i7 + 1;
        }
        return strI;
    }

    public double x() {
        return Double.longBitsToDouble(J());
    }

    public float y() {
        return Float.intBitsToFloat(z());
    }

    public int z() {
        k(4);
        byte[] bArr = this.f2027a;
        int i7 = this.f2028b;
        int i8 = i7 + 1;
        this.f2028b = i8;
        int i9 = (bArr[i7] & 255) << 24;
        int i10 = i7 + 2;
        this.f2028b = i10;
        int i11 = ((bArr[i8] & 255) << 16) | i9;
        int i12 = i7 + 3;
        this.f2028b = i12;
        int i13 = i11 | ((bArr[i10] & 255) << 8);
        this.f2028b = i7 + 4;
        return (bArr[i12] & 255) | i13;
    }

    public E(int i7) {
        this.f2027a = new byte[i7];
        this.f2029c = i7;
    }

    public E(byte[] bArr) {
        this.f2027a = bArr;
        this.f2029c = bArr.length;
    }

    public E(byte[] bArr, int i7) {
        this.f2027a = bArr;
        this.f2029c = i7;
    }
}
