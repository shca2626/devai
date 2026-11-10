package H1;

import E0.AbstractC0332s;
import E0.U;
import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import j3.o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o3.g;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3369a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3370b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f3371c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f3372d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3373e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3374f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3375g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3376h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3377i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3378j;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3379a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3380b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3381c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3382d;

        /* renamed from: e, reason: collision with root package name */
        public final int f3383e;

        /* renamed from: f, reason: collision with root package name */
        public final int f3384f;

        /* renamed from: g, reason: collision with root package name */
        public final int f3385g;

        /* renamed from: h, reason: collision with root package name */
        public final int f3386h;

        /* renamed from: i, reason: collision with root package name */
        public final int f3387i;

        /* renamed from: j, reason: collision with root package name */
        public final int f3388j;

        /* renamed from: k, reason: collision with root package name */
        public final int f3389k;

        public a(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f3379a = i7;
            this.f3380b = i8;
            this.f3381c = i9;
            this.f3382d = i10;
            this.f3383e = i11;
            this.f3384f = i12;
            this.f3385g = i13;
            this.f3386h = i14;
            this.f3387i = i15;
            this.f3388j = i16;
            this.f3389k = i17;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static H1.c.a a(java.lang.String r17) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: H1.c.a.a(java.lang.String):H1.c$a");
        }
    }

    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final Pattern f3390c = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: d, reason: collision with root package name */
        public static final Pattern f3391d = Pattern.compile(U.G("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: e, reason: collision with root package name */
        public static final Pattern f3392e = Pattern.compile(U.G("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: f, reason: collision with root package name */
        public static final Pattern f3393f = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a, reason: collision with root package name */
        public final int f3394a;

        /* renamed from: b, reason: collision with root package name */
        public final PointF f3395b;

        public b(int i7, PointF pointF) {
            this.f3394a = i7;
            this.f3395b = pointF;
        }

        public static int a(String str) {
            Matcher matcher = f3393f.matcher(str);
            if (matcher.find()) {
                return c.e((String) o.q(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f3390c.matcher(str);
            PointF pointF = null;
            int i7 = -1;
            while (matcher.find()) {
                String str2 = (String) o.q(matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i7 = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i7, pointF);
        }

        public static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f3391d.matcher(str);
            Matcher matcher2 = f3392e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    AbstractC0332s.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) o.q(strGroup)).trim()), Float.parseFloat(((String) o.q(strGroup2)).trim()));
        }

        public static String d(String str) {
            return f3390c.matcher(str).replaceAll("");
        }
    }

    public c(String str, int i7, Integer num, Integer num2, float f7, boolean z7, boolean z8, boolean z9, boolean z10, int i8) {
        this.f3369a = str;
        this.f3370b = i7;
        this.f3371c = num;
        this.f3372d = num2;
        this.f3373e = f7;
        this.f3374f = z7;
        this.f3375g = z8;
        this.f3376h = z9;
        this.f3377i = z10;
        this.f3378j = i8;
    }

    public static c b(String str, a aVar) {
        boolean z7;
        boolean z8;
        o.d(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i7 = aVar.f3389k;
        if (length != i7) {
            AbstractC0332s.h("SsaStyle", U.G("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i7), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f3379a].trim();
            int i8 = aVar.f3380b;
            int iE = i8 != -1 ? e(strArrSplit[i8].trim()) : -1;
            int i9 = aVar.f3381c;
            Integer numH = i9 != -1 ? h(strArrSplit[i9].trim()) : null;
            int i10 = aVar.f3382d;
            Integer numH2 = i10 != -1 ? h(strArrSplit[i10].trim()) : null;
            int i11 = aVar.f3383e;
            float fI = i11 != -1 ? i(strArrSplit[i11].trim()) : -3.4028235E38f;
            int i12 = aVar.f3384f;
            boolean z9 = false;
            boolean z10 = true;
            if (i12 == -1 || !f(strArrSplit[i12].trim())) {
                z7 = false;
            } else {
                z7 = false;
                z9 = true;
            }
            int i13 = aVar.f3385g;
            if (i13 == -1 || !f(strArrSplit[i13].trim())) {
                z8 = true;
                z10 = z7;
            } else {
                z8 = true;
            }
            int i14 = aVar.f3386h;
            if (i14 == -1 || !f(strArrSplit[i14].trim())) {
                z8 = false;
            }
            int i15 = aVar.f3387i;
            boolean z11 = i15 != -1 && f(strArrSplit[i15].trim());
            int i16 = aVar.f3388j;
            return new c(strTrim, iE, numH, numH2, fI, z9, z10, z8, z11, i16 != -1 ? g(strArrSplit[i16].trim()) : -1);
        } catch (RuntimeException e7) {
            AbstractC0332s.i("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e7);
            return null;
        }
    }

    public static boolean c(int i7) {
        switch (i7) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean d(int i7) {
        return i7 == 1 || i7 == 3;
    }

    public static int e(String str) throws NumberFormatException {
        try {
            int i7 = Integer.parseInt(str.trim());
            if (c(i7)) {
                return i7;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC0332s.h("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static boolean f(String str) throws NumberFormatException {
        try {
            int i7 = Integer.parseInt(str);
            return i7 == 1 || i7 == -1;
        } catch (NumberFormatException e7) {
            AbstractC0332s.i("SsaStyle", "Failed to parse boolean value: '" + str + "'", e7);
            return false;
        }
    }

    public static int g(String str) throws NumberFormatException {
        try {
            int i7 = Integer.parseInt(str.trim());
            if (d(i7)) {
                return i7;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC0332s.h("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static Integer h(String str) {
        try {
            long j7 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            o.d(j7 <= 4294967295L);
            return Integer.valueOf(Color.argb(g.e(((j7 >> 24) & 255) ^ 255), g.e(j7 & 255), g.e((j7 >> 8) & 255), g.e((j7 >> 16) & 255)));
        } catch (IllegalArgumentException e7) {
            AbstractC0332s.i("SsaStyle", "Failed to parse color expression: '" + str + "'", e7);
            return null;
        }
    }

    public static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e7) {
            AbstractC0332s.i("SsaStyle", "Failed to parse font size: '" + str + "'", e7);
            return -3.4028235E38f;
        }
    }
}
