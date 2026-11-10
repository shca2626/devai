package v6;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class B {

    /* renamed from: d, reason: collision with root package name */
    public static final b f23156d = new b(null);

    /* renamed from: e, reason: collision with root package name */
    public static final B f23157e = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f23158a;

    /* renamed from: b, reason: collision with root package name */
    public long f23159b;

    /* renamed from: c, reason: collision with root package name */
    public long f23160c;

    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public b() {
        }
    }

    public B a() {
        this.f23158a = false;
        return this;
    }

    public B b() {
        this.f23160c = 0L;
        return this;
    }

    public long c() {
        if (this.f23158a) {
            return this.f23159b;
        }
        throw new IllegalStateException("No deadline");
    }

    public B d(long j7) {
        this.f23158a = true;
        this.f23159b = j7;
        return this;
    }

    public boolean e() {
        return this.f23158a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f23158a && this.f23159b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public B g(long j7, TimeUnit timeUnit) {
        M5.m.e(timeUnit, "unit");
        if (j7 >= 0) {
            this.f23160c = timeUnit.toNanos(j7);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j7).toString());
    }

    public long h() {
        return this.f23160c;
    }

    public static final class a extends B {
        @Override // v6.B
        public B g(long j7, TimeUnit timeUnit) {
            M5.m.e(timeUnit, "unit");
            return this;
        }

        @Override // v6.B
        public void f() {
        }

        @Override // v6.B
        public B d(long j7) {
            return this;
        }
    }
}
