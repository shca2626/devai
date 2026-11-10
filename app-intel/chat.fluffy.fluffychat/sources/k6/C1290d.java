package k6;

import java.util.concurrent.TimeUnit;

/* renamed from: k6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1290d {

    /* renamed from: n, reason: collision with root package name */
    public static final C1290d f19197n = new a().c().a();

    /* renamed from: o, reason: collision with root package name */
    public static final C1290d f19198o = new a().e().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19199a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19200b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19201c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19202d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19203e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19204f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f19205g;

    /* renamed from: h, reason: collision with root package name */
    public final int f19206h;

    /* renamed from: i, reason: collision with root package name */
    public final int f19207i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f19208j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f19209k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f19210l;

    /* renamed from: m, reason: collision with root package name */
    public String f19211m;

    /* renamed from: k6.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19212a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19213b;

        /* renamed from: c, reason: collision with root package name */
        public int f19214c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f19215d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f19216e = -1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19217f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f19218g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f19219h;

        public C1290d a() {
            return new C1290d(this);
        }

        public a b(int i7, TimeUnit timeUnit) {
            if (i7 >= 0) {
                long seconds = timeUnit.toSeconds(i7);
                this.f19215d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i7);
        }

        public a c() {
            this.f19212a = true;
            return this;
        }

        public a d() {
            this.f19213b = true;
            return this;
        }

        public a e() {
            this.f19217f = true;
            return this;
        }
    }

    public C1290d(boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, int i9, int i10, boolean z12, boolean z13, boolean z14, String str) {
        this.f19199a = z7;
        this.f19200b = z8;
        this.f19201c = i7;
        this.f19202d = i8;
        this.f19203e = z9;
        this.f19204f = z10;
        this.f19205g = z11;
        this.f19206h = i9;
        this.f19207i = i10;
        this.f19208j = z12;
        this.f19209k = z13;
        this.f19210l = z14;
        this.f19211m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k6.C1290d k(k6.r r23) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.C1290d.k(k6.r):k6.d");
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f19199a) {
            sb.append("no-cache, ");
        }
        if (this.f19200b) {
            sb.append("no-store, ");
        }
        if (this.f19201c != -1) {
            sb.append("max-age=");
            sb.append(this.f19201c);
            sb.append(", ");
        }
        if (this.f19202d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f19202d);
            sb.append(", ");
        }
        if (this.f19203e) {
            sb.append("private, ");
        }
        if (this.f19204f) {
            sb.append("public, ");
        }
        if (this.f19205g) {
            sb.append("must-revalidate, ");
        }
        if (this.f19206h != -1) {
            sb.append("max-stale=");
            sb.append(this.f19206h);
            sb.append(", ");
        }
        if (this.f19207i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f19207i);
            sb.append(", ");
        }
        if (this.f19208j) {
            sb.append("only-if-cached, ");
        }
        if (this.f19209k) {
            sb.append("no-transform, ");
        }
        if (this.f19210l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean b() {
        return this.f19203e;
    }

    public boolean c() {
        return this.f19204f;
    }

    public int d() {
        return this.f19201c;
    }

    public int e() {
        return this.f19206h;
    }

    public int f() {
        return this.f19207i;
    }

    public boolean g() {
        return this.f19205g;
    }

    public boolean h() {
        return this.f19199a;
    }

    public boolean i() {
        return this.f19200b;
    }

    public boolean j() {
        return this.f19208j;
    }

    public String toString() {
        String str = this.f19211m;
        if (str != null) {
            return str;
        }
        String strA = a();
        this.f19211m = strA;
        return strA;
    }

    public C1290d(a aVar) {
        this.f19199a = aVar.f19212a;
        this.f19200b = aVar.f19213b;
        this.f19201c = aVar.f19214c;
        this.f19202d = -1;
        this.f19203e = false;
        this.f19204f = false;
        this.f19205g = false;
        this.f19206h = aVar.f19215d;
        this.f19207i = aVar.f19216e;
        this.f19208j = aVar.f19217f;
        this.f19209k = aVar.f19218g;
        this.f19210l = aVar.f19219h;
    }
}
