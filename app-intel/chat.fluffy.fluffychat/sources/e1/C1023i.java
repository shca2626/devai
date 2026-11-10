package e1;

import java.util.Arrays;

/* renamed from: e1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1023i {

    /* renamed from: c, reason: collision with root package name */
    public boolean f15388c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15389d;

    /* renamed from: f, reason: collision with root package name */
    public int f15391f;

    /* renamed from: a, reason: collision with root package name */
    public a f15386a = new a();

    /* renamed from: b, reason: collision with root package name */
    public a f15387b = new a();

    /* renamed from: e, reason: collision with root package name */
    public long f15390e = -9223372036854775807L;

    /* renamed from: e1.i$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f15392a;

        /* renamed from: b, reason: collision with root package name */
        public long f15393b;

        /* renamed from: c, reason: collision with root package name */
        public long f15394c;

        /* renamed from: d, reason: collision with root package name */
        public long f15395d;

        /* renamed from: e, reason: collision with root package name */
        public long f15396e;

        /* renamed from: f, reason: collision with root package name */
        public long f15397f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean[] f15398g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        public int f15399h;

        public static int c(long j7) {
            return (int) (j7 % 15);
        }

        public long a() {
            long j7 = this.f15396e;
            if (j7 == 0) {
                return 0L;
            }
            return this.f15397f / j7;
        }

        public long b() {
            return this.f15397f;
        }

        public boolean d() {
            long j7 = this.f15395d;
            if (j7 == 0) {
                return false;
            }
            return this.f15398g[c(j7 - 1)];
        }

        public boolean e() {
            return this.f15395d > 15 && this.f15399h == 0;
        }

        public void f(long j7) {
            long j8 = this.f15395d;
            if (j8 == 0) {
                this.f15392a = j7;
            } else if (j8 == 1) {
                long j9 = j7 - this.f15392a;
                this.f15393b = j9;
                this.f15397f = j9;
                this.f15396e = 1L;
            } else {
                long j10 = j7 - this.f15394c;
                int iC = c(j8);
                if (Math.abs(j10 - this.f15393b) <= 1000000) {
                    this.f15396e++;
                    this.f15397f += j10;
                    boolean[] zArr = this.f15398g;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f15399h--;
                    }
                } else {
                    boolean[] zArr2 = this.f15398g;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f15399h++;
                    }
                }
            }
            this.f15395d++;
            this.f15394c = j7;
        }

        public void g() {
            this.f15395d = 0L;
            this.f15396e = 0L;
            this.f15397f = 0L;
            this.f15399h = 0;
            Arrays.fill(this.f15398g, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f15386a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f15386a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f15391f;
    }

    public long d() {
        if (e()) {
            return this.f15386a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f15386a.e();
    }

    public void f(long j7) {
        this.f15386a.f(j7);
        if (this.f15386a.e() && !this.f15389d) {
            this.f15388c = false;
        } else if (this.f15390e != -9223372036854775807L) {
            if (!this.f15388c || this.f15387b.d()) {
                this.f15387b.g();
                this.f15387b.f(this.f15390e);
            }
            this.f15388c = true;
            this.f15387b.f(j7);
        }
        if (this.f15388c && this.f15387b.e()) {
            a aVar = this.f15386a;
            this.f15386a = this.f15387b;
            this.f15387b = aVar;
            this.f15388c = false;
            this.f15389d = false;
        }
        this.f15390e = j7;
        this.f15391f = this.f15386a.e() ? 0 : this.f15391f + 1;
    }

    public void g() {
        this.f15386a.g();
        this.f15387b.g();
        this.f15388c = false;
        this.f15390e = -9223372036854775807L;
        this.f15391f = 0;
    }
}
