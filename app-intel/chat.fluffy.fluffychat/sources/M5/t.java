package M5;

/* loaded from: classes.dex */
public abstract class t extends c implements T5.h {

    /* renamed from: s, reason: collision with root package name */
    public final boolean f5720s;

    public t() {
        this.f5720s = false;
    }

    @Override // M5.c
    public T5.a b() {
        return this.f5720s ? this : super.b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return h().equals(tVar.h()) && g().equals(tVar.g()) && l().equals(tVar.l()) && m.a(f(), tVar.f());
        }
        if (obj instanceof T5.h) {
            return obj.equals(b());
        }
        return false;
    }

    public int hashCode() {
        return (((h().hashCode() * 31) + g().hashCode()) * 31) + l().hashCode();
    }

    public T5.h m() {
        if (this.f5720s) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (T5.h) super.k();
    }

    public String toString() {
        T5.a aVarB = b();
        if (aVarB != this) {
            return aVarB.toString();
        }
        return "property " + g() + " (Kotlin reflection is not available)";
    }

    public t(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, (i7 & 1) == 1);
        this.f5720s = (i7 & 2) == 2;
    }
}
