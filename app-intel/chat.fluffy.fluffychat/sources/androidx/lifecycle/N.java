package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import w0.AbstractC1725a;

/* loaded from: classes.dex */
public class N {

    /* renamed from: b, reason: collision with root package name */
    public static final b f12376b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC1725a.c f12377c;

    /* renamed from: a, reason: collision with root package name */
    public final x0.f f12378a;

    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public static /* synthetic */ N b(b bVar, P p7, c cVar, AbstractC1725a abstractC1725a, int i7, Object obj) {
            if ((i7 & 2) != 0) {
                cVar = x0.h.f23451a.b(p7);
            }
            if ((i7 & 4) != 0) {
                abstractC1725a = x0.h.f23451a.a(p7);
            }
            return bVar.a(p7, cVar, abstractC1725a);
        }

        public final N a(P p7, c cVar, AbstractC1725a abstractC1725a) {
            M5.m.e(p7, "owner");
            M5.m.e(cVar, "factory");
            M5.m.e(abstractC1725a, "extras");
            return new N(p7.D(), cVar, abstractC1725a);
        }

        public b() {
        }
    }

    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12383a = a.f12384a;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f12384a = new a();
        }

        default M a(Class cls) {
            M5.m.e(cls, "modelClass");
            return x0.h.f23451a.d();
        }

        default M b(Class cls, AbstractC1725a abstractC1725a) {
            M5.m.e(cls, "modelClass");
            M5.m.e(abstractC1725a, "extras");
            return a(cls);
        }

        default M c(T5.b bVar, AbstractC1725a abstractC1725a) {
            M5.m.e(bVar, "modelClass");
            M5.m.e(abstractC1725a, "extras");
            return b(K5.a.a(bVar), abstractC1725a);
        }
    }

    public static class d implements c {

        /* renamed from: c, reason: collision with root package name */
        public static d f12386c;

        /* renamed from: b, reason: collision with root package name */
        public static final a f12385b = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final AbstractC1725a.c f12387d = N.f12377c;

        public static final class a {
            public /* synthetic */ a(M5.g gVar) {
                this();
            }

            public final d a() {
                if (d.f12386c == null) {
                    d.f12386c = new d();
                }
                d dVar = d.f12386c;
                M5.m.b(dVar);
                return dVar;
            }

            public a() {
            }
        }

        @Override // androidx.lifecycle.N.c
        public M a(Class cls) {
            M5.m.e(cls, "modelClass");
            return x0.c.f23442a.a(cls);
        }

        @Override // androidx.lifecycle.N.c
        public M b(Class cls, AbstractC1725a abstractC1725a) {
            M5.m.e(cls, "modelClass");
            M5.m.e(abstractC1725a, "extras");
            return a(cls);
        }

        @Override // androidx.lifecycle.N.c
        public M c(T5.b bVar, AbstractC1725a abstractC1725a) {
            M5.m.e(bVar, "modelClass");
            M5.m.e(abstractC1725a, "extras");
            return b(K5.a.a(bVar), abstractC1725a);
        }
    }

    public static class e {
        public void d(M m7) {
            M5.m.e(m7, "viewModel");
        }
    }

    public static final class f implements AbstractC1725a.c {
    }

    static {
        AbstractC1725a.C0283a c0283a = AbstractC1725a.f23251b;
        f12377c = new f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public N(O o7, c cVar) {
        this(o7, cVar, null, 4, null);
        M5.m.e(o7, "store");
        M5.m.e(cVar, "factory");
    }

    public final M a(T5.b bVar) {
        M5.m.e(bVar, "modelClass");
        return x0.f.e(this.f12378a, bVar, null, 2, null);
    }

    public M b(Class cls) {
        M5.m.e(cls, "modelClass");
        return a(K5.a.c(cls));
    }

    public final M c(String str, T5.b bVar) {
        M5.m.e(str, "key");
        M5.m.e(bVar, "modelClass");
        return this.f12378a.d(bVar, str);
    }

    public static class a extends d {

        /* renamed from: f, reason: collision with root package name */
        public static final C0108a f12379f = new C0108a(null);

        /* renamed from: g, reason: collision with root package name */
        public static a f12380g;

        /* renamed from: h, reason: collision with root package name */
        public static final AbstractC1725a.c f12381h;

        /* renamed from: e, reason: collision with root package name */
        public final Application f12382e;

        /* renamed from: androidx.lifecycle.N$a$a, reason: collision with other inner class name */
        public static final class C0108a {
            public /* synthetic */ C0108a(M5.g gVar) {
                this();
            }

            public final a a(Application application) {
                M5.m.e(application, "application");
                if (a.f12380g == null) {
                    a.f12380g = new a(application);
                }
                a aVar = a.f12380g;
                M5.m.b(aVar);
                return aVar;
            }

            public C0108a() {
            }
        }

        public static final class b implements AbstractC1725a.c {
        }

        static {
            AbstractC1725a.C0283a c0283a = AbstractC1725a.f23251b;
            f12381h = new b();
        }

        public a(Application application, int i7) {
            this.f12382e = application;
        }

        @Override // androidx.lifecycle.N.d, androidx.lifecycle.N.c
        public M a(Class cls) {
            M5.m.e(cls, "modelClass");
            Application application = this.f12382e;
            if (application != null) {
                return h(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.N.d, androidx.lifecycle.N.c
        public M b(Class cls, AbstractC1725a abstractC1725a) {
            M5.m.e(cls, "modelClass");
            M5.m.e(abstractC1725a, "extras");
            if (this.f12382e != null) {
                return a(cls);
            }
            Application application = (Application) abstractC1725a.a(f12381h);
            if (application != null) {
                return h(cls, application);
            }
            if (AbstractC0795a.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(cls);
        }

        public final M h(Class cls, Application application) {
            if (!AbstractC0795a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                M m7 = (M) cls.getConstructor(Application.class).newInstance(application);
                M5.m.b(m7);
                return m7;
            } catch (IllegalAccessException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            } catch (InstantiationException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            } catch (NoSuchMethodException e9) {
                throw new RuntimeException("Cannot create an instance of " + cls, e9);
            } catch (InvocationTargetException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            M5.m.e(application, "application");
        }
    }

    public N(x0.f fVar) {
        this.f12378a = fVar;
    }

    public /* synthetic */ N(O o7, c cVar, AbstractC1725a abstractC1725a, int i7, M5.g gVar) {
        this(o7, cVar, (i7 & 4) != 0 ? AbstractC1725a.b.f23253c : abstractC1725a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public N(O o7, c cVar, AbstractC1725a abstractC1725a) {
        this(new x0.f(o7, cVar, abstractC1725a));
        M5.m.e(o7, "store");
        M5.m.e(cVar, "factory");
        M5.m.e(abstractC1725a, "defaultCreationExtras");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public N(P p7) {
        M5.m.e(p7, "owner");
        O oD = p7.D();
        x0.h hVar = x0.h.f23451a;
        this(oD, hVar.b(p7), hVar.a(p7));
    }
}
