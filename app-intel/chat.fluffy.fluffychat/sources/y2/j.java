package y2;

import L5.l;
import M5.m;
import M5.n;
import W5.C0637o;
import W5.InterfaceC0633m;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import y5.C1813i;
import y5.C1823s;

/* loaded from: classes.dex */
public interface j extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f23996b = a.f23997a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f23997a = new a();

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
            public final /* synthetic */ j f23998m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver f23999n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserverOnPreDrawListenerC0293b f24000o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar, ViewTreeObserver viewTreeObserver, ViewTreeObserverOnPreDrawListenerC0293b viewTreeObserverOnPreDrawListenerC0293b) {
                super(1);
                this.f23998m = jVar;
                this.f23999n = viewTreeObserver;
                this.f24000o = viewTreeObserverOnPreDrawListenerC0293b;
            }

            @Override // L5.l
            public /* bridge */ /* synthetic */ Object a(Object obj) {
                b((Throwable) obj);
                return C1823s.f24020a;
            }

            public final void b(Throwable th) {
                j jVar = this.f23998m;
                ViewTreeObserver viewTreeObserver = this.f23999n;
                m.d(viewTreeObserver, "viewTreeObserver");
                b.g(jVar, viewTreeObserver, this.f24000o);
            }
        }

        /* renamed from: y2.j$b$b, reason: collision with other inner class name */
        public static final class ViewTreeObserverOnPreDrawListenerC0293b implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: l, reason: collision with root package name */
            public boolean f24001l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ j f24002m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver f24003n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ InterfaceC0633m f24004o;

            public ViewTreeObserverOnPreDrawListenerC0293b(j jVar, ViewTreeObserver viewTreeObserver, InterfaceC0633m interfaceC0633m) {
                this.f24002m = jVar;
                this.f24003n = viewTreeObserver;
                this.f24004o = interfaceC0633m;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                c cVarE = b.e(this.f24002m);
                if (cVarE != null) {
                    j jVar = this.f24002m;
                    ViewTreeObserver viewTreeObserver = this.f24003n;
                    m.d(viewTreeObserver, "viewTreeObserver");
                    b.g(jVar, viewTreeObserver, this);
                    if (!this.f24001l) {
                        this.f24001l = true;
                        this.f24004o.resumeWith(C1813i.b(cVarE));
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
            C0637o c0637o = new C0637o(D5.b.c(eVar), 1);
            c0637o.F();
            ViewTreeObserver viewTreeObserver = jVar.a().getViewTreeObserver();
            ViewTreeObserverOnPreDrawListenerC0293b viewTreeObserverOnPreDrawListenerC0293b = new ViewTreeObserverOnPreDrawListenerC0293b(jVar, viewTreeObserver, c0637o);
            viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0293b);
            c0637o.h(new a(jVar, viewTreeObserver, viewTreeObserverOnPreDrawListenerC0293b));
            Object objY = c0637o.y();
            if (objY == D5.c.e()) {
                E5.h.c(eVar);
            }
            return objY;
        }
    }

    View a();

    boolean b();
}
