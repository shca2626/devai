package org.webrtc;

import android.graphics.Matrix;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class VideoFrame implements RefCounted {
    private final Buffer buffer;
    private final int rotation;
    private final long timestampNs;

    public interface Buffer extends RefCounted {
        @CalledByNative
        Buffer cropAndScale(int i7, int i8, int i9, int i10, int i11, int i12);

        @CalledByNative
        default int getBufferType() {
            return 0;
        }

        @CalledByNative
        int getHeight();

        @CalledByNative
        int getWidth();

        @Override // org.webrtc.RefCounted
        @CalledByNative
        void release();

        @Override // org.webrtc.RefCounted
        @CalledByNative
        void retain();

        @CalledByNative
        I420Buffer toI420();
    }

    public interface I420Buffer extends Buffer {
        @Override // org.webrtc.VideoFrame.Buffer
        default int getBufferType() {
            return 1;
        }

        @CalledByNative
        ByteBuffer getDataU();

        @CalledByNative
        ByteBuffer getDataV();

        @CalledByNative
        ByteBuffer getDataY();

        @CalledByNative
        int getStrideU();

        @CalledByNative
        int getStrideV();

        @CalledByNative
        int getStrideY();
    }

    public interface TextureBuffer extends Buffer {

        public enum Type {
            OES(36197),
            RGB(3553);

            private final int glTarget;

            Type(int i7) {
                this.glTarget = i7;
            }

            public int getGlTarget() {
                return this.glTarget;
            }
        }

        default TextureBuffer applyTransformMatrix(Matrix matrix, int i7, int i8) {
            throw new UnsupportedOperationException("Not implemented");
        }

        int getTextureId();

        Matrix getTransformMatrix();

        Type getType();

        default int getUnscaledHeight() {
            return getHeight();
        }

        default int getUnscaledWidth() {
            return getWidth();
        }
    }

    @CalledByNative
    public VideoFrame(Buffer buffer, int i7, long j7) {
        if (buffer == null) {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
        if (i7 % 90 != 0) {
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        this.buffer = buffer;
        this.rotation = i7;
        this.timestampNs = j7;
    }

    @CalledByNative
    public Buffer getBuffer() {
        return this.buffer;
    }

    public int getRotatedHeight() {
        return this.rotation % 180 == 0 ? this.buffer.getHeight() : this.buffer.getWidth();
    }

    public int getRotatedWidth() {
        return this.rotation % 180 == 0 ? this.buffer.getWidth() : this.buffer.getHeight();
    }

    @CalledByNative
    public int getRotation() {
        return this.rotation;
    }

    @CalledByNative
    public long getTimestampNs() {
        return this.timestampNs;
    }

    @Override // org.webrtc.RefCounted
    @CalledByNative
    public void release() {
        this.buffer.release();
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        this.buffer.retain();
    }
}
