package z5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import y5.AbstractC1816l;

/* renamed from: z5.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1892w extends C1891v {

    /* renamed from: z5.w$a */
    public static final class a implements U5.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f24201a;

        public a(Iterable iterable) {
            this.f24201a = iterable;
        }

        @Override // U5.d
        public Iterator iterator() {
            return this.f24201a.iterator();
        }
    }

    public static boolean A(Iterable iterable, Object obj) {
        M5.m.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : H(iterable, obj) >= 0;
    }

    public static List B(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        return X(a0(iterable));
    }

    public static List C(Iterable iterable, int i7) {
        ArrayList arrayList;
        M5.m.e(iterable, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return X(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i7;
            if (size <= 0) {
                return C1884o.i();
            }
            if (size == 1) {
                return C1883n.d(M(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i7 < size2) {
                        arrayList.add(list.get(i7));
                        i7++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i7);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i8 = 0;
        for (Object obj : iterable) {
            if (i8 >= i7) {
                arrayList.add(obj);
            } else {
                i8++;
            }
        }
        return C1884o.m(arrayList);
    }

    public static final Object D(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return E((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object E(List list) {
        M5.m.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object F(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object G(List list) {
        M5.m.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final int H(Iterable iterable, Object obj) {
        M5.m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i7 = 0;
        for (Object obj2 : iterable) {
            if (i7 < 0) {
                C1884o.n();
            }
            if (M5.m.a(obj, obj2)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static final Appendable I(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, L5.l lVar) throws IOException {
        M5.m.e(iterable, "<this>");
        M5.m.e(appendable, "buffer");
        M5.m.e(charSequence, "separator");
        M5.m.e(charSequence2, "prefix");
        M5.m.e(charSequence3, "postfix");
        M5.m.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i8 = 0;
        for (Object obj : iterable) {
            i8++;
            if (i8 > 1) {
                appendable.append(charSequence);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            V5.m.a(appendable, obj, lVar);
        }
        if (i7 >= 0 && i8 > i7) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String K(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, L5.l lVar) {
        M5.m.e(iterable, "<this>");
        M5.m.e(charSequence, "separator");
        M5.m.e(charSequence2, "prefix");
        M5.m.e(charSequence3, "postfix");
        M5.m.e(charSequence4, "truncated");
        return ((StringBuilder) I(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i7, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String L(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, L5.l lVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i8 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i8 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i8 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        L5.l lVar2 = lVar;
        return K(iterable, charSequence, charSequence2, charSequence3, i7, charSequence5, lVar2);
    }

    public static final Object M(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return N((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object N(List list) {
        M5.m.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(C1884o.k(list));
    }

    public static Object O(List list) {
        M5.m.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable P(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List Q(Collection collection, Object obj) {
        M5.m.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object R(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        if (iterable instanceof List) {
            return S((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object S(List list) {
        M5.m.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static List T(Iterable iterable, int i7) {
        M5.m.e(iterable, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return C1884o.i();
        }
        if (iterable instanceof Collection) {
            if (i7 >= ((Collection) iterable).size()) {
                return X(iterable);
            }
            if (i7 == 1) {
                return C1883n.d(D(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i7);
        Iterator it = iterable.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return C1884o.m(arrayList);
    }

    public static final Collection U(Iterable iterable, Collection collection) {
        M5.m.e(iterable, "<this>");
        M5.m.e(collection, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static float[] V(Collection collection) {
        M5.m.e(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            fArr[i7] = ((Number) it.next()).floatValue();
            i7++;
        }
        return fArr;
    }

    public static int[] W(Collection collection) {
        M5.m.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr[i7] = ((Number) it.next()).intValue();
            i7++;
        }
        return iArr;
    }

    public static List X(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return C1884o.m(Y(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C1884o.i();
        }
        if (size != 1) {
            return Z(collection);
        }
        return C1883n.d(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List Y(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        return iterable instanceof Collection ? Z((Collection) iterable) : (List) U(iterable, new ArrayList());
    }

    public static List Z(Collection collection) {
        M5.m.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final Set a0(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) U(iterable, new LinkedHashSet());
    }

    public static Set b0(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return C1868I.f((Set) U(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C1868I.d();
        }
        if (size != 1) {
            return (Set) U(iterable, new LinkedHashSet(C1865F.e(collection.size())));
        }
        return C1867H.c(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static List c0(Iterable iterable, Iterable iterable2) {
        M5.m.e(iterable, "<this>");
        M5.m.e(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(C1885p.o(iterable, 10), C1885p.o(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(AbstractC1816l.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static U5.d z(Iterable iterable) {
        M5.m.e(iterable, "<this>");
        return new a(iterable);
    }
}
