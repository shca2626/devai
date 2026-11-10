package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22749b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f22750c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22751d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f22752e;

    /* renamed from: f, reason: collision with root package name */
    public final i[] f22753f;

    public d(String str, boolean z7, boolean z8, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f22749b = str;
        this.f22750c = z7;
        this.f22751d = z8;
        this.f22752e = strArr;
        this.f22753f = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f22750c == dVar.f22750c && this.f22751d == dVar.f22751d && Objects.equals(this.f22749b, dVar.f22749b) && Arrays.equals(this.f22752e, dVar.f22752e) && Arrays.equals(this.f22753f, dVar.f22753f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (((527 + (this.f22750c ? 1 : 0)) * 31) + (this.f22751d ? 1 : 0)) * 31;
        String str = this.f22749b;
        return i7 + (str != null ? str.hashCode() : 0);
    }
}
