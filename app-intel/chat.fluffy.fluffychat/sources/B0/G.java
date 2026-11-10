package B0;

import E0.U;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class G implements Comparable, Parcelable {
    public static final Parcelable.Creator<G> CREATOR = new a();

    /* renamed from: o, reason: collision with root package name */
    public static final String f369o = U.A0(0);

    /* renamed from: p, reason: collision with root package name */
    public static final String f370p = U.A0(1);

    /* renamed from: q, reason: collision with root package name */
    public static final String f371q = U.A0(2);

    /* renamed from: l, reason: collision with root package name */
    public final int f372l;

    /* renamed from: m, reason: collision with root package name */
    public final int f373m;

    /* renamed from: n, reason: collision with root package name */
    public final int f374n;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public G createFromParcel(Parcel parcel) {
            return new G(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public G[] newArray(int i7) {
            return new G[i7];
        }
    }

    public G(int i7, int i8, int i9) {
        this.f372l = i7;
        this.f373m = i8;
        this.f374n = i9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(G g7) {
        int i7 = this.f372l - g7.f372l;
        if (i7 != 0) {
            return i7;
        }
        int i8 = this.f373m - g7.f373m;
        return i8 == 0 ? this.f374n - g7.f374n : i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && G.class == obj.getClass()) {
            G g7 = (G) obj;
            if (this.f372l == g7.f372l && this.f373m == g7.f373m && this.f374n == g7.f374n) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f372l * 31) + this.f373m) * 31) + this.f374n;
    }

    public String toString() {
        return this.f372l + "." + this.f373m + "." + this.f374n;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f372l);
        parcel.writeInt(this.f373m);
        parcel.writeInt(this.f374n);
    }

    public G(Parcel parcel) {
        this.f372l = parcel.readInt();
        this.f373m = parcel.readInt();
        this.f374n = parcel.readInt();
    }
}
