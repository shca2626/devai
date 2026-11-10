package M0;

import java.util.Objects;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f5561a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5562b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5563c;

    public e(String str, String str2, String str3) {
        this.f5561a = str;
        this.f5562b = str2;
        this.f5563c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (Objects.equals(this.f5561a, eVar.f5561a) && Objects.equals(this.f5562b, eVar.f5562b) && Objects.equals(this.f5563c, eVar.f5563c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f5561a.hashCode() * 31;
        String str = this.f5562b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5563c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
