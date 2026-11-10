package androidx.appcompat.widget;

import Z.C0691e0;
import Z.W;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import i.AbstractC1145a;
import i.f;
import i.g;
import i.j;
import o.AbstractC1379b;
import q.AbstractC1464a;
import q.d0;
import q.n0;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC1464a {

    /* renamed from: A, reason: collision with root package name */
    public TextView f11283A;

    /* renamed from: B, reason: collision with root package name */
    public int f11284B;

    /* renamed from: C, reason: collision with root package name */
    public int f11285C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f11286D;

    /* renamed from: E, reason: collision with root package name */
    public int f11287E;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f11288t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f11289u;

    /* renamed from: v, reason: collision with root package name */
    public View f11290v;

    /* renamed from: w, reason: collision with root package name */
    public View f11291w;

    /* renamed from: x, reason: collision with root package name */
    public View f11292x;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout f11293y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f11294z;

    public class a implements View.OnClickListener {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ AbstractC1379b f11295l;

        public a(AbstractC1379b abstractC1379b) {
            this.f11295l = abstractC1379b;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f11295l.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    @Override // q.AbstractC1464a
    public /* bridge */ /* synthetic */ C0691e0 f(int i7, long j7) {
        return super.f(i7, j7);
    }

    public void g() {
        if (this.f11290v == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // q.AbstractC1464a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // q.AbstractC1464a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f11289u;
    }

    public CharSequence getTitle() {
        return this.f11288t;
    }

    public void h(AbstractC1379b abstractC1379b) {
        View view = this.f11290v;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f11287E, (ViewGroup) this, false);
            this.f11290v = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f11290v);
        }
        View viewFindViewById = this.f11290v.findViewById(f.f17047i);
        this.f11291w = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(abstractC1379b));
        e eVar = (e) abstractC1379b.e();
        androidx.appcompat.widget.a aVar = this.f21223o;
        if (aVar != null) {
            aVar.y();
        }
        androidx.appcompat.widget.a aVar2 = new androidx.appcompat.widget.a(getContext());
        this.f21223o = aVar2;
        aVar2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f21223o, this.f21221m);
        ActionMenuView actionMenuView = (ActionMenuView) this.f21223o.o(this);
        this.f21222n = actionMenuView;
        W.p0(actionMenuView, null);
        addView(this.f21222n, layoutParams);
    }

    public final void i() {
        if (this.f11293y == null) {
            LayoutInflater.from(getContext()).inflate(g.f17065a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f11293y = linearLayout;
            this.f11294z = (TextView) linearLayout.findViewById(f.f17043e);
            this.f11283A = (TextView) this.f11293y.findViewById(f.f17042d);
            if (this.f11284B != 0) {
                this.f11294z.setTextAppearance(getContext(), this.f11284B);
            }
            if (this.f11285C != 0) {
                this.f11283A.setTextAppearance(getContext(), this.f11285C);
            }
        }
        this.f11294z.setText(this.f11288t);
        this.f11283A.setText(this.f11289u);
        boolean zIsEmpty = TextUtils.isEmpty(this.f11288t);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f11289u);
        this.f11283A.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f11293y.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f11293y.getParent() == null) {
            addView(this.f11293y);
        }
    }

    public boolean j() {
        return this.f11286D;
    }

    public void k() {
        removeAllViews();
        this.f11292x = null;
        this.f21222n = null;
        this.f21223o = null;
        View view = this.f11291w;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        androidx.appcompat.widget.a aVar = this.f21223o;
        if (aVar != null) {
            return aVar.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.a aVar = this.f21223o;
        if (aVar != null) {
            aVar.B();
            this.f21223o.C();
        }
    }

    @Override // q.AbstractC1464a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        boolean zB = n0.b(this);
        int paddingRight = zB ? (i9 - i7) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i10 - i8) - getPaddingTop()) - getPaddingBottom();
        View view = this.f11290v;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11290v.getLayoutParams();
            int i11 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i12 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbstractC1464a.d(paddingRight, i11, zB);
            paddingRight = AbstractC1464a.d(iD + e(this.f11290v, iD, paddingTop, paddingTop2, zB), i12, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f11293y;
        if (linearLayout != null && this.f11292x == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f11293y, iE, paddingTop, paddingTop2, zB);
        }
        View view2 = this.f11292x;
        if (view2 != null) {
            e(view2, iE, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i9 - i7) - getPaddingRight();
        ActionMenuView actionMenuView = this.f21222n;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        if (View.MeasureSpec.getMode(i7) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i8) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i7);
        int size2 = this.f21224p;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i8);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f11290v;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11290v.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f21222n;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f21222n, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f11293y;
        if (linearLayout != null && this.f11292x == null) {
            if (this.f11286D) {
                this.f11293y.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f11293y.getMeasuredWidth();
                boolean z7 = measuredWidth <= paddingLeft;
                if (z7) {
                    paddingLeft -= measuredWidth;
                }
                this.f11293y.setVisibility(z7 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f11292x;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i9 = layoutParams.width;
            int i10 = i9 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i9 >= 0) {
                paddingLeft = Math.min(i9, paddingLeft);
            }
            int i11 = layoutParams.height;
            int i12 = i11 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i11 >= 0) {
                iMin = Math.min(i11, iMin);
            }
            this.f11292x.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i10), View.MeasureSpec.makeMeasureSpec(iMin, i12));
        }
        if (this.f21224p > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            int measuredHeight = getChildAt(i14).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i13) {
                i13 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i13);
    }

    @Override // q.AbstractC1464a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // q.AbstractC1464a
    public void setContentHeight(int i7) {
        this.f21224p = i7;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f11292x;
        if (view2 != null) {
            removeView(view2);
        }
        this.f11292x = view;
        if (view != null && (linearLayout = this.f11293y) != null) {
            removeView(linearLayout);
            this.f11293y = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f11289u = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f11288t = charSequence;
        i();
        W.o0(this, charSequence);
    }

    public void setTitleOptional(boolean z7) {
        if (z7 != this.f11286D) {
            requestLayout();
        }
        this.f11286D = z7;
    }

    @Override // q.AbstractC1464a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i7) {
        super.setVisibility(i7);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16936g);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        d0 d0VarV = d0.v(context, attributeSet, j.f17345y, i7, 0);
        W.p0(this, d0VarV.g(j.f17350z));
        this.f11284B = d0VarV.n(j.f17118D, 0);
        this.f11285C = d0VarV.n(j.f17113C, 0);
        this.f21224p = d0VarV.m(j.f17108B, 0);
        this.f11287E = d0VarV.n(j.f17103A, g.f17068d);
        d0VarV.w();
    }
}
