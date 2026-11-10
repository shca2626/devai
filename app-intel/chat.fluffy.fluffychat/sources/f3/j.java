package f3;

/* loaded from: classes.dex */
public class j extends d {

    /* renamed from: a, reason: collision with root package name */
    public float f15771a = -1.0f;

    @Override // f3.d
    public void b(m mVar, float f7, float f8, float f9) {
        mVar.o(0.0f, f9 * f8, 180.0f, 180.0f - f7);
        float f10 = f9 * 2.0f * f8;
        mVar.a(0.0f, 0.0f, f10, f10, 180.0f, f7);
    }
}
