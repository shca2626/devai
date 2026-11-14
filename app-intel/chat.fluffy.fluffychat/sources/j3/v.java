package j3;

import j3.v;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class v {

    public static class a implements u, Serializable {

        /* renamed from: l, reason: collision with root package name */
        public transient Object f18738l = new Object();

        /* renamed from: m, reason: collision with root package name */
        public final u f18739m;

        /* renamed from: n, reason: collision with root package name */
        public volatile transient boolean f18740n;

        /* renamed from: o, reason: collision with root package name */
        public transient Object f18741o;

        public a(u uVar) {
            this.f18739m = (u) o.q(uVar);
        }

        @Override // j3.u
        public Object get() {
            if (!this.f18740n) {
                synchronized (this.f18738l) {
                    try {
                        if (!this.f18740n) {
                            Object obj = this.f18739m.get();
                            this.f18741o = obj;
                            this.f18740n = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC1235j.a(this.f18741o);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f18740n) {
                obj = "<supplier that returned " + this.f18741o + ">";
            } else {
                obj = this.f18739m;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class b implements u {

        /* renamed from: o, reason: collision with root package name */
        public static final u f18742o = new u() { // from class: j3.w
            @Override // j3.u
            public final Object get() {
                return v.b.a();
            }
        };

        /* renamed from: l, reason: collision with root package name */
        public final Object f18743l = new Object();

        /* renamed from: m, reason: collision with root package name */
        public volatile u f18744m;

        /* renamed from: n, reason: collision with root package name */
        public Object f18745n;

        public b(u uVar) {
            this.f18744m = (u) o.q(uVar);
        }

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        @Override // j3.u
        public Object get() {
            u uVar = this.f18744m;
            u uVar2 = f18742o;
            if (uVar != uVar2) {
                synchronized (this.f18743l) {
                    try {
                        if (this.f18744m != uVar2) {
                            Object obj = this.f18744m.get();
                            this.f18745n = obj;
                            this.f18744m = uVar2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC1235j.a(this.f18745n);
        }

        public String toString() {
            Object obj = this.f18744m;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f18742o) {
                obj = "<supplier that returned " + this.f18745n + ">";
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
