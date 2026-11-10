package A6;

import M5.g;
import M5.m;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class c implements Parcelable {
    public static final a CREATOR = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f321l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f322m;

    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(g gVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            int i7 = parcel.readInt();
            byte[] bArr = new byte[i7];
            parcel.readByteArray(bArr);
            boolean z7 = parcel.readInt() == 1;
            if (i7 == 0) {
                return null;
            }
            return new c(bArr, z7);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i7) {
            return new c[i7];
        }

        public a() {
        }
    }

    public c(byte[] bArr, boolean z7) {
        m.e(bArr, "content");
        this.f321l = bArr;
        this.f322m = z7;
    }

    public final byte[] b() {
        return this.f321l;
    }

    public final boolean c() {
        return this.f322m;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        m.e(parcel, "parcel");
        parcel.writeInt(this.f321l.length);
        parcel.writeByteArray(this.f321l);
        parcel.writeInt(this.f322m ? 1 : 0);
    }
}
