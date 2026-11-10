package com.fasterxml.jackson.core.io;

/* loaded from: classes.dex */
public final class NumberOutput {
    private static int BILLION = 1000000000;
    private static long BILLION_L = 1000000000;
    private static long MAX_INT_AS_LONG = 2147483647L;
    private static int MILLION = 1000000;
    private static long MIN_INT_AS_LONG = -2147483648L;
    static final String SMALLEST_INT = String.valueOf(Integer.MIN_VALUE);
    static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    private static final int[] TRIPLET_TO_CHARS = new int[1000];
    private static final String[] sSmallIntStrs;
    private static final String[] sSmallIntStrs2;

    static {
        int i7 = 0;
        for (int i8 = 0; i8 < 10; i8++) {
            for (int i9 = 0; i9 < 10; i9++) {
                int i10 = 0;
                while (i10 < 10) {
                    TRIPLET_TO_CHARS[i7] = ((i8 + 48) << 16) | ((i9 + 48) << 8) | (i10 + 48);
                    i10++;
                    i7++;
                }
            }
        }
        sSmallIntStrs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        sSmallIntStrs2 = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    private static int _full3(int i7, char[] cArr, int i8) {
        int i9 = TRIPLET_TO_CHARS[i7];
        cArr[i8] = (char) (i9 >> 16);
        int i10 = i8 + 2;
        cArr[i8 + 1] = (char) ((i9 >> 8) & 127);
        int i11 = i8 + 3;
        cArr[i10] = (char) (i9 & 127);
        return i11;
    }

    private static int _leading3(int i7, char[] cArr, int i8) {
        int i9 = TRIPLET_TO_CHARS[i7];
        if (i7 > 9) {
            if (i7 > 99) {
                cArr[i8] = (char) (i9 >> 16);
                i8++;
            }
            cArr[i8] = (char) ((i9 >> 8) & 127);
            i8++;
        }
        int i10 = i8 + 1;
        cArr[i8] = (char) (i9 & 127);
        return i10;
    }

    private static int _outputFullBillion(int i7, char[] cArr, int i8) {
        int i9 = i7 / 1000;
        int i10 = i7 - (i9 * 1000);
        int i11 = i9 / 1000;
        int[] iArr = TRIPLET_TO_CHARS;
        int i12 = iArr[i11];
        cArr[i8] = (char) (i12 >> 16);
        cArr[i8 + 1] = (char) ((i12 >> 8) & 127);
        cArr[i8 + 2] = (char) (i12 & 127);
        int i13 = iArr[i9 - (i11 * 1000)];
        cArr[i8 + 3] = (char) (i13 >> 16);
        cArr[i8 + 4] = (char) ((i13 >> 8) & 127);
        cArr[i8 + 5] = (char) (i13 & 127);
        int i14 = iArr[i10];
        cArr[i8 + 6] = (char) (i14 >> 16);
        int i15 = i8 + 8;
        cArr[i8 + 7] = (char) ((i14 >> 8) & 127);
        int i16 = i8 + 9;
        cArr[i15] = (char) (i14 & 127);
        return i16;
    }

    private static int _outputSmallestI(char[] cArr, int i7) {
        String str = SMALLEST_INT;
        int length = str.length();
        str.getChars(0, length, cArr, i7);
        return i7 + length;
    }

    private static int _outputSmallestL(char[] cArr, int i7) {
        String str = SMALLEST_LONG;
        int length = str.length();
        str.getChars(0, length, cArr, i7);
        return i7 + length;
    }

    private static int _outputUptoBillion(int i7, char[] cArr, int i8) {
        if (i7 < MILLION) {
            if (i7 < 1000) {
                return _leading3(i7, cArr, i8);
            }
            int i9 = i7 / 1000;
            return _outputUptoMillion(cArr, i8, i9, i7 - (i9 * 1000));
        }
        int i10 = i7 / 1000;
        int i11 = i7 - (i10 * 1000);
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        int i_leading3 = _leading3(i12, cArr, i8);
        int[] iArr = TRIPLET_TO_CHARS;
        int i14 = iArr[i13];
        cArr[i_leading3] = (char) (i14 >> 16);
        cArr[i_leading3 + 1] = (char) ((i14 >> 8) & 127);
        cArr[i_leading3 + 2] = (char) (i14 & 127);
        int i15 = iArr[i11];
        cArr[i_leading3 + 3] = (char) (i15 >> 16);
        int i16 = i_leading3 + 5;
        cArr[i_leading3 + 4] = (char) ((i15 >> 8) & 127);
        int i17 = i_leading3 + 6;
        cArr[i16] = (char) (i15 & 127);
        return i17;
    }

    private static int _outputUptoMillion(char[] cArr, int i7, int i8, int i9) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i10 = iArr[i8];
        if (i8 > 9) {
            if (i8 > 99) {
                cArr[i7] = (char) (i10 >> 16);
                i7++;
            }
            cArr[i7] = (char) ((i10 >> 8) & 127);
            i7++;
        }
        cArr[i7] = (char) (i10 & 127);
        int i11 = iArr[i9];
        cArr[i7 + 1] = (char) (i11 >> 16);
        int i12 = i7 + 3;
        cArr[i7 + 2] = (char) ((i11 >> 8) & 127);
        int i13 = i7 + 4;
        cArr[i12] = (char) (i11 & 127);
        return i13;
    }

