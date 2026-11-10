package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class n extends RecyclerView.q {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f13453a;

    /* renamed from: b, reason: collision with root package name */
    public Scroller f13454b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView.s f13455c = new a();

    public class a extends RecyclerView.s {

        /* renamed from: a, reason: collision with root package name */
        public boolean f13456a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i7) {
            super.a(recyclerView, i7);
            if (i7 == 0 && this.f13456a) {
                this.f13456a = false;
                n.this.k();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i7, int i8) {
            if (i7 == 0 && i8 == 0) {
                return;
            }
            this.f13456a = true;
        }
    }

    public class b extends g {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g, androidx.recyclerview.widget.RecyclerView.y
        public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            n nVar = n.this;
            RecyclerView recyclerView = nVar.f13453a;
            if (recyclerView == null) {
                return;
            }
            int[] iArrC = nVar.c(recyclerView.getLayoutManager(), view);
            int i7 = iArrC[0];
            int i8 = iArrC[1];
            int iW = w(Math.max(Math.abs(i7), Math.abs(i8)));
            if (iW > 0) {
                aVar.d(i7, i8, iW, this.f13434j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean a(int i7, int i8) {
        RecyclerView.o layoutManager = this.f13453a.getLayoutManager();
        if (layoutManager == null || this.f13453a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f13453a.getMinFlingVelocity();
        return (Math.abs(i8) > minFlingVelocity || Math.abs(i7) > minFlingVelocity) && j(layoutManager, i7, i8);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f13453a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f13453a = recyclerView;
        if (recyclerView != null) {
            i();
            this.f13454b = new Scroller(this.f13453a.getContext(), new DecelerateInterpolator());
            k();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public RecyclerView.y d(RecyclerView.o oVar) {
        return e(oVar);
    }

    public g e(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.y.b) {
            return new b(this.f13453a.getContext());
        }
        return null;
    }

    public final void f() {
        this.f13453a.X0(this.f13455c);
        this.f13453a.setOnFlingListener(null);
    }

    public abstract View g(RecyclerView.o oVar);

    public abstract int h(RecyclerView.o oVar, int i7, int i8);

    public final void i() {
        if (this.f13453a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f13453a.k(this.f13455c);
        this.f13453a.setOnFlingListener(this);
    }

    public final boolean j(RecyclerView.o oVar, int i7, int i8) {
        RecyclerView.y yVarD;
        int iH;
        if (!(oVar instanceof RecyclerView.y.b) || (yVarD = d(oVar)) == null || (iH = h(oVar, i7, i8)) == -1) {
            return false;
        }
        yVarD.p(iH);
        oVar.J1(yVarD);
        return true;
    }

    public void k() {
        RecyclerView.o layoutManager;
        View viewG;
        RecyclerView recyclerView = this.f13453a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewG = g(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewG);
        int i7 = iArrC[0];
        if (i7 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f13453a.k1(i7, iArrC[1]);
    }
}
