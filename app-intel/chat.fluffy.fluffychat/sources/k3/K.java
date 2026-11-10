package k3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class K {

    public class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18869a;

        public a(int i7) {
            this.f18869a = i7;
        }

        @Override // k3.K.e
        public Map c() {
            return V.c(this.f18869a);
        }
    }

    public class b extends e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f18870a;

        public b(Comparator comparator) {
            this.f18870a = comparator;
        }

        @Override // k3.K.e
        public Map c() {
            return new TreeMap(this.f18870a);
        }
    }

    public static final class c implements j3.u, Serializable {

        /* renamed from: l, reason: collision with root package name */
        public final int f18871l;

        public c(int i7) {
            this.f18871l = AbstractC1267i.b(i7, "expectedValuesPerKey");
        }

        @Override // j3.u
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.f18871l);
        }
    }

    public static abstract class d extends K {
        public d() {
            super(null);
        }

        public abstract F e();
    }

    public static abstract class e {

        public class a extends d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f18872a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f18873b;

            public a(e eVar, int i7) {
                this.f18872a = i7;
                this.f18873b = eVar;
            }

            @Override // k3.K.d
            public F e() {
                return L.b(this.f18873b.c(), new c(this.f18872a));
            }
        }

        public d a() {
            return b(2);
        }

        public d b(int i7) {
            AbstractC1267i.b(i7, "expectedValuesPerKey");
            return new a(this, i7);
        }

        public abstract Map c();
    }

    public /* synthetic */ K(a aVar) {
        this();
    }

    public static e a() {
        return b(8);
    }

    public static e b(int i7) {
        AbstractC1267i.b(i7, "expectedKeys");
        return new a(i7);
    }

    public static e c() {
        return d(U.d());
    }

    public static e d(Comparator comparator) {
        j3.o.q(comparator);
        return new b(comparator);
    }

    public K() {
    }
}
