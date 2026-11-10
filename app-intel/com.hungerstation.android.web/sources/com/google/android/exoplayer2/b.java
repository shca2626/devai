package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes8.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f20416a;

    /* renamed from: b, reason: collision with root package name */
    private final a f20417b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20418c;

    private final class a extends BroadcastReceiver implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC0397b f20419b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f20420c;

        public a(Handler handler, InterfaceC0397b interfaceC0397b) {
            this.f20420c = handler;
            this.f20419b = interfaceC0397b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f20420c.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f20418c) {
                this.f20419b.s();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.b$b, reason: collision with other inner class name */
    public interface InterfaceC0397b {
        void s();
    }

    public b(Context context, Handler handler, InterfaceC0397b interfaceC0397b) {
        this.f20416a = context.getApplicationContext();
        this.f20417b = new a(handler, interfaceC0397b);
    }

    public void b(boolean z12) {
        if (z12 && !this.f20418c) {
            this.f20416a.registerReceiver(this.f20417b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f20418c = true;
        } else {
            if (z12 || !this.f20418c) {
                return;
            }
            this.f20416a.unregisterReceiver(this.f20417b);
            this.f20418c = false;
        }
    }
}
