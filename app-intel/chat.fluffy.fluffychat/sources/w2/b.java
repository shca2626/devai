package w2;

import M5.m;
import k6.A;

/* loaded from: classes.dex */
public final class b extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final A f23294l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(A a7) {
        super("HTTP " + a7.f() + ": " + ((Object) a7.t()));
        m.e(a7, "response");
        this.f23294l = a7;
    }
}
