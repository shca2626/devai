package z5;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: z5.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1873g implements Collection, N5.a {

    /* renamed from: l, reason: collision with root package name */
    public final Object[] f24167l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f24168m;

    public C1873g(Object[] objArr, boolean z7) {
        M5.m.e(objArr, "values");
        this.f24167l = objArr;
        this.f24168m = z7;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return C1878l.q(this.f24167l, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        M5.m.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int f() {
        return this.f24167l.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f24167l.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return M5.b.a(this.f24167l);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        M5.m.e(objArr, "array");
        return M5.f.b(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return C1880n.b(this.f24167l, this.f24168m);
    }
}
