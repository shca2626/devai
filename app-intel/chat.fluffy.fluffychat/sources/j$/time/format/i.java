package j$.time.format;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;

/* loaded from: classes2.dex */
public final class i implements e {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f18293d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e, reason: collision with root package name */
    public static final i f18294e = new i("+HH:MM:ss", "Z");

    /* renamed from: f, reason: collision with root package name */
    public static final i f18295f = new i("+HH:MM:ss", "0");

    /* renamed from: a, reason: collision with root package name */
    public final String f18296a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18297b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18298c;

    public i(String str, String str2) {
        for (int i7 = 0; i7 < 22; i7++) {
            if (f18293d[i7].equals(str)) {
                this.f18297b = i7;
                this.f18298c = i7 % 11;
                this.f18296a = str2;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        Long lA = sVar.a(j$.time.temporal.a.OFFSET_SECONDS);
        boolean z7 = false;
        if (lA == null) {
            return false;
        }
        int intExact = Math.toIntExact(lA.longValue());
        String str = this.f18296a;
        if (intExact == 0) {
            sb.append(str);
            return true;
        }
        int iAbs = Math.abs((intExact / 3600) % 100);
        int iAbs2 = Math.abs((intExact / 60) % 60);
        int iAbs3 = Math.abs(intExact % 60);
        int length = sb.length();
        sb.append(intExact < 0 ? "-" : "+");
        if (this.f18297b < 11 || iAbs >= 10) {
            a(false, iAbs, sb);
        } else {
            sb.append((char) (iAbs + 48));
        }
        int i7 = this.f18298c;
        if ((i7 >= 3 && i7 <= 8) || ((i7 >= 9 && iAbs3 > 0) || (i7 >= 1 && iAbs2 > 0))) {
            a(i7 > 0 && i7 % 2 == 0, iAbs2, sb);
            iAbs += iAbs2;
            if (i7 == 7 || i7 == 8 || (i7 >= 5 && iAbs3 > 0)) {
                if (i7 > 0 && i7 % 2 == 0) {
                    z7 = true;
                }
                a(z7, iAbs3, sb);
                iAbs += iAbs3;
            }
        }
        if (iAbs == 0) {
            sb.setLength(length);
            sb.append(str);
        }
        return true;
    }

    public static void a(boolean z7, int i7, StringBuilder sb) {
        sb.append(z7 ? ":" : "");
        sb.append((char) ((i7 / 10) + 48));
        sb.append((char) ((i7 % 10) + 48));
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i7) {
        CharSequence charSequence2;
        int i8;
        int i9;
        int i10;
        int i11;
        int length = charSequence.length();
        int length2 = this.f18296a.length();
        if (length2 == 0) {
            if (i7 == length) {
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i7, i7);
            }
            charSequence2 = charSequence;
        } else {
            if (i7 == length) {
                return ~i7;
            }
            charSequence2 = charSequence;
            if (pVar.g(charSequence2, i7, this.f18296a, 0, length2)) {
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i7, i7 + length2);
            }
        }
        char cCharAt = charSequence.charAt(i7);
        if (cCharAt == '+' || cCharAt == '-') {
            int i12 = cCharAt == '-' ? -1 : 1;
            int i13 = this.f18298c;
            boolean z7 = i13 > 0 && i13 % 2 == 0;
            int i14 = this.f18297b;
            boolean z8 = i14 < 11;
            int[] iArr = new int[4];
            iArr[0] = i7 + 1;
            if (!pVar.f18318c) {
                if (z8) {
                    if (z7 || (i14 == 0 && length > (i11 = i7 + 3) && charSequence2.charAt(i11) == ':')) {
                        i14 = 10;
                        z7 = true;
                    } else {
                        i14 = 9;
                    }
                } else if (z7 || (i14 == 11 && length > (i10 = i7 + 3) && (charSequence2.charAt(i7 + 2) == ':' || charSequence2.charAt(i10) == ':'))) {
                    i14 = 21;
                    z7 = true;
                } else {
                    i14 = 20;
                }
            }
            switch (i14) {
                case 0:
                case 11:
                    c(charSequence2, z8, iArr);
                    break;
                case 1:
                case 2:
                case 13:
                    c(charSequence2, z8, iArr);
                    d(charSequence2, z7, false, iArr);
                    break;
                case 3:
                case 4:
                case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                    c(charSequence2, z8, iArr);
                    d(charSequence2, z7, true, iArr);
                    break;
                case 5:
                case 6:
                case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                    c(charSequence2, z8, iArr);
                    d(charSequence2, z7, true, iArr);
                    b(charSequence2, z7, 3, iArr);
                    break;
                case 7:
                case 8:
                case 19:
                    c(charSequence2, z8, iArr);
                    d(charSequence2, z7, true, iArr);
                    if (!b(charSequence2, z7, 3, iArr)) {
                        iArr[0] = ~iArr[0];
                        break;
                    }
                    break;
                case 9:
                case 10:
                case 21:
                    c(charSequence2, z8, iArr);
                    if (b(charSequence2, z7, 2, iArr)) {
                        b(charSequence2, z7, 3, iArr);
                        break;
                    }
                    break;
                case 12:
                    e(charSequence2, 1, 4, iArr);
                    break;
                case StdKeyDeserializer.TYPE_URL /* 14 */:
                    e(charSequence2, 3, 4, iArr);
                    break;
                case 16:
                    e(charSequence2, 3, 6, iArr);
                    break;
                case 18:
                    e(charSequence2, 5, 6, iArr);
                    break;
                case 20:
                    e(charSequence2, 1, 6, iArr);
                    break;
            }
            int i15 = iArr[0];
            if (i15 > 0) {
                int i16 = iArr[1];
                if (i16 > 23 || (i8 = iArr[2]) > 59 || (i9 = iArr[3]) > 59) {
                    throw new j$.time.c("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
                return pVar.f(j$.time.temporal.a.OFFSET_SECONDS, ((i8 * 60) + (i16 * 3600) + i9) * i12, i7, i15);
            }
        }
        return length2 == 0 ? pVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i7, i7) : ~i7;
    }

    public static void c(CharSequence charSequence, boolean z7, int[] iArr) {
        if (z7) {
            if (b(charSequence, false, 1, iArr)) {
                return;
            }
            iArr[0] = ~iArr[0];
            return;
        }
        e(charSequence, 1, 2, iArr);
    }

    public static void d(CharSequence charSequence, boolean z7, boolean z8, int[] iArr) {
        if (b(charSequence, z7, 2, iArr) || !z8) {
            return;
        }
        iArr[0] = ~iArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(java.lang.CharSequence r5, boolean r6, int r7, int[] r8) {
        /*
            r0 = 0
            r1 = r8[r0]
            r2 = 1
            if (r1 >= 0) goto L7
            return r2
        L7:
            if (r6 == 0) goto L1d
            if (r7 == r2) goto L1d
            int r6 = r1 + 1
            int r3 = r5.length()
            if (r6 > r3) goto L4e
            char r1 = r5.charAt(r1)
            r3 = 58
            if (r1 == r3) goto L1c
            goto L4e
        L1c:
            r1 = r6
        L1d:
            int r6 = r1 + 2
            int r3 = r5.length()
            if (r6 <= r3) goto L26
            goto L4e
        L26:
            int r3 = r1 + 1
            char r1 = r5.charAt(r1)
            char r5 = r5.charAt(r3)
            r3 = 48
            if (r1 < r3) goto L4e
            r4 = 57
            if (r1 > r4) goto L4e
            if (r5 < r3) goto L4e
            if (r5 <= r4) goto L3d
            goto L4e
        L3d:
            int r1 = r1 - r3
            int r1 = r1 * 10
            int r5 = r5 - r3
            int r5 = r5 + r1
            if (r5 < 0) goto L4e
            r1 = 59
            if (r5 <= r1) goto L49
            goto L4e
        L49:
            r8[r7] = r5
            r8[r0] = r6
            return r2
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.i.b(java.lang.CharSequence, boolean, int, int[]):boolean");
    }

    public static void e(CharSequence charSequence, int i7, int i8, int[] iArr) {
        int i9;
        char cCharAt;
        int i10 = iArr[0];
        char[] cArr = new char[i8];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i8 && (i9 = i10 + 1) <= charSequence.length() && (cCharAt = charSequence.charAt(i10)) >= '0' && cCharAt <= '9') {
            cArr[i11] = cCharAt;
            i12++;
            i11++;
            i10 = i9;
        }
        if (i12 < i7) {
            iArr[0] = ~iArr[0];
            return;
        }
        switch (i12) {
            case 1:
                iArr[1] = cArr[0] - '0';
                break;
            case 2:
                iArr[1] = (cArr[1] - '0') + ((cArr[0] - '0') * 10);
                break;
            case 3:
                iArr[1] = cArr[0] - '0';
                iArr[2] = (cArr[2] - '0') + ((cArr[1] - '0') * 10);
                break;
            case 4:
                iArr[1] = (cArr[1] - '0') + ((cArr[0] - '0') * 10);
                iArr[2] = (cArr[3] - '0') + ((cArr[2] - '0') * 10);
                break;
            case 5:
                iArr[1] = cArr[0] - '0';
                iArr[2] = (cArr[2] - '0') + ((cArr[1] - '0') * 10);
                iArr[3] = (cArr[4] - '0') + ((cArr[3] - '0') * 10);
                break;
            case 6:
                iArr[1] = (cArr[1] - '0') + ((cArr[0] - '0') * 10);
                iArr[2] = (cArr[3] - '0') + ((cArr[2] - '0') * 10);
                iArr[3] = (cArr[5] - '0') + ((cArr[4] - '0') * 10);
                break;
        }
        iArr[0] = i10;
    }

    public final String toString() {
        String strReplace = this.f18296a.replace("'", "''");
        return "Offset(" + f18293d[this.f18297b] + ",'" + strReplace + "')";
    }
}
