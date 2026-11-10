package M0;

import java.util.Objects;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f5574a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5575b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5576c;

    /* renamed from: d, reason: collision with root package name */
    public final String f5577d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5578e;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f5574a = str;
        this.f5575b = str2;
        this.f5576c = str3;
        this.f5577d = str4;
        this.f5578e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Objects.equals(this.f5574a, hVar.f5574a) && Objects.equals(this.f5575b, hVar.f5575b) && Objects.equals(this.f5576c, hVar.f5576c) && Objects.equals(this.f5577d, hVar.f5577d) && Objects.equals(this.f5578e, hVar.f5578e);
    }

    public int hashCode() {
        String str = this.f5574a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f5575b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f5576c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f5577d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f5578e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
