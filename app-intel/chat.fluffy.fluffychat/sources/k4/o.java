package k4;

/* loaded from: classes.dex */
public class o extends i {

    /* renamed from: c, reason: collision with root package name */
    public boolean f19091c;

    public o(D3.l lVar) {
        super(lVar);
        this.f19091c = true;
    }

    @Override // k4.i
    public D3.c e(D3.h hVar) {
        if (this.f19091c) {
            this.f19091c = false;
            return new D3.c(new J3.k(hVar.e()));
        }
        this.f19091c = true;
        return new D3.c(new J3.k(hVar));
    }
}
