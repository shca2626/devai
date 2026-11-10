package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: p, reason: collision with root package name */
    public static final ThreadLocal f13409p = new ThreadLocal();

    /* renamed from: q, reason: collision with root package name */
    public static Comparator f13410q = new a();

    /* renamed from: m, reason: collision with root package name */
    public long f13412m;

    /* renamed from: n, reason: collision with root package name */
    public long f13413n;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f13411l = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f13414o = new ArrayList();

    public static class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f13422d;
            if ((recyclerView == null) != (cVar2.f13422d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z7 = cVar.f13419a;
            if (z7 != cVar2.f13419a) {
                return z7 ? -1 : 1;
            }
            int i7 = cVar2.f13420b - cVar.f13420b;
            if (i7 != 0) {
                return i7;
            }
            int i8 = cVar.f13421c - cVar2.f13421c;
            if (i8 != 0) {
                return i8;
            }
            return 0;
        }
    }

    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        public int f13415a;

        /* renamed from: b, reason: collision with root package name */
        public int f13416b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f13417c;

        /* renamed from: d, reason: collision with root package name */
        public int f13418d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i7, int i8) {
            if (i7 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i8 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i9 = this.f13418d;
            int i10 = i9 * 2;
            int[] iArr = this.f13417c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f13417c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[i9 * 4];
                this.f13417c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f13417c;
            iArr4[i10] = i7;
            iArr4[i10 + 1] = i8;
            this.f13418d++;
        }

        public void b() {
            int[] iArr = this.f13417c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f13418d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z7) {
            this.f13418d = 0;
            int[] iArr = this.f13417c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f13122x;
            if (recyclerView.f13120w == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z7) {
                if (!recyclerView.f13104o.p()) {
                    oVar.p(recyclerView.f13120w.c(), this);
                }
            } else if (!recyclerView.l0()) {
                oVar.o(this.f13415a, this.f13416b, recyclerView.f13111r0, this);
            }
            int i7 = this.f13418d;
            if (i7 > oVar.f13184m) {
                oVar.f13184m = i7;
                oVar.f13185n = z7;
                recyclerView.f13100m.K();
            }
        }

        public boolean d(int i7) {
            if (this.f13417c != null) {
                int i8 = this.f13418d * 2;
                for (int i9 = 0; i9 < i8; i9 += 2) {
                    if (this.f13417c[i9] == i7) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i7, int i8) {
            this.f13415a = i7;
            this.f13416b = i8;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f13419a;

        /* renamed from: b, reason: collision with root package name */
        public int f13420b;

        /* renamed from: c, reason: collision with root package name */
        public int f13421c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f13422d;

        /* renamed from: e, reason: collision with root package name */
        public int f13423e;

        public void a() {
            this.f13419a = false;
            this.f13420b = 0;
            this.f13421c = 0;
            this.f13422d = null;
            this.f13423e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i7) {
        int iJ = recyclerView.f13106p.j();
        for (int i8 = 0; i8 < iJ; i8++) {
            RecyclerView.C cF0 = RecyclerView.f0(recyclerView.f13106p.i(i8));
            if (cF0.f13138c == i7 && !cF0.t()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f13411l.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f13411l.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView recyclerView = (RecyclerView) this.f13411l.get(i8);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f13109q0.c(recyclerView, false);
                i7 += recyclerView.f13109q0.f13418d;
            }
        }
        this.f13414o.ensureCapacity(i7);
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f13411l.get(i10);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f13109q0;
                int iAbs = Math.abs(bVar.f13415a) + Math.abs(bVar.f13416b);
                for (int i11 = 0; i11 < bVar.f13418d * 2; i11 += 2) {
                    if (i9 >= this.f13414o.size()) {
                        cVar = new c();
                        this.f13414o.add(cVar);
                    } else {
                        cVar = (c) this.f13414o.get(i9);
                    }
                    int[] iArr = bVar.f13417c;
                    int i12 = iArr[i11 + 1];
                    cVar.f13419a = i12 <= iAbs;
                    cVar.f13420b = iAbs;
                    cVar.f13421c = i12;
                    cVar.f13422d = recyclerView2;
                    cVar.f13423e = iArr[i11];
                    i9++;
                }
            }
        }
        Collections.sort(this.f13414o, f13410q);
    }

    public final void c(c cVar, long j7) {
        RecyclerView.C cI = i(cVar.f13422d, cVar.f13423e, cVar.f13419a ? Long.MAX_VALUE : j7);
        if (cI == null || cI.f13137b == null || !cI.s() || cI.t()) {
            return;
        }
        h((RecyclerView) cI.f13137b.get(), j7);
    }

    public final void d(long j7) {
        for (int i7 = 0; i7 < this.f13414o.size(); i7++) {
            c cVar = (c) this.f13414o.get(i7);
            if (cVar.f13422d == null) {
                return;
            }
            c(cVar, j7);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i7, int i8) {
        if (recyclerView.isAttachedToWindow() && this.f13412m == 0) {
            this.f13412m = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f13109q0.e(i7, i8);
    }

    public void g(long j7) {
        b();
        d(j7);
    }

    public final void h(RecyclerView recyclerView, long j7) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f13077N && recyclerView.f13106p.j() != 0) {
            recyclerView.T0();
        }
        b bVar = recyclerView.f13109q0;
        bVar.c(recyclerView, true);
        if (bVar.f13418d != 0) {
            try {
                V.k.a("RV Nested Prefetch");
                recyclerView.f13111r0.f(recyclerView.f13120w);
                for (int i7 = 0; i7 < bVar.f13418d * 2; i7 += 2) {
                    i(recyclerView, bVar.f13417c[i7], j7);
                }
            } finally {
                V.k.b();
            }
        }
    }

    public final RecyclerView.C i(RecyclerView recyclerView, int i7, long j7) {
        if (e(recyclerView, i7)) {
            return null;
        }
        RecyclerView.u uVar = recyclerView.f13100m;
        try {
            recyclerView.F0();
            RecyclerView.C cI = uVar.I(i7, false, j7);
            if (cI != null) {
                if (!cI.s() || cI.t()) {
                    uVar.a(cI, false);
                } else {
                    uVar.B(cI.f13136a);
                }
            }
            recyclerView.H0(false);
            return cI;
        } catch (Throwable th) {
            recyclerView.H0(false);
            throw th;
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f13411l.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            V.k.a("RV Prefetch");
            if (!this.f13411l.isEmpty()) {
                int size = this.f13411l.size();
                long jMax = 0;
                for (int i7 = 0; i7 < size; i7++) {
                    RecyclerView recyclerView = (RecyclerView) this.f13411l.get(i7);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f13413n);
                }
            }
        } finally {
            this.f13412m = 0L;
            V.k.b();
        }
    }
}
