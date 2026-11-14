package androidx.lifecycle;

/* loaded from: classes.dex */
public interface DefaultLifecycleObserver extends InterfaceC0808m {
    default void onCreate(InterfaceC0809n interfaceC0809n) {
        M5.m.e(interfaceC0809n, "owner");
    }

    default void onDestroy(InterfaceC0809n interfaceC0809n) {
        M5.m.e(interfaceC0809n, "owner");
    }

    default void onPause(InterfaceC0809n interfaceC0809n) {
        M5.m.e(interfaceC0809n, "owner");
    }

    default void onResume(InterfaceC0809n interfaceC0809n) {
        M5.m.e(interfaceC0809n, "owner");
    }

    default void onStart(InterfaceC0809n interfaceC0809n) {
        M5.m.e(interfaceC0809n, "owner");
    }

    default void onStop(InterfaceC0809n interfaceC0809n) {
        M5.m.e(interfaceC0809n, "owner");
    }
}
