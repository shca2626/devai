package y1;

import B0.A;
import g1.r;
import j3.o;
import java.util.ArrayDeque;

/* renamed from: y1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1800a implements InterfaceC1802c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23827a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f23828b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final g f23829c = new g();

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC1801b f23830d;

    /* renamed from: e, reason: collision with root package name */
    public int f23831e;

    /* renamed from: f, reason: collision with root package name */
    public int f23832f;

    /* renamed from: g, reason: collision with root package name */
    public long f23833g;

    /* renamed from: y1.a$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23834a;

        /* renamed from: b, reason: collision with root package name */
        public final long f23835b;

        public b(int i7, long j7) {
            this.f23834a = i7;
            this.f23835b = j7;
        }
    }

    public static String f(r rVar, int i7) {
        if (i7 == 0) {
            return "";
        }
        byte[] bArr = new byte[i7];
        rVar.readFully(bArr, 0, i7);
        while (i7 > 0 && bArr[i7 - 1] == 0) {
            i7--;
        }
        return new String(bArr, 0, i7);
    }

    @Override // y1.InterfaceC1802c
    public boolean a(r rVar) throws A {
        o.q(this.f23830d);
        while (true) {
            b bVar = (b) this.f23828b.peek();
            if (bVar != null && rVar.getPosition() >= bVar.f23835b) {
                this.f23830d.a(((b) this.f23828b.pop()).f23834a);
                return true;
            }
            if (this.f23831e == 0) {
                long jD = this.f23829c.d(rVar, true, false, 4);
                if (jD == -2) {
                    jD = c(rVar);
                }
                if (jD == -1) {
                    return false;
                }
                this.f23832f = (int) jD;
                this.f23831e = 1;
            }
            if (this.f23831e == 1) {
                this.f23833g = this.f23829c.d(rVar, false, true, 8);
                this.f23831e = 2;
            }
            int iB = this.f23830d.b(this.f23832f);
            if (iB != 0) {
                if (iB == 1) {
                    long position = rVar.getPosition();
                    this.f23828b.push(new b(this.f23832f, this.f23833g + position));
                    this.f23830d.g(this.f23832f, position, this.f23833g);
                    this.f23831e = 0;
                    return true;
                }
                if (iB == 2) {
                    long j7 = this.f23833g;
                    if (j7 <= 8) {
                        this.f23830d.h(this.f23832f, e(rVar, (int) j7));
                        this.f23831e = 0;
                        return true;
                    }
                    throw A.a("Invalid integer size: " + this.f23833g, null);
                }
                if (iB == 3) {
                    long j8 = this.f23833g;
                    if (j8 <= 2147483647L) {
                        this.f23830d.d(this.f23832f, f(rVar, (int) j8));
                        this.f23831e = 0;
                        return true;
                    }
                    throw A.a("String element size: " + this.f23833g, null);
                }
                if (iB == 4) {
                    this.f23830d.e(this.f23832f, (int) this.f23833g, rVar);
                    this.f23831e = 0;
                    return true;
                }
                if (iB != 5) {
                    throw A.a("Invalid element type " + iB, null);
                }
                long j9 = this.f23833g;
                if (j9 == 4 || j9 == 8) {
                    this.f23830d.f(this.f23832f, d(rVar, (int) j9));
                    this.f23831e = 0;
                    return true;
                }
                throw A.a("Invalid float size: " + this.f23833g, null);
            }
            rVar.p((int) this.f23833g);
            this.f23831e = 0;
        }
    }

    @Override // y1.InterfaceC1802c
    public void b(InterfaceC1801b interfaceC1801b) {
        this.f23830d = interfaceC1801b;
    }

    public final long c(r rVar) {
        rVar.o();
        while (true) {
            rVar.t(this.f23827a, 0, 4);
            int iC = g.c(this.f23827a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) g.a(this.f23827a, iC, false);
                if (this.f23830d.c(iA)) {
                    rVar.p(iC);
                    return iA;
                }
            }
            rVar.p(1);
        }
    }

    public final double d(r rVar, int i7) {
        return i7 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(rVar, i7));
    }

    public final long e(r rVar, int i7) {
        rVar.readFully(this.f23827a, 0, i7);
        long j7 = 0;
        for (int i8 = 0; i8 < i7; i8++) {
            j7 = (j7 << 8) | (this.f23827a[i8] & 255);
        }
        return j7;
    }

    @Override // y1.InterfaceC1802c
    public void reset() {
        this.f23831e = 0;
        this.f23828b.clear();
        this.f23829c.e();
    }
}
