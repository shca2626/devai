package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0778i extends AbstractC0774e {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f12073c = Logger.getLogger(AbstractC0778i.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f12074d = j0.B();

    /* renamed from: a, reason: collision with root package name */
    public C0779j f12075a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12076b;

    /* renamed from: androidx.datastore.preferences.protobuf.i$b */
    public static abstract class b extends AbstractC0778i {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f12077e;

        /* renamed from: f, reason: collision with root package name */
        public final int f12078f;

        /* renamed from: g, reason: collision with root package name */
        public int f12079g;

        /* renamed from: h, reason: collision with root package name */
        public int f12080h;

        public b(int i7) {
            super();
            if (i7 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i7, 20)];
            this.f12077e = bArr;
            this.f12078f = bArr.length;
        }

        public final void X0(byte b7) {
            byte[] bArr = this.f12077e;
            int i7 = this.f12079g;
            this.f12079g = i7 + 1;
            bArr[i7] = b7;
            this.f12080h++;
        }

        public final void Y0(int i7) {
            byte[] bArr = this.f12077e;
            int i8 = this.f12079g;
            int i9 = i8 + 1;
            this.f12079g = i9;
            bArr[i8] = (byte) (i7 & 255);
            int i10 = i8 + 2;
            this.f12079g = i10;
            bArr[i9] = (byte) ((i7 >> 8) & 255);
            int i11 = i8 + 3;
            this.f12079g = i11;
            bArr[i10] = (byte) ((i7 >> 16) & 255);
            this.f12079g = i8 + 4;
            bArr[i11] = (byte) ((i7 >> 24) & 255);
            this.f12080h += 4;
        }

        public final void Z0(long j7) {
            byte[] bArr = this.f12077e;
            int i7 = this.f12079g;
            int i8 = i7 + 1;
            this.f12079g = i8;
            bArr[i7] = (byte) (j7 & 255);
            int i9 = i7 + 2;
            this.f12079g = i9;
            bArr[i8] = (byte) ((j7 >> 8) & 255);
            int i10 = i7 + 3;
            this.f12079g = i10;
            bArr[i9] = (byte) ((j7 >> 16) & 255);
            int i11 = i7 + 4;
            this.f12079g = i11;
            bArr[i10] = (byte) (255 & (j7 >> 24));
            int i12 = i7 + 5;
            this.f12079g = i12;
            bArr[i11] = (byte) (((int) (j7 >> 32)) & 255);
            int i13 = i7 + 6;
            this.f12079g = i13;
            bArr[i12] = (byte) (((int) (j7 >> 40)) & 255);
            int i14 = i7 + 7;
            this.f12079g = i14;
            bArr[i13] = (byte) (((int) (j7 >> 48)) & 255);
            this.f12079g = i7 + 8;
            bArr[i14] = (byte) (((int) (j7 >> 56)) & 255);
            this.f12080h += 8;
        }

        public final void a1(int i7) {
            if (i7 >= 0) {
                c1(i7);
            } else {
                d1(i7);
            }
        }

        public final void b1(int i7, int i8) {
            c1(l0.c(i7, i8));
        }

        public final void c1(int i7) {
            if (!AbstractC0778i.f12074d) {
                while ((i7 & (-128)) != 0) {
                    byte[] bArr = this.f12077e;
                    int i8 = this.f12079g;
                    this.f12079g = i8 + 1;
                    bArr[i8] = (byte) ((i7 | 128) & 255);
                    this.f12080h++;
                    i7 >>>= 7;
                }
                byte[] bArr2 = this.f12077e;
                int i9 = this.f12079g;
                this.f12079g = i9 + 1;
                bArr2[i9] = (byte) i7;
                this.f12080h++;
                return;
            }
            long j7 = this.f12079g;
            while ((i7 & (-128)) != 0) {
                byte[] bArr3 = this.f12077e;
                int i10 = this.f12079g;
                this.f12079g = i10 + 1;
                j0.H(bArr3, i10, (byte) ((i7 | 128) & 255));
                i7 >>>= 7;
            }
            byte[] bArr4 = this.f12077e;
            int i11 = this.f12079g;
            this.f12079g = i11 + 1;
            j0.H(bArr4, i11, (byte) i7);
            this.f12080h += (int) (this.f12079g - j7);
        }

        public final void d1(long j7) {
            if (!AbstractC0778i.f12074d) {
                while ((j7 & (-128)) != 0) {
                    byte[] bArr = this.f12077e;
                    int i7 = this.f12079g;
                    this.f12079g = i7 + 1;
                    bArr[i7] = (byte) ((((int) j7) | 128) & 255);
                    this.f12080h++;
                    j7 >>>= 7;
                }
                byte[] bArr2 = this.f12077e;
                int i8 = this.f12079g;
                this.f12079g = i8 + 1;
                bArr2[i8] = (byte) j7;
                this.f12080h++;
                return;
            }
            long j8 = this.f12079g;
            while ((j7 & (-128)) != 0) {
                byte[] bArr3 = this.f12077e;
                int i9 = this.f12079g;
                this.f12079g = i9 + 1;
                j0.H(bArr3, i9, (byte) ((((int) j7) | 128) & 255));
                j7 >>>= 7;
            }
            byte[] bArr4 = this.f12077e;
            int i10 = this.f12079g;
            this.f12079g = i10 + 1;
            j0.H(bArr4, i10, (byte) j7);
            this.f12080h += (int) (this.f12079g - j8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final int e0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.i$c */
    public static class c extends AbstractC0778i {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f12081e;

        /* renamed from: f, reason: collision with root package name */
        public final int f12082f;

        /* renamed from: g, reason: collision with root package name */
        public final int f12083g;

        /* renamed from: h, reason: collision with root package name */
        public int f12084h;

        public c(byte[] bArr, int i7, int i8) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i9 = i7 + i8;
            if ((i7 | i8 | (bArr.length - i9)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i7), Integer.valueOf(i8)));
            }
            this.f12081e = bArr;
            this.f12082f = i7;
            this.f12084h = i7;
            this.f12083g = i9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void A0(int i7, int i8) throws d {
            S0(i7, 0);
            B0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void B0(int i7) throws d {
            if (i7 >= 0) {
                U0(i7);
            } else {
                W0(i7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void E0(int i7, K k7, Z z7) throws d {
            S0(i7, 2);
            U0(((AbstractC0770a) k7).j(z7));
            z7.e(k7, this.f12075a);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void F0(K k7) throws d {
            U0(k7.f());
            k7.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void G0(int i7, K k7) throws d {
            S0(1, 3);
            T0(2, i7);
            Y0(3, k7);
            S0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void H0(int i7, AbstractC0775f abstractC0775f) throws d {
            S0(1, 3);
            T0(2, i7);
            k0(3, abstractC0775f);
            S0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void Q0(int i7, String str) throws d {
            S0(i7, 2);
            R0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void R0(String str) throws d {
            int i7 = this.f12084h;
            try {
                int iT = AbstractC0778i.T(str.length() * 3);
                int iT2 = AbstractC0778i.T(str.length());
                if (iT2 != iT) {
                    U0(k0.c(str));
                    this.f12084h = k0.b(str, this.f12081e, this.f12084h, e0());
                    return;
                }
                int i8 = i7 + iT2;
                this.f12084h = i8;
                int iB = k0.b(str, this.f12081e, i8, e0());
                this.f12084h = i7;
                U0((iB - i7) - iT2);
                this.f12084h = iB;
            } catch (k0.d e7) {
                this.f12084h = i7;
                Z(str, e7);
            } catch (IndexOutOfBoundsException e8) {
                throw new d(e8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void S0(int i7, int i8) throws d {
            U0(l0.c(i7, i8));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void T0(int i7, int i8) throws d {
            S0(i7, 0);
            U0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void U0(int i7) throws d {
            while ((i7 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f12081e;
                    int i8 = this.f12084h;
                    this.f12084h = i8 + 1;
                    bArr[i8] = (byte) ((i7 | 128) & 255);
                    i7 >>>= 7;
                } catch (IndexOutOfBoundsException e7) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12084h), Integer.valueOf(this.f12083g), 1), e7);
                }
            }
            byte[] bArr2 = this.f12081e;
            int i9 = this.f12084h;
            this.f12084h = i9 + 1;
            bArr2[i9] = (byte) i7;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void V0(int i7, long j7) throws d {
            S0(i7, 0);
            W0(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void W0(long j7) throws d {
            if (AbstractC0778i.f12074d && e0() >= 10) {
                while ((j7 & (-128)) != 0) {
                    byte[] bArr = this.f12081e;
                    int i7 = this.f12084h;
                    this.f12084h = i7 + 1;
                    j0.H(bArr, i7, (byte) ((((int) j7) | 128) & 255));
                    j7 >>>= 7;
                }
                byte[] bArr2 = this.f12081e;
                int i8 = this.f12084h;
                this.f12084h = i8 + 1;
                j0.H(bArr2, i8, (byte) j7);
                return;
            }
            while ((j7 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f12081e;
                    int i9 = this.f12084h;
                    this.f12084h = i9 + 1;
                    bArr3[i9] = (byte) ((((int) j7) | 128) & 255);
                    j7 >>>= 7;
                } catch (IndexOutOfBoundsException e7) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12084h), Integer.valueOf(this.f12083g), 1), e7);
                }
            }
            byte[] bArr4 = this.f12081e;
            int i10 = this.f12084h;
            this.f12084h = i10 + 1;
            bArr4[i10] = (byte) j7;
        }

        public final void X0(byte[] bArr, int i7, int i8) throws d {
            try {
                System.arraycopy(bArr, i7, this.f12081e, this.f12084h, i8);
                this.f12084h += i8;
            } catch (IndexOutOfBoundsException e7) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12084h), Integer.valueOf(this.f12083g), Integer.valueOf(i8)), e7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void Y() {
        }

        public final void Y0(int i7, K k7) throws d {
            S0(i7, 2);
            F0(k7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i, androidx.datastore.preferences.protobuf.AbstractC0774e
        public final void a(byte[] bArr, int i7, int i8) throws d {
            X0(bArr, i7, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final int e0() {
            return this.f12083g - this.f12084h;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void f0(byte b7) throws d {
            try {
                byte[] bArr = this.f12081e;
                int i7 = this.f12084h;
                this.f12084h = i7 + 1;
                bArr[i7] = b7;
            } catch (IndexOutOfBoundsException e7) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12084h), Integer.valueOf(this.f12083g), 1), e7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void g0(int i7, boolean z7) throws d {
            S0(i7, 0);
            f0(z7 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void j0(byte[] bArr, int i7, int i8) throws d {
            U0(i8);
            X0(bArr, i7, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void k0(int i7, AbstractC0775f abstractC0775f) throws d {
            S0(i7, 2);
            l0(abstractC0775f);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void l0(AbstractC0775f abstractC0775f) throws d {
            U0(abstractC0775f.size());
            abstractC0775f.z(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void q0(int i7, int i8) throws d {
            S0(i7, 5);
            r0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void r0(int i7) throws d {
            try {
                byte[] bArr = this.f12081e;
                int i8 = this.f12084h;
                int i9 = i8 + 1;
                this.f12084h = i9;
                bArr[i8] = (byte) (i7 & 255);
                int i10 = i8 + 2;
                this.f12084h = i10;
                bArr[i9] = (byte) ((i7 >> 8) & 255);
                int i11 = i8 + 3;
                this.f12084h = i11;
                bArr[i10] = (byte) ((i7 >> 16) & 255);
                this.f12084h = i8 + 4;
                bArr[i11] = (byte) ((i7 >> 24) & 255);
            } catch (IndexOutOfBoundsException e7) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12084h), Integer.valueOf(this.f12083g), 1), e7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void s0(int i7, long j7) throws d {
            S0(i7, 1);
            t0(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public final void t0(long j7) throws d {
            try {
                byte[] bArr = this.f12081e;
                int i7 = this.f12084h;
                int i8 = i7 + 1;
                this.f12084h = i8;
                bArr[i7] = (byte) (((int) j7) & 255);
                int i9 = i7 + 2;
                this.f12084h = i9;
                bArr[i8] = (byte) (((int) (j7 >> 8)) & 255);
                int i10 = i7 + 3;
                this.f12084h = i10;
                bArr[i9] = (byte) (((int) (j7 >> 16)) & 255);
                int i11 = i7 + 4;
                this.f12084h = i11;
                bArr[i10] = (byte) (((int) (j7 >> 24)) & 255);
                int i12 = i7 + 5;
                this.f12084h = i12;
                bArr[i11] = (byte) (((int) (j7 >> 32)) & 255);
                int i13 = i7 + 6;
                this.f12084h = i13;
                bArr[i12] = (byte) (((int) (j7 >> 40)) & 255);
                int i14 = i7 + 7;
                this.f12084h = i14;
                bArr[i13] = (byte) (((int) (j7 >> 48)) & 255);
                this.f12084h = i7 + 8;
                bArr[i14] = (byte) (((int) (j7 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e7) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12084h), Integer.valueOf(this.f12083g), 1), e7);
            }
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.i$d */
    public static class d extends IOException {
        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.i$e */
    public static final class e extends b {

        /* renamed from: i, reason: collision with root package name */
        public final OutputStream f12085i;

        public e(OutputStream outputStream, int i7) {
            super(i7);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f12085i = outputStream;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void A0(int i7, int i8) throws IOException {
            f1(20);
            b1(i7, 0);
            a1(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void B0(int i7) throws IOException {
            if (i7 >= 0) {
                U0(i7);
            } else {
                W0(i7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void E0(int i7, K k7, Z z7) throws IOException {
            S0(i7, 2);
            i1(k7, z7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void F0(K k7) throws IOException {
            U0(k7.f());
            k7.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void G0(int i7, K k7) throws IOException {
            S0(1, 3);
            T0(2, i7);
            h1(3, k7);
            S0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void H0(int i7, AbstractC0775f abstractC0775f) throws IOException {
            S0(1, 3);
            T0(2, i7);
            k0(3, abstractC0775f);
            S0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void Q0(int i7, String str) throws IOException {
            S0(i7, 2);
            R0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void R0(String str) throws IOException {
            int iC;
            try {
                int length = str.length() * 3;
                int iT = AbstractC0778i.T(length);
                int i7 = iT + length;
                int i8 = this.f12078f;
                if (i7 > i8) {
                    byte[] bArr = new byte[length];
                    int iB = k0.b(str, bArr, 0, length);
                    U0(iB);
                    a(bArr, 0, iB);
                    return;
                }
                if (i7 > i8 - this.f12079g) {
                    e1();
                }
                int iT2 = AbstractC0778i.T(str.length());
                int i9 = this.f12079g;
                try {
                    if (iT2 == iT) {
                        int i10 = i9 + iT2;
                        this.f12079g = i10;
                        int iB2 = k0.b(str, this.f12077e, i10, this.f12078f - i10);
                        this.f12079g = i9;
                        iC = (iB2 - i9) - iT2;
                        c1(iC);
                        this.f12079g = iB2;
                    } else {
                        iC = k0.c(str);
                        c1(iC);
                        this.f12079g = k0.b(str, this.f12077e, this.f12079g, iC);
                    }
                    this.f12080h += iC;
                } catch (k0.d e7) {
                    this.f12080h -= this.f12079g - i9;
                    this.f12079g = i9;
                    throw e7;
                } catch (ArrayIndexOutOfBoundsException e8) {
                    throw new d(e8);
                }
            } catch (k0.d e9) {
                Z(str, e9);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void S0(int i7, int i8) throws IOException {
            U0(l0.c(i7, i8));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void T0(int i7, int i8) throws IOException {
            f1(20);
            b1(i7, 0);
            c1(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void U0(int i7) throws IOException {
            f1(5);
            c1(i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void V0(int i7, long j7) throws IOException {
            f1(20);
            b1(i7, 0);
            d1(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void W0(long j7) throws IOException {
            f1(10);
            d1(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void Y() throws IOException {
            if (this.f12079g > 0) {
                e1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i, androidx.datastore.preferences.protobuf.AbstractC0774e
        public void a(byte[] bArr, int i7, int i8) throws IOException {
            g1(bArr, i7, i8);
        }

        public final void e1() throws IOException {
            this.f12085i.write(this.f12077e, 0, this.f12079g);
            this.f12079g = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void f0(byte b7) throws IOException {
            if (this.f12079g == this.f12078f) {
                e1();
            }
            X0(b7);
        }

        public final void f1(int i7) throws IOException {
            if (this.f12078f - this.f12079g < i7) {
                e1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void g0(int i7, boolean z7) throws IOException {
            f1(11);
            b1(i7, 0);
            X0(z7 ? (byte) 1 : (byte) 0);
        }

        public void g1(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = this.f12078f;
            int i10 = this.f12079g;
            if (i9 - i10 >= i8) {
                System.arraycopy(bArr, i7, this.f12077e, i10, i8);
                this.f12079g += i8;
                this.f12080h += i8;
                return;
            }
            int i11 = i9 - i10;
            System.arraycopy(bArr, i7, this.f12077e, i10, i11);
            int i12 = i7 + i11;
            int i13 = i8 - i11;
            this.f12079g = this.f12078f;
            this.f12080h += i11;
            e1();
            if (i13 <= this.f12078f) {
                System.arraycopy(bArr, i12, this.f12077e, 0, i13);
                this.f12079g = i13;
            } else {
                this.f12085i.write(bArr, i12, i13);
            }
            this.f12080h += i13;
        }

        public void h1(int i7, K k7) throws IOException {
            S0(i7, 2);
            F0(k7);
        }

        public void i1(K k7, Z z7) throws IOException {
            U0(((AbstractC0770a) k7).j(z7));
            z7.e(k7, this.f12075a);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void j0(byte[] bArr, int i7, int i8) throws IOException {
            U0(i8);
            g1(bArr, i7, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void k0(int i7, AbstractC0775f abstractC0775f) throws IOException {
            S0(i7, 2);
            l0(abstractC0775f);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void l0(AbstractC0775f abstractC0775f) throws IOException {
            U0(abstractC0775f.size());
            abstractC0775f.z(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void q0(int i7, int i8) throws IOException {
            f1(14);
            b1(i7, 5);
            Y0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void r0(int i7) throws IOException {
            f1(4);
            Y0(i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void s0(int i7, long j7) throws IOException {
            f1(18);
            b1(i7, 1);
            Z0(j7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0778i
        public void t0(long j7) throws IOException {
            f1(8);
            Z0(j7);
        }
    }

    public static int A(C0793y c0793y) {
        return B(c0793y.b());
    }

    public static int B(int i7) {
        return T(i7) + i7;
    }

    public static int C(int i7, K k7, Z z7) {
        return R(i7) + E(k7, z7);
    }

    public static int D(K k7) {
        return B(k7.f());
    }

    public static int E(K k7, Z z7) {
        return B(((AbstractC0770a) k7).j(z7));
    }

    public static int F(int i7) {
        if (i7 > 4096) {
            return 4096;
        }
        return i7;
    }

    public static int G(int i7, AbstractC0775f abstractC0775f) {
        return (R(1) * 2) + S(2, i7) + g(3, abstractC0775f);
    }

    public static int H(int i7, int i8) {
        return R(i7) + I(i8);
    }

    public static int I(int i7) {
        return 4;
    }

    public static int J(int i7, long j7) {
        return R(i7) + K(j7);
    }

    public static int K(long j7) {
        return 8;
    }

    public static int L(int i7, int i8) {
        return R(i7) + M(i8);
    }

    public static int M(int i7) {
        return T(W(i7));
    }

    public static int N(int i7, long j7) {
        return R(i7) + O(j7);
    }

    public static int O(long j7) {
        return V(X(j7));
    }

    public static int P(int i7, String str) {
        return R(i7) + Q(str);
    }

    public static int Q(String str) {
        int length;
        try {
            length = k0.c(str);
        } catch (k0.d unused) {
            length = str.getBytes(AbstractC0789u.f12246b).length;
        }
        return B(length);
    }

    public static int R(int i7) {
        return T(l0.c(i7, 0));
    }

    public static int S(int i7, int i8) {
        return R(i7) + T(i8);
    }

    public static int T(int i7) {
        return (352 - (Integer.numberOfLeadingZeros(i7) * 9)) >>> 6;
    }

    public static int U(int i7, long j7) {
        return R(i7) + V(j7);
    }

    public static int V(long j7) {
        return (640 - (Long.numberOfLeadingZeros(j7) * 9)) >>> 6;
    }

    public static int W(int i7) {
        return (i7 >> 31) ^ (i7 << 1);
    }

    public static long X(long j7) {
        return (j7 >> 63) ^ (j7 << 1);
    }

    public static AbstractC0778i b0(OutputStream outputStream, int i7) {
        return new e(outputStream, i7);
    }

    public static AbstractC0778i c0(byte[] bArr) {
        return d0(bArr, 0, bArr.length);
    }

    public static int d(int i7, boolean z7) {
        return R(i7) + e(z7);
    }

    public static AbstractC0778i d0(byte[] bArr, int i7, int i8) {
        return new c(bArr, i7, i8);
    }

    public static int e(boolean z7) {
        return 1;
    }

    public static int f(byte[] bArr) {
        return B(bArr.length);
    }

    public static int g(int i7, AbstractC0775f abstractC0775f) {
        return R(i7) + h(abstractC0775f);
    }

    public static int h(AbstractC0775f abstractC0775f) {
        return B(abstractC0775f.size());
    }

    public static int i(int i7, double d7) {
        return R(i7) + j(d7);
    }

    public static int j(double d7) {
        return 8;
    }

    public static int k(int i7, int i8) {
        return R(i7) + l(i8);
    }

    public static int l(int i7) {
        return w(i7);
    }

    public static int m(int i7, int i8) {
        return R(i7) + n(i8);
    }

    public static int n(int i7) {
        return 4;
    }

    public static int o(int i7, long j7) {
        return R(i7) + p(j7);
    }

    public static int p(long j7) {
        return 8;
    }

    public static int q(int i7, float f7) {
        return R(i7) + r(f7);
    }

    public static int r(float f7) {
        return 4;
    }

    public static int s(int i7, K k7, Z z7) {
        return (R(i7) * 2) + u(k7, z7);
    }

    public static int t(K k7) {
        return k7.f();
    }

    public static int u(K k7, Z z7) {
        return ((AbstractC0770a) k7).j(z7);
    }

    public static int v(int i7, int i8) {
        return R(i7) + w(i8);
    }

    public static int w(int i7) {
        return V(i7);
    }

    public static int x(int i7, long j7) {
        return R(i7) + y(j7);
    }

    public static int y(long j7) {
        return V(j7);
    }

    public static int z(int i7, C0793y c0793y) {
        return R(i7) + A(c0793y);
    }

    public abstract void A0(int i7, int i8);

    public abstract void B0(int i7);

    public final void C0(int i7, long j7) {
        V0(i7, j7);
    }

    public final void D0(long j7) {
        W0(j7);
    }

    public abstract void E0(int i7, K k7, Z z7);

    public abstract void F0(K k7);

    public abstract void G0(int i7, K k7);

    public abstract void H0(int i7, AbstractC0775f abstractC0775f);

    public final void I0(int i7, int i8) {
        q0(i7, i8);
    }

    public final void J0(int i7) {
        r0(i7);
    }

    public final void K0(int i7, long j7) {
        s0(i7, j7);
    }

    public final void L0(long j7) {
        t0(j7);
    }

    public final void M0(int i7, int i8) {
        T0(i7, W(i8));
    }

    public final void N0(int i7) {
        U0(W(i7));
    }

    public final void O0(int i7, long j7) {
        V0(i7, X(j7));
    }

    public final void P0(long j7) {
        W0(X(j7));
    }

    public abstract void Q0(int i7, String str);

    public abstract void R0(String str);

    public abstract void S0(int i7, int i8);

    public abstract void T0(int i7, int i8);

    public abstract void U0(int i7);

    public abstract void V0(int i7, long j7);

    public abstract void W0(long j7);

    public abstract void Y();

    public final void Z(String str, k0.d dVar) throws d {
        f12073c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(AbstractC0789u.f12246b);
        try {
            U0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e7) {
            throw new d(e7);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0774e
    public abstract void a(byte[] bArr, int i7, int i8);

    public boolean a0() {
        return this.f12076b;
    }

    public final void c() {
        if (e0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int e0();

    public abstract void f0(byte b7);

    public abstract void g0(int i7, boolean z7);

    public final void h0(boolean z7) {
        f0(z7 ? (byte) 1 : (byte) 0);
    }

    public final void i0(byte[] bArr) {
        j0(bArr, 0, bArr.length);
    }

    public abstract void j0(byte[] bArr, int i7, int i8);

    public abstract void k0(int i7, AbstractC0775f abstractC0775f);

    public abstract void l0(AbstractC0775f abstractC0775f);

    public final void m0(int i7, double d7) {
        s0(i7, Double.doubleToRawLongBits(d7));
    }

    public final void n0(double d7) {
        t0(Double.doubleToRawLongBits(d7));
    }

    public final void o0(int i7, int i8) {
        A0(i7, i8);
    }

    public final void p0(int i7) {
        B0(i7);
    }

    public abstract void q0(int i7, int i8);

    public abstract void r0(int i7);

    public abstract void s0(int i7, long j7);

    public abstract void t0(long j7);

    public final void u0(int i7, float f7) {
        q0(i7, Float.floatToRawIntBits(f7));
    }

    public final void v0(float f7) {
        r0(Float.floatToRawIntBits(f7));
    }

    public final void w0(int i7, K k7) {
        S0(i7, 3);
        y0(k7);
        S0(i7, 4);
    }

    public final void x0(int i7, K k7, Z z7) {
        S0(i7, 3);
        z0(k7, z7);
        S0(i7, 4);
    }

    public final void y0(K k7) {
        k7.g(this);
    }

    public final void z0(K k7, Z z7) {
        z7.e(k7, this.f12075a);
    }

    public AbstractC0778i() {
    }
}
