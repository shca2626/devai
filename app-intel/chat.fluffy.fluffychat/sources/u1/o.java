package u1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class o extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22781b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22782c;

    public o(String str, String str2, String str3) {
        super(str);
        this.f22781b = str2;
        this.f22782c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (this.f22766a.equals(oVar.f22766a) && Objects.equals(this.f22781b, oVar.f22781b) && Objects.equals(this.f22782c, oVar.f22782c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (527 + this.f22766a.hashCode()) * 31;
        String str = this.f22781b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22782c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // u1.i
    public String toString() {
        return this.f22766a + ": url=" + this.f22782c;
    }
}
