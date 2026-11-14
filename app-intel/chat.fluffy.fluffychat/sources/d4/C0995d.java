package d4;

/* renamed from: d4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0995d {

    /* renamed from: a, reason: collision with root package name */
    public final float f15182a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15183b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15184c;

    /* renamed from: d, reason: collision with root package name */
    public final long f15185d;

    public C0995d(float f7, long j7, long j8, long j9) {
        this.f15182a = f7;
        this.f15183b = j7;
        this.f15184c = j8;
        this.f15185d = j9;
    }

    public final long a() {
        return this.f15183b;
    }

    public final long b() {
        return this.f15185d;
    }

    public final long c() {
        return this.f15184c;
    }

    public final float d() {
        return this.f15182a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0995d)) {
            return false;
        }
        C0995d c0995d = (C0995d) obj;
        return Float.compare(this.f15182a, c0995d.f15182a) == 0 && this.f15183b == c0995d.f15183b && this.f15184c == c0995d.f15184c && this.f15185d == c0995d.f15185d;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f15182a) * 31) + Long.hashCode(this.f15183b)) * 31) + Long.hashCode(this.f15184c)) * 31) + Long.hashCode(this.f15185d);
    }

    public String toString() {
        return "ProgressInfo(percent=" + this.f15182a + ", bytesProcessed=" + this.f15183b + ", etaMs=" + this.f15184c + ", elapsedMs=" + this.f15185d + ')';
    }
}
