package z1;

import g1.C1081j;
import g1.J;

/* renamed from: z1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1830a extends C1081j implements InterfaceC1838i {

    /* renamed from: i, reason: collision with root package name */
    public final long f24034i;

    /* renamed from: j, reason: collision with root package name */
    public final int f24035j;

    /* renamed from: k, reason: collision with root package name */
    public final int f24036k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f24037l;

    /* renamed from: m, reason: collision with root package name */
    public final long f24038m;

    public C1830a(long j7, long j8, J.a aVar, boolean z7) {
        this(j7, j8, aVar.f15963f, aVar.f15960c, z7, true);
    }

    @Override // z1.InterfaceC1838i
    public long a(long j7) {
        return j(j7);
    }

    @Override // z1.InterfaceC1838i
    public long c() {
        return this.f24038m;
    }

    @Override // z1.InterfaceC1838i
    public long d() {
        return this.f24034i;
    }

    @Override // z1.InterfaceC1838i
    public int h() {
        return this.f24035j;
    }

    public C1830a l(long j7) {
        return new C1830a(j7, this.f24034i, this.f24035j, this.f24036k, this.f24037l, false);
    }

    public C1830a(long j7, long j8, int i7, int i8, boolean z7) {
        this(j7, j8, i7, i8, z7, true);
    }

    public C1830a(long j7, long j8, int i7, int i8, boolean z7, boolean z8) {
        super(j7, j8, i7, i8, z7, z8);
        long j9 = j7;
        this.f24034i = j8;
        this.f24035j = i7;
        this.f24036k = i8;
        this.f24037l = z7;
        this.f24038m = j9 == -1 ? -1L : j9;
    }
}
