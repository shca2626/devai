package Q1;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f7596f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f7597a;

    /* renamed from: b, reason: collision with root package name */
    public final float f7598b;

    /* renamed from: c, reason: collision with root package name */
    public final float f7599c;

    /* renamed from: d, reason: collision with root package name */
    public final float f7600d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7601e;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public b() {
        this(0, 0.0f, 0.0f, 0.0f, 0L, 31, null);
    }

    public final long a() {
        return this.f7601e;
    }

    public final float b() {
        return this.f7598b;
    }

    public final int c() {
        return this.f7597a;
    }

    public final float d() {
        return this.f7599c;
    }

    public final float e() {
        return this.f7600d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            return this.f7599c == bVar.f7599c && this.f7600d == bVar.f7600d && this.f7598b == bVar.f7598b && this.f7597a == bVar.f7597a && this.f7601e == bVar.f7601e;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Float.hashCode(this.f7599c) * 31) + Float.hashCode(this.f7600d)) * 31) + Float.hashCode(this.f7598b)) * 31) + Integer.hashCode(this.f7597a)) * 31) + Long.hashCode(this.f7601e);
    }

    public String toString() {
        return "NavigationEvent(touchX=" + this.f7599c + ", touchY=" + this.f7600d + ", progress=" + this.f7598b + ", swipeEdge=" + this.f7597a + ", frameTimeMillis=" + this.f7601e + ')';
    }

    public b(int i7, float f7, float f8, float f9, long j7) {
        this.f7597a = i7;
        this.f7598b = f7;
        this.f7599c = f8;
        this.f7600d = f9;
        this.f7601e = j7;
    }

    public /* synthetic */ b(int i7, float f7, float f8, float f9, long j7, int i8, M5.g gVar) {
        this((i8 & 1) != 0 ? 2 : i7, (i8 & 2) != 0 ? 0.0f : f7, (i8 & 4) != 0 ? 0.0f : f8, (i8 & 8) != 0 ? 0.0f : f9, (i8 & 16) != 0 ? 0L : j7);
    }
}
