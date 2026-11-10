package v1;

import B0.y;
import o3.i;

/* renamed from: v1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1675a implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f22899a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22900b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22901c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22902d;

    /* renamed from: e, reason: collision with root package name */
    public final long f22903e;

    public AbstractC1675a(long j7, long j8, long j9, long j10, long j11) {
        this.f22899a = j7;
        this.f22900b = j8;
        this.f22901c = j9;
        this.f22902d = j10;
        this.f22903e = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC1675a abstractC1675a = (AbstractC1675a) obj;
            if (this.f22899a == abstractC1675a.f22899a && this.f22900b == abstractC1675a.f22900b && this.f22901c == abstractC1675a.f22901c && this.f22902d == abstractC1675a.f22902d && this.f22903e == abstractC1675a.f22903e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + i.c(this.f22899a)) * 31) + i.c(this.f22900b)) * 31) + i.c(this.f22901c)) * 31) + i.c(this.f22902d)) * 31) + i.c(this.f22903e);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f22899a + ", photoSize=" + this.f22900b + ", photoPresentationTimestampUs=" + this.f22901c + ", videoStartPosition=" + this.f22902d + ", videoSize=" + this.f22903e;
    }
}
