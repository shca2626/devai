package U0;

import E0.E;
import E0.U;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f8325l = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final byte f8326a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8327b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8328c;

    /* renamed from: d, reason: collision with root package name */
    public final byte f8329d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8330e;

    /* renamed from: f, reason: collision with root package name */
    public final byte f8331f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8332g;

    /* renamed from: h, reason: collision with root package name */
    public final long f8333h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8334i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f8335j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f8336k;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8337a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8338b;

        /* renamed from: c, reason: collision with root package name */
        public byte f8339c;

        /* renamed from: d, reason: collision with root package name */
        public int f8340d;

        /* renamed from: e, reason: collision with root package name */
        public long f8341e;

        /* renamed from: f, reason: collision with root package name */
        public int f8342f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f8343g = d.f8325l;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f8344h = d.f8325l;

        public d i() {
            return new d(this);
        }

        public b j(byte[] bArr) {
            j3.o.q(bArr);
            this.f8343g = bArr;
            return this;
        }

        public b k(boolean z7) {
            this.f8338b = z7;
            return this;
        }

        public b l(boolean z7) {
            this.f8337a = z7;
            return this;
        }

        public b m(byte[] bArr) {
            j3.o.q(bArr);
            this.f8344h = bArr;
            return this;
        }

        public b n(byte b7) {
            this.f8339c = b7;
            return this;
        }

        public b o(int i7) {
            j3.o.d(i7 >= 0 && i7 <= 65535);
            this.f8340d = i7 & 65535;
            return this;
        }

        public b p(int i7) {
            this.f8342f = i7;
            return this;
        }

        public b q(long j7) {
            this.f8341e = j7;
            return this;
        }
    }

    public static int b(int i7) {
        return m3.d.f(i7 + 1, 65536);
    }

    public static int c(int i7) {
        return m3.d.f(i7 - 1, 65536);
    }

    public static d d(E e7) {
        byte[] bArr;
        if (e7.a() < 12) {
            return null;
        }
        int iQ = e7.Q();
        byte b7 = (byte) (iQ >> 6);
        boolean z7 = ((iQ >> 5) & 1) == 1;
        byte b8 = (byte) (iQ & 15);
        boolean z8 = ((iQ >> 4) & 1) == 1;
        if (b7 != 2) {
            return null;
        }
        int iQ2 = e7.Q();
        boolean z9 = ((iQ2 >> 7) & 1) == 1;
        byte b9 = (byte) (iQ2 & 127);
        int iY = e7.Y();
        long jS = e7.S();
        int iZ = e7.z();
        if (b8 > 0) {
            bArr = new byte[b8 * 4];
            for (int i7 = 0; i7 < b8; i7++) {
                e7.u(bArr, i7 * 4, 4);
            }
        } else {
            bArr = f8325l;
        }
        if (z8) {
            e7.g0(2);
            short sM = e7.M();
            if (sM != 0) {
                e7.g0(sM * 4);
            }
        }
        byte[] bArr2 = new byte[e7.a()];
        e7.u(bArr2, 0, e7.a());
        return new b().l(z7).k(z9).n(b9).o(iY).q(jS).p(iZ).j(bArr).m(bArr2).i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f8331f == dVar.f8331f && this.f8332g == dVar.f8332g && this.f8330e == dVar.f8330e && this.f8333h == dVar.f8333h && this.f8334i == dVar.f8334i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (((((527 + this.f8331f) * 31) + this.f8332g) * 31) + (this.f8330e ? 1 : 0)) * 31;
        long j7 = this.f8333h;
        return ((i7 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f8334i;
    }

    public String toString() {
        return U.G("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f8331f), Integer.valueOf(this.f8332g), Long.valueOf(this.f8333h), Integer.valueOf(this.f8334i), Boolean.valueOf(this.f8330e));
    }

    public d(b bVar) {
        this.f8326a = (byte) 2;
        this.f8327b = bVar.f8337a;
        this.f8328c = false;
        this.f8330e = bVar.f8338b;
        this.f8331f = bVar.f8339c;
        this.f8332g = bVar.f8340d;
        this.f8333h = bVar.f8341e;
        this.f8334i = bVar.f8342f;
        byte[] bArr = bVar.f8343g;
        this.f8335j = bArr;
        this.f8329d = (byte) (bArr.length / 4);
        this.f8336k = bVar.f8344h;
    }
}
