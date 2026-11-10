package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes7.dex */
public interface l extends IInterface {

    public static abstract class a extends Binder implements l {

        /* renamed from: androidx.room.l$a$a, reason: collision with other inner class name */
        private static class C0199a implements l {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f11418a;

            C0199a(IBinder iBinder) {
                this.f11418a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11418a;
            }

            @Override // androidx.room.l
            public void b(String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    parcelObtain.writeStringArray(strArr);
                    this.f11418a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static l G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof l)) ? new C0199a(iBinder) : (l) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i12, Parcel parcel, Parcel parcel2, int i13) throws RemoteException {
            if (i12 >= 1 && i12 <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
            }
            if (i12 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
            if (i12 != 1) {
                return super.onTransact(i12, parcel, parcel2, i13);
            }
            b(parcel.createStringArray());
            return true;
        }
    }

    void b(String[] strArr) throws RemoteException;
}
