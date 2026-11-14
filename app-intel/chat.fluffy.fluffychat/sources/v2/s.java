package v2;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0809n;

/* loaded from: classes.dex */
public abstract class s implements DefaultLifecycleObserver {
    public /* synthetic */ s(M5.g gVar) {
        this();
    }

    public abstract void b();

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC0809n interfaceC0809n) {
        M5.m.e(interfaceC0809n, "owner");
        b();
    }

    public s() {
    }

    public void a() {
    }
}
