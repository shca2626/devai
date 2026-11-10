package k4;

/* loaded from: classes.dex */
public class s implements Comparable {

    /* renamed from: l, reason: collision with root package name */
    public final int f19100l;

    /* renamed from: m, reason: collision with root package name */
    public final int f19101m;

    public s(int i7, int i8) {
        this.f19100l = i7;
        this.f19101m = i8;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(s sVar) {
        int i7 = this.f19101m * this.f19100l;
        int i8 = sVar.f19101m * sVar.f19100l;
        if (i8 < i7) {
            return 1;
        }
        return i8 > i7 ? -1 : 0;
    }

    public s d() {
        return new s(this.f19101m, this.f19100l);
    }

    public s e(s sVar) {
        int i7 = this.f19100l;
        int i8 = sVar.f19101m;
        int i9 = i7 * i8;
        int i10 = sVar.f19100l;
        int i11 = this.f19101m;
        return i9 <= i10 * i11 ? new s(i10, (i11 * i10) / i7) : new s((i7 * i8) / i11, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            s sVar = (s) obj;
            if (this.f19100l == sVar.f19100l && this.f19101m == sVar.f19101m) {
                return true;
            }
        }
        return false;
    }

    public s f(s sVar) {
        int i7 = this.f19100l;
        int i8 = sVar.f19101m;
        int i9 = i7 * i8;
        int i10 = sVar.f19100l;
        int i11 = this.f19101m;
        return i9 >= i10 * i11 ? new s(i10, (i11 * i10) / i7) : new s((i7 * i8) / i11, i8);
    }

    public int hashCode() {
        return (this.f19100l * 31) + this.f19101m;
    }

    public String toString() {
        return this.f19100l + "x" + this.f19101m;
    }
}
