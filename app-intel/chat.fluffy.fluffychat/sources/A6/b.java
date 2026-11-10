package A6;

import M5.g;
import M5.m;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class b implements Parcelable {
    public static final a CREATOR = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public final String f318l;

    /* renamed from: m, reason: collision with root package name */
    public final A6.a f319m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f320n;

    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(g gVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            boolean z7 = parcel.readInt() == 1;
            String string = parcel.readString();
            A6.a aVarCreateFromParcel = parcel.readInt() == 1 ? A6.a.CREATOR.createFromParcel(parcel) : null;
            if (string == null) {
                return null;
            }
            return new b(string, aVarCreateFromParcel, z7);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i7) {
            return new b[i7];
        }

        public a() {
        }
    }

    public b(String str, A6.a aVar, boolean z7) {
        m.e(str, "url");
        this.f318l = str;
        this.f319m = aVar;
        this.f320n = z7;
    }

    public final A6.a b() {
        return this.f319m;
    }

    public final boolean c() {
        return this.f320n;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f318l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        m.e(parcel, "parcel");
        parcel.writeInt(this.f320n ? 1 : 0);
        parcel.writeString(this.f318l);
        parcel.writeInt(this.f319m != null ? 1 : 0);
        A6.a aVar = this.f319m;
        if (aVar != null) {
            aVar.writeToParcel(parcel, i7);
        }
    }
}
