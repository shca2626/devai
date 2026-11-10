package P0;

import c1.o;
import java.util.List;

/* loaded from: classes.dex */
public final class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final l f7345a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7346b;

    public e(l lVar, List list) {
        this.f7345a = lVar;
        this.f7346b = list;
    }

    @Override // P0.l
    public o.a a(i iVar, f fVar) {
        return new T0.b(this.f7345a.a(iVar, fVar), this.f7346b);
    }

    @Override // P0.l
    public o.a b() {
        return new T0.b(this.f7345a.b(), this.f7346b);
    }
}
