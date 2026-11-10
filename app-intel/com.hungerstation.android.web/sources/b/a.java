package b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: e, reason: collision with root package name */
    public static final String f12523e = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0225a extends Binder implements a {

        /* renamed from: b.a$a$a, reason: collision with other inner class name */
        private static class C0226a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f12524a;

            C0226a(IBinder iBinder) {
                this.f12524a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12524a;
            }

            @Override // b.a
            public void q(String str, int i12, String str2, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f12523e);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeString(str2);
                    b.b(parcelObtain, notification, 0);
                    this.f12524a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static a G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f12523e);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0226a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void b(Parcel parcel, T t12, int i12) {
            if (t12 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t12.writeToParcel(parcel, i12);
            }
        }
    }

    void q(String str, int i12, String str2, Notification notification) throws RemoteException;
}
