package r1;

import B0.s;
import B0.y;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: r1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1558a implements y.a {

    /* renamed from: g, reason: collision with root package name */
    public static final s f22107g = new s.b().y0("application/id3").P();

    /* renamed from: h, reason: collision with root package name */
    public static final s f22108h = new s.b().y0("application/x-scte35").P();

    /* renamed from: a, reason: collision with root package name */
    public final String f22109a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22110b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22111c;

    /* renamed from: d, reason: collision with root package name */
    public final long f22112d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f22113e;

    /* renamed from: f, reason: collision with root package name */
    public int f22114f;

    public C1558a(String str, String str2, long j7, long j8, byte[] bArr) {
        this.f22109a = str;
        this.f22110b = str2;
        this.f22111c = j7;
        this.f22112d = j8;
        this.f22113e = bArr;
    }

    @Override // B0.y.a
    public s b() {
        String str = this.f22109a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f22108h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f22107g;
            default:
                return null;
        }
    }

    @Override // B0.y.a
    public byte[] c() {
        if (b() != null) {
            return this.f22113e;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1558a.class == obj.getClass()) {
            C1558a c1558a = (C1558a) obj;
            if (this.f22111c == c1558a.f22111c && this.f22112d == c1558a.f22112d && Objects.equals(this.f22109a, c1558a.f22109a) && Objects.equals(this.f22110b, c1558a.f22110b) && Arrays.equals(this.f22113e, c1558a.f22113e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f22114f == 0) {
            String str = this.f22109a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f22110b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j7 = this.f22111c;
            int i7 = (((iHashCode + iHashCode2) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j8 = this.f22112d;
            this.f22114f = ((i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + Arrays.hashCode(this.f22113e);
        }
        return this.f22114f;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f22109a + ", id=" + this.f22112d + ", durationMs=" + this.f22111c + ", value=" + this.f22110b;
    }
}
