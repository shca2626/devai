package j;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static Field f18604a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f18605b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f18606c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f18607d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f18608e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f18609f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f18610g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f18611h;

    public static class a {
        public static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    public static void a(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        b(resources);
    }

    public static void b(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object obj;
        if (!f18611h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f18610g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e7) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e7);
            }
            f18611h = true;
        }
        Field field = f18610g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e8) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e8);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f18605b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f18604a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e9) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e9);
            }
            f18605b = true;
        }
        Field field2 = f18604a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e10);
            }
        }
        if (obj2 != null) {
            c(obj2);
        }
    }

    public static void c(Object obj) throws NoSuchFieldException, SecurityException {
        LongSparseArray longSparseArray;
        if (!f18607d) {
            try {
                f18606c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e7) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e7);
            }
            f18607d = true;
        }
        Class cls = f18606c;
        if (cls == null) {
            return;
        }
        if (!f18609f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f18608e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e8);
            }
            f18609f = true;
        }
        Field field = f18608e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e9) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e9);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
