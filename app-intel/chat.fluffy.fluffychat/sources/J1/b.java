package J1;

import android.text.TextUtils;
import j3.AbstractC1229c;
import java.util.regex.Pattern;
import k3.AbstractC1258B;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f4653d = Pattern.compile("\\s+");

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC1258B f4654e = AbstractC1258B.w("auto", "none");

    /* renamed from: f, reason: collision with root package name */
    public static final AbstractC1258B f4655f = AbstractC1258B.x("dot", "sesame", "circle");

    /* renamed from: g, reason: collision with root package name */
    public static final AbstractC1258B f4656g = AbstractC1258B.w("filled", "open");

    /* renamed from: h, reason: collision with root package name */
    public static final AbstractC1258B f4657h = AbstractC1258B.x("after", "before", "outside");

    /* renamed from: a, reason: collision with root package name */
    public final int f4658a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4659b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4660c;

    public b(int i7, int i8, int i9) {
        this.f4658a = i7;
        this.f4659b = i8;
        this.f4660c = i9;
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        String strF = AbstractC1229c.f(str.trim());
        if (strF.isEmpty()) {
            return null;
        }
        return b(AbstractC1258B.r(TextUtils.split(strF, f4653d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static J1.b b(k3.AbstractC1258B r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.b.b(k3.B):J1.b");
    }
}
