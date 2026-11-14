package j$.time.temporal;

/* loaded from: classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* renamed from: a, reason: collision with root package name */
    public final String f18386a;

    static {
        j$.time.e.z(31556952L, 0);
        j$.time.e.z(7889238L, 0);
    }

    i(String str) {
        this.f18386a = str;
    }

    @Override // j$.time.temporal.s
    public final m r(m mVar, long j7) {
        int i7 = c.f18382a[ordinal()];
        if (i7 == 1) {
            return mVar.c(Math.addExact(mVar.g(r0), j7), j.f18389c);
        }
        if (i7 == 2) {
            return mVar.d(j7 / 4, b.YEARS).d((j7 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f18386a;
    }
}
