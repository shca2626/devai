package E1;

import D1.k;
import j3.o;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f implements k {

    /* renamed from: l, reason: collision with root package name */
    public final List f2326l;

    public f(List list) {
        this.f2326l = list;
    }

    @Override // D1.k
    public int a(long j7) {
        return j7 < 0 ? 0 : -1;
    }

    @Override // D1.k
    public long d(int i7) {
        o.d(i7 == 0);
        return 0L;
    }

    @Override // D1.k
    public List e(long j7) {
        return j7 >= 0 ? this.f2326l : Collections.EMPTY_LIST;
    }

    @Override // D1.k
    public int f() {
        return 1;
    }
}
