package j;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static Field f18603a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f18604b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f18605c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f18606d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f18607e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f18608f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f18609g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f18610h;

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
        if (!f18610h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f18609g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e7) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e7);
            }
            f18610h = true;
        }
        Field field = f18609g;
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
        if (!f18604b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f18603a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e9) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e9);
            }
            f18604b = true;
        }
        Field field2 = f18603a;
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
        if (!f18606d) {
            try {
                f18605c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e7) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e7);
            }
            f18606d = true;
        }
        Class cls = f18605c;
        if (cls == null) {
            return;
        }
        if (!f18608f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f18607e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e8);
            }
            f18608f = true;
        }
        Field field = f18607e;
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
