package b1;

import B0.I;
import java.util.List;

/* loaded from: classes.dex */
public final class z extends AbstractC0831c {

    /* renamed from: i, reason: collision with root package name */
    public final int f13706i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f13707j;

    public z(I i7, int i8, int i9) {
        this(i7, i8, i9, 0, null);
    }

    @Override // b1.y
    public int d() {
        return 0;
    }

    @Override // b1.y
    public int n() {
        return this.f13706i;
    }

    @Override // b1.y
    public Object r() {
        return this.f13707j;
    }

    public z(I i7, int i8, int i9, int i10, Object obj) {
        super(i7, new int[]{i8}, i9);
        this.f13706i = i10;
        this.f13707j = obj;
    }

    @Override // b1.y
    public void p(long j7, long j8, long j9, List list, Z0.o[] oVarArr) {
    }
}
