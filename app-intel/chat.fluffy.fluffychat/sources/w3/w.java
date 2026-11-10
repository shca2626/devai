package w3;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final int f23346a = a();

    public static int a() {
        return e(System.getProperty("java.version"));
    }

    public static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i7 = 0; i7 < str.length(); i7++) {
                char cCharAt = str.charAt(i7);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean c() {
        return f23346a >= 9;
    }

    public static int d(String str) throws NumberFormatException {
        try {
            String[] strArrSplit = str.split("[._]", 3);
            int i7 = Integer.parseInt(strArrSplit[0]);
            return (i7 != 1 || strArrSplit.length <= 1) ? i7 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int e(String str) throws NumberFormatException {
        int iD = d(str);
        if (iD == -1) {
            iD = b(str);
        }
        if (iD == -1) {
            return 6;
        }
        return iD;
    }
}
