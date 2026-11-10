package org.webrtc;

/* loaded from: classes3.dex */
public class FrameCryptorKeyProvider {
    private long nativeKeyProvider;

    @CalledByNative
    public FrameCryptorKeyProvider(long j7) {
        this.nativeKeyProvider = j7;
    }

    private void checkKeyProviderExists() {
        if (this.nativeKeyProvider == 0) {
            throw new IllegalStateException("FrameCryptorKeyProvider has been disposed.");
        }
    }

    private static native byte[] nativeExportKey(long j7, String str, int i7);

    private static native byte[] nativeExportSharedKey(long j7, int i7);

    private static native byte[] nativeRatchetKey(long j7, String str, int i7);

    private static native byte[] nativeRatchetSharedKey(long j7, int i7);

    private static native boolean nativeSetKey(long j7, String str, int i7, byte[] bArr);

    private static native boolean nativeSetSharedKey(long j7, int i7, byte[] bArr);

    private static native void nativeSetSifTrailer(long j7, byte[] bArr);

    public void dispose() {
        checkKeyProviderExists();
        JniCommon.nativeReleaseRef(this.nativeKeyProvider);
        this.nativeKeyProvider = 0L;
    }

    public byte[] exportKey(String str, int i7) {
        checkKeyProviderExists();
        return nativeExportKey(this.nativeKeyProvider, str, i7);
    }

    public byte[] exportSharedKey(int i7) {
        checkKeyProviderExists();
        return nativeExportSharedKey(this.nativeKeyProvider, i7);
    }

    public long getNativeKeyProvider() {
        return this.nativeKeyProvider;
    }

    public byte[] ratchetKey(String str, int i7) {
        checkKeyProviderExists();
        return nativeRatchetKey(this.nativeKeyProvider, str, i7);
    }

    public byte[] ratchetSharedKey(int i7) {
        checkKeyProviderExists();
        return nativeRatchetSharedKey(this.nativeKeyProvider, i7);
    }

    public boolean setKey(String str, int i7, byte[] bArr) {
        checkKeyProviderExists();
        return nativeSetKey(this.nativeKeyProvider, str, i7, bArr);
    }

    public boolean setSharedKey(int i7, byte[] bArr) {
        checkKeyProviderExists();
        return nativeSetSharedKey(this.nativeKeyProvider, i7, bArr);
    }

    public void setSifTrailer(byte[] bArr) {
        checkKeyProviderExists();
        nativeSetSifTrailer(this.nativeKeyProvider, bArr);
    }
}