    public static boolean notFinite(double d7) {
        return Double.isNaN(d7) || Double.isInfinite(d7);
    }

    public static int outputInt(int i7, char[] cArr, int i8) {
        int i9;
        if (i7 < 0) {
            if (i7 == Integer.MIN_VALUE) {
                return _outputSmallestI(cArr, i8);
            }
            cArr[i8] = '-';
            i7 = -i7;
            i8++;
        }
        if (i7 < MILLION) {
            if (i7 >= 1000) {
                int i10 = i7 / 1000;
                return _full3(i7 - (i10 * 1000), cArr, _leading3(i10, cArr, i8));
            }
            if (i7 >= 10) {
                return _leading3(i7, cArr, i8);
            }
            cArr[i8] = (char) (i7 + 48);
            return i8 + 1;
        }
        int i11 = BILLION;
        if (i7 < i11) {
            int i12 = i7 / 1000;
            int i13 = i12 / 1000;
            return _full3(i7 - (i12 * 1000), cArr, _full3(i12 - (i13 * 1000), cArr, _leading3(i13, cArr, i8)));
        }
        int i14 = i7 - i11;
        if (i14 >= i11) {
            i14 -= i11;
            i9 = i8 + 1;
            cArr[i8] = '2';
        } else {
            i9 = i8 + 1;
            cArr[i8] = '1';
        }
        return _outputFullBillion(i14, cArr, i9);
    }

    public static int outputLong(long j7, char[] cArr, int i7) {
        int i_outputFullBillion;
        if (j7 < 0) {
            if (j7 > MIN_INT_AS_LONG) {
                return outputInt((int) j7, cArr, i7);
            }
            if (j7 == Long.MIN_VALUE) {
                return _outputSmallestL(cArr, i7);
            }
            cArr[i7] = '-';
            j7 = -j7;
            i7++;
        } else if (j7 <= MAX_INT_AS_LONG) {
            return outputInt((int) j7, cArr, i7);
        }
        long j8 = BILLION_L;
        long j9 = j7 / j8;
        long j10 = j7 - (j9 * j8);
        if (j9 < j8) {
            i_outputFullBillion = _outputUptoBillion((int) j9, cArr, i7);
        } else {
            long j11 = j9 / j8;
            int i_leading3 = _leading3((int) j11, cArr, i7);
            i_outputFullBillion = _outputFullBillion((int) (j9 - (j8 * j11)), cArr, i_leading3);
        }
        return _outputFullBillion((int) j10, cArr, i_outputFullBillion);
    }

