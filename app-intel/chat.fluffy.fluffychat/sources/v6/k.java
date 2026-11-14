package v6;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class k extends B {

    /* renamed from: f, reason: collision with root package name */
    public B f23200f;

    public k(B b7) {
        M5.m.e(b7, "delegate");
        this.f23200f = b7;
    }

    @Override // v6.B
    public B a() {
        return this.f23200f.a();
    }

    @Override // v6.B
    public B b() {
        return this.f23200f.b();
    }

    @Override // v6.B
    public long c() {
        return this.f23200f.c();
    }

    @Override // v6.B
    public B d(long j7) {
        return this.f23200f.d(j7);
    }

    @Override // v6.B
    public boolean e() {
        return this.f23200f.e();
    }

    @Override // v6.B
    public void f() throws InterruptedIOException {
        this.f23200f.f();
    }

    @Override // v6.B
    public B g(long j7, TimeUnit timeUnit) {
        M5.m.e(timeUnit, "unit");
        return this.f23200f.g(j7, timeUnit);
    }

    public final B i() {
        return this.f23200f;
    }

    public final k j(B b7) {
        M5.m.e(b7, "delegate");
        this.f23200f = b7;
        return this;
    }
}
