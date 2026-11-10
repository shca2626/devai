package K0;

/* renamed from: K0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0488j {

    /* renamed from: d, reason: collision with root package name */
    public static final C0488j f5160d = new b().d();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5161a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5162b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5163c;

    /* renamed from: K0.j$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5164a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5165b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f5166c;

        public C0488j d() {
            if (this.f5164a || !(this.f5165b || this.f5166c)) {
                return new C0488j(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        public b e(boolean z7) {
            this.f5164a = z7;
            return this;
        }

        public b f(boolean z7) {
            this.f5165b = z7;
            return this;
        }

        public b g(boolean z7) {
            this.f5166c = z7;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0488j.class == obj.getClass()) {
            C0488j c0488j = (C0488j) obj;
            if (this.f5161a == c0488j.f5161a && this.f5162b == c0488j.f5162b && this.f5163c == c0488j.f5163c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5161a ? 1 : 0) << 2) + ((this.f5162b ? 1 : 0) << 1) + (this.f5163c ? 1 : 0);
    }

    public C0488j(b bVar) {
        this.f5161a = bVar.f5164a;
        this.f5162b = bVar.f5165b;
        this.f5163c = bVar.f5166c;
    }
}
