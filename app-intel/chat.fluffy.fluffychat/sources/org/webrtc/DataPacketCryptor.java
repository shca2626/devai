package org.webrtc;

/* loaded from: classes3.dex */
public class DataPacketCryptor {
    private long nativePtr;

    public static class EncryptedPacket {
        public final byte[] iv;
        public final int keyIndex;
        public final byte[] payload;

        @CalledByNative("EncryptedPacket")
        public EncryptedPacket(byte[] bArr, byte[] bArr2, int i7) {
            this.payload = bArr;
            this.iv = bArr2;
            this.keyIndex = i7;
        }
    }

    @CalledByNative
    public DataPacketCryptor(long j7) {
        this.nativePtr = j7;
    }

    private void checkDataPacketCryptorExists() {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("DataPacketCryptor has been disposed.");
        }
    }

    private static native byte[] nativeDecrypt(long j7, String str, int i7, byte[] bArr, byte[] bArr2);

    private static native EncryptedPacket nativeEncrypt(long j7, String str, int i7, byte[] bArr);

    public byte[] decrypt(String str, EncryptedPacket encryptedPacket) {
        checkDataPacketCryptorExists();
        return nativeDecrypt(this.nativePtr, str, encryptedPacket.keyIndex, encryptedPacket.payload, encryptedPacket.iv);
    }

    public void dispose() {
        checkDataPacketCryptorExists();
        JniCommon.nativeReleaseRef(this.nativePtr);
        this.nativePtr = 0L;
    }

    public EncryptedPacket encrypt(String str, int i7, byte[] bArr) {
        checkDataPacketCryptorExists();
        return nativeEncrypt(this.nativePtr, str, i7, bArr);
    }

    public long getNativeDataPacketCryptor() {
        return this.nativePtr;
    }
}
