package b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0816a extends IInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13500a = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    void a(String str);

    void b(String str, int i7, String str2);

    void c(String str, int i7, String str2, Notification notification);

    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0128a extends Binder implements InterfaceC0816a {

        /* renamed from: b.a$a$a, reason: collision with other inner class name */
        public static class C0129a implements InterfaceC0816a {

            /* renamed from: c, reason: collision with root package name */
            public IBinder f13501c;

            public C0129a(IBinder iBinder) {
                this.f13501c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13501c;
            }

            @Override // b.InterfaceC0816a
            public void c(String str, int i7, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(InterfaceC0816a.f13500a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i7);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedObject(notification, 0);
                    this.f13501c.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0128a() {
            attachInterface(this, InterfaceC0816a.f13500a);
        }

        public static InterfaceC0816a e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0816a.f13500a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0816a)) ? new C0129a(iBinder) : (InterfaceC0816a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) {
            String str = InterfaceC0816a.f13500a;
            if (i7 >= 1 && i7 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i7 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i7 == 1) {
                c(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) parcel.readTypedObject(Notification.CREATOR));
            } else if (i7 == 2) {
                b(parcel.readString(), parcel.readInt(), parcel.readString());
            } else {
                if (i7 != 3) {
                    return super.onTransact(i7, parcel, parcel2, i8);
                }
                a(parcel.readString());
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
