package N3;

import D3.f;
import J3.h;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f6377a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f6378b;

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f6379c;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f6380d;

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f6381e;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6382a;

        static {
            int[] iArr = new int[b.values().length];
            f6382a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6382a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6382a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6382a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6382a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6382a[b.ECI_ENCODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        ECI_ENCODE
    }

    static {
        char[] cArr = {'!', JsonFactory.DEFAULT_QUOTE_CHAR, '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', JsonPointer.SEPARATOR, ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f6378b = cArr;
        f6379c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f6380d = cArr;
        f6381e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static J3.e a(byte[] r17) throws D3.f {
        /*
            r0 = 5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r2 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            J3.c r4 = new J3.c
            r6 = r17
            r4.<init>(r6)
            J3.h r5 = new J3.h
            r7 = 100
            r5.<init>(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r7.<init>(r8)
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r10.<init>(r11)
            N3.c$b r13 = N3.c.b.ASCII_ENCODE
            java.util.HashSet r14 = new java.util.HashSet
            r14.<init>()
        L33:
            N3.c$b r15 = N3.c.b.ASCII_ENCODE
            if (r13 != r15) goto L3c
            N3.c$b r13 = c(r4, r5, r7, r14)
            goto L65
        L3c:
            int[] r16 = N3.c.a.f6382a
            int r13 = r13.ordinal()
            r13 = r16[r13]
            switch(r13) {
                case 1: goto L61;
                case 2: goto L5d;
                case 3: goto L59;
                case 4: goto L55;
                case 5: goto L51;
                case 6: goto L4c;
                default: goto L47;
            }
        L47:
            D3.f r0 = D3.f.a()
            throw r0
        L4c:
            f(r4, r5)
            r8 = r11
            goto L64
        L51:
            d(r4, r5, r10)
            goto L64
        L55:
            g(r4, r5)
            goto L64
        L59:
            b(r4, r5)
            goto L64
        L5d:
            h(r4, r5, r14)
            goto L64
        L61:
            e(r4, r5, r14)
        L64:
            r13 = r15
        L65:
            N3.c$b r15 = N3.c.b.PAD_ENCODE
            if (r13 == r15) goto L6f
            int r15 = r4.a()
            if (r15 > 0) goto L33
        L6f:
            int r4 = r7.length()
            if (r4 <= 0) goto L78
            r5.e(r7)
        L78:
            if (r8 == 0) goto L99
            boolean r4 = r14.contains(r9)
            if (r4 != 0) goto L95
            boolean r3 = r14.contains(r3)
            if (r3 == 0) goto L87
            goto L95
        L87:
            boolean r0 = r14.contains(r12)
            if (r0 != 0) goto L97
            boolean r0 = r14.contains(r1)
            if (r0 == 0) goto L94
            goto L97
        L94:
            r0 = r2
        L95:
            r1 = r5
            goto Lba
        L97:
            r0 = 6
            goto L95
        L99:
            boolean r0 = r14.contains(r9)
            if (r0 != 0) goto Lb8
            boolean r0 = r14.contains(r3)
            if (r0 == 0) goto La6
            goto Lb8
        La6:
            boolean r0 = r14.contains(r12)
            if (r0 != 0) goto Lb6
            boolean r0 = r14.contains(r1)
            if (r0 == 0) goto Lb3
            goto Lb6
        Lb3:
            r1 = r5
            r0 = r11
            goto Lba
        Lb6:
            r0 = 3
            goto L95
        Lb8:
            r0 = 2
            goto L95
        Lba:
            J3.e r5 = new J3.e
            java.lang.String r7 = r1.toString()
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto Lc7
            r10 = 0
        Lc7:
            r8 = r10
            r9 = 0
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.c.a(byte[]):J3.e");
    }

    public static void b(J3.c cVar, h hVar) throws f {
        int iD;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i7 = 0; i7 < 3; i7++) {
                int i8 = iArr[i7];
                if (i8 == 0) {
                    hVar.b('\r');
                } else if (i8 == 1) {
                    hVar.b('*');
                } else if (i8 == 2) {
                    hVar.b('>');
                } else if (i8 == 3) {
                    hVar.b(' ');
                } else if (i8 < 14) {
                    hVar.b((char) (i8 + 44));
                } else {
                    if (i8 >= 40) {
                        throw f.a();
                    }
                    hVar.b((char) (i8 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static b c(J3.c cVar, h hVar, StringBuilder sb, Set set) throws f {
        boolean z7 = false;
        do {
            int iD = cVar.d(8);
            if (iD == 0) {
                throw f.a();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case 230:
                                return b.C40_ENCODE;
                            case 231:
                                return b.BASE256_ENCODE;
                            case 232:
                                set.add(Integer.valueOf(hVar.i()));
                                hVar.b((char) 29);
                                break;
                            case 233:
                            case 234:
                                break;
                            case 235:
                                z7 = true;
                                break;
                            case 236:
                                hVar.d("[)>\u001e05\u001d");
                                sb.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                hVar.d("[)>\u001e06\u001d");
                                sb.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return b.ANSIX12_ENCODE;
                            case 239:
                                return b.TEXT_ENCODE;
                            case 240:
                                return b.EDIFACT_ENCODE;
                            case 241:
                                return b.ECI_ENCODE;
                            default:
                                if (iD != 254 || cVar.a() != 0) {
                                    throw f.a();
                                }
                                break;
                        }
                    } else {
                        int i7 = iD - 130;
                        if (i7 < 10) {
                            hVar.b('0');
                        }
                        hVar.c(i7);
                    }
                } else {
                    return b.PAD_ENCODE;
                }
            } else {
                if (z7) {
                    iD += 128;
                }
                hVar.b((char) (iD - 1));
                return b.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    public static void d(J3.c cVar, h hVar, Collection collection) throws f {
        int iC = cVar.c();
        int i7 = iC + 2;
        int iJ = j(cVar.d(8), iC + 1);
        if (iJ == 0) {
            iJ = cVar.a() / 8;
        } else if (iJ >= 250) {
            iJ = ((iJ - 249) * 250) + j(cVar.d(8), i7);
            i7 = iC + 3;
        }
        if (iJ < 0) {
            throw f.a();
        }
        byte[] bArr = new byte[iJ];
        int i8 = 0;
        while (i8 < iJ) {
            if (cVar.a() < 8) {
                throw f.a();
            }
            bArr[i8] = (byte) j(cVar.d(8), i7);
            i8++;
            i7++;
        }
        collection.add(bArr);
        hVar.d(new String(bArr, StandardCharsets.ISO_8859_1));
    }

    public static void e(J3.c cVar, h hVar, Set set) throws f {
        int iD;
        int[] iArr = new int[3];
        boolean z7 = false;
        int i7 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i8 = 0; i8 < 3; i8++) {
                int i9 = iArr[i8];
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 == 2) {
                            char[] cArr = f6378b;
                            if (i9 < cArr.length) {
                                char c7 = cArr[i9];
                                if (z7) {
                                    hVar.b((char) (c7 + 128));
                                    z7 = false;
                                } else {
                                    hVar.b(c7);
                                }
                            } else if (i9 == 27) {
                                set.add(Integer.valueOf(hVar.i()));
                                hVar.b((char) 29);
                            } else {
                                if (i9 != 30) {
                                    throw f.a();
                                }
                                z7 = true;
                            }
                            i7 = 0;
                        } else {
                            if (i7 != 3) {
                                throw f.a();
                            }
                            if (z7) {
                                hVar.b((char) (i9 + 224));
                                z7 = false;
                                i7 = 0;
                            } else {
                                hVar.b((char) (i9 + 96));
                                i7 = 0;
                            }
                        }
                    } else if (z7) {
                        hVar.b((char) (i9 + 128));
                        z7 = false;
                        i7 = 0;
                    } else {
                        hVar.b((char) i9);
                        i7 = 0;
                    }
                } else if (i9 < 3) {
                    i7 = i9 + 1;
                } else {
                    char[] cArr2 = f6377a;
                    if (i9 >= cArr2.length) {
                        throw f.a();
                    }
                    char c8 = cArr2[i9];
                    if (z7) {
                        hVar.b((char) (c8 + 128));
                        z7 = false;
                    } else {
                        hVar.b(c8);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void f(J3.c cVar, h hVar) throws f {
        if (cVar.a() < 8) {
            throw f.a();
        }
        int iD = cVar.d(8);
        if (iD <= 127) {
            hVar.f(iD - 1);
        }
    }

    public static void g(J3.c cVar, h hVar) {
        while (cVar.a() > 16) {
            for (int i7 = 0; i7 < 4; i7++) {
                int iD = cVar.d(6);
                if (iD == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                hVar.b((char) iD);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void h(J3.c cVar, h hVar, Set set) throws f {
        int iD;
        int[] iArr = new int[3];
        boolean z7 = false;
        int i7 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            i(iD, cVar.d(8), iArr);
            for (int i8 = 0; i8 < 3; i8++) {
                int i9 = iArr[i8];
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 == 2) {
                            char[] cArr = f6380d;
                            if (i9 < cArr.length) {
                                char c7 = cArr[i9];
                                if (z7) {
                                    hVar.b((char) (c7 + 128));
                                    z7 = false;
                                } else {
                                    hVar.b(c7);
                                }
                            } else if (i9 == 27) {
                                set.add(Integer.valueOf(hVar.i()));
                                hVar.b((char) 29);
                            } else {
                                if (i9 != 30) {
                                    throw f.a();
                                }
                                z7 = true;
                            }
                            i7 = 0;
                        } else {
                            if (i7 != 3) {
                                throw f.a();
                            }
                            char[] cArr2 = f6381e;
                            if (i9 >= cArr2.length) {
                                throw f.a();
                            }
                            char c8 = cArr2[i9];
                            if (z7) {
                                hVar.b((char) (c8 + 128));
                                z7 = false;
                                i7 = 0;
                            } else {
                                hVar.b(c8);
                                i7 = 0;
                            }
                        }
                    } else if (z7) {
                        hVar.b((char) (i9 + 128));
                        z7 = false;
                        i7 = 0;
                    } else {
                        hVar.b((char) i9);
                        i7 = 0;
                    }
                } else if (i9 < 3) {
                    i7 = i9 + 1;
                } else {
                    char[] cArr3 = f6379c;
                    if (i9 >= cArr3.length) {
                        throw f.a();
                    }
                    char c9 = cArr3[i9];
                    if (z7) {
                        hVar.b((char) (c9 + 128));
                        z7 = false;
                    } else {
                        hVar.b(c9);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void i(int i7, int i8, int[] iArr) {
        int i9 = ((i7 << 8) + i8) - 1;
        int i10 = i9 / 1600;
        iArr[0] = i10;
        int i11 = i9 - (i10 * 1600);
        int i12 = i11 / 40;
        iArr[1] = i12;
        iArr[2] = i11 - (i12 * 40);
    }

    public static int j(int i7, int i8) {
        int i9 = i7 - (((i8 * 149) % 255) + 1);
        return i9 >= 0 ? i9 : i9 + 256;
    }
}
