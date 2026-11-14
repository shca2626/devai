package D0;

import j3.InterfaceC1231f;
import java.util.List;
import k3.AbstractC1278v;
import k3.U;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final U f1588c = U.d().f(new InterfaceC1231f() { // from class: D0.b
        @Override // j3.InterfaceC1231f
        public final Object apply(Object obj) {
            return Integer.valueOf(((a) obj).f1569r);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public static final c f1589d = new c(AbstractC1278v.v(), 0);

    /* renamed from: e, reason: collision with root package name */
    public static final String f1590e = E0.U.A0(0);

    /* renamed from: f, reason: collision with root package name */
    public static final String f1591f = E0.U.A0(1);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1278v f1592a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1593b;

    public c(List list, long j7) {
        this.f1592a = AbstractC1278v.C(f1588c, list);
        this.f1593b = j7;
    }
}
