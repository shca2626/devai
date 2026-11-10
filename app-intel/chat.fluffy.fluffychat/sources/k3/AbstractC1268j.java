package k3;

import j3.InterfaceC1232f;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: k3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1268j {

    /* renamed from: k3.j$a */
    public static class a extends AbstractCollection {

        /* renamed from: l, reason: collision with root package name */
        public final Collection f18979l;

        /* renamed from: m, reason: collision with root package name */
        public final j3.p f18980m;

        public a(Collection collection, j3.p pVar) {
            this.f18979l = collection;
            this.f18980m = pVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            j3.o.d(this.f18980m.apply(obj));
            return this.f18979l.add(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                j3.o.d(this.f18980m.apply(it.next()));
            }
            return this.f18979l.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            D.h(this.f18979l, this.f18980m);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (AbstractC1268j.c(this.f18979l, obj)) {
                return this.f18980m.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            return AbstractC1268j.a(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !D.a(this.f18979l, this.f18980m);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return E.i(this.f18979l.iterator(), this.f18980m);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.f18979l.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            Iterator it = this.f18979l.iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.f18980m.apply(next) && collection.contains(next)) {
                    it.remove();
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Iterator it = this.f18979l.iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.f18980m.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator it = this.f18979l.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (this.f18980m.apply(it.next())) {
                    i7++;
                }
            }
            return i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return G.i(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return G.i(iterator()).toArray(objArr);
        }
    }

    /* renamed from: k3.j$b */
    public static class b extends AbstractCollection {

        /* renamed from: l, reason: collision with root package name */
        public final Collection f18981l;

        /* renamed from: m, reason: collision with root package name */
        public final InterfaceC1232f f18982m;

        public b(Collection collection, InterfaceC1232f interfaceC1232f) {
            this.f18981l = (Collection) j3.o.q(collection);
            this.f18982m = (InterfaceC1232f) j3.o.q(interfaceC1232f);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f18981l.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f18981l.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return E.t(this.f18981l.iterator(), this.f18982m);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f18981l.size();
        }
    }

    public static boolean a(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder b(int i7) {
        AbstractC1267i.b(i7, "size");
        return new StringBuilder((int) Math.min(i7 * 8, 1073741824L));
    }

    public static boolean c(Collection collection, Object obj) {
        j3.o.q(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static Collection d(Collection collection, InterfaceC1232f interfaceC1232f) {
        return new b(collection, interfaceC1232f);
    }
}