    public static String toString(int i7) {
        String[] strArr = sSmallIntStrs;
        if (i7 < strArr.length) {
            if (i7 >= 0) {
                return strArr[i7];
            }
            int i8 = (-i7) - 1;
            String[] strArr2 = sSmallIntStrs2;
            if (i8 < strArr2.length) {
                return strArr2[i8];
            }
        }
        return Integer.toString(i7);
    }

    public static boolean notFinite(float f7) {
        return Float.isNaN(f7) || Float.isInfinite(f7);
    }

    private static int _outputSmallestI(byte[] bArr, int i7) {
        int length = SMALLEST_INT.length();
        int i8 = 0;
        while (i8 < length) {
            bArr[i7] = (byte) SMALLEST_INT.charAt(i8);
            i8++;
            i7++;
        }
        return i7;
    }

    private static int _outputSmallestL(byte[] bArr, int i7) {
        int length = SMALLEST_LONG.length();
        int i8 = 0;
        while (i8 < length) {
            bArr[i7] = (byte) SMALLEST_LONG.charAt(i8);
            i8++;
            i7++;
        }
        return i7;
    }

    private static int _full3(int i7, byte[] bArr, int i8) {
        int i9 = TRIPLET_TO_CHARS[i7];
        bArr[i8] = (byte) (i9 >> 16);
        int i10 = i8 + 2;
        bArr[i8 + 1] = (byte) (i9 >> 8);
        int i11 = i8 + 3;
        bArr[i10] = (byte) i9;
        return i11;
    }

    private static int _leading3(int i7, byte[] bArr, int i8) {
        int i9 = TRIPLET_TO_CHARS[i7];
        if (i7 > 9) {
            if (i7 > 99) {
                bArr[i8] = (byte) (i9 >> 16);
                i8++;
            }
            bArr[i8] = (byte) (i9 >> 8);
            i8++;
        }
        int i10 = i8 + 1;
        bArr[i8] = (byte) i9;
        return i10;
    }

    public static String toString(long j7) {
        if (j7 <= 2147483647L && j7 >= -2147483648L) {
            return toString((int) j7);
        }
        return Long.toString(j7);
    }

    public static String toString(double d7) {
        return Double.toString(d7);
    }

