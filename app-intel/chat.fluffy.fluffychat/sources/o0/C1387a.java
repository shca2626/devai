package o0;

import o0.AbstractC1390d;

/* renamed from: o0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1387a extends AbstractC1390d {

    /* renamed from: a, reason: collision with root package name */
    public final String f20313a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20314b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20315c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20316d;

    /* renamed from: o0.a$b */
    public static final class b extends AbstractC1390d.a {

        /* renamed from: a, reason: collision with root package name */
        public String f20317a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f20318b;

        /* renamed from: c, reason: collision with root package name */
        public String f20319c;

        /* renamed from: d, reason: collision with root package name */
        public String f20320d;

        @Override // o0.AbstractC1390d.a
        public AbstractC1390d a() {
            String str = "";
            if (this.f20317a == null) {
                str = " key";
            }
            if (this.f20318b == null) {
                str = str + " severity";
            }
            if (str.isEmpty()) {
                return new C1387a(this.f20317a, this.f20318b.intValue(), this.f20319c, this.f20320d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // o0.AbstractC1390d.a
        public AbstractC1390d.a c(String str) {
            this.f20320d = str;
            return this;
        }

        @Override // o0.AbstractC1390d.a
        public AbstractC1390d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f20317a = str;
            return this;
        }

        @Override // o0.AbstractC1390d.a
        public AbstractC1390d.a e(String str) {
            this.f20319c = str;
            return this;
        }

        @Override // o0.AbstractC1390d.a
        public AbstractC1390d.a f(int i7) {
            this.f20318b = Integer.valueOf(i7);
            return this;
        }
    }

    @Override // o0.AbstractC1390d
    public String b() {
        return this.f20316d;
    }

    @Override // o0.AbstractC1390d
    public String c() {
        return this.f20313a;
    }

    @Override // o0.AbstractC1390d
    public String d() {
        return this.f20315c;
    }

    @Override // o0.AbstractC1390d
    public int e() {
        return this.f20314b;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1390d) {
            AbstractC1390d abstractC1390d = (AbstractC1390d) obj;
            if (this.f20313a.equals(abstractC1390d.c()) && this.f20314b == abstractC1390d.e() && ((str = this.f20315c) != null ? str.equals(abstractC1390d.d()) : abstractC1390d.d() == null) && ((str2 = this.f20316d) != null ? str2.equals(abstractC1390d.b()) : abstractC1390d.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f20313a.hashCode() ^ 1000003) * 1000003) ^ this.f20314b) * 1000003;
        String str = this.f20315c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f20316d;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "KeyedAppState{key=" + this.f20313a + ", severity=" + this.f20314b + ", message=" + this.f20315c + ", data=" + this.f20316d + "}";
    }

    public C1387a(String str, int i7, String str2, String str3) {
        this.f20313a = str;
        this.f20314b = i7;
        this.f20315c = str2;
        this.f20316d = str3;
    }
}
