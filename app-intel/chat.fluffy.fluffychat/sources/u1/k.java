package u1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22768b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22769c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22770d;

    public k(String str, String str2, String str3) {
        super("----");
        this.f22768b = str;
        this.f22769c = str2;
        this.f22770d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (Objects.equals(this.f22769c, kVar.f22769c) && Objects.equals(this.f22768b, kVar.f22768b) && Objects.equals(this.f22770d, kVar.f22770d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22768b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22769c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22770d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // u1.i
    public String toString() {
        return this.f22766a + ": domain=" + this.f22768b + ", description=" + this.f22769c;
    }
}
