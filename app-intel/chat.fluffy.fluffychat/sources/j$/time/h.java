package j$.time;

import j$.time.temporal.TemporalAccessor;

/* loaded from: classes2.dex */
public final /* synthetic */ class h implements j$.time.temporal.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18351a;

    public /* synthetic */ h(int i7) {
        this.f18351a = i7;
    }

    @Override // j$.time.temporal.n
    public j$.time.temporal.m e(j$.time.temporal.m mVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return mVar.c(mVar.k(aVar).f18407d, aVar);
    }

    public Object j(TemporalAccessor temporalAccessor) {
        switch (this.f18351a) {
            case 0:
                return LocalDateTime.z(temporalAccessor);
            case 1:
                ZoneId zoneId = (ZoneId) temporalAccessor.b(j$.time.temporal.r.f18397a);
                if (zoneId == null || (zoneId instanceof x)) {
                    return null;
                }
                return zoneId;
            case 2:
            default:
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_DAY;
                if (temporalAccessor.h(aVar)) {
                    return LocalTime.U(temporalAccessor.i(aVar));
                }
                return null;
            case 3:
                return (ZoneId) temporalAccessor.b(j$.time.temporal.r.f18397a);
            case 4:
                return (j$.time.chrono.l) temporalAccessor.b(j$.time.temporal.r.f18398b);
            case 5:
                return (j$.time.temporal.s) temporalAccessor.b(j$.time.temporal.r.f18399c);
            case 6:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.OFFSET_SECONDS;
                if (temporalAccessor.h(aVar2)) {
                    return x.X(temporalAccessor.g(aVar2));
                }
                return null;
            case 7:
                ZoneId zoneId2 = (ZoneId) temporalAccessor.b(j$.time.temporal.r.f18397a);
                return zoneId2 != null ? zoneId2 : (ZoneId) temporalAccessor.b(j$.time.temporal.r.f18400d);
            case 8:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.EPOCH_DAY;
                if (temporalAccessor.h(aVar3)) {
                    return LocalDate.a0(temporalAccessor.i(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f18351a) {
            case 3:
                return "ZoneId";
            case 4:
                return "Chronology";
            case 5:
                return "Precision";
            case 6:
                return "ZoneOffset";
            case 7:
                return "Zone";
            case 8:
                return "LocalDate";
            case 9:
                return "LocalTime";
            default:
                return super.toString();
        }
    }
}
