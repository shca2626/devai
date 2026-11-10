package com.google.android.play.integrity.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes8.dex */
public class m extends Binder implements IInterface {
    protected m(String str) {
        attachInterface(this, str);
    }

    protected boolean a(int i12, Parcel parcel, Parcel parcel2, int i13) throws RemoteException {
        throw null;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i12, Parcel parcel, Parcel parcel2, int i13) throws RemoteException {
        if (i12 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i12, parcel, parcel2, i13)) {
            return true;
        }
        return a(i12, parcel, parcel2, i13);
    }
}
