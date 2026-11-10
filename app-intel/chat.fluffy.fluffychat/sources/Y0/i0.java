package Y0;

import B0.H;
import B0.v;
import android.net.Uri;

/* loaded from: classes.dex */
public final class i0 extends B0.H {

    /* renamed from: r, reason: collision with root package name */
    public static final Object f9696r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public static final B0.v f9697s = new v.c().c("SinglePeriodTimeline").g(Uri.EMPTY).a();

    /* renamed from: e, reason: collision with root package name */
    public final long f9698e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9699f;

    /* renamed from: g, reason: collision with root package name */
    public final long f9700g;

    /* renamed from: h, reason: collision with root package name */
    public final long f9701h;

    /* renamed from: i, reason: collision with root package name */
    public final long f9702i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9703j;

    /* renamed from: k, reason: collision with root package name */
    public final long f9704k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9705l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9706m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f9707n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f9708o;

    /* renamed from: p, reason: collision with root package name */
    public final B0.v f9709p;

    /* renamed from: q, reason: collision with root package name */
    public final v.g f9710q;

    public i0(long j7, boolean z7, boolean z8, boolean z9, Object obj, B0.v vVar) {
        this(j7, j7, 0L, 0L, z7, z8, z9, obj, vVar);
    }

    @Override // B0.H
    public int b(Object obj) {
        return f9696r.equals(obj) ? 0 : -1;
    }

    @Override // B0.H
    public H.b g(int i7, H.b bVar, boolean z7) {
        j3.o.o(i7, 1);
        return bVar.t(null, z7 ? f9696r : null, 0, this.f9701h, -this.f9703j);
    }

    @Override // B0.H
    public int i() {
        return 1;
    }

    @Override // B0.H
    public Object m(int i7) {
        j3.o.o(i7, 1);
        return f9696r;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r1
      0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000c, B:5:0x0010, B:7:0x0016, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // B0.H
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public B0.H.c o(int r25, B0.H.c r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 1
            r2 = r25
            j3.o.o(r2, r1)
            long r1 = r0.f9704k
            boolean r14 = r0.f9706m
            if (r14 == 0) goto L2d
            boolean r3 = r0.f9707n
            if (r3 != 0) goto L2d
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2d
            long r3 = r0.f9702i
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L26
        L23:
            r16 = r5
            goto L2f
        L26:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2d
            goto L23
        L2d:
            r16 = r1
        L2f:
            java.lang.Object r4 = B0.H.c.f397q
            B0.v r5 = r0.f9709p
            java.lang.Object r6 = r0.f9708o
            long r7 = r0.f9698e
            long r9 = r0.f9699f
            long r11 = r0.f9700g
            boolean r13 = r0.f9705l
            B0.v$g r15 = r0.f9710q
            long r1 = r0.f9702i
            r21 = 0
            r18 = r1
            long r1 = r0.f9703j
            r20 = 0
            r3 = r26
            r22 = r1
            B0.H$c r1 = r3.g(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: Y0.i0.o(int, B0.H$c, long):B0.H$c");
    }

    @Override // B0.H
    public int p() {
        return 1;
    }

    public i0(long j7, long j8, long j9, long j10, boolean z7, boolean z8, boolean z9, Object obj, B0.v vVar) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j7, j8, j9, j10, z7, z8, false, obj, vVar, z9 ? vVar.f829d : null);
    }

    public i0(long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z7, boolean z8, boolean z9, Object obj, B0.v vVar, v.g gVar) {
        this.f9698e = j7;
        this.f9699f = j8;
        this.f9700g = j9;
        this.f9701h = j10;
        this.f9702i = j11;
        this.f9703j = j12;
        this.f9704k = j13;
        this.f9705l = z7;
        this.f9706m = z8;
        this.f9707n = z9;
        this.f9708o = obj;
        this.f9709p = (B0.v) j3.o.q(vVar);
        this.f9710q = gVar;
    }
}
