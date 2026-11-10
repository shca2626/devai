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
    public final transient String f18392a;

    /* renamed from: b, reason: collision with root package name */
    public final transient u f18393b;

    /* renamed from: c, reason: collision with root package name */
    public final transient long f18394c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j7) {
        this.f18392a = str;
        this.f18393b = u.f((-365243219162L) + j7, 365241780471L + j7);
        this.f18394c = j7;
    }

    @Override // j$.time.temporal.q
    public final u I() {
        return this.f18393b;
    }

    @Override // j$.time.temporal.q
    public final m V(m mVar, long j7) {
        if (!this.f18393b.e(j7)) {
            throw new j$.time.c("Invalid value: " + this.f18392a + " " + j7);
        }
        return mVar.c(Math.subtractExact(j7, this.f18394c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.h(a.EPOCH_DAY)) {
            return this.f18393b;
        }
        throw new j$.time.c("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.q
    public final boolean s(TemporalAccessor temporalAccessor) {
        return temporalAccessor.h(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final long P(TemporalAccessor temporalAccessor) {
        return temporalAccessor.i(a.EPOCH_DAY) + this.f18394c;
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor F(Map map, w wVar, x xVar) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.l lVarR = j$.time.chrono.l.r(wVar);
        x xVar2 = x.LENIENT;
        long j7 = this.f18394c;
        if (xVar == xVar2) {
            return lVarR.p(Math.subtractExact(jLongValue, j7));
        }
        this.f18393b.b(jLongValue, this);
        return lVarR.p(jLongValue - j7);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f18392a;
    }
}
