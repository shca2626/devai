package d6;

import W5.AbstractC0635n0;

/* loaded from: classes.dex */
public class f extends AbstractC0635n0 {

    /* renamed from: o, reason: collision with root package name */
    public final int f15269o;

    /* renamed from: p, reason: collision with root package name */
    public final int f15270p;

    /* renamed from: q, reason: collision with root package name */
    public final long f15271q;

    /* renamed from: r, reason: collision with root package name */
    public final String f15272r;

    /* renamed from: s, reason: collision with root package name */
    public ExecutorC1001a f15273s;

    public f() {
        this(0, 0, 0L, null, 15, null);
    }

    @Override // W5.J
    public void U(C5.i iVar, Runnable runnable) {
        ExecutorC1001a.o(this.f15273s, runnable, false, false, 6, null);
    }

    public final ExecutorC1001a Y() {
        return new ExecutorC1001a(this.f15269o, this.f15270p, this.f15271q, this.f15272r);
    }

    public final void Z(Runnable runnable, boolean z7, boolean z8) {
        this.f15273s.n(runnable, z7, z8);
    }

    public void close() throws InterruptedException {
        this.f15273s.close();
    }

    public f(int i7, int i8, long j7, String str) {
        this.f15269o = i7;
        this.f15270p = i8;
        this.f15271q = j7;
        this.f15272r = str;
        this.f15273s = Y();
    }

    public /* synthetic */ f(int i7, int i8, long j7, String str, int i9, M5.g gVar) {
        this((i9 & 1) != 0 ? j.f15279c : i7, (i9 & 2) != 0 ? j.f15280d : i8, (i9 & 4) != 0 ? j.f15281e : j7, (i9 & 8) != 0 ? "CoroutineScheduler" : str);
    }
}
