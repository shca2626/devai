package l3;

import j3.AbstractC1229c;
import j3.o;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: l3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1304a {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC1304a f19559a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC1304a f19560b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC1304a f19561c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC1304a f19562d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC1304a f19563e = new b("base16()", "0123456789ABCDEF");

    /* renamed from: l3.a$a, reason: collision with other inner class name */
    public static final class C0220a {

        /* renamed from: a, reason: collision with root package name */
        public final String f19564a;

        /* renamed from: b, reason: collision with root package name */
        public final char[] f19565b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19566c;

        /* renamed from: d, reason: collision with root package name */
        public final int f19567d;

        /* renamed from: e, reason: collision with root package name */
        public final int f19568e;

        /* renamed from: f, reason: collision with root package name */
        public final int f19569f;

        /* renamed from: g, reason: collision with root package name */
        public final byte[] f19570g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean[] f19571h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f19572i;

        public C0220a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i7 = 0; i7 < cArr.length; i7++) {
                char c7 = cArr[i7];
                boolean z7 = true;
                o.f(c7 < 128, "Non-ASCII character: %s", c7);
                if (bArr[c7] != -1) {
                    z7 = false;
                }
                o.f(z7, "Duplicate character: %s", c7);
                bArr[c7] = (byte) i7;
            }
            return bArr;
        }

        public int c(char c7) throws d {
            if (c7 > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c7));
            }
            byte b7 = this.f19570g[c7];
            if (b7 != -1) {
                return b7;
            }
            if (c7 <= ' ' || c7 == 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c7));
            }
            throw new d("Unrecognized character: " + c7);
        }

        public char d(int i7) {
            return this.f19565b[i7];
        }

        public final boolean e() {
            for (char c7 : this.f19565b) {
                if (AbstractC1229c.c(c7)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0220a) {
                C0220a c0220a = (C0220a) obj;
                if (this.f19572i == c0220a.f19572i && Arrays.equals(this.f19565b, c0220a.f19565b)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean f() {
            for (char c7 : this.f19565b) {
                if (AbstractC1229c.d(c7)) {
                    return true;
                }
            }
            return false;
        }

        public C0220a g() {
            if (this.f19572i) {
                return this;
            }
            byte[] bArr = this.f19570g;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            int i7 = 65;
            while (true) {
                if (i7 > 90) {
                    return new C0220a(this.f19564a + ".ignoreCase()", this.f19565b, bArrCopyOf, true);
                }
                int i8 = i7 | 32;
                byte[] bArr2 = this.f19570g;
                byte b7 = bArr2[i7];
                byte b8 = bArr2[i8];
                if (b7 == -1) {
                    bArrCopyOf[i7] = b8;
                } else {
                    o.x(b8 == -1, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i7, (char) i8);
                    bArrCopyOf[i8] = b7;
                }
                i7++;
            }
        }

        public boolean h(int i7) {
            return this.f19571h[i7 % this.f19568e];
        }

        public int hashCode() {
            return Arrays.hashCode(this.f19565b) + (this.f19572i ? 1231 : 1237);
        }

        public C0220a i() {
            if (!f()) {
                return this;
            }
            o.w(!e(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f19565b.length];
            int i7 = 0;
            while (true) {
                char[] cArr2 = this.f19565b;
                if (i7 >= cArr2.length) {
                    break;
                }
                cArr[i7] = AbstractC1229c.e(cArr2[i7]);
                i7++;
            }
            C0220a c0220a = new C0220a(this.f19564a + ".lowerCase()", cArr);
            return this.f19572i ? c0220a.g() : c0220a;
        }

        public boolean j(char c7) {
            byte[] bArr = this.f19570g;
            return c7 < bArr.length && bArr[c7] != -1;
        }

        public String toString() {
            return this.f19564a;
        }

        public C0220a(String str, char[] cArr, byte[] bArr, boolean z7) {
            this.f19564a = (String) o.q(str);
            this.f19565b = (char[]) o.q(cArr);
            try {
                int iE = m3.d.e(cArr.length, RoundingMode.UNNECESSARY);
                this.f19567d = iE;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iE);
                int i7 = 1 << (3 - iNumberOfTrailingZeros);
                this.f19568e = i7;
                this.f19569f = iE >> iNumberOfTrailingZeros;
                this.f19566c = cArr.length - 1;
                this.f19570g = bArr;
                boolean[] zArr = new boolean[i7];
                for (int i8 = 0; i8 < this.f19569f; i8++) {
                    zArr[m3.d.b(i8 * 8, this.f19567d, RoundingMode.CEILING)] = true;
                }
                this.f19571h = zArr;
                this.f19572i = z7;
            } catch (ArithmeticException e7) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e7);
            }
        }
    }

    /* renamed from: l3.a$b */
    public static final class b extends e {

        /* renamed from: j, reason: collision with root package name */
        public final char[] f19573j;

        public b(String str, String str2) {
            this(new C0220a(str, str2.toCharArray()));
        }

        @Override // l3.AbstractC1304a.e, l3.AbstractC1304a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            o.q(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequence.length()) {
                bArr[i8] = (byte) ((this.f19574f.c(charSequence.charAt(i7)) << 4) | this.f19574f.c(charSequence.charAt(i7 + 1)));
                i7 += 2;
                i8++;
            }
            return i8;
        }

        @Override // l3.AbstractC1304a.e, l3.AbstractC1304a
        public void g(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            o.q(appendable);
            o.u(i7, i7 + i8, bArr.length);
            for (int i9 = 0; i9 < i8; i9++) {
                int i10 = bArr[i7 + i9] & 255;
                appendable.append(this.f19573j[i10]);
                appendable.append(this.f19573j[i10 | 256]);
            }
        }

        @Override // l3.AbstractC1304a.e
        public AbstractC1304a o(C0220a c0220a, Character ch) {
            return new b(c0220a);
        }

        public b(C0220a c0220a) {
            super(c0220a, null);
            this.f19573j = new char[512];
            o.d(c0220a.f19565b.length == 16);
            for (int i7 = 0; i7 < 256; i7++) {
                this.f19573j[i7] = c0220a.d(i7 >>> 4);
                this.f19573j[i7 | 256] = c0220a.d(i7 & 15);
            }
        }
    }

    /* renamed from: l3.a$c */
    public static final class c extends e {
        public c(String str, String str2, Character ch) {
            this(new C0220a(str, str2.toCharArray()), ch);
        }

        @Override // l3.AbstractC1304a.e, l3.AbstractC1304a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            o.q(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f19574f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequenceM.length()) {
                int i9 = i7 + 2;
                int iC = (this.f19574f.c(charSequenceM.charAt(i7)) << 18) | (this.f19574f.c(charSequenceM.charAt(i7 + 1)) << 12);
                int i10 = i8 + 1;
                bArr[i8] = (byte) (iC >>> 16);
                if (i9 < charSequenceM.length()) {
                    int i11 = i7 + 3;
                    int iC2 = iC | (this.f19574f.c(charSequenceM.charAt(i9)) << 6);
                    int i12 = i8 + 2;
                    bArr[i10] = (byte) ((iC2 >>> 8) & 255);
                    if (i11 < charSequenceM.length()) {
                        i7 += 4;
                        i8 += 3;
                        bArr[i12] = (byte) ((iC2 | this.f19574f.c(charSequenceM.charAt(i11))) & 255);
                    } else {
                        i8 = i12;
                        i7 = i11;
                    }
                } else {
                    i8 = i10;
                    i7 = i9;
                }
            }
            return i8;
        }

        @Override // l3.AbstractC1304a.e, l3.AbstractC1304a
        public void g(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            o.q(appendable);
            int i9 = i7 + i8;
            o.u(i7, i9, bArr.length);
            while (i8 >= 3) {
                int i10 = i7 + 2;
                int i11 = ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7] & 255) << 16);
                i7 += 3;
                int i12 = i11 | (bArr[i10] & 255);
                appendable.append(this.f19574f.d(i12 >>> 18));
                appendable.append(this.f19574f.d((i12 >>> 12) & 63));
                appendable.append(this.f19574f.d((i12 >>> 6) & 63));
                appendable.append(this.f19574f.d(i12 & 63));
                i8 -= 3;
            }
            if (i7 < i9) {
                n(appendable, bArr, i7, i9 - i7);
            }
        }

        @Override // l3.AbstractC1304a.e
        public AbstractC1304a o(C0220a c0220a, Character ch) {
            return new c(c0220a, ch);
        }

        public c(C0220a c0220a, Character ch) {
            super(c0220a, ch);
            o.d(c0220a.f19565b.length == 64);
        }
    }

    /* renamed from: l3.a$d */
    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    /* renamed from: l3.a$e */
    public static class e extends AbstractC1304a {

        /* renamed from: f, reason: collision with root package name */
        public final C0220a f19574f;

        /* renamed from: g, reason: collision with root package name */
        public final Character f19575g;

        /* renamed from: h, reason: collision with root package name */
        public volatile AbstractC1304a f19576h;

        /* renamed from: i, reason: collision with root package name */
        public volatile AbstractC1304a f19577i;

        public e(String str, String str2, Character ch) {
            this(new C0220a(str, str2.toCharArray()), ch);
        }

        @Override // l3.AbstractC1304a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            C0220a c0220a;
            o.q(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f19574f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequenceM.length()) {
                long jC = 0;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    c0220a = this.f19574f;
                    if (i9 >= c0220a.f19568e) {
                        break;
                    }
                    jC <<= c0220a.f19567d;
                    if (i7 + i9 < charSequenceM.length()) {
                        jC |= this.f19574f.c(charSequenceM.charAt(i10 + i7));
                        i10++;
                    }
                    i9++;
                }
                int i11 = c0220a.f19569f;
                int i12 = (i11 * 8) - (i10 * c0220a.f19567d);
                int i13 = (i11 - 1) * 8;
                while (i13 >= i12) {
                    bArr[i8] = (byte) ((jC >>> i13) & 255);
                    i13 -= 8;
                    i8++;
                }
                i7 += this.f19574f.f19568e;
            }
            return i8;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.f19574f.equals(eVar.f19574f) && Objects.equals(this.f19575g, eVar.f19575g)) {
                    return true;
                }
            }
            return false;
        }

        @Override // l3.AbstractC1304a
        public void g(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            o.q(appendable);
            o.u(i7, i7 + i8, bArr.length);
            int i9 = 0;
            while (i9 < i8) {
                n(appendable, bArr, i7 + i9, Math.min(this.f19574f.f19569f, i8 - i9));
                i9 += this.f19574f.f19569f;
            }
        }

        public int hashCode() {
            return this.f19574f.hashCode() ^ Objects.hashCode(this.f19575g);
        }

        @Override // l3.AbstractC1304a
        public AbstractC1304a i() {
            AbstractC1304a abstractC1304aO = this.f19577i;
            if (abstractC1304aO == null) {
                C0220a c0220aG = this.f19574f.g();
                abstractC1304aO = c0220aG == this.f19574f ? this : o(c0220aG, this.f19575g);
                this.f19577i = abstractC1304aO;
            }
            return abstractC1304aO;
        }

        @Override // l3.AbstractC1304a
        public AbstractC1304a j() {
            AbstractC1304a abstractC1304aO = this.f19576h;
            if (abstractC1304aO == null) {
                C0220a c0220aI = this.f19574f.i();
                abstractC1304aO = c0220aI == this.f19574f ? this : o(c0220aI, this.f19575g);
                this.f19576h = abstractC1304aO;
            }
            return abstractC1304aO;
        }

        @Override // l3.AbstractC1304a
        public int k(int i7) {
            return (int) (((this.f19574f.f19567d * i7) + 7) / 8);
        }

        @Override // l3.AbstractC1304a
        public int l(int i7) {
            C0220a c0220a = this.f19574f;
            return c0220a.f19568e * m3.d.b(i7, c0220a.f19569f, RoundingMode.CEILING);
        }

        @Override // l3.AbstractC1304a
        public CharSequence m(CharSequence charSequence) {
            o.q(charSequence);
            Character ch = this.f19575g;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public void n(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            o.q(appendable);
            o.u(i7, i7 + i8, bArr.length);
            int i9 = 0;
            o.d(i8 <= this.f19574f.f19569f);
            long j7 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                j7 = (j7 | (bArr[i7 + i10] & 255)) << 8;
            }
            int i11 = ((i8 + 1) * 8) - this.f19574f.f19567d;
            while (i9 < i8 * 8) {
                C0220a c0220a = this.f19574f;
                appendable.append(c0220a.d(((int) (j7 >>> (i11 - i9))) & c0220a.f19566c));
                i9 += this.f19574f.f19567d;
            }
            if (this.f19575g != null) {
                while (i9 < this.f19574f.f19569f * 8) {
                    appendable.append(this.f19575g.charValue());
                    i9 += this.f19574f.f19567d;
                }
            }
        }

        public AbstractC1304a o(C0220a c0220a, Character ch) {
            return new e(c0220a, ch);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f19574f);
            if (8 % this.f19574f.f19567d != 0) {
                if (this.f19575g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f19575g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public e(C0220a c0220a, Character ch) {
            this.f19574f = (C0220a) o.q(c0220a);
            o.k(ch == null || !c0220a.j(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f19575g = ch;
        }
    }

    public static AbstractC1304a a() {
        return f19563e;
    }

    public static byte[] h(byte[] bArr, int i7) {
        if (i7 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        return bArr2;
    }

    public final byte[] b(CharSequence charSequence) {
        try {
            return c(charSequence);
        } catch (d e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public final byte[] c(CharSequence charSequence) {
        CharSequence charSequenceM = m(charSequence);
        byte[] bArr = new byte[k(charSequenceM.length())];
        return h(bArr, d(bArr, charSequenceM));
    }

    public abstract int d(byte[] bArr, CharSequence charSequence);

    public String e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public final String f(byte[] bArr, int i7, int i8) {
        o.u(i7, i7 + i8, bArr.length);
        StringBuilder sb = new StringBuilder(l(i8));
        try {
            g(sb, bArr, i7, i8);
            return sb.toString();
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }

    public abstract void g(Appendable appendable, byte[] bArr, int i7, int i8);

    public abstract AbstractC1304a i();

    public abstract AbstractC1304a j();

    public abstract int k(int i7);

    public abstract int l(int i7);

    public abstract CharSequence m(CharSequence charSequence);
}
