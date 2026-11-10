package r1;

import B0.s;
import B0.y;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: r1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1559a implements y.a {

    /* renamed from: g, reason: collision with root package name */
    public static final s f22101g = new s.b().y0("application/id3").P();

    /* renamed from: h, reason: collision with root package name */
    public static final s f22102h = new s.b().y0("application/x-scte35").P();

    /* renamed from: a, reason: collision with root package name */
    public final String f22103a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22104b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22105c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22106d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f22107e;

    /* renamed from: f, reason: collision with root package name */
    public int f22108f;

    public C1559a(String str, String str2, long j7, long j8, byte[] bArr) {
        this.f22103a = str;
        this.f22104b = str2;
        this.f22105c = j7;
        this.f22106d = j8;
        this.f22107e = bArr;
    }

    @Override // B0.y.a
    public s b() {
        String str = this.f22103a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f22102h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f22101g;
            default:
                return null;
        }
    }

    @Override // B0.y.a
    public byte[] c() {
        if (b() != null) {
            return this.f22107e;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1559a.class == obj.getClass()) {
            C1559a c1559a = (C1559a) obj;
            if (this.f22105c == c1559a.f22105c && this.f22106d == c1559a.f22106d && Objects.equals(this.f22103a, c1559a.f22103a) && Objects.equals(this.f22104b, c1559a.f22104b) && Arrays.equals(this.f22107e, c1559a.f22107e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f22108f == 0) {
            String str = this.f22103a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f22104b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j7 = this.f22105c;
            int i7 = (((iHashCode + iHashCode2) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j8 = this.f22106d;
            this.f22108f = ((i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + Arrays.hashCode(this.f22107e);
        }
        return this.f22108f;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f22103a + ", id=" + this.f22106d + ", durationMs=" + this.f22105c + ", value=" + this.f22104b;
    }
}
