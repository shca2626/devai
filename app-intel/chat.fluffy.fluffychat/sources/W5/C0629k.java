package W5;

import java.util.concurrent.Future;

/* renamed from: W5.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0629k implements InterfaceC0631l {

    /* renamed from: a, reason: collision with root package name */
    public final Future f9158a;

    public C0629k(Future future) {
        this.f9158a = future;
    }

    @Override // W5.InterfaceC0631l
    public void a(Throwable th) {
        this.f9158a.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f9158a + ']';
    }
}
