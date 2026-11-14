package j$.time.temporal;

import j$.time.format.w;
import j$.time.format.x;
import java.util.Map;

/* loaded from: classes2.dex */
public interface q {
    u H();

    long O(TemporalAccessor temporalAccessor);

    m U(m mVar, long j7);

    boolean isDateBased();

    boolean r(TemporalAccessor temporalAccessor);

    u z(TemporalAccessor temporalAccessor);

    default TemporalAccessor E(Map map, w wVar, x xVar) {
        return null;
    }
}
