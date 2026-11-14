package l6;

import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import k6.B;
import k6.r;
import k6.s;
import k6.z;
import v6.A;
import v6.e;
import v6.h;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f19668a;

    /* renamed from: c, reason: collision with root package name */
    public static final B f19670c;

    /* renamed from: d, reason: collision with root package name */
    public static final z f19671d;

    /* renamed from: r, reason: collision with root package name */
    public static final Method f19685r;

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f19686s;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f19669b = new String[0];

    /* renamed from: e, reason: collision with root package name */
    public static final h f19672e = h.f("efbbbf");

    /* renamed from: f, reason: collision with root package name */
    public static final h f19673f = h.f("feff");

    /* renamed from: g, reason: collision with root package name */
    public static final h f19674g = h.f("fffe");

    /* renamed from: h, reason: collision with root package name */
    public static final h f19675h = h.f("0000ffff");

    /* renamed from: i, reason: collision with root package name */
    public static final h f19676i = h.f("ffff0000");

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f19677j = Charset.forName("UTF-8");

    /* renamed from: k, reason: collision with root package name */
    public static final Charset f19678k = Charset.forName("ISO-8859-1");

    /* renamed from: l, reason: collision with root package name */
    public static final Charset f19679l = Charset.forName("UTF-16BE");

    /* renamed from: m, reason: collision with root package name */
    public static final Charset f19680m = Charset.forName("UTF-16LE");

    /* renamed from: n, reason: collision with root package name */
    public static final Charset f19681n = Charset.forName("UTF-32BE");

    /* renamed from: o, reason: collision with root package name */
    public static final Charset f19682o = Charset.forName("UTF-32LE");

    /* renamed from: p, reason: collision with root package name */
    public static final TimeZone f19683p = DesugarTimeZone.getTimeZone("GMT");

    /* renamed from: q, reason: collision with root package name */
    public static final Comparator f19684q = new a();

    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19687a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19688b;

        public b(String str, boolean z7) {
            this.f19687a = str;
            this.f19688b = z7;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f19687a);
            thread.setDaemon(this.f19688b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f19668a = bArr;
        Method declaredMethod = null;
        f19670c = B.f(null, bArr);
        f19671d = z.c(null, bArr);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f19685r = declaredMethod;
        f19686s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static X509TrustManager A() throws NoSuchAlgorithmException, KeyStoreException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e7) {
            throw b("No System TLS", e7);
        }
    }

    public static boolean B(A a7, int i7, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jC = a7.c().e() ? a7.c().c() - jNanoTime : Long.MAX_VALUE;
        a7.c().d(Math.min(jC, timeUnit.toNanos(i7)) + jNanoTime);
        try {
            e eVar = new e();
            while (a7.k(eVar, 8192L) != -1) {
                eVar.a();
            }
            if (jC == Long.MAX_VALUE) {
                a7.c().a();
                return true;
            }
            a7.c().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                a7.c().a();
                return false;
            }
            a7.c().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                a7.c().a();
            } else {
                a7.c().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static int C(String str, int i7, int i8) {
        while (i7 < i8) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static int D(String str, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            char cCharAt = str.charAt(i9);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i9 + 1;
            }
        }
        return i7;
    }

    public static ThreadFactory E(String str, boolean z7) {
        return new b(str, z7);
    }

    public static r F(List list) {
        r.a aVar = new r.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            q6.c cVar = (q6.c) it.next();
            l6.a.f19666a.b(aVar, cVar.f21490a.C(), cVar.f21491b.C());
        }
        return aVar.d();
    }

    public static String G(String str, int i7, int i8) {
        int iC = C(str, i7, i8);
        return str.substring(iC, D(str, iC, i8));
    }

    public static boolean H(String str) {
        return f19686s.matcher(str).matches();
    }

    public static void a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f19685r;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError b(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String c(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (h(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressK = (str.startsWith("[") && str.endsWith("]")) ? k(str, 1, str.length() - 1) : k(str, 0, str.length());
        if (inetAddressK == null) {
            return null;
        }
        byte[] address = inetAddressK.getAddress();
        if (address.length == 16) {
            return w(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static void d(long j7, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void e(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused) {
            }
        }
    }

    public static void f(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e7) {
                if (!y(e7)) {
                    throw e7;
                }
            } catch (RuntimeException e8) {
                if (!"bio == null".equals(e8.getMessage())) {
                    throw e8;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String[] g(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static boolean h(String str) {
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int i(char c7) {
        if (c7 >= '0' && c7 <= '9') {
            return c7 - '0';
        }
        if (c7 >= 'a' && c7 <= 'f') {
            return c7 - 'W';
        }
        if (c7 < 'A' || c7 > 'F') {
            return -1;
        }
        return c7 - '7';
    }

    public static boolean j(String str, int i7, int i8, byte[] bArr, int i9) {
        int i10 = i9;
        while (i7 < i8) {
            if (i10 == bArr.length) {
                return false;
            }
            if (i10 != i9) {
                if (str.charAt(i7) != '.') {
                    return false;
                }
                i7++;
            }
            int i11 = i7;
            int i12 = 0;
            while (i11 < i8) {
                char cCharAt = str.charAt(i11);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i12 == 0 && i7 != i11) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i11++;
            }
            if (i11 - i7 == 0) {
                return false;
            }
            bArr[i10] = (byte) i12;
            i10++;
            i7 = i11;
        }
        return i10 == i9 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if (r4 == 16) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r5 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        r12 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress k(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            r7 = 0
            if (r13 >= r14) goto L79
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L79
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = j(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L79
        L4a:
            return r7
        L4b:
            r8 = r2
            r13 = r6
        L4d:
            if (r13 >= r14) goto L60
            char r10 = r12.charAt(r13)
            int r10 = i(r10)
            if (r10 != r3) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L60:
            int r10 = r13 - r6
            if (r10 == 0) goto L78
            r11 = 4
            if (r10 <= r11) goto L68
            goto L78
        L68:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7e
            return r7
        L7e:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8a:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r12
        L8f:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.c.k(java.lang.String, int, int):java.net.InetAddress");
    }

    public static int l(String str, int i7, int i8, char c7) {
        while (i7 < i8) {
            if (str.charAt(i7) == c7) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static int m(String str, int i7, int i8, String str2) {
        while (i7 < i8) {
            if (str2.indexOf(str.charAt(i7)) != -1) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static boolean n(A a7, int i7, TimeUnit timeUnit) {
        try {
            return B(a7, i7, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean o(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String p(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String q(s sVar, boolean z7) {
        String strL;
        if (sVar.l().contains(":")) {
            strL = "[" + sVar.l() + "]";
        } else {
            strL = sVar.l();
        }
        if (!z7 && sVar.w() == s.d(sVar.B())) {
            return strL;
        }
        return strL + ":" + sVar.w();
    }

    public static List r(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List s(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static Map t(Map map) {
        return map.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int u(Comparator comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (comparator.compare(strArr[i7], str) == 0) {
                return i7;
            }
        }
        return -1;
    }

    public static int v(String str) {
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i7;
            }
        }
        return -1;
    }

    public static String w(byte[] bArr) {
        int i7 = -1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < bArr.length) {
            int i11 = i9;
            while (i11 < 16 && bArr[i11] == 0 && bArr[i11 + 1] == 0) {
                i11 += 2;
            }
            int i12 = i11 - i9;
            if (i12 > i10 && i12 >= 4) {
                i7 = i9;
                i10 = i12;
            }
            i9 = i11 + 2;
        }
        e eVar = new e();
        while (i8 < bArr.length) {
            if (i8 == i7) {
                eVar.writeByte(58);
                i8 += i10;
                if (i8 == 16) {
                    eVar.writeByte(58);
                }
            } else {
                if (i8 > 0) {
                    eVar.writeByte(58);
                }
                eVar.w(((bArr[i8] & 255) << 8) | (bArr[i8 + 1] & 255));
                i8 += 2;
            }
        }
        return eVar.G();
    }

    public static String[] x(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i7]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i7++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean y(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean z(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
