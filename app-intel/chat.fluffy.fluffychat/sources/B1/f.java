package B1;

import B0.A;
import E0.E;
import g1.AbstractC1090t;
import g1.r;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f1089a;

    /* renamed from: b, reason: collision with root package name */
    public int f1090b;

    /* renamed from: c, reason: collision with root package name */
    public long f1091c;

    /* renamed from: d, reason: collision with root package name */
    public long f1092d;

    /* renamed from: e, reason: collision with root package name */
    public long f1093e;

    /* renamed from: f, reason: collision with root package name */
    public long f1094f;

    /* renamed from: g, reason: collision with root package name */
    public int f1095g;

    /* renamed from: h, reason: collision with root package name */
    public int f1096h;

    /* renamed from: i, reason: collision with root package name */
    public int f1097i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f1098j = new int[255];

    /* renamed from: k, reason: collision with root package name */
    public final E f1099k = new E(255);

    public boolean a(r rVar, boolean z7) throws A {
        b();
        this.f1099k.b0(27);
        if (!AbstractC1090t.c(rVar, this.f1099k.f(), 0, 27, z7) || this.f1099k.S() != 1332176723) {
            return false;
        }
        int iQ = this.f1099k.Q();
        this.f1089a = iQ;
        if (iQ != 0) {
            if (z7) {
                return false;
            }
            throw A.e("unsupported bit stream revision");
        }
        this.f1090b = this.f1099k.Q();
        this.f1091c = this.f1099k.E();
        this.f1092d = this.f1099k.G();
        this.f1093e = this.f1099k.G();
        this.f1094f = this.f1099k.G();
        int iQ2 = this.f1099k.Q();
        this.f1095g = iQ2;
        this.f1096h = iQ2 + 27;
        this.f1099k.b0(iQ2);
        if (!AbstractC1090t.c(rVar, this.f1099k.f(), 0, this.f1095g, z7)) {
            return false;
        }
        for (int i7 = 0; i7 < this.f1095g; i7++) {
            this.f1098j[i7] = this.f1099k.Q();
            this.f1097i += this.f1098j[i7];
        }
        return true;
    }

    public void b() {
        this.f1089a = 0;
        this.f1090b = 0;
        this.f1091c = 0L;
        this.f1092d = 0L;
        this.f1093e = 0L;
        this.f1094f = 0L;
        this.f1095g = 0;
        this.f1096h = 0;
        this.f1097i = 0;
    }

    public boolean c(r rVar) {
        return d(rVar, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.a(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(g1.r r9, long r10) {
        /*
            r8 = this;
            long r0 = r9.getPosition()
            long r2 = r9.i()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            j3.o.d(r0)
            E0.E r0 = r8.f1099k
            r3 = 4
            r0.b0(r3)
        L1a:
            r4 = -1
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L2b
            long r4 = r9.getPosition()
            r6 = 4
            long r4 = r4 + r6
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 >= 0) goto L51
        L2b:
            E0.E r4 = r8.f1099k
            byte[] r4 = r4.f()
            boolean r4 = g1.AbstractC1090t.c(r9, r4, r1, r3, r2)
            if (r4 == 0) goto L51
            E0.E r0 = r8.f1099k
            r0.f0(r1)
            E0.E r0 = r8.f1099k
            long r4 = r0.S()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L4d
            r9.o()
            return r2
        L4d:
            r9.p(r2)
            goto L1a
        L51:
            if (r0 == 0) goto L5b
            long r3 = r9.getPosition()
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 >= 0) goto L63
        L5b:
            int r3 = r9.a(r2)
            r4 = -1
            if (r3 == r4) goto L63
            goto L51
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.f.d(g1.r, long):boolean");
    }
}
