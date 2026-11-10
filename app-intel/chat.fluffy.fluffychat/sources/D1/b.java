package D1;

import E0.AbstractC0320f;
import android.os.Bundle;
import android.os.Parcel;
import j3.InterfaceC1232f;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {
    public e a(long j7, byte[] bArr, int i7, int i8) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, i7, i8);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
        parcelObtain.recycle();
        return new e(AbstractC0320f.a(new InterfaceC1232f() { // from class: D1.a
            @Override // j3.InterfaceC1232f
            public final Object apply(Object obj) {
                return D0.a.b((Bundle) obj);
            }
        }, (ArrayList) j3.o.q(bundle.getParcelableArrayList("c"))), j7, bundle.getLong("d"));
    }
}
