package l6;

/* loaded from: classes3.dex */
public abstract class b implements Runnable {

    /* renamed from: l, reason: collision with root package name */
    public final String f19668l;

    public b(String str, Object... objArr) {
        this.f19668l = c.p(str, objArr);
    }

    public abstract void k();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f19668l);
        try {
            k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
