package s;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: s.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1597b implements Iterable {

    /* renamed from: l, reason: collision with root package name */
    public c f22338l;

    /* renamed from: m, reason: collision with root package name */
    public c f22339m;

    /* renamed from: n, reason: collision with root package name */
    public final WeakHashMap f22340n = new WeakHashMap();

    /* renamed from: o, reason: collision with root package name */
    public int f22341o = 0;

    /* renamed from: s.b$a */
    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // s.C1597b.e
        public c b(c cVar) {
            return cVar.f22345o;
        }

        @Override // s.C1597b.e
        public c c(c cVar) {
            return cVar.f22344n;
        }
    }

    /* renamed from: s.b$b, reason: collision with other inner class name */
    public static class C0265b extends e {
        public C0265b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // s.C1597b.e
        public c b(c cVar) {
            return cVar.f22344n;
        }

        @Override // s.C1597b.e
        public c c(c cVar) {
            return cVar.f22345o;
        }
    }

    /* renamed from: s.b$c */
    public static class c implements Map.Entry {

        /* renamed from: l, reason: collision with root package name */
        public final Object f22342l;

        /* renamed from: m, reason: collision with root package name */
        public final Object f22343m;

        /* renamed from: n, reason: collision with root package name */
        public c f22344n;

        /* renamed from: o, reason: collision with root package name */
        public c f22345o;

        public c(Object obj, Object obj2) {
            this.f22342l = obj;
            this.f22343m = obj2;
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
            return this.f22342l.equals(cVar.f22342l) && this.f22343m.equals(cVar.f22343m);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f22342l;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f22343m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f22342l.hashCode() ^ this.f22343m.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f22342l + "=" + this.f22343m;
        }
    }

    /* renamed from: s.b$d */
    public class d extends f implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public c f22346l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f22347m = true;

        public d() {
        }

        @Override // s.C1597b.f
        public void a(c cVar) {
            c cVar2 = this.f22346l;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f22345o;
                this.f22346l = cVar3;
                this.f22347m = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f22347m) {
                this.f22347m = false;
                this.f22346l = C1597b.this.f22338l;
            } else {
                c cVar = this.f22346l;
                this.f22346l = cVar != null ? cVar.f22344n : null;
            }
            return this.f22346l;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22347m) {
                return C1597b.this.f22338l != null;
            }
            c cVar = this.f22346l;
            return (cVar == null || cVar.f22344n == null) ? false : true;
        }
    }

    /* renamed from: s.b$e */
    public static abstract class e extends f implements Iterator {

        /* renamed from: l, reason: collision with root package name */
        public c f22349l;

        /* renamed from: m, reason: collision with root package name */
        public c f22350m;

        public e(c cVar, c cVar2) {
            this.f22349l = cVar2;
            this.f22350m = cVar;
        }

        @Override // s.C1597b.f
        public void a(c cVar) {
            if (this.f22349l == cVar && cVar == this.f22350m) {
                this.f22350m = null;
                this.f22349l = null;
            }
            c cVar2 = this.f22349l;
            if (cVar2 == cVar) {
                this.f22349l = b(cVar2);
            }
            if (this.f22350m == cVar) {
                this.f22350m = e();
            }
        }

        public abstract c b(c cVar);

        public abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f22350m;
            this.f22350m = e();
            return cVar;
        }

        public final c e() {
            c cVar = this.f22350m;
            c cVar2 = this.f22349l;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22350m != null;
        }
    }

    /* renamed from: s.b$f */
    public static abstract class f {
        public abstract void a(c cVar);
    }

    public Iterator descendingIterator() {
        C0265b c0265b = new C0265b(this.f22339m, this.f22338l);
        this.f22340n.put(c0265b, Boolean.FALSE);
        return c0265b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1597b)) {
            return false;
        }
        C1597b c1597b = (C1597b) obj;
        if (size() != c1597b.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c1597b.iterator();
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
        return this.f22338l;
    }

    public c g(Object obj) {
        c cVar = this.f22338l;
        while (cVar != null && !cVar.f22342l.equals(obj)) {
            cVar = cVar.f22344n;
        }
        return cVar;
    }

    public d h() {
        d dVar = new d();
        this.f22340n.put(dVar, Boolean.FALSE);
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
        return this.f22339m;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f22338l, this.f22339m);
        this.f22340n.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public c j(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f22341o++;
        c cVar2 = this.f22339m;
        if (cVar2 == null) {
            this.f22338l = cVar;
            this.f22339m = cVar;
            return cVar;
        }
        cVar2.f22344n = cVar;
        cVar.f22345o = cVar2;
        this.f22339m = cVar;
        return cVar;
    }

    public Object k(Object obj, Object obj2) {
        c cVarG = g(obj);
        if (cVarG != null) {
            return cVarG.f22343m;
        }
        j(obj, obj2);
        return null;
    }

    public Object l(Object obj) {
        c cVarG = g(obj);
        if (cVarG == null) {
            return null;
        }
        this.f22341o--;
        if (!this.f22340n.isEmpty()) {
            Iterator it = this.f22340n.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarG);
            }
        }
        c cVar = cVarG.f22345o;
        if (cVar != null) {
            cVar.f22344n = cVarG.f22344n;
        } else {
            this.f22338l = cVarG.f22344n;
        }
        c cVar2 = cVarG.f22344n;
        if (cVar2 != null) {
            cVar2.f22345o = cVar;
        } else {
            this.f22339m = cVar;
        }
        cVarG.f22344n = null;
        cVarG.f22345o = null;
        return cVarG.f22343m;
    }

    public int size() {
        return this.f22341o;
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
