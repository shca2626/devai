package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import b2.AbstractC0840a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0840a abstractC0840a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f11888a = (IconCompat) abstractC0840a.v(remoteActionCompat.f11888a, 1);
        remoteActionCompat.f11889b = abstractC0840a.l(remoteActionCompat.f11889b, 2);
        remoteActionCompat.f11890c = abstractC0840a.l(remoteActionCompat.f11890c, 3);
        remoteActionCompat.f11891d = (PendingIntent) abstractC0840a.r(remoteActionCompat.f11891d, 4);
        remoteActionCompat.f11892e = abstractC0840a.h(remoteActionCompat.f11892e, 5);
        remoteActionCompat.f11893f = abstractC0840a.h(remoteActionCompat.f11893f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0840a abstractC0840a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0840a.x(false, false);
        abstractC0840a.M(remoteActionCompat.f11888a, 1);
        abstractC0840a.D(remoteActionCompat.f11889b, 2);
        abstractC0840a.D(remoteActionCompat.f11890c, 3);
        abstractC0840a.H(remoteActionCompat.f11891d, 4);
        abstractC0840a.z(remoteActionCompat.f11892e, 5);
        abstractC0840a.z(remoteActionCompat.f11893f, 6);
    }
}
