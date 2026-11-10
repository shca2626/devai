package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC1201b;
import j$.time.temporal.TemporalAccessor;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final TemporalAccessor f18324a;

    /* renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f18325b;

    /* renamed from: c, reason: collision with root package name */
    public int f18326c;

    public s(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.l lVar = dateTimeFormatter.f18276e;
        if (lVar != null) {
            j$.time.chrono.l lVar2 = (j$.time.chrono.l) temporalAccessor.b(j$.time.temporal.r.f18399b);
            ZoneId zoneId = (ZoneId) temporalAccessor.b(j$.time.temporal.r.f18398a);
            InterfaceC1201b interfaceC1201bG = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            if (lVar != null) {
                j$.time.chrono.l lVar3 = lVar != null ? lVar : lVar2;
                if (lVar != null) {
                    if (temporalAccessor.h(j$.time.temporal.a.EPOCH_DAY)) {
                        interfaceC1201bG = lVar3.G(temporalAccessor);
                    } else if (lVar != j$.time.chrono.s.f18250c || lVar2 != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.isDateBased() && temporalAccessor.h(aVar)) {
                                throw new j$.time.c("Unable to apply override chronology '" + lVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new r(interfaceC1201bG, temporalAccessor, lVar3, zoneId);
            }
        }
        this.f18324a = temporalAccessor;
        this.f18325b = dateTimeFormatter;
    }

    public final Long a(j$.time.temporal.q qVar) {
        int i7 = this.f18326c;
        TemporalAccessor temporalAccessor = this.f18324a;
        if (i7 <= 0 || temporalAccessor.h(qVar)) {
            return Long.valueOf(temporalAccessor.i(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.f18324a.toString();
    }
}
