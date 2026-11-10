package A5;

import M5.m;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import z5.AbstractC1872f;

/* loaded from: classes.dex */
public final class h extends AbstractC1872f implements Set, Serializable, N5.b {

    /* renamed from: m, reason: collision with root package name */
    public static final a f313m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public static final h f314n = new h(d.f288y.e());

    /* renamed from: l, reason: collision with root package name */
    public final d f315l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public h(d dVar) {
        m.e(dVar, "backing");
        this.f315l = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.f315l.i(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        this.f315l.l();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f315l.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f315l.containsKey(obj);
    }

    @Override // z5.AbstractC1872f
    public int f() {
        return this.f315l.size();
    }

    public final Set g() {
        this.f315l.k();
        return size() > 0 ? this : f314n;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f315l.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f315l.C();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f315l.L(obj);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        this.f315l.l();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        this.f315l.l();
        return super.retainAll(collection);
    }

    public h() {
        this(new d());
    }
}
