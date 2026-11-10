package com.airbnb.lottie.model;

import android.graphics.PointF;

/* loaded from: classes7.dex */
public class DocumentData {
    public float baselineShift;
    public PointF boxPosition;
    public PointF boxSize;
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f12, Justification justification, int i12, float f13, float f14, int i13, int i14, float f15, boolean z12, PointF pointF, PointF pointF2) {
        set(str, str2, f12, justification, i12, f13, f14, i13, i14, f15, z12, pointF, pointF2);
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size)) * 31) + this.justification.ordinal()) * 31) + this.tracking;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.lineHeight);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.color;
    }

    public void set(String str, String str2, float f12, Justification justification, int i12, float f13, float f14, int i13, int i14, float f15, boolean z12, PointF pointF, PointF pointF2) {
        this.text = str;
        this.fontName = str2;
        this.size = f12;
        this.justification = justification;
        this.tracking = i12;
        this.lineHeight = f13;
        this.baselineShift = f14;
        this.color = i13;
        this.strokeColor = i14;
        this.strokeWidth = f15;
        this.strokeOverFill = z12;
        this.boxPosition = pointF;
        this.boxSize = pointF2;
    }

    public DocumentData() {
    }
}
