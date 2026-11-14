package v6;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import z5.C1880k;

/* loaded from: classes3.dex */
public class h implements Serializable, Comparable {

    /* renamed from: o, reason: collision with root package name */
    public static final a f23193o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static final h f23194p = new h(new byte[0]);

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f23195l;

    /* renamed from: m, reason: collision with root package name */
    public transient int f23196m;

    /* renamed from: n, reason: collision with root package name */
    public transient String f23197n;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final h a(String str) {
            M5.m.e(str, "<this>");
            byte[] bArrA = AbstractC1718a.a(str);
            if (bArrA != null) {
                return new h(bArrA);
            }
            return null;
        }

        public final h b(String str) {
            M5.m.e(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = i7 * 2;
                bArr[i7] = (byte) ((w6.b.e(str.charAt(i8)) << 4) + w6.b.e(str.charAt(i8 + 1)));
            }
            return new h(bArr);
        }

        public final h c(String str) {
            M5.m.e(str, "<this>");
            h hVar = new h(C.a(str));
            hVar.w(str);
            return hVar;
        }

        public final h d(byte... bArr) {
            M5.m.e(bArr, "data");
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            M5.m.d(bArrCopyOf, "copyOf(this, size)");
            return new h(bArrCopyOf);
        }

        public a() {
        }
    }

    public h(byte[] bArr) {
        M5.m.e(bArr, "data");
        this.f23195l = bArr;
    }

    public static final h e(String str) {
        return f23193o.a(str);
    }

    public static final h f(String str) {
        return f23193o.b(str);
    }

    public static final h i(String str) {
        return f23193o.c(str);
    }

    public static final h s(byte... bArr) {
        return f23193o.d(bArr);
    }

    public h A() {
        for (int i7 = 0; i7 < k().length; i7++) {
            byte b7 = k()[i7];
            if (b7 >= 65 && b7 <= 90) {
                byte[] bArrK = k();
                byte[] bArrCopyOf = Arrays.copyOf(bArrK, bArrK.length);
                M5.m.d(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i7] = (byte) (b7 + 32);
                for (int i8 = i7 + 1; i8 < bArrCopyOf.length; i8++) {
                    byte b8 = bArrCopyOf[i8];
                    if (b8 >= 65 && b8 <= 90) {
                        bArrCopyOf[i8] = (byte) (b8 + 32);
                    }
                }
                return new h(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] B() {
        byte[] bArrK = k();
        byte[] bArrCopyOf = Arrays.copyOf(bArrK, bArrK.length);
        M5.m.d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String C() {
        String strN = n();
        if (strN != null) {
            return strN;
        }
        String strB = C.b(p());
        w(strB);
        return strB;
    }

    public void D(e eVar, int i7, int i8) {
        M5.m.e(eVar, "buffer");
        w6.b.d(this, eVar, i7, i8);
    }

    public String a() {
        return AbstractC1718a.c(k(), null, 1, null);
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        M5.m.e(hVar, "other");
        int iY = y();
        int iY2 = hVar.y();
        int iMin = Math.min(iY, iY2);
        for (int i7 = 0; i7 < iMin; i7++) {
            int iJ = j(i7) & 255;
            int iJ2 = hVar.j(i7) & 255;
            if (iJ != iJ2) {
                return iJ < iJ2 ? -1 : 1;
            }
        }
        if (iY == iY2) {
            return 0;
        }
        return iY < iY2 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.y() == k().length && hVar.u(0, k(), 0, k().length)) {
                return true;
            }
        }
        return false;
    }

    public h h(String str) throws NoSuchAlgorithmException {
        M5.m.e(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f23195l, 0, y());
        byte[] bArrDigest = messageDigest.digest();
        M5.m.d(bArrDigest, "digestBytes");
        return new h(bArrDigest);
    }

    public int hashCode() {
        int iL = l();
        if (iL != 0) {
            return iL;
        }
        int iHashCode = Arrays.hashCode(k());
        v(iHashCode);
        return iHashCode;
    }

    public final byte j(int i7) {
        return q(i7);
    }

    public final byte[] k() {
        return this.f23195l;
    }

    public final int l() {
        return this.f23196m;
    }

    public int m() {
        return k().length;
    }

    public final String n() {
        return this.f23197n;
    }

    public String o() {
        char[] cArr = new char[k().length * 2];
        int i7 = 0;
        for (byte b7 : k()) {
            int i8 = i7 + 1;
            cArr[i7] = w6.b.f()[(b7 >> 4) & 15];
            i7 += 2;
            cArr[i8] = w6.b.f()[b7 & 15];
        }
        return V5.w.p(cArr);
    }

    public byte[] p() {
        return k();
    }

    public byte q(int i7) {
        return k()[i7];
    }

    public final h r() {
        return h("MD5");
    }

    public boolean t(int i7, h hVar, int i8, int i9) {
        M5.m.e(hVar, "other");
        return hVar.u(i8, k(), i7, i9);
    }

    public String toString() {
        if (k().length == 0) {
            return "[size=0]";
        }
        int iC = w6.b.c(k(), 64);
        if (iC != -1) {
            String strC = C();
            String strSubstring = strC.substring(0, iC);
            M5.m.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strW = V5.w.w(V5.w.w(V5.w.w(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iC >= strC.length()) {
                return "[text=" + strW + ']';
            }
            return "[size=" + k().length + " text=" + strW + "…]";
        }
        if (k().length <= 64) {
            return "[hex=" + o() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(k().length);
        sb.append(" hex=");
        int iC2 = AbstractC1719b.c(this, 64);
        if (iC2 <= k().length) {
            if (iC2 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            sb.append((iC2 == k().length ? this : new h(C1880k.l(k(), 0, iC2))).o());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + k().length + ')').toString());
    }

    public boolean u(int i7, byte[] bArr, int i8, int i9) {
        M5.m.e(bArr, "other");
        return i7 >= 0 && i7 <= k().length - i9 && i8 >= 0 && i8 <= bArr.length - i9 && AbstractC1719b.a(k(), i7, bArr, i8, i9);
    }

    public final void v(int i7) {
        this.f23196m = i7;
    }

    public final void w(String str) {
        this.f23197n = str;
    }

    public final h x() {
        return h("SHA-256");
    }

    public final int y() {
        return m();
    }

    public final boolean z(h hVar) {
        M5.m.e(hVar, "prefix");
        return t(0, hVar, 0, hVar.y());
    }
}
