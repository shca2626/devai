package y2;

import L5.l;
import M5.m;
import M5.n;
import W5.C0636o;
import W5.InterfaceC0632m;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import y5.C1814i;
import y5.C1824s;

/* loaded from: classes.dex */
public interface j extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f23990b = a.f23991a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f23991a = new a();

        public static /* synthetic */ j b(a aVar, View view, boolean z7, int i7, Object obj) {
            if ((i7 & 2) != 0) {
                z7 = true;
            }
            return aVar.a(view, z7);
        }

        public final j a(View view, boolean z7) {
            m.e(view, "view");
            return new f(view, z7);
        }
    }

    public static final class b {

        public static final class a extends n implements l {

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ j f23992m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver f23993n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserverOnPreDrawListenerC0293b f23994o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar, ViewTreeObserver viewTreeObserver, ViewTreeObserverOnPreDrawListenerC0293b viewTreeObserverOnPreDrawListenerC0293b) {
                super(1);
                this.f23992m = jVar;
                this.f23993n = viewTreeObserver;
                this.f23994o = viewTreeObserverOnPreDrawListenerC0293b;
            }

            @Override // L5.l
            public /* bridge */ /* synthetic */ Object a(Object obj) {
                b((Throwable) obj);
                return C1824s.f24014a;
            }

            public final void b(Throwable th) {
                j jVar = this.f23992m;
                ViewTreeObserver viewTreeObserver = this.f23993n;
                m.d(viewTreeObserver, "viewTreeObserver");
                b.g(jVar, viewTreeObserver, this.f23994o);
            }
        }

        /* renamed from: y2.j$b$b, reason: collision with other inner class name */
        public static final class ViewTreeObserverOnPreDrawListenerC0293b implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: l, reason: collision with root package name */
            public boolean f23995l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ j f23996m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver f23997n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ InterfaceC0632m f23998o;

            public ViewTreeObserverOnPreDrawListenerC0293b(j jVar, ViewTreeObserver viewTreeObserver, InterfaceC0632m interfaceC0632m) {
                this.f23996m = jVar;
                this.f23997n = viewTreeObserver;
                this.f23998o = interfaceC0632m;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                c cVarE = b.e(this.f23996m);
                if (cVarE != null) {
                    j jVar = this.f23996m;
                    ViewTreeObserver viewTreeObserver = this.f23997n;
                    m.d(viewTreeObserver, "viewTreeObserver");
                    b.g(jVar, viewTreeObserver, this);
                    if (!this.f23995l) {
                        this.f23995l = true;
                        this.f23998o.resumeWith(C1814i.b(cVarE));
                    }
                }
                return true;
            }
        }

        public static int c(j jVar, int i7, int i8, int i9, boolean z7) {
            int i10 = i7 - i9;
            if (i10 > 0) {
                return i10;
            }
            int i11 = i8 - i9;
            if (i11 > 0) {
                return i11;
            }
            if (i7 != -2) {
                return -1;
            }
            DisplayMetrics displayMetrics = jVar.a().getContext().getResources().getDisplayMetrics();
            return z7 ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        }

        public static int d(j jVar) {
            ViewGroup.LayoutParams layoutParams = jVar.a().getLayoutParams();
            return c(jVar, layoutParams == null ? -1 : layoutParams.height, jVar.a().getHeight(), jVar.b() ? jVar.a().getPaddingTop() + jVar.a().getPaddingBottom() : 0, false);
        }

        public static c e(j jVar) {
            int iD;
            int iF = f(jVar);
            if (iF > 0 && (iD = d(jVar)) > 0) {
                return new c(iF, iD);
            }
            return null;
        }

        public static int f(j jVar) {
            ViewGroup.LayoutParams layoutParams = jVar.a().getLayoutParams();
            return c(jVar, layoutParams == null ? -1 : layoutParams.width, jVar.a().getWidth(), jVar.b() ? jVar.a().getPaddingLeft() + jVar.a().getPaddingRight() : 0, true);
        }

        public static void g(j jVar, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            } else {
                jVar.a().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
        }

        public static Object h(j jVar, C5.e eVar) {
            c cVarE = e(jVar);
            if (cVarE != null) {
                return cVarE;
            }
            C0636o c0636o = new C0636o(D5.b.c(eVar), 1);
            c0636o.F();
            ViewTreeObserver viewTreeObserver = jVar.a().getViewTreeObserver();
            ViewTreeObserverOnPreDrawListenerC0293b viewTreeObserverOnPreDrawListenerC0293b = new ViewTreeObserverOnPreDrawListenerC0293b(jVar, viewTreeObserver, c0636o);
            viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0293b);
            c0636o.h(new a(jVar, viewTreeObserver, viewTreeObserverOnPreDrawListenerC0293b));
            Object objY = c0636o.y();
            if (objY == D5.c.e()) {
                E5.h.c(eVar);
            }
            return objY;
        }
    }

    View a();

    boolean b();
}
