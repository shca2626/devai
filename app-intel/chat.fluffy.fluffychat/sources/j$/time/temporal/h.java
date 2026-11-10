package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class h implements q {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f18384a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f18385b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f18385b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final u I() {
                return u.g(90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.DAY_OF_YEAR) || !temporalAccessor.h(a.MONTH_OF_YEAR) || !temporalAccessor.h(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.f18388a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f18250c);
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                long jI = temporalAccessor.i(h.QUARTER_OF_YEAR);
                if (jI == 1) {
                    long jI2 = temporalAccessor.i(a.YEAR);
                    j$.time.chrono.s.f18250c.getClass();
                    return j$.time.chrono.s.X(jI2) ? u.f(1L, 91L) : u.f(1L, 90L);
                }
                if (jI == 2) {
                    return u.f(1L, 91L);
                }
                if (jI == 3 || jI == 4) {
                    return u.f(1L, 92L);
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                int iG = temporalAccessor.g(a.DAY_OF_YEAR);
                int iG2 = temporalAccessor.g(a.MONTH_OF_YEAR);
                long jI = temporalAccessor.i(a.YEAR);
                int i7 = (iG2 - 1) / 3;
                j$.time.chrono.s.f18250c.getClass();
                return iG - h.f18384a[i7 + (j$.time.chrono.s.X(jI) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j7) {
                long jP = P(mVar);
                I().b(j7, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.c((j7 - jP) + mVar.i(aVar), aVar);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                long jSubtractExact;
                j$.time.h hVarG0;
                a aVar = a.YEAR;
                Long l7 = (Long) map.get(aVar);
                q qVar = h.QUARTER_OF_YEAR;
                Long l8 = (Long) map.get(qVar);
                if (l7 == null || l8 == null) {
                    return null;
                }
                int iA = aVar.f18380b.a(l7.longValue(), aVar);
                long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                h hVar2 = j.f18388a;
                if (!j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f18250c)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                if (xVar == x.LENIENT) {
                    hVarG0 = j$.time.h.b0(iA, 1, 1).g0(Math.multiplyExact(Math.subtractExact(l8.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    j$.time.h hVarB0 = j$.time.h.b0(iA, ((qVar.I().a(l8.longValue(), qVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        if (xVar == x.STRICT) {
                            A(hVarB0).b(jLongValue, this);
                        } else {
                            I().b(jLongValue, this);
                        }
                    }
                    jSubtractExact = jLongValue - 1;
                    hVarG0 = hVarB0;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(qVar);
                return hVarG0.f0(jSubtractExact);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final u I() {
                return u.f(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.f18388a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f18250c);
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.i(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j7) {
                long jP = P(mVar);
                I().b(j7, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.c(((j7 - jP) * 3) + mVar.i(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final u I() {
                return u.g(52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.f18388a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f18250c);
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (s(temporalAccessor)) {
                    return h.a0(j$.time.h.F(temporalAccessor));
                }
                throw new t("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.X(j$.time.h.F(temporalAccessor));
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j7) {
                I().b(j7, this);
                return mVar.d(Math.subtractExact(j7, P(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor F(Map map, w wVar, x xVar) {
                j$.time.h hVarC;
                long j7;
                long j8;
                q qVar = h.WEEK_BASED_YEAR;
                Long l7 = (Long) map.get(qVar);
                a aVar = a.DAY_OF_WEEK;
                Long l8 = (Long) map.get(aVar);
                if (l7 == null || l8 == null) {
                    return null;
                }
                int iA = qVar.I().a(l7.longValue(), qVar);
                long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                h hVar4 = j.f18388a;
                if (!j$.time.chrono.l.r(wVar).equals(j$.time.chrono.s.f18250c)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                j$.time.h hVarB0 = j$.time.h.b0(iA, 1, 4);
                if (xVar == x.LENIENT) {
                    long jLongValue2 = l8.longValue();
                    if (jLongValue2 > 7) {
                        long j9 = jLongValue2 - 1;
                        j7 = 1;
                        hVarB0 = hVarB0.h0(j9 / 7);
                        j8 = j9 % 7;
                    } else {
                        j7 = 1;
                        if (jLongValue2 < 1) {
                            hVarB0 = hVarB0.h0(Math.subtractExact(jLongValue2, 7L) / 7);
                            j8 = (jLongValue2 + 6) % 7;
                        }
                        hVarC = hVarB0.h0(Math.subtractExact(jLongValue, j7)).c(jLongValue2, aVar);
                    }
                    jLongValue2 = j8 + j7;
                    hVarC = hVarB0.h0(Math.subtractExact(jLongValue, j7)).c(jLongValue2, aVar);
                } else {
                    int iA2 = aVar.f18380b.a(l8.longValue(), aVar);
                    if (jLongValue < 1 || jLongValue > 52) {
                        if (xVar == x.STRICT) {
                            h.a0(hVarB0).b(jLongValue, this);
                        } else {
                            I().b(jLongValue, this);
                        }
                    }
                    hVarC = hVarB0.h0(jLongValue - 1).c(iA2, aVar);
                }
                map.remove(this);
                map.remove(qVar);
                map.remove(aVar);
                return hVarC;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final u I() {
                return a.YEAR.f18380b;
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.f18388a;
                return j$.time.chrono.l.r(temporalAccessor).equals(j$.time.chrono.s.f18250c);
            }

            @Override // j$.time.temporal.q
            public final long P(TemporalAccessor temporalAccessor) {
                if (s(temporalAccessor)) {
                    return h.Y(j$.time.h.F(temporalAccessor));
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final u A(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                return I();
            }

            @Override // j$.time.temporal.q
            public final m V(m mVar, long j7) {
                if (!s(mVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.f18380b.a(j7, h.WEEK_BASED_YEAR);
                j$.time.h hVarF = j$.time.h.F(mVar);
                int iG = hVarF.g(a.DAY_OF_WEEK);
                int iX = h.X(hVarF);
                if (iX == 53 && h.Z(iA) == 52) {
                    iX = 52;
                }
                return mVar.m(j$.time.h.b0(iA, 1, 4).f0(((iX - 1) * 7) + (iG - r6.g(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f18385b = new h[]{hVar, hVar2, hVar3, hVar4};
        f18384a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static u a0(j$.time.h hVar) {
        return u.f(1L, Z(Y(hVar)));
    }

    public static int Z(int i7) {
        j$.time.h hVarB0 = j$.time.h.b0(i7, 1, 1);
        if (hVarB0.P() != DayOfWeek.THURSDAY) {
            return (hVarB0.P() == DayOfWeek.WEDNESDAY && hVarB0.Y()) ? 53 : 52;
        }
        return 53;
    }

    public static int X(j$.time.h hVar) {
        int iOrdinal = hVar.P().ordinal();
        int iV = hVar.V() - 1;
        int i7 = (3 - iOrdinal) + iV;
        int i8 = i7 - ((i7 / 7) * 7);
        int i9 = i8 - 3;
        if (i9 < -3) {
            i9 = i8 + 4;
        }
        if (iV >= i9) {
            int i10 = ((iV - i9) / 7) + 1;
            if (i10 != 53 || i9 == -3 || (i9 == -2 && hVar.Y())) {
                return i10;
            }
            return 1;
        }
        if (hVar.V() != 180) {
            hVar = j$.time.h.d0(hVar.f18345a, 180);
        }
        return (int) a0(hVar.i0(-1L)).f18408d;
    }

    public static int Y(j$.time.h hVar) {
        int i7 = hVar.f18345a;
        int iV = hVar.V();
        if (iV <= 3) {
            return iV - hVar.P().ordinal() < -2 ? i7 - 1 : i7;
        }
        if (iV >= 363) {
            return ((iV - 363) - (hVar.Y() ? 1 : 0)) - hVar.P().ordinal() >= 0 ? i7 + 1 : i7;
        }
        return i7;
    }
}
