package androidx.lifecycle;

import y5.C1810f;

/* renamed from: androidx.lifecycle.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0805j {

    /* renamed from: a, reason: collision with root package name */
    public C0797b f12404a = new C0797b(null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: androidx.lifecycle.j$a */
    public static final class a {
        private static final /* synthetic */ F5.a $ENTRIES;
        private static final /* synthetic */ a[] $VALUES;
        public static final C0109a Companion;
        public static final a ON_CREATE = new a("ON_CREATE", 0);
        public static final a ON_START = new a("ON_START", 1);
        public static final a ON_RESUME = new a("ON_RESUME", 2);
        public static final a ON_PAUSE = new a("ON_PAUSE", 3);
        public static final a ON_STOP = new a("ON_STOP", 4);
        public static final a ON_DESTROY = new a("ON_DESTROY", 5);
        public static final a ON_ANY = new a("ON_ANY", 6);

        /* renamed from: androidx.lifecycle.j$a$a, reason: collision with other inner class name */
        public static final class C0109a {

            /* renamed from: androidx.lifecycle.j$a$a$a, reason: collision with other inner class name */
            public static final /* synthetic */ class C0110a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f12405a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.f12409n.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.f12410o.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.f12411p.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.f12407l.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.f12408m.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f12405a = iArr;
                }
            }

            public /* synthetic */ C0109a(M5.g gVar) {
                this();
            }

            public final a a(b bVar) {
                M5.m.e(bVar, "state");
                int i7 = C0110a.f12405a[bVar.ordinal()];
                if (i7 == 1) {
                    return a.ON_DESTROY;
                }
                if (i7 == 2) {
                    return a.ON_STOP;
                }
                if (i7 != 3) {
                    return null;
                }
                return a.ON_PAUSE;
            }

            public final a b(b bVar) {
                M5.m.e(bVar, "state");
                int i7 = C0110a.f12405a[bVar.ordinal()];
                if (i7 == 1) {
                    return a.ON_START;
                }
                if (i7 == 2) {
                    return a.ON_RESUME;
                }
                if (i7 != 5) {
                    return null;
                }
                return a.ON_CREATE;
            }

            public C0109a() {
            }
        }

        /* renamed from: androidx.lifecycle.j$a$b */
        public static final /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12406a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f12406a = iArr;
            }
        }

        static {
            a[] aVarArrA = a();
            $VALUES = aVarArrA;
            $ENTRIES = F5.b.a(aVarArrA);
            Companion = new C0109a(null);
        }

        public a(String str, int i7) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) $VALUES.clone();
        }

        public final b d() {
            switch (b.f12406a[ordinal()]) {
                case 1:
                case 2:
                    return b.f12409n;
                case 3:
                case 4:
                    return b.f12410o;
                case 5:
                    return b.f12411p;
                case 6:
                    return b.f12407l;
                case 7:
                    throw new IllegalArgumentException(this + " has no target state");
                default:
                    throw new C1810f();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: androidx.lifecycle.j$b */
    public static final class b {

        /* renamed from: l, reason: collision with root package name */
        public static final b f12407l = new b("DESTROYED", 0);

        /* renamed from: m, reason: collision with root package name */
        public static final b f12408m = new b("INITIALIZED", 1);

        /* renamed from: n, reason: collision with root package name */
        public static final b f12409n = new b("CREATED", 2);

        /* renamed from: o, reason: collision with root package name */
        public static final b f12410o = new b("STARTED", 3);

        /* renamed from: p, reason: collision with root package name */
        public static final b f12411p = new b("RESUMED", 4);

        /* renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ b[] f12412q;

        /* renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ F5.a f12413r;

        static {
            b[] bVarArrA = a();
            f12412q = bVarArrA;
            f12413r = F5.b.a(bVarArrA);
        }

        public b(String str, int i7) {
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f12407l, f12408m, f12409n, f12410o, f12411p};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f12412q.clone();
        }

        public final boolean d(b bVar) {
            M5.m.e(bVar, "state");
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(InterfaceC0808m interfaceC0808m);

    public abstract b b();

    public abstract void c(InterfaceC0808m interfaceC0808m);
}
