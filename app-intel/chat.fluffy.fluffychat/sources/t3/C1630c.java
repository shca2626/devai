package t3;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r3.AbstractC1563b;
import t3.e;

/* renamed from: t3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1630c {

    /* renamed from: b, reason: collision with root package name */
    public static final C1630c f22566b = new C1630c(new e.a());

    /* renamed from: c, reason: collision with root package name */
    public static final C1630c f22567c = new C1630c(new e.C0272e());

    /* renamed from: d, reason: collision with root package name */
    public static final C1630c f22568d = new C1630c(new e.g());

    /* renamed from: e, reason: collision with root package name */
    public static final C1630c f22569e = new C1630c(new e.f());

    /* renamed from: f, reason: collision with root package name */
    public static final C1630c f22570f = new C1630c(new e.b());

    /* renamed from: g, reason: collision with root package name */
    public static final C1630c f22571g = new C1630c(new e.d());

    /* renamed from: h, reason: collision with root package name */
    public static final C1630c f22572h = new C1630c(new e.c());

    /* renamed from: a, reason: collision with root package name */
    public final d f22573a;

    /* renamed from: t3.c$a */
    public static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final e f22574a;

        @Override // t3.C1630c.d
        public Object a(String str) {
            Iterator it = C1630c.b("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f22574a.a(str, (Provider) it.next());
                } catch (Exception e7) {
                    if (exc == null) {
                        exc = e7;
                    }
                }
            }
            return this.f22574a.a(str, null);
        }

        public a(e eVar) {
            this.f22574a = eVar;
        }
    }

    /* renamed from: t3.c$b */
    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public final e f22575a;

        @Override // t3.C1630c.d
        public Object a(String str) {
            return this.f22575a.a(str, null);
        }

        public b(e eVar) {
            this.f22575a = eVar;
        }
    }

    /* renamed from: t3.c$c, reason: collision with other inner class name */
    public static class C0271c implements d {

        /* renamed from: a, reason: collision with root package name */
        public final e f22576a;

        @Override // t3.C1630c.d
        public Object a(String str) throws GeneralSecurityException {
            Iterator it = C1630c.b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f22576a.a(str, (Provider) it.next());
                } catch (Exception e7) {
                    if (exc == null) {
                        exc = e7;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        public C0271c(e eVar) {
            this.f22576a = eVar;
        }
    }

    /* renamed from: t3.c$d */
    public interface d {
        Object a(String str);
    }

    public C1630c(e eVar) {
        if (AbstractC1563b.a()) {
            this.f22573a = new C0271c(eVar);
        } else if (g.a()) {
            this.f22573a = new a(eVar);
        } else {
            this.f22573a = new b(eVar);
        }
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public Object a(String str) {
        return this.f22573a.a(str);
    }
}
