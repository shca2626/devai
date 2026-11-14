package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22755b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f22756c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22757d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f22758e;

    /* renamed from: f, reason: collision with root package name */
    public final i[] f22759f;

    public d(String str, boolean z7, boolean z8, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f22755b = str;
        this.f22756c = z7;
        this.f22757d = z8;
        this.f22758e = strArr;
        this.f22759f = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f22756c == dVar.f22756c && this.f22757d == dVar.f22757d && Objects.equals(this.f22755b, dVar.f22755b) && Arrays.equals(this.f22758e, dVar.f22758e) && Arrays.equals(this.f22759f, dVar.f22759f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (((527 + (this.f22756c ? 1 : 0)) * 31) + (this.f22757d ? 1 : 0)) * 31;
        String str = this.f22755b;
        return i7 + (str != null ? str.hashCode() : 0);
    }
}
