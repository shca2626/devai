package A5;

import M5.m;
import java.util.Collection;
import java.util.Iterator;
import z5.AbstractC1870d;

/* loaded from: classes.dex */
public final class g extends AbstractC1870d implements Collection, N5.b {

    /* renamed from: l, reason: collision with root package name */
    public final d f312l;

    public g(d dVar) {
        m.e(dVar, "backing");
        this.f312l = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f312l.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f312l.containsValue(obj);
    }

    @Override // z5.AbstractC1870d
    public int f() {
        return this.f312l.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f312l.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f312l.O();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f312l.M(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        this.f312l.l();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        this.f312l.l();
        return super.retainAll(collection);
    }
}
