package u1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l extends i {

    /* renamed from: b, reason: collision with root package name */
    public final int f22777b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22778c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22779d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f22780e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f22781f;

    public l(int i7, int i8, int i9, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f22777b = i7;
        this.f22778c = i8;
        this.f22779d = i9;
        this.f22780e = iArr;
        this.f22781f = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.f22777b == lVar.f22777b && this.f22778c == lVar.f22778c && this.f22779d == lVar.f22779d && Arrays.equals(this.f22780e, lVar.f22780e) && Arrays.equals(this.f22781f, lVar.f22781f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f22777b) * 31) + this.f22778c) * 31) + this.f22779d) * 31) + Arrays.hashCode(this.f22780e)) * 31) + Arrays.hashCode(this.f22781f);
    }
}
