package androidx.lifecycle;

import androidx.lifecycle.AbstractC0804j;
import y5.C1811f;

/* renamed from: androidx.lifecycle.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0799e implements InterfaceC0806l {

    /* renamed from: l, reason: collision with root package name */
    public final DefaultLifecycleObserver f12398l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0806l f12399m;

    /* renamed from: androidx.lifecycle.e$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12400a;

        static {
            int[] iArr = new int[AbstractC0804j.a.values().length];
            try {
                iArr[AbstractC0804j.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0804j.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0804j.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0804j.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0804j.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0804j.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0804j.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f12400a = iArr;
        }
    }

    public C0799e(DefaultLifecycleObserver defaultLifecycleObserver, InterfaceC0806l interfaceC0806l) {
        M5.m.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f12398l = defaultLifecycleObserver;
        this.f12399m = interfaceC0806l;
    }

    @Override // androidx.lifecycle.InterfaceC0806l
    public void d(InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar) {
        M5.m.e(interfaceC0808n, "source");
        M5.m.e(aVar, "event");
        switch (a.f12400a[aVar.ordinal()]) {
            case 1:
                this.f12398l.onCreate(interfaceC0808n);
                break;
            case 2:
                this.f12398l.onStart(interfaceC0808n);
                break;
            case 3:
                this.f12398l.onResume(interfaceC0808n);
                break;
            case 4:
                this.f12398l.onPause(interfaceC0808n);
                break;
            case 5:
                this.f12398l.onStop(interfaceC0808n);
                break;
            case 6:
                this.f12398l.onDestroy(interfaceC0808n);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                throw new C1811f();
        }
        InterfaceC0806l interfaceC0806l = this.f12399m;
        if (interfaceC0806l != null) {
            interfaceC0806l.d(interfaceC0808n, aVar);
        }
    }
}
