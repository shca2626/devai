package androidx.lifecycle;

/* loaded from: classes.dex */
public interface DefaultLifecycleObserver extends InterfaceC0807m {
    default void onCreate(InterfaceC0808n interfaceC0808n) {
        M5.m.e(interfaceC0808n, "owner");
    }

    default void onDestroy(InterfaceC0808n interfaceC0808n) {
        M5.m.e(interfaceC0808n, "owner");
    }

    default void onPause(InterfaceC0808n interfaceC0808n) {
        M5.m.e(interfaceC0808n, "owner");
    }

    default void onResume(InterfaceC0808n interfaceC0808n) {
        M5.m.e(interfaceC0808n, "owner");
    }

    default void onStart(InterfaceC0808n interfaceC0808n) {
        M5.m.e(interfaceC0808n, "owner");
    }

    default void onStop(InterfaceC0808n interfaceC0808n) {
        M5.m.e(interfaceC0808n, "owner");
    }
}
