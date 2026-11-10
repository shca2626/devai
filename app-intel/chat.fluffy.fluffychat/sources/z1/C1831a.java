package z1;

import g1.C1080j;
import g1.J;

/* renamed from: z1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1831a extends C1080j implements InterfaceC1839i {

    /* renamed from: i, reason: collision with root package name */
    public final long f24028i;

    /* renamed from: j, reason: collision with root package name */
    public final int f24029j;

    /* renamed from: k, reason: collision with root package name */
    public final int f24030k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f24031l;

    /* renamed from: m, reason: collision with root package name */
    public final long f24032m;

    public C1831a(long j7, long j8, J.a aVar, boolean z7) {
        this(j7, j8, aVar.f15963f, aVar.f15960c, z7, true);
    }

    @Override // z1.InterfaceC1839i
    public long a(long j7) {
        return j(j7);
    }

    @Override // z1.InterfaceC1839i
    public long c() {
        return this.f24032m;
    }

    @Override // z1.InterfaceC1839i
    public long d() {
        return this.f24028i;
    }

    @Override // z1.InterfaceC1839i
    public int h() {
        return this.f24029j;
    }

    public C1831a l(long j7) {
        return new C1831a(j7, this.f24028i, this.f24029j, this.f24030k, this.f24031l, false);
    }

    public C1831a(long j7, long j8, int i7, int i8, boolean z7) {
        this(j7, j8, i7, i8, z7, true);
    }

    public C1831a(long j7, long j8, int i7, int i8, boolean z7, boolean z8) {
        super(j7, j8, i7, i8, z7, z8);
        long j9 = j7;
        this.f24028i = j8;
        this.f24029j = i7;
        this.f24030k = i8;
        this.f24031l = z7;
        this.f24032m = j9 == -1 ? -1L : j9;
    }
}
