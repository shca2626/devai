package com.google.android.gms.internal.wallet;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes8.dex */
public class zzb extends Binder implements IInterface {
    protected zzb(String str) {
        attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
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
        return zza(i12, parcel, parcel2, i13);
    }

    protected boolean zza(int i12, Parcel parcel, Parcel parcel2, int i13) throws RemoteException {
        throw null;
    }
}
