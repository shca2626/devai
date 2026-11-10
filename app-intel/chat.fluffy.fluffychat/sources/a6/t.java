package a6;

/* loaded from: classes.dex */
public final class t implements C5.e, E5.e {

    /* renamed from: l, reason: collision with root package name */
    public final C5.e f10899l;

    /* renamed from: m, reason: collision with root package name */
    public final C5.i f10900m;

    public t(C5.e eVar, C5.i iVar) {
        this.f10899l = eVar;
        this.f10900m = iVar;
    }

    @Override // E5.e
    public E5.e f() {
        C5.e eVar = this.f10899l;
        if (eVar instanceof E5.e) {
            return (E5.e) eVar;
        }
        return null;
    }

    @Override // C5.e
    public C5.i getContext() {
        return this.f10900m;
    }

    @Override // C5.e
    public void resumeWith(Object obj) {
        this.f10899l.resumeWith(obj);
    }
}
