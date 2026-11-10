package F2;

import android.content.Context;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static j f2693a;

    public static synchronized j a() {
        try {
            if (f2693a == null) {
                f2693a = new j();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2693a;
    }

    public k b(Context context, E2.a aVar) {
        if (L.b.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return k.precise;
        }
        if (L.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return k.reduced;
        }
        aVar.a(E2.b.permissionDenied);
        return null;
    }
}
