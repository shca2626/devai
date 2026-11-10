package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22743b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22744c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22745d;

    /* renamed from: e, reason: collision with root package name */
    public final long f22746e;

    /* renamed from: f, reason: collision with root package name */
    public final long f22747f;

    /* renamed from: g, reason: collision with root package name */
    public final i[] f22748g;

    public c(String str, int i7, int i8, long j7, long j8, i[] iVarArr) {
        super("CHAP");
        this.f22743b = str;
        this.f22744c = i7;
        this.f22745d = i8;
        this.f22746e = j7;
        this.f22747f = j8;
        this.f22748g = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f22744c == cVar.f22744c && this.f22745d == cVar.f22745d && this.f22746e == cVar.f22746e && this.f22747f == cVar.f22747f && Objects.equals(this.f22743b, cVar.f22743b) && Arrays.equals(this.f22748g, cVar.f22748g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (((((((527 + this.f22744c) * 31) + this.f22745d) * 31) + ((int) this.f22746e)) * 31) + ((int) this.f22747f)) * 31;
        String str = this.f22743b;
        return i7 + (str != null ? str.hashCode() : 0);
    }
}
