package C3;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import u3.C1648d;
import u3.t;

/* loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* renamed from: w, reason: collision with root package name */
    public static final Pattern f1371w = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f1372x = new String[128];

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f1373y;

    /* renamed from: l, reason: collision with root package name */
    public final Writer f1374l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f1375m = new int[32];

    /* renamed from: n, reason: collision with root package name */
    public int f1376n = 0;

    /* renamed from: o, reason: collision with root package name */
    public C1648d f1377o;

    /* renamed from: p, reason: collision with root package name */
    public String f1378p;

    /* renamed from: q, reason: collision with root package name */
    public String f1379q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1380r;

    /* renamed from: s, reason: collision with root package name */
    public t f1381s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1382t;

    /* renamed from: u, reason: collision with root package name */
    public String f1383u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1384v;

    static {
        for (int i7 = 0; i7 <= 31; i7++) {
            f1372x[i7] = String.format("\\u%04x", Integer.valueOf(i7));
        }
        String[] strArr = f1372x;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f1373y = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        G(6);
        this.f1381s = t.LEGACY_STRICT;
        this.f1384v = true;
        Objects.requireNonNull(writer, "out == null");
        this.f1374l = writer;
        J(C1648d.f22794d);
    }

    public static boolean a(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public final void B() throws IOException {
        if (this.f1380r) {
            return;
        }
        this.f1374l.write(this.f1377o.b());
        int i7 = this.f1376n;
        for (int i8 = 1; i8 < i7; i8++) {
            this.f1374l.write(this.f1377o.a());
        }
    }

    public c C() throws IOException {
        if (this.f1383u != null) {
            if (!this.f1384v) {
                this.f1383u = null;
                return this;
            }
            Y();
        }
        e();
        this.f1374l.write("null");
        return this;
    }

    public final c E(int i7, char c7) throws IOException {
        e();
        G(i7);
        this.f1374l.write(c7);
        return this;
    }

    public final int F() {
        int i7 = this.f1376n;
        if (i7 != 0) {
            return this.f1375m[i7 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void G(int i7) {
        int i8 = this.f1376n;
        int[] iArr = this.f1375m;
        if (i8 == iArr.length) {
            this.f1375m = Arrays.copyOf(iArr, i8 * 2);
        }
        int[] iArr2 = this.f1375m;
        int i9 = this.f1376n;
        this.f1376n = i9 + 1;
        iArr2[i9] = i7;
    }

    public final void H(int i7) {
        this.f1375m[this.f1376n - 1] = i7;
    }

    public final void J(C1648d c1648d) {
        Objects.requireNonNull(c1648d);
        this.f1377o = c1648d;
        this.f1379q = ",";
        if (c1648d.c()) {
            this.f1378p = ": ";
            if (this.f1377o.b().isEmpty()) {
                this.f1379q = ", ";
            }
        } else {
            this.f1378p = ":";
        }
        this.f1380r = this.f1377o.b().isEmpty() && this.f1377o.a().isEmpty();
    }

    public final void K(boolean z7) {
        this.f1382t = z7;
    }

    public final void L(boolean z7) {
        this.f1384v = z7;
    }

    public final void M(t tVar) {
        Objects.requireNonNull(tVar);
        this.f1381s = tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f1382t
            if (r0 == 0) goto L7
            java.lang.String[] r0 = C3.c.f1373y
            goto L9
        L7:
            java.lang.String[] r0 = C3.c.f1372x
        L9:
            java.io.Writer r1 = r8.f1374l
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f1374l
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f1374l
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f1374l
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f1374l
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C3.c.N(java.lang.String):void");
    }

    public c P(double d7) throws IOException {
        Y();
        if (this.f1381s == t.LENIENT || !(Double.isNaN(d7) || Double.isInfinite(d7))) {
            e();
            this.f1374l.append((CharSequence) Double.toString(d7));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d7);
    }

    public c R(long j7) throws IOException {
        Y();
        e();
        this.f1374l.write(Long.toString(j7));
        return this;
    }

    public c U(Boolean bool) throws IOException {
        if (bool == null) {
            return C();
        }
        Y();
        e();
        this.f1374l.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c V(Number number) throws IOException {
        if (number == null) {
            return C();
        }
        Y();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!a(cls)) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f1381s != t.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
                }
            } else if (cls != Float.class && cls != Double.class && !f1371w.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        e();
        this.f1374l.append((CharSequence) string);
        return this;
    }

    public c W(String str) throws IOException {
        if (str == null) {
            return C();
        }
        Y();
        e();
        N(str);
        return this;
    }

    public c X(boolean z7) throws IOException {
        Y();
        e();
        this.f1374l.write(z7 ? "true" : "false");
        return this;
    }

    public final void Y() throws IOException {
        if (this.f1383u != null) {
            d();
            N(this.f1383u);
            this.f1383u = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1374l.close();
        int i7 = this.f1376n;
        if (i7 > 1 || (i7 == 1 && this.f1375m[i7 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f1376n = 0;
    }

    public final void d() throws IOException {
        int iF = F();
        if (iF == 5) {
            this.f1374l.write(this.f1379q);
        } else if (iF != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        B();
        H(4);
    }

    public final void e() throws IOException {
        int iF = F();
        if (iF == 1) {
            H(2);
            B();
            return;
        }
        if (iF == 2) {
            this.f1374l.append((CharSequence) this.f1379q);
            B();
        } else {
            if (iF == 4) {
                this.f1374l.append((CharSequence) this.f1378p);
                H(5);
                return;
            }
            if (iF != 6) {
                if (iF != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f1381s != t.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            H(7);
        }
    }

    public c f() throws IOException {
        Y();
        return E(1, '[');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f1376n == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f1374l.flush();
    }

    public c i() throws IOException {
        Y();
        return E(3, '{');
    }

    public final c j(int i7, int i8, char c7) throws IOException {
        int iF = F();
        if (iF != i8 && iF != i7) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f1383u != null) {
            throw new IllegalStateException("Dangling name: " + this.f1383u);
        }
        this.f1376n--;
        if (iF == i8) {
            B();
        }
        this.f1374l.write(c7);
        return this;
    }

    public c n() {
        return j(1, 2, ']');
    }

    public c o() {
        return j(3, 5, '}');
    }

    public final boolean r() {
        return this.f1384v;
    }

    public final t t() {
        return this.f1381s;
    }

    public final boolean u() {
        return this.f1382t;
    }

    public boolean x() {
        return this.f1381s == t.LENIENT;
    }

    public c y(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f1383u != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iF = F();
        if (iF != 3 && iF != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f1383u = str;
        return this;
    }
}
