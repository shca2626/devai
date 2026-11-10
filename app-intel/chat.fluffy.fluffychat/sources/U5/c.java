package U5;

import M5.m;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final L5.a f8464a;

    /* renamed from: b, reason: collision with root package name */
    public final L5.l f8465b;

    public static final class a implements Iterator, N5.a {

        /* renamed from: l, reason: collision with root package name */
        public Object f8466l;

        /* renamed from: m, reason: collision with root package name */
        public int f8467m = -2;

        public a() {
        }

        private final void a() {
            Object objA;
            if (this.f8467m == -2) {
                objA = c.this.f8464a.d();
            } else {
                L5.l lVar = c.this.f8465b;
                Object obj = this.f8466l;
                m.b(obj);
                objA = lVar.a(obj);
            }
            this.f8466l = objA;
            this.f8467m = objA == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8467m < 0) {
                a();
            }
            return this.f8467m == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f8467m < 0) {
                a();
            }
            if (this.f8467m == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f8466l;
            m.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f8467m = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(L5.a aVar, L5.l lVar) {
        m.e(aVar, "getInitialValue");
        m.e(lVar, "getNextValue");
        this.f8464a = aVar;
        this.f8465b = lVar;
    }

    @Override // U5.d
    public Iterator iterator() {
        return new a();
    }
}
