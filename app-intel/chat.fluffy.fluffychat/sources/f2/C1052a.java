package f2;

import M5.m;
import Z5.d;
import android.app.Activity;
import e2.C1032a;
import g2.InterfaceC1102f;
import java.util.concurrent.Executor;

/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1052a implements InterfaceC1102f {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1102f f15714b;

    /* renamed from: c, reason: collision with root package name */
    public final C1032a f15715c;

    public C1052a(InterfaceC1102f interfaceC1102f, C1032a c1032a) {
        this.f15714b = interfaceC1102f;
        this.f15715c = c1032a;
    }

    @Override // g2.InterfaceC1102f
    public d a(Activity activity) {
        m.e(activity, "activity");
        return this.f15714b.a(activity);
    }

    public final void b(Activity activity, Executor executor, Y.a aVar) {
        m.e(activity, "activity");
        m.e(executor, "executor");
        m.e(aVar, "consumer");
        this.f15715c.a(executor, aVar, this.f15714b.a(activity));
    }

    public final void c(Y.a aVar) {
        m.e(aVar, "consumer");
        this.f15715c.b(aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1052a(InterfaceC1102f interfaceC1102f) {
        this(interfaceC1102f, new C1032a());
        m.e(interfaceC1102f, "tracker");
    }
}
