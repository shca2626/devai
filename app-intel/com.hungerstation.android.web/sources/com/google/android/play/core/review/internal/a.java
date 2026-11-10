package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes8.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f23712a;

    /* renamed from: b, reason: collision with root package name */
    private final String f23713b = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";

    protected a(IBinder iBinder, String str) {
        this.f23712a = iBinder;
    }

    protected final Parcel G() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f23713b);
        return parcelObtain;
    }

    protected final void H(int i12, Parcel parcel) throws RemoteException {
        try {
            this.f23712a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f23712a;
    }
}
