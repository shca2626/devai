package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoDecoder {

    public interface Callback {
        void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2);
    }

    public static class DecodeInfo {
        public final boolean isMissingFrames;
        public final long renderTimeMs;

        public DecodeInfo(boolean z7, long j7) {
            this.isMissingFrames = z7;
            this.renderTimeMs = j7;
        }
    }

    public static class Settings {
        public final int height;
        public final int numberOfCores;
        public final int width;

        @CalledByNative
        public Settings(int i7, int i8, int i9) {
            this.numberOfCores = i7;
            this.width = i8;
            this.height = i9;
        }
    }

    @CalledByNative
    default long createNative(long j7) {
        return 0L;
    }

    @CalledByNative
    VideoCodecStatus decode(EncodedImage encodedImage, DecodeInfo decodeInfo);

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    VideoCodecStatus initDecode(Settings settings, Callback callback);

    @CalledByNative
    VideoCodecStatus release();
}
