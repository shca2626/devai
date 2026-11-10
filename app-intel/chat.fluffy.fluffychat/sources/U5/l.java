package U5;

import M5.m;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f8472a;

    /* renamed from: b, reason: collision with root package name */
    public final L5.l f8473b;

    public static final class a implements Iterator, N5.a {

        /* renamed from: l, reason: collision with root package name */
        public final Iterator f8474l;

        public a() {
            this.f8474l = l.this.f8472a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8474l.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return l.this.f8473b.a(this.f8474l.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public l(d dVar, L5.l lVar) {
        m.e(dVar, "sequence");
        m.e(lVar, "transformer");
        this.f8472a = dVar;
        this.f8473b = lVar;
    }

    @Override // U5.d
    public Iterator iterator() {
        return new a();
    }
}
