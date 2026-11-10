package Z1;

import Z1.AbstractC0734l;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: Z1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0738p extends AbstractC0734l {

    /* renamed from: W, reason: collision with root package name */
    public int f10324W;

    /* renamed from: U, reason: collision with root package name */
    public ArrayList f10322U = new ArrayList();

    /* renamed from: V, reason: collision with root package name */
    public boolean f10323V = true;

    /* renamed from: X, reason: collision with root package name */
    public boolean f10325X = false;

    /* renamed from: Y, reason: collision with root package name */
    public int f10326Y = 0;

    /* renamed from: Z1.p$a */
    public class a extends C0735m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0734l f10327a;

        public a(AbstractC0734l abstractC0734l) {
            this.f10327a = abstractC0734l;
        }

        @Override // Z1.C0735m, Z1.AbstractC0734l.f
        public void b(AbstractC0734l abstractC0734l) {
            this.f10327a.W();
            abstractC0734l.S(this);
        }
    }

    /* renamed from: Z1.p$b */
    public static class b extends C0735m {

        /* renamed from: a, reason: collision with root package name */
        public C0738p f10329a;

        public b(C0738p c0738p) {
            this.f10329a = c0738p;
        }

        @Override // Z1.C0735m, Z1.AbstractC0734l.f
        public void b(AbstractC0734l abstractC0734l) {
            C0738p c0738p = this.f10329a;
            int i7 = c0738p.f10324W - 1;
            c0738p.f10324W = i7;
            if (i7 == 0) {
                c0738p.f10325X = false;
                c0738p.s();
            }
            abstractC0734l.S(this);
        }

        @Override // Z1.C0735m, Z1.AbstractC0734l.f
        public void e(AbstractC0734l abstractC0734l) {
            C0738p c0738p = this.f10329a;
            if (c0738p.f10325X) {
                return;
            }
            c0738p.d0();
            this.f10329a.f10325X = true;
        }
    }

    @Override // Z1.AbstractC0734l
    public void Q(View view) {
        super.Q(view);
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).Q(view);
        }
    }

    @Override // Z1.AbstractC0734l
    public void U(View view) {
        super.U(view);
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).U(view);
        }
    }

    @Override // Z1.AbstractC0734l
    public void W() {
        if (this.f10322U.isEmpty()) {
            d0();
            s();
            return;
        }
        r0();
        int i7 = 0;
        if (this.f10323V) {
            ArrayList arrayList = this.f10322U;
            int size = arrayList.size();
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                ((AbstractC0734l) obj).W();
            }
            return;
        }
        for (int i8 = 1; i8 < this.f10322U.size(); i8++) {
            ((AbstractC0734l) this.f10322U.get(i8 - 1)).a(new a((AbstractC0734l) this.f10322U.get(i8)));
        }
        AbstractC0734l abstractC0734l = (AbstractC0734l) this.f10322U.get(0);
        if (abstractC0734l != null) {
            abstractC0734l.W();
        }
    }

    @Override // Z1.AbstractC0734l
    public void Y(AbstractC0734l.e eVar) {
        super.Y(eVar);
        this.f10326Y |= 8;
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).Y(eVar);
        }
    }

    @Override // Z1.AbstractC0734l
    public void a0(AbstractC0729g abstractC0729g) {
        super.a0(abstractC0729g);
        this.f10326Y |= 4;
        if (this.f10322U != null) {
            for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
                ((AbstractC0734l) this.f10322U.get(i7)).a0(abstractC0729g);
            }
        }
    }

    @Override // Z1.AbstractC0734l
    public void b0(AbstractC0737o abstractC0737o) {
        super.b0(abstractC0737o);
        this.f10326Y |= 2;
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).b0(abstractC0737o);
        }
    }

    @Override // Z1.AbstractC0734l
    public void cancel() {
        super.cancel();
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).cancel();
        }
    }

    @Override // Z1.AbstractC0734l
    public String e0(String str) {
        String strE0 = super.e0(str);
        for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strE0);
            sb.append("\n");
            sb.append(((AbstractC0734l) this.f10322U.get(i7)).e0(str + "  "));
            strE0 = sb.toString();
        }
        return strE0;
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public C0738p a(AbstractC0734l.f fVar) {
        return (C0738p) super.a(fVar);
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public C0738p b(View view) {
        for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).b(view);
        }
        return (C0738p) super.b(view);
    }

    @Override // Z1.AbstractC0734l
    public void h(s sVar) {
        if (J(sVar.f10334b)) {
            ArrayList arrayList = this.f10322U;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                AbstractC0734l abstractC0734l = (AbstractC0734l) obj;
                if (abstractC0734l.J(sVar.f10334b)) {
                    abstractC0734l.h(sVar);
                    sVar.f10335c.add(abstractC0734l);
                }
            }
        }
    }

    public C0738p h0(AbstractC0734l abstractC0734l) {
        i0(abstractC0734l);
        long j7 = this.f10292n;
        if (j7 >= 0) {
            abstractC0734l.X(j7);
        }
        if ((this.f10326Y & 1) != 0) {
            abstractC0734l.Z(v());
        }
        if ((this.f10326Y & 2) != 0) {
            abstractC0734l.b0(z());
        }
        if ((this.f10326Y & 4) != 0) {
            abstractC0734l.a0(y());
        }
        if ((this.f10326Y & 8) != 0) {
            abstractC0734l.Y(u());
        }
        return this;
    }

    public final void i0(AbstractC0734l abstractC0734l) {
        this.f10322U.add(abstractC0734l);
        abstractC0734l.f10275C = this;
    }

    public AbstractC0734l j0(int i7) {
        if (i7 < 0 || i7 >= this.f10322U.size()) {
            return null;
        }
        return (AbstractC0734l) this.f10322U.get(i7);
    }

    public int k0() {
        return this.f10322U.size();
    }

    @Override // Z1.AbstractC0734l
    public void l(s sVar) {
        super.l(sVar);
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).l(sVar);
        }
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C0738p S(AbstractC0734l.f fVar) {
        return (C0738p) super.S(fVar);
    }

    @Override // Z1.AbstractC0734l
    public void m(s sVar) {
        if (J(sVar.f10334b)) {
            ArrayList arrayList = this.f10322U;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                AbstractC0734l abstractC0734l = (AbstractC0734l) obj;
                if (abstractC0734l.J(sVar.f10334b)) {
                    abstractC0734l.m(sVar);
                    sVar.f10335c.add(abstractC0734l);
                }
            }
        }
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C0738p T(View view) {
        for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
            ((AbstractC0734l) this.f10322U.get(i7)).T(view);
        }
        return (C0738p) super.T(view);
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public C0738p X(long j7) {
        ArrayList arrayList;
        super.X(j7);
        if (this.f10292n >= 0 && (arrayList = this.f10322U) != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((AbstractC0734l) this.f10322U.get(i7)).X(j7);
            }
        }
        return this;
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public C0738p Z(TimeInterpolator timeInterpolator) {
        this.f10326Y |= 1;
        ArrayList arrayList = this.f10322U;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((AbstractC0734l) this.f10322U.get(i7)).Z(timeInterpolator);
            }
        }
        return (C0738p) super.Z(timeInterpolator);
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC0734l clone() {
        C0738p c0738p = (C0738p) super.clone();
        c0738p.f10322U = new ArrayList();
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            c0738p.i0(((AbstractC0734l) this.f10322U.get(i7)).clone());
        }
        return c0738p;
    }

    public C0738p p0(int i7) {
        if (i7 == 0) {
            this.f10323V = true;
            return this;
        }
        if (i7 == 1) {
            this.f10323V = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i7);
    }

    @Override // Z1.AbstractC0734l
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public C0738p c0(long j7) {
        return (C0738p) super.c0(j7);
    }

    @Override // Z1.AbstractC0734l
    public void r(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jB = B();
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            AbstractC0734l abstractC0734l = (AbstractC0734l) this.f10322U.get(i7);
            if (jB > 0 && (this.f10323V || i7 == 0)) {
                long jB2 = abstractC0734l.B();
                if (jB2 > 0) {
                    abstractC0734l.c0(jB2 + jB);
                } else {
                    abstractC0734l.c0(jB);
                }
            }
            abstractC0734l.r(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    public final void r0() {
        b bVar = new b(this);
        ArrayList arrayList = this.f10322U;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            ((AbstractC0734l) obj).a(bVar);
        }
        this.f10324W = this.f10322U.size();
    }
}
