package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes7.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8418a;

    /* renamed from: b, reason: collision with root package name */
    private final RunnableC0164a f8419b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8420c;

    /* renamed from: androidx.media3.exoplayer.a$a, reason: collision with other inner class name */
    private final class RunnableC0164a extends BroadcastReceiver implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final b f8421b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f8422c;

        public RunnableC0164a(Handler handler, b bVar) {
            this.f8422c = handler;
            this.f8421b = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f8422c.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f8420c) {
                this.f8421b.s();
            }
        }
    }

    public interface b {
        void s();
    }

    public a(Context context, Handler handler, b bVar) {
        this.f8418a = context.getApplicationContext();
        this.f8419b = new RunnableC0164a(handler, bVar);
    }

    public void b(boolean z12) {
        if (z12 && !this.f8420c) {
            this.f8418a.registerReceiver(this.f8419b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f8420c = true;
        } else {
            if (z12 || !this.f8420c) {
                return;
            }
            this.f8418a.unregisterReceiver(this.f8419b);
            this.f8420c = false;
        }
    }
}
