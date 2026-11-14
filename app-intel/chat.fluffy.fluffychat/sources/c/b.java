package c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import c.InterfaceC0889a;

/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f13819l = false;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f13820m = null;

    /* renamed from: n, reason: collision with root package name */
    public InterfaceC0889a f13821n;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i7) {
            return new b[i7];
        }
    }

    /* renamed from: c.b$b, reason: collision with other inner class name */
    public class BinderC0134b extends InterfaceC0889a.AbstractBinderC0132a {
        public BinderC0134b() {
        }

        @Override // c.InterfaceC0889a
        public void d(int i7, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f13820m;
            if (handler != null) {
                handler.post(bVar.new c(i7, bundle));
            } else {
                bVar.b(i7, bundle);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final int f13823l;

        /* renamed from: m, reason: collision with root package name */
        public final Bundle f13824m;

        public c(int i7, Bundle bundle) {
            this.f13823l = i7;
            this.f13824m = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f13823l, this.f13824m);
        }
    }

    public b(Parcel parcel) {
        this.f13821n = InterfaceC0889a.AbstractBinderC0132a.e(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        synchronized (this) {
            try {
                if (this.f13821n == null) {
                    this.f13821n = new BinderC0134b();
                }
                parcel.writeStrongBinder(this.f13821n.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(int i7, Bundle bundle) {
    }
}
