package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoProcessor extends CapturerObserver {

    public static class FrameAdaptationParameters {
        public final int cropHeight;
        public final int cropWidth;
        public final int cropX;
        public final int cropY;
        public final boolean drop;
        public final int scaleHeight;
        public final int scaleWidth;
        public final long timestampNs;

        public FrameAdaptationParameters(int i7, int i8, int i9, int i10, int i11, int i12, long j7, boolean z7) {
            this.cropX = i7;
            this.cropY = i8;
            this.cropWidth = i9;
            this.cropHeight = i10;
            this.scaleWidth = i11;
            this.scaleHeight = i12;
            this.timestampNs = j7;
            this.drop = z7;
        }
    }

    static VideoFrame applyFrameAdaptationParameters(VideoFrame videoFrame, FrameAdaptationParameters frameAdaptationParameters) {
        if (frameAdaptationParameters.drop) {
            return null;
        }
        return new VideoFrame(videoFrame.getBuffer().cropAndScale(frameAdaptationParameters.cropX, frameAdaptationParameters.cropY, frameAdaptationParameters.cropWidth, frameAdaptationParameters.cropHeight, frameAdaptationParameters.scaleWidth, frameAdaptationParameters.scaleHeight), videoFrame.getRotation(), frameAdaptationParameters.timestampNs);
    }

    default void onFrameCaptured(VideoFrame videoFrame, FrameAdaptationParameters frameAdaptationParameters) {
        VideoFrame videoFrameApplyFrameAdaptationParameters = applyFrameAdaptationParameters(videoFrame, frameAdaptationParameters);
        if (videoFrameApplyFrameAdaptationParameters != null) {
            onFrameCaptured(videoFrameApplyFrameAdaptationParameters);
            videoFrameApplyFrameAdaptationParameters.release();
        }
    }

    void setSink(VideoSink videoSink);
}
