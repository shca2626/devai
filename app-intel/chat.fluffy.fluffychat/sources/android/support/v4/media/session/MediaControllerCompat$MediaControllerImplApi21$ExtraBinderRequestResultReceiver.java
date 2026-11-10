package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f10943l;

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i7, Bundle bundle) {
        b.a(this.f10943l.get());
    }
}
