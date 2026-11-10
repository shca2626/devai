package org.webrtc;

import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoSource;

/* loaded from: classes3.dex */
class NativeAndroidVideoTrackSource {
    private final long nativeAndroidVideoTrackSource;

    public NativeAndroidVideoTrackSource(long j7) {
        this.nativeAndroidVideoTrackSource = j7;
    }

    @CalledByNative
    public static VideoProcessor.FrameAdaptationParameters createFrameAdaptationParameters(int i7, int i8, int i9, int i10, int i11, int i12, long j7, boolean z7) {
        return new VideoProcessor.FrameAdaptationParameters(i7, i8, i9, i10, i11, i12, j7, z7);
    }

    private static native VideoProcessor.FrameAdaptationParameters nativeAdaptFrame(long j7, int i7, int i8, int i9, long j8);

    private static native void nativeAdaptOutputFormat(long j7, int i7, int i8, Integer num, int i9, int i10, Integer num2, Integer num3);

    private static native void nativeOnFrameCaptured(long j7, int i7, long j8, VideoFrame.Buffer buffer);

    private static native void nativeSetIsScreencast(long j7, boolean z7);

    private static native void nativeSetState(long j7, boolean z7);

    public VideoProcessor.FrameAdaptationParameters adaptFrame(VideoFrame videoFrame) {
        return nativeAdaptFrame(this.nativeAndroidVideoTrackSource, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs());
    }

    public void adaptOutputFormat(VideoSource.AspectRatio aspectRatio, Integer num, VideoSource.AspectRatio aspectRatio2, Integer num2, Integer num3) {
        nativeAdaptOutputFormat(this.nativeAndroidVideoTrackSource, aspectRatio.width, aspectRatio.height, num, aspectRatio2.width, aspectRatio2.height, num2, num3);
    }

    public void onFrameCaptured(VideoFrame videoFrame) {
        nativeOnFrameCaptured(this.nativeAndroidVideoTrackSource, videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getBuffer());
    }

    public void setIsScreencast(boolean z7) {
        nativeSetIsScreencast(this.nativeAndroidVideoTrackSource, z7);
    }

    public void setState(boolean z7) {
        nativeSetState(this.nativeAndroidVideoTrackSource, z7);
    }
}
