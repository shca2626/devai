package u1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class o extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22787b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22788c;

    public o(String str, String str2, String str3) {
        super(str);
        this.f22787b = str2;
        this.f22788c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (this.f22772a.equals(oVar.f22772a) && Objects.equals(this.f22787b, oVar.f22787b) && Objects.equals(this.f22788c, oVar.f22788c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (527 + this.f22772a.hashCode()) * 31;
        String str = this.f22787b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22788c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // u1.i
    public String toString() {
        return this.f22772a + ": url=" + this.f22788c;
    }
}
