package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class r implements m {
    public static final r AH;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ r[] f18249a;

    @Override // j$.time.chrono.m
    public final int getValue() {
        return 1;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f18249a.clone();
    }

    static {
        r rVar = new r("AH", 0);
        AH = rVar;
        f18249a = new r[]{rVar};
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return j$.time.temporal.u.f(1L, 1L);
        }
        return super.l(qVar);
    }
}
