package k3;

import j3.AbstractC1236k;
import k3.N;

/* loaded from: classes.dex */
public abstract class O {

    public static abstract class a implements N.a {
        public boolean equals(Object obj) {
            if (obj instanceof N.a) {
                N.a aVar = (N.a) obj;
                if (getCount() == aVar.getCount() && AbstractC1236k.a(a(), aVar.a())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object objA = a();
            return (objA == null ? 0 : objA.hashCode()) ^ getCount();
        }

        public String toString() {
            String strValueOf = String.valueOf(a());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    public static N a(Iterable iterable) {
        return (N) iterable;
    }

    public static boolean b(N n7, Object obj) {
        if (obj == n7) {
            return true;
        }
        if (obj instanceof N) {
            N n8 = (N) obj;
            if (n7.size() == n8.size() && n7.entrySet().size() == n8.entrySet().size()) {
                for (N.a aVar : n8.entrySet()) {
                    if (n7.d(aVar.a()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static int c(Iterable iterable) {
        if (iterable instanceof N) {
            return ((N) iterable).b().size();
        }
        return 11;
    }
}
