package W5;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class B {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9082b = AtomicIntegerFieldUpdater.newUpdater(B.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f9083a;

    public B(Throwable th, boolean z7) {
        this.f9083a = th;
        this._handled$volatile = z7 ? 1 : 0;
    }

    public final boolean a() {
        return f9082b.get(this) == 1;
    }

    public final boolean c() {
        return f9082b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return Q.a(this) + '[' + this.f9083a + ']';
    }

    public /* synthetic */ B(Throwable th, boolean z7, int i7, M5.g gVar) {
        this(th, (i7 & 2) != 0 ? false : z7);
    }
}
