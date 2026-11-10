package g1;

import E0.AbstractC0322h;
import F0.h;
import java.util.ArrayList;
import java.util.List;

/* renamed from: g1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1074d {

    /* renamed from: a, reason: collision with root package name */
    public final List f16050a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16051b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16052c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16053d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16054e;

    /* renamed from: f, reason: collision with root package name */
    public final int f16055f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16056g;

    /* renamed from: h, reason: collision with root package name */
    public final int f16057h;

    /* renamed from: i, reason: collision with root package name */
    public final int f16058i;

    /* renamed from: j, reason: collision with root package name */
    public final int f16059j;

    /* renamed from: k, reason: collision with root package name */
    public final float f16060k;

    /* renamed from: l, reason: collision with root package name */
    public final String f16061l;

    public C1074d(List list, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, float f7, String str) {
        this.f16050a = list;
        this.f16051b = i7;
        this.f16052c = i8;
        this.f16053d = i9;
        this.f16054e = i10;
        this.f16055f = i11;
        this.f16056g = i12;
        this.f16057h = i13;
        this.f16058i = i14;
        this.f16059j = i15;
        this.f16060k = f7;
        this.f16061l = str;
    }

    public static byte[] a(E0.E e7) {
        int iY = e7.Y();
        int iG = e7.g();
        e7.g0(iY);
        return AbstractC0322h.k(e7.f(), iG, iY);
    }

    public static C1074d b(E0.E e7) throws B0.A {
        String strG;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        float f7;
        int i13;
        int i14;
        try {
            e7.g0(4);
            int iQ = (e7.Q() & 3) + 1;
            if (iQ == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iQ2 = e7.Q() & 31;
            for (int i15 = 0; i15 < iQ2; i15++) {
                arrayList.add(a(e7));
            }
            int iQ3 = e7.Q();
            for (int i16 = 0; i16 < iQ3; i16++) {
                arrayList.add(a(e7));
            }
            if (iQ2 > 0) {
                h.m mVarD = F0.h.D((byte[]) arrayList.get(0), F0.h.f2479a.length, ((byte[]) arrayList.get(0)).length);
                int i17 = mVarD.f2546f;
                int i18 = mVarD.f2547g;
                int i19 = mVarD.f2549i + 8;
                int i20 = mVarD.f2550j + 8;
                int i21 = mVarD.f2557q;
                int i22 = mVarD.f2558r;
                int i23 = mVarD.f2559s;
                int i24 = mVarD.f2560t;
                float f8 = mVarD.f2548h;
                strG = AbstractC0322h.g(mVarD.f2541a, mVarD.f2542b, mVarD.f2543c);
                i11 = i23;
                i12 = i24;
                f7 = f8;
                i10 = i20;
                i13 = i21;
                i14 = i22;
                i7 = i17;
                i8 = i18;
                i9 = i19;
            } else {
                strG = null;
                i7 = -1;
                i8 = -1;
                i9 = -1;
                i10 = -1;
                i11 = -1;
                i12 = 16;
                f7 = 1.0f;
                i13 = -1;
                i14 = -1;
            }
            return new C1074d(arrayList, iQ, i7, i8, i9, i10, i13, i14, i11, i12, f7, strG);
        } catch (ArrayIndexOutOfBoundsException e8) {
            throw B0.A.a("Error parsing AVC config", e8);
        }
    }
}
