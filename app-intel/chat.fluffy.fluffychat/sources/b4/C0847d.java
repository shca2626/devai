package b4;

import D3.p;

/* renamed from: b4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0847d extends p {

    /* renamed from: c, reason: collision with root package name */
    public final float f13735c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13736d;

    public C0847d(float f7, float f8, float f9) {
        this(f7, f8, f9, 1);
    }

    public boolean f(float f7, float f8, float f9) {
        if (Math.abs(f8 - d()) > f7 || Math.abs(f9 - c()) > f7) {
            return false;
        }
        float fAbs = Math.abs(f7 - this.f13735c);
        return fAbs <= 1.0f || fAbs <= this.f13735c;
    }

    public C0847d g(float f7, float f8, float f9) {
        int i7 = this.f13736d;
        int i8 = i7 + 1;
        float fC = (i7 * c()) + f8;
        float f10 = i8;
        return new C0847d(fC / f10, ((this.f13736d * d()) + f7) / f10, ((this.f13736d * this.f13735c) + f9) / f10, i8);
    }

    public int h() {
        return this.f13736d;
    }

    public float i() {
        return this.f13735c;
    }

    public C0847d(float f7, float f8, float f9, int i7) {
        super(f7, f8);
        this.f13735c = f9;
        this.f13736d = i7;
    }
}
