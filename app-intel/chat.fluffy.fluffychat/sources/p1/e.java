package p1;

import B0.y;
import o3.i;

/* loaded from: classes.dex */
public final class e implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f20759a;

    public e(long j7) {
        this.f20759a = j7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && e.class == obj.getClass() && this.f20759a == ((e) obj).f20759a;
    }

    public int hashCode() {
        return 527 + i.c(this.f20759a);
    }

    public String toString() {
        return "ThumbnailMetadata: presentationTimeUs=" + this.f20759a;
    }
}
