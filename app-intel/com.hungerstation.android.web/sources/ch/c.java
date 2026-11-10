package ch;

/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static final String f17186a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b, reason: collision with root package name */
    static final String f17187b = String.valueOf(Long.MAX_VALUE);

    public static boolean a(String str, boolean z12) {
        String str2 = z12 ? f17186a : f17187b;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            int iCharAt = str.charAt(i12) - str2.charAt(i12);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }
}
