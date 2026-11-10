package B0;

import E0.U;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public final Object f366a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final PriorityQueue f367b = new PriorityQueue(10, Collections.reverseOrder());

    /* renamed from: c, reason: collision with root package name */
    public int f368c = Integer.MIN_VALUE;

    public void a(int i7) {
        synchronized (this.f366a) {
            this.f367b.add(Integer.valueOf(i7));
            this.f368c = Math.max(this.f368c, i7);
        }
    }

    public void b(int i7) {
        synchronized (this.f366a) {
            this.f367b.remove(Integer.valueOf(i7));
            this.f368c = this.f367b.isEmpty() ? Integer.MIN_VALUE : ((Integer) U.i((Integer) this.f367b.peek())).intValue();
            this.f366a.notifyAll();
        }
    }
}
