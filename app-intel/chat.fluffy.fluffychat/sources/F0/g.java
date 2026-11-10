package F0;

import B0.y;

/* loaded from: classes.dex */
public final class g implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f2476a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2477b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2478c;

    public g(long j7, long j8, long j9) {
        this.f2476a = j7;
        this.f2477b = j8;
        this.f2478c = j9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2476a == gVar.f2476a && this.f2477b == gVar.f2477b && this.f2478c == gVar.f2478c;
    }

    public int hashCode() {
        return ((((527 + o3.i.c(this.f2476a)) * 31) + o3.i.c(this.f2477b)) * 31) + o3.i.c(this.f2478c);
    }

    public String toString() {
        return "Mp4Timestamp: creation time=" + this.f2476a + ", modification time=" + this.f2477b + ", timescale=" + this.f2478c;
    }
}
