package C3;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import u3.t;
import w3.AbstractC1737G;
import w3.x;
import x3.g;

/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: A, reason: collision with root package name */
    public int[] f1344A;

    /* renamed from: l, reason: collision with root package name */
    public final Reader f1345l;

    /* renamed from: u, reason: collision with root package name */
    public long f1354u;

    /* renamed from: v, reason: collision with root package name */
    public int f1355v;

    /* renamed from: w, reason: collision with root package name */
    public String f1356w;

    /* renamed from: x, reason: collision with root package name */
    public int[] f1357x;

    /* renamed from: z, reason: collision with root package name */
    public String[] f1359z;

    /* renamed from: m, reason: collision with root package name */
    public t f1346m = t.LEGACY_STRICT;

    /* renamed from: n, reason: collision with root package name */
    public int f1347n = 255;

    /* renamed from: o, reason: collision with root package name */
    public final char[] f1348o = new char[1024];

    /* renamed from: p, reason: collision with root package name */
    public int f1349p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f1350q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f1351r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f1352s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f1353t = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f1358y = 1;

    /* renamed from: C3.a$a, reason: collision with other inner class name */
    public class C0013a extends x {
        @Override // w3.x
        public void a(a aVar) throws IOException {
            if (aVar instanceof g) {
                ((g) aVar).n0();
                return;
            }
            int iJ = aVar.f1353t;
            if (iJ == 0) {
                iJ = aVar.j();
            }
            if (iJ == 13) {
                aVar.f1353t = 9;
            } else if (iJ == 12) {
                aVar.f1353t = 8;
            } else {
                if (iJ != 14) {
                    throw aVar.h0("a name");
                }
                aVar.f1353t = 10;
            }
        }
    }

    static {
        x.f23347a = new C0013a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f1357x = iArr;
        iArr[0] = 6;
        this.f1359z = new String[32];
        this.f1344A = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f1345l = reader;
    }

    private String u(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i7 = 0;
        while (true) {
            int i8 = this.f1358y;
            if (i7 >= i8) {
                return sb.toString();
            }
            int i9 = this.f1357x[i7];
            switch (i9) {
                case 1:
                case 2:
                    int i10 = this.f1344A[i7];
                    if (z7 && i10 > 0 && i7 == i8 - 1) {
                        i10--;
                    }
                    sb.append('[');
                    sb.append(i10);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.f1359z[i7];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i9);
            }
            i7++;
        }
    }

    public boolean B() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        return (iJ == 2 || iJ == 4 || iJ == 17) ? false : true;
    }

    public final boolean C() {
        return this.f1346m == t.LENIENT;
    }

    public final boolean E(char c7) throws d {
        if (c7 == '\t' || c7 == '\n' || c7 == '\f' || c7 == '\r' || c7 == ' ') {
            return false;
        }
        if (c7 != '#') {
            if (c7 == ',') {
                return false;
            }
            if (c7 != '/' && c7 != '=') {
                if (c7 == '{' || c7 == '}' || c7 == ':') {
                    return false;
                }
                if (c7 != ';') {
                    switch (c7) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        f();
        return false;
    }

    public String F() {
        return " at line " + (this.f1351r + 1) + " column " + ((this.f1349p - this.f1352s) + 1) + " path " + t();
    }

    public boolean G() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ == 5) {
            this.f1353t = 0;
            int[] iArr = this.f1344A;
            int i7 = this.f1358y - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        }
        if (iJ != 6) {
            throw h0("a boolean");
        }
        this.f1353t = 0;
        int[] iArr2 = this.f1344A;
        int i8 = this.f1358y - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return false;
    }

    public double H() throws IOException, NumberFormatException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ == 15) {
            this.f1353t = 0;
            int[] iArr = this.f1344A;
            int i7 = this.f1358y - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f1354u;
        }
        if (iJ == 16) {
            this.f1356w = new String(this.f1348o, this.f1349p, this.f1355v);
            this.f1349p += this.f1355v;
        } else if (iJ == 8 || iJ == 9) {
            this.f1356w = P(iJ == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (iJ == 10) {
            this.f1356w = U();
        } else if (iJ != 11) {
            throw h0("a double");
        }
        this.f1353t = 11;
        double d7 = Double.parseDouble(this.f1356w);
        if (this.f1346m != t.LENIENT && (Double.isNaN(d7) || Double.isInfinite(d7))) {
            throw g0("JSON forbids NaN and infinities: " + d7);
        }
        this.f1356w = null;
        this.f1353t = 0;
        int[] iArr2 = this.f1344A;
        int i8 = this.f1358y - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return d7;
    }

    public int J() throws IOException, NumberFormatException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ == 15) {
            long j7 = this.f1354u;
            int i7 = (int) j7;
            if (j7 == i7) {
                this.f1353t = 0;
                int[] iArr = this.f1344A;
                int i8 = this.f1358y - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
            throw new NumberFormatException("Expected an int but was " + this.f1354u + F());
        }
        if (iJ == 16) {
            this.f1356w = new String(this.f1348o, this.f1349p, this.f1355v);
            this.f1349p += this.f1355v;
        } else {
            if (iJ != 8 && iJ != 9 && iJ != 10) {
                throw h0("an int");
            }
            if (iJ == 10) {
                this.f1356w = U();
            } else {
                this.f1356w = P(iJ == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            try {
                int i9 = Integer.parseInt(this.f1356w);
                this.f1353t = 0;
                int[] iArr2 = this.f1344A;
                int i10 = this.f1358y - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return i9;
            } catch (NumberFormatException unused) {
            }
        }
        this.f1353t = 11;
        double d7 = Double.parseDouble(this.f1356w);
        int i11 = (int) d7;
        if (i11 != d7) {
            throw new NumberFormatException("Expected an int but was " + this.f1356w + F());
        }
        this.f1356w = null;
        this.f1353t = 0;
        int[] iArr3 = this.f1344A;
        int i12 = this.f1358y - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return i11;
    }

    public long K() throws IOException, NumberFormatException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ == 15) {
            this.f1353t = 0;
            int[] iArr = this.f1344A;
            int i7 = this.f1358y - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f1354u;
        }
        if (iJ == 16) {
            this.f1356w = new String(this.f1348o, this.f1349p, this.f1355v);
            this.f1349p += this.f1355v;
        } else {
            if (iJ != 8 && iJ != 9 && iJ != 10) {
                throw h0("a long");
            }
            if (iJ == 10) {
                this.f1356w = U();
            } else {
                this.f1356w = P(iJ == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            try {
                long j7 = Long.parseLong(this.f1356w);
                this.f1353t = 0;
                int[] iArr2 = this.f1344A;
                int i8 = this.f1358y - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return j7;
            } catch (NumberFormatException unused) {
            }
        }
        this.f1353t = 11;
        double d7 = Double.parseDouble(this.f1356w);
        long j8 = (long) d7;
        if (j8 != d7) {
            throw new NumberFormatException("Expected a long but was " + this.f1356w + F());
        }
        this.f1356w = null;
        this.f1353t = 0;
        int[] iArr3 = this.f1344A;
        int i9 = this.f1358y - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return j8;
    }

    public String L() throws IOException {
        String strP;
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ == 14) {
            strP = U();
        } else if (iJ == 12) {
            strP = P('\'');
        } else {
            if (iJ != 13) {
                throw h0("a name");
            }
            strP = P(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        this.f1353t = 0;
        this.f1359z[this.f1358y - 1] = strP;
        return strP;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int M(boolean r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.f1348o
            int r1 = r8.f1349p
            int r2 = r8.f1350q
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r8.f1349p = r1
            boolean r1 = r8.r(r3)
            if (r1 != 0) goto L30
            if (r9 != 0) goto L15
            r9 = -1
            return r9
        L15:
            java.io.EOFException r9 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r8.F()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L30:
            int r1 = r8.f1349p
            int r2 = r8.f1350q
        L34:
            int r4 = r1 + 1
            char r5 = r0[r1]
            r6 = 10
            if (r5 != r6) goto L45
            int r1 = r8.f1351r
            int r1 = r1 + r3
            r8.f1351r = r1
            r8.f1352s = r4
            goto Lb2
        L45:
            r6 = 32
            if (r5 == r6) goto Lb2
            r6 = 13
            if (r5 == r6) goto Lb2
            r6 = 9
            if (r5 != r6) goto L52
            goto Lb2
        L52:
            r6 = 47
            if (r5 != r6) goto L9d
            r8.f1349p = r4
            r7 = 2
            if (r4 != r2) goto L69
            r8.f1349p = r1
            boolean r1 = r8.r(r7)
            int r2 = r8.f1349p
            int r2 = r2 + r3
            r8.f1349p = r2
            if (r1 != 0) goto L69
            goto L76
        L69:
            r8.f()
            int r1 = r8.f1349p
            char r2 = r0[r1]
            r3 = 42
            if (r2 == r3) goto L83
            if (r2 == r6) goto L77
        L76:
            return r5
        L77:
            int r1 = r1 + 1
            r8.f1349p = r1
            r8.d0()
            int r1 = r8.f1349p
            int r2 = r8.f1350q
            goto L6
        L83:
            int r1 = r1 + 1
            r8.f1349p = r1
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r8.c0(r1)
            if (r1 == 0) goto L96
            int r1 = r8.f1349p
            int r1 = r1 + r7
            int r2 = r8.f1350q
            goto L6
        L96:
            java.lang.String r9 = "Unterminated comment"
            C3.d r9 = r8.g0(r9)
            throw r9
        L9d:
            r1 = 35
            if (r5 != r1) goto Laf
            r8.f1349p = r4
            r8.f()
            r8.d0()
            int r1 = r8.f1349p
            int r2 = r8.f1350q
            goto L6
        Laf:
            r8.f1349p = r4
            return r5
        Lb2:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: C3.a.M(boolean):int");
    }

    public void N() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ != 7) {
            throw h0("null");
        }
        this.f1353t = 0;
        int[] iArr = this.f1344A;
        int i7 = this.f1358y - 1;
        iArr[i7] = iArr[i7] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r10.f1349p = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String P(char r11) throws C3.d {
        /*
            r10 = this;
            char[] r0 = r10.f1348o
            r1 = 0
        L3:
            int r2 = r10.f1349p
            int r3 = r10.f1350q
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L6c
            int r7 = r2 + 1
            char r2 = r0[r2]
            u3.t r8 = r10.f1346m
            u3.t r9 = u3.t.STRICT
            if (r8 != r9) goto L24
            r8 = 32
            if (r2 < r8) goto L1d
            goto L24
        L1d:
            java.lang.String r11 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            C3.d r11 = r10.g0(r11)
            throw r11
        L24:
            if (r2 != r11) goto L3a
            r10.f1349p = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L32
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r3, r7)
            return r11
        L32:
            r1.append(r0, r3, r7)
            java.lang.String r11 = r1.toString()
            return r11
        L3a:
            r8 = 92
            if (r2 != r8) goto L5f
            r10.f1349p = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L50
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L50:
            r1.append(r0, r3, r2)
            char r2 = r10.Z()
            r1.append(r2)
            int r2 = r10.f1349p
            int r3 = r10.f1350q
            goto L7
        L5f:
            r5 = 10
            if (r2 != r5) goto L6a
            int r2 = r10.f1351r
            int r2 = r2 + r6
            r10.f1351r = r2
            r10.f1352s = r7
        L6a:
            r2 = r7
            goto L9
        L6c:
            if (r1 != 0) goto L7c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r10.f1349p = r2
            boolean r2 = r10.r(r6)
            if (r2 == 0) goto L8b
            goto L3
        L8b:
            java.lang.String r11 = "Unterminated string"
            C3.d r11 = r10.g0(r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: C3.a.P(char):java.lang.String");
    }

    public String R() throws IOException {
        String str;
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ == 10) {
            str = U();
        } else if (iJ == 8) {
            str = P('\'');
        } else if (iJ == 9) {
            str = P(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (iJ == 11) {
            str = this.f1356w;
            this.f1356w = null;
        } else if (iJ == 15) {
            str = Long.toString(this.f1354u);
        } else {
            if (iJ != 16) {
                throw h0("a string");
            }
            str = new String(this.f1348o, this.f1349p, this.f1355v);
            this.f1349p += this.f1355v;
        }
        this.f1353t = 0;
        int[] iArr = this.f1344A;
        int i7 = this.f1358y - 1;
        iArr[i7] = iArr[i7] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        f();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String U() throws C3.d {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f1349p
            int r4 = r3 + r2
            int r5 = r6.f1350q
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f1348o
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.f()
            goto L5c
        L4e:
            char[] r3 = r6.f1348o
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.r(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f1348o
            int r4 = r6.f1349p
            r0.append(r3, r4, r2)
            int r3 = r6.f1349p
            int r3 = r3 + r2
            r6.f1349p = r3
            r2 = 1
            boolean r2 = r6.r(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f1348o
            int r3 = r6.f1349p
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f1348o
            int r3 = r6.f1349p
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f1349p
            int r2 = r2 + r1
            r6.f1349p = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: C3.a.U():java.lang.String");
    }

    public b V() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        switch (iJ) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case StdKeyDeserializer.TYPE_URL /* 14 */:
                return b.NAME;
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
            case 16:
                return b.NUMBER;
            case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int W() {
        String str;
        String str2;
        int i7;
        char c7 = this.f1348o[this.f1349p];
        if (c7 == 't' || c7 == 'T') {
            str = "true";
            str2 = "TRUE";
            i7 = 5;
        } else if (c7 == 'f' || c7 == 'F') {
            str = "false";
            str2 = "FALSE";
            i7 = 6;
        } else {
            if (c7 != 'n' && c7 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i7 = 7;
        }
        boolean z7 = this.f1346m != t.STRICT;
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (this.f1349p + i8 >= this.f1350q && !r(i8 + 1)) {
                return 0;
            }
            char c8 = this.f1348o[this.f1349p + i8];
            if (c8 != str.charAt(i8) && (!z7 || c8 != str2.charAt(i8))) {
                return 0;
            }
        }
        if ((this.f1349p + length < this.f1350q || r(length + 1)) && E(this.f1348o[this.f1349p + length])) {
            return 0;
        }
        this.f1349p += length;
        this.f1353t = i7;
        return i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (E(r14) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        if (r9 != 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        if (r10 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009d, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
    
        if (r11 != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        if (r13 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
    
        if (r13 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
    
        r19.f1354u = r11;
        r19.f1349p += r8;
        r19.f1353t = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b7, code lost:
    
        if (r9 == 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
    
        if (r9 == 4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bd, code lost:
    
        if (r9 != 7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
    
        r19.f1355v = r8;
        r19.f1353t = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c7, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c8, code lost:
    
        return r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int X() {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C3.a.X():int");
    }

    public final void Y(int i7) throws d {
        int i8 = this.f1358y;
        if (i8 - 1 >= this.f1347n) {
            throw new d("Nesting limit " + this.f1347n + " reached" + F());
        }
        int[] iArr = this.f1357x;
        if (i8 == iArr.length) {
            int i9 = i8 * 2;
            this.f1357x = Arrays.copyOf(iArr, i9);
            this.f1344A = Arrays.copyOf(this.f1344A, i9);
            this.f1359z = (String[]) Arrays.copyOf(this.f1359z, i9);
        }
        int[] iArr2 = this.f1357x;
        int i10 = this.f1358y;
        this.f1358y = i10 + 1;
        iArr2[i10] = i7;
    }

    public final char Z() throws d {
        int i7;
        if (this.f1349p == this.f1350q && !r(1)) {
            throw g0("Unterminated escape sequence");
        }
        char[] cArr = this.f1348o;
        int i8 = this.f1349p;
        int i9 = i8 + 1;
        this.f1349p = i9;
        char c7 = cArr[i8];
        if (c7 != '\n') {
            if (c7 != '\"') {
                if (c7 != '\'') {
                    if (c7 != '/' && c7 != '\\') {
                        if (c7 == 'b') {
                            return '\b';
                        }
                        if (c7 == 'f') {
                            return '\f';
                        }
                        if (c7 == 'n') {
                            return '\n';
                        }
                        if (c7 == 'r') {
                            return '\r';
                        }
                        if (c7 == 't') {
                            return '\t';
                        }
                        if (c7 != 'u') {
                            throw g0("Invalid escape sequence");
                        }
                        if (i8 + 5 > this.f1350q && !r(4)) {
                            throw g0("Unterminated escape sequence");
                        }
                        int i10 = this.f1349p;
                        int i11 = i10 + 4;
                        int i12 = 0;
                        while (i10 < i11) {
                            char c8 = this.f1348o[i10];
                            int i13 = i12 << 4;
                            if (c8 >= '0' && c8 <= '9') {
                                i7 = c8 - '0';
                            } else if (c8 >= 'a' && c8 <= 'f') {
                                i7 = c8 - 'W';
                            } else {
                                if (c8 < 'A' || c8 > 'F') {
                                    throw g0("Malformed Unicode escape \\u" + new String(this.f1348o, this.f1349p, 4));
                                }
                                i7 = c8 - '7';
                            }
                            i12 = i13 + i7;
                            i10++;
                        }
                        this.f1349p += 4;
                        return (char) i12;
                    }
                }
            }
            return c7;
        }
        if (this.f1346m == t.STRICT) {
            throw g0("Cannot escape a newline character in strict mode");
        }
        this.f1351r++;
        this.f1352s = i9;
        if (this.f1346m == t.STRICT) {
            throw g0("Invalid escaped character \"'\" in strict mode");
        }
        return c7;
    }

    public final void a0(t tVar) {
        Objects.requireNonNull(tVar);
        this.f1346m = tVar;
    }

    public final void b0(char c7) throws d {
        char[] cArr = this.f1348o;
        do {
            int i7 = this.f1349p;
            int i8 = this.f1350q;
            while (i7 < i8) {
                int i9 = i7 + 1;
                char c8 = cArr[i7];
                if (c8 == c7) {
                    this.f1349p = i9;
                    return;
                }
                if (c8 == '\\') {
                    this.f1349p = i9;
                    Z();
                    i7 = this.f1349p;
                    i8 = this.f1350q;
                } else {
                    if (c8 == '\n') {
                        this.f1351r++;
                        this.f1352s = i9;
                    }
                    i7 = i9;
                }
            }
            this.f1349p = i7;
        } while (r(1));
        throw g0("Unterminated string");
    }

    public final boolean c0(String str) {
        int length = str.length();
        while (true) {
            if (this.f1349p + length > this.f1350q && !r(length)) {
                return false;
            }
            char[] cArr = this.f1348o;
            int i7 = this.f1349p;
            if (cArr[i7] != '\n') {
                for (int i8 = 0; i8 < length; i8++) {
                    if (this.f1348o[this.f1349p + i8] != str.charAt(i8)) {
                        break;
                    }
                }
                return true;
            }
            this.f1351r++;
            this.f1352s = i7 + 1;
            this.f1349p++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1353t = 0;
        this.f1357x[0] = 8;
        this.f1358y = 1;
        this.f1345l.close();
    }

    public void d() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ != 3) {
            throw h0("BEGIN_ARRAY");
        }
        Y(1);
        this.f1344A[this.f1358y - 1] = 0;
        this.f1353t = 0;
    }

    public final void d0() {
        char c7;
        do {
            if (this.f1349p >= this.f1350q && !r(1)) {
                return;
            }
            char[] cArr = this.f1348o;
            int i7 = this.f1349p;
            int i8 = i7 + 1;
            this.f1349p = i8;
            c7 = cArr[i7];
            if (c7 == '\n') {
                this.f1351r++;
                this.f1352s = i8;
                return;
            }
        } while (c7 != '\r');
    }

    public void e() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ != 1) {
            throw h0("BEGIN_OBJECT");
        }
        Y(3);
        this.f1353t = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0() throws C3.d {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f1349p
            int r2 = r1 + r0
            int r3 = r4.f1350q
            if (r2 >= r3) goto L51
            char[] r2 = r4.f1348o
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.f()
        L4b:
            int r1 = r4.f1349p
            int r1 = r1 + r0
            r4.f1349p = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f1349p = r1
            r0 = 1
            boolean r0 = r4.r(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C3.a.e0():void");
    }

    public final void f() throws d {
        if (this.f1346m != t.LENIENT) {
            throw g0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void f0() throws IOException {
        int i7 = 0;
        do {
            int iJ = this.f1353t;
            if (iJ == 0) {
                iJ = j();
            }
            switch (iJ) {
                case 1:
                    Y(3);
                    i7++;
                    this.f1353t = 0;
                    break;
                case 2:
                    if (i7 == 0) {
                        this.f1359z[this.f1358y - 1] = null;
                    }
                    this.f1358y--;
                    i7--;
                    this.f1353t = 0;
                    break;
                case 3:
                    Y(1);
                    i7++;
                    this.f1353t = 0;
                    break;
                case 4:
                    this.f1358y--;
                    i7--;
                    this.f1353t = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                default:
                    this.f1353t = 0;
                    break;
                case 8:
                    b0('\'');
                    this.f1353t = 0;
                    break;
                case 9:
                    b0(JsonFactory.DEFAULT_QUOTE_CHAR);
                    this.f1353t = 0;
                    break;
                case 10:
                    e0();
                    this.f1353t = 0;
                    break;
                case 12:
                    b0('\'');
                    if (i7 == 0) {
                        this.f1359z[this.f1358y - 1] = "<skipped>";
                    }
                    this.f1353t = 0;
                    break;
                case 13:
                    b0(JsonFactory.DEFAULT_QUOTE_CHAR);
                    if (i7 == 0) {
                        this.f1359z[this.f1358y - 1] = "<skipped>";
                    }
                    this.f1353t = 0;
                    break;
                case StdKeyDeserializer.TYPE_URL /* 14 */:
                    e0();
                    if (i7 == 0) {
                        this.f1359z[this.f1358y - 1] = "<skipped>";
                    }
                    this.f1353t = 0;
                    break;
                case 16:
                    this.f1349p += this.f1355v;
                    this.f1353t = 0;
                    break;
                case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                    break;
            }
            return;
        } while (i7 > 0);
        int[] iArr = this.f1344A;
        int i8 = this.f1358y - 1;
        iArr[i8] = iArr[i8] + 1;
    }

    public final d g0(String str) throws d {
        throw new d(str + F() + "\nSee " + AbstractC1737G.a("malformed-json"));
    }

    public final IllegalStateException h0(String str) {
        return new IllegalStateException("Expected " + str + " but was " + V() + F() + "\nSee " + AbstractC1737G.a(V() == b.NULL ? "adapter-not-null-safe" : "unexpected-json-structure"));
    }

    public final void i() throws IOException {
        M(true);
        int i7 = this.f1349p;
        this.f1349p = i7 - 1;
        if (i7 + 4 <= this.f1350q || r(5)) {
            int i8 = this.f1349p;
            char[] cArr = this.f1348o;
            if (cArr[i8] == ')' && cArr[i8 + 1] == ']' && cArr[i8 + 2] == '}' && cArr[i8 + 3] == '\'' && cArr[i8 + 4] == '\n') {
                this.f1349p = i8 + 5;
            }
        }
    }

    public int j() throws IOException {
        int iM;
        int[] iArr = this.f1357x;
        int i7 = this.f1358y;
        int i8 = iArr[i7 - 1];
        if (i8 == 1) {
            iArr[i7 - 1] = 2;
        } else if (i8 == 2) {
            int iM2 = M(true);
            if (iM2 != 44) {
                if (iM2 != 59) {
                    if (iM2 != 93) {
                        throw g0("Unterminated array");
                    }
                    this.f1353t = 4;
                    return 4;
                }
                f();
            }
        } else {
            if (i8 == 3 || i8 == 5) {
                iArr[i7 - 1] = 4;
                if (i8 == 5 && (iM = M(true)) != 44) {
                    if (iM != 59) {
                        if (iM != 125) {
                            throw g0("Unterminated object");
                        }
                        this.f1353t = 2;
                        return 2;
                    }
                    f();
                }
                int iM3 = M(true);
                if (iM3 == 34) {
                    this.f1353t = 13;
                    return 13;
                }
                if (iM3 == 39) {
                    f();
                    this.f1353t = 12;
                    return 12;
                }
                if (iM3 == 125) {
                    if (i8 == 5) {
                        throw g0("Expected name");
                    }
                    this.f1353t = 2;
                    return 2;
                }
                f();
                this.f1349p--;
                if (!E((char) iM3)) {
                    throw g0("Expected name");
                }
                this.f1353t = 14;
                return 14;
            }
            if (i8 == 4) {
                iArr[i7 - 1] = 5;
                int iM4 = M(true);
                if (iM4 != 58) {
                    if (iM4 != 61) {
                        throw g0("Expected ':'");
                    }
                    f();
                    if (this.f1349p < this.f1350q || r(1)) {
                        char[] cArr = this.f1348o;
                        int i9 = this.f1349p;
                        if (cArr[i9] == '>') {
                            this.f1349p = i9 + 1;
                        }
                    }
                }
            } else if (i8 == 6) {
                if (this.f1346m == t.LENIENT) {
                    i();
                }
                this.f1357x[this.f1358y - 1] = 7;
            } else if (i8 == 7) {
                if (M(false) == -1) {
                    this.f1353t = 17;
                    return 17;
                }
                f();
                this.f1349p--;
            } else if (i8 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iM5 = M(true);
        if (iM5 == 34) {
            this.f1353t = 9;
            return 9;
        }
        if (iM5 == 39) {
            f();
            this.f1353t = 8;
            return 8;
        }
        if (iM5 != 44 && iM5 != 59) {
            if (iM5 == 91) {
                this.f1353t = 3;
                return 3;
            }
            if (iM5 != 93) {
                if (iM5 == 123) {
                    this.f1353t = 1;
                    return 1;
                }
                this.f1349p--;
                int iW = W();
                if (iW != 0) {
                    return iW;
                }
                int iX = X();
                if (iX != 0) {
                    return iX;
                }
                if (!E(this.f1348o[this.f1349p])) {
                    throw g0("Expected value");
                }
                f();
                this.f1353t = 10;
                return 10;
            }
            if (i8 == 1) {
                this.f1353t = 4;
                return 4;
            }
        }
        if (i8 != 1 && i8 != 2) {
            throw g0("Unexpected value");
        }
        f();
        this.f1349p--;
        this.f1353t = 7;
        return 7;
    }

    public void n() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ != 4) {
            throw h0("END_ARRAY");
        }
        int i7 = this.f1358y;
        this.f1358y = i7 - 1;
        int[] iArr = this.f1344A;
        int i8 = i7 - 2;
        iArr[i8] = iArr[i8] + 1;
        this.f1353t = 0;
    }

    public void o() throws IOException {
        int iJ = this.f1353t;
        if (iJ == 0) {
            iJ = j();
        }
        if (iJ != 2) {
            throw h0("END_OBJECT");
        }
        int i7 = this.f1358y;
        int i8 = i7 - 1;
        this.f1358y = i8;
        this.f1359z[i8] = null;
        int[] iArr = this.f1344A;
        int i9 = i7 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.f1353t = 0;
    }

    public final boolean r(int i7) throws IOException {
        int i8;
        int i9;
        char[] cArr = this.f1348o;
        int i10 = this.f1352s;
        int i11 = this.f1349p;
        this.f1352s = i10 - i11;
        int i12 = this.f1350q;
        if (i12 != i11) {
            int i13 = i12 - i11;
            this.f1350q = i13;
            System.arraycopy(cArr, i11, cArr, 0, i13);
        } else {
            this.f1350q = 0;
        }
        this.f1349p = 0;
        do {
            Reader reader = this.f1345l;
            int i14 = this.f1350q;
            int i15 = reader.read(cArr, i14, cArr.length - i14);
            if (i15 == -1) {
                return false;
            }
            i8 = this.f1350q + i15;
            this.f1350q = i8;
            if (this.f1351r == 0 && (i9 = this.f1352s) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.f1349p++;
                this.f1352s = i9 + 1;
                i7++;
            }
        } while (i8 < i7);
        return true;
    }

    public String t() {
        return u(false);
    }

    public String toString() {
        return getClass().getSimpleName() + F();
    }

    public String x() {
        return u(true);
    }

    public final t y() {
        return this.f1346m;
    }
}
