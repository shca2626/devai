package M0;

import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5529a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5530b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5531c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5532d;

    public b(String str, String str2, int i7, int i8) {
        this.f5529a = str;
        this.f5530b = str2;
        this.f5531c = i7;
        this.f5532d = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5531c == bVar.f5531c && this.f5532d == bVar.f5532d && Objects.equals(this.f5529a, bVar.f5529a) && Objects.equals(this.f5530b, bVar.f5530b);
    }

    public int hashCode() {
        return Objects.hash(this.f5529a, this.f5530b, Integer.valueOf(this.f5531c), Integer.valueOf(this.f5532d));
    }
}
