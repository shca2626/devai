package E0;

import E0.InterfaceC0329o;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class K implements InterfaceC0329o {

    /* renamed from: b, reason: collision with root package name */
    public static final List f2079b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f2080a;

    public static final class b implements InterfaceC0329o.a {

        /* renamed from: a, reason: collision with root package name */
        public Message f2081a;

        /* renamed from: b, reason: collision with root package name */
        public K f2082b;

        public b() {
        }

        @Override // E0.InterfaceC0329o.a
        public void a() {
            ((Message) j3.o.q(this.f2081a)).sendToTarget();
            b();
        }

        public final void b() {
            this.f2081a = null;
            this.f2082b = null;
            K.q(this);
        }

        public boolean c(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) j3.o.q(this.f2081a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        public b d(Message message, K k7) {
            this.f2081a = message;
            this.f2082b = k7;
            return this;
        }
    }

    public K(Handler handler) {
        this.f2080a = handler;
    }

    public static b p() {
        b bVar;
        List list = f2079b;
        synchronized (list) {
            try {
                bVar = list.isEmpty() ? new b() : (b) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static void q(b bVar) {
        List list = f2079b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // E0.InterfaceC0329o
    public InterfaceC0329o.a a(int i7, int i8, int i9) {
        return p().d(this.f2080a.obtainMessage(i7, i8, i9), this);
    }

    @Override // E0.InterfaceC0329o
    public boolean b(int i7, int i8) {
        return this.f2080a.sendEmptyMessageDelayed(i7, i8);
    }

    @Override // E0.InterfaceC0329o
    public boolean c(Runnable runnable) {
        return this.f2080a.post(runnable);
    }

    @Override // E0.InterfaceC0329o
    public InterfaceC0329o.a d(int i7) {
        return p().d(this.f2080a.obtainMessage(i7), this);
    }

    @Override // E0.InterfaceC0329o
    public boolean e(int i7) {
        j3.o.d(i7 != 0);
        return this.f2080a.hasMessages(i7);
    }

    @Override // E0.InterfaceC0329o
    public boolean f(Runnable runnable, long j7) {
        return this.f2080a.postDelayed(runnable, j7);
    }

    @Override // E0.InterfaceC0329o
    public boolean g(int i7) {
        return this.f2080a.sendEmptyMessage(i7);
    }

    @Override // E0.InterfaceC0329o
    public InterfaceC0329o.a h(int i7, int i8, int i9, Object obj) {
        return p().d(this.f2080a.obtainMessage(i7, i8, i9, obj), this);
    }

    @Override // E0.InterfaceC0329o
    public boolean i(int i7, long j7) {
        return this.f2080a.sendEmptyMessageAtTime(i7, j7);
    }

    @Override // E0.InterfaceC0329o
    public boolean j(InterfaceC0329o.a aVar) {
        return ((b) aVar).c(this.f2080a);
    }

    @Override // E0.InterfaceC0329o
    public void k(int i7) {
        j3.o.d(i7 != 0);
        this.f2080a.removeMessages(i7);
    }

    @Override // E0.InterfaceC0329o
    public InterfaceC0329o.a l(int i7, Object obj) {
        return p().d(this.f2080a.obtainMessage(i7, obj), this);
    }

    @Override // E0.InterfaceC0329o
    public void m(Object obj) {
        this.f2080a.removeCallbacksAndMessages(obj);
    }

    @Override // E0.InterfaceC0329o
    public Looper n() {
        return this.f2080a.getLooper();
    }
}
