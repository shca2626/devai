package T3;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final List f8268a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8269b;

    public c(List list, int i7) {
        this.f8268a = new ArrayList(list);
        this.f8269b = i7;
    }

    public List a() {
        return this.f8268a;
    }

    public int b() {
        return this.f8269b;
    }

    public boolean c(List list) {
        return this.f8268a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f8268a.equals(((c) obj).f8268a);
        }
        return false;
    }

    public int hashCode() {
        return this.f8268a.hashCode();
    }

    public String toString() {
        return "{ " + this.f8268a + " }";
    }
}
