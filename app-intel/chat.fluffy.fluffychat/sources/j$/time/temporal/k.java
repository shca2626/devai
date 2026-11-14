package j$.time.temporal;

import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* loaded from: classes2.dex */
public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a, reason: collision with root package name */
    public final transient String f18391a;

    /* renamed from: b, reason: collision with root package name */
    public final transient u f18392b;

    /* renamed from: c, reason: collision with root package name */
    public final transient long f18393c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j7) {
        this.f18391a = str;
        this.f18392b = u.f((-365243219162L) + j7, 365241780471L + j7);
        this.f18393c = j7;
    }

    @Override // j$.time.temporal.q
    public final u H() {
        return this.f18392b;
    }

    @Override // j$.time.temporal.q
    public final m U(m mVar, long j7) {
        if (!this.f18392b.e(j7)) {
            throw new j$.time.b("Invalid value: " + this.f18391a + " " + j7);
        }
        return mVar.c(Math.subtractExact(j7, this.f18393c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final boolean r(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u z(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.h(a.EPOCH_DAY)) {
            return this.f18392b;
        }
        throw new j$.time.b("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.q
    public final long O(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) + this.f18393c;
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor E(Map map, w wVar, x xVar) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l lVarQ = j$.time.chrono.l.q(wVar);
        x xVar2 = x.LENIENT;
        long j7 = this.f18393c;
        if (xVar == xVar2) {
            return lVarQ.o(Math.subtractExact(jLongValue, j7));
        }
        this.f18392b.b(jLongValue, this);
        return lVarQ.o(jLongValue - j7);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f18391a;
    }
}
