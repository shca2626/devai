package Y5;

import W5.InterfaceC0632m;
import b6.AbstractC0855H;
import b6.C0852E;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final m f9895a = new m(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f9896b = AbstractC0855H.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f9897c = AbstractC0855H.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* renamed from: d, reason: collision with root package name */
    public static final C0852E f9898d = new C0852E("BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    public static final C0852E f9899e = new C0852E("SHOULD_BUFFER");

    /* renamed from: f, reason: collision with root package name */
    public static final C0852E f9900f = new C0852E("S_RESUMING_BY_RCV");

    /* renamed from: g, reason: collision with root package name */
    public static final C0852E f9901g = new C0852E("RESUMING_BY_EB");

    /* renamed from: h, reason: collision with root package name */
    public static final C0852E f9902h = new C0852E("POISONED");

    /* renamed from: i, reason: collision with root package name */
    public static final C0852E f9903i = new C0852E("DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    public static final C0852E f9904j = new C0852E("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final C0852E f9905k = new C0852E("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final C0852E f9906l = new C0852E("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    public static final C0852E f9907m = new C0852E("SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    public static final C0852E f9908n = new C0852E("SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    public static final C0852E f9909o = new C0852E("FAILED");

    /* renamed from: p, reason: collision with root package name */
    public static final C0852E f9910p = new C0852E("NO_RECEIVE_RESULT");

    /* renamed from: q, reason: collision with root package name */
    public static final C0852E f9911q = new C0852E("CLOSE_HANDLER_CLOSED");

    /* renamed from: r, reason: collision with root package name */
    public static final C0852E f9912r = new C0852E("CLOSE_HANDLER_INVOKED");

    /* renamed from: s, reason: collision with root package name */
    public static final C0852E f9913s = new C0852E("NO_CLOSE_CAUSE");

    public static final /* synthetic */ class a extends M5.k implements L5.p {

        /* renamed from: u, reason: collision with root package name */
        public static final a f9914u = new a();

        public a() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final m m(long j7, m mVar) {
            return f.x(j7, mVar);
        }

        @Override // L5.p
        public /* bridge */ /* synthetic */ Object n(Object obj, Object obj2) {
            return m(((Number) obj).longValue(), (m) obj2);
        }
    }

    public static final long A(int i7) {
        if (i7 == 0) {
            return 0L;
        }
        if (i7 != Integer.MAX_VALUE) {
            return i7;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean B(InterfaceC0632m interfaceC0632m, Object obj, L5.q qVar) {
        Object objS = interfaceC0632m.s(obj, null, qVar);
        if (objS == null) {
            return false;
        }
        interfaceC0632m.z(objS);
        return true;
    }

    public static /* synthetic */ boolean C(InterfaceC0632m interfaceC0632m, Object obj, L5.q qVar, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            qVar = null;
        }
        return B(interfaceC0632m, obj, qVar);
    }

    public static final long v(long j7, boolean z7) {
        return (z7 ? 4611686018427387904L : 0L) + j7;
    }

    public static final long w(long j7, int i7) {
        return (i7 << 60) + j7;
    }

    public static final m x(long j7, m mVar) {
        return new m(j7, mVar, mVar.y(), 0);
    }

    public static final T5.e y() {
        return a.f9914u;
    }

    public static final C0852E z() {
        return f9906l;
    }
}
