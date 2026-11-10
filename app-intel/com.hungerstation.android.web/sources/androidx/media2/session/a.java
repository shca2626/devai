package androidx.media2.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes7.dex */
public interface a extends IInterface {

    /* renamed from: androidx.media2.session.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0161a extends Binder implements a {

        /* renamed from: androidx.media2.session.a$a$a, reason: collision with other inner class name */
        private static class C0162a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f8264a;

            C0162a(IBinder iBinder) {
                this.f8264a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8264a;
            }
        }

        public static a G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media2.session.IMediaSession");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0162a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
