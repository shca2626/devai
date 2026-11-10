package q5;

/* renamed from: q5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1503b extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final String f21444l;

    /* renamed from: m, reason: collision with root package name */
    public final String f21445m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f21446n;

    public C1503b(String str, String str2, Object obj) {
        M5.m.e(str, "code");
        this.f21444l = str;
        this.f21445m = str2;
        this.f21446n = obj;
    }

    public final String a() {
        return this.f21444l;
    }

    public final Object b() {
        return this.f21446n;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f21445m;
    }
}
