package k3;

import j3.AbstractC1237k;
import j3.InterfaceC1232f;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class E {

    public class a extends AbstractC1260b {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Iterator f18837n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ j3.p f18838o;

        public a(Iterator it, j3.p pVar) {
            this.f18837n = it;
            this.f18838o = pVar;
        }

        @Override // k3.AbstractC1260b
        public Object a() {
            while (this.f18837n.hasNext()) {
                Object next = this.f18837n.next();
                if (this.f18838o.apply(next)) {
                    return next;
                }
            }
            return b();
        }
    }

    public class b extends f0 {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1232f f18839m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Iterator it, InterfaceC1232f interfaceC1232f) {
            super(it);
            this.f18839m = interfaceC1232f;
        }

        @Override // k3.f0
        public Object a(Object obj) {
            return this.f18839m.apply(obj);
        }
    }

    public static final class c extends AbstractC1259a {

        /* renamed from: o, reason: collision with root package name */
        public static final i0 f18840o = new c(new Object[0], 0);

        /* renamed from: n, reason: collision with root package name */
        public final Object[] f18841n;

        public c(Object[] objArr, int i7) {
            super(objArr.length, i7);
            this.f18841n = objArr;
        }

        @Override // k3.AbstractC1259a
        public Object a(int i7) {
            return this.f18841n[i7];
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
            AbstractC1267i.d(false);
        }
    }

    public static final class e extends h0 {

        /* renamed from: l, reason: collision with root package name */
        public final Object f18844l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f18845m;

        public e(Object obj) {
            this.f18844l = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f18845m;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f18845m) {
                throw new NoSuchElementException();
            }
            this.f18845m = true;
            return this.f18844l;
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
            if (!it2.hasNext() || !AbstractC1237k.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static h0 f() {
        return g();
    }

    public static i0 g() {
        return c.f18840o;
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

    public static Iterator t(Iterator it, InterfaceC1232f interfaceC1232f) {
        j3.o.q(interfaceC1232f);
        return new b(it, interfaceC1232f);
    }
}
