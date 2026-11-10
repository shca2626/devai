package B0;

import E0.U;
import java.util.Objects;

/* renamed from: B0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0312n {

    /* renamed from: e, reason: collision with root package name */
    public static final C0312n f665e = new b(0).e();

    /* renamed from: f, reason: collision with root package name */
    public static final String f666f = U.A0(0);

    /* renamed from: g, reason: collision with root package name */
    public static final String f667g = U.A0(1);

    /* renamed from: h, reason: collision with root package name */
    public static final String f668h = U.A0(2);

    /* renamed from: i, reason: collision with root package name */
    public static final String f669i = U.A0(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f670a;

    /* renamed from: b, reason: collision with root package name */
    public final int f671b;

    /* renamed from: c, reason: collision with root package name */
    public final int f672c;

    /* renamed from: d, reason: collision with root package name */
    public final String f673d;

    /* renamed from: B0.n$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f674a;

        /* renamed from: b, reason: collision with root package name */
        public int f675b;

        /* renamed from: c, reason: collision with root package name */
        public int f676c;

        /* renamed from: d, reason: collision with root package name */
        public String f677d;

        public b(int i7) {
            this.f674a = i7;
        }

        public C0312n e() {
            j3.o.d(this.f675b <= this.f676c);
            return new C0312n(this);
        }

        public b f(int i7) {
            this.f676c = i7;
            return this;
        }

        public b g(int i7) {
            this.f675b = i7;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0312n)) {
            return false;
        }
        C0312n c0312n = (C0312n) obj;
        return this.f670a == c0312n.f670a && this.f671b == c0312n.f671b && this.f672c == c0312n.f672c && Objects.equals(this.f673d, c0312n.f673d);
    }

    public int hashCode() {
        int i7 = (((((527 + this.f670a) * 31) + this.f671b) * 31) + this.f672c) * 31;
        String str = this.f673d;
        return i7 + (str == null ? 0 : str.hashCode());
    }

    public C0312n(b bVar) {
        this.f670a = bVar.f674a;
        this.f671b = bVar.f675b;
        this.f672c = bVar.f676c;
        this.f673d = bVar.f677d;
    }
}
