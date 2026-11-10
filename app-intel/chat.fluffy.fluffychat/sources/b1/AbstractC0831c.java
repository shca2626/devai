package b1;

import B0.I;
import E0.U;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* renamed from: b1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0831c implements y {

    /* renamed from: a, reason: collision with root package name */
    public final I f13553a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13554b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f13555c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13556d;

    /* renamed from: e, reason: collision with root package name */
    public final B0.s[] f13557e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f13558f;

    /* renamed from: g, reason: collision with root package name */
    public int f13559g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13560h;

    public AbstractC0831c(I i7, int... iArr) {
        this(i7, iArr, 0);
    }

    public static /* synthetic */ int v(B0.s sVar, B0.s sVar2) {
        return sVar2.f754j - sVar.f754j;
    }

    @Override // b1.y
    public boolean b(int i7, long j7) {
        return this.f13558f[i7] > j7;
    }

    @Override // b1.InterfaceC0825C
    public final I c() {
        return this.f13553a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC0831c abstractC0831c = (AbstractC0831c) obj;
            if (this.f13553a.equals(abstractC0831c.f13553a) && Arrays.equals(this.f13555c, abstractC0831c.f13555c)) {
                return true;
            }
        }
        return false;
    }

    @Override // b1.y
    public void f(boolean z7) {
        this.f13560h = z7;
    }

    @Override // b1.InterfaceC0825C
    public final B0.s g(int i7) {
        return this.f13557e[i7];
    }

    public int hashCode() {
        if (this.f13559g == 0) {
            this.f13559g = (System.identityHashCode(this.f13553a) * 31) + Arrays.hashCode(this.f13555c);
        }
        return this.f13559g;
    }

    @Override // b1.InterfaceC0825C
    public final int i(int i7) {
        return this.f13555c[i7];
    }

    @Override // b1.y
    public int j(long j7, List list) {
        return list.size();
    }

    @Override // b1.y
    public final int k() {
        return this.f13555c[d()];
    }

    @Override // b1.InterfaceC0825C
    public final int l(B0.s sVar) {
        for (int i7 = 0; i7 < this.f13554b; i7++) {
            if (this.f13557e[i7] == sVar) {
                return i7;
            }
        }
        return -1;
    }

    @Override // b1.InterfaceC0825C
    public final int length() {
        return this.f13555c.length;
    }

    @Override // b1.y
    public final B0.s m() {
        return this.f13557e[d()];
    }

    @Override // b1.y
    public boolean o(int i7, long j7) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = b(i7, jElapsedRealtime);
        int i8 = 0;
        while (i8 < this.f13554b && !zB) {
            zB = (i8 == i7 || b(i8, jElapsedRealtime)) ? false : true;
            i8++;
        }
        if (!zB) {
            return false;
        }
        long[] jArr = this.f13558f;
        jArr[i7] = Math.max(jArr[i7], U.c(jElapsedRealtime, j7, Long.MAX_VALUE));
        return true;
    }

    @Override // b1.InterfaceC0825C
    public final int u(int i7) {
        for (int i8 = 0; i8 < this.f13554b; i8++) {
            if (this.f13555c[i8] == i7) {
                return i8;
            }
        }
        return -1;
    }

    public AbstractC0831c(I i7, int[] iArr, int i8) {
        j3.o.v(iArr.length > 0);
        this.f13556d = i8;
        this.f13553a = (I) j3.o.q(i7);
        int length = iArr.length;
        this.f13554b = length;
        this.f13557e = new B0.s[length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            this.f13557e[i9] = i7.a(iArr[i9]);
        }
        Arrays.sort(this.f13557e, new Comparator() { // from class: b1.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC0831c.v((B0.s) obj, (B0.s) obj2);
            }
        });
        this.f13555c = new int[this.f13554b];
        int i10 = 0;
        while (true) {
            int i11 = this.f13554b;
            if (i10 >= i11) {
                this.f13558f = new long[i11];
                this.f13560h = false;
                return;
            } else {
                this.f13555c[i10] = i7.b(this.f13557e[i10]);
                i10++;
            }
        }
    }

    @Override // b1.y
    public void a() {
    }

    @Override // b1.y
    public void h() {
    }

    @Override // b1.y
    public void q(float f7) {
    }
}
