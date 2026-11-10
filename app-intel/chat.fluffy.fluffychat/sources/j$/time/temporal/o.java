package j$.time.temporal;

/* loaded from: classes2.dex */
public final /* synthetic */ class o implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18396a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18397b;

    public /* synthetic */ o(int i7, int i8) {
        this.f18396a = i8;
        this.f18397b = i7;
    }

    @Override // j$.time.temporal.n
    public final m e(m mVar) {
        switch (this.f18396a) {
            case 0:
                int iG = mVar.g(a.DAY_OF_WEEK);
                int i7 = this.f18397b;
                if (iG == i7) {
                    return mVar;
                }
                return mVar.d(iG - i7 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int iG2 = mVar.g(a.DAY_OF_WEEK);
                int i8 = this.f18397b;
                if (iG2 == i8) {
                    return mVar;
                }
                return mVar.a(i8 - iG2 >= 0 ? 7 - r1 : -r1, b.DAYS);
        }
    }
}
