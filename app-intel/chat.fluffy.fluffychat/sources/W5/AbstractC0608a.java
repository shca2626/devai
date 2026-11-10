package W5;

import com.fasterxml.jackson.core.JsonFactory;

/* renamed from: W5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0608a extends C0 implements InterfaceC0652w0, C5.e, M {

    /* renamed from: n, reason: collision with root package name */
    public final C5.i f9135n;

    public AbstractC0608a(C5.i iVar, boolean z7, boolean z8) {
        super(z8);
        if (z7) {
            o0((InterfaceC0652w0) iVar.a(InterfaceC0652w0.f9180d));
        }
        this.f9135n = iVar.n(this);
    }

    @Override // W5.C0
    public final void A0(Object obj) {
        if (!(obj instanceof B)) {
            S0(obj);
        } else {
            B b7 = (B) obj;
            R0(b7.f9083a, b7.a());
        }
    }

    public void Q0(Object obj) {
        I(obj);
    }

    public final void T0(O o7, Object obj, L5.p pVar) {
        o7.d(pVar, obj, this);
    }

    @Override // W5.C0
    public String W() {
        return Q.a(this) + " was cancelled";
    }

    @Override // W5.C0, W5.InterfaceC0652w0
    public boolean e() {
        return super.e();
    }

    @Override // C5.e
    public final C5.i getContext() {
        return this.f9135n;
    }

    @Override // W5.M
    public C5.i l() {
        return this.f9135n;
    }

    @Override // W5.C0
    public final void n0(Throwable th) {
        L.a(this.f9135n, th);
    }

    @Override // C5.e
    public final void resumeWith(Object obj) {
        Object objU0 = u0(D.b(obj));
        if (objU0 == D0.f9097b) {
            return;
        }
        Q0(objU0);
    }

    @Override // W5.C0
    public String v0() {
        String strG = H.g(this.f9135n);
        if (strG == null) {
            return super.v0();
        }
        return JsonFactory.DEFAULT_QUOTE_CHAR + strG + "\":" + super.v0();
    }

    public void S0(Object obj) {
    }

    public void R0(Throwable th, boolean z7) {
    }
}
