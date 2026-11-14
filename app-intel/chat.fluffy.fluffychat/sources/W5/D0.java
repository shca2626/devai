package W5;

import b6.C0853E;

/* loaded from: classes.dex */
public abstract class D0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0853E f9096a = new C0853E("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final C0853E f9097b = new C0853E("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    public static final C0853E f9098c = new C0853E("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    public static final C0853E f9099d = new C0853E("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    public static final C0853E f9100e = new C0853E("SEALED");

    /* renamed from: f, reason: collision with root package name */
    public static final C0620f0 f9101f = new C0620f0(false);

    /* renamed from: g, reason: collision with root package name */
    public static final C0620f0 f9102g = new C0620f0(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC0645s0 ? new C0647t0((InterfaceC0645s0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC0645s0 interfaceC0645s0;
        C0647t0 c0647t0 = obj instanceof C0647t0 ? (C0647t0) obj : null;
        return (c0647t0 == null || (interfaceC0645s0 = c0647t0.f9175a) == null) ? obj : interfaceC0645s0;
    }
}
