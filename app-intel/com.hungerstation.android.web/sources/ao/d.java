package ao;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final b f12202a;

    /* renamed from: b, reason: collision with root package name */
    public final a f12203b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12204c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12205d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12206e;

    /* renamed from: f, reason: collision with root package name */
    public final double f12207f;

    /* renamed from: g, reason: collision with root package name */
    public final double f12208g;

    /* renamed from: h, reason: collision with root package name */
    public final int f12209h;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f12210a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12211b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f12212c;

        public a(boolean z12, boolean z13, boolean z14) {
            this.f12210a = z12;
            this.f12211b = z13;
            this.f12212c = z14;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f12213a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12214b;

        public b(int i12, int i13) {
            this.f12213a = i12;
            this.f12214b = i13;
        }
    }

    public d(long j12, b bVar, a aVar, int i12, int i13, double d12, double d13, int i14) {
        this.f12204c = j12;
        this.f12202a = bVar;
        this.f12203b = aVar;
        this.f12205d = i12;
        this.f12206e = i13;
        this.f12207f = d12;
        this.f12208g = d13;
        this.f12209h = i14;
    }

    public boolean a(long j12) {
        return this.f12204c < j12;
    }
}
