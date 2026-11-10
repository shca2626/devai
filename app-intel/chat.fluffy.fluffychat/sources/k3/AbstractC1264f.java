package k3;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k3.L;

/* renamed from: k3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1264f implements J {

    /* renamed from: l, reason: collision with root package name */
    public transient Collection f18970l;

    /* renamed from: m, reason: collision with root package name */
    public transient Set f18971m;

    /* renamed from: n, reason: collision with root package name */
    public transient Collection f18972n;

    /* renamed from: o, reason: collision with root package name */
    public transient Map f18973o;

    /* renamed from: k3.f$a */
    public class a extends L.b {
        public a() {
        }

        @Override // k3.L.b
        public J f() {
            return AbstractC1264f.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC1264f.this.i();
        }
    }

    /* renamed from: k3.f$b */
    public class b extends AbstractCollection {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC1264f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC1264f.this.d(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC1264f.this.k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractC1264f.this.size();
        }
    }

    @Override // k3.J
    public Collection a() {
        Collection collection = this.f18970l;
        if (collection != null) {
            return collection;
        }
        Collection collectionF = f();
        this.f18970l = collectionF;
        return collectionF;
    }

    @Override // k3.J
    public Map b() {
        Map map = this.f18973o;
        if (map != null) {
            return map;
        }
        Map mapE = e();
        this.f18973o = mapE;
        return mapE;
    }

    @Override // k3.J
    public boolean c(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean d(Object obj) {
        Iterator it = b().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map e();

    public boolean equals(Object obj) {
        return L.a(this, obj);
    }

    public abstract Collection f();

    public abstract Set g();

    public abstract Collection h();

    public int hashCode() {
        return b().hashCode();
    }

    public abstract Iterator i();

    public boolean j() {
        return size() == 0;
    }

    public Iterator k() {
        return H.u(a().iterator());
    }

    @Override // k3.J
    public Set keySet() {
        Set set = this.f18971m;
        if (set != null) {
            return set;
        }
        Set setG = g();
        this.f18971m = setG;
        return setG;
    }

    @Override // k3.J
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return b().toString();
    }

    @Override // k3.J
    public Collection values() {
        Collection collection = this.f18972n;
        if (collection != null) {
            return collection;
        }
        Collection collectionH = h();
        this.f18972n = collectionH;
        return collectionH;
    }
}
