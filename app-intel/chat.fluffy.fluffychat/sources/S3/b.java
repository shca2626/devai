package S3;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f8175a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8176b;

    public b(int i7, int i8) {
        this.f8175a = i7;
        this.f8176b = i8;
    }

    public final int a() {
        return this.f8176b;
    }

    public final int b() {
        return this.f8175a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f8175a == bVar.f8175a && this.f8176b == bVar.f8176b;
    }

    public final int hashCode() {
        return this.f8175a ^ this.f8176b;
    }

    public final String toString() {
        return this.f8175a + "(" + this.f8176b + ')';
    }
}
