package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public class zzbx extends Binder implements IInterface {
    protected zzbx(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i12, Parcel parcel, Parcel parcel2, int i13) throws RemoteException {
        boolean zOnTransact;
        if (i12 > 16777215) {
            zOnTransact = super.onTransact(i12, parcel, parcel2, i13);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        return zza(i12, parcel, parcel2, i13);
    }

    protected boolean zza(int i12, Parcel parcel, Parcel parcel2, int i13) throws RemoteException {
        return false;
    }
}
