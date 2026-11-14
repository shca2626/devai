package h0;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: h0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1127b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f16577a;

    public C1127b(int i7) {
        this.f16577a = new AtomicInteger(i7);
    }

    public final int a() {
        return this.f16577a.decrementAndGet();
    }

    public final int b() {
        return this.f16577a.get();
    }

    public final int c() {
        return this.f16577a.getAndIncrement();
    }

    public final int d() {
        return this.f16577a.incrementAndGet();
    }
}
