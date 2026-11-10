package y2;

import M5.m;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final int f23976l;

    /* renamed from: m, reason: collision with root package name */
    public final int f23977m;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            return new c(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c[] newArray(int i7) {
            return new c[i7];
        }
    }

    public c(int i7, int i8) {
        super(null);
        this.f23976l = i7;
        this.f23977m = i8;
        if (!(i7 > 0 && i8 > 0)) {
            throw new IllegalArgumentException("width and height must be > 0.");
        }
    }

    public final int b() {
        return this.f23976l;
    }

    public final int c() {
        return this.f23977m;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f23977m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f23976l == cVar.f23976l && this.f23977m == cVar.f23977m;
    }

    public final int f() {
        return this.f23976l;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f23976l) * 31) + Integer.hashCode(this.f23977m);
    }

    public String toString() {
        return "PixelSize(width=" + this.f23976l + ", height=" + this.f23977m + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        m.e(parcel, "out");
        parcel.writeInt(this.f23976l);
        parcel.writeInt(this.f23977m);
    }
}
