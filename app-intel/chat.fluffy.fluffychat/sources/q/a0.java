package q;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f21231c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList f21232d;

    /* renamed from: a, reason: collision with root package name */
    public final Resources f21233a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f21234b;

    public a0(Context context) {
        super(context);
        if (!m0.c()) {
            this.f21233a = new c0(this, context.getResources());
            this.f21234b = null;
            return;
        }
        m0 m0Var = new m0(this, context.getResources());
        this.f21233a = m0Var;
        Resources.Theme themeNewTheme = m0Var.newTheme();
        this.f21234b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        return ((context instanceof a0) || (context.getResources() instanceof c0) || (context.getResources() instanceof m0) || !m0.c()) ? false : true;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f21231c) {
            try {
                ArrayList arrayList = f21232d;
                if (arrayList == null) {
                    f21232d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f21232d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f21232d.remove(size);
                        }
                    }
                    for (int size2 = f21232d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f21232d.get(size2);
                        a0 a0Var = weakReference2 != null ? (a0) weakReference2.get() : null;
                        if (a0Var != null && a0Var.getBaseContext() == context) {
                            return a0Var;
                        }
                    }
                }
                a0 a0Var2 = new a0(context);
                f21232d.add(new WeakReference(a0Var2));
                return a0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f21233a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f21233a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f21234b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i7) {
        Resources.Theme theme = this.f21234b;
        if (theme == null) {
            super.setTheme(i7);
        } else {
            theme.applyStyle(i7, true);
        }
    }
}
