package com.airbnb.lottie.value;

/* loaded from: classes7.dex */
public class LottieFrameInfo<T> {
    private float endFrame;
    private T endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private T startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    public LottieFrameInfo<T> set(float f12, float f13, T t12, T t13, float f14, float f15, float f16) {
        this.startFrame = f12;
        this.endFrame = f13;
        this.startValue = t12;
        this.endValue = t13;
        this.linearKeyframeProgress = f14;
        this.interpolatedKeyframeProgress = f15;
        this.overallProgress = f16;
        return this;
    }
}
