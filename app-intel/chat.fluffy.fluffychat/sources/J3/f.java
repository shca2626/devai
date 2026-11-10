package J3;

/* loaded from: classes.dex */
public final class f extends j {
    @Override // J3.j
    public b c(b bVar, int i7, int i8, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22) {
        return d(bVar, i7, i8, l.b(f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22));
    }

    @Override // J3.j
    public b d(b bVar, int i7, int i8, l lVar) throws D3.j {
        if (i7 <= 0 || i8 <= 0) {
            throw D3.j.a();
        }
        b bVar2 = new b(i7, i8);
        int i9 = i7 * 2;
        float[] fArr = new float[i9];
        for (int i10 = 0; i10 < i8; i10++) {
            float f7 = i10 + 0.5f;
            for (int i11 = 0; i11 < i9; i11 += 2) {
                fArr[i11] = (i11 / 2) + 0.5f;
                fArr[i11 + 1] = f7;
            }
            lVar.f(fArr);
            j.a(bVar, fArr);
            for (int i12 = 0; i12 < i9; i12 += 2) {
                try {
                    if (bVar.g((int) fArr[i12], (int) fArr[i12 + 1])) {
                        bVar2.s(i12 / 2, i10);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw D3.j.a();
                }
            }
        }
        return bVar2;
    }
}
