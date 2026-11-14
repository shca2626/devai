package n5;

/* renamed from: n5.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1368f extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final String f20150l;

    /* renamed from: m, reason: collision with root package name */
    public final String f20151m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f20152n;

    public C1368f(String str, String str2, Object obj) {
        M5.m.e(str, "code");
        this.f20150l = str;
        this.f20151m = str2;
        this.f20152n = obj;
    }

    public final String a() {
        return this.f20150l;
    }

    public final Object b() {
        return this.f20152n;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f20151m;
    }
}
