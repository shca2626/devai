package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {

    /* renamed from: A, reason: collision with root package name */
    public int f13007A;

    /* renamed from: B, reason: collision with root package name */
    public int f13008B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f13009C;

    /* renamed from: D, reason: collision with root package name */
    public d f13010D;

    /* renamed from: E, reason: collision with root package name */
    public final a f13011E;

    /* renamed from: F, reason: collision with root package name */
    public final b f13012F;

    /* renamed from: G, reason: collision with root package name */
    public int f13013G;

    /* renamed from: H, reason: collision with root package name */
    public int[] f13014H;

    /* renamed from: s, reason: collision with root package name */
    public int f13015s;

    /* renamed from: t, reason: collision with root package name */
    public c f13016t;

    /* renamed from: u, reason: collision with root package name */
    public i f13017u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13018v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13019w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13020x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13021y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f13022z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public i f13023a;

        /* renamed from: b, reason: collision with root package name */
        public int f13024b;

        /* renamed from: c, reason: collision with root package name */
        public int f13025c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f13026d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f13027e;

        public a() {
            e();
        }

        public void a() {
            this.f13025c = this.f13026d ? this.f13023a.i() : this.f13023a.m();
        }

        public void b(View view, int i7) {
            if (this.f13026d) {
                this.f13025c = this.f13023a.d(view) + this.f13023a.o();
            } else {
                this.f13025c = this.f13023a.g(view);
            }
            this.f13024b = i7;
        }

        public void c(View view, int i7) {
            int iO = this.f13023a.o();
            if (iO >= 0) {
                b(view, i7);
                return;
            }
            this.f13024b = i7;
            if (this.f13026d) {
                int i8 = (this.f13023a.i() - iO) - this.f13023a.d(view);
                this.f13025c = this.f13023a.i() - i8;
                if (i8 > 0) {
                    int iE = this.f13025c - this.f13023a.e(view);
                    int iM = this.f13023a.m();
                    int iMin = iE - (iM + Math.min(this.f13023a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f13025c += Math.min(i8, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f13023a.g(view);
            int iM2 = iG - this.f13023a.m();
            this.f13025c = iG;
            if (iM2 > 0) {
                int i9 = (this.f13023a.i() - Math.min(0, (this.f13023a.i() - iO) - this.f13023a.d(view))) - (iG + this.f13023a.e(view));
                if (i9 < 0) {
                    this.f13025c -= Math.min(iM2, -i9);
                }
            }
        }

        public boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.b();
        }

        public void e() {
            this.f13024b = -1;
            this.f13025c = Integer.MIN_VALUE;
            this.f13026d = false;
            this.f13027e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f13024b + ", mCoordinate=" + this.f13025c + ", mLayoutFromEnd=" + this.f13026d + ", mValid=" + this.f13027e + '}';
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f13028a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f13029b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f13030c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f13031d;

        public void a() {
            this.f13028a = 0;
            this.f13029b = false;
            this.f13030c = false;
            this.f13031d = false;
        }
    }

    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public int f13033b;

        /* renamed from: c, reason: collision with root package name */
        public int f13034c;

        /* renamed from: d, reason: collision with root package name */
        public int f13035d;

        /* renamed from: e, reason: collision with root package name */
        public int f13036e;

        /* renamed from: f, reason: collision with root package name */
        public int f13037f;

        /* renamed from: g, reason: collision with root package name */
        public int f13038g;

        /* renamed from: k, reason: collision with root package name */
        public int f13042k;

        /* renamed from: m, reason: collision with root package name */
        public boolean f13044m;

        /* renamed from: a, reason: collision with root package name */
        public boolean f13032a = true;

        /* renamed from: h, reason: collision with root package name */
        public int f13039h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f13040i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f13041j = false;

        /* renamed from: l, reason: collision with root package name */
        public List f13043l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f13035d = -1;
            } else {
                this.f13035d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        public boolean c(RecyclerView.z zVar) {
            int i7 = this.f13035d;
            return i7 >= 0 && i7 < zVar.b();
        }

        public View d(RecyclerView.u uVar) {
            if (this.f13043l != null) {
                return e();
            }
            View viewO = uVar.o(this.f13035d);
            this.f13035d += this.f13036e;
            return viewO;
        }

        public final View e() {
            int size = this.f13043l.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = ((RecyclerView.C) this.f13043l.get(i7)).f13136a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f13035d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int iA;
            int size = this.f13043l.size();
            View view2 = null;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < size; i8++) {
                View view3 = ((RecyclerView.C) this.f13043l.get(i8)).f13136a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f13035d) * this.f13036e) >= 0 && iA < i7) {
                    if (iA == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i7 = iA;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: l, reason: collision with root package name */
        public int f13045l;

        /* renamed from: m, reason: collision with root package name */
        public int f13046m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f13047n;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i7) {
                return new d[i7];
            }
        }

        public d() {
        }

        public boolean b() {
            return this.f13045l >= 0;
        }

        public void c() {
            this.f13045l = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f13045l);
            parcel.writeInt(this.f13046m);
            parcel.writeInt(this.f13047n ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f13045l = parcel.readInt();
            this.f13046m = parcel.readInt();
            this.f13047n = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f13045l = dVar.f13045l;
            this.f13046m = dVar.f13046m;
            this.f13047n = dVar.f13047n;
        }
    }

    public LinearLayoutManager(Context context, int i7, boolean z7) {
        this.f13015s = 1;
        this.f13019w = false;
        this.f13020x = false;
        this.f13021y = false;
        this.f13022z = true;
        this.f13007A = -1;
        this.f13008B = Integer.MIN_VALUE;
        this.f13010D = null;
        this.f13011E = new a();
        this.f13012F = new b();
        this.f13013G = 2;
        this.f13014H = new int[2];
        C2(i7);
        D2(z7);
    }

    public final void A2() {
        if (this.f13015s == 1 || !q2()) {
            this.f13020x = this.f13019w;
        } else {
            this.f13020x = !this.f13019w;
        }
    }

    public int B2(int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (J() == 0 || i7 == 0) {
            return 0;
        }
        T1();
        this.f13016t.f13032a = true;
        int i8 = i7 > 0 ? 1 : -1;
        int iAbs = Math.abs(i7);
        I2(i8, iAbs, true, zVar);
        c cVar = this.f13016t;
        int iU1 = cVar.f13038g + U1(uVar, cVar, zVar, false);
        if (iU1 < 0) {
            return 0;
        }
        if (iAbs > iU1) {
            i7 = i8 * iU1;
        }
        this.f13017u.r(-i7);
        this.f13016t.f13042k = i7;
        return i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i7) {
        int iJ = J();
        if (iJ == 0) {
            return null;
        }
        int iH0 = i7 - h0(I(0));
        if (iH0 >= 0 && iH0 < iJ) {
            View viewI = I(iH0);
            if (h0(viewI) == i7) {
                return viewI;
            }
        }
        return super.C(i7);
    }

    public void C2(int i7) {
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i7);
        }
        g(null);
        if (i7 != this.f13015s || this.f13017u == null) {
            i iVarB = i.b(this, i7);
            this.f13017u = iVarB;
            this.f13011E.f13023a = iVarB;
            this.f13015s = i7;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z7) {
        g(null);
        if (z7 == this.f13019w) {
            return;
        }
        this.f13019w = z7;
        t1();
    }

    public void E2(boolean z7) {
        g(null);
        if (this.f13021y == z7) {
            return;
        }
        this.f13021y = z7;
        t1();
    }

    public final boolean F2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        if (J() == 0) {
            return false;
        }
        View viewV = V();
        if (viewV != null && aVar.d(viewV, zVar)) {
            aVar.c(viewV, h0(viewV));
            return true;
        }
        if (this.f13018v != this.f13021y) {
            return false;
        }
        View viewI2 = aVar.f13026d ? i2(uVar, zVar) : j2(uVar, zVar);
        if (viewI2 == null) {
            return false;
        }
        aVar.b(viewI2, h0(viewI2));
        if (!zVar.e() && L1() && (this.f13017u.g(viewI2) >= this.f13017u.i() || this.f13017u.d(viewI2) < this.f13017u.m())) {
            aVar.f13025c = aVar.f13026d ? this.f13017u.i() : this.f13017u.m();
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    public final boolean G2(RecyclerView.z zVar, a aVar) {
        int i7;
        if (!zVar.e() && (i7 = this.f13007A) != -1) {
            if (i7 >= 0 && i7 < zVar.b()) {
                aVar.f13024b = this.f13007A;
                d dVar = this.f13010D;
                if (dVar != null && dVar.b()) {
                    boolean z7 = this.f13010D.f13047n;
                    aVar.f13026d = z7;
                    if (z7) {
                        aVar.f13025c = this.f13017u.i() - this.f13010D.f13046m;
                    } else {
                        aVar.f13025c = this.f13017u.m() + this.f13010D.f13046m;
                    }
                    return true;
                }
                if (this.f13008B != Integer.MIN_VALUE) {
                    boolean z8 = this.f13020x;
                    aVar.f13026d = z8;
                    if (z8) {
                        aVar.f13025c = this.f13017u.i() - this.f13008B;
                    } else {
                        aVar.f13025c = this.f13017u.m() + this.f13008B;
                    }
                    return true;
                }
                View viewC = C(this.f13007A);
                if (viewC == null) {
                    if (J() > 0) {
                        aVar.f13026d = (this.f13007A < h0(I(0))) == this.f13020x;
                    }
                    aVar.a();
                } else {
                    if (this.f13017u.e(viewC) > this.f13017u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f13017u.g(viewC) - this.f13017u.m() < 0) {
                        aVar.f13025c = this.f13017u.m();
                        aVar.f13026d = false;
                        return true;
                    }
                    if (this.f13017u.i() - this.f13017u.d(viewC) < 0) {
                        aVar.f13025c = this.f13017u.i();
                        aVar.f13026d = true;
                        return true;
                    }
                    aVar.f13025c = aVar.f13026d ? this.f13017u.d(viewC) + this.f13017u.o() : this.f13017u.g(viewC);
                }
                return true;
            }
            this.f13007A = -1;
            this.f13008B = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void H2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        if (G2(zVar, aVar) || F2(uVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f13024b = this.f13021y ? zVar.b() - 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.I0(recyclerView, uVar);
        if (this.f13009C) {
            k1(uVar);
            uVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z zVar, int i7) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i7);
        J1(gVar);
    }

    public final void I2(int i7, int i8, boolean z7, RecyclerView.z zVar) {
        int iM;
        this.f13016t.f13044m = z2();
        this.f13016t.f13037f = i7;
        int[] iArr = this.f13014H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int iMax = Math.max(0, this.f13014H[0]);
        int iMax2 = Math.max(0, this.f13014H[1]);
        boolean z8 = i7 == 1;
        c cVar = this.f13016t;
        int i9 = z8 ? iMax2 : iMax;
        cVar.f13039h = i9;
        if (!z8) {
            iMax = iMax2;
        }
        cVar.f13040i = iMax;
        if (z8) {
            cVar.f13039h = i9 + this.f13017u.j();
            View viewM2 = m2();
            c cVar2 = this.f13016t;
            cVar2.f13036e = this.f13020x ? -1 : 1;
            int iH0 = h0(viewM2);
            c cVar3 = this.f13016t;
            cVar2.f13035d = iH0 + cVar3.f13036e;
            cVar3.f13033b = this.f13017u.d(viewM2);
            iM = this.f13017u.d(viewM2) - this.f13017u.i();
        } else {
            View viewN2 = n2();
            this.f13016t.f13039h += this.f13017u.m();
            c cVar4 = this.f13016t;
            cVar4.f13036e = this.f13020x ? 1 : -1;
            int iH02 = h0(viewN2);
            c cVar5 = this.f13016t;
            cVar4.f13035d = iH02 + cVar5.f13036e;
            cVar5.f13033b = this.f13017u.g(viewN2);
            iM = (-this.f13017u.g(viewN2)) + this.f13017u.m();
        }
        c cVar6 = this.f13016t;
        cVar6.f13034c = i8;
        if (z7) {
            cVar6.f13034c = i8 - iM;
        }
        cVar6.f13038g = iM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        int iR1;
        A2();
        if (J() == 0 || (iR1 = R1(i7)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(iR1, (int) (this.f13017u.n() * 0.33333334f), false, zVar);
        c cVar = this.f13016t;
        cVar.f13038g = Integer.MIN_VALUE;
        cVar.f13032a = false;
        U1(uVar, cVar, zVar, true);
        View viewG2 = iR1 == -1 ? g2() : f2();
        View viewN2 = iR1 == -1 ? n2() : m2();
        if (!viewN2.hasFocusable()) {
            return viewG2;
        }
        if (viewG2 == null) {
            return null;
        }
        return viewN2;
    }

    public final void J2(int i7, int i8) {
        this.f13016t.f13034c = this.f13017u.i() - i8;
        c cVar = this.f13016t;
        cVar.f13036e = this.f13020x ? -1 : 1;
        cVar.f13035d = i7;
        cVar.f13037f = 1;
        cVar.f13033b = i8;
        cVar.f13038g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    public final void K2(a aVar) {
        J2(aVar.f13024b, aVar.f13025c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.f13010D == null && this.f13018v == this.f13021y;
    }

    public final void L2(int i7, int i8) {
        this.f13016t.f13034c = i8 - this.f13017u.m();
        c cVar = this.f13016t;
        cVar.f13035d = i7;
        cVar.f13036e = this.f13020x ? 1 : -1;
        cVar.f13037f = -1;
        cVar.f13033b = i8;
        cVar.f13038g = Integer.MIN_VALUE;
    }

    public void M1(RecyclerView.z zVar, int[] iArr) {
        int i7;
        int iO2 = o2(zVar);
        if (this.f13016t.f13037f == -1) {
            i7 = 0;
        } else {
            i7 = iO2;
            iO2 = 0;
        }
        iArr[0] = iO2;
        iArr[1] = i7;
    }

    public final void M2(a aVar) {
        L2(aVar.f13024b, aVar.f13025c);
    }

    public void N1(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i7 = cVar.f13035d;
        if (i7 < 0 || i7 >= zVar.b()) {
            return;
        }
        cVar2.a(i7, Math.max(0, cVar.f13038g));
    }

    public final int O1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(zVar, this.f13017u, Y1(!this.f13022z, true), X1(!this.f13022z, true), this, this.f13022z);
    }

    public final int P1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(zVar, this.f13017u, Y1(!this.f13022z, true), X1(!this.f13022z, true), this, this.f13022z, this.f13020x);
    }

    public final int Q1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(zVar, this.f13017u, Y1(!this.f13022z, true), X1(!this.f13022z, true), this, this.f13022z);
    }

    public int R1(int i7) {
        return i7 != 1 ? i7 != 2 ? i7 != 17 ? i7 != 33 ? i7 != 66 ? (i7 == 130 && this.f13015s == 1) ? 1 : Integer.MIN_VALUE : this.f13015s == 0 ? 1 : Integer.MIN_VALUE : this.f13015s == 1 ? -1 : Integer.MIN_VALUE : this.f13015s == 0 ? -1 : Integer.MIN_VALUE : (this.f13015s != 1 && q2()) ? -1 : 1 : (this.f13015s != 1 && q2()) ? 1 : -1;
    }

    public c S1() {
        return new c();
    }

    public void T1() {
        if (this.f13016t == null) {
            this.f13016t = S1();
        }
    }

    public int U1(RecyclerView.u uVar, c cVar, RecyclerView.z zVar, boolean z7) {
        int i7 = cVar.f13034c;
        int i8 = cVar.f13038g;
        if (i8 != Integer.MIN_VALUE) {
            if (i7 < 0) {
                cVar.f13038g = i8 + i7;
            }
            v2(uVar, cVar);
        }
        int i9 = cVar.f13034c + cVar.f13039h;
        b bVar = this.f13012F;
        while (true) {
            if ((!cVar.f13044m && i9 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            s2(uVar, zVar, cVar, bVar);
            if (!bVar.f13029b) {
                cVar.f13033b += bVar.f13028a * cVar.f13037f;
                if (!bVar.f13030c || cVar.f13043l != null || !zVar.e()) {
                    int i10 = cVar.f13034c;
                    int i11 = bVar.f13028a;
                    cVar.f13034c = i10 - i11;
                    i9 -= i11;
                }
                int i12 = cVar.f13038g;
                if (i12 != Integer.MIN_VALUE) {
                    int i13 = i12 + bVar.f13028a;
                    cVar.f13038g = i13;
                    int i14 = cVar.f13034c;
                    if (i14 < 0) {
                        cVar.f13038g = i13 + i14;
                    }
                    v2(uVar, cVar);
                }
                if (z7 && bVar.f13031d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i7 - cVar.f13034c;
    }

    public final View V1() {
        return d2(0, J());
    }

    public final View W1(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, 0, J(), zVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u uVar, RecyclerView.z zVar) {
        int i7;
        int i8;
        int i9;
        int i10;
        int iK2;
        int i11;
        View viewC;
        int iG;
        int i12;
        int i13 = -1;
        if (!(this.f13010D == null && this.f13007A == -1) && zVar.b() == 0) {
            k1(uVar);
            return;
        }
        d dVar = this.f13010D;
        if (dVar != null && dVar.b()) {
            this.f13007A = this.f13010D.f13045l;
        }
        T1();
        this.f13016t.f13032a = false;
        A2();
        View viewV = V();
        a aVar = this.f13011E;
        if (!aVar.f13027e || this.f13007A != -1 || this.f13010D != null) {
            aVar.e();
            a aVar2 = this.f13011E;
            aVar2.f13026d = this.f13020x ^ this.f13021y;
            H2(uVar, zVar, aVar2);
            this.f13011E.f13027e = true;
        } else if (viewV != null && (this.f13017u.g(viewV) >= this.f13017u.i() || this.f13017u.d(viewV) <= this.f13017u.m())) {
            this.f13011E.c(viewV, h0(viewV));
        }
        c cVar = this.f13016t;
        cVar.f13037f = cVar.f13042k >= 0 ? 1 : -1;
        int[] iArr = this.f13014H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int iMax = Math.max(0, this.f13014H[0]) + this.f13017u.m();
        int iMax2 = Math.max(0, this.f13014H[1]) + this.f13017u.j();
        if (zVar.e() && (i11 = this.f13007A) != -1 && this.f13008B != Integer.MIN_VALUE && (viewC = C(i11)) != null) {
            if (this.f13020x) {
                i12 = this.f13017u.i() - this.f13017u.d(viewC);
                iG = this.f13008B;
            } else {
                iG = this.f13017u.g(viewC) - this.f13017u.m();
                i12 = this.f13008B;
            }
            int i14 = i12 - iG;
            if (i14 > 0) {
                iMax += i14;
            } else {
                iMax2 -= i14;
            }
        }
        a aVar3 = this.f13011E;
        if (!aVar3.f13026d ? !this.f13020x : this.f13020x) {
            i13 = 1;
        }
        u2(uVar, zVar, aVar3, i13);
        w(uVar);
        this.f13016t.f13044m = z2();
        this.f13016t.f13041j = zVar.e();
        this.f13016t.f13040i = 0;
        a aVar4 = this.f13011E;
        if (aVar4.f13026d) {
            M2(aVar4);
            c cVar2 = this.f13016t;
            cVar2.f13039h = iMax;
            U1(uVar, cVar2, zVar, false);
            c cVar3 = this.f13016t;
            i8 = cVar3.f13033b;
            int i15 = cVar3.f13035d;
            int i16 = cVar3.f13034c;
            if (i16 > 0) {
                iMax2 += i16;
            }
            K2(this.f13011E);
            c cVar4 = this.f13016t;
            cVar4.f13039h = iMax2;
            cVar4.f13035d += cVar4.f13036e;
            U1(uVar, cVar4, zVar, false);
            c cVar5 = this.f13016t;
            i7 = cVar5.f13033b;
            int i17 = cVar5.f13034c;
            if (i17 > 0) {
                L2(i15, i8);
                c cVar6 = this.f13016t;
                cVar6.f13039h = i17;
                U1(uVar, cVar6, zVar, false);
                i8 = this.f13016t.f13033b;
            }
        } else {
            K2(aVar4);
            c cVar7 = this.f13016t;
            cVar7.f13039h = iMax2;
            U1(uVar, cVar7, zVar, false);
            c cVar8 = this.f13016t;
            i7 = cVar8.f13033b;
            int i18 = cVar8.f13035d;
            int i19 = cVar8.f13034c;
            if (i19 > 0) {
                iMax += i19;
            }
            M2(this.f13011E);
            c cVar9 = this.f13016t;
            cVar9.f13039h = iMax;
            cVar9.f13035d += cVar9.f13036e;
            U1(uVar, cVar9, zVar, false);
            c cVar10 = this.f13016t;
            i8 = cVar10.f13033b;
            int i20 = cVar10.f13034c;
            if (i20 > 0) {
                J2(i18, i7);
                c cVar11 = this.f13016t;
                cVar11.f13039h = i20;
                U1(uVar, cVar11, zVar, false);
                i7 = this.f13016t.f13033b;
            }
        }
        if (J() > 0) {
            if (this.f13020x ^ this.f13021y) {
                int iK22 = k2(i7, uVar, zVar, true);
                i9 = i8 + iK22;
                i10 = i7 + iK22;
                iK2 = l2(i9, uVar, zVar, false);
            } else {
                int iL2 = l2(i8, uVar, zVar, true);
                i9 = i8 + iL2;
                i10 = i7 + iL2;
                iK2 = k2(i10, uVar, zVar, false);
            }
            i8 = i9 + iK2;
            i7 = i10 + iK2;
        }
        t2(uVar, zVar, i8, i7);
        if (zVar.e()) {
            this.f13011E.e();
        } else {
            this.f13017u.s();
        }
        this.f13018v = this.f13021y;
    }

    public View X1(boolean z7, boolean z8) {
        return this.f13020x ? e2(0, J(), z7, z8) : e2(J() - 1, -1, z7, z8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z zVar) {
        super.Y0(zVar);
        this.f13010D = null;
        this.f13007A = -1;
        this.f13008B = Integer.MIN_VALUE;
        this.f13011E.e();
    }

    public View Y1(boolean z7, boolean z8) {
        return this.f13020x ? e2(J() - 1, -1, z7, z8) : e2(0, J(), z7, z8);
    }

    public int Z1() {
        View viewE2 = e2(0, J(), false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i7) {
        if (J() == 0) {
            return null;
        }
        int i8 = (i7 < h0(I(0))) != this.f13020x ? -1 : 1;
        return this.f13015s == 0 ? new PointF(i8, 0.0f) : new PointF(0.0f, i8);
    }

    public final View a2() {
        return d2(J() - 1, -1);
    }

    public final View b2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, J() - 1, -1, zVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f13010D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View viewE2 = e2(J() - 1, -1, false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.f13010D != null) {
            return new d(this.f13010D);
        }
        d dVar = new d();
        if (J() <= 0) {
            dVar.c();
            return dVar;
        }
        T1();
        boolean z7 = this.f13018v ^ this.f13020x;
        dVar.f13047n = z7;
        if (z7) {
            View viewM2 = m2();
            dVar.f13046m = this.f13017u.i() - this.f13017u.d(viewM2);
            dVar.f13045l = h0(viewM2);
            return dVar;
        }
        View viewN2 = n2();
        dVar.f13045l = h0(viewN2);
        dVar.f13046m = this.f13017u.g(viewN2) - this.f13017u.m();
        return dVar;
    }

    public View d2(int i7, int i8) {
        int i9;
        int i10;
        T1();
        if (i8 <= i7 && i8 >= i7) {
            return I(i7);
        }
        if (this.f13017u.g(I(i7)) < this.f13017u.m()) {
            i9 = 16644;
            i10 = 16388;
        } else {
            i9 = 4161;
            i10 = 4097;
        }
        return this.f13015s == 0 ? this.f13176e.a(i7, i8, i9, i10) : this.f13177f.a(i7, i8, i9, i10);
    }

    public View e2(int i7, int i8, boolean z7, boolean z8) {
        T1();
        int i9 = z7 ? 24579 : 320;
        int i10 = z8 ? 320 : 0;
        return this.f13015s == 0 ? this.f13176e.a(i7, i8, i9, i10) : this.f13177f.a(i7, i8, i9, i10);
    }

    public final View f2() {
        return this.f13020x ? V1() : a2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.f13010D == null) {
            super.g(str);
        }
    }

    public final View g2() {
        return this.f13020x ? a2() : V1();
    }

    public View h2(RecyclerView.u uVar, RecyclerView.z zVar, int i7, int i8, int i9) {
        T1();
        int iM = this.f13017u.m();
        int i10 = this.f13017u.i();
        int i11 = i8 > i7 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i7 != i8) {
            View viewI = I(i7);
            int iH0 = h0(viewI);
            if (iH0 >= 0 && iH0 < i9) {
                if (((RecyclerView.p) viewI.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.f13017u.g(viewI) < i10 && this.f13017u.d(viewI) >= iM) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i7 += i11;
        }
        return view != null ? view : view2;
    }

    public final View i2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f13020x ? W1(uVar, zVar) : b2(uVar, zVar);
    }

    public final View j2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f13020x ? b2(uVar, zVar) : W1(uVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f13015s == 0;
    }

    public final int k2(int i7, RecyclerView.u uVar, RecyclerView.z zVar, boolean z7) {
        int i8;
        int i9 = this.f13017u.i() - i7;
        if (i9 <= 0) {
            return 0;
        }
        int i10 = -B2(-i9, uVar, zVar);
        int i11 = i7 + i10;
        if (!z7 || (i8 = this.f13017u.i() - i11) <= 0) {
            return i10;
        }
        this.f13017u.r(i8);
        return i8 + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f13015s == 1;
    }

    public final int l2(int i7, RecyclerView.u uVar, RecyclerView.z zVar, boolean z7) {
        int iM;
        int iM2 = i7 - this.f13017u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i8 = -B2(iM2, uVar, zVar);
        int i9 = i7 + i8;
        if (!z7 || (iM = i9 - this.f13017u.m()) <= 0) {
            return i8;
        }
        this.f13017u.r(-iM);
        return i8 - iM;
    }

    public final View m2() {
        return I(this.f13020x ? 0 : J() - 1);
    }

    public final View n2() {
        return I(this.f13020x ? J() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i7, int i8, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.f13015s != 0) {
            i7 = i8;
        }
        if (J() == 0 || i7 == 0) {
            return;
        }
        T1();
        I2(i7 > 0 ? 1 : -1, Math.abs(i7), true, zVar);
        N1(zVar, this.f13016t, cVar);
    }

    public int o2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.f13017u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i7, RecyclerView.o.c cVar) {
        boolean z7;
        int i8;
        d dVar = this.f13010D;
        if (dVar == null || !dVar.b()) {
            A2();
            z7 = this.f13020x;
            i8 = this.f13007A;
            if (i8 == -1) {
                i8 = z7 ? i7 - 1 : 0;
            }
        } else {
            d dVar2 = this.f13010D;
            z7 = dVar2.f13047n;
            i8 = dVar2.f13045l;
        }
        int i9 = z7 ? -1 : 1;
        for (int i10 = 0; i10 < this.f13013G && i8 >= 0 && i8 < i7; i10++) {
            cVar.a(i8, 0);
            i8 += i9;
        }
    }

    public int p2() {
        return this.f13015s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z zVar) {
        return O1(zVar);
    }

    public boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public boolean r2() {
        return this.f13022z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    public void s2(RecyclerView.u uVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i7;
        int i8;
        int i9;
        int i10;
        int iE0;
        int iF;
        int i11;
        int i12;
        View viewD = cVar.d(uVar);
        if (viewD == null) {
            bVar.f13029b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f13043l == null) {
            if (this.f13020x == (cVar.f13037f == -1)) {
                d(viewD);
            } else {
                e(viewD, 0);
            }
        } else {
            if (this.f13020x == (cVar.f13037f == -1)) {
                b(viewD);
            } else {
                c(viewD, 0);
            }
        }
        A0(viewD, 0, 0);
        bVar.f13028a = this.f13017u.e(viewD);
        if (this.f13015s == 1) {
            if (q2()) {
                iF = o0() - f0();
                iE0 = iF - this.f13017u.f(viewD);
            } else {
                iE0 = e0();
                iF = this.f13017u.f(viewD) + iE0;
            }
            if (cVar.f13037f == -1) {
                i12 = cVar.f13033b;
                i11 = i12 - bVar.f13028a;
            } else {
                i11 = cVar.f13033b;
                i12 = bVar.f13028a + i11;
            }
            int i13 = iE0;
            i10 = i11;
            i9 = i13;
            i8 = i12;
            i7 = iF;
        } else {
            int iG0 = g0();
            int iF2 = this.f13017u.f(viewD) + iG0;
            if (cVar.f13037f == -1) {
                int i14 = cVar.f13033b;
                i9 = i14 - bVar.f13028a;
                i7 = i14;
                i8 = iF2;
            } else {
                int i15 = cVar.f13033b;
                i7 = bVar.f13028a + i15;
                i8 = iF2;
                i9 = i15;
            }
            i10 = iG0;
        }
        z0(viewD, i9, i10, i7, i8);
        if (pVar.c() || pVar.b()) {
            bVar.f13030c = true;
        }
        bVar.f13031d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return O1(zVar);
    }

    public final void t2(RecyclerView.u uVar, RecyclerView.z zVar, int i7, int i8) {
        if (!zVar.g() || J() == 0 || zVar.e() || !L1()) {
            return;
        }
        List listK = uVar.k();
        int size = listK.size();
        int iH0 = h0(I(0));
        int iE = 0;
        int iE2 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView.C c7 = (RecyclerView.C) listK.get(i9);
            if (!c7.v()) {
                if ((c7.m() < iH0) != this.f13020x) {
                    iE += this.f13017u.e(c7.f13136a);
                } else {
                    iE2 += this.f13017u.e(c7.f13136a);
                }
            }
        }
        this.f13016t.f13043l = listK;
        if (iE > 0) {
            L2(h0(n2()), i7);
            c cVar = this.f13016t;
            cVar.f13039h = iE;
            cVar.f13034c = 0;
            cVar.a();
            U1(uVar, this.f13016t, zVar, false);
        }
        if (iE2 > 0) {
            J2(h0(m2()), i8);
            c cVar2 = this.f13016t;
            cVar2.f13039h = iE2;
            cVar2.f13034c = 0;
            cVar2.a();
            U1(uVar, this.f13016t, zVar, false);
        }
        this.f13016t.f13043l = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public void u2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar, int i7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    public final void v2(RecyclerView.u uVar, c cVar) {
        if (!cVar.f13032a || cVar.f13044m) {
            return;
        }
        int i7 = cVar.f13038g;
        int i8 = cVar.f13040i;
        if (cVar.f13037f == -1) {
            x2(uVar, i7, i8);
        } else {
            y2(uVar, i7, i8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f13015s == 1) {
            return 0;
        }
        return B2(i7, uVar, zVar);
    }

    public final void w2(RecyclerView.u uVar, int i7, int i8) {
        if (i7 == i8) {
            return;
        }
        if (i8 <= i7) {
            while (i7 > i8) {
                n1(i7, uVar);
                i7--;
            }
        } else {
            for (int i9 = i8 - 1; i9 >= i7; i9--) {
                n1(i9, uVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i7) {
        this.f13007A = i7;
        this.f13008B = Integer.MIN_VALUE;
        d dVar = this.f13010D;
        if (dVar != null) {
            dVar.c();
        }
        t1();
    }

    public final void x2(RecyclerView.u uVar, int i7, int i8) {
        int iJ = J();
        if (i7 < 0) {
            return;
        }
        int iH = (this.f13017u.h() - i7) + i8;
        if (this.f13020x) {
            for (int i9 = 0; i9 < iJ; i9++) {
                View viewI = I(i9);
                if (this.f13017u.g(viewI) < iH || this.f13017u.q(viewI) < iH) {
                    w2(uVar, 0, i9);
                    return;
                }
            }
            return;
        }
        int i10 = iJ - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            View viewI2 = I(i11);
            if (this.f13017u.g(viewI2) < iH || this.f13017u.q(viewI2) < iH) {
                w2(uVar, i10, i11);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f13015s == 0) {
            return 0;
        }
        return B2(i7, uVar, zVar);
    }

    public final void y2(RecyclerView.u uVar, int i7, int i8) {
        if (i7 < 0) {
            return;
        }
        int i9 = i7 - i8;
        int iJ = J();
        if (!this.f13020x) {
            for (int i10 = 0; i10 < iJ; i10++) {
                View viewI = I(i10);
                if (this.f13017u.d(viewI) > i9 || this.f13017u.p(viewI) > i9) {
                    w2(uVar, 0, i10);
                    return;
                }
            }
            return;
        }
        int i11 = iJ - 1;
        for (int i12 = i11; i12 >= 0; i12--) {
            View viewI2 = I(i12);
            if (this.f13017u.d(viewI2) > i9 || this.f13017u.p(viewI2) > i9) {
                w2(uVar, i11, i12);
                return;
            }
        }
    }

    public boolean z2() {
        return this.f13017u.k() == 0 && this.f13017u.h() == 0;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f13015s = 1;
        this.f13019w = false;
        this.f13020x = false;
        this.f13021y = false;
        this.f13022z = true;
        this.f13007A = -1;
        this.f13008B = Integer.MIN_VALUE;
        this.f13010D = null;
        this.f13011E = new a();
        this.f13012F = new b();
        this.f13013G = 2;
        this.f13014H = new int[2];
        RecyclerView.o.d dVarI0 = RecyclerView.o.i0(context, attributeSet, i7, i8);
        C2(dVarI0.f13192a);
        D2(dVarI0.f13194c);
        E2(dVarI0.f13195d);
    }
}
