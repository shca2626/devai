package f2;

import M5.m;
import Z5.d;
import android.app.Activity;
import e2.C1031a;
import g2.InterfaceC1101f;
import java.util.concurrent.Executor;

/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1051a implements InterfaceC1101f {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1101f f15714b;

    /* renamed from: c, reason: collision with root package name */
    public final C1031a f15715c;

    public C1051a(InterfaceC1101f interfaceC1101f, C1031a c1031a) {
        this.f15714b = interfaceC1101f;
        this.f15715c = c1031a;
    }

    @Override // g2.InterfaceC1101f
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
    public C1051a(InterfaceC1101f interfaceC1101f) {
        this(interfaceC1101f, new C1031a());
        m.e(interfaceC1101f, "tracker");
    }
}
