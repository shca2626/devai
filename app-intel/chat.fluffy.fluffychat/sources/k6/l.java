package k6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f19368j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f19369k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f19370l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f19371m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f19372a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19373b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19374c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19375d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19376e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19377f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f19378g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f19379h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f19380i;

    public l(String str, String str2, long j7, String str3, String str4, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f19372a = str;
        this.f19373b = str2;
        this.f19374c = j7;
        this.f19375d = str3;
        this.f19376e = str4;
        this.f19377f = z7;
        this.f19378g = z8;
        this.f19380i = z9;
        this.f19379h = z10;
    }

    public static int a(String str, int i7, int i8, boolean z7) {
        while (i7 < i8) {
            char cCharAt = str.charAt(i7);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z7)) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !l6.c.H(str);
    }

    public static l d(long j7, s sVar, String str) throws NumberFormatException {
        long j8;
        String str2;
        int length = str.length();
        char c7 = ';';
        int iL = l6.c.l(str, 0, length, ';');
        int iL2 = l6.c.l(str, 0, iL, '=');
        String strG = null;
        if (iL2 == iL) {
            return null;
        }
        String strG2 = l6.c.G(str, 0, iL2);
        if (strG2.isEmpty() || l6.c.v(strG2) != -1) {
            return null;
        }
        String strG3 = l6.c.G(str, iL2 + 1, iL);
        if (l6.c.v(strG3) != -1) {
            return null;
        }
        int i7 = iL + 1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = true;
        long jH = 253402300799999L;
        long jI = -1;
        String strSubstring = null;
        while (i7 < length) {
            int iL3 = l6.c.l(str, i7, length, c7);
            int iL4 = l6.c.l(str, i7, iL3, '=');
            String strG4 = l6.c.G(str, i7, iL4);
            String strG5 = iL4 < iL3 ? l6.c.G(str, iL4 + 1, iL3) : "";
            if (strG4.equalsIgnoreCase("expires")) {
                try {
                    jH = h(strG5, 0, strG5.length());
                    z9 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strG4.equalsIgnoreCase("max-age")) {
                jI = i(strG5);
                z9 = true;
            } else if (strG4.equalsIgnoreCase("domain")) {
                strG = g(strG5);
                z10 = false;
            } else if (strG4.equalsIgnoreCase("path")) {
                strSubstring = strG5;
            } else if (strG4.equalsIgnoreCase("secure")) {
                z7 = true;
            } else if (strG4.equalsIgnoreCase("httponly")) {
                z8 = true;
            }
            i7 = iL3 + 1;
            c7 = ';';
        }
        if (jI == Long.MIN_VALUE) {
            j8 = Long.MIN_VALUE;
        } else if (jI != -1) {
            long j9 = j7 + (jI <= 9223372036854775L ? jI * 1000 : Long.MAX_VALUE);
            j8 = (j9 < j7 || j9 > 253402300799999L) ? 253402300799999L : j9;
        } else {
            j8 = jH;
        }
        String strL = sVar.l();
        if (strG == null) {
            str2 = strL;
        } else {
            if (!b(strL, strG)) {
                return null;
            }
            str2 = strG;
        }
        if (strL.length() != str2.length() && PublicSuffixDatabase.c().d(str2) == null) {
            return null;
        }
        if (strSubstring == null || !strSubstring.startsWith("/")) {
            String strG6 = sVar.g();
            int iLastIndexOf = strG6.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strG6.substring(0, iLastIndexOf) : "/";
        }
        return new l(strG2, strG3, j8, str2, strSubstring, z7, z8, z10, z9);
    }

    public static l e(s sVar, String str) {
        return d(System.currentTimeMillis(), sVar, str);
    }

    public static List f(s sVar, r rVar) {
        List listI = rVar.i("Set-Cookie");
        int size = listI.size();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < size; i7++) {
            l lVarE = e(sVar, (String) listI.get(i7));
            if (lVarE != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lVarE);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public static String g(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strC = l6.c.c(str);
        if (strC != null) {
            return strC;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long h(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.l.h(java.lang.String, int, int):long");
    }

    public static long i(String str) throws NumberFormatException {
        try {
            long j7 = Long.parseLong(str);
            if (j7 <= 0) {
                return Long.MIN_VALUE;
            }
            return j7;
        } catch (NumberFormatException e7) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e7;
        }
    }

    public String c() {
        return this.f19372a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f19372a.equals(this.f19372a) && lVar.f19373b.equals(this.f19373b) && lVar.f19375d.equals(this.f19375d) && lVar.f19376e.equals(this.f19376e) && lVar.f19374c == this.f19374c && lVar.f19377f == this.f19377f && lVar.f19378g == this.f19378g && lVar.f19379h == this.f19379h && lVar.f19380i == this.f19380i;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f19372a.hashCode()) * 31) + this.f19373b.hashCode()) * 31) + this.f19375d.hashCode()) * 31) + this.f19376e.hashCode()) * 31;
        long j7 = this.f19374c;
        return ((((((((iHashCode + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (!this.f19377f ? 1 : 0)) * 31) + (!this.f19378g ? 1 : 0)) * 31) + (!this.f19379h ? 1 : 0)) * 31) + (!this.f19380i ? 1 : 0);
    }

    public String j(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f19372a);
        sb.append('=');
        sb.append(this.f19373b);
        if (this.f19379h) {
            if (this.f19374c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(o6.d.a(new Date(this.f19374c)));
            }
        }
        if (!this.f19380i) {
            sb.append("; domain=");
            if (z7) {
                sb.append(".");
            }
            sb.append(this.f19375d);
        }
        sb.append("; path=");
        sb.append(this.f19376e);
        if (this.f19377f) {
            sb.append("; secure");
        }
        if (this.f19378g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.f19373b;
    }

    public String toString() {
        return j(false);
    }
}
