package Y;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9359a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static char[] f9360b = new char[24];

    public static int a(int i7, int i8, boolean z7, int i9) {
        if (i7 > 99 || (z7 && i9 >= 3)) {
            return i8 + 3;
        }
        if (i7 > 9 || (z7 && i9 >= 2)) {
            return i8 + 2;
        }
        if (z7 || i7 > 0) {
            return i8 + 1;
        }
        return 0;
    }

    public static void b(long j7, StringBuilder sb) {
        synchronized (f9359a) {
            sb.append(f9360b, 0, c(j7, 0));
        }
    }

    public static int c(long j7, int i7) {
        char c7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j8 = j7;
        if (f9360b.length < i7) {
            f9360b = new char[i7];
        }
        char[] cArr = f9360b;
        if (j8 == 0) {
            int i12 = i7 - 1;
            while (i12 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j8 > 0) {
            c7 = '+';
        } else {
            j8 = -j8;
            c7 = '-';
        }
        int i13 = (int) (j8 % 1000);
        int iFloor = (int) Math.floor(j8 / 1000);
        if (iFloor > 86400) {
            i8 = iFloor / 86400;
            iFloor -= 86400 * i8;
        } else {
            i8 = 0;
        }
        if (iFloor > 3600) {
            i9 = iFloor / 3600;
            iFloor -= i9 * 3600;
        } else {
            i9 = 0;
        }
        if (iFloor > 60) {
            int i14 = iFloor / 60;
            iFloor -= i14 * 60;
            i10 = i14;
        } else {
            i10 = 0;
        }
        if (i7 != 0) {
            int iA = a(i8, 1, false, 0);
            int iA2 = iA + a(i9, 1, iA > 0, 2);
            int iA3 = iA2 + a(i10, 1, iA2 > 0, 2);
            int iA4 = iA3 + a(iFloor, 1, iA3 > 0, 2);
            i11 = 0;
            for (int iA5 = iA4 + a(i13, 2, true, iA4 > 0 ? 3 : 0) + 1; iA5 < i7; iA5++) {
                cArr[i11] = ' ';
                i11++;
            }
        } else {
            i11 = 0;
        }
        cArr[i11] = c7;
        int i15 = i11 + 1;
        boolean z7 = i7 != 0;
        int iD = d(cArr, i8, 'd', i15, false, 0);
        int iD2 = d(cArr, i9, 'h', iD, iD != i15, z7 ? 2 : 0);
        int iD3 = d(cArr, i10, 'm', iD2, iD2 != i15, z7 ? 2 : 0);
        int iD4 = d(cArr, iFloor, 's', iD3, iD3 != i15, z7 ? 2 : 0);
        int iD5 = d(cArr, i13, 'm', iD4, true, (!z7 || iD4 == i15) ? 0 : 3);
        cArr[iD5] = 's';
        return iD5 + 1;
    }

    public static int d(char[] cArr, int i7, char c7, int i8, boolean z7, int i9) {
        int i10;
        if (!z7 && i7 <= 0) {
            return i8;
        }
        if ((!z7 || i9 < 3) && i7 <= 99) {
            i10 = i8;
        } else {
            int i11 = i7 / 100;
            cArr[i8] = (char) (i11 + 48);
            i10 = i8 + 1;
            i7 -= i11 * 100;
        }
        if ((z7 && i9 >= 2) || i7 > 9 || i8 != i10) {
            int i12 = i7 / 10;
            cArr[i10] = (char) (i12 + 48);
            i10++;
            i7 -= i12 * 10;
        }
        cArr[i10] = (char) (i7 + 48);
        cArr[i10 + 1] = c7;
        return i10 + 2;
    }
}
