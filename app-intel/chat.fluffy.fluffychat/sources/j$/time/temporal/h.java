package j$.time.temporal;

import j$.time.DayOfWeek;
import j$.time.LocalDate;
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
    public static final int[] f18383a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f18384b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f18384b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final u H() {
                return u.g(90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final boolean r(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.DAY_OF_YEAR) || !temporalAccessor.h(a.MONTH_OF_YEAR) || !temporalAccessor.h(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.f18387a;
                return j$.time.chrono.l.q(temporalAccessor).equals(j$.time.chrono.s.f18258c);
            }

            @Override // j$.time.temporal.q
            public final u z(TemporalAccessor temporalAccessor) {
                if (!r(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                long jI = temporalAccessor.i(h.QUARTER_OF_YEAR);
                if (jI == 1) {
                    long jI2 = temporalAccessor.i(a.YEAR);
                    j$.time.chrono.s.f18258c.getClass();
                    return j$.time.chrono.s.W(jI2) ? u.f(1L, 91L) : u.f(1L, 90L);
                }
                if (jI == 2) {
                    return u.f(1L, 91L);
                }
                if (jI == 3 || jI == 4) {
                    return u.f(1L, 92L);
                }
                return H();
            }

            @Override // j$.time.temporal.q
            public final long O(TemporalAccessor temporalAccessor) {
                if (!r(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                int iG = temporalAccessor.g(a.DAY_OF_YEAR);
                int iG2 = temporalAccessor.g(a.MONTH_OF_YEAR);
                long jI = temporalAccessor.i(a.YEAR);
                int i7 = (iG2 - 1) / 3;
                j$.time.chrono.s.f18258c.getClass();
                return iG - h.f18383a[i7 + (j$.time.chrono.s.W(jI) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m U(m mVar, long j7) {
                long jO = O(mVar);
                H().b(j7, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.c((j7 - jO) + mVar.i(aVar), aVar);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor E(Map map, w wVar, x xVar) {
                long jSubtractExact;
                LocalDate localDateD0;
                a aVar = a.YEAR;
                Long l7 = (Long) map.get(aVar);
                q qVar = h.QUARTER_OF_YEAR;
                Long l8 = (Long) map.get(qVar);
                if (l7 == null || l8 == null) {
                    return null;
                }
                int iA = aVar.f18379b.a(l7.longValue(), aVar);
                long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                h hVar2 = j.f18387a;
                if (!j$.time.chrono.l.q(wVar).equals(j$.time.chrono.s.f18258c)) {
                    throw new j$.time.b("Resolve requires IsoChronology");
                }
                if (xVar == x.LENIENT) {
                    localDateD0 = LocalDate.Z(iA, 1, 1).d0(Math.multiplyExact(Math.subtractExact(l8.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    LocalDate localDateZ = LocalDate.Z(iA, ((qVar.H().a(l8.longValue(), qVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        if (xVar == x.STRICT) {
                            z(localDateZ).b(jLongValue, this);
                        } else {
                            H().b(jLongValue, this);
                        }
                    }
                    jSubtractExact = jLongValue - 1;
                    localDateD0 = localDateZ;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(qVar);
                return localDateD0.plusDays(jSubtractExact);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final u H() {
                return u.f(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final boolean r(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.f18387a;
                return j$.time.chrono.l.q(temporalAccessor).equals(j$.time.chrono.s.f18258c);
            }

            @Override // j$.time.temporal.q
            public final long O(TemporalAccessor temporalAccessor) {
                if (!r(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.i(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.q
            public final u z(TemporalAccessor temporalAccessor) {
                if (!r(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return H();
            }

            @Override // j$.time.temporal.q
            public final m U(m mVar, long j7) {
                long jO = O(mVar);
                H().b(j7, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.c(((j7 - jO) * 3) + mVar.i(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final u H() {
                return u.g(52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final boolean r(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.f18387a;
                return j$.time.chrono.l.q(temporalAccessor).equals(j$.time.chrono.s.f18258c);
            }

            @Override // j$.time.temporal.q
            public final u z(TemporalAccessor temporalAccessor) {
                if (r(temporalAccessor)) {
                    return h.Z(LocalDate.E(temporalAccessor));
                }
                throw new t("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final long O(TemporalAccessor temporalAccessor) {
                if (!r(temporalAccessor)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.W(LocalDate.E(temporalAccessor));
            }

            @Override // j$.time.temporal.q
            public final m U(m mVar, long j7) {
                H().b(j7, this);
                return mVar.d(Math.subtractExact(j7, O(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor E(Map map, w wVar, x xVar) {
                LocalDate localDateC;
                long j7;
                long j8;
                q qVar = h.WEEK_BASED_YEAR;
                Long l7 = (Long) map.get(qVar);
                a aVar = a.DAY_OF_WEEK;
                Long l8 = (Long) map.get(aVar);
                if (l7 == null || l8 == null) {
                    return null;
                }
                int iA = qVar.H().a(l7.longValue(), qVar);
                long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                h hVar4 = j.f18387a;
                if (!j$.time.chrono.l.q(wVar).equals(j$.time.chrono.s.f18258c)) {
                    throw new j$.time.b("Resolve requires IsoChronology");
                }
                LocalDate localDateZ = LocalDate.Z(iA, 1, 4);
                if (xVar == x.LENIENT) {
                    long jLongValue2 = l8.longValue();
                    if (jLongValue2 > 7) {
                        long j9 = jLongValue2 - 1;
                        j7 = 1;
                        localDateZ = localDateZ.e0(j9 / 7);
                        j8 = j9 % 7;
                    } else {
                        j7 = 1;
                        if (jLongValue2 < 1) {
                            localDateZ = localDateZ.e0(Math.subtractExact(jLongValue2, 7L) / 7);
                            j8 = (jLongValue2 + 6) % 7;
                        }
                        localDateC = localDateZ.e0(Math.subtractExact(jLongValue, j7)).c(jLongValue2, aVar);
                    }
                    jLongValue2 = j8 + j7;
                    localDateC = localDateZ.e0(Math.subtractExact(jLongValue, j7)).c(jLongValue2, aVar);
                } else {
                    int iA2 = aVar.f18379b.a(l8.longValue(), aVar);
                    if (jLongValue < 1 || jLongValue > 52) {
                        if (xVar == x.STRICT) {
                            h.Z(localDateZ).b(jLongValue, this);
                        } else {
                            H().b(jLongValue, this);
                        }
                    }
                    localDateC = localDateZ.e0(jLongValue - 1).c(iA2, aVar);
                }
                map.remove(this);
                map.remove(qVar);
                map.remove(aVar);
                return localDateC;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final u H() {
                return a.YEAR.f18379b;
            }

            @Override // j$.time.temporal.q
            public final boolean r(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.h(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.f18387a;
                return j$.time.chrono.l.q(temporalAccessor).equals(j$.time.chrono.s.f18258c);
            }

            @Override // j$.time.temporal.q
            public final long O(TemporalAccessor temporalAccessor) {
                if (r(temporalAccessor)) {
                    return h.X(LocalDate.E(temporalAccessor));
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final u z(TemporalAccessor temporalAccessor) {
                if (!r(temporalAccessor)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                return H();
            }

            @Override // j$.time.temporal.q
            public final m U(m mVar, long j7) {
                if (!r(mVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.f18379b.a(j7, h.WEEK_BASED_YEAR);
                LocalDate localDateE = LocalDate.E(mVar);
                int iG = localDateE.g(a.DAY_OF_WEEK);
                int iW = h.W(localDateE);
                if (iW == 53 && h.Y(iA) == 52) {
                    iW = 52;
                }
                return mVar.l(LocalDate.Z(iA, 1, 4).plusDays(((iW - 1) * 7) + (iG - r6.g(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f18384b = new h[]{hVar, hVar2, hVar3, hVar4};
        f18383a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static u Z(LocalDate localDate) {
        return u.f(1L, Y(X(localDate)));
    }

    public static int Y(int i7) {
        LocalDate localDateZ = LocalDate.Z(i7, 1, 1);
        if (localDateZ.getDayOfWeek() != DayOfWeek.THURSDAY) {
            return (localDateZ.getDayOfWeek() == DayOfWeek.WEDNESDAY && localDateZ.W()) ? 53 : 52;
        }
        return 53;
    }

    public static int W(LocalDate localDate) {
        int iOrdinal = localDate.getDayOfWeek().ordinal();
        int iO = localDate.O() - 1;
        int i7 = (3 - iOrdinal) + iO;
        int i8 = i7 - ((i7 / 7) * 7);
        int i9 = i8 - 3;
        if (i9 < -3) {
            i9 = i8 + 4;
        }
        if (iO >= i9) {
            int i10 = ((iO - i9) / 7) + 1;
            if (i10 != 53 || i9 == -3 || (i9 == -2 && localDate.W())) {
                return i10;
            }
            return 1;
        }
        if (localDate.O() != 180) {
            localDate = LocalDate.b0(localDate.f18194a, 180);
        }
        return (int) Z(localDate.f0(-1L)).f18407d;
    }

    public static int X(LocalDate localDate) {
        int i7 = localDate.f18194a;
        int iO = localDate.O();
        if (iO <= 3) {
            return iO - localDate.getDayOfWeek().ordinal() < -2 ? i7 - 1 : i7;
        }
        if (iO >= 363) {
            return ((iO - 363) - (localDate.W() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? i7 + 1 : i7;
        }
        return i7;
    }
}
