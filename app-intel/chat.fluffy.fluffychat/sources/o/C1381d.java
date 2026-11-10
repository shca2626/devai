package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* renamed from: o.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1381d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f20243f;

    /* renamed from: a, reason: collision with root package name */
    public int f20244a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f20245b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f20246c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f20247d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f20248e;

    /* renamed from: o.d$a */
    public static class a {
        public static Context a(C1381d c1381d, Configuration configuration) {
            return c1381d.createConfigurationContext(configuration);
        }
    }

    public C1381d() {
        super(null);
    }

    public static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f20243f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f20243f = configuration2;
        }
        return configuration.equals(f20243f);
    }

    public void a(Configuration configuration) {
        if (this.f20248e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f20247d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f20247d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f20248e == null) {
            Configuration configuration = this.f20247d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f20248e = super.getResources();
            } else {
                this.f20248e = a.a(this, this.f20247d).getResources();
            }
        }
        return this.f20248e;
    }

    public int c() {
        return this.f20244a;
    }

    public final void d() {
        boolean z7 = this.f20245b == null;
        if (z7) {
            this.f20245b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f20245b.setTo(theme);
            }
        }
        f(this.f20245b, this.f20244a, z7);
    }

    public void f(Resources.Theme theme, int i7, boolean z7) {
        theme.applyStyle(i7, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f20246c == null) {
            this.f20246c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f20246c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f20245b;
        if (theme != null) {
            return theme;
        }
        if (this.f20244a == 0) {
            this.f20244a = i.i.f17102d;
        }
        d();
        return this.f20245b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i7) {
        if (this.f20244a != i7) {
            this.f20244a = i7;
            d();
        }
    }

    public C1381d(Context context, int i7) {
        super(context);
        this.f20244a = i7;
    }

    public C1381d(Context context, Resources.Theme theme) {
        super(context);
        this.f20245b = theme;
    }
}
