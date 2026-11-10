package b4;

import D3.p;

/* renamed from: b4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0843a extends p {

    /* renamed from: c, reason: collision with root package name */
    public final float f13723c;

    public C0843a(float f7, float f8, float f9) {
        super(f7, f8);
        this.f13723c = f9;
    }

    public boolean f(float f7, float f8, float f9) {
        if (Math.abs(f8 - d()) > f7 || Math.abs(f9 - c()) > f7) {
            return false;
        }
        float fAbs = Math.abs(f7 - this.f13723c);
        return fAbs <= 1.0f || fAbs <= this.f13723c;
    }

    public C0843a g(float f7, float f8, float f9) {
        return new C0843a((c() + f8) / 2.0f, (d() + f7) / 2.0f, (this.f13723c + f9) / 2.0f);
    }
}
