package F0;

import B0.y;

/* loaded from: classes.dex */
public final class d implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f2468a;

    public d(int i7) {
        this.f2468a = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f2468a == ((d) obj).f2468a;
    }

    public int hashCode() {
        return this.f2468a;
    }

    public String toString() {
        return "Mp4AlternateGroup: " + this.f2468a;
    }
}
