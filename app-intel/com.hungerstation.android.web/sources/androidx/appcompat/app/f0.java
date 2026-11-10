package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes6.dex */
class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static Field f2019a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f2020b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f2021c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f2022d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f2023e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f2024f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f2025g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f2026h;

    static class a {
        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    static void a(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 28) {
            return;
        }
        if (i12 >= 24) {
            d(resources);
        } else if (i12 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    private static void b(Resources resources) throws NoSuchFieldException, SecurityException {
        Map map;
        if (!f2020b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f2019a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2020b = true;
        }
        Field field = f2019a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException unused2) {
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object obj;
        if (!f2020b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f2019a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2020b = true;
        }
        Field field = f2019a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    private static void d(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object obj;
        if (!f2026h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f2025g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2026h = true;
        }
        Field field = f2025g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException unused2) {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f2020b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f2019a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            f2020b = true;
        }
        Field field2 = f2019a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException unused4) {
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) throws NoSuchFieldException, SecurityException {
        LongSparseArray longSparseArray;
        if (!f2022d) {
            try {
                f2021c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            f2022d = true;
        }
        Class<?> cls = f2021c;
        if (cls == null) {
            return;
        }
        if (!f2024f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f2023e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            f2024f = true;
        }
        Field field = f2023e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