    private static int _outputUptoMillion(byte[] bArr, int i7, int i8, int i9) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i10 = iArr[i8];
        if (i8 > 9) {
            if (i8 > 99) {
                bArr[i7] = (byte) (i10 >> 16);
                i7++;
            }
            bArr[i7] = (byte) (i10 >> 8);
            i7++;
        }
        bArr[i7] = (byte) i10;
        int i11 = iArr[i9];
        bArr[i7 + 1] = (byte) (i11 >> 16);
        int i12 = i7 + 3;
        bArr[i7 + 2] = (byte) (i11 >> 8);
        int i13 = i7 + 4;
        bArr[i12] = (byte) i11;
        return i13;
    }

    public static String toString(float f7) {
        return Float.toString(f7);
    }

    public static int outputLong(long j7, byte[] bArr, int i7) {
        int i_outputFullBillion;
        if (j7 < 0) {
            if (j7 > MIN_INT_AS_LONG) {
                return outputInt((int) j7, bArr, i7);
            }
            if (j7 == Long.MIN_VALUE) {
                return _outputSmallestL(bArr, i7);
            }
            bArr[i7] = 45;
            j7 = -j7;
            i7++;
        } else if (j7 <= MAX_INT_AS_LONG) {
            return outputInt((int) j7, bArr, i7);
        }
        long j8 = BILLION_L;
        long j9 = j7 / j8;
        long j10 = j7 - (j9 * j8);
        if (j9 < j8) {
            i_outputFullBillion = _outputUptoBillion((int) j9, bArr, i7);
        } else {
            long j11 = j9 / j8;
            int i_leading3 = _leading3((int) j11, bArr, i7);
            i_outputFullBillion = _outputFullBillion((int) (j9 - (j8 * j11)), bArr, i_leading3);
        }
        return _outputFullBillion((int) j10, bArr, i_outputFullBillion);
    }

    private static int _outputFullBillion(int i7, byte[] bArr, int i8) {
        int i9 = i7 / 1000;
        int i10 = i7 - (i9 * 1000);
        int i11 = i9 / 1000;
        int i12 = i9 - (i11 * 1000);
        int[] iArr = TRIPLET_TO_CHARS;
        int i13 = iArr[i11];
        bArr[i8] = (byte) (i13 >> 16);
        bArr[i8 + 1] = (byte) (i13 >> 8);
        bArr[i8 + 2] = (byte) i13;
        int i14 = iArr[i12];
        bArr[i8 + 3] = (byte) (i14 >> 16);
        bArr[i8 + 4] = (byte) (i14 >> 8);
        bArr[i8 + 5] = (byte) i14;
        int i15 = iArr[i10];
        bArr[i8 + 6] = (byte) (i15 >> 16);
        int i16 = i8 + 8;
        bArr[i8 + 7] = (byte) (i15 >> 8);
        int i17 = i8 + 9;
        bArr[i16] = (byte) i15;
        return i17;
    }

    private static int _outputUptoBillion(int i7, byte[] bArr, int i8) {
        if (i7 < MILLION) {
            if (i7 < 1000) {
                return _leading3(i7, bArr, i8);
            }
            int i9 = i7 / 1000;
            return _outputUptoMillion(bArr, i8, i9, i7 - (i9 * 1000));
        }
        int i10 = i7 / 1000;
        int i11 = i7 - (i10 * 1000);
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        int i_leading3 = _leading3(i12, bArr, i8);
        int[] iArr = TRIPLET_TO_CHARS;
        int i14 = iArr[i13];
        bArr[i_leading3] = (byte) (i14 >> 16);
        bArr[i_leading3 + 1] = (byte) (i14 >> 8);
        bArr[i_leading3 + 2] = (byte) i14;
        int i15 = iArr[i11];
        bArr[i_leading3 + 3] = (byte) (i15 >> 16);
        int i16 = i_leading3 + 5;
        bArr[i_leading3 + 4] = (byte) (i15 >> 8);
        int i17 = i_leading3 + 6;
        bArr[i16] = (byte) i15;
        return i17;
    }

    public static int outputInt(int i7, byte[] bArr, int i8) {
        int i9;
        if (i7 < 0) {
            if (i7 == Integer.MIN_VALUE) {
                return _outputSmallestI(bArr, i8);
            }
            bArr[i8] = 45;
            i7 = -i7;
            i8++;
        }
        if (i7 < MILLION) {
            if (i7 >= 1000) {
                int i10 = i7 / 1000;
                return _full3(i7 - (i10 * 1000), bArr, _leading3(i10, bArr, i8));
            }
            if (i7 < 10) {
                int i11 = i8 + 1;
                bArr[i8] = (byte) (i7 + 48);
                return i11;
            }
            return _leading3(i7, bArr, i8);
        }
        int i12 = BILLION;
        if (i7 >= i12) {
            int i13 = i7 - i12;
            if (i13 >= i12) {
                i13 -= i12;
                i9 = i8 + 1;
                bArr[i8] = 50;
            } else {
                i9 = i8 + 1;
                bArr[i8] = 49;
            }
            return _outputFullBillion(i13, bArr, i9);
        }
        int i14 = i7 / 1000;
        int i15 = i14 / 1000;
        return _full3(i7 - (i14 * 1000), bArr, _full3(i14 - (i15 * 1000), bArr, _leading3(i15, bArr, i8)));
    }
}
