package f;

import M5.m;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1045i implements Parcelable {

    /* renamed from: l, reason: collision with root package name */
    public final IntentSender f15645l;

    /* renamed from: m, reason: collision with root package name */
    public final Intent f15646m;

    /* renamed from: n, reason: collision with root package name */
    public final int f15647n;

    /* renamed from: o, reason: collision with root package name */
    public final int f15648o;

    /* renamed from: p, reason: collision with root package name */
    public static final c f15644p = new c(null);
    public static final Parcelable.Creator<C1045i> CREATOR = new b();

    /* renamed from: f.i$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final IntentSender f15649a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f15650b;

        /* renamed from: c, reason: collision with root package name */
        public int f15651c;

        /* renamed from: d, reason: collision with root package name */
        public int f15652d;

        public a(IntentSender intentSender) {
            m.e(intentSender, "intentSender");
            this.f15649a = intentSender;
        }

        public final C1045i a() {
            return new C1045i(this.f15649a, this.f15650b, this.f15651c, this.f15652d);
        }

        public final a b(Intent intent) {
            this.f15650b = intent;
            return this;
        }

        public final a c(int i7, int i8) {
            this.f15652d = i7;
            this.f15651c = i8;
            return this;
        }
    }

    /* renamed from: f.i$b */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1045i createFromParcel(Parcel parcel) {
            m.e(parcel, "inParcel");
            return new C1045i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1045i[] newArray(int i7) {
            return new C1045i[i7];
        }
    }

    /* renamed from: f.i$c */
    public static final class c {
        public /* synthetic */ c(M5.g gVar) {
            this();
        }

        public c() {
        }
    }

    public C1045i(IntentSender intentSender, Intent intent, int i7, int i8) {
        m.e(intentSender, "intentSender");
        this.f15645l = intentSender;
        this.f15646m = intent;
        this.f15647n = i7;
        this.f15648o = i8;
    }

    public final Intent b() {
        return this.f15646m;
    }

    public final int c() {
        return this.f15647n;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f15648o;
    }

    public final IntentSender f() {
        return this.f15645l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        m.e(parcel, "dest");
        parcel.writeParcelable(this.f15645l, i7);
        parcel.writeParcelable(this.f15646m, i7);
        parcel.writeInt(this.f15647n);
        parcel.writeInt(this.f15648o);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1045i(Parcel parcel) {
        m.e(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        m.b(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
