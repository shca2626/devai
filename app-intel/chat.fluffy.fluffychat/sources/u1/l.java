package u1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l extends i {

    /* renamed from: b, reason: collision with root package name */
    public final int f22771b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22772c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22773d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f22774e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f22775f;

    public l(int i7, int i8, int i9, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f22771b = i7;
        this.f22772c = i8;
        this.f22773d = i9;
        this.f22774e = iArr;
        this.f22775f = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.f22771b == lVar.f22771b && this.f22772c == lVar.f22772c && this.f22773d == lVar.f22773d && Arrays.equals(this.f22774e, lVar.f22774e) && Arrays.equals(this.f22775f, lVar.f22775f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f22771b) * 31) + this.f22772c) * 31) + this.f22773d) * 31) + Arrays.hashCode(this.f22774e)) * 31) + Arrays.hashCode(this.f22775f);
    }
}
