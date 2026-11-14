package y5;

import java.io.Serializable;

/* renamed from: y5.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1813i implements Serializable {

    /* renamed from: m, reason: collision with root package name */
    public static final a f24010m = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public final Object f24011l;

    /* renamed from: y5.i$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: y5.i$b */
    public static final class b implements Serializable {

        /* renamed from: l, reason: collision with root package name */
        public final Throwable f24012l;

        public b(Throwable th) {
            M5.m.e(th, "exception");
            this.f24012l = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && M5.m.a(this.f24012l, ((b) obj).f24012l);
        }

        public int hashCode() {
            return this.f24012l.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f24012l + ')';
        }
    }

    public /* synthetic */ C1813i(Object obj) {
        this.f24011l = obj;
    }

    public static final /* synthetic */ C1813i a(Object obj) {
        return new C1813i(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof C1813i) && M5.m.a(obj, ((C1813i) obj2).h());
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f24012l;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof b;
    }

    public static String g(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f24011l, obj);
    }

    public final /* synthetic */ Object h() {
        return this.f24011l;
    }

    public int hashCode() {
        return e(this.f24011l);
    }

    public String toString() {
        return g(this.f24011l);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
