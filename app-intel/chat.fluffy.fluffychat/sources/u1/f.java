package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22757b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22758c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22759d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f22760e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f22757b = str;
        this.f22758c = str2;
        this.f22759d = str3;
        this.f22760e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (Objects.equals(this.f22757b, fVar.f22757b) && Objects.equals(this.f22758c, fVar.f22758c) && Objects.equals(this.f22759d, fVar.f22759d) && Arrays.equals(this.f22760e, fVar.f22760e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22757b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22758c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22759d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f22760e);
    }

    @Override // u1.i
    public String toString() {
        return this.f22766a + ": mimeType=" + this.f22757b + ", filename=" + this.f22758c + ", description=" + this.f22759d;
    }
}
