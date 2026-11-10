package com.airbnb.lottie.parser.moshi;

/* loaded from: classes.dex */
final class JsonScope {
    static final int CLOSED = 8;
    static final int DANGLING_NAME = 4;
    static final int EMPTY_ARRAY = 1;
    static final int EMPTY_DOCUMENT = 6;
    static final int EMPTY_OBJECT = 3;
    static final int NONEMPTY_ARRAY = 2;
    static final int NONEMPTY_DOCUMENT = 7;
    static final int NONEMPTY_OBJECT = 5;

    private JsonScope() {
    }

    static String getPath(int i12, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            if (i14 == 1 || i14 == 2) {
                sb2.append('[');
                sb2.append(iArr2[i13]);
                sb2.append(']');
            } else if (i14 == 3 || i14 == 4 || i14 == 5) {
                sb2.append('.');
                String str = strArr[i13];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }
}
