package W5;

import b6.C0852E;

/* loaded from: classes.dex */
public abstract class D0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0852E f9096a = new C0852E("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final C0852E f9097b = new C0852E("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    public static final C0852E f9098c = new C0852E("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    public static final C0852E f9099d = new C0852E("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    public static final C0852E f9100e = new C0852E("SEALED");

    /* renamed from: f, reason: collision with root package name */
    public static final C0619f0 f9101f = new C0619f0(false);

    /* renamed from: g, reason: collision with root package name */
    public static final C0619f0 f9102g = new C0619f0(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC0644s0 ? new C0646t0((InterfaceC0644s0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC0644s0 interfaceC0644s0;
        C0646t0 c0646t0 = obj instanceof C0646t0 ? (C0646t0) obj : null;
        return (c0646t0 == null || (interfaceC0644s0 = c0646t0.f9175a) == null) ? obj : interfaceC0644s0;
    }
}
