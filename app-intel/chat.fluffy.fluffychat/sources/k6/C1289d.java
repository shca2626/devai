package k6;

import java.util.concurrent.TimeUnit;

/* renamed from: k6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1289d {

    /* renamed from: n, reason: collision with root package name */
    public static final C1289d f19196n = new a().c().a();

    /* renamed from: o, reason: collision with root package name */
    public static final C1289d f19197o = new a().e().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19198a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19199b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19200c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19201d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19202e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19203f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f19204g;

    /* renamed from: h, reason: collision with root package name */
    public final int f19205h;

    /* renamed from: i, reason: collision with root package name */
    public final int f19206i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f19207j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f19208k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f19209l;

    /* renamed from: m, reason: collision with root package name */
    public String f19210m;

    /* renamed from: k6.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19211a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19212b;

        /* renamed from: c, reason: collision with root package name */
        public int f19213c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f19214d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f19215e = -1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19216f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f19217g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f19218h;

        public C1289d a() {
            return new C1289d(this);
        }

        public a b(int i7, TimeUnit timeUnit) {
            if (i7 >= 0) {
                long seconds = timeUnit.toSeconds(i7);
                this.f19214d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i7);
        }

        public a c() {
            this.f19211a = true;
            return this;
        }

        public a d() {
            this.f19212b = true;
            return this;
        }

        public a e() {
            this.f19216f = true;
            return this;
        }
    }

    public C1289d(boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, int i9, int i10, boolean z12, boolean z13, boolean z14, String str) {
        this.f19198a = z7;
        this.f19199b = z8;
        this.f19200c = i7;
        this.f19201d = i8;
        this.f19202e = z9;
        this.f19203f = z10;
        this.f19204g = z11;
        this.f19205h = i9;
        this.f19206i = i10;
        this.f19207j = z12;
        this.f19208k = z13;
        this.f19209l = z14;
        this.f19210m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k6.C1289d k(k6.r r23) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.C1289d.k(k6.r):k6.d");
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f19198a) {
            sb.append("no-cache, ");
        }
        if (this.f19199b) {
            sb.append("no-store, ");
        }
        if (this.f19200c != -1) {
            sb.append("max-age=");
            sb.append(this.f19200c);
            sb.append(", ");
        }
        if (this.f19201d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f19201d);
            sb.append(", ");
        }
        if (this.f19202e) {
            sb.append("private, ");
        }
        if (this.f19203f) {
            sb.append("public, ");
        }
        if (this.f19204g) {
            sb.append("must-revalidate, ");
        }
        if (this.f19205h != -1) {
            sb.append("max-stale=");
            sb.append(this.f19205h);
            sb.append(", ");
        }
        if (this.f19206i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f19206i);
            sb.append(", ");
        }
        if (this.f19207j) {
            sb.append("only-if-cached, ");
        }
        if (this.f19208k) {
            sb.append("no-transform, ");
        }
        if (this.f19209l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean b() {
        return this.f19202e;
    }

    public boolean c() {
        return this.f19203f;
    }

    public int d() {
        return this.f19200c;
    }

    public int e() {
        return this.f19205h;
    }

    public int f() {
        return this.f19206i;
    }

    public boolean g() {
        return this.f19204g;
    }

    public boolean h() {
        return this.f19198a;
    }

    public boolean i() {
        return this.f19199b;
    }

    public boolean j() {
        return this.f19207j;
    }

    public String toString() {
        String str = this.f19210m;
        if (str != null) {
            return str;
        }
        String strA = a();
        this.f19210m = strA;
        return strA;
    }

    public C1289d(a aVar) {
        this.f19198a = aVar.f19211a;
        this.f19199b = aVar.f19212b;
        this.f19200c = aVar.f19213c;
        this.f19201d = -1;
        this.f19202e = false;
        this.f19203f = false;
        this.f19204g = false;
        this.f19205h = aVar.f19214d;
        this.f19206i = aVar.f19215e;
        this.f19207j = aVar.f19216f;
        this.f19208k = aVar.f19217g;
        this.f19209l = aVar.f19218h;
    }
}
