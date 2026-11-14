package k6;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class s {

    /* renamed from: j, reason: collision with root package name */
    public static final char[] f19397j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f19398a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19399b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19400c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19401d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19402e;

    /* renamed from: f, reason: collision with root package name */
    public final List f19403f;

    /* renamed from: g, reason: collision with root package name */
    public final List f19404g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19405h;

    /* renamed from: i, reason: collision with root package name */
    public final String f19406i;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f19407a;

        /* renamed from: d, reason: collision with root package name */
        public String f19410d;

        /* renamed from: f, reason: collision with root package name */
        public final List f19412f;

        /* renamed from: g, reason: collision with root package name */
        public List f19413g;

        /* renamed from: h, reason: collision with root package name */
        public String f19414h;

        /* renamed from: b, reason: collision with root package name */
        public String f19408b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f19409c = "";

        /* renamed from: e, reason: collision with root package name */
        public int f19411e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f19412f = arrayList;
            arrayList.add("");
        }

        public static String b(String str, int i7, int i8) {
            return l6.c.c(s.r(str, i7, i8, false));
        }

        public static int i(String str, int i7, int i8) throws NumberFormatException {
            int i9;
            try {
                i9 = Integer.parseInt(s.a(str, i7, i8, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i9 <= 0 || i9 > 65535) {
                return -1;
            }
            return i9;
        }

        public static int m(String str, int i7, int i8) {
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (cCharAt == ':') {
                    return i7;
                }
                if (cCharAt == '[') {
                    do {
                        i7++;
                        if (i7 < i8) {
                        }
                    } while (str.charAt(i7) != ']');
                }
                i7++;
            }
            return i8;
        }

        public static int r(String str, int i7, int i8) {
            if (i8 - i7 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i7);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i7++;
                    if (i7 >= i8) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i7);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i7;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int s(String str, int i7, int i8) {
            int i9 = 0;
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i9++;
                i7++;
            }
            return i9;
        }

        public s a() {
            if (this.f19407a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f19410d != null) {
                return new s(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int c() {
            int i7 = this.f19411e;
            return i7 != -1 ? i7 : s.d(this.f19407a);
        }

        public a d(String str) {
            this.f19413g = str != null ? s.y(s.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strB = b(str, 0, str.length());
            if (strB != null) {
                this.f19410d = strB;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public final boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a h(s sVar, String str) throws NumberFormatException, EOFException {
            int iM;
            String str2;
            int i7;
            String str3;
            String str4 = str;
            int iC = l6.c.C(str4, 0, str4.length());
            int iD = l6.c.D(str4, iC, str4.length());
            int iR = r(str4, iC, iD);
            if (iR != -1) {
                if (str4.regionMatches(true, iC, "https:", 0, 6)) {
                    this.f19407a = "https";
                    iC += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (!str4.regionMatches(true, iC, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, iR) + "'");
                    }
                    this.f19407a = "http";
                    iC += 5;
                }
            } else {
                if (sVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f19407a = sVar.f19398a;
            }
            int iS = s(str4, iC, iD);
            char c7 = '#';
            if (iS >= 2 || sVar == null || !sVar.f19398a.equals(this.f19407a)) {
                int i8 = iC + iS;
                boolean z7 = false;
                boolean z8 = false;
                while (true) {
                    iM = l6.c.m(str4, i8, iD, "@/\\?#");
                    char cCharAt = iM != iD ? str4.charAt(iM) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c7 || cCharAt == '/' || cCharAt == '\\' || cCharAt == '?') {
                        break;
                    }
                    if (cCharAt != '@') {
                        str3 = str4;
                    } else {
                        if (z7) {
                            i7 = iM;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.f19409c);
                            sb.append("%40");
                            str3 = str;
                            sb.append(s.a(str3, i8, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.f19409c = sb.toString();
                        } else {
                            int iL = l6.c.l(str4, i8, iM, ':');
                            String strA = s.a(str, i8, iL, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z8) {
                                strA = this.f19408b + "%40" + strA;
                            }
                            this.f19408b = strA;
                            if (iL != iM) {
                                i7 = iM;
                                this.f19409c = s.a(str, iL + 1, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z7 = true;
                            } else {
                                i7 = iM;
                            }
                            str3 = str;
                            z8 = true;
                        }
                        i8 = i7 + 1;
                    }
                    str4 = str3;
                    c7 = '#';
                }
                str2 = str4;
                int i9 = i8;
                int iM2 = m(str2, i9, iM);
                int i10 = iM2 + 1;
                if (i10 < iM) {
                    this.f19410d = b(str2, i9, iM2);
                    int i11 = i(str2, i10, iM);
                    this.f19411e = i11;
                    if (i11 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i10, iM) + JsonFactory.DEFAULT_QUOTE_CHAR);
                    }
                } else {
                    this.f19410d = b(str2, i9, iM2);
                    this.f19411e = s.d(this.f19407a);
                }
                if (this.f19410d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i9, iM2) + JsonFactory.DEFAULT_QUOTE_CHAR);
                }
                iC = iM;
            } else {
                this.f19408b = sVar.j();
                this.f19409c = sVar.f();
                this.f19410d = sVar.f19401d;
                this.f19411e = sVar.f19402e;
                this.f19412f.clear();
                this.f19412f.addAll(sVar.h());
                if (iC == iD || str4.charAt(iC) == '#') {
                    d(sVar.i());
                }
                str2 = str4;
            }
            int iM3 = l6.c.m(str2, iC, iD, "?#");
            p(str2, iC, iM3);
            if (iM3 < iD && str2.charAt(iM3) == '?') {
                int iL2 = l6.c.l(str2, iM3, iD, '#');
                this.f19413g = s.y(s.a(str2, iM3 + 1, iL2, " \"'<>#", true, false, true, true, null));
                iM3 = iL2;
            }
            if (iM3 < iD && str2.charAt(iM3) == '#') {
                this.f19414h = s.a(str2, iM3 + 1, iD, "", true, false, false, false, null);
            }
            return this;
        }

        public a j(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f19409c = s.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public final void k() {
            if (!((String) this.f19412f.remove(r0.size() - 1)).isEmpty() || this.f19412f.isEmpty()) {
                this.f19412f.add("");
            } else {
                this.f19412f.set(r0.size() - 1, "");
            }
        }

        public a l(int i7) {
            if (i7 > 0 && i7 <= 65535) {
                this.f19411e = i7;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i7);
        }

        public final void n(String str, int i7, int i8, boolean z7, boolean z8) throws EOFException {
            String strA = s.a(str, i7, i8, " \"<>^`{}|/\\?#", z8, false, false, true, null);
            if (f(strA)) {
                return;
            }
            if (g(strA)) {
                k();
                return;
            }
            if (((String) this.f19412f.get(r11.size() - 1)).isEmpty()) {
                this.f19412f.set(r11.size() - 1, strA);
            } else {
                this.f19412f.add(strA);
            }
            if (z7) {
                this.f19412f.add("");
            }
        }

        public a o() {
            int size = this.f19412f.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f19412f.set(i7, s.b((String) this.f19412f.get(i7), "[]", true, true, false, true));
            }
            List list = this.f19413g;
            if (list != null) {
                int size2 = list.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    String str = (String) this.f19413g.get(i8);
                    if (str != null) {
                        this.f19413g.set(i8, s.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f19414h;
            if (str2 != null) {
                this.f19414h = s.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public final void p(String str, int i7, int i8) throws EOFException {
            if (i7 == i8) {
                return;
            }
            char cCharAt = str.charAt(i7);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f19412f.clear();
                this.f19412f.add("");
                i7++;
            } else {
                List list = this.f19412f;
                list.set(list.size() - 1, "");
            }
            int i9 = i7;
            while (i9 < i8) {
                int iM = l6.c.m(str, i9, i8, "/\\");
                boolean z7 = iM < i8;
                String str2 = str;
                n(str2, i9, iM, z7, true);
                if (z7) {
                    iM++;
                }
                i9 = iM;
                str = str2;
            }
        }

        public a q(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f19407a = "http";
                return this;
            }
            if (str.equalsIgnoreCase("https")) {
                this.f19407a = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + str);
        }

        public a t(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f19408b = s.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f19407a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f19408b.isEmpty() || !this.f19409c.isEmpty()) {
                sb.append(this.f19408b);
                if (!this.f19409c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f19409c);
                }
                sb.append('@');
            }
            String str2 = this.f19410d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f19410d);
                    sb.append(']');
                } else {
                    sb.append(this.f19410d);
                }
            }
            if (this.f19411e != -1 || this.f19407a != null) {
                int iC = c();
                String str3 = this.f19407a;
                if (str3 == null || iC != s.d(str3)) {
                    sb.append(':');
                    sb.append(iC);
                }
            }
            s.q(sb, this.f19412f);
            if (this.f19413g != null) {
                sb.append('?');
                s.n(sb, this.f19413g);
            }
            if (this.f19414h != null) {
                sb.append('#');
                sb.append(this.f19414h);
            }
            return sb.toString();
        }
    }

    public s(a aVar) {
        this.f19398a = aVar.f19407a;
        this.f19399b = s(aVar.f19408b, false);
        this.f19400c = s(aVar.f19409c, false);
        this.f19401d = aVar.f19410d;
        this.f19402e = aVar.c();
        this.f19403f = t(aVar.f19412f, false);
        List list = aVar.f19413g;
        this.f19404g = list != null ? t(list, true) : null;
        String str = aVar.f19414h;
        this.f19405h = str != null ? s(str, false) : null;
        this.f19406i = aVar.toString();
    }

    public static String a(String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) throws EOFException {
        int iCharCount = i7;
        while (iCharCount < i8) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z10) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z7 || (z8 && !v(str, iCharCount, i8)))) || (iCodePointAt == 43 && z9)))) {
                v6.e eVar = new v6.e();
                eVar.c0(str, i7, iCharCount);
                c(eVar, str, iCharCount, i8, str2, z7, z8, z9, z10, charset);
                return eVar.G();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i7, i8);
    }

    public static String b(String str, String str2, boolean z7, boolean z8, boolean z9, boolean z10) {
        return a(str, 0, str.length(), str2, z7, z8, z9, z10, null);
    }

    public static void c(v6.e eVar, String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) throws EOFException {
        v6.e eVar2 = null;
        while (i7 < i8) {
            int iCodePointAt = str.codePointAt(i7);
            if (!z7 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z9) {
                    eVar.v(z7 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z10) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z7 || (z8 && !v(str, i7, i8)))))) {
                    if (eVar2 == null) {
                        eVar2 = new v6.e();
                    }
                    if (charset == null || charset.equals(l6.c.f19677j)) {
                        eVar2.d0(iCodePointAt);
                    } else {
                        eVar2.a0(str, i7, Character.charCount(iCodePointAt) + i7, charset);
                    }
                    while (!eVar2.m()) {
                        byte b7 = eVar2.readByte();
                        eVar.writeByte(37);
                        char[] cArr = f19397j;
                        eVar.writeByte(cArr[((b7 & 255) >> 4) & 15]);
                        eVar.writeByte(cArr[b7 & 15]);
                    }
                } else {
                    eVar.d0(iCodePointAt);
                }
            }
            i7 += Character.charCount(iCodePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static s k(String str) {
        return new a().h(null, str).a();
    }

    public static void n(StringBuilder sb, List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7 += 2) {
            String str = (String) list.get(i7);
            String str2 = (String) list.get(i7 + 1);
            if (i7 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static void q(StringBuilder sb, List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            sb.append(JsonPointer.SEPARATOR);
            sb.append((String) list.get(i7));
        }
    }

    public static String r(String str, int i7, int i8, boolean z7) {
        for (int i9 = i7; i9 < i8; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '%' || (cCharAt == '+' && z7)) {
                v6.e eVar = new v6.e();
                eVar.c0(str, i7, i9);
                u(eVar, str, i9, i8, z7);
                return eVar.G();
            }
        }
        return str.substring(i7, i8);
    }

    public static String s(String str, boolean z7) {
        return r(str, 0, str.length(), z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void u(v6.e r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = l6.c.i(r2)
            char r3 = r6.charAt(r1)
            int r3 = l6.c.i(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.d0(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.s.u(v6.e, java.lang.String, int, int, boolean):void");
    }

    public static boolean v(String str, int i7, int i8) {
        int i9 = i7 + 2;
        return i9 < i8 && str.charAt(i7) == '%' && l6.c.i(str.charAt(i7 + 1)) != -1 && l6.c.i(str.charAt(i9)) != -1;
    }

    public static List y(String str) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 <= str.length()) {
            int iIndexOf = str.indexOf(38, i7);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i7);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i7, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i7, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i7 = iIndexOf + 1;
        }
        return arrayList;
    }

    public s A(String str) {
        a aVarP = p(str);
        if (aVarP != null) {
            return aVarP.a();
        }
        return null;
    }

    public String B() {
        return this.f19398a;
    }

    public URI C() {
        String string = o().o().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e7) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e7);
            }
        }
    }

    public String e() {
        if (this.f19405h == null) {
            return null;
        }
        return this.f19406i.substring(this.f19406i.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f19406i.equals(this.f19406i);
    }

    public String f() {
        if (this.f19400c.isEmpty()) {
            return "";
        }
        return this.f19406i.substring(this.f19406i.indexOf(58, this.f19398a.length() + 3) + 1, this.f19406i.indexOf(64));
    }

    public String g() {
        int iIndexOf = this.f19406i.indexOf(47, this.f19398a.length() + 3);
        String str = this.f19406i;
        return this.f19406i.substring(iIndexOf, l6.c.m(str, iIndexOf, str.length(), "?#"));
    }

    public List h() {
        int iIndexOf = this.f19406i.indexOf(47, this.f19398a.length() + 3);
        String str = this.f19406i;
        int iM = l6.c.m(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iM) {
            int i7 = iIndexOf + 1;
            int iL = l6.c.l(this.f19406i, i7, iM, JsonPointer.SEPARATOR);
            arrayList.add(this.f19406i.substring(i7, iL));
            iIndexOf = iL;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f19406i.hashCode();
    }

    public String i() {
        if (this.f19404g == null) {
            return null;
        }
        int iIndexOf = this.f19406i.indexOf(63) + 1;
        String str = this.f19406i;
        return this.f19406i.substring(iIndexOf, l6.c.l(str, iIndexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f19399b.isEmpty()) {
            return "";
        }
        int length = this.f19398a.length() + 3;
        String str = this.f19406i;
        return this.f19406i.substring(length, l6.c.m(str, length, str.length(), ":@"));
    }

    public String l() {
        return this.f19401d;
    }

    public boolean m() {
        return this.f19398a.equals("https");
    }

    public a o() {
        a aVar = new a();
        aVar.f19407a = this.f19398a;
        aVar.f19408b = j();
        aVar.f19409c = f();
        aVar.f19410d = this.f19401d;
        aVar.f19411e = this.f19402e != d(this.f19398a) ? this.f19402e : -1;
        aVar.f19412f.clear();
        aVar.f19412f.addAll(h());
        aVar.d(i());
        aVar.f19414h = e();
        return aVar;
    }

    public a p(String str) {
        try {
            return new a().h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List t(List list, boolean z7) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i7 = 0; i7 < size; i7++) {
            String str = (String) list.get(i7);
            arrayList.add(str != null ? s(str, z7) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String toString() {
        return this.f19406i;
    }

    public int w() {
        return this.f19402e;
    }

    public String x() {
        if (this.f19404g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        n(sb, this.f19404g);
        return sb.toString();
    }

    public String z() {
        return p("/...").t("").j("").a().toString();
    }
}
