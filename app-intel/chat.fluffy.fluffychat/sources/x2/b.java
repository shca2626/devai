package x2;

/* loaded from: classes.dex */
public enum b {
    ENABLED(true, true),
    READ_ONLY(true, false),
    WRITE_ONLY(false, true),
    DISABLED(false, false);


    /* renamed from: l, reason: collision with root package name */
    public final boolean f23464l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f23465m;

    b(boolean z7, boolean z8) {
        this.f23464l = z7;
        this.f23465m = z8;
    }

    public final boolean d() {
        return this.f23464l;
    }

    public final boolean e() {
        return this.f23465m;
    }
}
