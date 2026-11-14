package z4;

import java.util.Map;

/* renamed from: z4.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1859p {

    /* renamed from: e, reason: collision with root package name */
    public static final a f24178e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f24179a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f24180b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f24181c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f24182d;

    /* renamed from: z4.p$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1859p a(Map map) {
            boolean z7 = map != null;
            boolean zA = M5.m.a(map != null ? map.get("grant") : null, "lifetime");
            boolean zA2 = M5.m.a(map != null ? map.get("access") : null, "readWrite");
            Object obj = map != null ? map.get("autoPersist") : null;
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            return new C1859p(z7, zA, zA2, bool != null ? bool.booleanValue() : true);
        }

        public a() {
        }
    }

    public C1859p(boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f24179a = z7;
        this.f24180b = z8;
        this.f24181c = z9;
        this.f24182d = z10;
    }

    public final boolean a() {
        return this.f24180b && this.f24182d;
    }

    public final boolean b() {
        return this.f24181c;
    }

    public final boolean c() {
        return this.f24179a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1859p)) {
            return false;
        }
        C1859p c1859p = (C1859p) obj;
        return this.f24179a == c1859p.f24179a && this.f24180b == c1859p.f24180b && this.f24181c == c1859p.f24181c && this.f24182d == c1859p.f24182d;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f24179a) * 31) + Boolean.hashCode(this.f24180b)) * 31) + Boolean.hashCode(this.f24181c)) * 31) + Boolean.hashCode(this.f24182d);
    }

    public String toString() {
        return "SafOptions(requested=" + this.f24179a + ", lifetimeGrant=" + this.f24180b + ", readWrite=" + this.f24181c + ", autoPersist=" + this.f24182d + ")";
    }
}
