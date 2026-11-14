package j3;

/* loaded from: classes.dex */
public final class r extends AbstractC1237l {

    /* renamed from: l, reason: collision with root package name */
    public final Object f18726l;

    public r(Object obj) {
        this.f18726l = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f18726l.equals(((r) obj).f18726l);
        }
        return false;
    }

    public int hashCode() {
        return this.f18726l.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f18726l + ")";
    }
}
