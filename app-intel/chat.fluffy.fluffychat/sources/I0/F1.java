package I0;

/* loaded from: classes.dex */
public final class F1 {

    /* renamed from: c, reason: collision with root package name */
    public static final F1 f3666c = new F1(0, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f3667a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3668b;

    public F1(int i7, boolean z7) {
        this.f3667a = i7;
        this.f3668b = z7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && F1.class == obj.getClass()) {
            F1 f12 = (F1) obj;
            if (this.f3667a == f12.f3667a && this.f3668b == f12.f3668b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f3667a << 1) + (this.f3668b ? 1 : 0);
    }
}
