package j$.time.temporal;

/* loaded from: classes2.dex */
public enum b implements s {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");


    /* renamed from: a, reason: collision with root package name */
    public final String f18381a;

    static {
        j$.time.e.E(1L);
        j$.time.e.E(1000L);
        j$.time.e.E(1000000L);
        j$.time.e.z(1L, 0);
        j$.time.e.z(60L, 0);
        j$.time.e.z(3600L, 0);
        j$.time.e.z(43200L, 0);
        j$.time.e.z(86400L, 0);
        j$.time.e.z(604800L, 0);
        j$.time.e.z(2629746L, 0);
        j$.time.e.z(31556952L, 0);
        j$.time.e.z(315569520L, 0);
        j$.time.e.z(3155695200L, 0);
        j$.time.e.z(31556952000L, 0);
        j$.time.e.z(31556952000000000L, 0);
        j$.time.e.z(Math.addExact(Long.MAX_VALUE, Math.floorDiv(999999999L, 1000000000L)), (int) Math.floorMod(999999999L, 1000000000L));
    }

    b(String str) {
        this.f18381a = str;
    }

    @Override // j$.time.temporal.s
    public final m r(m mVar, long j7) {
        return mVar.d(j7, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f18381a;
    }
}
