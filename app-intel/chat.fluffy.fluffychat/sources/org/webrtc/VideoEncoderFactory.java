package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoEncoderFactory {

    public interface VideoEncoderSelector {
        @CalledByNative
        VideoCodecInfo onAvailableBitrate(int i7);

        @CalledByNative
        void onCurrentEncoder(VideoCodecInfo videoCodecInfo);

        @CalledByNative
        VideoCodecInfo onEncoderBroken();

        @CalledByNative
        default VideoCodecInfo onResolutionChange(int i7, int i8) {
            return null;
        }
    }

    @CalledByNative
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    default VideoEncoderSelector getEncoderSelector() {
        return null;
    }

    @CalledByNative
    default VideoCodecInfo[] getImplementations() {
        return getSupportedCodecs();
    }

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
