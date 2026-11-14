package F2;

import h5.j;

/* renamed from: F2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0346f implements A {

    /* renamed from: a, reason: collision with root package name */
    public j.d f2675a;

    public C0346f(j.d dVar) {
        this.f2675a = dVar;
    }

    @Override // F2.A
    public void a(boolean z7) {
        this.f2675a.success(Boolean.valueOf(z7));
    }

    @Override // F2.A
    public void b(E2.b bVar) {
        this.f2675a.error(bVar.toString(), bVar.d(), null);
    }
}
