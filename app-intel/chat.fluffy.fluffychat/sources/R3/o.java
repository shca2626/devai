package R3;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8055c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    public final m f8056a = new m();

    /* renamed from: b, reason: collision with root package name */
    public final n f8057b = new n();

    public D3.n a(int i7, J3.a aVar, int i8) {
        int[] iArrN = p.n(aVar, i8, false, f8055c);
        try {
            return this.f8057b.b(i7, aVar, iArrN);
        } catch (D3.m unused) {
            return this.f8056a.b(i7, aVar, iArrN);
        }
    }
}
