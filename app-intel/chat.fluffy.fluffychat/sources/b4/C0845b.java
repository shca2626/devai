package b4;

import D3.j;
import D3.q;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0845b {

    /* renamed from: a, reason: collision with root package name */
    public final J3.b f13724a;

    /* renamed from: c, reason: collision with root package name */
    public final int f13726c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13727d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13728e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13729f;

    /* renamed from: g, reason: collision with root package name */
    public final float f13730g;

    /* renamed from: i, reason: collision with root package name */
    public final q f13732i;

    /* renamed from: b, reason: collision with root package name */
    public final List f13725b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    public final int[] f13731h = new int[3];

    public C0845b(J3.b bVar, int i7, int i8, int i9, int i10, float f7, q qVar) {
        this.f13724a = bVar;
        this.f13726c = i7;
        this.f13727d = i8;
        this.f13728e = i9;
        this.f13729f = i10;
        this.f13730g = f7;
        this.f13732i = qVar;
    }

    public static float a(int[] iArr, int i7) {
        return (i7 - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final float b(int i7, int i8, int i9, int i10) {
        J3.b bVar = this.f13724a;
        int iL = bVar.l();
        int[] iArr = this.f13731h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i11 = i7;
        while (i11 >= 0 && bVar.g(i8, i11)) {
            int i12 = iArr[1];
            if (i12 > i9) {
                break;
            }
            iArr[1] = i12 + 1;
            i11--;
        }
        if (i11 >= 0 && iArr[1] <= i9) {
            while (i11 >= 0 && !bVar.g(i8, i11)) {
                int i13 = iArr[0];
                if (i13 > i9) {
                    break;
                }
                iArr[0] = i13 + 1;
                i11--;
            }
            if (iArr[0] > i9) {
                return Float.NaN;
            }
            int i14 = i7 + 1;
            while (i14 < iL && bVar.g(i8, i14)) {
                int i15 = iArr[1];
                if (i15 > i9) {
                    break;
                }
                iArr[1] = i15 + 1;
                i14++;
            }
            if (i14 != iL && iArr[1] <= i9) {
                while (i14 < iL && !bVar.g(i8, i14)) {
                    int i16 = iArr[2];
                    if (i16 > i9) {
                        break;
                    }
                    iArr[2] = i16 + 1;
                    i14++;
                }
                int i17 = iArr[2];
                if (i17 <= i9 && Math.abs(((iArr[0] + iArr[1]) + i17) - i10) * 5 < i10 * 2 && d(iArr)) {
                    return a(iArr, i14);
                }
            }
        }
        return Float.NaN;
    }

    public C0844a c() throws j {
        C0844a c0844aE;
        C0844a c0844aE2;
        int i7 = this.f13726c;
        int i8 = this.f13729f;
        int i9 = this.f13728e + i7;
        int i10 = this.f13727d + (i8 / 2);
        int[] iArr = new int[3];
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = ((i11 & 1) == 0 ? (i11 + 1) / 2 : -((i11 + 1) / 2)) + i10;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i13 = i7;
            while (i13 < i9 && !this.f13724a.g(i13, i12)) {
                i13++;
            }
            int i14 = 0;
            while (i13 < i9) {
                if (!this.f13724a.g(i13, i12)) {
                    if (i14 == 1) {
                        i14++;
                    }
                    iArr[i14] = iArr[i14] + 1;
                } else if (i14 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i14 != 2) {
                    i14++;
                    iArr[i14] = iArr[i14] + 1;
                } else {
                    if (d(iArr) && (c0844aE2 = e(iArr, i12, i13)) != null) {
                        return c0844aE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i14 = 1;
                }
                i13++;
            }
            if (d(iArr) && (c0844aE = e(iArr, i12, i9)) != null) {
                return c0844aE;
            }
        }
        if (this.f13725b.isEmpty()) {
            throw j.a();
        }
        return (C0844a) this.f13725b.get(0);
    }

    public final boolean d(int[] iArr) {
        float f7 = this.f13730g;
        float f8 = f7 / 2.0f;
        for (int i7 = 0; i7 < 3; i7++) {
            if (Math.abs(f7 - iArr[i7]) >= f8) {
                return false;
            }
        }
        return true;
    }

    public final C0844a e(int[] iArr, int i7, int i8) {
        int i9 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i8);
        float fB = b(i7, (int) fA, iArr[1] * 2, i9);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f7 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (C0844a c0844a : this.f13725b) {
            if (c0844a.f(f7, fB, fA)) {
                return c0844a.g(fB, fA, f7);
            }
        }
        C0844a c0844a2 = new C0844a(fA, fB, f7);
        this.f13725b.add(c0844a2);
        q qVar = this.f13732i;
        if (qVar == null) {
            return null;
        }
        qVar.a(c0844a2);
        return null;
    }
}
