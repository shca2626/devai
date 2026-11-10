package u1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22754b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22755c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22756d;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f22754b = str;
        this.f22755c = str2;
        this.f22756d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (Objects.equals(this.f22755c, eVar.f22755c) && Objects.equals(this.f22754b, eVar.f22754b) && Objects.equals(this.f22756d, eVar.f22756d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22754b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22755c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22756d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // u1.i
    public String toString() {
        return this.f22766a + ": language=" + this.f22754b + ", description=" + this.f22755c + ", text=" + this.f22756d;
    }
}
