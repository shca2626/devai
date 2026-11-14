package u1;

import B0.x;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1642a extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22744b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22745c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22746d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f22747e;

    public C1642a(String str, String str2, int i7, byte[] bArr) {
        super("APIC");
        this.f22744b = str;
        this.f22745c = str2;
        this.f22746d = i7;
        this.f22747e = bArr;
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        bVar.L(this.f22747e, this.f22746d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1642a.class == obj.getClass()) {
            C1642a c1642a = (C1642a) obj;
            if (this.f22746d == c1642a.f22746d && Objects.equals(this.f22744b, c1642a.f22744b) && Objects.equals(this.f22745c, c1642a.f22745c) && Arrays.equals(this.f22747e, c1642a.f22747e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (527 + this.f22746d) * 31;
        String str = this.f22744b;
        int iHashCode = (i7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22745c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f22747e);
    }

    @Override // u1.i
    public String toString() {
        return this.f22772a + ": mimeType=" + this.f22744b + ", description=" + this.f22745c;
    }
}
