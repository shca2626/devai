package Z1;

import Z.W;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* loaded from: classes.dex */
public abstract class A {

    /* renamed from: a, reason: collision with root package name */
    public static final M f10179a;

    /* renamed from: b, reason: collision with root package name */
    public static final Property f10180b;

    /* renamed from: c, reason: collision with root package name */
    public static final Property f10181c;

    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(A.c(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f7) {
            A.g(view, f7.floatValue());
        }
    }

    public class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return W.t(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            W.s0(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f10179a = new L();
        } else {
            f10179a = new K();
        }
        f10180b = new a(Float.class, "translationAlpha");
        f10181c = new b(Rect.class, "clipBounds");
    }

    public static void a(View view) {
        f10179a.a(view);
    }

    public static z b(View view) {
        return new y(view);
    }

    public static float c(View view) {
        return f10179a.b(view);
    }

    public static P d(View view) {
        return new O(view);
    }

    public static void e(View view) {
        f10179a.c(view);
    }

    public static void f(View view, int i7, int i8, int i9, int i10) {
        f10179a.d(view, i7, i8, i9, i10);
    }

    public static void g(View view, float f7) {
        f10179a.e(view, f7);
    }

    public static void h(View view, int i7) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        f10179a.f(view, i7);
    }

    public static void i(View view, Matrix matrix) {
        f10179a.g(view, matrix);
    }

    public static void j(View view, Matrix matrix) {
        f10179a.h(view, matrix);
    }
}
