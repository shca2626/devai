package N;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f5757a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f5758b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5759c = new Object();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f5760a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f5761b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5762c;

        public a(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f5760a = colorStateList;
            this.f5761b = configuration;
            this.f5762c = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f5763a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources.Theme f5764b;

        public b(Resources resources, Resources.Theme theme) {
            this.f5763a = resources;
            this.f5764b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.f5763a.equals(bVar.f5763a) && Y.c.a(this.f5764b, bVar.f5764b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Y.c.b(this.f5763a, this.f5764b);
        }
    }

    public static abstract class c {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i7, Handler handler) {
            e(handler).post(new Runnable() { // from class: N.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5770l.f(i7);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: N.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5768l.g(typeface);
                }
            });
        }

        public abstract void f(int i7);

        public abstract void g(Typeface typeface);
    }

    public static final class d {

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final Object f5765a = new Object();

            /* renamed from: b, reason: collision with root package name */
            public static Method f5766b;

            /* renamed from: c, reason: collision with root package name */
            public static boolean f5767c;

            /* JADX WARN: Removed duplicated region for block: B:31:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public static void a(android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = N.h.d.a.f5765a
                    monitor-enter(r0)
                    boolean r1 = N.h.d.a.f5767c     // Catch: java.lang.Throwable -> L17
                    r2 = 0
                    if (r1 != 0) goto L23
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r2)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    N.h.d.a.f5766b = r3     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    r3.setAccessible(r1)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    goto L21
                L17:
                    r6 = move-exception
                    goto L39
                L19:
                    r3 = move-exception
                    java.lang.String r4 = "ResourcesCompat"
                    java.lang.String r5 = "Failed to retrieve rebase() method"
                    android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L17
                L21:
                    N.h.d.a.f5767c = r1     // Catch: java.lang.Throwable -> L17
                L23:
                    java.lang.reflect.Method r1 = N.h.d.a.f5766b     // Catch: java.lang.Throwable -> L17
                    if (r1 == 0) goto L37
                    r1.invoke(r6, r2)     // Catch: java.lang.Throwable -> L17 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d
                    goto L37
                L2b:
                    r6 = move-exception
                    goto L2e
                L2d:
                    r6 = move-exception
                L2e:
                    java.lang.String r1 = "ResourcesCompat"
                    java.lang.String r3 = "Failed to invoke rebase() method via reflection"
                    android.util.Log.i(r1, r3, r6)     // Catch: java.lang.Throwable -> L17
                    N.h.d.a.f5766b = r2     // Catch: java.lang.Throwable -> L17
                L37:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    return
                L39:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: N.h.d.a.a(android.content.res.Resources$Theme):void");
            }
        }

        public static class b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.a(theme);
            } else {
                a.a(theme);
            }
        }
    }

    public static void a(b bVar, int i7, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f5759c) {
            try {
                WeakHashMap weakHashMap = f5758b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(bVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(bVar, sparseArray);
                }
                sparseArray.append(i7, new a(colorStateList, bVar.f5763a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f5762c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList b(N.h.b r5, int r6) {
        /*
            java.lang.Object r0 = N.h.f5759c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = N.h.f5758b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            N.h$a r2 = (N.h.a) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f5761b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f5763a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f5764b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f5762c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f5762c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f5760a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: N.h.b(N.h$b, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i7) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i7, new TypedValue(), 0, null, null, false, true);
    }

    public static ColorStateList d(Resources resources, int i7, Resources.Theme theme) {
        b bVar = new b(resources, theme);
        ColorStateList colorStateListB = b(bVar, i7);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListK = k(resources, i7, theme);
        if (colorStateListK == null) {
            return resources.getColorStateList(i7, theme);
        }
        a(bVar, i7, colorStateListK, theme);
        return colorStateListK;
    }

    public static Drawable e(Resources resources, int i7, Resources.Theme theme) {
        return resources.getDrawable(i7, theme);
    }

    public static Drawable f(Resources resources, int i7, int i8, Resources.Theme theme) {
        return resources.getDrawableForDensity(i7, i8, theme);
    }

    public static Typeface g(Context context, int i7) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i7, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface h(Context context, int i7, TypedValue typedValue, int i8, c cVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i7, typedValue, i8, cVar, null, true, false);
    }

    public static void i(Context context, int i7, c cVar, Handler handler) throws Resources.NotFoundException {
        Y.h.j(cVar);
        if (context.isRestricted()) {
            cVar.c(-4, handler);
        } else {
            m(context, i7, new TypedValue(), 0, cVar, handler, false, false);
        }
    }

    public static TypedValue j() {
        ThreadLocal threadLocal = f5757a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList k(Resources resources, int i7, Resources.Theme theme) {
        if (l(resources, i7)) {
            return null;
        }
        try {
            return N.c.a(resources, resources.getXml(i7), theme);
        } catch (Exception e7) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e7);
            return null;
        }
    }

    public static boolean l(Resources resources, int i7) throws Resources.NotFoundException {
        TypedValue typedValueJ = j();
        resources.getValue(i7, typedValueJ, true);
        int i8 = typedValueJ.type;
        return i8 >= 28 && i8 <= 31;
    }

    public static Typeface m(Context context, int i7, TypedValue typedValue, int i8, c cVar, Handler handler, boolean z7, boolean z8) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i7, typedValue, true);
        Typeface typefaceN = n(context, resources, typedValue, i7, i8, cVar, handler, z7, z8);
        if (typefaceN != null || cVar != null || z8) {
            return typefaceN;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i7) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface n(android.content.Context r13, android.content.res.Resources r14, android.util.TypedValue r15, int r16, int r17, N.h.c r18, android.os.Handler r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N.h.n(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, N.h$c, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
