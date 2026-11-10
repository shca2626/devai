package a4;

import J3.m;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f10792a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10793a;

        static {
            int[] iArr = new int[h.values().length];
            f10793a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10793a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10793a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10793a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10793a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10793a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10793a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10793a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10793a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10793a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ff A[LOOP:0: B:64:0x001e->B:61:0x00ff, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static J3.e a(byte[] r19, a4.j r20, a4.f r21, java.util.Map r22) throws D3.f {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.d.a(byte[], a4.j, a4.f, java.util.Map):J3.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(J3.c r3, java.lang.StringBuilder r4, int r5, boolean r6) throws D3.f {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.d(r2)
            int r2 = r1 / 45
            char r2 = h(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = h(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            D3.f r3 = D3.f.a()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.d(r2)
            char r3 = h(r3)
            r4.append(r3)
            goto L47
        L42:
            D3.f r3 = D3.f.a()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.d.b(J3.c, java.lang.StringBuilder, int, boolean):void");
    }

    public static void c(J3.c cVar, StringBuilder sb, int i7, J3.d dVar, Collection collection, Map map) throws D3.f {
        if (i7 * 8 > cVar.a()) {
            throw D3.f.a();
        }
        byte[] bArr = new byte[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            bArr[i8] = (byte) cVar.d(8);
        }
        sb.append(new String(bArr, dVar == null ? m.a(bArr, map) : dVar.e()));
        collection.add(bArr);
    }

    public static void d(J3.c cVar, StringBuilder sb, int i7) throws D3.f {
        if (m.f4798c == null) {
            throw D3.f.a();
        }
        if (i7 * 13 > cVar.a()) {
            throw D3.f.a();
        }
        byte[] bArr = new byte[i7 * 2];
        int i8 = 0;
        while (i7 > 0) {
            int iD = cVar.d(13);
            int i9 = (iD % 96) | ((iD / 96) << 8);
            int i10 = i9 + (i9 < 2560 ? 41377 : 42657);
            bArr[i8] = (byte) ((i10 >> 8) & 255);
            bArr[i8 + 1] = (byte) (i10 & 255);
            i8 += 2;
            i7--;
        }
        sb.append(new String(bArr, m.f4798c));
    }

    public static void e(J3.c cVar, StringBuilder sb, int i7) throws D3.f {
        if (i7 * 13 > cVar.a()) {
            throw D3.f.a();
        }
        byte[] bArr = new byte[i7 * 2];
        int i8 = 0;
        while (i7 > 0) {
            int iD = cVar.d(13);
            int i9 = (iD % 192) | ((iD / 192) << 8);
            int i10 = i9 + (i9 < 7936 ? 33088 : 49472);
            bArr[i8] = (byte) (i10 >> 8);
            bArr[i8 + 1] = (byte) i10;
            i8 += 2;
            i7--;
        }
        sb.append(new String(bArr, m.f4797b));
    }

    public static void f(J3.c cVar, StringBuilder sb, int i7) throws D3.f {
        while (i7 >= 3) {
            if (cVar.a() < 10) {
                throw D3.f.a();
            }
            int iD = cVar.d(10);
            if (iD >= 1000) {
                throw D3.f.a();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i7 -= 3;
        }
        if (i7 == 2) {
            if (cVar.a() < 7) {
                throw D3.f.a();
            }
            int iD2 = cVar.d(7);
            if (iD2 >= 100) {
                throw D3.f.a();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i7 == 1) {
            if (cVar.a() < 4) {
                throw D3.f.a();
            }
            int iD3 = cVar.d(4);
            if (iD3 >= 10) {
                throw D3.f.a();
            }
            sb.append(h(iD3));
        }
    }

    public static int g(J3.c cVar) throws D3.f {
        int iD = cVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return cVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return cVar.d(16) | ((iD & 31) << 16);
        }
        throw D3.f.a();
    }

    public static char h(int i7) throws D3.f {
        char[] cArr = f10792a;
        if (i7 < cArr.length) {
            return cArr[i7];
        }
        throw D3.f.a();
    }
}
