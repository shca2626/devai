package Q1;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7637a = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends j {

        /* renamed from: b, reason: collision with root package name */
        public static final b f7638b = new b();

        public b() {
            super(null);
        }

        public String toString() {
            return "Idle()";
        }
    }

    public static final class c extends j {

        /* renamed from: b, reason: collision with root package name */
        public final Q1.b f7639b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7640c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Q1.b bVar, int i7) {
            super(null);
            M5.m.e(bVar, "latestEvent");
            this.f7639b = bVar;
            this.f7640c = i7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f7640c == cVar.f7640c && M5.m.a(this.f7639b, cVar.f7639b);
        }

        public int hashCode() {
            return (this.f7640c * 31) + this.f7639b.hashCode();
        }

        public String toString() {
            return "InProgress(latestEvent=" + this.f7639b + ", direction=" + this.f7640c + ')';
        }
    }

    public /* synthetic */ j(M5.g gVar) {
        this();
    }

    public j() {
    }
}
