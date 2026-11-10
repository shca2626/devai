package k3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k3.AbstractC1277t;

/* renamed from: k3.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1282y extends AbstractC1265g implements Serializable {

    /* renamed from: p, reason: collision with root package name */
    public final transient AbstractC1281x f19036p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f19037q;

    /* renamed from: k3.y$a */
    public class a extends h0 {

        /* renamed from: l, reason: collision with root package name */
        public final Iterator f19038l;

        /* renamed from: m, reason: collision with root package name */
        public Object f19039m = null;

        /* renamed from: n, reason: collision with root package name */
        public Iterator f19040n = E.f();

        public a() {
            this.f19038l = AbstractC1282y.this.f19036p.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!this.f19040n.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f19038l.next();
                this.f19039m = entry.getKey();
                this.f19040n = ((AbstractC1277t) entry.getValue()).iterator();
            }
            Object obj = this.f19039m;
            Objects.requireNonNull(obj);
            return H.h(obj, this.f19040n.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19040n.hasNext() || this.f19038l.hasNext();
        }
    }

    /* renamed from: k3.y$b */
    public class b extends h0 {

        /* renamed from: l, reason: collision with root package name */
        public Iterator f19042l;

        /* renamed from: m, reason: collision with root package name */
        public Iterator f19043m = E.f();

        public b() {
            this.f19042l = AbstractC1282y.this.f19036p.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19043m.hasNext() || this.f19042l.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f19043m.hasNext()) {
                this.f19043m = ((AbstractC1277t) this.f19042l.next()).iterator();
            }
            return this.f19043m.next();
        }
    }

    /* renamed from: k3.y$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Map f19045a;

        /* renamed from: b, reason: collision with root package name */
        public Comparator f19046b;

        /* renamed from: c, reason: collision with root package name */
        public Comparator f19047c;

        /* renamed from: d, reason: collision with root package name */
        public int f19048d = 4;

        public AbstractC1282y a() {
            Map map = this.f19045a;
            if (map == null) {
                return C1280w.w();
            }
            Collection collectionEntrySet = map.entrySet();
            Comparator comparator = this.f19046b;
            if (comparator != null) {
                collectionEntrySet = U.b(comparator).e().c(collectionEntrySet);
            }
            return C1280w.u(collectionEntrySet, this.f19047c);
        }

        public Map b() {
            Map map = this.f19045a;
            if (map != null) {
                return map;
            }
            Map mapD = V.d();
            this.f19045a = mapD;
            return mapD;
        }

        public AbstractC1277t.b c(int i7) {
            return AbstractC1279v.p(i7);
        }

        public c d(Object obj, Object obj2) {
            AbstractC1267i.a(obj, obj2);
            AbstractC1277t.b bVarC = (AbstractC1277t.b) b().get(obj);
            if (bVarC == null) {
                bVarC = c(this.f19048d);
                b().put(obj, bVarC);
            }
            bVarC.a(obj2);
            return this;
        }
    }

    /* renamed from: k3.y$d */
    public static class d extends AbstractC1277t {

        /* renamed from: m, reason: collision with root package name */
        public final AbstractC1282y f19049m;

        public d(AbstractC1282y abstractC1282y) {
            this.f19049m = abstractC1282y;
        }

        @Override // k3.AbstractC1277t, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f19049m.c(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: l */
        public h0 iterator() {
            return this.f19049m.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f19049m.size();
        }
    }

    /* renamed from: k3.y$e */
    public static final class e extends AbstractC1277t {

        /* renamed from: m, reason: collision with root package name */
        public final transient AbstractC1282y f19050m;

        public e(AbstractC1282y abstractC1282y) {
            this.f19050m = abstractC1282y;
        }

        @Override // k3.AbstractC1277t, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f19050m.d(obj);
        }

        @Override // k3.AbstractC1277t
        public int g(Object[] objArr, int i7) {
            h0 it = this.f19050m.f19036p.values().iterator();
            while (it.hasNext()) {
                i7 = ((AbstractC1277t) it.next()).g(objArr, i7);
            }
            return i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: l */
        public h0 iterator() {
            return this.f19050m.k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f19050m.size();
        }
    }

    public AbstractC1282y(AbstractC1281x abstractC1281x, int i7) {
        this.f19036p = abstractC1281x;
        this.f19037q = i7;
    }

    @Override // k3.AbstractC1264f, k3.J
    public /* bridge */ /* synthetic */ boolean c(Object obj, Object obj2) {
        return super.c(obj, obj2);
    }

    @Override // k3.J
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // k3.AbstractC1264f
    public boolean d(Object obj) {
        return obj != null && super.d(obj);
    }

    @Override // k3.AbstractC1264f
    public Map e() {
        throw new AssertionError("should never be called");
    }

    @Override // k3.AbstractC1264f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // k3.AbstractC1264f
    public Set g() {
        throw new AssertionError("unreachable");
    }

    @Override // k3.AbstractC1264f
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // k3.AbstractC1264f
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // k3.AbstractC1264f, k3.J
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public AbstractC1281x b() {
        return this.f19036p;
    }

    @Override // k3.AbstractC1264f
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC1277t f() {
        return new d(this);
    }

    @Override // k3.AbstractC1264f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public AbstractC1277t h() {
        return new e(this);
    }

    @Override // k3.AbstractC1264f, k3.J
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AbstractC1277t a() {
        return (AbstractC1277t) super.a();
    }

    @Override // k3.AbstractC1264f
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public h0 i() {
        return new a();
    }

    @Override // k3.J
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // k3.AbstractC1264f, k3.J
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public AbstractC1258B keySet() {
        return this.f19036p.keySet();
    }

    @Override // k3.AbstractC1264f
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public h0 k() {
        return new b();
    }

    @Override // k3.AbstractC1264f, k3.J
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // k3.AbstractC1264f, k3.J
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public AbstractC1277t values() {
        return (AbstractC1277t) super.values();
    }

    @Override // k3.J
    public int size() {
        return this.f19037q;
    }

    @Override // k3.AbstractC1264f
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
