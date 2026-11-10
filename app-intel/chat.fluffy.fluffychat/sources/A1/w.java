package A1;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f210a;

    /* renamed from: b, reason: collision with root package name */
    public final int f211b;

    /* renamed from: c, reason: collision with root package name */
    public final long f212c;

    /* renamed from: d, reason: collision with root package name */
    public final long f213d;

    /* renamed from: e, reason: collision with root package name */
    public final long f214e;

    /* renamed from: f, reason: collision with root package name */
    public final long f215f;

    /* renamed from: g, reason: collision with root package name */
    public final B0.s f216g;

    /* renamed from: h, reason: collision with root package name */
    public final int f217h;

    /* renamed from: i, reason: collision with root package name */
    public final long[] f218i;

    /* renamed from: j, reason: collision with root package name */
    public final long[] f219j;

    /* renamed from: k, reason: collision with root package name */
    public final int f220k;

    /* renamed from: l, reason: collision with root package name */
    public final x[] f221l;

    public w(int i7, int i8, long j7, long j8, long j9, long j10, B0.s sVar, int i9, x[] xVarArr, int i10, long[] jArr, long[] jArr2) {
        this.f210a = i7;
        this.f211b = i8;
        this.f212c = j7;
        this.f213d = j8;
        this.f214e = j9;
        this.f215f = j10;
        this.f216g = sVar;
        this.f217h = i9;
        this.f221l = xVarArr;
        this.f220k = i10;
        this.f218i = jArr;
        this.f219j = jArr2;
    }

    public w a(B0.s sVar) {
        return new w(this.f210a, this.f211b, this.f212c, this.f213d, this.f214e, this.f215f, sVar, this.f217h, this.f221l, this.f220k, this.f218i, this.f219j);
    }

    public x b(int i7) {
        x[] xVarArr = this.f221l;
        if (xVarArr == null) {
            return null;
        }
        return xVarArr[i7];
    }
}
