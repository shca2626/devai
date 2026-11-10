package C0;

import E0.InterfaceC0321g;
import E0.InterfaceC0329o;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1212a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1213b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0329o f1214c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1215d;

    public final class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC0012c f1216a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC0329o f1217b;

        public final void b() {
            if (c.this.f1215d) {
                this.f1216a.C();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f1217b.c(new Runnable() { // from class: C0.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1219l.b();
                    }
                });
            }
        }

        public b(InterfaceC0329o interfaceC0329o, InterfaceC0012c interfaceC0012c) {
            this.f1217b = interfaceC0329o;
            this.f1216a = interfaceC0012c;
        }
    }

    /* renamed from: C0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0012c {
        void C();
    }

    public c(Context context, Looper looper, Looper looper2, InterfaceC0012c interfaceC0012c, InterfaceC0321g interfaceC0321g) {
        this.f1212a = context.getApplicationContext();
        this.f1214c = interfaceC0321g.c(looper, null);
        this.f1213b = new b(interfaceC0321g.c(looper2, null), interfaceC0012c);
    }

    public void d(boolean z7) {
        if (z7 == this.f1215d) {
            return;
        }
        if (z7) {
            this.f1214c.c(new Runnable() { // from class: C0.a
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = this.f1210l;
                    cVar.f1212a.registerReceiver(cVar.f1213b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
                }
            });
            this.f1215d = true;
        } else {
            this.f1214c.c(new Runnable() { // from class: C0.b
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = this.f1211l;
                    cVar.f1212a.unregisterReceiver(cVar.f1213b);
                }
            });
            this.f1215d = false;
        }
    }
}
