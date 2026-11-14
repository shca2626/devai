package k3;

import j3.AbstractC1236k;
import j3.InterfaceC1231f;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class E {

    public class a extends AbstractC1259b {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Iterator f18836n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ j3.p f18837o;

        public a(Iterator it, j3.p pVar) {
            this.f18836n = it;
            this.f18837o = pVar;
        }

        @Override // k3.AbstractC1259b
        public Object a() {
            while (this.f18836n.hasNext()) {
                Object next = this.f18836n.next();
                if (this.f18837o.apply(next)) {
                    return next;
                }
            }
            return b();
        }
    }

    public class b extends f0 {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1231f f18838m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Iterator it, InterfaceC1231f interfaceC1231f) {
            super(it);
            this.f18838m = interfaceC1231f;
        }

        @Override // k3.f0
        public Object a(Object obj) {
            return this.f18838m.apply(obj);
        }
    }

    public static final class c extends AbstractC1258a {

        /* renamed from: o, reason: collision with root package name */
        public static final i0 f18839o = new c(new Object[0], 0);

        /* renamed from: n, reason: collision with root package name */
        public final Object[] f18840n;

        public c(Object[] objArr, int i7) {
            super(objArr.length, i7);
            this.f18840n = objArr;
        }

        @Override // k3.AbstractC1258a
        public Object a(int i7) {
            return this.f18840n[i7];
        }
    }

    public enum d implements Iterator {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            AbstractC1266i.d(false);
        }
    }

    public static final class e extends h0 {

        /* renamed from: l, reason: collision with root package name */
        public final Object f18843l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f18844m;

        public e(Object obj) {
            this.f18843l = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f18844m;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f18844m) {
                throw new NoSuchElementException();
            }
            this.f18844m = true;
            return this.f18843l;
        }
    }

    public static boolean a(Collection collection, Iterator it) {
        j3.o.q(collection);
        j3.o.q(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static boolean b(Iterator it, j3.p pVar) {
        return o(it, pVar) != -1;
    }

    public static void c(Iterator it) {
        j3.o.q(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean d(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !AbstractC1236k.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static h0 f() {
        return g();
    }

    public static i0 g() {
        return c.f18839o;
    }

    public static Iterator h() {
        return d.INSTANCE;
    }

    public static h0 i(Iterator it, j3.p pVar) {
        j3.o.q(it);
        j3.o.q(pVar);
        return new a(it, pVar);
    }

    public static Object j(Iterator it, j3.p pVar) {
        j3.o.q(it);
        j3.o.q(pVar);
        while (it.hasNext()) {
            Object next = it.next();
            if (pVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static Object k(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object l(Iterator it, Object obj) {
        return it.hasNext() ? k(it) : obj;
    }

    public static Object m(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static Object n(Iterator it) {
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i7 = 0; i7 < 4 && it.hasNext(); i7++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static int o(Iterator it, j3.p pVar) {
        j3.o.r(pVar, "predicate");
        int i7 = 0;
        while (it.hasNext()) {
            if (pVar.apply(it.next())) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static Object p(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static boolean q(Iterator it, Collection collection) {
        j3.o.q(collection);
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public static boolean r(Iterator it, j3.p pVar) {
        j3.o.q(pVar);
        boolean z7 = false;
        while (it.hasNext()) {
            if (pVar.apply(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public static h0 s(Object obj) {
        return new e(obj);
    }

    public static Iterator t(Iterator it, InterfaceC1231f interfaceC1231f) {
        j3.o.q(interfaceC1231f);
        return new b(it, interfaceC1231f);
    }
}
