package k3;

import j3.AbstractC1237k;
import j3.InterfaceC1232f;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class G {

    public static class a extends AbstractList implements RandomAccess, Serializable {

        /* renamed from: l, reason: collision with root package name */
        public final List f18846l;

        /* renamed from: m, reason: collision with root package name */
        public final InterfaceC1232f f18847m;

        /* renamed from: k3.G$a$a, reason: collision with other inner class name */
        public class C0213a extends g0 {
            public C0213a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // k3.f0
            public Object a(Object obj) {
                return a.this.f18847m.apply(obj);
            }
        }

        public a(List list, InterfaceC1232f interfaceC1232f) {
            this.f18846l = (List) j3.o.q(list);
            this.f18847m = (InterfaceC1232f) j3.o.q(interfaceC1232f);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i7) {
            return this.f18847m.apply(this.f18846l.get(i7));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f18846l.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i7) {
            return new C0213a(this.f18846l.listIterator(i7));
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i7) {
            return this.f18847m.apply(this.f18846l.remove(i7));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i7, int i8) {
            this.f18846l.subList(i7, i8).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f18846l.size();
        }
    }

    public static class b extends AbstractSequentialList implements Serializable {

        /* renamed from: l, reason: collision with root package name */
        public final List f18849l;

        /* renamed from: m, reason: collision with root package name */
        public final InterfaceC1232f f18850m;

        public class a extends g0 {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // k3.f0
            public Object a(Object obj) {
                return b.this.f18850m.apply(obj);
            }
        }

        public b(List list, InterfaceC1232f interfaceC1232f) {
            this.f18849l = (List) j3.o.q(list);
            this.f18850m = (InterfaceC1232f) j3.o.q(interfaceC1232f);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f18849l.isEmpty();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i7) {
            return new a(this.f18849l.listIterator(i7));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i7, int i8) {
            this.f18849l.subList(i7, i8).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f18849l.size();
        }
    }

    public static List a(Iterable iterable) {
        return (List) iterable;
    }

    public static int b(int i7) {
        AbstractC1267i.b(i7, "arraySize");
        return o3.g.n(i7 + 5 + (i7 / 10));
    }

    public static boolean c(List list, Object obj) {
        if (obj == j3.o.q(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return E.e(list.iterator(), list2.iterator());
        }
        for (int i7 = 0; i7 < size; i7++) {
            if (!AbstractC1237k.a(list.get(i7), list2.get(i7))) {
                return false;
            }
        }
        return true;
    }

    public static int d(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (AbstractC1237k.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int e(List list, Object obj) {
        int size = list.size();
        int i7 = 0;
        if (obj == null) {
            while (i7 < size) {
                if (list.get(i7) == null) {
                    return i7;
                }
                i7++;
            }
            return -1;
        }
        while (i7 < size) {
            if (obj.equals(list.get(i7))) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int f(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (AbstractC1237k.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int g(List list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static ArrayList h() {
        return new ArrayList();
    }

    public static ArrayList i(Iterator it) {
        ArrayList arrayListH = h();
        E.a(arrayListH, it);
        return arrayListH;
    }

    public static ArrayList j(Object... objArr) {
        j3.o.q(objArr);
        ArrayList arrayList = new ArrayList(b(objArr.length));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static List k(List list, InterfaceC1232f interfaceC1232f) {
        return list instanceof RandomAccess ? new a(list, interfaceC1232f) : new b(list, interfaceC1232f);
    }
}
