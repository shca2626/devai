package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22749b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22750c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22751d;

    /* renamed from: e, reason: collision with root package name */
    public final long f22752e;

    /* renamed from: f, reason: collision with root package name */
    public final long f22753f;

    /* renamed from: g, reason: collision with root package name */
    public final i[] f22754g;

    public c(String str, int i7, int i8, long j7, long j8, i[] iVarArr) {
        super("CHAP");
        this.f22749b = str;
        this.f22750c = i7;
        this.f22751d = i8;
        this.f22752e = j7;
        this.f22753f = j8;
        this.f22754g = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f22750c == cVar.f22750c && this.f22751d == cVar.f22751d && this.f22752e == cVar.f22752e && this.f22753f == cVar.f22753f && Objects.equals(this.f22749b, cVar.f22749b) && Arrays.equals(this.f22754g, cVar.f22754g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (((((((527 + this.f22750c) * 31) + this.f22751d) * 31) + ((int) this.f22752e)) * 31) + ((int) this.f22753f)) * 31;
        String str = this.f22749b;
        return i7 + (str != null ? str.hashCode() : 0);
    }
}
