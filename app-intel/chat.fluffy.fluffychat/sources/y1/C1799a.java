package y1;

import B0.A;
import g1.r;
import j3.o;
import java.util.ArrayDeque;

/* renamed from: y1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1799a implements InterfaceC1801c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23833a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f23834b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final g f23835c = new g();

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC1800b f23836d;

    /* renamed from: e, reason: collision with root package name */
    public int f23837e;

    /* renamed from: f, reason: collision with root package name */
    public int f23838f;

    /* renamed from: g, reason: collision with root package name */
    public long f23839g;

    /* renamed from: y1.a$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23840a;

        /* renamed from: b, reason: collision with root package name */
        public final long f23841b;

        public b(int i7, long j7) {
            this.f23840a = i7;
            this.f23841b = j7;
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

    @Override // y1.InterfaceC1801c
    public boolean a(r rVar) throws A {
        o.q(this.f23836d);
        while (true) {
            b bVar = (b) this.f23834b.peek();
            if (bVar != null && rVar.getPosition() >= bVar.f23841b) {
                this.f23836d.a(((b) this.f23834b.pop()).f23840a);
                return true;
            }
            if (this.f23837e == 0) {
                long jD = this.f23835c.d(rVar, true, false, 4);
                if (jD == -2) {
                    jD = c(rVar);
                }
                if (jD == -1) {
                    return false;
                }
                this.f23838f = (int) jD;
                this.f23837e = 1;
            }
            if (this.f23837e == 1) {
                this.f23839g = this.f23835c.d(rVar, false, true, 8);
                this.f23837e = 2;
            }
            int iB = this.f23836d.b(this.f23838f);
            if (iB != 0) {
                if (iB == 1) {
                    long position = rVar.getPosition();
                    this.f23834b.push(new b(this.f23838f, this.f23839g + position));
                    this.f23836d.g(this.f23838f, position, this.f23839g);
                    this.f23837e = 0;
                    return true;
                }
                if (iB == 2) {
                    long j7 = this.f23839g;
                    if (j7 <= 8) {
                        this.f23836d.h(this.f23838f, e(rVar, (int) j7));
                        this.f23837e = 0;
                        return true;
                    }
                    throw A.a("Invalid integer size: " + this.f23839g, null);
                }
                if (iB == 3) {
                    long j8 = this.f23839g;
                    if (j8 <= 2147483647L) {
                        this.f23836d.d(this.f23838f, f(rVar, (int) j8));
                        this.f23837e = 0;
                        return true;
                    }
                    throw A.a("String element size: " + this.f23839g, null);
                }
                if (iB == 4) {
                    this.f23836d.e(this.f23838f, (int) this.f23839g, rVar);
                    this.f23837e = 0;
                    return true;
                }
                if (iB != 5) {
                    throw A.a("Invalid element type " + iB, null);
                }
                long j9 = this.f23839g;
                if (j9 == 4 || j9 == 8) {
                    this.f23836d.f(this.f23838f, d(rVar, (int) j9));
                    this.f23837e = 0;
                    return true;
                }
                throw A.a("Invalid float size: " + this.f23839g, null);
            }
            rVar.p((int) this.f23839g);
            this.f23837e = 0;
        }
    }

    @Override // y1.InterfaceC1801c
    public void b(InterfaceC1800b interfaceC1800b) {
        this.f23836d = interfaceC1800b;
    }

    public final long c(r rVar) {
        rVar.o();
        while (true) {
            rVar.t(this.f23833a, 0, 4);
            int iC = g.c(this.f23833a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) g.a(this.f23833a, iC, false);
                if (this.f23836d.c(iA)) {
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
        rVar.readFully(this.f23833a, 0, i7);
        long j7 = 0;
        for (int i8 = 0; i8 < i7; i8++) {
            j7 = (j7 << 8) | (this.f23833a[i8] & 255);
        }
        return j7;
    }

    @Override // y1.InterfaceC1801c
    public void reset() {
        this.f23837e = 0;
        this.f23834b.clear();
        this.f23835c.e();
    }
}
