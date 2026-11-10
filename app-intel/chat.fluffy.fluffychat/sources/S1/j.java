package S1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f8156a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f8157b = {112, 114, 109, 0};

    public static void A(byte[] bArr, int i7, int i8, b bVar) {
        int iM = m(i7, i8, bVar.f8139g);
        int i9 = iM / 8;
        bArr[i9] = (byte) ((1 << (iM % 8)) | bArr[i9]);
    }

    public static void B(InputStream inputStream) {
        c.h(inputStream);
        int iJ = c.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            c.j(inputStream);
            for (int iJ2 = c.j(inputStream); iJ2 > 0; iJ2--) {
                c.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean C(OutputStream outputStream, byte[] bArr, b[] bVarArr) throws IOException {
        if (Arrays.equals(bArr, k.f8158a)) {
            P(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f8159b)) {
            O(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f8161d)) {
            M(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f8160c)) {
            N(outputStream, bVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, k.f8162e)) {
            return false;
        }
        L(outputStream, bVarArr);
        return true;
    }

    public static void D(OutputStream outputStream, b bVar) throws IOException {
        int[] iArr = bVar.f8140h;
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = iArr[i7];
            c.p(outputStream, i9 - i8);
            i7++;
            i8 = i9;
        }
    }

    public static l E(b[] bVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            c.p(byteArrayOutputStream, bVarArr.length);
            int i7 = 2;
            for (b bVar : bVarArr) {
                c.q(byteArrayOutputStream, bVar.f8135c);
                c.q(byteArrayOutputStream, bVar.f8136d);
                c.q(byteArrayOutputStream, bVar.f8139g);
                String strJ = j(bVar.f8133a, bVar.f8134b, k.f8158a);
                int iK = c.k(strJ);
                c.p(byteArrayOutputStream, iK);
                i7 = i7 + 14 + iK;
                c.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i7 == byteArray.length) {
                l lVar = new l(d.DEX_FILES, i7, byteArray, false);
                byteArrayOutputStream.close();
                return lVar;
            }
            throw c.c("Expected size " + i7 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void F(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f8156a);
        outputStream.write(bArr);
    }

    public static void G(OutputStream outputStream, b bVar) throws IOException {
        K(outputStream, bVar);
        D(outputStream, bVar);
        I(outputStream, bVar);
    }

    public static void H(OutputStream outputStream, b bVar, String str) throws IOException {
        c.p(outputStream, c.k(str));
        c.p(outputStream, bVar.f8137e);
        c.q(outputStream, bVar.f8138f);
        c.q(outputStream, bVar.f8135c);
        c.q(outputStream, bVar.f8139g);
        c.n(outputStream, str);
    }

    public static void I(OutputStream outputStream, b bVar) throws IOException {
        byte[] bArr = new byte[k(bVar.f8139g)];
        for (Map.Entry entry : bVar.f8141i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                A(bArr, 2, iIntValue, bVar);
            }
            if ((iIntValue2 & 4) != 0) {
                A(bArr, 4, iIntValue, bVar);
            }
        }
        outputStream.write(bArr);
    }

    public static void J(OutputStream outputStream, int i7, b bVar) throws IOException {
        byte[] bArr = new byte[l(i7, bVar.f8139g)];
        for (Map.Entry entry : bVar.f8141i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i8 = 0;
            for (int i9 = 1; i9 <= 4; i9 <<= 1) {
                if (i9 != 1 && (i9 & i7) != 0) {
                    if ((i9 & iIntValue2) == i9) {
                        int i10 = (bVar.f8139g * i8) + iIntValue;
                        int i11 = i10 / 8;
                        bArr[i11] = (byte) ((1 << (i10 % 8)) | bArr[i11]);
                    }
                    i8++;
                }
            }
        }
        outputStream.write(bArr);
    }

    public static void K(OutputStream outputStream, b bVar) throws IOException {
        int i7 = 0;
        for (Map.Entry entry : bVar.f8141i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                c.p(outputStream, iIntValue - i7);
                c.p(outputStream, 0);
                i7 = iIntValue;
            }
        }
    }

    public static void L(OutputStream outputStream, b[] bVarArr) throws IOException {
        c.p(outputStream, bVarArr.length);
        for (b bVar : bVarArr) {
            String strJ = j(bVar.f8133a, bVar.f8134b, k.f8162e);
            c.p(outputStream, c.k(strJ));
            c.p(outputStream, bVar.f8141i.size());
            c.p(outputStream, bVar.f8140h.length);
            c.q(outputStream, bVar.f8135c);
            c.n(outputStream, strJ);
            Iterator it = bVar.f8141i.keySet().iterator();
            while (it.hasNext()) {
                c.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i7 : bVar.f8140h) {
                c.p(outputStream, i7);
            }
        }
    }

    public static void M(OutputStream outputStream, b[] bVarArr) throws IOException {
        c.r(outputStream, bVarArr.length);
        for (b bVar : bVarArr) {
            int size = bVar.f8141i.size() * 4;
            String strJ = j(bVar.f8133a, bVar.f8134b, k.f8161d);
            c.p(outputStream, c.k(strJ));
            c.p(outputStream, bVar.f8140h.length);
            c.q(outputStream, size);
            c.q(outputStream, bVar.f8135c);
            c.n(outputStream, strJ);
            Iterator it = bVar.f8141i.keySet().iterator();
            while (it.hasNext()) {
                c.p(outputStream, ((Integer) it.next()).intValue());
                c.p(outputStream, 0);
            }
            for (int i7 : bVar.f8140h) {
                c.p(outputStream, i7);
            }
        }
    }

    public static void N(OutputStream outputStream, b[] bVarArr) throws IOException {
        byte[] bArrB = b(bVarArr, k.f8160c);
        c.r(outputStream, bVarArr.length);
        c.m(outputStream, bArrB);
    }

    public static void O(OutputStream outputStream, b[] bVarArr) throws IOException {
        byte[] bArrB = b(bVarArr, k.f8159b);
        c.r(outputStream, bVarArr.length);
        c.m(outputStream, bArrB);
    }

    public static void P(OutputStream outputStream, b[] bVarArr) throws IOException {
        Q(outputStream, bVarArr);
    }

    public static void Q(OutputStream outputStream, b[] bVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(E(bVarArr));
        arrayList.add(c(bVarArr));
        arrayList.add(d(bVarArr));
        long length2 = k.f8158a.length + f8156a.length + 4 + (arrayList.size() * 16);
        c.q(outputStream, arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            l lVar = (l) arrayList.get(i7);
            c.q(outputStream, lVar.f8165a.d());
            c.q(outputStream, length2);
            if (lVar.f8168d) {
                byte[] bArr = lVar.f8167c;
                long length3 = bArr.length;
                byte[] bArrB = c.b(bArr);
                arrayList2.add(bArrB);
                c.q(outputStream, bArrB.length);
                c.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(lVar.f8167c);
                c.q(outputStream, lVar.f8167c.length);
                c.q(outputStream, 0L);
                length = lVar.f8167c.length;
            }
            length2 += length;
        }
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            outputStream.write((byte[]) arrayList2.get(i8));
        }
    }

    public static int a(b bVar) {
        Iterator it = bVar.f8141i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    public static byte[] b(b[] bVarArr, byte[] bArr) throws IOException {
        int i7 = 0;
        int iK = 0;
        for (b bVar : bVarArr) {
            iK += c.k(j(bVar.f8133a, bVar.f8134b, bArr)) + 16 + (bVar.f8137e * 2) + bVar.f8138f + k(bVar.f8139g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, k.f8160c)) {
            int length = bVarArr.length;
            while (i7 < length) {
                b bVar2 = bVarArr[i7];
                H(byteArrayOutputStream, bVar2, j(bVar2.f8133a, bVar2.f8134b, bArr));
                G(byteArrayOutputStream, bVar2);
                i7++;
            }
        } else {
            for (b bVar3 : bVarArr) {
                H(byteArrayOutputStream, bVar3, j(bVar3.f8133a, bVar3.f8134b, bArr));
            }
            int length2 = bVarArr.length;
            while (i7 < length2) {
                G(byteArrayOutputStream, bVarArr[i7]);
                i7++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw c.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static l c(b[] bVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 0;
        for (int i8 = 0; i8 < bVarArr.length; i8++) {
            try {
                b bVar = bVarArr[i8];
                c.p(byteArrayOutputStream, i8);
                c.p(byteArrayOutputStream, bVar.f8137e);
                i7 = i7 + 4 + (bVar.f8137e * 2);
                D(byteArrayOutputStream, bVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i7 == byteArray.length) {
            l lVar = new l(d.CLASSES, i7, byteArray, true);
            byteArrayOutputStream.close();
            return lVar;
        }
        throw c.c("Expected size " + i7 + ", does not match actual size " + byteArray.length);
    }

    public static l d(b[] bVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 0;
        for (int i8 = 0; i8 < bVarArr.length; i8++) {
            try {
                b bVar = bVarArr[i8];
                int iA = a(bVar);
                byte[] bArrE = e(iA, bVar);
                byte[] bArrF = f(bVar);
                c.p(byteArrayOutputStream, i8);
                int length = bArrE.length + 2 + bArrF.length;
                c.q(byteArrayOutputStream, length);
                c.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i7 = i7 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i7 == byteArray.length) {
            l lVar = new l(d.METHODS, i7, byteArray, true);
            byteArrayOutputStream.close();
            return lVar;
        }
        throw c.c("Expected size " + i7 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(int i7, b bVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            J(byteArrayOutputStream, i7, bVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] f(b bVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            K(byteArrayOutputStream, bVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    public static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    public static b i(b[] bVarArr, String str) {
        if (bVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            if (bVarArr[i7].f8134b.equals(strH)) {
                return bVarArr[i7];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String strA = k.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + k.a(bArr) + str2;
    }

    public static int k(int i7) {
        return z(i7 * 2) / 8;
    }

    public static int l(int i7, int i8) {
        return z(Integer.bitCount(i7 & (-2)) * i8) / 8;
    }

    public static int m(int i7, int i8, int i9) {
        if (i7 == 1) {
            throw c.c("HOT methods are not stored in the bitmap");
        }
        if (i7 == 2) {
            return i8;
        }
        if (i7 == 4) {
            return i8 + i9;
        }
        throw c.c("Unexpected flag: " + i7);
    }

    public static int[] n(InputStream inputStream, int i7) {
        int[] iArr = new int[i7];
        int iH = 0;
        for (int i8 = 0; i8 < i7; i8++) {
            iH += c.h(inputStream);
            iArr[i8] = iH;
        }
        return iArr;
    }

    public static int o(BitSet bitSet, int i7, int i8) {
        int i9 = bitSet.get(m(2, i7, i8)) ? 2 : 0;
        return bitSet.get(m(4, i7, i8)) ? i9 | 4 : i9;
    }

    public static byte[] p(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, c.d(inputStream, bArr.length))) {
            return c.d(inputStream, k.f8159b.length);
        }
        throw c.c("Invalid magic");
    }

    public static void q(InputStream inputStream, b bVar) {
        int iAvailable = inputStream.available() - bVar.f8138f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += c.h(inputStream);
            bVar.f8141i.put(Integer.valueOf(iH), 1);
            for (int iH2 = c.h(inputStream); iH2 > 0; iH2--) {
                B(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw c.c("Read too much data during profile line parse");
        }
    }

    public static b[] r(InputStream inputStream, byte[] bArr, byte[] bArr2, b[] bVarArr) {
        if (Arrays.equals(bArr, k.f8163f)) {
            if (Arrays.equals(k.f8158a, bArr2)) {
                throw c.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return s(inputStream, bArr, bVarArr);
        }
        if (Arrays.equals(bArr, k.f8164g)) {
            return u(inputStream, bArr2, bVarArr);
        }
        throw c.c("Unsupported meta version");
    }

    public static b[] s(InputStream inputStream, byte[] bArr, b[] bVarArr) throws IOException {
        if (!Arrays.equals(bArr, k.f8163f)) {
            throw c.c("Unsupported meta version");
        }
        int iJ = c.j(inputStream);
        byte[] bArrE = c.e(inputStream, (int) c.i(inputStream), (int) c.i(inputStream));
        if (inputStream.read() > 0) {
            throw c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            b[] bVarArrT = t(byteArrayInputStream, iJ, bVarArr);
            byteArrayInputStream.close();
            return bVarArrT;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static b[] t(InputStream inputStream, int i7, b[] bVarArr) {
        if (inputStream.available() == 0) {
            return new b[0];
        }
        if (i7 != bVarArr.length) {
            throw c.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i7];
        int[] iArr = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            int iH = c.h(inputStream);
            iArr[i8] = c.h(inputStream);
            strArr[i8] = c.f(inputStream, iH);
        }
        for (int i9 = 0; i9 < i7; i9++) {
            b bVar = bVarArr[i9];
            if (!bVar.f8134b.equals(strArr[i9])) {
                throw c.c("Order of dexfiles in metadata did not match baseline");
            }
            int i10 = iArr[i9];
            bVar.f8137e = i10;
            bVar.f8140h = n(inputStream, i10);
        }
        return bVarArr;
    }

    public static b[] u(InputStream inputStream, byte[] bArr, b[] bVarArr) throws IOException {
        int iH = c.h(inputStream);
        byte[] bArrE = c.e(inputStream, (int) c.i(inputStream), (int) c.i(inputStream));
        if (inputStream.read() > 0) {
            throw c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            b[] bVarArrV = v(byteArrayInputStream, bArr, iH, bVarArr);
            byteArrayInputStream.close();
            return bVarArrV;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static b[] v(InputStream inputStream, byte[] bArr, int i7, b[] bVarArr) {
        if (inputStream.available() == 0) {
            return new b[0];
        }
        if (i7 != bVarArr.length) {
            throw c.c("Mismatched number of dex files found in metadata");
        }
        for (int i8 = 0; i8 < i7; i8++) {
            c.h(inputStream);
            String strF = c.f(inputStream, c.h(inputStream));
            long jI = c.i(inputStream);
            int iH = c.h(inputStream);
            b bVarI = i(bVarArr, strF);
            if (bVarI == null) {
                throw c.c("Missing profile key: " + strF);
            }
            bVarI.f8136d = jI;
            int[] iArrN = n(inputStream, iH);
            if (Arrays.equals(bArr, k.f8162e)) {
                bVarI.f8137e = iH;
                bVarI.f8140h = iArrN;
            }
        }
        return bVarArr;
    }

    public static void w(InputStream inputStream, b bVar) {
        BitSet bitSetValueOf = BitSet.valueOf(c.d(inputStream, c.a(bVar.f8139g * 2)));
        int i7 = 0;
        while (true) {
            int i8 = bVar.f8139g;
            if (i7 >= i8) {
                return;
            }
            int iO = o(bitSetValueOf, i7, i8);
            if (iO != 0) {
                Integer num = (Integer) bVar.f8141i.get(Integer.valueOf(i7));
                if (num == null) {
                    num = 0;
                }
                bVar.f8141i.put(Integer.valueOf(i7), Integer.valueOf(iO | num.intValue()));
            }
            i7++;
        }
    }

    public static b[] x(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, k.f8159b)) {
            throw c.c("Unsupported version");
        }
        int iJ = c.j(inputStream);
        byte[] bArrE = c.e(inputStream, (int) c.i(inputStream), (int) c.i(inputStream));
        if (inputStream.read() > 0) {
            throw c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            b[] bVarArrY = y(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return bVarArrY;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static b[] y(InputStream inputStream, String str, int i7) {
        if (inputStream.available() == 0) {
            return new b[0];
        }
        b[] bVarArr = new b[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            int iH = c.h(inputStream);
            int iH2 = c.h(inputStream);
            bVarArr[i8] = new b(str, c.f(inputStream, iH), c.i(inputStream), 0L, iH2, (int) c.i(inputStream), (int) c.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i9 = 0; i9 < i7; i9++) {
            b bVar = bVarArr[i9];
            q(inputStream, bVar);
            bVar.f8140h = n(inputStream, bVar.f8137e);
            w(inputStream, bVar);
        }
        return bVarArr;
    }

    public static int z(int i7) {
        return (i7 + 7) & (-8);
    }
}
