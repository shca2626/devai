package com.google.gson.internal;

/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f25074a = a();

    private static int a() {
        return c(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i12 = 0; i12 < str.length(); i12++) {
                char cCharAt = str.charAt(i12);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb2.append(cCharAt);
            }
            return Integer.parseInt(sb2.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static int c(String str) throws NumberFormatException {
        int iE = e(str);
        if (iE == -1) {
            iE = b(str);
        }
        if (iE == -1) {
            return 6;
        }
        return iE;
    }

    public static boolean d() {
        return f25074a >= 9;
    }

    private static int e(String str) throws NumberFormatException {
        try {
            String[] strArrSplit = str.split("[._]");
            int i12 = Integer.parseInt(strArrSplit[0]);
            return (i12 != 1 || strArrSplit.length <= 1) ? i12 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
