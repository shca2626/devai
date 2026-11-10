package k3;

import j3.InterfaceC1232f;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.AbstractC1264f;
import k3.H;

/* loaded from: classes.dex */
public abstract class L {

    public static class a extends AbstractC1261c {

        /* renamed from: r, reason: collision with root package name */
        public transient j3.u f18874r;

        public a(Map map, j3.u uVar) {
            super(map);
            this.f18874r = (j3.u) j3.o.q(uVar);
        }

        @Override // k3.AbstractC1262d
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public List s() {
            return (List) this.f18874r.get();
        }

        @Override // k3.AbstractC1264f
        public Map e() {
            return u();
        }

        @Override // k3.AbstractC1264f
        public Set g() {
            return v();
        }
    }

    public static abstract class b extends AbstractCollection {
        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return f().c(entry.getKey(), entry.getValue());
        }

        public abstract J f();

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return f().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f().size();
        }
    }

    public static final class c extends d implements F {
        public c(F f7, H.i iVar) {
            super(f7, iVar);
        }

        @Override // k3.L.d, k3.J
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public List get(Object obj) {
            return m(obj, this.f18875p.get(obj));
        }

        @Override // k3.L.d
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public List m(Object obj, Collection collection) {
            return G.k((List) collection, H.d(this.f18876q, obj));
        }
    }

    public static class d extends AbstractC1264f {

        /* renamed from: p, reason: collision with root package name */
        public final J f18875p;

        /* renamed from: q, reason: collision with root package name */
        public final H.i f18876q;

        public d(J j7, H.i iVar) {
            this.f18875p = (J) j3.o.q(j7);
            this.f18876q = (H.i) j3.o.q(iVar);
        }

        @Override // k3.J
        public void clear() {
            this.f18875p.clear();
        }

        @Override // k3.AbstractC1264f
        public Map e() {
            return H.q(this.f18875p.b(), new H.i() { // from class: k3.M
                @Override // k3.H.i
                public final Object a(Object obj, Object obj2) {
                    return this.f18877a.m(obj, (Collection) obj2);
                }
            });
        }

        @Override // k3.AbstractC1264f
        public Collection f() {
            return new AbstractC1264f.a();
        }

        @Override // k3.AbstractC1264f
        public Set g() {
            return this.f18875p.keySet();
        }

        @Override // k3.J
        public abstract Collection get(Object obj);

        @Override // k3.AbstractC1264f
        public Collection h() {
            return AbstractC1268j.d(this.f18875p.a(), H.b(this.f18876q));
        }

        @Override // k3.AbstractC1264f
        public Iterator i() {
            return E.t(this.f18875p.a().iterator(), H.a(this.f18876q));
        }

        public abstract Collection m(Object obj, Collection collection);

        @Override // k3.J
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // k3.AbstractC1264f, k3.J
        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        @Override // k3.J
        public int size() {
            return this.f18875p.size();
        }
    }

    public static boolean a(J j7, Object obj) {
        if (obj == j7) {
            return true;
        }
        if (obj instanceof J) {
            return j7.b().equals(((J) obj).b());
        }
        return false;
    }

    public static F b(Map map, j3.u uVar) {
        return new a(map, uVar);
    }

    public static F c(F f7, H.i iVar) {
        return new c(f7, iVar);
    }

    public static F d(F f7, InterfaceC1232f interfaceC1232f) {
        j3.o.q(interfaceC1232f);
        return c(f7, H.c(interfaceC1232f));
    }
}
