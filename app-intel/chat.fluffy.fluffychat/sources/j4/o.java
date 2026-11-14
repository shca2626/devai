package j4;

/* loaded from: classes.dex */
public enum o {
    AES_GCM_NoPadding(null, 23);


    /* renamed from: l, reason: collision with root package name */
    public final int f18760l;

    o(q qVar, int i7) {
        this.f18760l = i7;
    }

    public static o d(String str) {
        return "AES_GCM_NoPadding_BIOMETRIC".equals(str) ? AES_GCM_NoPadding : "AES_CBC_PKCS7Padding".equals(str) ? AES_GCM_NoPadding : valueOf(str);
    }

    public static boolean e(String str) {
        return "AES_CBC_PKCS7Padding".equals(str);
    }
}
