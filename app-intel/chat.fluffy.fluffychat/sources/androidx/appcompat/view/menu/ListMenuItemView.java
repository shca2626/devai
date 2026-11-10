package androidx.appcompat.view.menu;

import Z.W;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import i.AbstractC1145a;
import q.d0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements j.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: A, reason: collision with root package name */
    public LayoutInflater f11091A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f11092B;

    /* renamed from: l, reason: collision with root package name */
    public g f11093l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f11094m;

    /* renamed from: n, reason: collision with root package name */
    public RadioButton f11095n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f11096o;

    /* renamed from: p, reason: collision with root package name */
    public CheckBox f11097p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f11098q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f11099r;

    /* renamed from: s, reason: collision with root package name */
    public ImageView f11100s;

    /* renamed from: t, reason: collision with root package name */
    public LinearLayout f11101t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f11102u;

    /* renamed from: v, reason: collision with root package name */
    public int f11103v;

    /* renamed from: w, reason: collision with root package name */
    public Context f11104w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11105x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f11106y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f11107z;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1145a.f16918A);
    }

    private LayoutInflater getInflater() {
        if (this.f11091A == null) {
            this.f11091A = LayoutInflater.from(getContext());
        }
        return this.f11091A;
    }

    private void setSubMenuArrowVisible(boolean z7) {
        ImageView imageView = this.f11099r;
        if (imageView != null) {
            imageView.setVisibility(z7 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f11100s;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11100s.getLayoutParams();
        rect.top += this.f11100s.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i7) {
        LinearLayout linearLayout = this.f11101t;
        if (linearLayout != null) {
            linearLayout.addView(view, i7);
        } else {
            addView(view, i7);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void d(g gVar, int i7) {
        this.f11093l = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    public final void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(i.g.f17072h, (ViewGroup) this, false);
        this.f11097p = checkBox;
        a(checkBox);
    }

    public final void f() {
        ImageView imageView = (ImageView) getInflater().inflate(i.g.f17073i, (ViewGroup) this, false);
        this.f11094m = imageView;
        b(imageView, 0);
    }

    public final void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(i.g.f17075k, (ViewGroup) this, false);
        this.f11095n = radioButton;
        a(radioButton);
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.f11093l;
    }

    public void h(boolean z7, char c7) {
        int i7 = (z7 && this.f11093l.A()) ? 0 : 8;
        if (i7 == 0) {
            this.f11098q.setText(this.f11093l.h());
        }
        if (this.f11098q.getVisibility() != i7) {
            this.f11098q.setVisibility(i7);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        W.p0(this, this.f11102u);
        TextView textView = (TextView) findViewById(i.f.f17035M);
        this.f11096o = textView;
        int i7 = this.f11103v;
        if (i7 != -1) {
            textView.setTextAppearance(this.f11104w, i7);
        }
        this.f11098q = (TextView) findViewById(i.f.f17028F);
        ImageView imageView = (ImageView) findViewById(i.f.f17031I);
        this.f11099r = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f11106y);
        }
        this.f11100s = (ImageView) findViewById(i.f.f17056r);
        this.f11101t = (LinearLayout) findViewById(i.f.f17050l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        if (this.f11094m != null && this.f11105x) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f11094m.getLayoutParams();
            int i9 = layoutParams.height;
            if (i9 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i9;
            }
        }
        super.onMeasure(i7, i8);
    }

    public void setCheckable(boolean z7) {
        CompoundButton compoundButton;
        View view;
        if (!z7 && this.f11095n == null && this.f11097p == null) {
            return;
        }
        if (this.f11093l.m()) {
            if (this.f11095n == null) {
                g();
            }
            compoundButton = this.f11095n;
            view = this.f11097p;
        } else {
            if (this.f11097p == null) {
                e();
            }
            compoundButton = this.f11097p;
            view = this.f11095n;
        }
        if (z7) {
            compoundButton.setChecked(this.f11093l.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f11097p;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f11095n;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z7) {
        CompoundButton compoundButton;
        if (this.f11093l.m()) {
            if (this.f11095n == null) {
                g();
            }
            compoundButton = this.f11095n;
        } else {
            if (this.f11097p == null) {
                e();
            }
            compoundButton = this.f11097p;
        }
        compoundButton.setChecked(z7);
    }

    public void setForceShowIcon(boolean z7) {
        this.f11092B = z7;
        this.f11105x = z7;
    }

    public void setGroupDividerEnabled(boolean z7) {
        ImageView imageView = this.f11100s;
        if (imageView != null) {
            imageView.setVisibility((this.f11107z || !z7) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z7 = this.f11093l.z() || this.f11092B;
        if (z7 || this.f11105x) {
            ImageView imageView = this.f11094m;
            if (imageView == null && drawable == null && !this.f11105x) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f11105x) {
                this.f11094m.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f11094m;
            if (!z7) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f11094m.getVisibility() != 0) {
                this.f11094m.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f11096o.getVisibility() != 8) {
                this.f11096o.setVisibility(8);
            }
        } else {
            this.f11096o.setText(charSequence);
            if (this.f11096o.getVisibility() != 0) {
                this.f11096o.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet);
        d0 d0VarV = d0.v(getContext(), attributeSet, i.j.f17199T1, i7, 0);
        this.f11102u = d0VarV.g(i.j.f17207V1);
        this.f11103v = d0VarV.n(i.j.f17203U1, -1);
        this.f11105x = d0VarV.a(i.j.f17211W1, false);
        this.f11104w = context;
        this.f11106y = d0VarV.g(i.j.f17215X1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, AbstractC1145a.f16953x, 0);
        this.f11107z = typedArrayObtainStyledAttributes.hasValue(0);
        d0VarV.w();
        typedArrayObtainStyledAttributes.recycle();
    }
}
