package e0;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: e0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1009a implements Parcelable {

    /* renamed from: l, reason: collision with root package name */
    public final Parcelable f15321l;

    /* renamed from: m, reason: collision with root package name */
    public static final AbstractC1009a f15320m = new C0158a();
    public static final Parcelable.Creator<AbstractC1009a> CREATOR = new b();

    /* renamed from: e0.a$a, reason: collision with other inner class name */
    public class C0158a extends AbstractC1009a {
        public C0158a() {
            super((C0158a) null);
        }
    }

    /* renamed from: e0.a$b */
    public class b implements Parcelable.ClassLoaderCreator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC1009a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbstractC1009a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbstractC1009a.f15320m;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AbstractC1009a[] newArray(int i7) {
            return new AbstractC1009a[i7];
        }
    }

    public /* synthetic */ AbstractC1009a(C0158a c0158a) {
        this();
    }

    public final Parcelable b() {
        return this.f15321l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f15321l, i7);
    }

    public AbstractC1009a() {
        this.f15321l = null;
    }

    public AbstractC1009a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f15321l = parcelable == f15320m ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbstractC1009a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f15321l = parcelable == null ? f15320m : parcelable;
    }
}
