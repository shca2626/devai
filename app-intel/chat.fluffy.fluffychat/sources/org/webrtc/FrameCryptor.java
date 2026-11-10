package org.webrtc;

/* loaded from: classes3.dex */
public class FrameCryptor {
    private long nativeFrameCryptor;
    private long observerPtr = 0;

    public enum FrameCryptionState {
        NEW,
        OK,
        ENCRYPTIONFAILED,
        DECRYPTIONFAILED,
        MISSINGKEY,
        KEYRATCHETED,
        INTERNALERROR;

        @CalledByNative("FrameCryptionState")
        public static FrameCryptionState fromNativeIndex(int i7) {
            return values()[i7];
        }
    }

    public interface Observer {
        @CalledByNative("Observer")
        void onFrameCryptionStateChanged(String str, FrameCryptionState frameCryptionState);
    }

    @CalledByNative
    public FrameCryptor(long j7) {
        this.nativeFrameCryptor = j7;
    }

    private void checkFrameCryptorExists() {
        if (this.nativeFrameCryptor == 0) {
            throw new IllegalStateException("FrameCryptor has been disposed.");
        }
    }

    private static native int nativeGetKeyIndex(long j7);

    private static native boolean nativeIsEnabled(long j7);

    private static native void nativeSetEnabled(long j7, boolean z7);

    private static native void nativeSetKeyIndex(long j7, int i7);

    private static native long nativeSetObserver(long j7, Observer observer);

    private static native void nativeUnSetObserver(long j7);

    public void dispose() {
        checkFrameCryptorExists();
        nativeUnSetObserver(this.nativeFrameCryptor);
        JniCommon.nativeReleaseRef(this.nativeFrameCryptor);
        this.nativeFrameCryptor = 0L;
        long j7 = this.observerPtr;
        if (j7 != 0) {
            JniCommon.nativeReleaseRef(j7);
            this.observerPtr = 0L;
        }
    }

    public int getKeyIndex() {
        checkFrameCryptorExists();
        return nativeGetKeyIndex(this.nativeFrameCryptor);
    }

    public long getNativeFrameCryptor() {
        return this.nativeFrameCryptor;
    }

    public boolean isEnabled() {
        checkFrameCryptorExists();
        return nativeIsEnabled(this.nativeFrameCryptor);
    }

    public void setEnabled(boolean z7) {
        checkFrameCryptorExists();
        nativeSetEnabled(this.nativeFrameCryptor, z7);
    }

    public void setKeyIndex(int i7) {
        checkFrameCryptorExists();
        nativeSetKeyIndex(this.nativeFrameCryptor, i7);
    }

    public void setObserver(Observer observer) {
        checkFrameCryptorExists();
        nativeSetObserver(this.nativeFrameCryptor, observer);
        long j7 = this.observerPtr;
        if (j7 != 0) {
            JniCommon.nativeReleaseRef(j7);
            this.observerPtr = 0L;
        }
    }
}
