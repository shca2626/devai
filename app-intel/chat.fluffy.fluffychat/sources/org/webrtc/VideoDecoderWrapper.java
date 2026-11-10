package org.webrtc;

import org.webrtc.VideoDecoder;

/* loaded from: classes3.dex */
class VideoDecoderWrapper {
    @CalledByNative
    public static VideoDecoder.Callback createDecoderCallback(final long j7) {
        return new VideoDecoder.Callback() { // from class: org.webrtc.g0
            @Override // org.webrtc.VideoDecoder.Callback
            public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
                VideoDecoderWrapper.nativeOnDecodedFrame(j7, videoFrame, num, num2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnDecodedFrame(long j7, VideoFrame videoFrame, Integer num, Integer num2);
}
