package M5;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements T5.a, Serializable {

    /* renamed from: r, reason: collision with root package name */
    public static final Object f5703r = a.f5710l;

    /* renamed from: l, reason: collision with root package name */
    public transient T5.a f5704l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f5705m;

    /* renamed from: n, reason: collision with root package name */
    public final Class f5706n;

    /* renamed from: o, reason: collision with root package name */
    public final String f5707o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5708p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f5709q;

    public static class a implements Serializable {

        /* renamed from: l, reason: collision with root package name */
        public static final a f5710l = new a();
    }

    public c() {
        this(f5703r);
    }

    public T5.a b() {
        T5.a aVar = this.f5704l;
        if (aVar != null) {
            return aVar;
        }
        T5.a aVarC = c();
        this.f5704l = aVarC;
        return aVarC;
    }

    public abstract T5.a c();

    public Object f() {
        return this.f5705m;
    }

    public String g() {
        return this.f5707o;
    }

    public T5.d h() {
        Class cls = this.f5706n;
        if (cls == null) {
            return null;
        }
        return this.f5709q ? x.c(cls) : x.b(cls);
    }

    public T5.a k() {
        T5.a aVarB = b();
        if (aVarB != this) {
            return aVarB;
        }
        throw new K5.b();
    }

    public String l() {
        return this.f5708p;
    }

    public c(Object obj) {
        this(obj, null, null, null, false);
    }

    public c(Object obj, Class cls, String str, String str2, boolean z7) {
        this.f5705m = obj;
        this.f5706n = cls;
        this.f5707o = str;
        this.f5708p = str2;
        this.f5709q = z7;
    }
}
