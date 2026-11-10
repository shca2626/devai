package J1;

import D1.k;
import E0.U;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: l, reason: collision with root package name */
    public final c f4719l;

    /* renamed from: m, reason: collision with root package name */
    public final long[] f4720m;

    /* renamed from: n, reason: collision with root package name */
    public final Map f4721n;

    /* renamed from: o, reason: collision with root package name */
    public final Map f4722o;

    /* renamed from: p, reason: collision with root package name */
    public final Map f4723p;

    public h(c cVar, Map map, Map map2, Map map3) {
        this.f4719l = cVar;
        this.f4722o = map2;
        this.f4723p = map3;
        this.f4721n = map != null ? Collections.unmodifiableMap(map) : Collections.EMPTY_MAP;
        this.f4720m = cVar.j();
    }

    @Override // D1.k
    public int a(long j7) {
        int iD = U.d(this.f4720m, j7, false, false);
        if (iD < this.f4720m.length) {
            return iD;
        }
        return -1;
    }

    @Override // D1.k
    public long d(int i7) {
        return this.f4720m[i7];
    }

    @Override // D1.k
    public List e(long j7) {
        return this.f4719l.h(j7, this.f4721n, this.f4722o, this.f4723p);
    }

    @Override // D1.k
    public int f() {
        return this.f4720m.length;
    }
}
