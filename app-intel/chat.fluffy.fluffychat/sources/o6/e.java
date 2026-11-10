package o6;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import k6.A;
import k6.l;
import k6.m;
import k6.r;
import k6.s;
import k6.y;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final v6.h f20486a = v6.h.i("\"\\");

    /* renamed from: b, reason: collision with root package name */
    public static final v6.h f20487b = v6.h.i("\t ,=");

    public static long a(r rVar) {
        return j(rVar.c("Content-Length"));
    }

    public static long b(A a7) {
        return a(a7.o());
    }

    public static boolean c(A a7) {
        if (a7.E().g().equals("HEAD")) {
            return false;
        }
        int iF = a7.f();
        return (((iF >= 100 && iF < 200) || iF == 204 || iF == 304) && b(a7) == -1 && !"chunked".equalsIgnoreCase(a7.j("Transfer-Encoding"))) ? false : true;
    }

    public static boolean d(r rVar) {
        return k(rVar).contains("*");
    }

    public static boolean e(A a7) {
        return d(a7.o());
    }

    public static int f(String str, int i7) {
        try {
            long j7 = Long.parseLong(str);
            if (j7 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j7 < 0) {
                return 0;
            }
            return (int) j7;
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    public static void g(m mVar, s sVar, r rVar) {
        if (mVar == m.f19381a) {
            return;
        }
        List listF = l.f(sVar, rVar);
        if (listF.isEmpty()) {
            return;
        }
        mVar.b(sVar, listF);
    }

    public static int h(String str, int i7, String str2) {
        while (i7 < str.length() && str2.indexOf(str.charAt(i7)) == -1) {
            i7++;
        }
        return i7;
    }

    public static int i(String str, int i7) {
        char cCharAt;
        while (i7 < str.length() && ((cCharAt = str.charAt(i7)) == ' ' || cCharAt == '\t')) {
            i7++;
        }
        return i7;
    }

    public static long j(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set k(r rVar) {
        Set treeSet = Collections.EMPTY_SET;
        int iG = rVar.g();
        for (int i7 = 0; i7 < iG; i7++) {
            if ("Vary".equalsIgnoreCase(rVar.e(i7))) {
                String strH = rVar.h(i7);
                if (treeSet.isEmpty()) {
                    treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strH.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }

    public static Set l(A a7) {
        return k(a7.o());
    }

    public static r m(r rVar, r rVar2) {
        Set setK = k(rVar2);
        if (setK.isEmpty()) {
            return new r.a().d();
        }
        r.a aVar = new r.a();
        int iG = rVar.g();
        for (int i7 = 0; i7 < iG; i7++) {
            String strE = rVar.e(i7);
            if (setK.contains(strE)) {
                aVar.a(strE, rVar.h(i7));
            }
        }
        return aVar.d();
    }

    public static r n(A a7) {
        return m(a7.u().E().e(), a7.o());
    }

    public static boolean o(A a7, r rVar, y yVar) {
        for (String str : l(a7)) {
            if (!l6.c.o(rVar.i(str), yVar.d(str))) {
                return false;
            }
        }
        return true;
    }
}
