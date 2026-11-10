package ah;

/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    protected int f1140a;

    /* renamed from: b, reason: collision with root package name */
    protected int f1141b;

    protected g() {
    }

    public final int a() {
        int i12 = this.f1141b;
        if (i12 < 0) {
            return 0;
        }
        return i12;
    }

    public final int b() {
        return this.f1141b + 1;
    }

    public final String c() {
        int i12 = this.f1140a;
        return i12 != 0 ? i12 != 1 ? i12 != 2 ? "?" : "OBJECT" : "ARRAY" : "ROOT";
    }

    public final boolean d() {
        return this.f1140a == 1;
    }

    public final boolean e() {
        return this.f1140a == 2;
    }

    public final boolean f() {
        return this.f1140a == 0;
    }
}
