package q5;

/* renamed from: q5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1502b extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final String f21450l;

    /* renamed from: m, reason: collision with root package name */
    public final String f21451m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f21452n;

    public C1502b(String str, String str2, Object obj) {
        M5.m.e(str, "code");
        this.f21450l = str;
        this.f21451m = str2;
        this.f21452n = obj;
    }

    public final String a() {
        return this.f21450l;
    }

    public final Object b() {
        return this.f21452n;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f21451m;
    }
}
