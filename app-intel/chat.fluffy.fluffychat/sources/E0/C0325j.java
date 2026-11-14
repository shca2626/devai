package E0;

/* renamed from: E0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0325j {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0322g f2167a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2168b;

    public C0325j() {
        this(InterfaceC0322g.f2159a);
    }

    public synchronized void a() {
        while (!this.f2168b) {
            this.f2167a.d();
            wait();
        }
    }

    public synchronized void b() {
        boolean z7 = false;
        while (!this.f2168b) {
            try {
                this.f2167a.d();
                wait();
            } catch (InterruptedException unused) {
                z7 = true;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c(long j7) {
        if (j7 <= 0) {
            return this.f2168b;
        }
        long jE = this.f2167a.e();
        long j8 = j7 + jE;
        if (j8 < jE) {
            b();
        } else {
            boolean z7 = false;
            while (!this.f2168b && jE < j8) {
                try {
                    this.f2167a.d();
                    wait(j8 - jE);
                } catch (InterruptedException unused) {
                    z7 = true;
                }
                jE = this.f2167a.e();
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
        }
        return this.f2168b;
    }

    public synchronized boolean d() {
        boolean z7;
        z7 = this.f2168b;
        this.f2168b = false;
        return z7;
    }

    public synchronized boolean e() {
        return this.f2168b;
    }

    public synchronized boolean f() {
        if (this.f2168b) {
            return false;
        }
        this.f2168b = true;
        notifyAll();
        return true;
    }

    public C0325j(InterfaceC0322g interfaceC0322g) {
        this.f2167a = interfaceC0322g;
    }
}
