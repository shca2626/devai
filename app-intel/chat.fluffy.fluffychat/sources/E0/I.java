package E0;

/* loaded from: classes.dex */
public final class I extends IllegalStateException {

    /* renamed from: l, reason: collision with root package name */
    public final int f2077l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2078m;

    public I(int i7, int i8) {
        super(a(i7, i8));
        this.f2077l = i7;
        this.f2078m = i8;
    }

    public static String a(int i7, int i8) {
        if (i7 == 0) {
            return "Player stuck buffering and not loading for " + i8 + " ms";
        }
        if (i7 == 1) {
            return "Player stuck buffering with no progress for " + i8 + " ms";
        }
        if (i7 == 2) {
            return "Player stuck playing with no progress for " + i8 + " ms";
        }
        if (i7 == 3) {
            return "Player stuck playing without ending for " + i8 + " ms";
        }
        if (i7 != 4) {
            throw new IllegalStateException();
        }
        return "Player stuck suppressed for " + i8 + " ms";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && I.class == obj.getClass()) {
            I i7 = (I) obj;
            if (this.f2077l == i7.f2077l && this.f2078m == i7.f2078m) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f2077l) * 31) + this.f2078m;
    }
}
