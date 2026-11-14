package v1;

import B0.y;
import o3.i;

/* renamed from: v1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1674a implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f22905a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22906b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22907c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22908d;

    /* renamed from: e, reason: collision with root package name */
    public final long f22909e;

    public AbstractC1674a(long j7, long j8, long j9, long j10, long j11) {
        this.f22905a = j7;
        this.f22906b = j8;
        this.f22907c = j9;
        this.f22908d = j10;
        this.f22909e = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC1674a abstractC1674a = (AbstractC1674a) obj;
            if (this.f22905a == abstractC1674a.f22905a && this.f22906b == abstractC1674a.f22906b && this.f22907c == abstractC1674a.f22907c && this.f22908d == abstractC1674a.f22908d && this.f22909e == abstractC1674a.f22909e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + i.c(this.f22905a)) * 31) + i.c(this.f22906b)) * 31) + i.c(this.f22907c)) * 31) + i.c(this.f22908d)) * 31) + i.c(this.f22909e);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f22905a + ", photoSize=" + this.f22906b + ", photoPresentationTimestampUs=" + this.f22907c + ", videoStartPosition=" + this.f22908d + ", videoSize=" + this.f22909e;
    }
}
