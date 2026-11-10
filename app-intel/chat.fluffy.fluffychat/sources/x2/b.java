package x2;

/* loaded from: classes.dex */
public enum b {
    ENABLED(true, true),
    READ_ONLY(true, false),
    WRITE_ONLY(false, true),
    DISABLED(false, false);


    /* renamed from: l, reason: collision with root package name */
    public final boolean f23458l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f23459m;

    b(boolean z7, boolean z8) {
        this.f23458l = z7;
        this.f23459m = z8;
    }

    public final boolean d() {
        return this.f23458l;
    }

    public final boolean e() {
        return this.f23459m;
    }
}
