package J3;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final float f4787a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4788b;

    /* renamed from: c, reason: collision with root package name */
    public final float f4789c;

    /* renamed from: d, reason: collision with root package name */
    public final float f4790d;

    /* renamed from: e, reason: collision with root package name */
    public final float f4791e;

    /* renamed from: f, reason: collision with root package name */
    public final float f4792f;

    /* renamed from: g, reason: collision with root package name */
    public final float f4793g;

    /* renamed from: h, reason: collision with root package name */
    public final float f4794h;

    /* renamed from: i, reason: collision with root package name */
    public final float f4795i;

    public l(float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f4787a = f7;
        this.f4788b = f10;
        this.f4789c = f13;
        this.f4790d = f8;
        this.f4791e = f11;
        this.f4792f = f14;
        this.f4793g = f9;
        this.f4794h = f12;
        this.f4795i = f15;
    }

    public static l b(float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22) {
        return d(f15, f16, f17, f18, f19, f20, f21, f22).e(c(f7, f8, f9, f10, f11, f12, f13, f14));
    }

    public static l c(float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        return d(f7, f8, f9, f10, f11, f12, f13, f14).a();
    }

    public static l d(float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        float f15 = ((f7 - f9) + f11) - f13;
        float f16 = ((f8 - f10) + f12) - f14;
        if (f15 == 0.0f && f16 == 0.0f) {
            return new l(f9 - f7, f11 - f9, f7, f10 - f8, f12 - f10, f8, 0.0f, 0.0f, 1.0f);
        }
        float f17 = f9 - f11;
        float f18 = f13 - f11;
        float f19 = f10 - f12;
        float f20 = f14 - f12;
        float f21 = (f17 * f20) - (f18 * f19);
        float f22 = ((f20 * f15) - (f18 * f16)) / f21;
        float f23 = ((f17 * f16) - (f15 * f19)) / f21;
        return new l((f9 - f7) + (f22 * f9), (f13 - f7) + (f23 * f13), f7, (f10 - f8) + (f22 * f10), (f14 - f8) + (f23 * f14), f8, f22, f23, 1.0f);
    }

    public l a() {
        float f7 = this.f4791e;
        float f8 = this.f4795i;
        float f9 = this.f4792f;
        float f10 = this.f4794h;
        float f11 = (f7 * f8) - (f9 * f10);
        float f12 = this.f4793g;
        float f13 = this.f4790d;
        float f14 = (f9 * f12) - (f13 * f8);
        float f15 = (f13 * f10) - (f7 * f12);
        float f16 = this.f4789c;
        float f17 = this.f4788b;
        float f18 = (f16 * f10) - (f17 * f8);
        float f19 = this.f4787a;
        return new l(f11, f14, f15, f18, (f8 * f19) - (f16 * f12), (f12 * f17) - (f10 * f19), (f17 * f9) - (f16 * f7), (f16 * f13) - (f9 * f19), (f19 * f7) - (f17 * f13));
    }

    public l e(l lVar) {
        float f7 = this.f4787a;
        float f8 = lVar.f4787a;
        float f9 = this.f4790d;
        float f10 = lVar.f4788b;
        float f11 = this.f4793g;
        float f12 = lVar.f4789c;
        float f13 = (f7 * f8) + (f9 * f10) + (f11 * f12);
        float f14 = lVar.f4790d;
        float f15 = lVar.f4791e;
        float f16 = lVar.f4792f;
        float f17 = (f7 * f14) + (f9 * f15) + (f11 * f16);
        float f18 = lVar.f4793g;
        float f19 = lVar.f4794h;
        float f20 = lVar.f4795i;
        float f21 = (f7 * f18) + (f9 * f19) + (f11 * f20);
        float f22 = this.f4788b;
        float f23 = this.f4791e;
        float f24 = (f22 * f8) + (f23 * f10);
        float f25 = this.f4794h;
        float f26 = f24 + (f25 * f12);
        float f27 = (f22 * f14) + (f23 * f15) + (f25 * f16);
        float f28 = (f22 * f18) + (f23 * f19) + (f25 * f20);
        float f29 = this.f4789c;
        float f30 = f8 * f29;
        float f31 = this.f4792f;
        float f32 = f30 + (f10 * f31);
        float f33 = this.f4795i;
        return new l(f13, f17, f21, f26, f27, f28, f32 + (f12 * f33), (f29 * f14) + (f15 * f31) + (f16 * f33), (f29 * f18) + (f31 * f19) + (f33 * f20));
    }

    public void f(float[] fArr) {
        float f7 = this.f4787a;
        float f8 = this.f4788b;
        float f9 = this.f4789c;
        float f10 = this.f4790d;
        float f11 = this.f4791e;
        float f12 = this.f4792f;
        float f13 = this.f4793g;
        float f14 = this.f4794h;
        float f15 = this.f4795i;
        int length = fArr.length - 1;
        for (int i7 = 0; i7 < length; i7 += 2) {
            float f16 = fArr[i7];
            int i8 = i7 + 1;
            float f17 = fArr[i8];
            float f18 = (f9 * f16) + (f12 * f17) + f15;
            fArr[i7] = (((f7 * f16) + (f10 * f17)) + f13) / f18;
            fArr[i8] = (((f16 * f8) + (f17 * f11)) + f14) / f18;
        }
    }
}
