package E5;

/* loaded from: classes.dex */
public abstract class j extends a {
    public j(C5.e eVar) {
        super(eVar);
        if (eVar != null && eVar.getContext() != C5.j.f1392l) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // C5.e
    public C5.i getContext() {
        return C5.j.f1392l;
    }
}
