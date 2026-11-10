package org.webrtc;

import org.webrtc.EncodedImage;

/* loaded from: classes3.dex */
public interface VideoEncoder {

    public static class BitrateAllocation {
        public final int[][] bitratesBbs;

        @CalledByNative
        public BitrateAllocation(int[][] iArr) {
            this.bitratesBbs = iArr;
        }

        public int getSum() {
            int i7 = 0;
            for (int[] iArr : this.bitratesBbs) {
                for (int i8 : iArr) {
                    i7 += i8;
                }
            }
            return i7;
        }
    }

    public interface Callback {
        void onEncodedFrame(EncodedImage encodedImage, CodecSpecificInfo codecSpecificInfo);
    }

    public static class Capabilities {
        public final boolean lossNotification;

        @CalledByNative
        public Capabilities(boolean z7) {
            this.lossNotification = z7;
        }
    }

    public static class CodecSpecificInfo {
    }

    public static class CodecSpecificInfoAV1 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoH264 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoH265 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoVP8 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoVP9 extends CodecSpecificInfo {
    }

    public static class EncodeInfo {
        public final EncodedImage.FrameType[] frameTypes;

        @CalledByNative
        public EncodeInfo(EncodedImage.FrameType[] frameTypeArr) {
            this.frameTypes = frameTypeArr;
        }
    }

    public static class EncoderInfo {
        public final boolean applyAlignmentToAllSimulcastLayers;
        public final int requestedResolutionAlignment;

        public EncoderInfo(int i7, boolean z7) {
            this.requestedResolutionAlignment = i7;
            this.applyAlignmentToAllSimulcastLayers = z7;
        }

        @CalledByNative
        public boolean getApplyAlignmentToAllSimulcastLayers() {
            return this.applyAlignmentToAllSimulcastLayers;
        }

        @CalledByNative
        public int getRequestedResolutionAlignment() {
            return this.requestedResolutionAlignment;
        }
    }

    public static class RateControlParameters {
        public final BitrateAllocation bitrate;
        public final double framerateFps;

        @CalledByNative
        public RateControlParameters(BitrateAllocation bitrateAllocation, double d7) {
            this.bitrate = bitrateAllocation;
            this.framerateFps = d7;
        }
    }

    public static class ResolutionBitrateLimits {
        public final int frameSizePixels;
        public final int maxBitrateBps;
        public final int minBitrateBps;
        public final int minStartBitrateBps;

        public ResolutionBitrateLimits(int i7, int i8, int i9, int i10) {
            this.frameSizePixels = i7;
            this.minStartBitrateBps = i8;
            this.minBitrateBps = i9;
            this.maxBitrateBps = i10;
        }

        @CalledByNative
        public int getFrameSizePixels() {
            return this.frameSizePixels;
        }

        @CalledByNative
        public int getMaxBitrateBps() {
            return this.maxBitrateBps;
        }

        @CalledByNative
        public int getMinBitrateBps() {
            return this.minBitrateBps;
        }

        @CalledByNative
        public int getMinStartBitrateBps() {
            return this.minStartBitrateBps;
        }
    }

    public static class Settings {
        public final boolean automaticResizeOn;
        public final Capabilities capabilities;
        public final int height;
        public final int maxFramerate;
        public final int numberOfCores;
        public final int numberOfSimulcastStreams;
        public final int startBitrate;
        public final int width;

        @Deprecated
        public Settings(int i7, int i8, int i9, int i10, int i11, int i12, boolean z7) {
            this(i7, i8, i9, i10, i11, i12, z7, new Capabilities(false));
        }

        @CalledByNative
        public Settings(int i7, int i8, int i9, int i10, int i11, int i12, boolean z7, Capabilities capabilities) {
            this.numberOfCores = i7;
            this.width = i8;
            this.height = i9;
            this.startBitrate = i10;
            this.maxFramerate = i11;
            this.numberOfSimulcastStreams = i12;
            this.automaticResizeOn = z7;
            this.capabilities = capabilities;
        }
    }

    @CalledByNative
    default long createNative(long j7) {
        return 0L;
    }

    @CalledByNative
    VideoCodecStatus encode(VideoFrame videoFrame, EncodeInfo encodeInfo);

    @CalledByNative
    default EncoderInfo getEncoderInfo() {
        return new EncoderInfo(1, false);
    }

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    default ResolutionBitrateLimits[] getResolutionBitrateLimits() {
        return new ResolutionBitrateLimits[0];
    }

    @CalledByNative
    ScalingSettings getScalingSettings();

    @CalledByNative
    VideoCodecStatus initEncode(Settings settings, Callback callback);

    @CalledByNative
    default boolean isHardwareEncoder() {
        return true;
    }

    @CalledByNative
    VideoCodecStatus release();

    VideoCodecStatus setRateAllocation(BitrateAllocation bitrateAllocation, int i7);

    @CalledByNative
    default VideoCodecStatus setRates(RateControlParameters rateControlParameters) {
        return setRateAllocation(rateControlParameters.bitrate, (int) Math.ceil(rateControlParameters.framerateFps));
    }

    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();
        public final Integer high;
        public final Integer low;
        public final boolean on;

        public ScalingSettings(int i7, int i8) {
            this.on = true;
            this.low = Integer.valueOf(i7);
            this.high = Integer.valueOf(i8);
        }

        public String toString() {
            if (!this.on) {
                return "OFF";
            }
            return "[ " + this.low + ", " + this.high + " ]";
        }

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z7) {
            this.on = z7;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z7, int i7, int i8) {
            this.on = z7;
            this.low = Integer.valueOf(i7);
            this.high = Integer.valueOf(i8);
        }
    }
}
