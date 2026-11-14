package o0;

import o0.AbstractC1389d;

/* renamed from: o0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1386a extends AbstractC1389d {

    /* renamed from: a, reason: collision with root package name */
    public final String f20312a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20313b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20314c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20315d;

    /* renamed from: o0.a$b */
    public static final class b extends AbstractC1389d.a {

        /* renamed from: a, reason: collision with root package name */
        public String f20316a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f20317b;

        /* renamed from: c, reason: collision with root package name */
        public String f20318c;

        /* renamed from: d, reason: collision with root package name */
        public String f20319d;

        @Override // o0.AbstractC1389d.a
        public AbstractC1389d a() {
            String str = "";
            if (this.f20316a == null) {
                str = " key";
            }
            if (this.f20317b == null) {
                str = str + " severity";
            }
            if (str.isEmpty()) {
                return new C1386a(this.f20316a, this.f20317b.intValue(), this.f20318c, this.f20319d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // o0.AbstractC1389d.a
        public AbstractC1389d.a c(String str) {
            this.f20319d = str;
            return this;
        }

        @Override // o0.AbstractC1389d.a
        public AbstractC1389d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f20316a = str;
            return this;
        }

        @Override // o0.AbstractC1389d.a
        public AbstractC1389d.a e(String str) {
            this.f20318c = str;
            return this;
        }

        @Override // o0.AbstractC1389d.a
        public AbstractC1389d.a f(int i7) {
            this.f20317b = Integer.valueOf(i7);
            return this;
        }
    }

    @Override // o0.AbstractC1389d
    public String b() {
        return this.f20315d;
    }

    @Override // o0.AbstractC1389d
    public String c() {
        return this.f20312a;
    }

    @Override // o0.AbstractC1389d
    public String d() {
        return this.f20314c;
    }

    @Override // o0.AbstractC1389d
    public int e() {
        return this.f20313b;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1389d) {
            AbstractC1389d abstractC1389d = (AbstractC1389d) obj;
            if (this.f20312a.equals(abstractC1389d.c()) && this.f20313b == abstractC1389d.e() && ((str = this.f20314c) != null ? str.equals(abstractC1389d.d()) : abstractC1389d.d() == null) && ((str2 = this.f20315d) != null ? str2.equals(abstractC1389d.b()) : abstractC1389d.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f20312a.hashCode() ^ 1000003) * 1000003) ^ this.f20313b) * 1000003;
        String str = this.f20314c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f20315d;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "KeyedAppState{key=" + this.f20312a + ", severity=" + this.f20313b + ", message=" + this.f20314c + ", data=" + this.f20315d + "}";
    }

    public C1386a(String str, int i7, String str2, String str3) {
        this.f20312a = str;
        this.f20313b = i7;
        this.f20314c = str2;
        this.f20315d = str3;
    }
}
