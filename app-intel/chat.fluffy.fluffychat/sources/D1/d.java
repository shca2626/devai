package D1;

import E0.AbstractC0320f;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import j3.InterfaceC1232f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {
    public byte[] a(List list, long j7) {
        ArrayList<? extends Parcelable> arrayListB = AbstractC0320f.b(list, new InterfaceC1232f() { // from class: D1.c
            @Override // j3.InterfaceC1232f
            public final Object apply(Object obj) {
                return ((D0.a) obj).d();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListB);
        bundle.putLong("d", j7);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
