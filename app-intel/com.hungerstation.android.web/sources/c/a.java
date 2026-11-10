package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: f, reason: collision with root package name */
    public static final String f16268f = "android$support$v4$os$IResultReceiver".replace('$', '.');

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void g(int i12, Bundle bundle) throws RemoteException;

    /* renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0305a extends Binder implements a {

        /* renamed from: c.a$a$a, reason: collision with other inner class name */
        private static class C0306a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f16269a;

            C0306a(IBinder iBinder) {
                this.f16269a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f16269a;
            }
        }

        public AbstractBinderC0305a() {
            attachInterface(this, a.f16268f);
        }

        public static a G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f16268f);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0306a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i12, Parcel parcel, Parcel parcel2, int i13) throws RemoteException {
            String str = a.f16268f;
            if (i12 >= 1 && i12 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i12 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i12 != 1) {
                return super.onTransact(i12, parcel, parcel2, i13);
            }
            g(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
