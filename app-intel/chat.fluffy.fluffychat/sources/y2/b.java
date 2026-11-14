package y2;

import M5.m;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: l, reason: collision with root package name */
    public static final b f23981l = new b();
    public static final Parcelable.Creator<b> CREATOR = new a();

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            parcel.readInt();
            return b.f23981l;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b[] newArray(int i7) {
            return new b[i7];
        }
    }

    public b() {
        super(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "coil.size.OriginalSize";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        m.e(parcel, "out");
        parcel.writeInt(1);
    }
}
