package g1;

/* loaded from: classes.dex */
public final class T extends AbstractC1070A {

    /* renamed from: b, reason: collision with root package name */
    public final long f15982b;

    public T(r rVar, long j7) {
        super(rVar);
        j3.o.d(rVar.getPosition() >= j7);
        this.f15982b = j7;
    }

    @Override // g1.AbstractC1070A, g1.r
    public long getLength() {
        return super.getLength() - this.f15982b;
    }

    @Override // g1.AbstractC1070A, g1.r
    public long getPosition() {
        return super.getPosition() - this.f15982b;
    }

    @Override // g1.AbstractC1070A, g1.r
    public long i() {
        return super.i() - this.f15982b;
    }
}
