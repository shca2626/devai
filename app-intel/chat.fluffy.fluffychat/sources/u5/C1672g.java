package u5;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import g2.k;
import g2.l;

/* renamed from: u5.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1672g {

    /* renamed from: u5.g$a */
    public interface a {
        void a(float f7, float f8, float f9);
    }

    /* renamed from: u5.g$b */
    public interface b {
        boolean a(View view);
    }

    public static /* synthetic */ boolean a(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static void b(Context context, a aVar) {
        Activity activityD = d(context);
        if (activityD != null) {
            k kVarA = l.b().a(activityD);
            aVar.a(kVarA.a().width(), kVarA.a().height(), context.getResources().getDisplayMetrics().density);
        }
    }

    public static boolean c(View view) {
        return f(view, new b() { // from class: u5.f
            @Override // u5.C1672g.b
            public final boolean a(View view2) {
                return view2.hasFocus();
            }
        });
    }

    public static Activity d(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return d(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean e(View view, final Class[] clsArr) {
        return f(view, new b() { // from class: u5.e
            @Override // u5.C1672g.b
            public final boolean a(View view2) {
                return C1672g.a(clsArr, view2);
            }
        });
    }

    public static boolean f(View view, b bVar) {
        if (view == null) {
            return false;
        }
        if (bVar.a(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                if (f(viewGroup.getChildAt(i7), bVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
