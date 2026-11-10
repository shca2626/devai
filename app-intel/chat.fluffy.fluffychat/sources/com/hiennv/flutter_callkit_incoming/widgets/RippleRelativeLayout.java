package com.hiennv.flutter_callkit_incoming.widgets;

import M5.g;
import M5.m;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.hiennv.flutter_callkit_incoming.R;
import com.hiennv.flutter_callkit_incoming.Utils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class RippleRelativeLayout extends RelativeLayout {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_DURATION_TIME = 6000;
    private static final int DEFAULT_RIPPLE_COUNT = 5;
    private static final float DEFAULT_SCALE = 6.0f;
    private ArrayList<Animator> animatorList;
    private AnimatorSet animatorSet;
    private boolean isRippleAnimationRunning;
    private Paint paint;
    private int rippleAmount;
    private int rippleColor;
    private int rippleDelay;
    private int rippleDurationTime;
    private RelativeLayout.LayoutParams rippleParams;
    private float rippleRadius;
    private float rippleScale;
    private final ArrayList<RippleView> rippleViewList;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public final class RippleView extends View {
        public RippleView(Context context) {
            super(context);
            setVisibility(4);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            m.e(canvas, "canvas");
            float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
            Paint paint = RippleRelativeLayout.this.paint;
            m.b(paint);
            canvas.drawCircle(fMin, fMin, fMin, paint);
        }
    }

    public RippleRelativeLayout(Context context) {
        super(context);
        this.paint = new Paint();
        this.rippleViewList = new ArrayList<>();
    }

    @SuppressLint({"CustomViewStyleable"})
    private final void init(Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ripple_relativeLayout);
        m.d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.rippleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ripple_relativeLayout_ripple_color, getResources().getColor(R.color.ripple_main_color));
        this.rippleRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.ripple_relativeLayout_ripple_radius, Utils.Companion.dpToPx(30.0f));
        this.rippleDurationTime = typedArrayObtainStyledAttributes.getInt(R.styleable.ripple_relativeLayout_ripple_duration, DEFAULT_DURATION_TIME);
        this.rippleAmount = typedArrayObtainStyledAttributes.getInt(R.styleable.ripple_relativeLayout_ripple_amount, 5);
        this.rippleScale = typedArrayObtainStyledAttributes.getFloat(R.styleable.ripple_relativeLayout_ripple_scale, DEFAULT_SCALE);
        typedArrayObtainStyledAttributes.recycle();
        this.rippleDelay = this.rippleDurationTime / this.rippleAmount;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.rippleColor);
        float f7 = 2;
        float f8 = this.rippleRadius;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f7 * f8), (int) (f7 * f8));
        this.rippleParams = layoutParams;
        m.b(layoutParams);
        layoutParams.addRule(13, -1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        m.b(animatorSet);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animatorList = new ArrayList<>();
        int i7 = this.rippleAmount;
        for (int i8 = 0; i8 < i7; i8++) {
            RippleView rippleView = new RippleView(getContext());
            addView(rippleView, this.rippleParams);
            this.rippleViewList.add(rippleView);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rippleView, "ScaleX", 1.0f, this.rippleScale);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setRepeatMode(1);
            objectAnimatorOfFloat.setStartDelay(this.rippleDelay * i8);
            objectAnimatorOfFloat.setDuration(this.rippleDurationTime);
            ArrayList<Animator> arrayList = this.animatorList;
            m.b(arrayList);
            arrayList.add(objectAnimatorOfFloat);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(rippleView, "ScaleY", 1.0f, this.rippleScale);
            objectAnimatorOfFloat2.setRepeatCount(-1);
            objectAnimatorOfFloat2.setRepeatMode(1);
            objectAnimatorOfFloat2.setStartDelay(this.rippleDelay * i8);
            objectAnimatorOfFloat2.setDuration(this.rippleDurationTime);
            ArrayList<Animator> arrayList2 = this.animatorList;
            m.b(arrayList2);
            arrayList2.add(objectAnimatorOfFloat2);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(rippleView, "Alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat3.setRepeatCount(-1);
            objectAnimatorOfFloat3.setRepeatMode(1);
            objectAnimatorOfFloat3.setStartDelay(this.rippleDelay * i8);
            objectAnimatorOfFloat3.setDuration(this.rippleDurationTime);
            ArrayList<Animator> arrayList3 = this.animatorList;
            m.b(arrayList3);
            arrayList3.add(objectAnimatorOfFloat3);
        }
        AnimatorSet animatorSet2 = this.animatorSet;
        m.b(animatorSet2);
        animatorSet2.playTogether(this.animatorList);
        startRippleAnimation();
    }

    public final boolean isRippleAnimationRunning() {
        return this.isRippleAnimationRunning;
    }

    public final void startRippleAnimation() {
        if (this.isRippleAnimationRunning) {
            return;
        }
        Iterator<RippleView> it = this.rippleViewList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            RippleView next = it.next();
            m.d(next, "next(...)");
            next.setVisibility(0);
        }
        AnimatorSet animatorSet = this.animatorSet;
        m.b(animatorSet);
        animatorSet.start();
        this.isRippleAnimationRunning = true;
    }

    public final void stopRippleAnimation() {
        if (this.isRippleAnimationRunning) {
            AnimatorSet animatorSet = this.animatorSet;
            m.b(animatorSet);
            animatorSet.end();
            this.isRippleAnimationRunning = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RippleRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.e(context, "context");
        this.paint = new Paint();
        this.rippleViewList = new ArrayList<>();
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RippleRelativeLayout(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        m.e(context, "context");
        this.paint = new Paint();
        this.rippleViewList = new ArrayList<>();
        init(context, attributeSet);
    }
}
