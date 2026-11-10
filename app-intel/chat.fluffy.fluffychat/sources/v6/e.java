package v6;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import z5.C1877k;

/* loaded from: classes3.dex */
public final class e implements g, f, Cloneable, ByteChannel {

    /* renamed from: l, reason: collision with root package name */
    public v f23178l;

    /* renamed from: m, reason: collision with root package name */
    public long f23179m;

    public static final class a implements Closeable {

        /* renamed from: l, reason: collision with root package name */
        public e f23180l;

        /* renamed from: m, reason: collision with root package name */
        public v f23181m;

        /* renamed from: o, reason: collision with root package name */
        public byte[] f23183o;

        /* renamed from: n, reason: collision with root package name */
        public long f23182n = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f23184p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f23185q = -1;

        public final void a(v vVar) {
            this.f23181m = vVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f23180l == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f23180l = null;
            a(null);
            this.f23182n = -1L;
            this.f23183o = null;
            this.f23184p = -1;
            this.f23185q = -1;
        }
    }

    @Override // v6.y
    public void A(e eVar, long j7) {
        v vVar;
        M5.m.e(eVar, "source");
        if (eVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        AbstractC1720b.b(eVar.size(), 0L, j7);
        while (j7 > 0) {
            v vVar2 = eVar.f23178l;
            M5.m.b(vVar2);
            int i7 = vVar2.f23225c;
            M5.m.b(eVar.f23178l);
            if (j7 < i7 - r1.f23224b) {
                v vVar3 = this.f23178l;
                if (vVar3 != null) {
                    M5.m.b(vVar3);
                    vVar = vVar3.f23229g;
                } else {
                    vVar = null;
                }
                if (vVar != null && vVar.f23227e) {
                    if ((vVar.f23225c + j7) - (vVar.f23226d ? 0 : vVar.f23224b) <= 8192) {
                        v vVar4 = eVar.f23178l;
                        M5.m.b(vVar4);
                        vVar4.f(vVar, (int) j7);
                        eVar.J(eVar.size() - j7);
                        J(size() + j7);
                        return;
                    }
                }
                v vVar5 = eVar.f23178l;
                M5.m.b(vVar5);
                eVar.f23178l = vVar5.e((int) j7);
            }
            v vVar6 = eVar.f23178l;
            M5.m.b(vVar6);
            long j8 = vVar6.f23225c - vVar6.f23224b;
            eVar.f23178l = vVar6.b();
            v vVar7 = this.f23178l;
            if (vVar7 == null) {
                this.f23178l = vVar6;
                vVar6.f23229g = vVar6;
                vVar6.f23228f = vVar6;
            } else {
                M5.m.b(vVar7);
                v vVar8 = vVar7.f23229g;
                M5.m.b(vVar8);
                vVar8.c(vVar6).a();
            }
            eVar.J(eVar.size() - j8);
            J(size() + j8);
            j7 -= j8;
        }
    }

    public h B() {
        return h(size());
    }

    public int C() {
        return AbstractC1720b.d(readInt());
    }

    @Override // v6.g
    public String D() {
        return s(Long.MAX_VALUE);
    }

    public short E() {
        return AbstractC1720b.e(readShort());
    }

    public String F(long j7, Charset charset) throws EOFException {
        M5.m.e(charset, "charset");
        if (j7 < 0 || j7 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (this.f23179m < j7) {
            throw new EOFException();
        }
        if (j7 == 0) {
            return "";
        }
        v vVar = this.f23178l;
        M5.m.b(vVar);
        int i7 = vVar.f23224b;
        if (i7 + j7 > vVar.f23225c) {
            return new String(I(j7), charset);
        }
        int i8 = (int) j7;
        String str = new String(vVar.f23223a, i7, i8, charset);
        int i9 = vVar.f23224b + i8;
        vVar.f23224b = i9;
        this.f23179m -= j7;
        if (i9 == vVar.f23225c) {
            this.f23178l = vVar.b();
            w.b(vVar);
        }
        return str;
    }

    public String G() {
        return F(this.f23179m, V5.c.f8852b);
    }

    public String H(long j7) {
        return F(j7, V5.c.f8852b);
    }

    @Override // v6.g
    public byte[] I(long j7) throws EOFException {
        if (j7 < 0 || j7 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (size() < j7) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j7];
        readFully(bArr);
        return bArr;
    }

    public final void J(long j7) {
        this.f23179m = j7;
    }

    public final h K() {
        if (size() <= 2147483647L) {
            return L((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final h L(int i7) {
        if (i7 == 0) {
            return h.f23188p;
        }
        AbstractC1720b.b(size(), 0L, i7);
        v vVar = this.f23178l;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            M5.m.b(vVar);
            int i11 = vVar.f23225c;
            int i12 = vVar.f23224b;
            if (i11 == i12) {
                throw new AssertionError("s.limit == s.pos");
            }
            i9 += i11 - i12;
            i10++;
            vVar = vVar.f23228f;
        }
        byte[][] bArr = new byte[i10][];
        int[] iArr = new int[i10 * 2];
        v vVar2 = this.f23178l;
        int i13 = 0;
        while (i8 < i7) {
            M5.m.b(vVar2);
            bArr[i13] = vVar2.f23223a;
            i8 += vVar2.f23225c - vVar2.f23224b;
            iArr[i13] = Math.min(i8, i7);
            iArr[i13 + i10] = vVar2.f23224b;
            vVar2.f23226d = true;
            i13++;
            vVar2 = vVar2.f23228f;
        }
        return new x(bArr, iArr);
    }

    public final v M(int i7) {
        if (i7 < 1 || i7 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        v vVar = this.f23178l;
        if (vVar != null) {
            M5.m.b(vVar);
            v vVar2 = vVar.f23229g;
            M5.m.b(vVar2);
            return (vVar2.f23225c + i7 > 8192 || !vVar2.f23227e) ? vVar2.c(w.c()) : vVar2;
        }
        v vVarC = w.c();
        this.f23178l = vVarC;
        vVarC.f23229g = vVarC;
        vVarC.f23228f = vVarC;
        return vVarC;
    }

    public e N(h hVar) {
        M5.m.e(hVar, "byteString");
        hVar.D(this, 0, hVar.y());
        return this;
    }

    @Override // v6.g
    public void O(long j7) throws EOFException {
        if (this.f23179m < j7) {
            throw new EOFException();
        }
    }

    @Override // v6.f
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public e write(byte[] bArr) {
        M5.m.e(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @Override // v6.f
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public e write(byte[] bArr, int i7, int i8) {
        M5.m.e(bArr, "source");
        long j7 = i8;
        AbstractC1720b.b(bArr.length, i7, j7);
        int i9 = i8 + i7;
        while (i7 < i9) {
            v vVarM = M(1);
            int iMin = Math.min(i9 - i7, 8192 - vVarM.f23225c);
            int i10 = i7 + iMin;
            C1877k.e(bArr, vVarM.f23223a, vVarM.f23225c, i7, i10);
            vVarM.f23225c += iMin;
            i7 = i10;
        }
        J(size() + j7);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7 A[EDGE_INSN: B:43:0x00a7->B:37:0x00a7 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // v6.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long S() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb1
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            v6.v r6 = r14.f23178l
            M5.m.b(r6)
            byte[] r7 = r6.f23223a
            int r8 = r6.f23224b
            int r9 = r6.f23225c
        L18:
            if (r8 >= r9) goto L93
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3c
        L27:
            r11 = 97
            if (r10 < r11) goto L32
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L32
            int r11 = r10 + (-87)
            goto L3c
        L32:
            r11 = 65
            if (r10 < r11) goto L74
            r11 = 70
            if (r10 > r11) goto L74
            int r11 = r10 + (-55)
        L3c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4c:
            v6.e r0 = new v6.e
            r0.<init>()
            v6.e r0 = r0.w(r4)
            v6.e r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.G()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L74:
            if (r0 == 0) goto L78
            r1 = 1
            goto L93
        L78:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = v6.AbstractC1720b.f(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L93:
            if (r8 != r9) goto L9f
            v6.v r7 = r6.b()
            r14.f23178l = r7
            v6.w.b(r6)
            goto La1
        L9f:
            r6.f23224b = r8
        La1:
            if (r1 != 0) goto La7
            v6.v r6 = r14.f23178l
            if (r6 != 0) goto Ld
        La7:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.J(r1)
            return r4
        Lb1:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.e.S():long");
    }

    @Override // v6.g
    public InputStream T() {
        return new b();
    }

    public long U(A a7) {
        M5.m.e(a7, "source");
        long j7 = 0;
        while (true) {
            long jK = a7.k(this, 8192L);
            if (jK == -1) {
                return j7;
            }
            j7 += jK;
        }
    }

    @Override // v6.f
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public e writeByte(int i7) {
        v vVarM = M(1);
        byte[] bArr = vVarM.f23223a;
        int i8 = vVarM.f23225c;
        vVarM.f23225c = i8 + 1;
        bArr[i8] = (byte) i7;
        J(size() + 1);
        return this;
    }

    @Override // v6.f
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public e Q(long j7) {
        boolean z7;
        if (j7 == 0) {
            return writeByte(48);
        }
        int i7 = 1;
        if (j7 < 0) {
            j7 = -j7;
            if (j7 < 0) {
                return v("-9223372036854775808");
            }
            z7 = true;
        } else {
            z7 = false;
        }
        if (j7 >= 100000000) {
            i7 = j7 < 1000000000000L ? j7 < 10000000000L ? j7 < 1000000000 ? 9 : 10 : j7 < 100000000000L ? 11 : 12 : j7 < 1000000000000000L ? j7 < 10000000000000L ? 13 : j7 < 100000000000000L ? 14 : 15 : j7 < 100000000000000000L ? j7 < 10000000000000000L ? 16 : 17 : j7 < 1000000000000000000L ? 18 : 19;
        } else if (j7 >= 10000) {
            i7 = j7 < 1000000 ? j7 < 100000 ? 5 : 6 : j7 < 10000000 ? 7 : 8;
        } else if (j7 >= 100) {
            i7 = j7 < 1000 ? 3 : 4;
        } else if (j7 >= 10) {
            i7 = 2;
        }
        if (z7) {
            i7++;
        }
        v vVarM = M(i7);
        byte[] bArr = vVarM.f23223a;
        int i8 = vVarM.f23225c + i7;
        while (j7 != 0) {
            long j8 = 10;
            i8--;
            bArr[i8] = w6.a.a()[(int) (j7 % j8)];
            j7 /= j8;
        }
        if (z7) {
            bArr[i8 - 1] = 45;
        }
        vVarM.f23225c += i7;
        J(size() + i7);
        return this;
    }

    @Override // v6.f
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public e w(long j7) {
        if (j7 == 0) {
            return writeByte(48);
        }
        long j8 = (j7 >>> 1) | j7;
        long j9 = j8 | (j8 >>> 2);
        long j10 = j9 | (j9 >>> 4);
        long j11 = j10 | (j10 >>> 8);
        long j12 = j11 | (j11 >>> 16);
        long j13 = j12 | (j12 >>> 32);
        long j14 = j13 - ((j13 >>> 1) & 6148914691236517205L);
        long j15 = ((j14 >>> 2) & 3689348814741910323L) + (j14 & 3689348814741910323L);
        long j16 = ((j15 >>> 4) + j15) & 1085102592571150095L;
        long j17 = j16 + (j16 >>> 8);
        long j18 = j17 + (j17 >>> 16);
        int i7 = (int) ((((j18 & 63) + ((j18 >>> 32) & 63)) + 3) / 4);
        v vVarM = M(i7);
        byte[] bArr = vVarM.f23223a;
        int i8 = vVarM.f23225c;
        for (int i9 = (i8 + i7) - 1; i9 >= i8; i9--) {
            bArr[i9] = w6.a.a()[(int) (15 & j7)];
            j7 >>>= 4;
        }
        vVarM.f23225c += i7;
        J(size() + i7);
        return this;
    }

    @Override // v6.f
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public e writeInt(int i7) {
        v vVarM = M(4);
        byte[] bArr = vVarM.f23223a;
        int i8 = vVarM.f23225c;
        bArr[i8] = (byte) ((i7 >>> 24) & 255);
        bArr[i8 + 1] = (byte) ((i7 >>> 16) & 255);
        bArr[i8 + 2] = (byte) ((i7 >>> 8) & 255);
        bArr[i8 + 3] = (byte) (i7 & 255);
        vVarM.f23225c = i8 + 4;
        J(size() + 4);
        return this;
    }

    @Override // v6.f
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public e writeShort(int i7) {
        v vVarM = M(2);
        byte[] bArr = vVarM.f23223a;
        int i8 = vVarM.f23225c;
        bArr[i8] = (byte) ((i7 >>> 8) & 255);
        bArr[i8 + 1] = (byte) (i7 & 255);
        vVarM.f23225c = i8 + 2;
        J(size() + 2);
        return this;
    }

    public final void a() throws EOFException {
        skip(size());
    }

    public e a0(String str, int i7, int i8, Charset charset) {
        M5.m.e(str, "string");
        M5.m.e(charset, "charset");
        if (i7 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i7).toString());
        }
        if (i8 < i7) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i8 + " < " + i7).toString());
        }
        if (i8 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i8 + " > " + str.length()).toString());
        }
        if (M5.m.a(charset, V5.c.f8852b)) {
            return c0(str, i7, i8);
        }
        String strSubstring = str.substring(i7, i8);
        M5.m.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        M5.m.d(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    @Override // v6.f
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public e v(String str) {
        M5.m.e(str, "string");
        return c0(str, 0, str.length());
    }

    @Override // v6.A
    public B c() {
        return B.f23157e;
    }

    public e c0(String str, int i7, int i8) {
        char cCharAt;
        M5.m.e(str, "string");
        if (i7 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i7).toString());
        }
        if (i8 < i7) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i8 + " < " + i7).toString());
        }
        if (i8 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i8 + " > " + str.length()).toString());
        }
        while (i7 < i8) {
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 < 128) {
                v vVarM = M(1);
                byte[] bArr = vVarM.f23223a;
                int i9 = vVarM.f23225c - i7;
                int iMin = Math.min(i8, 8192 - i9);
                int i10 = i7 + 1;
                bArr[i7 + i9] = (byte) cCharAt2;
                while (true) {
                    i7 = i10;
                    if (i7 >= iMin || (cCharAt = str.charAt(i7)) >= 128) {
                        break;
                    }
                    i10 = i7 + 1;
                    bArr[i7 + i9] = (byte) cCharAt;
                }
                int i11 = vVarM.f23225c;
                int i12 = (i9 + i7) - i11;
                vVarM.f23225c = i11 + i12;
                J(size() + i12);
            } else {
                if (cCharAt2 < 2048) {
                    v vVarM2 = M(2);
                    byte[] bArr2 = vVarM2.f23223a;
                    int i13 = vVarM2.f23225c;
                    bArr2[i13] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i13 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    vVarM2.f23225c = i13 + 2;
                    J(size() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    v vVarM3 = M(3);
                    byte[] bArr3 = vVarM3.f23223a;
                    int i14 = vVarM3.f23225c;
                    bArr3[i14] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i14 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i14 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    vVarM3.f23225c = i14 + 3;
                    J(size() + 3);
                } else {
                    int i15 = i7 + 1;
                    char cCharAt3 = i15 < i8 ? str.charAt(i15) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        i7 = i15;
                    } else {
                        int i16 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        v vVarM4 = M(4);
                        byte[] bArr4 = vVarM4.f23223a;
                        int i17 = vVarM4.f23225c;
                        bArr4[i17] = (byte) ((i16 >> 18) | 240);
                        bArr4[i17 + 1] = (byte) (((i16 >> 12) & 63) | 128);
                        bArr4[i17 + 2] = (byte) (((i16 >> 6) & 63) | 128);
                        bArr4[i17 + 3] = (byte) ((i16 & 63) | 128);
                        vVarM4.f23225c = i17 + 4;
                        J(size() + 4);
                        i7 += 2;
                    }
                }
                i7++;
            }
        }
        return this;
    }

    public e d0(int i7) {
        if (i7 < 128) {
            writeByte(i7);
            return this;
        }
        if (i7 < 2048) {
            v vVarM = M(2);
            byte[] bArr = vVarM.f23223a;
            int i8 = vVarM.f23225c;
            bArr[i8] = (byte) ((i7 >> 6) | 192);
            bArr[i8 + 1] = (byte) ((i7 & 63) | 128);
            vVarM.f23225c = i8 + 2;
            J(size() + 2);
            return this;
        }
        if (55296 <= i7 && i7 < 57344) {
            writeByte(63);
            return this;
        }
        if (i7 < 65536) {
            v vVarM2 = M(3);
            byte[] bArr2 = vVarM2.f23223a;
            int i9 = vVarM2.f23225c;
            bArr2[i9] = (byte) ((i7 >> 12) | 224);
            bArr2[i9 + 1] = (byte) (((i7 >> 6) & 63) | 128);
            bArr2[i9 + 2] = (byte) ((i7 & 63) | 128);
            vVarM2.f23225c = i9 + 3;
            J(size() + 3);
            return this;
        }
        if (i7 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + AbstractC1720b.g(i7));
        }
        v vVarM3 = M(4);
        byte[] bArr3 = vVarM3.f23223a;
        int i10 = vVarM3.f23225c;
        bArr3[i10] = (byte) ((i7 >> 18) | 240);
        bArr3[i10 + 1] = (byte) (((i7 >> 12) & 63) | 128);
        bArr3[i10 + 2] = (byte) (((i7 >> 6) & 63) | 128);
        bArr3[i10 + 3] = (byte) ((i7 & 63) | 128);
        vVarM3.f23225c = i10 + 4;
        J(size() + 4);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (size() != eVar.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        v vVar = this.f23178l;
        M5.m.b(vVar);
        v vVar2 = eVar.f23178l;
        M5.m.b(vVar2);
        int i7 = vVar.f23224b;
        int i8 = vVar2.f23224b;
        long j7 = 0;
        while (j7 < size()) {
            long jMin = Math.min(vVar.f23225c - i7, vVar2.f23225c - i8);
            long j8 = 0;
            while (j8 < jMin) {
                int i9 = i7 + 1;
                int i10 = i8 + 1;
                if (vVar.f23223a[i7] != vVar2.f23223a[i8]) {
                    return false;
                }
                j8++;
                i7 = i9;
                i8 = i10;
            }
            if (i7 == vVar.f23225c) {
                vVar = vVar.f23228f;
                M5.m.b(vVar);
                i7 = vVar.f23224b;
            }
            if (i8 == vVar2.f23225c) {
                vVar2 = vVar2.f23228f;
                M5.m.b(vVar2);
                i8 = vVar2.f23224b;
            }
            j7 += jMin;
        }
        return true;
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return o();
    }

    @Override // v6.g
    public long g(y yVar) {
        M5.m.e(yVar, "sink");
        long size = size();
        if (size > 0) {
            yVar.A(this, size);
        }
        return size;
    }

    @Override // v6.g
    public h h(long j7) throws EOFException {
        if (j7 < 0 || j7 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (size() < j7) {
            throw new EOFException();
        }
        if (j7 < 4096) {
            return new h(I(j7));
        }
        h hVarL = L((int) j7);
        skip(j7);
        return hVarL;
    }

    public int hashCode() {
        v vVar = this.f23178l;
        if (vVar == null) {
            return 0;
        }
        int i7 = 1;
        do {
            int i8 = vVar.f23225c;
            for (int i9 = vVar.f23224b; i9 < i8; i9++) {
                i7 = (i7 * 31) + vVar.f23223a[i9];
            }
            vVar = vVar.f23228f;
            M5.m.b(vVar);
        } while (vVar != this.f23178l);
        return i7;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // v6.A
    public long k(e eVar, long j7) {
        M5.m.e(eVar, "sink");
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j7 > size()) {
            j7 = size();
        }
        eVar.A(this, j7);
        return j7;
    }

    @Override // v6.g
    public boolean m() {
        return this.f23179m == 0;
    }

    public final long n() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        v vVar = this.f23178l;
        M5.m.b(vVar);
        v vVar2 = vVar.f23229g;
        M5.m.b(vVar2);
        return (vVar2.f23225c >= 8192 || !vVar2.f23227e) ? size : size - (r3 - vVar2.f23224b);
    }

    public final e o() {
        e eVar = new e();
        if (size() == 0) {
            return eVar;
        }
        v vVar = this.f23178l;
        M5.m.b(vVar);
        v vVarD = vVar.d();
        eVar.f23178l = vVarD;
        vVarD.f23229g = vVarD;
        vVarD.f23228f = vVarD;
        for (v vVar2 = vVar.f23228f; vVar2 != vVar; vVar2 = vVar2.f23228f) {
            v vVar3 = vVarD.f23229g;
            M5.m.b(vVar3);
            M5.m.b(vVar2);
            vVar3.c(vVar2.d());
        }
        eVar.J(size());
        return eVar;
    }

    @Override // v6.g
    public g peek() {
        return o.d(new s(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r1 = new v6.e().W(r8).V(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r2 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: " + r1.G());
     */
    @Override // v6.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long q() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.e.q():long");
    }

    public final e r(e eVar, long j7, long j8) {
        M5.m.e(eVar, "out");
        long j9 = j7;
        AbstractC1720b.b(size(), j9, j8);
        if (j8 != 0) {
            eVar.J(eVar.size() + j8);
            v vVar = this.f23178l;
            while (true) {
                M5.m.b(vVar);
                int i7 = vVar.f23225c;
                int i8 = vVar.f23224b;
                if (j9 < i7 - i8) {
                    break;
                }
                j9 -= i7 - i8;
                vVar = vVar.f23228f;
            }
            v vVar2 = vVar;
            long j10 = j8;
            while (j10 > 0) {
                M5.m.b(vVar2);
                v vVarD = vVar2.d();
                int i9 = vVarD.f23224b + ((int) j9);
                vVarD.f23224b = i9;
                vVarD.f23225c = Math.min(i9 + ((int) j10), vVarD.f23225c);
                v vVar3 = eVar.f23178l;
                if (vVar3 == null) {
                    vVarD.f23229g = vVarD;
                    vVarD.f23228f = vVarD;
                    eVar.f23178l = vVarD;
                } else {
                    M5.m.b(vVar3);
                    v vVar4 = vVar3.f23229g;
                    M5.m.b(vVar4);
                    vVar4.c(vVarD);
                }
                j10 -= vVarD.f23225c - vVarD.f23224b;
                vVar2 = vVar2.f23228f;
                j9 = 0;
            }
        }
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "sink");
        v vVar = this.f23178l;
        if (vVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), vVar.f23225c - vVar.f23224b);
        byteBuffer.put(vVar.f23223a, vVar.f23224b, iMin);
        int i7 = vVar.f23224b + iMin;
        vVar.f23224b = i7;
        this.f23179m -= iMin;
        if (i7 == vVar.f23225c) {
            this.f23178l = vVar.b();
            w.b(vVar);
        }
        return iMin;
    }

    @Override // v6.g
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        v vVar = this.f23178l;
        M5.m.b(vVar);
        int i7 = vVar.f23224b;
        int i8 = vVar.f23225c;
        int i9 = i7 + 1;
        byte b7 = vVar.f23223a[i7];
        J(size() - 1);
        if (i9 != i8) {
            vVar.f23224b = i9;
            return b7;
        }
        this.f23178l = vVar.b();
        w.b(vVar);
        return b7;
    }

    @Override // v6.g
    public void readFully(byte[] bArr) throws EOFException {
        M5.m.e(bArr, "sink");
        int i7 = 0;
        while (i7 < bArr.length) {
            int i8 = read(bArr, i7, bArr.length - i7);
            if (i8 == -1) {
                throw new EOFException();
            }
            i7 += i8;
        }
    }

    @Override // v6.g
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        v vVar = this.f23178l;
        M5.m.b(vVar);
        int i7 = vVar.f23224b;
        int i8 = vVar.f23225c;
        if (i8 - i7 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = vVar.f23223a;
        int i9 = i7 + 3;
        int i10 = ((bArr[i7 + 1] & 255) << 16) | ((bArr[i7] & 255) << 24) | ((bArr[i7 + 2] & 255) << 8);
        int i11 = i7 + 4;
        int i12 = (bArr[i9] & 255) | i10;
        J(size() - 4);
        if (i11 != i8) {
            vVar.f23224b = i11;
            return i12;
        }
        this.f23178l = vVar.b();
        w.b(vVar);
        return i12;
    }

    @Override // v6.g
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        v vVar = this.f23178l;
        M5.m.b(vVar);
        int i7 = vVar.f23224b;
        int i8 = vVar.f23225c;
        if (i8 - i7 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = vVar.f23223a;
        int i9 = i7 + 1;
        int i10 = (bArr[i7] & 255) << 8;
        int i11 = i7 + 2;
        int i12 = (bArr[i9] & 255) | i10;
        J(size() - 2);
        if (i11 == i8) {
            this.f23178l = vVar.b();
            w.b(vVar);
        } else {
            vVar.f23224b = i11;
        }
        return (short) i12;
    }

    @Override // v6.g
    public String s(long j7) throws EOFException {
        if (j7 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j7).toString());
        }
        long j8 = j7 != Long.MAX_VALUE ? j7 + 1 : Long.MAX_VALUE;
        long jX = x((byte) 10, 0L, j8);
        if (jX != -1) {
            return w6.a.b(this, jX);
        }
        if (j8 < size() && u(j8 - 1) == 13 && u(j8) == 10) {
            return w6.a.b(this, j8);
        }
        e eVar = new e();
        r(eVar, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j7) + " content=" + eVar.B().o() + (char) 8230);
    }

    public final long size() {
        return this.f23179m;
    }

    @Override // v6.g
    public void skip(long j7) throws EOFException {
        while (j7 > 0) {
            v vVar = this.f23178l;
            if (vVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j7, vVar.f23225c - vVar.f23224b);
            long j8 = iMin;
            J(size() - j8);
            j7 -= j8;
            int i7 = vVar.f23224b + iMin;
            vVar.f23224b = i7;
            if (i7 == vVar.f23225c) {
                this.f23178l = vVar.b();
                w.b(vVar);
            }
        }
    }

    public String toString() {
        return K().toString();
    }

    public final byte u(long j7) {
        AbstractC1720b.b(size(), j7, 1L);
        v vVar = this.f23178l;
        if (vVar == null) {
            M5.m.b(null);
            throw null;
        }
        if (size() - j7 < j7) {
            long size = size();
            while (size > j7) {
                vVar = vVar.f23229g;
                M5.m.b(vVar);
                size -= vVar.f23225c - vVar.f23224b;
            }
            M5.m.b(vVar);
            return vVar.f23223a[(int) ((vVar.f23224b + j7) - size)];
        }
        long j8 = 0;
        while (true) {
            long j9 = (vVar.f23225c - vVar.f23224b) + j8;
            if (j9 > j7) {
                M5.m.b(vVar);
                return vVar.f23223a[(int) ((vVar.f23224b + j7) - j8)];
            }
            vVar = vVar.f23228f;
            M5.m.b(vVar);
            j8 = j9;
        }
    }

    public long x(byte b7, long j7, long j8) {
        v vVar;
        int i7;
        long size = 0;
        if (0 > j7 || j7 > j8) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j7 + " toIndex=" + j8).toString());
        }
        if (j8 > size()) {
            j8 = size();
        }
        if (j7 == j8 || (vVar = this.f23178l) == null) {
            return -1L;
        }
        if (size() - j7 < j7) {
            size = size();
            while (size > j7) {
                vVar = vVar.f23229g;
                M5.m.b(vVar);
                size -= vVar.f23225c - vVar.f23224b;
            }
            while (size < j8) {
                byte[] bArr = vVar.f23223a;
                int iMin = (int) Math.min(vVar.f23225c, (vVar.f23224b + j8) - size);
                i7 = (int) ((vVar.f23224b + j7) - size);
                while (i7 < iMin) {
                    if (bArr[i7] != b7) {
                        i7++;
                    }
                }
                size += vVar.f23225c - vVar.f23224b;
                vVar = vVar.f23228f;
                M5.m.b(vVar);
                j7 = size;
            }
            return -1L;
        }
        while (true) {
            long j9 = (vVar.f23225c - vVar.f23224b) + size;
            if (j9 > j7) {
                break;
            }
            vVar = vVar.f23228f;
            M5.m.b(vVar);
            size = j9;
        }
        while (size < j8) {
            byte[] bArr2 = vVar.f23223a;
            int iMin2 = (int) Math.min(vVar.f23225c, (vVar.f23224b + j8) - size);
            i7 = (int) ((vVar.f23224b + j7) - size);
            while (i7 < iMin2) {
                if (bArr2[i7] != b7) {
                    i7++;
                }
            }
            size += vVar.f23225c - vVar.f23224b;
            vVar = vVar.f23228f;
            M5.m.b(vVar);
            j7 = size;
        }
        return -1L;
        return (i7 - vVar.f23224b) + size;
    }

    public byte[] y() {
        return I(size());
    }

    @Override // v6.g
    public boolean z(long j7) {
        return this.f23179m >= j7;
    }

    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(e.this.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream
        public int read() {
            if (e.this.size() > 0) {
                return e.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return e.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) {
            M5.m.e(bArr, "sink");
            return e.this.read(bArr, i7, i8);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i7 = iRemaining;
        while (i7 > 0) {
            v vVarM = M(1);
            int iMin = Math.min(i7, 8192 - vVarM.f23225c);
            byteBuffer.get(vVarM.f23223a, vVarM.f23225c, iMin);
            i7 -= iMin;
            vVarM.f23225c += iMin;
        }
        this.f23179m += iRemaining;
        return iRemaining;
    }

    public int read(byte[] bArr, int i7, int i8) {
        M5.m.e(bArr, "sink");
        AbstractC1720b.b(bArr.length, i7, i8);
        v vVar = this.f23178l;
        if (vVar == null) {
            return -1;
        }
        int iMin = Math.min(i8, vVar.f23225c - vVar.f23224b);
        byte[] bArr2 = vVar.f23223a;
        int i9 = vVar.f23224b;
        C1877k.e(bArr2, bArr, i7, i9, i9 + iMin);
        vVar.f23224b += iMin;
        J(size() - iMin);
        if (vVar.f23224b == vVar.f23225c) {
            this.f23178l = vVar.b();
            w.b(vVar);
        }
        return iMin;
    }

    @Override // v6.g, v6.f
    public e b() {
        return this;
    }

    @Override // v6.A, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // v6.f, v6.y, java.io.Flushable
    public void flush() {
    }

    @Override // v6.g
    public e l() {
        return this;
    }

    @Override // v6.f
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public e p() {
        return this;
    }
}
