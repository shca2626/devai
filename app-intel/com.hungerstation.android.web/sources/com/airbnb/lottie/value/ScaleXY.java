package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f12, float f13) {
        this.scaleX = f12;
        this.scaleY = f13;
    }

    public boolean equals(float f12, float f13) {
        return this.scaleX == f12 && this.scaleY == f13;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f12, float f13) {
        this.scaleX = f12;
        this.scaleY = f13;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
