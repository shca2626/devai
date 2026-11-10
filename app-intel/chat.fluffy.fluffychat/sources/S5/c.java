package S5;

import M5.g;

/* loaded from: classes.dex */
public final class c extends S5.a {

    /* renamed from: p, reason: collision with root package name */
    public static final a f8212p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final c f8213q = new c(1, 0);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f8213q;
        }

        public a() {
        }
    }

    public c(int i7, int i8) {
        super(i7, i8, 1);
    }

    @Override // S5.a
    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return f() == cVar.f() && g() == cVar.g();
    }

    @Override // S5.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (f() * 31) + g();
    }

    @Override // S5.a
    public boolean isEmpty() {
        return f() > g();
    }

    public Integer k() {
        return Integer.valueOf(g());
    }

    public Integer l() {
        return Integer.valueOf(f());
    }

    @Override // S5.a
    public String toString() {
        return f() + ".." + g();
    }
}
