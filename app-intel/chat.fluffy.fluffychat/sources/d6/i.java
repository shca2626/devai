package d6;

import W5.Q;

/* loaded from: classes.dex */
public final class i extends h {

    /* renamed from: n, reason: collision with root package name */
    public final Runnable f15276n;

    public i(Runnable runnable, long j7, boolean z7) {
        super(j7, z7);
        this.f15276n = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15276n.run();
    }

    public String toString() {
        return "Task[" + Q.a(this.f15276n) + '@' + Q.b(this.f15276n) + ", " + this.f15274l + ", " + j.c(this.f15275m) + ']';
    }
}
