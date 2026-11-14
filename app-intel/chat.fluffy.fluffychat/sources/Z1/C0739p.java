package Z1;

import Z1.AbstractC0735l;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: Z1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0739p extends AbstractC0735l {

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
    public class a extends C0736m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0735l f10327a;

        public a(AbstractC0735l abstractC0735l) {
            this.f10327a = abstractC0735l;
        }

        @Override // Z1.C0736m, Z1.AbstractC0735l.f
        public void b(AbstractC0735l abstractC0735l) {
            this.f10327a.W();
            abstractC0735l.S(this);
        }
    }

    /* renamed from: Z1.p$b */
    public static class b extends C0736m {

        /* renamed from: a, reason: collision with root package name */
        public C0739p f10329a;

        public b(C0739p c0739p) {
            this.f10329a = c0739p;
        }

        @Override // Z1.C0736m, Z1.AbstractC0735l.f
        public void b(AbstractC0735l abstractC0735l) {
            C0739p c0739p = this.f10329a;
            int i7 = c0739p.f10324W - 1;
            c0739p.f10324W = i7;
            if (i7 == 0) {
                c0739p.f10325X = false;
                c0739p.s();
            }
            abstractC0735l.S(this);
        }

        @Override // Z1.C0736m, Z1.AbstractC0735l.f
        public void e(AbstractC0735l abstractC0735l) {
            C0739p c0739p = this.f10329a;
            if (c0739p.f10325X) {
                return;
            }
            c0739p.d0();
            this.f10329a.f10325X = true;
        }
    }

    @Override // Z1.AbstractC0735l
    public void Q(View view) {
        super.Q(view);
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).Q(view);
        }
    }

    @Override // Z1.AbstractC0735l
    public void U(View view) {
        super.U(view);
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).U(view);
        }
    }

    @Override // Z1.AbstractC0735l
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
                ((AbstractC0735l) obj).W();
            }
            return;
        }
        for (int i8 = 1; i8 < this.f10322U.size(); i8++) {
            ((AbstractC0735l) this.f10322U.get(i8 - 1)).a(new a((AbstractC0735l) this.f10322U.get(i8)));
        }
        AbstractC0735l abstractC0735l = (AbstractC0735l) this.f10322U.get(0);
        if (abstractC0735l != null) {
            abstractC0735l.W();
        }
    }

    @Override // Z1.AbstractC0735l
    public void Y(AbstractC0735l.e eVar) {
        super.Y(eVar);
        this.f10326Y |= 8;
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).Y(eVar);
        }
    }

    @Override // Z1.AbstractC0735l
    public void a0(AbstractC0730g abstractC0730g) {
        super.a0(abstractC0730g);
        this.f10326Y |= 4;
        if (this.f10322U != null) {
            for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
                ((AbstractC0735l) this.f10322U.get(i7)).a0(abstractC0730g);
            }
        }
    }

    @Override // Z1.AbstractC0735l
    public void b0(AbstractC0738o abstractC0738o) {
        super.b0(abstractC0738o);
        this.f10326Y |= 2;
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).b0(abstractC0738o);
        }
    }

    @Override // Z1.AbstractC0735l
    public void cancel() {
        super.cancel();
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).cancel();
        }
    }

    @Override // Z1.AbstractC0735l
    public String e0(String str) {
        String strE0 = super.e0(str);
        for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strE0);
            sb.append("\n");
            sb.append(((AbstractC0735l) this.f10322U.get(i7)).e0(str + "  "));
            strE0 = sb.toString();
        }
        return strE0;
    }

    @Override // Z1.AbstractC0735l
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public C0739p a(AbstractC0735l.f fVar) {
        return (C0739p) super.a(fVar);
    }

    @Override // Z1.AbstractC0735l
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public C0739p b(View view) {
        for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).b(view);
        }
        return (C0739p) super.b(view);
    }

    @Override // Z1.AbstractC0735l
    public void h(s sVar) {
        if (J(sVar.f10334b)) {
            ArrayList arrayList = this.f10322U;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                AbstractC0735l abstractC0735l = (AbstractC0735l) obj;
                if (abstractC0735l.J(sVar.f10334b)) {
                    abstractC0735l.h(sVar);
                    sVar.f10335c.add(abstractC0735l);
                }
            }
        }
    }

    public C0739p h0(AbstractC0735l abstractC0735l) {
        i0(abstractC0735l);
        long j7 = this.f10292n;
        if (j7 >= 0) {
            abstractC0735l.X(j7);
        }
        if ((this.f10326Y & 1) != 0) {
            abstractC0735l.Z(v());
        }
        if ((this.f10326Y & 2) != 0) {
            abstractC0735l.b0(z());
        }
        if ((this.f10326Y & 4) != 0) {
            abstractC0735l.a0(y());
        }
        if ((this.f10326Y & 8) != 0) {
            abstractC0735l.Y(u());
        }
        return this;
    }

    public final void i0(AbstractC0735l abstractC0735l) {
        this.f10322U.add(abstractC0735l);
        abstractC0735l.f10275C = this;
    }

    public AbstractC0735l j0(int i7) {
        if (i7 < 0 || i7 >= this.f10322U.size()) {
            return null;
        }
        return (AbstractC0735l) this.f10322U.get(i7);
    }

    public int k0() {
        return this.f10322U.size();
    }

    @Override // Z1.AbstractC0735l
    public void l(s sVar) {
        super.l(sVar);
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).l(sVar);
        }
    }

    @Override // Z1.AbstractC0735l
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C0739p S(AbstractC0735l.f fVar) {
        return (C0739p) super.S(fVar);
    }

    @Override // Z1.AbstractC0735l
    public void m(s sVar) {
        if (J(sVar.f10334b)) {
            ArrayList arrayList = this.f10322U;
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                AbstractC0735l abstractC0735l = (AbstractC0735l) obj;
                if (abstractC0735l.J(sVar.f10334b)) {
                    abstractC0735l.m(sVar);
                    sVar.f10335c.add(abstractC0735l);
                }
            }
        }
    }

    @Override // Z1.AbstractC0735l
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C0739p T(View view) {
        for (int i7 = 0; i7 < this.f10322U.size(); i7++) {
            ((AbstractC0735l) this.f10322U.get(i7)).T(view);
        }
        return (C0739p) super.T(view);
    }

    @Override // Z1.AbstractC0735l
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public C0739p X(long j7) {
        ArrayList arrayList;
        super.X(j7);
        if (this.f10292n >= 0 && (arrayList = this.f10322U) != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((AbstractC0735l) this.f10322U.get(i7)).X(j7);
            }
        }
        return this;
    }

    @Override // Z1.AbstractC0735l
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public C0739p Z(TimeInterpolator timeInterpolator) {
        this.f10326Y |= 1;
        ArrayList arrayList = this.f10322U;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((AbstractC0735l) this.f10322U.get(i7)).Z(timeInterpolator);
            }
        }
        return (C0739p) super.Z(timeInterpolator);
    }

    @Override // Z1.AbstractC0735l
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC0735l clone() {
        C0739p c0739p = (C0739p) super.clone();
        c0739p.f10322U = new ArrayList();
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            c0739p.i0(((AbstractC0735l) this.f10322U.get(i7)).clone());
        }
        return c0739p;
    }

    public C0739p p0(int i7) {
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

    @Override // Z1.AbstractC0735l
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public C0739p c0(long j7) {
        return (C0739p) super.c0(j7);
    }

    @Override // Z1.AbstractC0735l
    public void r(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jB = B();
        int size = this.f10322U.size();
        for (int i7 = 0; i7 < size; i7++) {
            AbstractC0735l abstractC0735l = (AbstractC0735l) this.f10322U.get(i7);
            if (jB > 0 && (this.f10323V || i7 == 0)) {
                long jB2 = abstractC0735l.B();
                if (jB2 > 0) {
                    abstractC0735l.c0(jB2 + jB);
                } else {
                    abstractC0735l.c0(jB);
                }
            }
            abstractC0735l.r(viewGroup, tVar, tVar2, arrayList, arrayList2);
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
            ((AbstractC0735l) obj).a(bVar);
        }
        this.f10324W = this.f10322U.size();
    }
}
