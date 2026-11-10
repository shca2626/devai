package Z0;

import B0.s;

/* loaded from: classes.dex */
public abstract class n extends f {

    /* renamed from: j, reason: collision with root package name */
    public final long f10173j;

    public n(G0.f fVar, G0.j jVar, s sVar, int i7, Object obj, long j7, long j8, long j9) {
        super(fVar, jVar, 1, sVar, i7, obj, j7, j8);
        j3.o.q(sVar);
        this.f10173j = j9;
    }

    public long g() {
        long j7 = this.f10173j;
        if (j7 != -1) {
            return j7 + 1;
        }
        return -1L;
    }

    public abstract boolean h();
}
