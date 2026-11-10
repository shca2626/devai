package Y;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9352a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9353b;

    public d(Object obj, Object obj2) {
        this.f9352a = obj;
        this.f9353b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f9352a, this.f9352a) && c.a(dVar.f9353b, this.f9353b);
    }

    public int hashCode() {
        Object obj = this.f9352a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f9353b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f9352a + " " + this.f9353b + "}";
    }
}
