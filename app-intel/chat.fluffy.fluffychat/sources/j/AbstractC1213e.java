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
import y.C1787b;

/* renamed from: j.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1213e {

    /* renamed from: l, reason: collision with root package name */
    public static t.a f18472l = new t.a(new t.b());

    /* renamed from: m, reason: collision with root package name */
    public static int f18473m = -100;

    /* renamed from: n, reason: collision with root package name */
    public static V.h f18474n = null;

    /* renamed from: o, reason: collision with root package name */
    public static V.h f18475o = null;

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f18476p = null;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f18477q = false;

    /* renamed from: r, reason: collision with root package name */
    public static final C1787b f18478r = new C1787b();

    /* renamed from: s, reason: collision with root package name */
    public static final Object f18479s = new Object();

    /* renamed from: t, reason: collision with root package name */
    public static final Object f18480t = new Object();

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

    public static void D(AbstractC1213e abstractC1213e) {
        synchronized (f18479s) {
            E(abstractC1213e);
        }
    }

    public static void E(AbstractC1213e abstractC1213e) {
        synchronized (f18479s) {
            try {
                Iterator it = f18478r.iterator();
                while (it.hasNext()) {
                    AbstractC1213e abstractC1213e2 = (AbstractC1213e) ((WeakReference) it.next()).get();
                    if (abstractC1213e2 == abstractC1213e || abstractC1213e2 == null) {
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
                if (f18477q) {
                    return;
                }
                f18472l.execute(new Runnable() { // from class: j.d
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        AbstractC1213e.c(context);
                    }
                });
                return;
            }
            synchronized (f18480t) {
                try {
                    V.h hVar = f18474n;
                    if (hVar == null) {
                        if (f18475o == null) {
                            f18475o = V.h.b(t.b(context));
                        }
                        if (f18475o.e()) {
                        } else {
                            f18474n = f18475o;
                        }
                    } else if (!hVar.equals(f18475o)) {
                        V.h hVar2 = f18474n;
                        f18475o = hVar2;
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
        f18477q = true;
    }

    public static void d(AbstractC1213e abstractC1213e) {
        synchronized (f18479s) {
            E(abstractC1213e);
            f18478r.add(new WeakReference(abstractC1213e));
        }
    }

    public static AbstractC1213e h(Activity activity, InterfaceC1211c interfaceC1211c) {
        return new LayoutInflaterFactory2C1214f(activity, interfaceC1211c);
    }

    public static AbstractC1213e i(Dialog dialog, InterfaceC1211c interfaceC1211c) {
        return new LayoutInflaterFactory2C1214f(dialog, interfaceC1211c);
    }

    public static V.h k() {
        if (V.c.d()) {
            Object objO = o();
            if (objO != null) {
                return V.h.h(b.a(objO));
            }
        } else {
            V.h hVar = f18474n;
            if (hVar != null) {
                return hVar;
            }
        }
        return V.h.d();
    }

    public static int m() {
        return f18473m;
    }

    public static Object o() {
        Context contextL;
        Iterator it = f18478r.iterator();
        while (it.hasNext()) {
            AbstractC1213e abstractC1213e = (AbstractC1213e) ((WeakReference) it.next()).get();
            if (abstractC1213e != null && (contextL = abstractC1213e.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    public static V.h q() {
        return f18474n;
    }

    public static boolean u(Context context) {
        if (f18476p == null) {
            try {
                Bundle bundle = r.a(context).metaData;
                if (bundle != null) {
                    f18476p = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f18476p = Boolean.FALSE;
            }
        }
        return f18476p.booleanValue();
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

    public abstract AbstractC1209a r();

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
