package V5;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f8851a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f8852b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f8853c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f8854d;

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f8855e;

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f8856f;

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f8857g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        M5.m.d(charsetForName, "forName(...)");
        f8852b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        M5.m.d(charsetForName2, "forName(...)");
        f8853c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        M5.m.d(charsetForName3, "forName(...)");
        f8854d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        M5.m.d(charsetForName4, "forName(...)");
        f8855e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        M5.m.d(charsetForName5, "forName(...)");
        f8856f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        M5.m.d(charsetForName6, "forName(...)");
        f8857g = charsetForName6;
    }
}
