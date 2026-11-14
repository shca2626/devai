package androidx.lifecycle;

import androidx.lifecycle.AbstractC0805j;
import y5.C1810f;

/* renamed from: androidx.lifecycle.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0800e implements InterfaceC0807l {

    /* renamed from: l, reason: collision with root package name */
    public final DefaultLifecycleObserver f12398l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0807l f12399m;

    /* renamed from: androidx.lifecycle.e$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12400a;

        static {
            int[] iArr = new int[AbstractC0805j.a.values().length];
            try {
                iArr[AbstractC0805j.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0805j.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0805j.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0805j.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0805j.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0805j.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0805j.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f12400a = iArr;
        }
    }

    public C0800e(DefaultLifecycleObserver defaultLifecycleObserver, InterfaceC0807l interfaceC0807l) {
        M5.m.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f12398l = defaultLifecycleObserver;
        this.f12399m = interfaceC0807l;
    }

    @Override // androidx.lifecycle.InterfaceC0807l
    public void d(InterfaceC0809n interfaceC0809n, AbstractC0805j.a aVar) {
        M5.m.e(interfaceC0809n, "source");
        M5.m.e(aVar, "event");
        switch (a.f12400a[aVar.ordinal()]) {
            case 1:
                this.f12398l.onCreate(interfaceC0809n);
                break;
            case 2:
                this.f12398l.onStart(interfaceC0809n);
                break;
            case 3:
                this.f12398l.onResume(interfaceC0809n);
                break;
            case 4:
                this.f12398l.onPause(interfaceC0809n);
                break;
            case 5:
                this.f12398l.onStop(interfaceC0809n);
                break;
            case 6:
                this.f12398l.onDestroy(interfaceC0809n);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                throw new C1810f();
        }
        InterfaceC0807l interfaceC0807l = this.f12399m;
        if (interfaceC0807l != null) {
            interfaceC0807l.d(interfaceC0809n, aVar);
        }
    }
}
