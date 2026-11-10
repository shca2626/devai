package A1;

import E0.U;
import g1.S;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class A implements S {

    /* renamed from: a, reason: collision with root package name */
    public final int f31a;

    /* renamed from: b, reason: collision with root package name */
    public final o3.f f32b;

    public A(int i7, int[] iArr) {
        this.f31a = i7;
        this.f32b = iArr != null ? o3.f.a(iArr) : o3.f.e();
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(this.f32b.d());
        for (int i7 = 0; i7 < this.f32b.d(); i7++) {
            arrayList.add(U.o1(this.f32b.b(i7)));
        }
        return "UnsupportedBrands{major=" + U.o1(this.f31a) + ", compatible=" + arrayList + "}";
    }
}
