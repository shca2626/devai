package I0;

import java.util.Objects;

/* renamed from: I0.d1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0362d1 {

    /* renamed from: a, reason: collision with root package name */
    public final long f3950a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3951b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3952c;

    /* renamed from: I0.d1$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public long f3953a;

        /* renamed from: b, reason: collision with root package name */
        public float f3954b;

        /* renamed from: c, reason: collision with root package name */
        public long f3955c;

        public C0362d1 d() {
            return new C0362d1(this);
        }

        public b e(long j7) {
            j3.o.d(j7 >= 0 || j7 == -9223372036854775807L);
            this.f3955c = j7;
            return this;
        }

        public b f(long j7) {
            this.f3953a = j7;
            return this;
        }

        public b g(float f7) {
            j3.o.d(f7 > 0.0f || f7 == -3.4028235E38f);
            this.f3954b = f7;
            return this;
        }

        public b() {
            this.f3953a = -9223372036854775807L;
            this.f3954b = -3.4028235E38f;
            this.f3955c = -9223372036854775807L;
        }

        public b(C0362d1 c0362d1) {
            this.f3953a = c0362d1.f3950a;
            this.f3954b = c0362d1.f3951b;
            this.f3955c = c0362d1.f3952c;
        }
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0362d1)) {
            return false;
        }
        C0362d1 c0362d1 = (C0362d1) obj;
        return this.f3950a == c0362d1.f3950a && this.f3951b == c0362d1.f3951b && this.f3952c == c0362d1.f3952c;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f3950a), Float.valueOf(this.f3951b), Long.valueOf(this.f3952c));
    }

    public C0362d1(b bVar) {
        this.f3950a = bVar.f3953a;
        this.f3951b = bVar.f3954b;
        this.f3952c = bVar.f3955c;
    }
}
