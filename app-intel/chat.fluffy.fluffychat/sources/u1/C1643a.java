package u1;

import B0.x;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1643a extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22738b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22739c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22740d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f22741e;

    public C1643a(String str, String str2, int i7, byte[] bArr) {
        super("APIC");
        this.f22738b = str;
        this.f22739c = str2;
        this.f22740d = i7;
        this.f22741e = bArr;
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        bVar.L(this.f22741e, this.f22740d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1643a.class == obj.getClass()) {
            C1643a c1643a = (C1643a) obj;
            if (this.f22740d == c1643a.f22740d && Objects.equals(this.f22738b, c1643a.f22738b) && Objects.equals(this.f22739c, c1643a.f22739c) && Arrays.equals(this.f22741e, c1643a.f22741e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (527 + this.f22740d) * 31;
        String str = this.f22738b;
        int iHashCode = (i7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22739c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f22741e);
    }

    @Override // u1.i
    public String toString() {
        return this.f22766a + ": mimeType=" + this.f22738b + ", description=" + this.f22739c;
    }
}
