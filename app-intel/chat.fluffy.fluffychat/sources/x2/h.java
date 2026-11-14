package x2;

import androidx.lifecycle.AbstractC0805j;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0808m;
import androidx.lifecycle.InterfaceC0809n;

/* loaded from: classes.dex */
public final class h extends AbstractC0805j {

    /* renamed from: b, reason: collision with root package name */
    public static final h f23495b = new h();

    /* renamed from: c, reason: collision with root package name */
    public static final InterfaceC0809n f23496c = new InterfaceC0809n() { // from class: x2.g
        @Override // androidx.lifecycle.InterfaceC0809n
        public final AbstractC0805j a() {
            return h.e();
        }
    };

    public static final AbstractC0805j e() {
        return f23495b;
    }

    @Override // androidx.lifecycle.AbstractC0805j
    public void a(InterfaceC0808m interfaceC0808m) {
        M5.m.e(interfaceC0808m, "observer");
        if (!(interfaceC0808m instanceof DefaultLifecycleObserver)) {
            throw new IllegalArgumentException((interfaceC0808m + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) interfaceC0808m;
        InterfaceC0809n interfaceC0809n = f23496c;
        defaultLifecycleObserver.onCreate(interfaceC0809n);
        defaultLifecycleObserver.onStart(interfaceC0809n);
        defaultLifecycleObserver.onResume(interfaceC0809n);
    }

    @Override // androidx.lifecycle.AbstractC0805j
    public AbstractC0805j.b b() {
        return AbstractC0805j.b.f12411p;
    }

    @Override // androidx.lifecycle.AbstractC0805j
    public void c(InterfaceC0808m interfaceC0808m) {
        M5.m.e(interfaceC0808m, "observer");
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }
}
