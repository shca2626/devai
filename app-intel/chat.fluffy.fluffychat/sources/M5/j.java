package M5;

/* loaded from: classes.dex */
public abstract class j extends c implements i, T5.e {

    /* renamed from: s, reason: collision with root package name */
    public final int f5715s;

    /* renamed from: t, reason: collision with root package name */
    public final int f5716t;

    public j(int i7, Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
        this.f5715s = i7;
        this.f5716t = i8 >> 1;
    }

    @Override // M5.c
    public T5.a c() {
        return x.a(this);
    }

    @Override // M5.i
    public int e() {
        return this.f5715s;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return g().equals(jVar.g()) && l().equals(jVar.l()) && this.f5716t == jVar.f5716t && this.f5715s == jVar.f5715s && m.a(f(), jVar.f()) && m.a(h(), jVar.h());
        }
        if (obj instanceof T5.e) {
            return obj.equals(b());
        }
        return false;
    }

    public int hashCode() {
        return (((h() == null ? 0 : h().hashCode() * 31) + g().hashCode()) * 31) + l().hashCode();
    }

    public String toString() {
        T5.a aVarB = b();
        if (aVarB != this) {
            return aVarB.toString();
        }
        if ("<init>".equals(g())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + g() + " (Kotlin reflection is not available)";
    }
}
