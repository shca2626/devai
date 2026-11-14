package androidx.media3.exoplayer.rtsp;

import B0.A;
import E0.U;
import U0.s;
import U0.t;
import android.net.Uri;
import androidx.media3.exoplayer.rtsp.e;
import j3.C1233h;
import j3.o;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k3.AbstractC1278v;
import k3.C1279w;
import k3.h0;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f12792a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f12793b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f12794c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f12795d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f12796e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f12797f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");

    /* renamed from: g, reason: collision with root package name */
    public static final String f12798g = new String(new byte[]{10});

    /* renamed from: h, reason: collision with root package name */
    public static final String f12799h = new String(new byte[]{13, 10});

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f12800a;

        /* renamed from: b, reason: collision with root package name */
        public final String f12801b;

        public a(String str, String str2) {
            this.f12800a = str;
            this.f12801b = str2;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f12802a;

        /* renamed from: b, reason: collision with root package name */
        public final long f12803b;

        public b(String str, long j7) {
            this.f12802a = str;
            this.f12803b = j7;
        }
    }

    public static void a(boolean z7, String str) throws A {
        if (!z7) {
            throw A.c(str, null);
        }
    }

    public static byte[] b(List list) {
        return C1233h.h(f12799h).e(list).getBytes(g.f12773r);
    }

    public static String c(int i7) {
        if (i7 == 200) {
            return "OK";
        }
        if (i7 == 461) {
            return "Unsupported Transport";
        }
        if (i7 == 500) {
            return "Internal Server Error";
        }
        if (i7 == 505) {
            return "RTSP Version Not Supported";
        }
        if (i7 == 301) {
            return "Move Permanently";
        }
        if (i7 == 302) {
            return "Move Temporarily";
        }
        if (i7 == 400) {
            return "Bad Request";
        }
        if (i7 == 401) {
            return "Unauthorized";
        }
        if (i7 == 404) {
            return "Not Found";
        }
        if (i7 == 405) {
            return "Method Not Allowed";
        }
        switch (i7) {
            case 454:
                return "Session Not Found";
            case 455:
                return "Method Not Valid In This State";
            case 456:
                return "Header Field Not Valid";
            case 457:
                return "Invalid Range";
            default:
                throw new IllegalArgumentException();
        }
    }

    public static byte[] d(String str) {
        return str.getBytes(g.f12773r);
    }

    public static boolean e(List list) {
        return f12793b.matcher((CharSequence) list.get(0)).matches();
    }

    public static boolean f(String str) {
        return f12792a.matcher(str).matches() || f12793b.matcher(str).matches();
    }

    public static long g(String str) throws A {
        try {
            Matcher matcher = f12794c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) o.q(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e7) {
            throw A.c(str, e7);
        }
    }

    public static int h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e7) {
            throw A.c(str, e7);
        }
    }

    public static int i(String str) {
        str.getClass();
        switch (str) {
            case "RECORD":
                return 8;
            case "TEARDOWN":
                return 12;
            case "GET_PARAMETER":
                return 3;
            case "OPTIONS":
                return 4;
            case "PLAY_NOTIFY":
                return 7;
            case "PLAY":
                return 6;
            case "REDIRECT":
                return 9;
            case "SET_PARAMETER":
                return 11;
            case "PAUSE":
                return 5;
            case "SETUP":
                return 10;
            case "ANNOUNCE":
                return 1;
            case "DESCRIBE":
                return 2;
            default:
                return 0;
        }
    }

    public static AbstractC1278v j(String str) {
        if (str == null) {
            return AbstractC1278v.v();
        }
        AbstractC1278v.a aVar = new AbstractC1278v.a();
        for (String str2 : U.k1(str, ",\\s?")) {
            int i7 = i(str2);
            if (i7 != 0) {
                aVar.a(Integer.valueOf(i7));
            }
        }
        return aVar.k();
    }

    public static s k(List list) {
        Matcher matcher = f12792a.matcher((CharSequence) list.get(0));
        o.d(matcher.matches());
        int i7 = i((String) o.q(matcher.group(1)));
        Uri uri = Uri.parse((String) o.q(matcher.group(2)));
        int iIndexOf = list.indexOf("");
        o.d(iIndexOf > 0);
        return new s(uri, i7, new e.b().c(list.subList(1, iIndexOf)).e(), C1233h.h(f12799h).e(list.subList(iIndexOf + 1, list.size())));
    }

    public static t l(List list) throws NumberFormatException {
        Matcher matcher = f12793b.matcher((CharSequence) list.get(0));
        o.d(matcher.matches());
        int i7 = Integer.parseInt((String) o.q(matcher.group(1)));
        int iIndexOf = list.indexOf("");
        o.d(iIndexOf > 0);
        return new t(i7, new e.b().c(list.subList(1, iIndexOf)).e(), C1233h.h(f12799h).e(list.subList(iIndexOf + 1, list.size())));
    }

    public static b m(String str) throws A {
        long j7;
        Matcher matcher = f12795d.matcher(str);
        if (!matcher.matches()) {
            throw A.c(str, null);
        }
        String str2 = (String) o.q(matcher.group(1));
        if (matcher.group(2) != null) {
            try {
                j7 = Integer.parseInt(r0) * 1000;
            } catch (NumberFormatException e7) {
                throw A.c(str, e7);
            }
        } else {
            j7 = 60000;
        }
        return new b(str2, j7);
    }

    public static a n(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return null;
        }
        String[] strArrL1 = U.l1(userInfo, ":");
        return new a(strArrL1[0], strArrL1[1]);
    }

    public static c o(String str) throws A {
        Matcher matcher = f12796e.matcher(str);
        if (matcher.find()) {
            return new c(2, (String) o.q(matcher.group(1)), (String) o.q(matcher.group(3)), j3.t.c(matcher.group(4)));
        }
        Matcher matcher2 = f12797f.matcher(str);
        if (matcher2.matches()) {
            return new c(1, (String) o.q(matcher2.group(1)), "", "");
        }
        throw A.c("Invalid WWW-Authenticate header " + str, null);
    }

    public static Uri p(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) o.q(uri.getEncodedAuthority());
        o.d(str.contains("@"));
        return uri.buildUpon().encodedAuthority(U.k1(str, "@")[1]).build();
    }

    public static AbstractC1278v q(s sVar) {
        o.d(sVar.f8377c.d("CSeq") != null);
        AbstractC1278v.a aVar = new AbstractC1278v.a();
        aVar.a(U.G("%s %s %s", t(sVar.f8376b), sVar.f8375a, "RTSP/1.0"));
        C1279w c1279wB = sVar.f8377c.b();
        h0 it = c1279wB.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            AbstractC1278v abstractC1278v = c1279wB.get(str);
            for (int i7 = 0; i7 < abstractC1278v.size(); i7++) {
                aVar.a(U.G("%s: %s", str, abstractC1278v.get(i7)));
            }
        }
        aVar.a("");
        aVar.a(sVar.f8378d);
        return aVar.k();
    }

    public static AbstractC1278v r(t tVar) {
        o.d(tVar.f8380b.d("CSeq") != null);
        AbstractC1278v.a aVar = new AbstractC1278v.a();
        aVar.a(U.G("%s %s %s", "RTSP/1.0", Integer.valueOf(tVar.f8379a), c(tVar.f8379a)));
        C1279w c1279wB = tVar.f8380b.b();
        h0 it = c1279wB.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            AbstractC1278v abstractC1278v = c1279wB.get(str);
            for (int i7 = 0; i7 < abstractC1278v.size(); i7++) {
                aVar.a(U.G("%s: %s", str, abstractC1278v.get(i7)));
            }
        }
        aVar.a("");
        aVar.a(tVar.f8381c);
        return aVar.k();
    }

    public static String[] s(String str) {
        String str2 = f12799h;
        if (!str.contains(str2)) {
            str2 = f12798g;
        }
        return U.k1(str, str2);
    }

    public static String t(int i7) {
        switch (i7) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return "REDIRECT";
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }
}
