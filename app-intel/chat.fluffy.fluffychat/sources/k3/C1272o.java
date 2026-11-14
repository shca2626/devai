package k3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: k3.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1272o extends U implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final Comparator[] f19010l;

    public C1272o(Comparator comparator, Comparator comparator2) {
        this.f19010l = new Comparator[]{comparator, comparator2};
    }

    @Override // k3.U, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i7 = 0;
        while (true) {
            Comparator[] comparatorArr = this.f19010l;
            if (i7 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i7].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i7++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1272o) {
            return Arrays.equals(this.f19010l, ((C1272o) obj).f19010l);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19010l);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.f19010l) + ")";
    }
}
