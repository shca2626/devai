package x2;

import androidx.lifecycle.AbstractC0804j;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0807m;
import androidx.lifecycle.InterfaceC0808n;

/* loaded from: classes.dex */
public final class h extends AbstractC0804j {

    /* renamed from: b, reason: collision with root package name */
    public static final h f23489b = new h();

    /* renamed from: c, reason: collision with root package name */
    public static final InterfaceC0808n f23490c = new InterfaceC0808n() { // from class: x2.g
        @Override // androidx.lifecycle.InterfaceC0808n
        public final AbstractC0804j a() {
            return h.e();
        }
    };

    public static final AbstractC0804j e() {
        return f23489b;
    }

    @Override // androidx.lifecycle.AbstractC0804j
    public void a(InterfaceC0807m interfaceC0807m) {
        M5.m.e(interfaceC0807m, "observer");
        if (!(interfaceC0807m instanceof DefaultLifecycleObserver)) {
            throw new IllegalArgumentException((interfaceC0807m + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) interfaceC0807m;
        InterfaceC0808n interfaceC0808n = f23490c;
        defaultLifecycleObserver.onCreate(interfaceC0808n);
        defaultLifecycleObserver.onStart(interfaceC0808n);
        defaultLifecycleObserver.onResume(interfaceC0808n);
    }

    @Override // androidx.lifecycle.AbstractC0804j
    public AbstractC0804j.b b() {
        return AbstractC0804j.b.f12411p;
    }

    @Override // androidx.lifecycle.AbstractC0804j
    public void c(InterfaceC0807m interfaceC0807m) {
        M5.m.e(interfaceC0807m, "observer");
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }
}
