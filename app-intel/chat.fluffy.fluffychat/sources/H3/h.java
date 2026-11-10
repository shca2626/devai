package H3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3418a;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f3422e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3423f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3420c = false;

    /* renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f3419b = new b();

    /* renamed from: d, reason: collision with root package name */
    public Handler f3421d = new Handler();

    public final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z7 = intent.getIntExtra("plugged", -1) <= 0;
                h.this.f3421d.post(new Runnable() { // from class: H3.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.f(z7);
                    }
                });
            }
        }
    }

    public h(Context context, Runnable runnable) {
        this.f3418a = context;
        this.f3422e = runnable;
    }

    public void c() {
        e();
        if (this.f3423f) {
            this.f3421d.postDelayed(this.f3422e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public final void e() {
        this.f3421d.removeCallbacksAndMessages(null);
    }

    public final void f(boolean z7) {
        this.f3423f = z7;
        if (this.f3420c) {
            c();
        }
    }

    public final void g() {
        if (this.f3420c) {
            return;
        }
        this.f3418a.registerReceiver(this.f3419b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f3420c = true;
    }

    public void h() {
        g();
        c();
    }

    public final void i() {
        if (this.f3420c) {
            this.f3418a.unregisterReceiver(this.f3419b);
            this.f3420c = false;
        }
    }
}
