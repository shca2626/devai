package B0;

import E0.U;
import java.util.Objects;

/* loaded from: classes.dex */
public class u {

    /* renamed from: c, reason: collision with root package name */
    public static final String f815c = U.A0(0);

    /* renamed from: d, reason: collision with root package name */
    public static final String f816d = U.A0(1);

    /* renamed from: a, reason: collision with root package name */
    public final String f817a;

    /* renamed from: b, reason: collision with root package name */
    public final String f818b;

    public u(String str, String str2) {
        this.f817a = U.S0(str);
        this.f818b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            u uVar = (u) obj;
            if (Objects.equals(this.f817a, uVar.f817a) && Objects.equals(this.f818b, uVar.f818b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f818b.hashCode() * 31;
        String str = this.f817a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
