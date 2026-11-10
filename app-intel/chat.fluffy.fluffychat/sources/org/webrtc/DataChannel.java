package org.webrtc;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class DataChannel {
    private long nativeDataChannel;
    private long nativeObserver;

    public static class Buffer {
        public final boolean binary;
        public final ByteBuffer data;

        @CalledByNative
        public Buffer(ByteBuffer byteBuffer, boolean z7) {
            this.data = byteBuffer;
            this.binary = z7;
        }
    }

    public static class Init {
        public boolean negotiated;
        public boolean ordered = true;
        public int maxRetransmitTimeMs = -1;
        public int maxRetransmits = -1;
        public String protocol = "";
        public int id = -1;

        @CalledByNative
        public int getId() {
            return this.id;
        }

        @CalledByNative
        public int getMaxRetransmitTimeMs() {
            return this.maxRetransmitTimeMs;
        }

        @CalledByNative
        public int getMaxRetransmits() {
            return this.maxRetransmits;
        }

        @CalledByNative
        public boolean getNegotiated() {
            return this.negotiated;
        }

        @CalledByNative
        public boolean getOrdered() {
            return this.ordered;
        }

        @CalledByNative
        public String getProtocol() {
            return this.protocol;
        }
    }

    public interface Observer {
        @CalledByNative
        void onBufferedAmountChange(long j7);

        @CalledByNative
        void onMessage(Buffer buffer);

        @CalledByNative
        void onStateChange();
    }

    public enum State {
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        @CalledByNative
        public static State fromNativeIndex(int i7) {
            return values()[i7];
        }
    }

    @CalledByNative
    public DataChannel(long j7) {
        this.nativeDataChannel = j7;
    }

    private void checkDataChannelExists() {
        if (this.nativeDataChannel == 0) {
            throw new IllegalStateException("DataChannel has been disposed.");
        }
    }

    private native long nativeBufferedAmount();

    private native void nativeClose();

    private native int nativeId();

    private native String nativeLabel();

    private native long nativeRegisterObserver(Observer observer);

    private native boolean nativeSend(byte[] bArr, boolean z7);

    private native State nativeState();

    private native void nativeUnregisterObserver(long j7);

    public long bufferedAmount() {
        checkDataChannelExists();
        return nativeBufferedAmount();
    }

    public void close() {
        checkDataChannelExists();
        nativeClose();
    }

    public void dispose() {
        checkDataChannelExists();
        JniCommon.nativeReleaseRef(this.nativeDataChannel);
        this.nativeDataChannel = 0L;
    }

    @CalledByNative
    public long getNativeDataChannel() {
        return this.nativeDataChannel;
    }

    public int id() {
        checkDataChannelExists();
        return nativeId();
    }

    public String label() {
        checkDataChannelExists();
        return nativeLabel();
    }

    public void registerObserver(Observer observer) {
        checkDataChannelExists();
        long j7 = this.nativeObserver;
        if (j7 != 0) {
            nativeUnregisterObserver(j7);
        }
        this.nativeObserver = nativeRegisterObserver(observer);
    }

    public boolean send(Buffer buffer) {
        checkDataChannelExists();
        byte[] bArr = new byte[buffer.data.remaining()];
        buffer.data.get(bArr);
        return nativeSend(bArr, buffer.binary);
    }

    public State state() {
        checkDataChannelExists();
        return nativeState();
    }

    public void unregisterObserver() {
        checkDataChannelExists();
        nativeUnregisterObserver(this.nativeObserver);
        this.nativeObserver = 0L;
    }
}
