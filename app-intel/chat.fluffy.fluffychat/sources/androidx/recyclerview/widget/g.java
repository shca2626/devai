package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class g extends RecyclerView.y {

    /* renamed from: k, reason: collision with root package name */
    public PointF f13435k;

    /* renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f13436l;

    /* renamed from: n, reason: collision with root package name */
    public float f13438n;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f13433i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f13434j = new DecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    public boolean f13437m = false;

    /* renamed from: o, reason: collision with root package name */
    public int f13439o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f13440p = 0;

    public g(Context context) {
        this.f13436l = context.getResources().getDisplayMetrics();
    }

    public final float A() {
        if (!this.f13437m) {
            this.f13438n = v(this.f13436l);
            this.f13437m = true;
        }
        return this.f13438n;
    }

    public int B() {
        PointF pointF = this.f13435k;
        if (pointF == null) {
            return 0;
        }
        float f7 = pointF.y;
        if (f7 == 0.0f) {
            return 0;
        }
        return f7 > 0.0f ? 1 : -1;
    }

    public void C(RecyclerView.y.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.f13435k = pointFA;
        this.f13439o = (int) (pointFA.x * 10000.0f);
        this.f13440p = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.f13439o * 1.2f), (int) (this.f13440p * 1.2f), (int) (x(10000) * 1.2f), this.f13433i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void l(int i7, int i8, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f13439o = y(this.f13439o, i7);
        int iY = y(this.f13440p, i8);
        this.f13440p = iY;
        if (this.f13439o == 0 && iY == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void n() {
        this.f13440p = 0;
        this.f13439o = 0;
        this.f13435k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int iT = t(view, z());
        int iU = u(view, B());
        int iW = w((int) Math.sqrt((iT * iT) + (iU * iU)));
        if (iW > 0) {
            aVar.d(-iT, -iU, iW, this.f13434j);
        }
    }

    public int s(int i7, int i8, int i9, int i10, int i11) {
        if (i11 == -1) {
            return i9 - i7;
        }
        if (i11 != 0) {
            if (i11 == 1) {
                return i10 - i8;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i12 = i9 - i7;
        if (i12 > 0) {
            return i12;
        }
        int i13 = i10 - i8;
        if (i13 < 0) {
            return i13;
        }
        return 0;
    }

    public int t(View view, int i7) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.k()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.Q(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, oVarE.T(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, oVarE.e0(), oVarE.o0() - oVarE.f0(), i7);
    }

    public int u(View view, int i7) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.l()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.U(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, oVarE.O(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, oVarE.g0(), oVarE.W() - oVarE.d0(), i7);
    }

    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int w(int i7) {
        return (int) Math.ceil(x(i7) / 0.3356d);
    }

    public int x(int i7) {
        return (int) Math.ceil(Math.abs(i7) * A());
    }

    public final int y(int i7, int i8) {
        int i9 = i7 - i8;
        if (i7 * i9 <= 0) {
            return 0;
        }
        return i9;
    }

    public int z() {
        PointF pointF = this.f13435k;
        if (pointF == null) {
            return 0;
        }
        float f7 = pointF.x;
        if (f7 == 0.0f) {
            return 0;
        }
        return f7 > 0.0f ? 1 : -1;
    }
}
