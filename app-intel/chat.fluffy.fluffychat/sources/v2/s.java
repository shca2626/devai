package v2;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0808n;

/* loaded from: classes.dex */
public abstract class s implements DefaultLifecycleObserver {
    public /* synthetic */ s(M5.g gVar) {
        this();
    }

    public abstract void b();

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC0808n interfaceC0808n) {
        M5.m.e(interfaceC0808n, "owner");
        b();
    }

    public s() {
    }

    public void a() {
    }
}
