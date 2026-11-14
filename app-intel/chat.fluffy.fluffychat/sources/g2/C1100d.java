package g2;

import android.graphics.Rect;
import d2.C0979b;
import g2.InterfaceC1099c;

/* renamed from: g2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1100d implements InterfaceC1099c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f16176d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final C0979b f16177a;

    /* renamed from: b, reason: collision with root package name */
    public final b f16178b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1099c.b f16179c;

    /* renamed from: g2.d$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(C0979b c0979b) {
            M5.m.e(c0979b, "bounds");
            if (c0979b.d() == 0 && c0979b.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero");
            }
            if (c0979b.b() != 0 && c0979b.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
            }
        }

        public a() {
        }
    }

    /* renamed from: g2.d$b */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final a f16180b = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final b f16181c = new b("FOLD");

        /* renamed from: d, reason: collision with root package name */
        public static final b f16182d = new b("HINGE");

        /* renamed from: a, reason: collision with root package name */
        public final String f16183a;

        /* renamed from: g2.d$b$a */
        public static final class a {
            public /* synthetic */ a(M5.g gVar) {
                this();
            }

            public final b a() {
                return b.f16181c;
            }

            public final b b() {
                return b.f16182d;
            }

            public a() {
            }
        }

        public b(String str) {
            this.f16183a = str;
        }

        public String toString() {
            return this.f16183a;
        }
    }

    public C1100d(C0979b c0979b, b bVar, InterfaceC1099c.b bVar2) {
        M5.m.e(c0979b, "featureBounds");
        M5.m.e(bVar, "type");
        M5.m.e(bVar2, "state");
        this.f16177a = c0979b;
        this.f16178b = bVar;
        this.f16179c = bVar2;
        f16176d.a(c0979b);
    }

    @Override // g2.InterfaceC1099c
    public InterfaceC1099c.a a() {
        return (this.f16177a.d() == 0 || this.f16177a.a() == 0) ? InterfaceC1099c.a.f16169c : InterfaceC1099c.a.f16170d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!M5.m.a(C1100d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        M5.m.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        C1100d c1100d = (C1100d) obj;
        return M5.m.a(this.f16177a, c1100d.f16177a) && M5.m.a(this.f16178b, c1100d.f16178b) && M5.m.a(getState(), c1100d.getState());
    }

    @Override // g2.InterfaceC1097a
    public Rect getBounds() {
        return this.f16177a.f();
    }

    @Override // g2.InterfaceC1099c
    public InterfaceC1099c.b getState() {
        return this.f16179c;
    }

    public int hashCode() {
        return (((this.f16177a.hashCode() * 31) + this.f16178b.hashCode()) * 31) + getState().hashCode();
    }

    public String toString() {
        return C1100d.class.getSimpleName() + " { " + this.f16177a + ", type=" + this.f16178b + ", state=" + getState() + " }";
    }
}
