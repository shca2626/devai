package k3;

import j3.AbstractC1236k;
import j3.InterfaceC1231f;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k3.d0;

/* loaded from: classes.dex */
public abstract class H {

    public class a implements InterfaceC1231f {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ i f18851l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Object f18852m;

        public a(i iVar, Object obj) {
            this.f18851l = iVar;
            this.f18852m = obj;
        }

        @Override // j3.InterfaceC1231f
        public Object apply(Object obj) {
            return this.f18851l.a(this.f18852m, obj);
        }
    }

    public class b implements InterfaceC1231f {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ i f18853l;

        public b(i iVar) {
            this.f18853l = iVar;
        }

        @Override // j3.InterfaceC1231f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Map.Entry entry) {
            return this.f18853l.a(entry.getKey(), entry.getValue());
        }
    }

    public class c extends AbstractC1262e {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f18854l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ i f18855m;

        public c(Map.Entry entry, i iVar) {
            this.f18854l = entry;
            this.f18855m = iVar;
        }

        @Override // k3.AbstractC1262e, java.util.Map.Entry
        public Object getKey() {
            return this.f18854l.getKey();
        }

        @Override // k3.AbstractC1262e, java.util.Map.Entry
        public Object getValue() {
            return this.f18855m.a(this.f18854l.getKey(), this.f18854l.getValue());
        }
    }

    public class d implements InterfaceC1231f {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ i f18856l;

        public d(i iVar) {
            this.f18856l = iVar;
        }

        @Override // j3.InterfaceC1231f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry apply(Map.Entry entry) {
            return H.r(this.f18856l, entry);
        }
    }

    public class e extends f0 {
        public e(Iterator it) {
            super(it);
        }

        @Override // k3.f0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    public class f implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1231f f18857a;

        public f(InterfaceC1231f interfaceC1231f) {
            this.f18857a = interfaceC1231f;
        }

        @Override // k3.H.i
        public Object a(Object obj, Object obj2) {
            return this.f18857a.apply(obj2);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class g implements InterfaceC1231f {

        /* renamed from: l, reason: collision with root package name */
        public static final g f18858l = new a("KEY", 0);

        /* renamed from: m, reason: collision with root package name */
        public static final g f18859m = new b("VALUE", 1);

        /* renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ g[] f18860n = a();

        public enum a extends g {
            public a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // j3.InterfaceC1231f
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        public enum b extends g {
            public b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // j3.InterfaceC1231f
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        public g(String str, int i7) {
        }

        public static /* synthetic */ g[] a() {
            return new g[]{f18858l, f18859m};
        }

        public static g valueOf(String str) {
            return (g) Enum.valueOf(g.class, str);
        }

        public static g[] values() {
            return (g[]) f18860n.clone();
        }

        public /* synthetic */ g(String str, int i7, I i8) {
            this(str, i7);
        }
    }

    public static abstract class h extends d0.d {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object objN = H.n(f(), key);
                if (AbstractC1236k.a(objN, entry.getValue()) && (objN != null || f().containsKey(key))) {
                    return true;
                }
            }
            return false;
        }

        public abstract Map f();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return f().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // k3.d0.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) j3.o.q(collection));
            } catch (UnsupportedOperationException unused) {
                return d0.j(this, collection.iterator());
            }
        }

        @Override // k3.d0.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) j3.o.q(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetG = d0.g(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetG.add(((Map.Entry) obj).getKey());
                    }
                }
                return f().keySet().retainAll(hashSetG);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f().size();
        }
    }

    public interface i {
        Object a(Object obj, Object obj2);
    }

    public static abstract class j extends AbstractMap {

        public class a extends h {
            public a() {
            }

            @Override // k3.H.h
            public Map f() {
                return j.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return j.this.a();
            }
        }

        public abstract Iterator a();

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return new a();
        }
    }

    public static class k extends d0.d {

        /* renamed from: l, reason: collision with root package name */
        public final Map f18862l;

        public k(Map map) {
            this.f18862l = (Map) j3.o.q(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f().containsKey(obj);
        }

        public Map f() {
            return this.f18862l;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f().size();
        }
    }

    public static class l extends j {

        /* renamed from: l, reason: collision with root package name */
        public final Map f18863l;

        /* renamed from: m, reason: collision with root package name */
        public final i f18864m;

        public l(Map map, i iVar) {
            this.f18863l = (Map) j3.o.q(map);
            this.f18864m = (i) j3.o.q(iVar);
        }

        @Override // k3.H.j
        public Iterator a() {
            return E.t(this.f18863l.entrySet().iterator(), H.a(this.f18864m));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f18863l.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f18863l.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.f18863l.get(obj);
            if (obj2 != null || this.f18863l.containsKey(obj)) {
                return this.f18864m.a(obj, Q.a(obj2));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.f18863l.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (this.f18863l.containsKey(obj)) {
                return this.f18864m.a(obj, Q.a(this.f18863l.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f18863l.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            return new m(this);
        }
    }

    public static class m extends AbstractCollection {

        /* renamed from: l, reason: collision with root package name */
        public final Map f18865l;

        public m(Map map) {
            this.f18865l = (Map) j3.o.q(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return f().containsValue(obj);
        }

        public final Map f() {
            return this.f18865l;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return H.u(f().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : f().entrySet()) {
                    if (AbstractC1236k.a(obj, entry.getValue())) {
                        f().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) j3.o.q(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = d0.f();
                for (Map.Entry entry : f().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return f().keySet().removeAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) j3.o.q(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = d0.f();
                for (Map.Entry entry : f().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return f().keySet().retainAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f().size();
        }
    }

    public static abstract class n extends AbstractMap {

        /* renamed from: l, reason: collision with root package name */
        public transient Set f18866l;

        /* renamed from: m, reason: collision with root package name */
        public transient Collection f18867m;

        public abstract Set a();

        public Collection b() {
            return new m(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f18866l;
            if (set != null) {
                return set;
            }
            Set setA = a();
            this.f18866l = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.f18867m;
            if (collection != null) {
                return collection;
            }
            Collection collectionB = b();
            this.f18867m = collectionB;
            return collectionB;
        }
    }

    public static InterfaceC1231f a(i iVar) {
        j3.o.q(iVar);
        return new d(iVar);
    }

    public static InterfaceC1231f b(i iVar) {
        j3.o.q(iVar);
        return new b(iVar);
    }

    public static i c(InterfaceC1231f interfaceC1231f) {
        j3.o.q(interfaceC1231f);
        return new f(interfaceC1231f);
    }

    public static InterfaceC1231f d(i iVar, Object obj) {
        j3.o.q(iVar);
        return new a(iVar, obj);
    }

    public static int e(int i7) {
        if (i7 < 3) {
            AbstractC1266i.b(i7, "expectedSize");
            return i7 + 1;
        }
        if (i7 < 1073741824) {
            return (int) Math.ceil(i7 / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean f(Map map, Object obj) {
        return E.d(u(map.entrySet().iterator()), obj);
    }

    public static boolean g(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static Map.Entry h(Object obj, Object obj2) {
        return new C1277u(obj, obj2);
    }

    public static InterfaceC1231f i() {
        return g.f18858l;
    }

    public static HashMap j() {
        return new HashMap();
    }

    public static HashMap k(int i7) {
        return new HashMap(e(i7));
    }

    public static IdentityHashMap l() {
        return new IdentityHashMap();
    }

    public static boolean m(Map map, Object obj) {
        j3.o.q(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static Object n(Map map, Object obj) {
        j3.o.q(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static Object o(Map map, Object obj) {
        j3.o.q(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String p(Map map) {
        StringBuilder sbB = AbstractC1267j.b(map.size());
        sbB.append('{');
        boolean z7 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z7) {
                sbB.append(", ");
            }
            sbB.append(entry.getKey());
            sbB.append('=');
            sbB.append(entry.getValue());
            z7 = false;
        }
        sbB.append('}');
        return sbB.toString();
    }

    public static Map q(Map map, i iVar) {
        return new l(map, iVar);
    }

    public static Map.Entry r(i iVar, Map.Entry entry) {
        j3.o.q(iVar);
        j3.o.q(entry);
        return new c(entry, iVar);
    }

    public static Map s(Map map, InterfaceC1231f interfaceC1231f) {
        return q(map, c(interfaceC1231f));
    }

    public static InterfaceC1231f t() {
        return g.f18859m;
    }

    public static Iterator u(Iterator it) {
        return new e(it);
    }
}
