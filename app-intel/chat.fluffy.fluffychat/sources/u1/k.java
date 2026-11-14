package u1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22774b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22775c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22776d;

    public k(String str, String str2, String str3) {
        super("----");
        this.f22774b = str;
        this.f22775c = str2;
        this.f22776d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (Objects.equals(this.f22775c, kVar.f22775c) && Objects.equals(this.f22774b, kVar.f22774b) && Objects.equals(this.f22776d, kVar.f22776d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22774b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22775c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22776d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // u1.i
    public String toString() {
        return this.f22772a + ": domain=" + this.f22774b + ", description=" + this.f22775c;
    }
}
