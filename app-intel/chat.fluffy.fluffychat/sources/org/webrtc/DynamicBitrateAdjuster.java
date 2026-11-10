package org.webrtc;

/* loaded from: classes3.dex */
class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    private static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    private static final int BITRATE_ADJUSTMENT_STEPS = 20;
    private static final double BITS_PER_BYTE = 8.0d;
    private int bitrateAdjustmentScaleExp;
    private double deviationBytes;
    private double timeSinceLastAdjustmentMs;

    private double getBitrateAdjustmentScale() {
        return Math.pow(BITRATE_ADJUSTMENT_MAX_SCALE, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i7) {
        double d7 = this.targetFramerateFps;
        if (d7 == 0.0d) {
            return;
        }
        int i8 = this.targetBitrateBps;
        double d8 = this.deviationBytes + (i7 - ((i8 / BITS_PER_BYTE) / d7));
        this.deviationBytes = d8;
        this.timeSinceLastAdjustmentMs += 1000.0d / d7;
        double d9 = i8 / BITS_PER_BYTE;
        double d10 = BITRATE_ADJUSTMENT_SEC * d9;
        double dMin = Math.min(d8, d10);
        this.deviationBytes = dMin;
        double dMax = Math.max(dMin, -d10);
        this.deviationBytes = dMax;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (dMax > d9) {
            int i9 = this.bitrateAdjustmentScaleExp - ((int) ((dMax / d9) + 0.5d));
            this.bitrateAdjustmentScaleExp = i9;
            this.bitrateAdjustmentScaleExp = Math.max(i9, -20);
            this.deviationBytes = d9;
        } else {
            double d11 = -d9;
            if (dMax < d11) {
                int i10 = this.bitrateAdjustmentScaleExp + ((int) (((-dMax) / d9) + 0.5d));
                this.bitrateAdjustmentScaleExp = i10;
                this.bitrateAdjustmentScaleExp = Math.min(i10, BITRATE_ADJUSTMENT_STEPS);
                this.deviationBytes = d11;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i7, double d7) {
        int i8 = this.targetBitrateBps;
        if (i8 > 0 && i7 < i8) {
            this.deviationBytes = (this.deviationBytes * i7) / i8;
        }
        super.setTargets(i7, d7);
    }
}
