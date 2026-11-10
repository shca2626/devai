package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import b2.AbstractC0839a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0839a abstractC0839a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f11888a = (IconCompat) abstractC0839a.v(remoteActionCompat.f11888a, 1);
        remoteActionCompat.f11889b = abstractC0839a.l(remoteActionCompat.f11889b, 2);
        remoteActionCompat.f11890c = abstractC0839a.l(remoteActionCompat.f11890c, 3);
        remoteActionCompat.f11891d = (PendingIntent) abstractC0839a.r(remoteActionCompat.f11891d, 4);
        remoteActionCompat.f11892e = abstractC0839a.h(remoteActionCompat.f11892e, 5);
        remoteActionCompat.f11893f = abstractC0839a.h(remoteActionCompat.f11893f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0839a abstractC0839a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0839a.x(false, false);
        abstractC0839a.M(remoteActionCompat.f11888a, 1);
        abstractC0839a.D(remoteActionCompat.f11889b, 2);
        abstractC0839a.D(remoteActionCompat.f11890c, 3);
        abstractC0839a.H(remoteActionCompat.f11891d, 4);
        abstractC0839a.z(remoteActionCompat.f11892e, 5);
        abstractC0839a.z(remoteActionCompat.f11893f, 6);
    }
}
