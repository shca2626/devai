package s;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: s.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1596b implements Iterable {

    /* renamed from: l, reason: collision with root package name */
    public c f22344l;

    /* renamed from: m, reason: collision with root package name */
    public c f22345m;

    /* renamed from: n, reason: collision with root package name */
    public final WeakHashMap f22346n = new WeakHashMap();

    /* renamed from: o, reason: collision with root package name */
    public int f22347o = 0;

    /* renamed from: s.b$a */
    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // s.C1596b.e
        public c b(c cVar) {
            return cVar.f22351o;
        }

        @Override // s.C1596b.e
        public c c(c cVar) {
            return cVar.f22350n;
        }
    }

    /* renamed from: s.b$b, reason: collision with other inner class name */
    public static class C0265b extends e {
        public C0265b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // s.C1596b.e
        public c b(c cVar) {
            return cVar.f22350n;
        }

        @Override // s.C1596b.e
        public c c(c cVar) {
            return cVar.f22351o;
        }
    }

    /* renamed from: s.b$c */
    public static class c implements Map.Entry {

        /* renamed from: l, reason: collision with root package name */
        public final Object f22348l;

        /* renamed from: m, reason: collision with root package name */
        public final Object f22349m;

        /* renamed from: n, reason: collision with root package name */
        public c f22350n;

        /* renamed from: o, reason: collision with root package name */
        public c f22351o;

        public c(Object obj, Object obj2) {
            this.f22348l = obj;
            this.f22349m = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f22348l.equals(cVar.f22348l) && this.f22349m.equals(cVar.f22349m);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f22348l;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f22349m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f22348l.hashCode() ^ this.f22349m.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f22348l + "=" + this.f22349m;
        }
    }

    /* renamed from: s.b$d */
    public class d extends f implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public c f22352l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f22353m = true;

        public d() {
        }

        @Override // s.C1596b.f
        public void a(c cVar) {
            c cVar2 = this.f22352l;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f22351o;
                this.f22352l = cVar3;
                this.f22353m = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f22353m) {
                this.f22353m = false;
                this.f22352l = C1596b.this.f22344l;
            } else {
                c cVar = this.f22352l;
                this.f22352l = cVar != null ? cVar.f22350n : null;
            }
            return this.f22352l;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22353m) {
                return C1596b.this.f22344l != null;
            }
            c cVar = this.f22352l;
            return (cVar == null || cVar.f22350n == null) ? false : true;
        }
    }

    /* renamed from: s.b$e */
    public static abstract class e extends f implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public c f22355l;

        /* renamed from: m, reason: collision with root package name */
        public c f22356m;

        public e(c cVar, c cVar2) {
            this.f22355l = cVar2;
            this.f22356m = cVar;
        }

        @Override // s.C1596b.f
        public void a(c cVar) {
            if (this.f22355l == cVar && cVar == this.f22356m) {
                this.f22356m = null;
                this.f22355l = null;
            }
            c cVar2 = this.f22355l;
            if (cVar2 == cVar) {
                this.f22355l = b(cVar2);
            }
            if (this.f22356m == cVar) {
                this.f22356m = e();
            }
        }

        public abstract c b(c cVar);

        public abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f22356m;
            this.f22356m = e();
            return cVar;
        }

        public final c e() {
            c cVar = this.f22356m;
            c cVar2 = this.f22355l;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22356m != null;
        }
    }

    /* renamed from: s.b$f */
    public static abstract class f {
        public abstract void a(c cVar);
    }

    public Iterator descendingIterator() {
        C0265b c0265b = new C0265b(this.f22345m, this.f22344l);
        this.f22346n.put(c0265b, Boolean.FALSE);
        return c0265b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1596b)) {
            return false;
        }
        C1596b c1596b = (C1596b) obj;
        if (size() != c1596b.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c1596b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry f() {
        return this.f22344l;
    }

    public c g(Object obj) {
        c cVar = this.f22344l;
        while (cVar != null && !cVar.f22348l.equals(obj)) {
            cVar = cVar.f22350n;
        }
        return cVar;
    }

    public d h() {
        d dVar = new d();
        this.f22346n.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    public Map.Entry i() {
        return this.f22345m;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f22344l, this.f22345m);
        this.f22346n.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public c j(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f22347o++;
        c cVar2 = this.f22345m;
        if (cVar2 == null) {
            this.f22344l = cVar;
            this.f22345m = cVar;
            return cVar;
        }
        cVar2.f22350n = cVar;
        cVar.f22351o = cVar2;
        this.f22345m = cVar;
        return cVar;
    }

    public Object k(Object obj, Object obj2) {
        c cVarG = g(obj);
        if (cVarG != null) {
            return cVarG.f22349m;
        }
        j(obj, obj2);
        return null;
    }

    public Object l(Object obj) {
        c cVarG = g(obj);
        if (cVarG == null) {
            return null;
        }
        this.f22347o--;
        if (!this.f22346n.isEmpty()) {
            Iterator it = this.f22346n.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarG);
            }
        }
        c cVar = cVarG.f22351o;
        if (cVar != null) {
            cVar.f22350n = cVarG.f22350n;
        } else {
            this.f22344l = cVarG.f22350n;
        }
        c cVar2 = cVarG.f22350n;
        if (cVar2 != null) {
            cVar2.f22351o = cVar;
        } else {
            this.f22345m = cVar;
        }
        cVarG.f22350n = null;
        cVarG.f22351o = null;
        return cVarG.f22349m;
    }

    public int size() {
        return this.f22347o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
