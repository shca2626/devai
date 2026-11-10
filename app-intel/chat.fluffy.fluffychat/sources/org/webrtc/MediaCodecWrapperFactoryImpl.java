package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {

    public static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        private final MediaCodec mediaCodec;

        public MediaCodecWrapperImpl(MediaCodec mediaCodec) {
            this.mediaCodec = mediaCodec;
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i7) {
            this.mediaCodec.configure(mediaFormat, surface, mediaCrypto, i7);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public Surface createInputSurface() {
            return this.mediaCodec.createInputSurface();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public int dequeueInputBuffer(long j7) {
            return this.mediaCodec.dequeueInputBuffer(j7);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j7) {
            return this.mediaCodec.dequeueOutputBuffer(bufferInfo, j7);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void flush() {
            this.mediaCodec.flush();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public MediaCodecInfo getCodecInfo() {
            return this.mediaCodec.getCodecInfo();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public ByteBuffer getInputBuffer(int i7) {
            return this.mediaCodec.getInputBuffer(i7);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public MediaFormat getInputFormat() {
            return this.mediaCodec.getInputFormat();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public ByteBuffer getOutputBuffer(int i7) {
            return this.mediaCodec.getOutputBuffer(i7);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public MediaFormat getOutputFormat() {
            return this.mediaCodec.getOutputFormat();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void queueInputBuffer(int i7, int i8, int i9, long j7, int i10) throws MediaCodec.CryptoException {
            this.mediaCodec.queueInputBuffer(i7, i8, i9, j7, i10);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void release() {
            this.mediaCodec.release();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void releaseOutputBuffer(int i7, boolean z7) {
            this.mediaCodec.releaseOutputBuffer(i7, z7);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void setParameters(Bundle bundle) {
            this.mediaCodec.setParameters(bundle);
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void start() {
            this.mediaCodec.start();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public void stop() {
            this.mediaCodec.stop();
        }

        @Override // org.webrtc.MediaCodecWrapper
        public MediaFormat getOutputFormat(int i7) {
            return this.mediaCodec.getOutputFormat(i7);
        }
    }

    @Override // org.webrtc.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String str) {
        return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(str));
    }
}
