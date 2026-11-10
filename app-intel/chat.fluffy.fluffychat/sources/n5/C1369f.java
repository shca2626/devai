package n5;

/* renamed from: n5.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1369f extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final String f20151l;

    /* renamed from: m, reason: collision with root package name */
    public final String f20152m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f20153n;

    public C1369f(String str, String str2, Object obj) {
        M5.m.e(str, "code");
        this.f20151l = str;
        this.f20152m = str2;
        this.f20153n = obj;
    }

    public final String a() {
        return this.f20151l;
    }

    public final Object b() {
        return this.f20153n;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f20152m;
    }
}
