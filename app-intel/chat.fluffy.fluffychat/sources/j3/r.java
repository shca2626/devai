package j3;

/* loaded from: classes.dex */
public final class r extends AbstractC1238l {

    /* renamed from: l, reason: collision with root package name */
    public final Object f18727l;

    public r(Object obj) {
        this.f18727l = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f18727l.equals(((r) obj).f18727l);
        }
        return false;
    }

    public int hashCode() {
        return this.f18727l.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f18727l + ")";
    }
}
