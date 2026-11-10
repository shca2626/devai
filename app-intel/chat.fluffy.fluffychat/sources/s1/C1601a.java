package s1;

import B0.x;
import B0.y;
import B0.z;
import E0.E;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* renamed from: s1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1601a implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f22375a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22376b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22377c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22378d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22379e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22380f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22381g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f22382h;

    public C1601a(int i7, String str, String str2, int i8, int i9, int i10, int i11, byte[] bArr) {
        this.f22375a = i7;
        this.f22376b = str;
        this.f22377c = str2;
        this.f22378d = i8;
        this.f22379e = i9;
        this.f22380f = i10;
        this.f22381g = i11;
        this.f22382h = bArr;
    }

    public static C1601a d(E e7) {
        int iZ = e7.z();
        String strU = z.u(e7.O(e7.z(), StandardCharsets.US_ASCII));
        String strN = e7.N(e7.z());
        int iZ2 = e7.z();
        int iZ3 = e7.z();
        int iZ4 = e7.z();
        int iZ5 = e7.z();
        int iZ6 = e7.z();
        byte[] bArr = new byte[iZ6];
        e7.u(bArr, 0, iZ6);
        return new C1601a(iZ, strU, strN, iZ2, iZ3, iZ4, iZ5, bArr);
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        bVar.L(this.f22382h, this.f22375a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1601a.class == obj.getClass()) {
            C1601a c1601a = (C1601a) obj;
            if (this.f22375a == c1601a.f22375a && this.f22376b.equals(c1601a.f22376b) && this.f22377c.equals(c1601a.f22377c) && this.f22378d == c1601a.f22378d && this.f22379e == c1601a.f22379e && this.f22380f == c1601a.f22380f && this.f22381g == c1601a.f22381g && Arrays.equals(this.f22382h, c1601a.f22382h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f22375a) * 31) + this.f22376b.hashCode()) * 31) + this.f22377c.hashCode()) * 31) + this.f22378d) * 31) + this.f22379e) * 31) + this.f22380f) * 31) + this.f22381g) * 31) + Arrays.hashCode(this.f22382h);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f22376b + ", description=" + this.f22377c;
    }
}
