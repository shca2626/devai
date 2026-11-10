package j$.time.temporal;

/* loaded from: classes2.dex */
public interface m extends TemporalAccessor {
    m c(long j7, q qVar);

    m d(long j7, s sVar);

    /* renamed from: k */
    m m(j$.time.h hVar);

    default m a(long j7, s sVar) {
        return j7 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j7, sVar);
    }
}
