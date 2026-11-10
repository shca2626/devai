package I0;

/* loaded from: classes.dex */
public final class J1 {

    /* renamed from: c, reason: collision with root package name */
    public static final J1 f3702c;

    /* renamed from: d, reason: collision with root package name */
    public static final J1 f3703d;

    /* renamed from: e, reason: collision with root package name */
    public static final J1 f3704e;

    /* renamed from: f, reason: collision with root package name */
    public static final J1 f3705f;

    /* renamed from: g, reason: collision with root package name */
    public static final J1 f3706g;

    /* renamed from: a, reason: collision with root package name */
    public final long f3707a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3708b;

    static {
        J1 j12 = new J1(0L, 0L);
        f3702c = j12;
        f3703d = new J1(Long.MAX_VALUE, Long.MAX_VALUE);
        f3704e = new J1(Long.MAX_VALUE, 0L);
        f3705f = new J1(0L, Long.MAX_VALUE);
        f3706g = j12;
    }

    public J1(long j7, long j8) {
        j3.o.d(j7 >= 0);
        j3.o.d(j8 >= 0);
        this.f3707a = j7;
        this.f3708b = j8;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(long r9, long r11, long r13) {
        /*
            r8 = this;
            long r2 = r8.f3707a
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto Lf
            long r4 = r8.f3708b
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto Lf
            return r9
        Lf:
            r4 = -9223372036854775808
            r0 = r9
            long r9 = E0.U.n1(r0, r2, r4)
            long r2 = r8.f3708b
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r2 = E0.U.c(r0, r2, r4)
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 > 0) goto L2d
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 > 0) goto L2d
            r4 = r6
            goto L2e
        L2d:
            r4 = r5
        L2e:
            int r7 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r7 > 0) goto L37
            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r2 > 0) goto L37
            r5 = r6
        L37:
            if (r4 == 0) goto L4c
            if (r5 == 0) goto L4c
            long r9 = r11 - r0
            long r9 = java.lang.Math.abs(r9)
            long r0 = r13 - r0
            long r0 = java.lang.Math.abs(r0)
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 > 0) goto L51
            goto L4e
        L4c:
            if (r4 == 0) goto L4f
        L4e:
            return r11
        L4f:
            if (r5 == 0) goto L52
        L51:
            return r13
        L52:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: I0.J1.a(long, long, long):long");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && J1.class == obj.getClass()) {
            J1 j12 = (J1) obj;
            if (this.f3707a == j12.f3707a && this.f3708b == j12.f3708b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f3707a) * 31) + ((int) this.f3708b);
    }
}
