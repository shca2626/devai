package g2;

/* renamed from: g2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1098c extends InterfaceC1096a {

    /* renamed from: g2.c$a */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0175a f16168b = new C0175a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final a f16169c = new a("NONE");

        /* renamed from: d, reason: collision with root package name */
        public static final a f16170d = new a("FULL");

        /* renamed from: a, reason: collision with root package name */
        public final String f16171a;

        /* renamed from: g2.c$a$a, reason: collision with other inner class name */
        public static final class C0175a {
            public /* synthetic */ C0175a(M5.g gVar) {
                this();
            }

            public C0175a() {
            }
        }

        public a(String str) {
            this.f16171a = str;
        }

        public String toString() {
            return this.f16171a;
        }
    }

    /* renamed from: g2.c$b */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final a f16172b = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final b f16173c = new b("FLAT");

        /* renamed from: d, reason: collision with root package name */
        public static final b f16174d = new b("HALF_OPENED");

        /* renamed from: a, reason: collision with root package name */
        public final String f16175a;

        /* renamed from: g2.c$b$a */
        public static final class a {
            public /* synthetic */ a(M5.g gVar) {
                this();
            }

            public a() {
            }
        }

        public b(String str) {
            this.f16175a = str;
        }

        public String toString() {
            return this.f16175a;
        }
    }

    a a();

    b getState();
}
