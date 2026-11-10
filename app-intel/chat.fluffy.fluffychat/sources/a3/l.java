package a3;

import Z.C0701j0;
import Z.I;
import Z.W;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;

/* loaded from: classes.dex */
public abstract class l {

    public class a implements Runnable {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ View f10770l;

        public a(View view) {
            this.f10770l = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f10770l.getContext().getSystemService("input_method")).showSoftInput(this.f10770l, 1);
        }
    }

    public class b implements I {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f10771a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f10772b;

        public b(d dVar, e eVar) {
            this.f10771a = dVar;
            this.f10772b = eVar;
        }

        @Override // Z.I
        public C0701j0 a(View view, C0701j0 c0701j0) {
            return this.f10771a.a(view, c0701j0, new e(this.f10772b));
        }
    }

    public interface d {
        C0701j0 a(View view, C0701j0 c0701j0, e eVar);
    }

    public static void a(View view, d dVar) {
        W.z0(view, new b(dVar, new e(W.F(view), view.getPaddingTop(), W.E(view), view.getPaddingBottom())));
        g(view);
    }

    public static float b(Context context, int i7) {
        return TypedValue.applyDimension(1, i7, context.getResources().getDisplayMetrics());
    }

    public static Integer c(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    public static float d(View view) {
        float fV = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fV += W.v((View) parent);
        }
        return fV;
    }

    public static boolean e(View view) {
        return W.A(view) == 1;
    }

    public static PorterDuff.Mode f(int i7, PorterDuff.Mode mode) {
        if (i7 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i7 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i7 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i7) {
            case StdKeyDeserializer.TYPE_URL /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void g(View view) {
        if (W.P(view)) {
            W.i0(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void h(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f10773a;

        /* renamed from: b, reason: collision with root package name */
        public int f10774b;

        /* renamed from: c, reason: collision with root package name */
        public int f10775c;

        /* renamed from: d, reason: collision with root package name */
        public int f10776d;

        public e(int i7, int i8, int i9, int i10) {
            this.f10773a = i7;
            this.f10774b = i8;
            this.f10775c = i9;
            this.f10776d = i10;
        }

        public e(e eVar) {
            this.f10773a = eVar.f10773a;
            this.f10774b = eVar.f10774b;
            this.f10775c = eVar.f10775c;
            this.f10776d = eVar.f10776d;
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            W.i0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
