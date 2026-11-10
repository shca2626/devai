package com.fasterxml.jackson.core.io;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class CharTypes {
    private static final byte[] HB;
    private static final char[] HC;
    private static final int[] sHexValues;
    private static final int[] sInputCodes;
    private static final int[] sInputCodesComment;
    private static final int[] sInputCodesJsNames;
    private static final int[] sInputCodesUTF8;
    private static final int[] sInputCodesUtf8JsNames;
    private static final int[] sInputCodesWS;
    private static final int[] sOutputEscapes128;

    public static class AltEscapes {
        public static final AltEscapes instance = new AltEscapes();
        private int[][] _altEscapes = new int[128][];

        private AltEscapes() {
        }

        public int[] escapesFor(int i7) {
            int[] iArrCopyOf = this._altEscapes[i7];
            if (iArrCopyOf == null) {
                iArrCopyOf = Arrays.copyOf(CharTypes.sOutputEscapes128, 128);
                if (iArrCopyOf[i7] == 0) {
                    iArrCopyOf[i7] = -1;
                }
                this._altEscapes[i7] = iArrCopyOf;
            }
            return iArrCopyOf;
        }
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        HC = charArray;
        int length = charArray.length;
        HB = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            HB[i7] = (byte) HC[i7];
        }
        int[] iArr = new int[256];
        for (int i8 = 0; i8 < 32; i8++) {
            iArr[i8] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        sInputCodes = iArr;
        int length2 = iArr.length;
        int[] iArr2 = new int[length2];
        System.arraycopy(iArr, 0, iArr2, 0, length2);
        for (int i9 = 128; i9 < 256; i9++) {
            iArr2[i9] = (i9 & 224) == 192 ? 2 : (i9 & 240) == 224 ? 3 : (i9 & 248) == 240 ? 4 : -1;
        }
        sInputCodesUTF8 = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i10 = 33; i10 < 256; i10++) {
            if (Character.isJavaIdentifierPart((char) i10)) {
                iArr3[i10] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        sInputCodesJsNames = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, 256);
        Arrays.fill(iArr4, 128, 128, 0);
        sInputCodesUtf8JsNames = iArr4;
        int[] iArr5 = new int[256];
        int[] iArr6 = sInputCodesUTF8;
        System.arraycopy(iArr6, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        sInputCodesComment = iArr5;
        int[] iArr7 = new int[256];
        System.arraycopy(iArr6, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        sInputCodesWS = iArr7;
        int[] iArr8 = new int[128];
        for (int i11 = 0; i11 < 32; i11++) {
            iArr8[i11] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        sOutputEscapes128 = iArr8;
        int[] iArr9 = new int[256];
        sHexValues = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i12 = 0; i12 < 10; i12++) {
            sHexValues[i12 + 48] = i12;
        }
        for (int i13 = 0; i13 < 6; i13++) {
            int[] iArr10 = sHexValues;
            int i14 = i13 + 10;
            iArr10[i13 + 97] = i14;
            iArr10[i13 + 65] = i14;
        }
    }

    public static void appendQuoted(StringBuilder sb, String str) {
        int[] iArr = sOutputEscapes128;
        int length = iArr.length;
        int length2 = str.length();
        for (int i7 = 0; i7 < length2; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt >= length || iArr[cCharAt] == 0) {
                sb.append(cCharAt);
            } else {
                sb.append('\\');
                int i8 = iArr[cCharAt];
                if (i8 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    char[] cArr = HC;
                    sb.append(cArr[cCharAt >> 4]);
                    sb.append(cArr[cCharAt & 15]);
                } else {
                    sb.append((char) i8);
                }
            }
        }
    }

    public static int charToHex(int i7) {
        return sHexValues[i7 & 255];
    }

    public static byte[] copyHexBytes() {
        return (byte[]) HB.clone();
    }

    public static char[] copyHexChars() {
        return (char[]) HC.clone();
    }

    public static int[] get7BitOutputEscapes() {
        return sOutputEscapes128;
    }

    public static int[] getInputCodeComment() {
        return sInputCodesComment;
    }

    public static int[] getInputCodeLatin1() {
        return sInputCodes;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return sInputCodesJsNames;
    }

    public static int[] getInputCodeUtf8() {
        return sInputCodesUTF8;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return sInputCodesUtf8JsNames;
    }

    public static int[] getInputCodeWS() {
        return sInputCodesWS;
    }

    public static int[] get7BitOutputEscapes(int i7) {
        return i7 == 34 ? sOutputEscapes128 : AltEscapes.instance.escapesFor(i7);
    }
}
