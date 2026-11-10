package S3;

import D3.p;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f8177a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f8178b;

    /* renamed from: c, reason: collision with root package name */
    public final p[] f8179c;

    public c(int i7, int[] iArr, int i8, int i9, int i10) {
        this.f8177a = i7;
        this.f8178b = iArr;
        float f7 = i8;
        float f8 = i10;
        this.f8179c = new p[]{new p(f7, f8), new p(i9, f8)};
    }

    public p[] a() {
        return this.f8179c;
    }

    public int[] b() {
        return this.f8178b;
    }

    public int c() {
        return this.f8177a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f8177a == ((c) obj).f8177a;
    }

    public int hashCode() {
        return this.f8177a;
    }
}
