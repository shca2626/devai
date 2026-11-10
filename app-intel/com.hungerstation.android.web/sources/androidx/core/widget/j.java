package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static Method f6893a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6894b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f6895c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f6896d;

    static class a {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z12) {
            popupWindow.setOverlapAnchor(z12);
        }

        static void d(PopupWindow popupWindow, int i12) {
            popupWindow.setWindowLayoutType(i12);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z12) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 23) {
            a.c(popupWindow, z12);
            return;
        }
        if (!f6896d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f6895c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f6896d = true;
        }
        Field field = f6895c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z12));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i12) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(popupWindow, i12);
            return;
        }
        if (!f6894b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f6893a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f6894b = true;
        }
        Method method = f6893a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i12));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i12, int i13, int i14) {
        popupWindow.showAsDropDown(view, i12, i13, i14);
    }
}
