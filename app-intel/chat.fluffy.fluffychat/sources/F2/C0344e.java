package F2;

import K.k;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* renamed from: F2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0344e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2671a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f2672b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2673c;

    /* renamed from: d, reason: collision with root package name */
    public k.e f2674d;

    public C0344e(Context context, String str, Integer num, g gVar) {
        this.f2671a = context;
        this.f2672b = num;
        this.f2673c = str;
        this.f2674d = new k.e(context, str).E(1);
        e(gVar, false);
    }

    public Notification a() {
        return this.f2674d.d();
    }

    public final PendingIntent b() {
        Intent launchIntentForPackage = this.f2671a.getPackageManager().getLaunchIntentForPackage(this.f2671a.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.setFlags(270532608);
        return PendingIntent.getActivity(this.f2671a, 0, launchIntentForPackage, 201326592);
    }

    public final int c(String str, String str2) {
        return this.f2671a.getResources().getIdentifier(str, str2, this.f2671a.getPackageName());
    }

    public void d(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            K.r rVarG = K.r.g(this.f2671a);
            AbstractC0342c.a();
            NotificationChannel notificationChannelA = AbstractC0341b.a(this.f2673c, str, 0);
            notificationChannelA.setLockscreenVisibility(0);
            rVarG.f(notificationChannelA);
        }
    }

    public final void e(g gVar, boolean z7) {
        int iC = c(gVar.c().b(), gVar.c().a());
        if (iC == 0) {
            c("ic_launcher.png", "mipmap");
        }
        this.f2674d = this.f2674d.o(gVar.e()).J(iC).n(gVar.d()).m(b()).C(gVar.h());
        Integer numA = gVar.a();
        if (numA != null) {
            this.f2674d = this.f2674d.k(numA.intValue());
        }
        if (z7) {
            K.r.g(this.f2671a).k(this.f2672b.intValue(), this.f2674d.d());
        }
    }

    public void f(g gVar, boolean z7) {
        e(gVar, z7);
    }
}
