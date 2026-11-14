package g1;

import g1.V;

/* loaded from: classes.dex */
public final class W {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f15991a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    public boolean f15992b;

    /* renamed from: c, reason: collision with root package name */
    public int f15993c;

    /* renamed from: d, reason: collision with root package name */
    public long f15994d;

    /* renamed from: e, reason: collision with root package name */
    public int f15995e;

    /* renamed from: f, reason: collision with root package name */
    public int f15996f;

    /* renamed from: g, reason: collision with root package name */
    public int f15997g;

    public void a(V v7, V.a aVar) {
        if (this.f15993c > 0) {
            v7.d(this.f15994d, this.f15995e, this.f15996f, this.f15997g, aVar);
            this.f15993c = 0;
        }
    }

    public void b() {
        this.f15992b = false;
        this.f15993c = 0;
    }

    public void c(V v7, long j7, int i7, int i8, int i9, V.a aVar) {
        j3.o.w(this.f15997g <= i8 + i9, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f15992b) {
            int i10 = this.f15993c;
            int i11 = i10 + 1;
            this.f15993c = i11;
            if (i10 == 0) {
                this.f15994d = j7;
                this.f15995e = i7;
                this.f15996f = 0;
            }
            this.f15996f += i8;
            this.f15997g = i9;
            if (i11 >= 16) {
                a(v7, aVar);
            }
        }
    }

    public void d(r rVar) {
        if (this.f15992b) {
            return;
        }
        rVar.t(this.f15991a, 0, 10);
        rVar.o();
        if (AbstractC1073b.j(this.f15991a) == 0) {
            return;
        }
        this.f15992b = true;
    }
}
