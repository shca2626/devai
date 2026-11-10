package F0;

import E0.E;
import E0.U;
import j3.o;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final b f2588a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f2589b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f2590c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final PriorityQueue f2591d = new PriorityQueue();

    /* renamed from: e, reason: collision with root package name */
    public int f2592e = -1;

    /* renamed from: f, reason: collision with root package name */
    public a f2593f;

    public static final class a implements Comparable {

        /* renamed from: m, reason: collision with root package name */
        public long f2595m = -9223372036854775807L;

        /* renamed from: l, reason: collision with root package name */
        public final List f2594l = new ArrayList();

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Long.compare(this.f2595m, aVar.f2595m);
        }

        public void d(long j7, E e7) {
            o.d(j7 != -9223372036854775807L);
            o.v(this.f2594l.isEmpty());
            this.f2595m = j7;
            this.f2594l.add(e7);
        }
    }

    public interface b {
        void a(long j7, E e7);
    }

    public k(b bVar) {
        this.f2588a = bVar;
    }

    public void a(long j7, E e7) {
        int i7;
        if (j7 == -9223372036854775807L || (i7 = this.f2592e) == 0 || (i7 != -1 && this.f2591d.size() >= this.f2592e && j7 < ((a) U.i((a) this.f2591d.peek())).f2595m)) {
            this.f2588a.a(j7, e7);
            return;
        }
        E eC = c(e7);
        a aVar = this.f2593f;
        if (aVar != null && j7 == aVar.f2595m) {
            aVar.f2594l.add(eC);
            return;
        }
        a aVar2 = this.f2590c.isEmpty() ? new a() : (a) this.f2590c.pop();
        aVar2.d(j7, eC);
        this.f2591d.add(aVar2);
        this.f2593f = aVar2;
        int i8 = this.f2592e;
        if (i8 != -1) {
            e(i8);
        }
    }

    public void b() {
        this.f2591d.clear();
    }

    public final E c(E e7) {
        E e8 = this.f2589b.isEmpty() ? new E() : (E) this.f2589b.pop();
        e8.b0(e7.a());
        System.arraycopy(e7.f(), e7.g(), e8.f(), 0, e8.a());
        return e8;
    }

    public void d() {
        e(0);
    }

    public final void e(int i7) {
        while (this.f2591d.size() > i7) {
            a aVar = (a) U.i((a) this.f2591d.poll());
            for (int i8 = 0; i8 < aVar.f2594l.size(); i8++) {
                this.f2588a.a(aVar.f2595m, (E) aVar.f2594l.get(i8));
                this.f2589b.push((E) aVar.f2594l.get(i8));
            }
            aVar.f2594l.clear();
            a aVar2 = this.f2593f;
            if (aVar2 != null && aVar2.f2595m == aVar.f2595m) {
                this.f2593f = null;
            }
            this.f2590c.push(aVar);
        }
    }

    public int f() {
        return this.f2592e;
    }

    public void g(int i7) {
        o.v(i7 >= 0);
        this.f2592e = i7;
        e(i7);
    }
}
