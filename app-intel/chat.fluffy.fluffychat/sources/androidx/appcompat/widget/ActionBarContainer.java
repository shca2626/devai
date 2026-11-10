package androidx.appcompat.widget;

import Z.W;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import i.f;
import i.j;
import q.C1465b;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: l, reason: collision with root package name */
    public boolean f11273l;

    /* renamed from: m, reason: collision with root package name */
    public View f11274m;

    /* renamed from: n, reason: collision with root package name */
    public View f11275n;

    /* renamed from: o, reason: collision with root package name */
    public View f11276o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f11277p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f11278q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f11279r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11280s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f11281t;

    /* renamed from: u, reason: collision with root package name */
    public int f11282u;

    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        W.p0(this, new C1465b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f17225a);
        this.f11277p = typedArrayObtainStyledAttributes.getDrawable(j.f17230b);
        this.f11278q = typedArrayObtainStyledAttributes.getDrawable(j.f17240d);
        this.f11282u = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f17270j, -1);
        boolean z7 = true;
        if (getId() == f.f17030H) {
            this.f11280s = true;
            this.f11279r = typedArrayObtainStyledAttributes.getDrawable(j.f17235c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f11280s ? this.f11277p != null || this.f11278q != null : this.f11279r != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f11277p;
        if (drawable != null && drawable.isStateful()) {
            this.f11277p.setState(getDrawableState());
        }
        Drawable drawable2 = this.f11278q;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f11278q.setState(getDrawableState());
        }
        Drawable drawable3 = this.f11279r;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f11279r.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f11274m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f11277p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f11278q;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f11279r;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f11275n = findViewById(f.f17039a);
        this.f11276o = findViewById(f.f17044f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f11273l || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[PHI: r1
      0x0049: PHI (r1v8 boolean) = (r1v1 boolean), (r1v1 boolean), (r1v0 boolean) binds: [B:31:0x00a6, B:33:0x00aa, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            r6 = r5
            android.view.View r8 = r6.f11274m
            r10 = 8
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L14
            int r2 = r8.getVisibility()
            if (r2 == r10) goto L14
            r2 = r0
            goto L15
        L14:
            r2 = r1
        L15:
            if (r8 == 0) goto L34
            int r3 = r8.getVisibility()
            if (r3 == r10) goto L34
            int r10 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r8.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r4 = r8.getMeasuredHeight()
            int r4 = r10 - r4
            int r3 = r3.bottomMargin
            int r4 = r4 - r3
            int r10 = r10 - r3
            r8.layout(r7, r4, r9, r10)
        L34:
            boolean r7 = r6.f11280s
            if (r7 == 0) goto L4c
            android.graphics.drawable.Drawable r7 = r6.f11279r
            if (r7 == 0) goto L49
            int r8 = r5.getMeasuredWidth()
            int r9 = r5.getMeasuredHeight()
            r7.setBounds(r1, r1, r8, r9)
            goto Lbf
        L49:
            r0 = r1
            goto Lbf
        L4c:
            android.graphics.drawable.Drawable r7 = r6.f11277p
            if (r7 == 0) goto La4
            android.view.View r7 = r6.f11275n
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L76
            android.graphics.drawable.Drawable r7 = r6.f11277p
            android.view.View r9 = r6.f11275n
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f11275n
            int r10 = r10.getTop()
            android.view.View r1 = r6.f11275n
            int r1 = r1.getRight()
            android.view.View r3 = r6.f11275n
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L76:
            android.view.View r7 = r6.f11276o
            if (r7 == 0) goto L9e
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9e
            android.graphics.drawable.Drawable r7 = r6.f11277p
            android.view.View r9 = r6.f11276o
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f11276o
            int r10 = r10.getTop()
            android.view.View r1 = r6.f11276o
            int r1 = r1.getRight()
            android.view.View r3 = r6.f11276o
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L9e:
            android.graphics.drawable.Drawable r7 = r6.f11277p
            r7.setBounds(r1, r1, r1, r1)
        La3:
            r1 = r0
        La4:
            r6.f11281t = r2
            if (r2 == 0) goto L49
            android.graphics.drawable.Drawable r7 = r6.f11278q
            if (r7 == 0) goto L49
            int r9 = r8.getLeft()
            int r10 = r8.getTop()
            int r1 = r8.getRight()
            int r8 = r8.getBottom()
            r7.setBounds(r9, r10, r1, r8)
        Lbf:
            if (r0 == 0) goto Lc4
            r5.invalidate()
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        int i9;
        if (this.f11275n == null && View.MeasureSpec.getMode(i8) == Integer.MIN_VALUE && (i9 = this.f11282u) >= 0) {
            i8 = View.MeasureSpec.makeMeasureSpec(Math.min(i9, View.MeasureSpec.getSize(i8)), Integer.MIN_VALUE);
        }
        super.onMeasure(i7, i8);
        if (this.f11275n == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i8);
        View view = this.f11274m;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f11275n) ? a(this.f11275n) : !b(this.f11276o) ? a(this.f11276o) : 0) + a(this.f11274m), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i8) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f11277p;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f11277p);
        }
        this.f11277p = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f11275n;
            if (view != null) {
                this.f11277p.setBounds(view.getLeft(), this.f11275n.getTop(), this.f11275n.getRight(), this.f11275n.getBottom());
            }
        }
        boolean z7 = false;
        if (!this.f11280s ? !(this.f11277p != null || this.f11278q != null) : this.f11279r == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f11279r;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f11279r);
        }
        this.f11279r = drawable;
        boolean z7 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f11280s && (drawable2 = this.f11279r) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f11280s ? !(this.f11277p != null || this.f11278q != null) : this.f11279r == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f11278q;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f11278q);
        }
        this.f11278q = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f11281t && (drawable2 = this.f11278q) != null) {
                drawable2.setBounds(this.f11274m.getLeft(), this.f11274m.getTop(), this.f11274m.getRight(), this.f11274m.getBottom());
            }
        }
        boolean z7 = false;
        if (!this.f11280s ? !(this.f11277p != null || this.f11278q != null) : this.f11279r == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(c cVar) {
        View view = this.f11274m;
        if (view != null) {
            removeView(view);
        }
        this.f11274m = cVar;
    }

    public void setTransitioning(boolean z7) {
        this.f11273l = z7;
        setDescendantFocusability(z7 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f11277p;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
        Drawable drawable2 = this.f11278q;
        if (drawable2 != null) {
            drawable2.setVisible(z7, false);
        }
        Drawable drawable3 = this.f11279r;
        if (drawable3 != null) {
            drawable3.setVisible(z7, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f11277p && !this.f11280s) {
            return true;
        }
        if (drawable == this.f11278q && this.f11281t) {
            return true;
        }
        return (drawable == this.f11279r && this.f11280s) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i7) {
        if (i7 != 0) {
            return super.startActionModeForChild(view, callback, i7);
        }
        return null;
    }
}
