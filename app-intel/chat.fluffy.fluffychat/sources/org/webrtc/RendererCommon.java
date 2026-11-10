package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;

/* loaded from: classes3.dex */
public class RendererCommon {
    private static final float BALANCED_VISIBLE_FRACTION = 0.5625f;

    public interface GlDrawer {
        void drawOes(int i7, float[] fArr, int i8, int i9, int i10, int i11, int i12, int i13);

        void drawRgb(int i7, float[] fArr, int i8, int i9, int i10, int i11, int i12, int i13);

        void drawYuv(int[] iArr, float[] fArr, int i7, int i8, int i9, int i10, int i11, int i12);

        void release();
    }

    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i7, int i8, int i9);
    }

    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    public static class VideoLayoutMeasure {
        private float visibleFractionMatchOrientation;
        private float visibleFractionMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
        }

        public Point measure(int i7, int i8, int i9, int i10) {
            int defaultSize = View.getDefaultSize(Integer.MAX_VALUE, i7);
            int defaultSize2 = View.getDefaultSize(Integer.MAX_VALUE, i8);
            if (i9 == 0 || i10 == 0 || defaultSize == 0 || defaultSize2 == 0) {
                return new Point(defaultSize, defaultSize2);
            }
            float f7 = i9 / i10;
            Point displaySize = RendererCommon.getDisplaySize(((f7 > 1.0f ? 1 : (f7 == 1.0f ? 0 : -1)) > 0) == (((float) defaultSize) / ((float) defaultSize2) > 1.0f) ? this.visibleFractionMatchOrientation : this.visibleFractionMismatchOrientation, f7, defaultSize, defaultSize2);
            if (View.MeasureSpec.getMode(i7) == 1073741824) {
                displaySize.x = defaultSize;
            }
            if (View.MeasureSpec.getMode(i8) == 1073741824) {
                displaySize.y = defaultSize2;
            }
            return displaySize;
        }

        public void setScalingType(ScalingType scalingType) {
            setScalingType(scalingType, scalingType);
        }

        public void setVisibleFraction(float f7, float f8) {
            this.visibleFractionMatchOrientation = f7;
            this.visibleFractionMismatchOrientation = f8;
        }

        public void setScalingType(ScalingType scalingType, ScalingType scalingType2) {
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType2);
        }
    }

    private static void adjustOrigin(float[] fArr) {
        float f7 = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[12] = f7;
        float f8 = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[13] = f8;
        fArr[12] = f7 + 0.5f;
        fArr[13] = f8 + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new float[]{fArr[0], fArr[3], 0.0f, fArr[6], fArr[1], fArr[4], 0.0f, fArr[7], 0.0f, 0.0f, 1.0f, 0.0f, fArr[2], fArr[5], 0.0f, fArr[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[4], fArr[12], fArr[1], fArr[5], fArr[13], fArr[3], fArr[7], fArr[15]};
        Matrix matrix = new Matrix();
        matrix.setValues(fArr2);
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        int iOrdinal = scalingType.ordinal();
        if (iOrdinal == 0) {
            return 1.0f;
        }
        if (iOrdinal == 1) {
            return 0.0f;
        }
        if (iOrdinal == 2) {
            return BALANCED_VISIBLE_FRACTION;
        }
        throw new IllegalArgumentException();
    }

    public static Point getDisplaySize(ScalingType scalingType, float f7, int i7, int i8) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f7, i7, i8);
    }

    public static float[] getLayoutMatrix(boolean z7, float f7, float f8) {
        float f9;
        float f10;
        if (f8 > f7) {
            f10 = f7 / f8;
            f9 = 1.0f;
        } else {
            f9 = f8 / f7;
            f10 = 1.0f;
        }
        if (z7) {
            f9 *= -1.0f;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, f9, f10, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }

    public static Point getDisplaySize(float f7, float f8, int i7, int i8) {
        return (f7 == 0.0f || f8 == 0.0f) ? new Point(i7, i8) : new Point(Math.min(i7, Math.round((i8 / f7) * f8)), Math.min(i8, Math.round((i7 / f7) / f8)));
    }
}
