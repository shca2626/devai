package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0888a extends IInterface {

    /* renamed from: b, reason: collision with root package name */
    public static final String f13817b = "android$support$v4$os$IResultReceiver".replace('$', '.');

    void d(int i7, Bundle bundle);

    /* renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0132a extends Binder implements InterfaceC0888a {

        /* renamed from: c.a$a$a, reason: collision with other inner class name */
        public static class C0133a implements InterfaceC0888a {

            /* renamed from: c, reason: collision with root package name */
            public IBinder f13818c;

            public C0133a(IBinder iBinder) {
                this.f13818c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13818c;
            }
        }

        public AbstractBinderC0132a() {
            attachInterface(this, InterfaceC0888a.f13817b);
        }

        public static InterfaceC0888a e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0888a.f13817b);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0888a)) ? new C0133a(iBinder) : (InterfaceC0888a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) {
            String str = InterfaceC0888a.f13817b;
            if (i7 >= 1 && i7 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i7 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i7 != 1) {
                return super.onTransact(i7, parcel, parcel2, i8);
            }
            d(parcel.readInt(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
