package v6;

/* loaded from: classes3.dex */
public abstract class C {
    public static final byte[] a(String str) {
        M5.m.e(str, "<this>");
        byte[] bytes = str.getBytes(V5.c.f8852b);
        M5.m.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        M5.m.e(bArr, "<this>");
        return new String(bArr, V5.c.f8852b);
    }
}
