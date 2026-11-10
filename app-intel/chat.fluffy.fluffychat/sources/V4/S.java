package V4;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class S {

    /* renamed from: c, reason: collision with root package name */
    public static S f8731c;

    /* renamed from: a, reason: collision with root package name */
    public final LongSparseArray f8732a = new LongSparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final PriorityQueue f8733b = new PriorityQueue();

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final AtomicLong f8734b = new AtomicLong(0);

        /* renamed from: a, reason: collision with root package name */
        public final long f8735a;

        public a(long j7) {
            this.f8735a = j7;
        }

        public static a b() {
            return c(f8734b.incrementAndGet());
        }

        public static a c(long j7) {
            return new a(j7);
        }

        public long d() {
            return this.f8735a;
        }
    }

    public static S a() {
        if (f8731c == null) {
            f8731c = new S();
        }
        return f8731c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f8733b.isEmpty() && ((Long) this.f8733b.peek()).longValue() < aVar.f8735a) {
            this.f8732a.remove(((Long) this.f8733b.poll()).longValue());
        }
        if (!this.f8733b.isEmpty() && ((Long) this.f8733b.peek()).longValue() == aVar.f8735a) {
            this.f8733b.poll();
        }
        MotionEvent motionEvent = (MotionEvent) this.f8732a.get(aVar.f8735a);
        this.f8732a.remove(aVar.f8735a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a aVarB = a.b();
        this.f8732a.put(aVarB.f8735a, MotionEvent.obtain(motionEvent));
        this.f8733b.add(Long.valueOf(aVarB.f8735a));
        return aVarB;
    }
}
