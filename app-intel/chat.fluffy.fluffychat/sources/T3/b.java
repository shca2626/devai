package T3;

import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final S3.b f8265a;

    /* renamed from: b, reason: collision with root package name */
    public final S3.b f8266b;

    /* renamed from: c, reason: collision with root package name */
    public final S3.c f8267c;

    public b(S3.b bVar, S3.b bVar2, S3.c cVar) {
        this.f8265a = bVar;
        this.f8266b = bVar2;
        this.f8267c = cVar;
    }

    public S3.c a() {
        return this.f8267c;
    }

    public S3.b b() {
        return this.f8265a;
    }

    public S3.b c() {
        return this.f8266b;
    }

    public boolean d() {
        return this.f8266b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f8265a, bVar.f8265a) && Objects.equals(this.f8266b, bVar.f8266b) && Objects.equals(this.f8267c, bVar.f8267c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f8265a) ^ Objects.hashCode(this.f8266b)) ^ Objects.hashCode(this.f8267c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f8265a);
        sb.append(" , ");
        sb.append(this.f8266b);
        sb.append(" : ");
        S3.c cVar = this.f8267c;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
