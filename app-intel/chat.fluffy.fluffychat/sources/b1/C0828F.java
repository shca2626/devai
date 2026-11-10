package b1;

import B0.L;
import I0.F1;
import java.util.Objects;

/* renamed from: b1.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0828F {

    /* renamed from: a, reason: collision with root package name */
    public final int f13522a;

    /* renamed from: b, reason: collision with root package name */
    public final F1[] f13523b;

    /* renamed from: c, reason: collision with root package name */
    public final y[] f13524c;

    /* renamed from: d, reason: collision with root package name */
    public final L f13525d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f13526e;

    public C0828F(F1[] f1Arr, y[] yVarArr, L l7, Object obj) {
        j3.o.d(f1Arr.length == yVarArr.length);
        this.f13523b = f1Arr;
        this.f13524c = (y[]) yVarArr.clone();
        this.f13525d = l7;
        this.f13526e = obj;
        this.f13522a = f1Arr.length;
    }

    public boolean a(C0828F c0828f) {
        if (c0828f == null || c0828f.f13524c.length != this.f13524c.length) {
            return false;
        }
        for (int i7 = 0; i7 < this.f13524c.length; i7++) {
            if (!b(c0828f, i7)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(C0828F c0828f, int i7) {
        return c0828f != null && Objects.equals(this.f13523b[i7], c0828f.f13523b[i7]) && Objects.equals(this.f13524c[i7], c0828f.f13524c[i7]);
    }

    public boolean c(int i7) {
        return this.f13523b[i7] != null;
    }
}
