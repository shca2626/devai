package I0;

import E0.AbstractC0332s;
import E0.C0319e;
import E0.InterfaceC0321g;
import I0.R1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Looper;
import j3.InterfaceC1232f;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public final class R1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3787a;

    /* renamed from: b, reason: collision with root package name */
    public final b f3788b;

    /* renamed from: c, reason: collision with root package name */
    public final C0319e f3789c;

    /* renamed from: d, reason: collision with root package name */
    public AudioManager f3790d;

    /* renamed from: e, reason: collision with root package name */
    public d f3791e;

    /* renamed from: f, reason: collision with root package name */
    public int f3792f;

    public interface b {
        void E(int i7, boolean z7);

        void z(int i7);
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f3793a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3794b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f3795c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3796d;

        /* renamed from: e, reason: collision with root package name */
        public final int f3797e;

        public c(int i7, int i8, boolean z7, int i9, int i10) {
            this.f3793a = i7;
            this.f3794b = i8;
            this.f3795c = z7;
            this.f3796d = i9;
            this.f3797e = i10;
        }
    }

    public final class d extends BroadcastReceiver {
        public d() {
        }

        public static /* synthetic */ void a(d dVar) {
            if (R1.this.f3791e == null) {
                return;
            }
            R1.this.f3789c.g(R1.this.j(((c) R1.this.f3789c.d()).f3793a));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            R1.this.f3789c.e(new Runnable() { // from class: I0.S1
                @Override // java.lang.Runnable
                public final void run() {
                    R1.d.a(this.f3800l);
                }
            });
        }
    }

    public R1(Context context, b bVar, final int i7, Looper looper, Looper looper2, InterfaceC0321g interfaceC0321g) {
        this.f3787a = context.getApplicationContext();
        this.f3788b = bVar;
        C0319e c0319e = new C0319e(new c(i7, 0, false, 0, 0), looper, looper2, interfaceC0321g, new C0319e.a() { // from class: I0.L1
            @Override // E0.C0319e.a
            public final void a(Object obj, Object obj2) {
                this.f3772a.m((R1.c) obj, (R1.c) obj2);
            }
        });
        this.f3789c = c0319e;
        c0319e.e(new Runnable() { // from class: I0.M1
            @Override // java.lang.Runnable
            public final void run() {
                R1.f(this.f3774l, i7);
            }
        });
    }

    public static /* synthetic */ c a(int i7, c cVar) {
        return new c(i7, cVar.f3794b, cVar.f3795c, cVar.f3796d, cVar.f3797e);
    }

    public static /* synthetic */ c b(c cVar) {
        return cVar;
    }

    public static /* synthetic */ c c(R1 r12, int i7, c cVar) {
        r12.getClass();
        return cVar.f3793a == i7 ? cVar : r12.j(i7);
    }

    public static /* synthetic */ c d(R1 r12, c cVar) {
        d dVar = r12.f3791e;
        if (dVar != null) {
            try {
                r12.f3787a.unregisterReceiver(dVar);
            } catch (RuntimeException e7) {
                AbstractC0332s.i("StreamVolumeManager", "Error unregistering stream volume receiver", e7);
            }
            r12.f3791e = null;
        }
        return cVar;
    }

    public static /* synthetic */ void f(R1 r12, int i7) {
        r12.f3790d = (AudioManager) j3.o.q((AudioManager) r12.f3787a.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND));
        d dVar = new d();
        try {
            r12.f3787a.registerReceiver(dVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            r12.f3791e = dVar;
        } catch (RuntimeException e7) {
            AbstractC0332s.i("StreamVolumeManager", "Error registering stream volume receiver", e7);
        }
        r12.f3789c.g(r12.j(i7));
    }

    public final c j(int i7) {
        j3.o.q(this.f3790d);
        return new c(i7, C0.s.f(this.f3790d, i7), C0.s.g(this.f3790d, i7), C0.s.e(this.f3790d, i7), C0.s.d(this.f3790d, i7));
    }

    public int k() {
        return ((c) this.f3789c.d()).f3797e;
    }

    public int l() {
        return ((c) this.f3789c.d()).f3796d;
    }

    public final void m(c cVar, c cVar2) {
        boolean z7 = cVar.f3795c;
        if (!z7 && cVar2.f3795c) {
            this.f3792f = cVar.f3794b;
        }
        int i7 = cVar.f3794b;
        int i8 = cVar2.f3794b;
        if (i7 != i8 || z7 != cVar2.f3795c) {
            this.f3788b.E(i8, cVar2.f3795c);
        }
        int i9 = cVar.f3793a;
        int i10 = cVar2.f3793a;
        if (i9 == i10 && cVar.f3796d == cVar2.f3796d && cVar.f3797e == cVar2.f3797e) {
            return;
        }
        this.f3788b.z(i10);
    }

    public void n() {
        this.f3789c.h(new InterfaceC1232f() { // from class: I0.P1
            @Override // j3.InterfaceC1232f
            public final Object apply(Object obj) {
                return R1.b((R1.c) obj);
            }
        }, new InterfaceC1232f() { // from class: I0.Q1
            @Override // j3.InterfaceC1232f
            public final Object apply(Object obj) {
                return R1.d(this.f3785l, (R1.c) obj);
            }
        });
    }

    public void o(final int i7) {
        this.f3789c.h(new InterfaceC1232f() { // from class: I0.N1
            @Override // j3.InterfaceC1232f
            public final Object apply(Object obj) {
                return R1.a(i7, (R1.c) obj);
            }
        }, new InterfaceC1232f() { // from class: I0.O1
            @Override // j3.InterfaceC1232f
            public final Object apply(Object obj) {
                return R1.c(this.f3781l, i7, (R1.c) obj);
            }
        });
    }
}
