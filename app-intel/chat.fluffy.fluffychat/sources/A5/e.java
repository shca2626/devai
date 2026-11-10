package A5;

import M5.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: l, reason: collision with root package name */
    public final d f310l;

    public e(d dVar) {
        m.e(dVar, "backing");
        this.f310l = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f310l.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        m.e(collection, "elements");
        return this.f310l.n(collection);
    }

    @Override // z5.AbstractC1872f
    public int f() {
        return this.f310l.size();
    }

    @Override // A5.a
    public boolean h(Map.Entry entry) {
        m.e(entry, "element");
        return this.f310l.o(entry);
    }

    @Override // A5.a
    public boolean i(Map.Entry entry) {
        m.e(entry, "element");
        return this.f310l.I(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f310l.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f310l.s();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry entry) {
        m.e(entry, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        this.f310l.l();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        this.f310l.l();
        return super.retainAll(collection);
    }
}
