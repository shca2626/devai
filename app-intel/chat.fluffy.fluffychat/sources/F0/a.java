package F0;

import E0.E;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f2461a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2462b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2463c;

    public a(int i7, int i8, String str) {
        this.f2461a = i7;
        this.f2462b = i8;
        this.f2463c = str;
    }

    public static a a(E e7) {
        String str;
        e7.g0(2);
        int iQ = e7.Q();
        int i7 = iQ >> 1;
        int iQ2 = ((e7.Q() >> 3) & 31) | ((iQ & 1) << 5);
        if (i7 == 4 || i7 == 5 || i7 == 7 || i7 == 8) {
            str = "dvhe";
        } else if (i7 == 9) {
            str = "dvav";
        } else {
            if (i7 != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i7 < 10 ? ".0" : ".");
        sb.append(i7);
        sb.append(iQ2 < 10 ? ".0" : ".");
        sb.append(iQ2);
        return new a(i7, iQ2, sb.toString());
    }
}
