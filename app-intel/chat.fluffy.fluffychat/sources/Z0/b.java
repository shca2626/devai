package Z0;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class b implements o {

    /* renamed from: b, reason: collision with root package name */
    public final long f10090b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10091c;

    /* renamed from: d, reason: collision with root package name */
    public long f10092d;

    public b(long j7, long j8) {
        this.f10090b = j7;
        this.f10091c = j8;
        f();
    }

    public final void c() {
        long j7 = this.f10092d;
        if (j7 < this.f10090b || j7 > this.f10091c) {
            throw new NoSuchElementException();
        }
    }

    public final long d() {
        return this.f10092d;
    }

    public boolean e() {
        return this.f10092d > this.f10091c;
    }

    public void f() {
        this.f10092d = this.f10090b - 1;
    }

    @Override // Z0.o
    public boolean next() {
        this.f10092d++;
        return !e();
    }
}
