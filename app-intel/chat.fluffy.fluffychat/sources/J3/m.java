package J3;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4796a = Charset.defaultCharset();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f4797b = Charset.forName("SJIS");

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f4798c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f4799d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f4800e;

    static {
        Charset charsetForName;
        try {
            charsetForName = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        f4798c = charsetForName;
        Charset charsetForName2 = Charset.forName("EUC_JP");
        f4799d = charsetForName2;
        Charset charset = f4797b;
        Charset charset2 = f4796a;
        f4800e = charset.equals(charset2) || charsetForName2.equals(charset2);
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x00da A[PHI: r19
      0x00da: PHI (r19v6 boolean) = (r19v5 boolean), (r19v5 boolean), (r19v5 boolean), (r19v7 boolean), (r19v7 boolean), (r19v7 boolean) binds: [B:86:0x00e0, B:88:0x00e4, B:90:0x00e8, B:78:0x00ce, B:79:0x00d0, B:81:0x00d4] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.charset.Charset a(byte[] r21, java.util.Map r22) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J3.m.a(byte[], java.util.Map):java.nio.charset.Charset");
    }
}
