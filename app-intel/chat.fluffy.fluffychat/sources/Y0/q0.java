package Y0;

import E0.AbstractC0332s;
import j3.InterfaceC1232f;
import k3.AbstractC1279v;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: d, reason: collision with root package name */
    public static final q0 f9797d = new q0(new B0.I[0]);

    /* renamed from: e, reason: collision with root package name */
    public static final String f9798e = E0.U.A0(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f9799a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1279v f9800b;

    /* renamed from: c, reason: collision with root package name */
    public int f9801c;

    public q0(B0.I... iArr) {
        this.f9800b = AbstractC1279v.s(iArr);
        this.f9799a = iArr.length;
        e();
    }

    public B0.I b(int i7) {
        return (B0.I) this.f9800b.get(i7);
    }

    public AbstractC1279v c() {
        return AbstractC1279v.r(k3.G.k(this.f9800b, new InterfaceC1232f() { // from class: Y0.p0
            @Override // j3.InterfaceC1232f
            public final Object apply(Object obj) {
                return Integer.valueOf(((B0.I) obj).f427c);
            }
        }));
    }

    public int d(B0.I i7) {
        int iIndexOf = this.f9800b.indexOf(i7);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final void e() {
        int i7 = 0;
        while (i7 < this.f9800b.size()) {
            int i8 = i7 + 1;
            for (int i9 = i8; i9 < this.f9800b.size(); i9++) {
                if (((B0.I) this.f9800b.get(i7)).equals(this.f9800b.get(i9))) {
                    AbstractC0332s.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i7 = i8;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q0.class == obj.getClass()) {
            q0 q0Var = (q0) obj;
            if (this.f9799a == q0Var.f9799a && this.f9800b.equals(q0Var.f9800b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f9801c == 0) {
            this.f9801c = this.f9800b.hashCode();
        }
        return this.f9801c;
    }

    public String toString() {
        return this.f9800b.toString();
    }
}
