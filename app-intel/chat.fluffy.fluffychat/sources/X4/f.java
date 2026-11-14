package X4;

import X4.c;
import android.os.Handler;
import android.os.Looper;
import u5.C1665a;

/* loaded from: classes.dex */
public class f implements c.d {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f9342a = C1665a.a(Looper.getMainLooper());

    @Override // X4.c.d
    public void a(Runnable runnable) {
        this.f9342a.post(runnable);
    }
}
