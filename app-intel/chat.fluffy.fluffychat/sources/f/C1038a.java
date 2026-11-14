package f;

import M5.m;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1038a implements Parcelable {

    /* renamed from: l, reason: collision with root package name */
    public final int f15620l;

    /* renamed from: m, reason: collision with root package name */
    public final Intent f15621m;

    /* renamed from: n, reason: collision with root package name */
    public static final b f15619n = new b(null);
    public static final Parcelable.Creator<C1038a> CREATOR = new C0163a();

    /* renamed from: f.a$a, reason: collision with other inner class name */
    public static final class C0163a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1038a createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            return new C1038a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1038a[] newArray(int i7) {
            return new C1038a[i7];
        }
    }

    /* renamed from: f.a$b */
    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public final String a(int i7) {
            return i7 != -1 ? i7 != 0 ? String.valueOf(i7) : "RESULT_CANCELED" : "RESULT_OK";
        }

        public b() {
        }
    }

    public C1038a(int i7, Intent intent) {
        this.f15620l = i7;
        this.f15621m = intent;
    }

    public final Intent b() {
        return this.f15621m;
    }

    public final int c() {
        return this.f15620l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + f15619n.a(this.f15620l) + ", data=" + this.f15621m + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        m.e(parcel, "dest");
        parcel.writeInt(this.f15620l);
        parcel.writeInt(this.f15621m == null ? 0 : 1);
        Intent intent = this.f15621m;
        if (intent != null) {
            intent.writeToParcel(parcel, i7);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1038a(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel));
        m.e(parcel, "parcel");
    }
}
