package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class f extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22763b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22764c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22765d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f22766e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f22763b = str;
        this.f22764c = str2;
        this.f22765d = str3;
        this.f22766e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (Objects.equals(this.f22763b, fVar.f22763b) && Objects.equals(this.f22764c, fVar.f22764c) && Objects.equals(this.f22765d, fVar.f22765d) && Arrays.equals(this.f22766e, fVar.f22766e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22763b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22764c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22765d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f22766e);
    }

    @Override // u1.i
    public String toString() {
        return this.f22772a + ": mimeType=" + this.f22763b + ", filename=" + this.f22764c + ", description=" + this.f22765d;
    }
}
