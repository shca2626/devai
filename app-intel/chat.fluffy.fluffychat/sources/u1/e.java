package u1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22760b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22761c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22762d;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f22760b = str;
        this.f22761c = str2;
        this.f22762d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (Objects.equals(this.f22761c, eVar.f22761c) && Objects.equals(this.f22760b, eVar.f22760b) && Objects.equals(this.f22762d, eVar.f22762d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22760b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22761c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22762d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // u1.i
    public String toString() {
        return this.f22772a + ": language=" + this.f22760b + ", description=" + this.f22761c + ", text=" + this.f22762d;
    }
}
