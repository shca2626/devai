package z1;

import E0.U;
import android.util.Pair;
import g1.N;
import g1.O;

/* renamed from: z1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1833c implements InterfaceC1839i {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f24037a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f24038b;

    /* renamed from: c, reason: collision with root package name */
    public final long f24039c;

    public C1833c(long[] jArr, long[] jArr2, long j7) {
        this.f24037a = jArr;
        this.f24038b = jArr2;
        this.f24039c = j7 == -9223372036854775807L ? U.P0(jArr2[jArr2.length - 1]) : j7;
    }

    public static C1833c b(long j7, u1.l lVar, long j8) {
        int length = lVar.f22774e.length;
        int i7 = length + 1;
        long[] jArr = new long[i7];
        long[] jArr2 = new long[i7];
        jArr[0] = j7;
        long j9 = 0;
        jArr2[0] = 0;
        for (int i8 = 1; i8 <= length; i8++) {
            int i9 = i8 - 1;
            j7 += lVar.f22772c + lVar.f22774e[i9];
            j9 += lVar.f22773d + lVar.f22775f[i9];
            jArr[i8] = j7;
            jArr2[i8] = j9;
        }
        return new C1833c(jArr, jArr2, j8);
    }

    public static Pair j(long j7, long[] jArr, long[] jArr2) {
        int iH = U.h(jArr, j7, true, true);
        long j8 = jArr[iH];
        long j9 = jArr2[iH];
        int i7 = iH + 1;
        if (i7 == jArr.length) {
            return Pair.create(Long.valueOf(j8), Long.valueOf(j9));
        }
        return Pair.create(Long.valueOf(j7), Long.valueOf(((long) ((jArr[i7] == j8 ? 0.0d : (j7 - j8) / (r6 - j8)) * (jArr2[i7] - j9))) + j9));
    }

    @Override // z1.InterfaceC1839i
    public long a(long j7) {
        return U.P0(((Long) j(j7, this.f24037a, this.f24038b).second).longValue());
    }

    @Override // z1.InterfaceC1839i
    public long c() {
        return -1L;
    }

    @Override // z1.InterfaceC1839i
    public long d() {
        return 0L;
    }

    @Override // g1.N
    public boolean e() {
        return true;
    }

    @Override // g1.N
    public N.a g(long j7) {
        Pair pairJ = j(U.s1(U.p(j7, 0L, this.f24039c)), this.f24038b, this.f24037a);
        return new N.a(new O(U.P0(((Long) pairJ.first).longValue()), ((Long) pairJ.second).longValue()));
    }

    @Override // z1.InterfaceC1839i
    public int h() {
        return -2147483647;
    }

    @Override // g1.N
    public long i() {
        return this.f24039c;
    }
}
