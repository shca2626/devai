package r0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: r0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1534c implements Parcelable {
    public static final Parcelable.Creator<C1534c> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final List f21900l;

    /* renamed from: m, reason: collision with root package name */
    public final List f21901m;

    /* renamed from: r0.c$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1534c createFromParcel(Parcel parcel) {
            return new C1534c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1534c[] newArray(int i7) {
            return new C1534c[i7];
        }
    }

    public C1534c(Parcel parcel) {
        this.f21900l = parcel.createStringArrayList();
        this.f21901m = parcel.createTypedArrayList(C1533b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeStringList(this.f21900l);
        parcel.writeTypedList(this.f21901m);
    }
}
