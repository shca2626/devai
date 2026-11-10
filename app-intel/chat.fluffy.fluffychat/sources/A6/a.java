package A6;

import M5.g;
import M5.m;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class a implements Parcelable {
    public static final C0007a CREATOR = new C0007a(null);

    /* renamed from: l, reason: collision with root package name */
    public final String f316l;

    /* renamed from: m, reason: collision with root package name */
    public final String f317m;

    /* renamed from: A6.a$a, reason: collision with other inner class name */
    public static final class C0007a implements Parcelable.Creator {
        public /* synthetic */ C0007a(g gVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (string == null || string2 == null) {
                return null;
            }
            return new a(string, string2);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i7) {
            return new a[i7];
        }

        public C0007a() {
        }
    }

    public a(String str, String str2) {
        m.e(str, "pubKey");
        m.e(str2, "auth");
        this.f316l = str;
        this.f317m = str2;
    }

    public final String b() {
        return this.f317m;
    }

    public final String c() {
        return this.f316l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f316l);
        parcel.writeString(this.f317m);
    }
}
