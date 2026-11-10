package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes8.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f23761a;

    /* renamed from: b, reason: collision with root package name */
    private final String f23762b;

    protected a(IBinder iBinder, String str) {
        this.f23761a = iBinder;
        this.f23762b = str;
    }

    protected final Parcel G() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f23762b);
        return parcelObtain;
    }

    protected final void H(int i12, Parcel parcel) throws RemoteException {
        try {
            this.f23761a.transact(i12, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f23761a;
    }
}
