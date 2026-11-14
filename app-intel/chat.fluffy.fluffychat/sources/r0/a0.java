package r0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import d.C0960e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import q0.AbstractC1489b;
import y5.C1823s;
import z5.C1889t;
import z5.C1892w;

/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: g, reason: collision with root package name */
    public static final a f21851g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f21852a;

    /* renamed from: b, reason: collision with root package name */
    public final List f21853b;

    /* renamed from: c, reason: collision with root package name */
    public final List f21854c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21855d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21856e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21857f;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final a0 a(ViewGroup viewGroup, AbstractC1516J abstractC1516J) {
            M5.m.e(viewGroup, "container");
            M5.m.e(abstractC1516J, "fragmentManager");
            b0 b0VarB0 = abstractC1516J.B0();
            M5.m.d(b0VarB0, "fragmentManager.specialEffectsControllerFactory");
            return b(viewGroup, b0VarB0);
        }

        public final a0 b(ViewGroup viewGroup, b0 b0Var) {
            M5.m.e(viewGroup, "container");
            M5.m.e(b0Var, "factory");
            Object tag = viewGroup.getTag(AbstractC1489b.f21399b);
            if (tag instanceof a0) {
                return (a0) tag;
            }
            a0 a0VarA = b0Var.a(viewGroup);
            M5.m.d(a0VarA, "factory.createController(container)");
            viewGroup.setTag(AbstractC1489b.f21399b, a0VarA);
            return a0VarA;
        }

        public a() {
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f21858a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21859b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21860c;

        public final void a(ViewGroup viewGroup) {
            M5.m.e(viewGroup, "container");
            if (!this.f21860c) {
                c(viewGroup);
            }
            this.f21860c = true;
        }

        public boolean b() {
            return this.f21858a;
        }

        public void c(ViewGroup viewGroup) {
            M5.m.e(viewGroup, "container");
        }

        public void d(ViewGroup viewGroup) {
            M5.m.e(viewGroup, "container");
        }

        public void e(C0960e c0960e, ViewGroup viewGroup) {
            M5.m.e(c0960e, "backEvent");
            M5.m.e(viewGroup, "container");
        }

        public void f(ViewGroup viewGroup) {
            M5.m.e(viewGroup, "container");
        }

        public final void g(ViewGroup viewGroup) {
            M5.m.e(viewGroup, "container");
            if (!this.f21859b) {
                f(viewGroup);
            }
            this.f21859b = true;
        }
    }

    public static final class c extends d {

        /* renamed from: l, reason: collision with root package name */
        public final C1522P f21861l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(d.b bVar, d.a aVar, C1522P c1522p) {
            M5.m.e(bVar, "finalState");
            M5.m.e(aVar, "lifecycleImpact");
            M5.m.e(c1522p, "fragmentStateManager");
            ComponentCallbacksC1548q componentCallbacksC1548qK = c1522p.k();
            M5.m.d(componentCallbacksC1548qK, "fragmentStateManager.fragment");
            super(bVar, aVar, componentCallbacksC1548qK);
            this.f21861l = c1522p;
        }

        @Override // r0.a0.d
        public void d() {
            super.d();
            h().f22048y = false;
            this.f21861l.m();
        }

        @Override // r0.a0.d
        public void p() {
            if (n()) {
                return;
            }
            super.p();
            if (i() != d.a.ADDING) {
                if (i() == d.a.REMOVING) {
                    ComponentCallbacksC1548q componentCallbacksC1548qK = this.f21861l.k();
                    M5.m.d(componentCallbacksC1548qK, "fragmentStateManager.fragment");
                    View viewT1 = componentCallbacksC1548qK.T1();
                    M5.m.d(viewT1, "fragment.requireView()");
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewT1.findFocus() + " on view " + viewT1 + " for Fragment " + componentCallbacksC1548qK);
                    }
                    viewT1.clearFocus();
                    return;
                }
                return;
            }
            ComponentCallbacksC1548q componentCallbacksC1548qK2 = this.f21861l.k();
            M5.m.d(componentCallbacksC1548qK2, "fragmentStateManager.fragment");
            View viewFindFocus = componentCallbacksC1548qK2.f22015V.findFocus();
            if (viewFindFocus != null) {
                componentCallbacksC1548qK2.Z1(viewFindFocus);
                if (AbstractC1516J.J0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + componentCallbacksC1548qK2);
                }
            }
            View viewT12 = h().T1();
            M5.m.d(viewT12, "this.fragment.requireView()");
            if (viewT12.getParent() == null) {
                if (AbstractC1516J.J0(2)) {
                    Log.v("FragmentManager", "Adding fragment " + componentCallbacksC1548qK2 + " view " + viewT12 + " to container in onStart");
                }
                this.f21861l.b();
                viewT12.setAlpha(0.0f);
            }
            if (viewT12.getAlpha() == 0.0f && viewT12.getVisibility() == 0) {
                if (AbstractC1516J.J0(2)) {
                    Log.v("FragmentManager", "Making view " + viewT12 + " INVISIBLE in onStart");
                }
                viewT12.setVisibility(4);
            }
            viewT12.setAlpha(componentCallbacksC1548qK2.o0());
            if (AbstractC1516J.J0(2)) {
                Log.v("FragmentManager", "Setting view alpha to " + componentCallbacksC1548qK2.o0() + " in onStart");
            }
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public b f21862a;

        /* renamed from: b, reason: collision with root package name */
        public a f21863b;

        /* renamed from: c, reason: collision with root package name */
        public final ComponentCallbacksC1548q f21864c;

        /* renamed from: d, reason: collision with root package name */
        public final List f21865d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f21866e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f21867f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f21868g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f21869h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f21870i;

        /* renamed from: j, reason: collision with root package name */
        public final List f21871j;

        /* renamed from: k, reason: collision with root package name */
        public final List f21872k;

        public enum a {
            NONE,
            ADDING,
            REMOVING
        }

        public enum b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            /* renamed from: l, reason: collision with root package name */
            public static final a f21877l = new a(null);

            public static final class a {
                public /* synthetic */ a(M5.g gVar) {
                    this();
                }

                public final b a(View view) {
                    M5.m.e(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i7) {
                    if (i7 == 0) {
                        return b.VISIBLE;
                    }
                    if (i7 == 4) {
                        return b.INVISIBLE;
                    }
                    if (i7 == 8) {
                        return b.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i7);
                }

                public a() {
                }
            }

            /* renamed from: r0.a0$d$b$b, reason: collision with other inner class name */
            public /* synthetic */ class C0260b {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f21883a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f21883a = iArr;
                }
            }

            public static final b e(int i7) {
                return f21877l.b(i7);
            }

            public final void d(View view, ViewGroup viewGroup) {
                M5.m.e(view, "view");
                M5.m.e(viewGroup, "container");
                if (AbstractC1516J.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Calling apply state");
                }
                int i7 = C0260b.f21883a[ordinal()];
                if (i7 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup2 != null) {
                        if (AbstractC1516J.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup2);
                        }
                        viewGroup2.removeView(view);
                        return;
                    }
                    return;
                }
                if (i7 == 2) {
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (AbstractC1516J.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + viewGroup);
                        }
                        viewGroup.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i7 == 3) {
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i7 != 4) {
                    return;
                }
                if (AbstractC1516J.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public /* synthetic */ class c {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f21884a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f21884a = iArr;
            }
        }

        public d(b bVar, a aVar, ComponentCallbacksC1548q componentCallbacksC1548q) {
            M5.m.e(bVar, "finalState");
            M5.m.e(aVar, "lifecycleImpact");
            M5.m.e(componentCallbacksC1548q, "fragment");
            this.f21862a = bVar;
            this.f21863b = aVar;
            this.f21864c = componentCallbacksC1548q;
            this.f21865d = new ArrayList();
            this.f21870i = true;
            ArrayList arrayList = new ArrayList();
            this.f21871j = arrayList;
            this.f21872k = arrayList;
        }

        public final void a(Runnable runnable) {
            M5.m.e(runnable, "listener");
            this.f21865d.add(runnable);
        }

        public final void b(b bVar) {
            M5.m.e(bVar, "effect");
            this.f21871j.add(bVar);
        }

        public final void c(ViewGroup viewGroup) {
            M5.m.e(viewGroup, "container");
            this.f21869h = false;
            if (this.f21866e) {
                return;
            }
            this.f21866e = true;
            if (this.f21871j.isEmpty()) {
                d();
                return;
            }
            Iterator it = C1892w.X(this.f21872k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(viewGroup);
            }
        }

        public void d() {
            this.f21869h = false;
            if (this.f21867f) {
                return;
            }
            if (AbstractC1516J.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f21867f = true;
            Iterator it = this.f21865d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void e(b bVar) {
            M5.m.e(bVar, "effect");
            if (this.f21871j.remove(bVar) && this.f21871j.isEmpty()) {
                d();
            }
        }

        public final List f() {
            return this.f21872k;
        }

        public final b g() {
            return this.f21862a;
        }

        public final ComponentCallbacksC1548q h() {
            return this.f21864c;
        }

        public final a i() {
            return this.f21863b;
        }

        public final boolean j() {
            return this.f21870i;
        }

        public final boolean k() {
            return this.f21866e;
        }

        public final boolean l() {
            return this.f21867f;
        }

        public final boolean m() {
            return this.f21868g;
        }

        public final boolean n() {
            return this.f21869h;
        }

        public final void o(b bVar, a aVar) {
            M5.m.e(bVar, "finalState");
            M5.m.e(aVar, "lifecycleImpact");
            int i7 = c.f21884a[aVar.ordinal()];
            if (i7 == 1) {
                if (this.f21862a == b.REMOVED) {
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f21864c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f21863b + " to ADDING.");
                    }
                    this.f21862a = b.VISIBLE;
                    this.f21863b = a.ADDING;
                    this.f21870i = true;
                    return;
                }
                return;
            }
            if (i7 == 2) {
                if (AbstractC1516J.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f21864c + " mFinalState = " + this.f21862a + " -> REMOVED. mLifecycleImpact  = " + this.f21863b + " to REMOVING.");
                }
                this.f21862a = b.REMOVED;
                this.f21863b = a.REMOVING;
                this.f21870i = true;
                return;
            }
            if (i7 == 3 && this.f21862a != b.REMOVED) {
                if (AbstractC1516J.J0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f21864c + " mFinalState = " + this.f21862a + " -> " + bVar + '.');
                }
                this.f21862a = bVar;
            }
        }

        public void p() {
            this.f21869h = true;
        }

        public final void q(boolean z7) {
            this.f21870i = z7;
        }

        public final void r(boolean z7) {
            this.f21868g = z7;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f21862a + " lifecycleImpact = " + this.f21863b + " fragment = " + this.f21864c + '}';
        }
    }

    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21885a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f21885a = iArr;
        }
    }

    public a0(ViewGroup viewGroup) {
        M5.m.e(viewGroup, "container");
        this.f21852a = viewGroup;
        this.f21853b = new ArrayList();
        this.f21854c = new ArrayList();
    }

    public static final void h(a0 a0Var, c cVar) {
        M5.m.e(a0Var, "this$0");
        M5.m.e(cVar, "$operation");
        if (a0Var.f21853b.contains(cVar)) {
            d.b bVarG = cVar.g();
            View view = cVar.h().f22015V;
            M5.m.d(view, "operation.fragment.mView");
            bVarG.d(view, a0Var.f21852a);
        }
    }

    public static final void i(a0 a0Var, c cVar) {
        M5.m.e(a0Var, "this$0");
        M5.m.e(cVar, "$operation");
        a0Var.f21853b.remove(cVar);
        a0Var.f21854c.remove(cVar);
    }

    public static final a0 u(ViewGroup viewGroup, AbstractC1516J abstractC1516J) {
        return f21851g.a(viewGroup, abstractC1516J);
    }

    public static final a0 v(ViewGroup viewGroup, b0 b0Var) {
        return f21851g.b(viewGroup, b0Var);
    }

    public final void A(C0960e c0960e) {
        M5.m.e(c0960e, "backEvent");
        if (AbstractC1516J.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + c0960e.a());
        }
        List list = this.f21854c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1889t.q(arrayList, ((d) it.next()).f());
        }
        List listX = C1892w.X(C1892w.b0(arrayList));
        int size = listX.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((b) listX.get(i7)).e(c0960e, this.f21852a);
        }
    }

    public final void B(List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((d) list.get(i7)).p();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1889t.q(arrayList, ((d) it.next()).f());
        }
        List listX = C1892w.X(C1892w.b0(arrayList));
        int size2 = listX.size();
        for (int i8 = 0; i8 < size2; i8++) {
            ((b) listX.get(i8)).g(this.f21852a);
        }
    }

    public final void C() {
        for (d dVar : this.f21853b) {
            if (dVar.i() == d.a.ADDING) {
                View viewT1 = dVar.h().T1();
                M5.m.d(viewT1, "fragment.requireView()");
                dVar.o(d.b.f21877l.b(viewT1.getVisibility()), d.a.NONE);
            }
        }
    }

    public final void D(boolean z7) {
        this.f21856e = z7;
    }

    public final void c(d dVar) {
        M5.m.e(dVar, "operation");
        if (dVar.j()) {
            d.b bVarG = dVar.g();
            View viewT1 = dVar.h().T1();
            M5.m.d(viewT1, "operation.fragment.requireView()");
            bVarG.d(viewT1, this.f21852a);
            dVar.q(false);
        }
    }

    public abstract void d(List list, boolean z7);

    public void e(List list) {
        M5.m.e(list, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1889t.q(arrayList, ((d) it.next()).f());
        }
        List listX = C1892w.X(C1892w.b0(arrayList));
        int size = listX.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((b) listX.get(i7)).d(this.f21852a);
        }
        int size2 = list.size();
        for (int i8 = 0; i8 < size2; i8++) {
            c((d) list.get(i8));
        }
        List listX2 = C1892w.X(list);
        int size3 = listX2.size();
        for (int i9 = 0; i9 < size3; i9++) {
            d dVar = (d) listX2.get(i9);
            if (dVar.f().isEmpty()) {
                dVar.d();
            }
        }
    }

    public final void f() {
        if (AbstractC1516J.J0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        B(this.f21854c);
        e(this.f21854c);
    }

    public final void g(d.b bVar, d.a aVar, C1522P c1522p) {
        synchronized (this.f21853b) {
            try {
                ComponentCallbacksC1548q componentCallbacksC1548qK = c1522p.k();
                M5.m.d(componentCallbacksC1548qK, "fragmentStateManager.fragment");
                d dVarO = o(componentCallbacksC1548qK);
                if (dVarO == null) {
                    if (c1522p.k().f22048y || c1522p.k().f22047x) {
                        ComponentCallbacksC1548q componentCallbacksC1548qK2 = c1522p.k();
                        M5.m.d(componentCallbacksC1548qK2, "fragmentStateManager.fragment");
                        dVarO = p(componentCallbacksC1548qK2);
                    } else {
                        dVarO = null;
                    }
                }
                if (dVarO != null) {
                    dVarO.o(bVar, aVar);
                    return;
                }
                final c cVar = new c(bVar, aVar, c1522p);
                this.f21853b.add(cVar);
                cVar.a(new Runnable() { // from class: r0.Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        a0.h(this.f21843l, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: r0.Z
                    @Override // java.lang.Runnable
                    public final void run() {
                        a0.i(this.f21845l, cVar);
                    }
                });
                C1823s c1823s = C1823s.f24020a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(d.b bVar, C1522P c1522p) {
        M5.m.e(bVar, "finalState");
        M5.m.e(c1522p, "fragmentStateManager");
        if (AbstractC1516J.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + c1522p.k());
        }
        g(bVar, d.a.ADDING, c1522p);
    }

    public final void k(C1522P c1522p) {
        M5.m.e(c1522p, "fragmentStateManager");
        if (AbstractC1516J.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + c1522p.k());
        }
        g(d.b.GONE, d.a.NONE, c1522p);
    }

    public final void l(C1522P c1522p) {
        M5.m.e(c1522p, "fragmentStateManager");
        if (AbstractC1516J.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + c1522p.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, c1522p);
    }

    public final void m(C1522P c1522p) {
        M5.m.e(c1522p, "fragmentStateManager");
        if (AbstractC1516J.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + c1522p.k());
        }
        g(d.b.VISIBLE, d.a.NONE, c1522p);
    }

    public final void n() {
        boolean z7;
        if (this.f21857f) {
            return;
        }
        if (!this.f21852a.isAttachedToWindow()) {
            q();
            this.f21856e = false;
            return;
        }
        synchronized (this.f21853b) {
            try {
                List<d> listZ = C1892w.Z(this.f21854c);
                this.f21854c.clear();
                Iterator it = listZ.iterator();
                while (true) {
                    z7 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    d dVar = (d) it.next();
                    if (this.f21853b.isEmpty() || !dVar.h().f22048y) {
                        z7 = false;
                    }
                    dVar.r(z7);
                }
                for (d dVar2 : listZ) {
                    if (this.f21855d) {
                        if (AbstractC1516J.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + dVar2);
                        }
                        dVar2.d();
                    } else {
                        if (AbstractC1516J.J0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + dVar2);
                        }
                        dVar2.c(this.f21852a);
                    }
                    this.f21855d = false;
                    if (!dVar2.l()) {
                        this.f21854c.add(dVar2);
                    }
                }
                if (!this.f21853b.isEmpty()) {
                    C();
                    List listZ2 = C1892w.Z(this.f21853b);
                    if (listZ2.isEmpty()) {
                        return;
                    }
                    this.f21853b.clear();
                    this.f21854c.addAll(listZ2);
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    d(listZ2, this.f21856e);
                    boolean zW = w(listZ2);
                    boolean zX = x(listZ2);
                    if (!zX || zW) {
                        z7 = false;
                    }
                    this.f21855d = z7;
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + zW + " \ntransition = " + zX);
                    }
                    if (!zX) {
                        B(listZ2);
                        e(listZ2);
                    } else if (zW) {
                        B(listZ2);
                        int size = listZ2.size();
                        for (int i7 = 0; i7 < size; i7++) {
                            c((d) listZ2.get(i7));
                        }
                    }
                    this.f21856e = false;
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                C1823s c1823s = C1823s.f24020a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final d o(ComponentCallbacksC1548q componentCallbacksC1548q) {
        Object next;
        Iterator it = this.f21853b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (M5.m.a(dVar.h(), componentCallbacksC1548q) && !dVar.k()) {
                break;
            }
        }
        return (d) next;
    }

    public final d p(ComponentCallbacksC1548q componentCallbacksC1548q) {
        Object next;
        Iterator it = this.f21854c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (M5.m.a(dVar.h(), componentCallbacksC1548q) && !dVar.k()) {
                break;
            }
        }
        return (d) next;
    }

    public final void q() {
        if (AbstractC1516J.J0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f21852a.isAttachedToWindow();
        synchronized (this.f21853b) {
            try {
                C();
                B(this.f21853b);
                List<d> listZ = C1892w.Z(this.f21854c);
                Iterator it = listZ.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).r(false);
                }
                for (d dVar : listZ) {
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f21852a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                    }
                    dVar.c(this.f21852a);
                }
                List<d> listZ2 = C1892w.Z(this.f21853b);
                Iterator it2 = listZ2.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).r(false);
                }
                for (d dVar2 : listZ2) {
                    if (AbstractC1516J.J0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f21852a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                    }
                    dVar2.c(this.f21852a);
                }
                C1823s c1823s = C1823s.f24020a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f21857f) {
            if (AbstractC1516J.J0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f21857f = false;
            n();
        }
    }

    public final d.a s(C1522P c1522p) {
        M5.m.e(c1522p, "fragmentStateManager");
        ComponentCallbacksC1548q componentCallbacksC1548qK = c1522p.k();
        M5.m.d(componentCallbacksC1548qK, "fragmentStateManager.fragment");
        d dVarO = o(componentCallbacksC1548qK);
        d.a aVarI = dVarO != null ? dVarO.i() : null;
        d dVarP = p(componentCallbacksC1548qK);
        d.a aVarI2 = dVarP != null ? dVarP.i() : null;
        int i7 = aVarI == null ? -1 : e.f21885a[aVarI.ordinal()];
        return (i7 == -1 || i7 == 1) ? aVarI2 : aVarI;
    }

    public final ViewGroup t() {
        return this.f21852a;
    }

    public final boolean w(List list) {
        boolean z7;
        Iterator it = list.iterator();
        loop0: while (true) {
            z7 = true;
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (!dVar.f().isEmpty()) {
                    List listF = dVar.f();
                    if (listF == null || !listF.isEmpty()) {
                        Iterator it2 = listF.iterator();
                        while (it2.hasNext()) {
                            if (!((b) it2.next()).b()) {
                                break;
                            }
                        }
                    }
                }
                z7 = false;
            }
            break loop0;
        }
        if (z7) {
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                C1889t.q(arrayList, ((d) it3.next()).f());
            }
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean x(List list) {
        Iterator it = list.iterator();
        boolean z7 = true;
        while (it.hasNext()) {
            if (!((d) it.next()).h().f22048y) {
                z7 = false;
            }
        }
        return z7;
    }

    public final boolean y() {
        return !this.f21853b.isEmpty();
    }

    public final void z() {
        Object objPrevious;
        synchronized (this.f21853b) {
            try {
                C();
                List list = this.f21853b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    d dVar = (d) objPrevious;
                    d.b.a aVar = d.b.f21877l;
                    View view = dVar.h().f22015V;
                    M5.m.d(view, "operation.fragment.mView");
                    d.b bVarA = aVar.a(view);
                    d.b bVarG = dVar.g();
                    d.b bVar = d.b.VISIBLE;
                    if (bVarG == bVar && bVarA != bVar) {
                        break;
                    }
                }
                d dVar2 = (d) objPrevious;
                ComponentCallbacksC1548q componentCallbacksC1548qH = dVar2 != null ? dVar2.h() : null;
                this.f21857f = componentCallbacksC1548qH != null ? componentCallbacksC1548qH.H0() : false;
                C1823s c1823s = C1823s.f24020a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
