package j3;

import j3.v;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class v {

    public static class a implements u, Serializable {

        /* renamed from: l, reason: collision with root package name */
        public transient Object f18739l = new Object();

        /* renamed from: m, reason: collision with root package name */
        public final u f18740m;

        /* renamed from: n, reason: collision with root package name */
        public volatile transient boolean f18741n;

        /* renamed from: o, reason: collision with root package name */
        public transient Object f18742o;

        public a(u uVar) {
            this.f18740m = (u) o.q(uVar);
        }

        @Override // j3.u
        public Object get() {
            if (!this.f18741n) {
                synchronized (this.f18739l) {
                    try {
                        if (!this.f18741n) {
                            Object obj = this.f18740m.get();
                            this.f18742o = obj;
                            this.f18741n = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC1236j.a(this.f18742o);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f18741n) {
                obj = "<supplier that returned " + this.f18742o + ">";
            } else {
                obj = this.f18740m;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class b implements u {

        /* renamed from: o, reason: collision with root package name */
        public static final u f18743o = new u() { // from class: j3.w
            @Override // j3.u
            public final Object get() {
                return v.b.a();
            }
        };

        /* renamed from: l, reason: collision with root package name */
        public final Object f18744l = new Object();

        /* renamed from: m, reason: collision with root package name */
        public volatile u f18745m;

        /* renamed from: n, reason: collision with root package name */
        public Object f18746n;

        public b(u uVar) {
            this.f18745m = (u) o.q(uVar);
        }

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        @Override // j3.u
        public Object get() {
            u uVar = this.f18745m;
            u uVar2 = f18743o;
            if (uVar != uVar2) {
                synchronized (this.f18744l) {
                    try {
                        if (this.f18745m != uVar2) {
                            Object obj = this.f18745m.get();
                            this.f18746n = obj;
                            this.f18745m = uVar2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC1236j.a(this.f18746n);
        }

        public String toString() {
            Object obj = this.f18745m;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f18743o) {
                obj = "<supplier that returned " + this.f18746n + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static u a(u uVar) {
        return ((uVar instanceof b) || (uVar instanceof a)) ? uVar : uVar instanceof Serializable ? new a(uVar) : new b(uVar);
    }
}
