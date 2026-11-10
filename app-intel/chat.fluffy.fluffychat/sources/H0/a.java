package H0;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: l, reason: collision with root package name */
    public int f3315l;

    public final void h(int i7) {
        this.f3315l = i7 | this.f3315l;
    }

    public void i() {
        this.f3315l = 0;
    }

    public final boolean j(int i7) {
        return (this.f3315l & i7) == i7;
    }

    public final boolean k() {
        return j(268435456);
    }

    public final boolean l() {
        return j(4);
    }

    public final boolean m() {
        return j(134217728);
    }

    public final boolean n() {
        return j(1);
    }

    public final boolean o() {
        return j(536870912);
    }

    public final boolean p() {
        return j(67108864);
    }

    public final void q(int i7) {
        this.f3315l = i7;
    }
}
