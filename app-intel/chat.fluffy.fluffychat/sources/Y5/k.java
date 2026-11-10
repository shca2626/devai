package Y5;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final b f9919a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final c f9920b = new c();

    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f9921a;

        public a(Throwable th) {
            this.f9921a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && M5.m.a(this.f9921a, ((a) obj).f9921a);
        }

        public int hashCode() {
            Throwable th = this.f9921a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // Y5.k.c
        public String toString() {
            return "Closed(" + this.f9921a + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public final Object a(Throwable th) {
            return k.b(new a(th));
        }

        public final Object b() {
            return k.b(k.f9920b);
        }

        public final Object c(Object obj) {
            return k.b(obj);
        }

        public b() {
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public static final Throwable c(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f9921a;
        }
        return null;
    }

    public static final Object d(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static final boolean e(Object obj) {
        return obj instanceof a;
    }

    public static final boolean f(Object obj) {
        return !(obj instanceof c);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
