package U5;

import M5.m;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f8457a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8458b;

    /* renamed from: c, reason: collision with root package name */
    public final L5.l f8459c;

    public static final class a implements Iterator, N5.a {

        /* renamed from: l, reason: collision with root package name */
        public final Iterator f8460l;

        /* renamed from: m, reason: collision with root package name */
        public int f8461m = -1;

        /* renamed from: n, reason: collision with root package name */
        public Object f8462n;

        public a() {
            this.f8460l = b.this.f8457a.iterator();
        }

        public final void a() {
            while (this.f8460l.hasNext()) {
                Object next = this.f8460l.next();
                if (((Boolean) b.this.f8459c.a(next)).booleanValue() == b.this.f8458b) {
                    this.f8462n = next;
                    this.f8461m = 1;
                    return;
                }
            }
            this.f8461m = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8461m == -1) {
                a();
            }
            return this.f8461m == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f8461m == -1) {
                a();
            }
            if (this.f8461m == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f8462n;
            this.f8462n = null;
            this.f8461m = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(d dVar, boolean z7, L5.l lVar) {
        m.e(dVar, "sequence");
        m.e(lVar, "predicate");
        this.f8457a = dVar;
        this.f8458b = z7;
        this.f8459c = lVar;
    }

    @Override // U5.d
    public Iterator iterator() {
        return new a();
    }
}
