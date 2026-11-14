package Z1;

import Z.W;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.C1786a;
import y.C1793h;

/* renamed from: Z1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0735l implements Cloneable {

    /* renamed from: R, reason: collision with root package name */
    public static final int[] f10270R = {2, 1, 3, 4};

    /* renamed from: S, reason: collision with root package name */
    public static final AbstractC0730g f10271S = new a();

    /* renamed from: T, reason: collision with root package name */
    public static ThreadLocal f10272T = new ThreadLocal();

    /* renamed from: E, reason: collision with root package name */
    public ArrayList f10277E;

    /* renamed from: F, reason: collision with root package name */
    public ArrayList f10278F;

    /* renamed from: N, reason: collision with root package name */
    public AbstractC0738o f10286N;

    /* renamed from: O, reason: collision with root package name */
    public e f10287O;

    /* renamed from: P, reason: collision with root package name */
    public C1786a f10288P;

    /* renamed from: l, reason: collision with root package name */
    public String f10290l = getClass().getName();

    /* renamed from: m, reason: collision with root package name */
    public long f10291m = -1;

    /* renamed from: n, reason: collision with root package name */
    public long f10292n = -1;

    /* renamed from: o, reason: collision with root package name */
    public TimeInterpolator f10293o = null;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f10294p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f10295q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f10296r = null;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f10297s = null;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f10298t = null;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f10299u = null;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f10300v = null;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList f10301w = null;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList f10302x = null;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f10303y = null;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList f10304z = null;

    /* renamed from: A, reason: collision with root package name */
    public t f10273A = new t();

    /* renamed from: B, reason: collision with root package name */
    public t f10274B = new t();

    /* renamed from: C, reason: collision with root package name */
    public C0739p f10275C = null;

    /* renamed from: D, reason: collision with root package name */
    public int[] f10276D = f10270R;

    /* renamed from: G, reason: collision with root package name */
    public boolean f10279G = false;

    /* renamed from: H, reason: collision with root package name */
    public ArrayList f10280H = new ArrayList();

    /* renamed from: I, reason: collision with root package name */
    public int f10281I = 0;

    /* renamed from: J, reason: collision with root package name */
    public boolean f10282J = false;

    /* renamed from: K, reason: collision with root package name */
    public boolean f10283K = false;

    /* renamed from: L, reason: collision with root package name */
    public ArrayList f10284L = null;

    /* renamed from: M, reason: collision with root package name */
    public ArrayList f10285M = new ArrayList();

    /* renamed from: Q, reason: collision with root package name */
    public AbstractC0730g f10289Q = f10271S;

    /* renamed from: Z1.l$a */
    public class a extends AbstractC0730g {
        @Override // Z1.AbstractC0730g
        public Path a(float f7, float f8, float f9, float f10) {
            Path path = new Path();
            path.moveTo(f7, f8);
            path.lineTo(f9, f10);
            return path;
        }
    }

    /* renamed from: Z1.l$b */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1786a f10305a;

        public b(C1786a c1786a) {
            this.f10305a = c1786a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10305a.remove(animator);
            AbstractC0735l.this.f10280H.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC0735l.this.f10280H.add(animator);
        }
    }

    /* renamed from: Z1.l$c */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC0735l.this.s();
            animator.removeListener(this);
        }
    }

    /* renamed from: Z1.l$d */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public View f10308a;

        /* renamed from: b, reason: collision with root package name */
        public String f10309b;

        /* renamed from: c, reason: collision with root package name */
        public s f10310c;

        /* renamed from: d, reason: collision with root package name */
        public P f10311d;

        /* renamed from: e, reason: collision with root package name */
        public AbstractC0735l f10312e;

        public d(View view, String str, AbstractC0735l abstractC0735l, P p7, s sVar) {
            this.f10308a = view;
            this.f10309b = str;
            this.f10310c = sVar;
            this.f10311d = p7;
            this.f10312e = abstractC0735l;
        }
    }

    /* renamed from: Z1.l$e */
    public static abstract class e {
    }

    /* renamed from: Z1.l$f */
    public interface f {
        void a(AbstractC0735l abstractC0735l);

        void b(AbstractC0735l abstractC0735l);

        void c(AbstractC0735l abstractC0735l);

        void d(AbstractC0735l abstractC0735l);

        void e(AbstractC0735l abstractC0735l);
    }

    public static C1786a A() {
        C1786a c1786a = (C1786a) f10272T.get();
        if (c1786a != null) {
            return c1786a;
        }
        C1786a c1786a2 = new C1786a();
        f10272T.set(c1786a2);
        return c1786a2;
    }

    public static boolean K(s sVar, s sVar2, String str) {
        Object obj = sVar.f10333a.get(str);
        Object obj2 = sVar2.f10333a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void f(t tVar, View view, s sVar) {
        tVar.f10336a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f10337b.indexOfKey(id) >= 0) {
                tVar.f10337b.put(id, null);
            } else {
                tVar.f10337b.put(id, view);
            }
        }
        String strI = W.I(view);
        if (strI != null) {
            if (tVar.f10339d.containsKey(strI)) {
                tVar.f10339d.put(strI, null);
            } else {
                tVar.f10339d.put(strI, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f10338c.f(itemIdAtPosition) < 0) {
                    W.u0(view, true);
                    tVar.f10338c.h(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) tVar.f10338c.c(itemIdAtPosition);
                if (view2 != null) {
                    W.u0(view2, false);
                    tVar.f10338c.h(itemIdAtPosition, null);
                }
            }
        }
    }

    public long B() {
        return this.f10291m;
    }

    public List C() {
        return this.f10294p;
    }

    public List D() {
        return this.f10296r;
    }

    public List E() {
        return this.f10297s;
    }

    public List F() {
        return this.f10295q;
    }

    public String[] G() {
        return null;
    }

    public s H(View view, boolean z7) {
        C0739p c0739p = this.f10275C;
        if (c0739p != null) {
            return c0739p.H(view, z7);
        }
        return (s) (z7 ? this.f10273A : this.f10274B).f10336a.get(view);
    }

    public boolean I(s sVar, s sVar2) {
        if (sVar != null && sVar2 != null) {
            String[] strArrG = G();
            if (strArrG != null) {
                for (String str : strArrG) {
                    if (K(sVar, sVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = sVar.f10333a.keySet().iterator();
                while (it.hasNext()) {
                    if (K(sVar, sVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean J(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f10298t;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f10299u;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f10300v;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (((Class) this.f10300v.get(i7)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f10301w != null && W.I(view) != null && this.f10301w.contains(W.I(view))) {
            return false;
        }
        if ((this.f10294p.size() == 0 && this.f10295q.size() == 0 && (((arrayList = this.f10297s) == null || arrayList.isEmpty()) && ((arrayList2 = this.f10296r) == null || arrayList2.isEmpty()))) || this.f10294p.contains(Integer.valueOf(id)) || this.f10295q.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f10296r;
        if (arrayList6 != null && arrayList6.contains(W.I(view))) {
            return true;
        }
        if (this.f10297s != null) {
            for (int i8 = 0; i8 < this.f10297s.size(); i8++) {
                if (((Class) this.f10297s.get(i8)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void L(C1786a c1786a, C1786a c1786a2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) sparseArray.valueAt(i7);
            if (view2 != null && J(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i7))) != null && J(view)) {
                s sVar = (s) c1786a.get(view2);
                s sVar2 = (s) c1786a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f10277E.add(sVar);
                    this.f10278F.add(sVar2);
                    c1786a.remove(view2);
                    c1786a2.remove(view);
                }
            }
        }
    }

    public final void M(C1786a c1786a, C1786a c1786a2) {
        s sVar;
        for (int size = c1786a.size() - 1; size >= 0; size--) {
            View view = (View) c1786a.f(size);
            if (view != null && J(view) && (sVar = (s) c1786a2.remove(view)) != null && J(sVar.f10334b)) {
                this.f10277E.add((s) c1786a.h(size));
                this.f10278F.add(sVar);
            }
        }
    }

    public final void N(C1786a c1786a, C1786a c1786a2, C1793h c1793h, C1793h c1793h2) {
        View view;
        int iM = c1793h.m();
        for (int i7 = 0; i7 < iM; i7++) {
            View view2 = (View) c1793h.n(i7);
            if (view2 != null && J(view2) && (view = (View) c1793h2.c(c1793h.g(i7))) != null && J(view)) {
                s sVar = (s) c1786a.get(view2);
                s sVar2 = (s) c1786a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f10277E.add(sVar);
                    this.f10278F.add(sVar2);
                    c1786a.remove(view2);
                    c1786a2.remove(view);
                }
            }
        }
    }

    public final void O(C1786a c1786a, C1786a c1786a2, C1786a c1786a3, C1786a c1786a4) {
        View view;
        int size = c1786a3.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = (View) c1786a3.j(i7);
            if (view2 != null && J(view2) && (view = (View) c1786a4.get(c1786a3.f(i7))) != null && J(view)) {
                s sVar = (s) c1786a.get(view2);
                s sVar2 = (s) c1786a2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f10277E.add(sVar);
                    this.f10278F.add(sVar2);
                    c1786a.remove(view2);
                    c1786a2.remove(view);
                }
            }
        }
    }

    public final void P(t tVar, t tVar2) {
        C1786a c1786a = new C1786a(tVar.f10336a);
        C1786a c1786a2 = new C1786a(tVar2.f10336a);
        int i7 = 0;
        while (true) {
            int[] iArr = this.f10276D;
            if (i7 >= iArr.length) {
                c(c1786a, c1786a2);
                return;
            }
            int i8 = iArr[i7];
            if (i8 == 1) {
                M(c1786a, c1786a2);
            } else if (i8 == 2) {
                O(c1786a, c1786a2, tVar.f10339d, tVar2.f10339d);
            } else if (i8 == 3) {
                L(c1786a, c1786a2, tVar.f10337b, tVar2.f10337b);
            } else if (i8 == 4) {
                N(c1786a, c1786a2, tVar.f10338c, tVar2.f10338c);
            }
            i7++;
        }
    }

    public void Q(View view) {
        if (this.f10283K) {
            return;
        }
        for (int size = this.f10280H.size() - 1; size >= 0; size--) {
            AbstractC0724a.b((Animator) this.f10280H.get(size));
        }
        ArrayList arrayList = this.f10284L;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f10284L.clone();
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((f) arrayList2.get(i7)).a(this);
            }
        }
        this.f10282J = true;
    }

    public void R(ViewGroup viewGroup) {
        d dVar;
        this.f10277E = new ArrayList();
        this.f10278F = new ArrayList();
        P(this.f10273A, this.f10274B);
        C1786a c1786aA = A();
        int size = c1786aA.size();
        P pD = A.d(viewGroup);
        for (int i7 = size - 1; i7 >= 0; i7--) {
            Animator animator = (Animator) c1786aA.f(i7);
            if (animator != null && (dVar = (d) c1786aA.get(animator)) != null && dVar.f10308a != null && pD.equals(dVar.f10311d)) {
                s sVar = dVar.f10310c;
                View view = dVar.f10308a;
                s sVarH = H(view, true);
                s sVarW = w(view, true);
                if (sVarH == null && sVarW == null) {
                    sVarW = (s) this.f10274B.f10336a.get(view);
                }
                if ((sVarH != null || sVarW != null) && dVar.f10312e.I(sVar, sVarW)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        c1786aA.remove(animator);
                    }
                }
            }
        }
        r(viewGroup, this.f10273A, this.f10274B, this.f10277E, this.f10278F);
        W();
    }

    public AbstractC0735l S(f fVar) {
        ArrayList arrayList = this.f10284L;
        if (arrayList != null) {
            arrayList.remove(fVar);
            if (this.f10284L.size() == 0) {
                this.f10284L = null;
            }
        }
        return this;
    }

    public AbstractC0735l T(View view) {
        this.f10295q.remove(view);
        return this;
    }

    public void U(View view) {
        if (this.f10282J) {
            if (!this.f10283K) {
                for (int size = this.f10280H.size() - 1; size >= 0; size--) {
                    AbstractC0724a.c((Animator) this.f10280H.get(size));
                }
                ArrayList arrayList = this.f10284L;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f10284L.clone();
                    int size2 = arrayList2.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        ((f) arrayList2.get(i7)).c(this);
                    }
                }
            }
            this.f10282J = false;
        }
    }

    public final void V(Animator animator, C1786a c1786a) {
        if (animator != null) {
            animator.addListener(new b(c1786a));
            g(animator);
        }
    }

    public void W() {
        d0();
        C1786a c1786aA = A();
        ArrayList arrayList = this.f10285M;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            Animator animator = (Animator) obj;
            if (c1786aA.containsKey(animator)) {
                d0();
                V(animator, c1786aA);
            }
        }
        this.f10285M.clear();
        s();
    }

    public AbstractC0735l X(long j7) {
        this.f10292n = j7;
        return this;
    }

    public void Y(e eVar) {
        this.f10287O = eVar;
    }

    public AbstractC0735l Z(TimeInterpolator timeInterpolator) {
        this.f10293o = timeInterpolator;
        return this;
    }

    public AbstractC0735l a(f fVar) {
        if (this.f10284L == null) {
            this.f10284L = new ArrayList();
        }
        this.f10284L.add(fVar);
        return this;
    }

    public void a0(AbstractC0730g abstractC0730g) {
        if (abstractC0730g == null) {
            this.f10289Q = f10271S;
        } else {
            this.f10289Q = abstractC0730g;
        }
    }

    public AbstractC0735l b(View view) {
        this.f10295q.add(view);
        return this;
    }

    public void b0(AbstractC0738o abstractC0738o) {
        this.f10286N = abstractC0738o;
    }

    public final void c(C1786a c1786a, C1786a c1786a2) {
        for (int i7 = 0; i7 < c1786a.size(); i7++) {
            s sVar = (s) c1786a.j(i7);
            if (J(sVar.f10334b)) {
                this.f10277E.add(sVar);
                this.f10278F.add(null);
            }
        }
        for (int i8 = 0; i8 < c1786a2.size(); i8++) {
            s sVar2 = (s) c1786a2.j(i8);
            if (J(sVar2.f10334b)) {
                this.f10278F.add(sVar2);
                this.f10277E.add(null);
            }
        }
    }

    public AbstractC0735l c0(long j7) {
        this.f10291m = j7;
        return this;
    }

    public void cancel() {
        for (int size = this.f10280H.size() - 1; size >= 0; size--) {
            ((Animator) this.f10280H.get(size)).cancel();
        }
        ArrayList arrayList = this.f10284L;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.f10284L.clone();
        int size2 = arrayList2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            ((f) arrayList2.get(i7)).d(this);
        }
    }

    public void d0() {
        if (this.f10281I == 0) {
            ArrayList arrayList = this.f10284L;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f10284L.clone();
                int size = arrayList2.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((f) arrayList2.get(i7)).e(this);
                }
            }
            this.f10283K = false;
        }
        this.f10281I++;
    }

    public String e0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f10292n != -1) {
            str2 = str2 + "dur(" + this.f10292n + ") ";
        }
        if (this.f10291m != -1) {
            str2 = str2 + "dly(" + this.f10291m + ") ";
        }
        if (this.f10293o != null) {
            str2 = str2 + "interp(" + this.f10293o + ") ";
        }
        if (this.f10294p.size() <= 0 && this.f10295q.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f10294p.size() > 0) {
            for (int i7 = 0; i7 < this.f10294p.size(); i7++) {
                if (i7 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f10294p.get(i7);
            }
        }
        if (this.f10295q.size() > 0) {
            for (int i8 = 0; i8 < this.f10295q.size(); i8++) {
                if (i8 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f10295q.get(i8);
            }
        }
        return str3 + ")";
    }

    public void g(Animator animator) {
        if (animator == null) {
            s();
            return;
        }
        if (t() >= 0) {
            animator.setDuration(t());
        }
        if (B() >= 0) {
            animator.setStartDelay(B() + animator.getStartDelay());
        }
        if (v() != null) {
            animator.setInterpolator(v());
        }
        animator.addListener(new c());
        animator.start();
    }

    public abstract void h(s sVar);

    public final void k(View view, boolean z7) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f10298t;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f10299u;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f10300v;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (((Class) this.f10300v.get(i7)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z7) {
                        m(sVar);
                    } else {
                        h(sVar);
                    }
                    sVar.f10335c.add(this);
                    l(sVar);
                    if (z7) {
                        f(this.f10273A, view, sVar);
                    } else {
                        f(this.f10274B, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f10302x;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f10303y;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f10304z;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    if (((Class) this.f10304z.get(i8)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                                k(viewGroup.getChildAt(i9), z7);
                            }
                        }
                    }
                }
            }
        }
    }

    public void l(s sVar) {
        String[] strArrB;
        if (this.f10286N == null || sVar.f10333a.isEmpty() || (strArrB = this.f10286N.b()) == null) {
            return;
        }
        for (String str : strArrB) {
            if (!sVar.f10333a.containsKey(str)) {
                this.f10286N.a(sVar);
                return;
            }
        }
    }

    public abstract void m(s sVar);

    public void n(ViewGroup viewGroup, boolean z7) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C1786a c1786a;
        o(z7);
        if ((this.f10294p.size() > 0 || this.f10295q.size() > 0) && (((arrayList = this.f10296r) == null || arrayList.isEmpty()) && ((arrayList2 = this.f10297s) == null || arrayList2.isEmpty()))) {
            for (int i7 = 0; i7 < this.f10294p.size(); i7++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f10294p.get(i7)).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z7) {
                        m(sVar);
                    } else {
                        h(sVar);
                    }
                    sVar.f10335c.add(this);
                    l(sVar);
                    if (z7) {
                        f(this.f10273A, viewFindViewById, sVar);
                    } else {
                        f(this.f10274B, viewFindViewById, sVar);
                    }
                }
            }
            for (int i8 = 0; i8 < this.f10295q.size(); i8++) {
                View view = (View) this.f10295q.get(i8);
                s sVar2 = new s(view);
                if (z7) {
                    m(sVar2);
                } else {
                    h(sVar2);
                }
                sVar2.f10335c.add(this);
                l(sVar2);
                if (z7) {
                    f(this.f10273A, view, sVar2);
                } else {
                    f(this.f10274B, view, sVar2);
                }
            }
        } else {
            k(viewGroup, z7);
        }
        if (z7 || (c1786a = this.f10288P) == null) {
            return;
        }
        int size = c1786a.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i9 = 0; i9 < size; i9++) {
            arrayList3.add(this.f10273A.f10339d.remove((String) this.f10288P.f(i9)));
        }
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) arrayList3.get(i10);
            if (view2 != null) {
                this.f10273A.f10339d.put((String) this.f10288P.j(i10), view2);
            }
        }
    }

    public void o(boolean z7) {
        if (z7) {
            this.f10273A.f10336a.clear();
            this.f10273A.f10337b.clear();
            this.f10273A.f10338c.a();
        } else {
            this.f10274B.f10336a.clear();
            this.f10274B.f10337b.clear();
            this.f10274B.f10338c.a();
        }
    }

    @Override // 
    /* renamed from: p */
    public AbstractC0735l clone() {
        try {
            AbstractC0735l abstractC0735l = (AbstractC0735l) super.clone();
            abstractC0735l.f10285M = new ArrayList();
            abstractC0735l.f10273A = new t();
            abstractC0735l.f10274B = new t();
            abstractC0735l.f10277E = null;
            abstractC0735l.f10278F = null;
            return abstractC0735l;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator q(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public void r(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorQ;
        int i7;
        int i8;
        View view;
        s sVar;
        Animator animator;
        s sVar2;
        int i9;
        C1786a c1786aA = A();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = Long.MAX_VALUE;
        int i10 = 0;
        while (i10 < size) {
            s sVar3 = (s) arrayList.get(i10);
            s sVar4 = (s) arrayList2.get(i10);
            if (sVar3 != null && !sVar3.f10335c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f10335c.contains(this)) {
                sVar4 = null;
            }
            if (!(sVar3 == null && sVar4 == null) && ((sVar3 == null || sVar4 == null || I(sVar3, sVar4)) && (animatorQ = q(viewGroup, sVar3, sVar4)) != null)) {
                if (sVar4 != null) {
                    view = sVar4.f10334b;
                    String[] strArrG = G();
                    if (strArrG != null && strArrG.length > 0) {
                        sVar2 = new s(view);
                        i7 = size;
                        i8 = i10;
                        s sVar5 = (s) tVar2.f10336a.get(view);
                        if (sVar5 != null) {
                            int i11 = 0;
                            while (i11 < strArrG.length) {
                                Map map = sVar2.f10333a;
                                String[] strArr = strArrG;
                                String str = strArr[i11];
                                map.put(str, sVar5.f10333a.get(str));
                                i11++;
                                strArrG = strArr;
                            }
                        }
                        int size2 = c1786aA.size();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= size2) {
                                animator = animatorQ;
                                break;
                            }
                            d dVar = (d) c1786aA.get((Animator) c1786aA.f(i12));
                            if (dVar.f10310c != null && dVar.f10308a == view) {
                                i9 = size2;
                                if (dVar.f10309b.equals(x()) && dVar.f10310c.equals(sVar2)) {
                                    animator = null;
                                    break;
                                }
                            } else {
                                i9 = size2;
                            }
                            i12++;
                            size2 = i9;
                        }
                    } else {
                        i7 = size;
                        i8 = i10;
                        animator = animatorQ;
                        sVar2 = null;
                    }
                    animatorQ = animator;
                    sVar = sVar2;
                } else {
                    i7 = size;
                    i8 = i10;
                    view = sVar3.f10334b;
                    sVar = null;
                }
                if (animatorQ != null) {
                    AbstractC0738o abstractC0738o = this.f10286N;
                    if (abstractC0738o != null) {
                        long jC = abstractC0738o.c(viewGroup, this, sVar3, sVar4);
                        sparseIntArray.put(this.f10285M.size(), (int) jC);
                        jMin = Math.min(jC, jMin);
                    }
                    c1786aA.put(animatorQ, new d(view, x(), this, A.d(viewGroup), sVar));
                    this.f10285M.add(animatorQ);
                    jMin = jMin;
                }
            } else {
                i7 = size;
                i8 = i10;
            }
            i10 = i8 + 1;
            size = i7;
        }
        if (sparseIntArray.size() != 0) {
            for (int i13 = 0; i13 < sparseIntArray.size(); i13++) {
                Animator animator2 = (Animator) this.f10285M.get(sparseIntArray.keyAt(i13));
                animator2.setStartDelay((sparseIntArray.valueAt(i13) - jMin) + animator2.getStartDelay());
            }
        }
    }

    public void s() {
        int i7 = this.f10281I - 1;
        this.f10281I = i7;
        if (i7 == 0) {
            ArrayList arrayList = this.f10284L;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f10284L.clone();
                int size = arrayList2.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ((f) arrayList2.get(i8)).b(this);
                }
            }
            for (int i9 = 0; i9 < this.f10273A.f10338c.m(); i9++) {
                View view = (View) this.f10273A.f10338c.n(i9);
                if (view != null) {
                    W.u0(view, false);
                }
            }
            for (int i10 = 0; i10 < this.f10274B.f10338c.m(); i10++) {
                View view2 = (View) this.f10274B.f10338c.n(i10);
                if (view2 != null) {
                    W.u0(view2, false);
                }
            }
            this.f10283K = true;
        }
    }

    public long t() {
        return this.f10292n;
    }

    public String toString() {
        return e0("");
    }

    public e u() {
        return this.f10287O;
    }

    public TimeInterpolator v() {
        return this.f10293o;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f10278F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f10277E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return (Z1.s) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Z1.s w(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            Z1.p r0 = r5.f10275C
            if (r0 == 0) goto L9
            Z1.s r6 = r0.w(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f10277E
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f10278F
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            Z1.s r4 = (Z1.s) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f10334b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList r6 = r5.f10278F
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f10277E
        L36:
            java.lang.Object r6 = r6.get(r3)
            Z1.s r6 = (Z1.s) r6
            return r6
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: Z1.AbstractC0735l.w(android.view.View, boolean):Z1.s");
    }

    public String x() {
        return this.f10290l;
    }

    public AbstractC0730g y() {
        return this.f10289Q;
    }

    public AbstractC0738o z() {
        return this.f10286N;
    }
}
