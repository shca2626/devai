package j;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import j.t;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import y.C1788b;

/* renamed from: j.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1214e {

    /* renamed from: l, reason: collision with root package name */
    public static t.a f18473l = new t.a(new t.b());

    /* renamed from: m, reason: collision with root package name */
    public static int f18474m = -100;

    /* renamed from: n, reason: collision with root package name */
    public static V.h f18475n = null;

    /* renamed from: o, reason: collision with root package name */
    public static V.h f18476o = null;

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f18477p = null;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f18478q = false;

    /* renamed from: r, reason: collision with root package name */
    public static final C1788b f18479r = new C1788b();

    /* renamed from: s, reason: collision with root package name */
    public static final Object f18480s = new Object();

    /* renamed from: t, reason: collision with root package name */
    public static final Object f18481t = new Object();

    /* renamed from: j.e$a */
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* renamed from: j.e$b */
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static void D(AbstractC1214e abstractC1214e) {
        synchronized (f18480s) {
            E(abstractC1214e);
        }
    }

    public static void E(AbstractC1214e abstractC1214e) {
        synchronized (f18480s) {
            try {
                Iterator it = f18479r.iterator();
                while (it.hasNext()) {
                    AbstractC1214e abstractC1214e2 = (AbstractC1214e) ((WeakReference) it.next()).get();
                    if (abstractC1214e2 == abstractC1214e || abstractC1214e2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void M(final Context context) {
        if (u(context)) {
            if (V.c.d()) {
                if (f18478q) {
                    return;
                }
                f18473l.execute(new Runnable() { // from class: j.d
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        AbstractC1214e.c(context);
                    }
                });
                return;
            }
            synchronized (f18481t) {
                try {
                    V.h hVar = f18475n;
                    if (hVar == null) {
                        if (f18476o == null) {
                            f18476o = V.h.b(t.b(context));
                        }
                        if (f18476o.e()) {
                        } else {
                            f18475n = f18476o;
                        }
                    } else if (!hVar.equals(f18476o)) {
                        V.h hVar2 = f18475n;
                        f18476o = hVar2;
                        t.a(context, hVar2.g());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static /* synthetic */ void c(Context context) throws IOException {
        t.c(context);
        f18478q = true;
    }

    public static void d(AbstractC1214e abstractC1214e) {
        synchronized (f18480s) {
            E(abstractC1214e);
            f18479r.add(new WeakReference(abstractC1214e));
        }
    }

    public static AbstractC1214e h(Activity activity, InterfaceC1212c interfaceC1212c) {
        return new LayoutInflaterFactory2C1215f(activity, interfaceC1212c);
    }

    public static AbstractC1214e i(Dialog dialog, InterfaceC1212c interfaceC1212c) {
        return new LayoutInflaterFactory2C1215f(dialog, interfaceC1212c);
    }

    public static V.h k() {
        if (V.c.d()) {
            Object objO = o();
            if (objO != null) {
                return V.h.h(b.a(objO));
            }
        } else {
            V.h hVar = f18475n;
            if (hVar != null) {
                return hVar;
            }
        }
        return V.h.d();
    }

    public static int m() {
        return f18474m;
    }

    public static Object o() {
        Context contextL;
        Iterator it = f18479r.iterator();
        while (it.hasNext()) {
            AbstractC1214e abstractC1214e = (AbstractC1214e) ((WeakReference) it.next()).get();
            if (abstractC1214e != null && (contextL = abstractC1214e.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    public static V.h q() {
        return f18475n;
    }

    public static boolean u(Context context) {
        if (f18477p == null) {
            try {
                Bundle bundle = r.a(context).metaData;
                if (bundle != null) {
                    f18477p = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f18477p = Boolean.FALSE;
            }
        }
        return f18477p.booleanValue();
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C();

    public abstract boolean F(int i7);

    public abstract void G(int i7);

    public abstract void H(View view);

    public abstract void I(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void K(int i7);

    public abstract void L(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i7);

    public abstract Context l();

    public abstract int n();

    public abstract MenuInflater p();

    public abstract AbstractC1210a r();

    public abstract void s();

    public abstract void t();

    public abstract void v(Configuration configuration);

    public abstract void w(Bundle bundle);

    public abstract void x();

    public abstract void y(Bundle bundle);

    public abstract void z();

    public void J(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void f(Context context) {
    }
}
