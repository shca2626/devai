package z1;

import E0.U;
import g1.I;
import g1.N;
import java.math.RoundingMode;

/* renamed from: z1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1832b implements InterfaceC1839i {

    /* renamed from: a, reason: collision with root package name */
    public final long f24033a;

    /* renamed from: b, reason: collision with root package name */
    public final long f24034b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24035c;

    /* renamed from: d, reason: collision with root package name */
    public final I f24036d;

    public C1832b(long j7, long j8, long j9) {
        this.f24036d = new I(new long[]{j8}, new long[]{0}, j7);
        this.f24033a = j8;
        this.f24034b = j9;
        int i7 = -2147483647;
        if (j7 == -9223372036854775807L) {
            this.f24035c = -2147483647;
            return;
        }
        long jG1 = U.g1(j8 - j9, 8L, j7, RoundingMode.HALF_UP);
        if (jG1 > 0 && jG1 <= 2147483647L) {
            i7 = (int) jG1;
        }
        this.f24035c = i7;
    }

    @Override // z1.InterfaceC1839i
    public long a(long j7) {
        return this.f24036d.a(j7);
    }

    public boolean b(long j7) {
        return this.f24036d.j(j7, 100000L);
    }

    @Override // z1.InterfaceC1839i
    public long c() {
        return this.f24034b;
    }

    @Override // z1.InterfaceC1839i
    public long d() {
        return this.f24033a;
    }

    @Override // g1.N
    public boolean e() {
        return this.f24036d.e();
    }

    @Override // g1.N
    public N.a g(long j7) {
        return this.f24036d.g(j7);
    }

    @Override // z1.InterfaceC1839i
    public int h() {
        return this.f24035c;
    }

    @Override // g1.N
    public long i() {
        return this.f24036d.i();
    }

    public void j(long j7, long j8) {
        if (b(j7)) {
            return;
        }
        this.f24036d.b(j7, j8);
    }

    public void k(long j7) {
        this.f24036d.k(j7);
    }
}
