package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements X1.b {

    public static class a {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class b {
    }

    public static void h(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: S1.i
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                androidx.profileinstaller.c.h(context);
            }
        });
    }

    @Override // X1.b
    public List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // X1.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: S1.g
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j7) {
                this.f8152a.g(applicationContext);
            }
        });
        return new b();
    }

    public void g(final Context context) {
        (Build.VERSION.SDK_INT >= 28 ? a.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new Runnable() { // from class: S1.h
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.h(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
